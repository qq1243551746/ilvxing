package com.hc.rest.service.user;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.hc.rest.entity.user.User;
import com.hc.rest.repository.user.UserRespository;
import com.hc.rest.utils.EirunyeException;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;
import com.hc.rest.utils.ip.GetMacAddress;
import com.hc.rest.utils.redis.TravelRedisConfig;
import com.hc.rest.utils.tools.md5.Md5PasswordEncoder;
import com.hc.rest.utils.tools.util.MD5Utils;
import com.hc.rest.utils.tools.util.StringBasicUtils;
import com.hc.rest.utils.yzm.AliyunMessageUtil;

@Service
public class UserService {

	@Autowired
	UserRespository userRepository;
	TravelRedisConfig redis = new TravelRedisConfig();

	/**
	 * 用户注册（将该方法返回的数据信息在redis中新增一条）
	 * 
	 * @param user
	 *            新增的用户信息
	 * @param mac
	 *            物理地址 ，以物理地址作为key,将返回的数据设为Value 添加到redis中
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Result<Boolean> userRegister(User user, HttpServletRequest request) throws Exception {
		RedisTemplate<String, Object> redisTemplate = redis.redisTemplate();

		// 获取mac值
		String mac = GetMacAddress.getMac(request);

		// 将用户修改为激活状态,0为未激活状态 1，为激活状态
		user.setActivated(1);

		// 通过随机生成的用户名,进行循环验证,确保用户名的唯一性
		String randomUser = StringBasicUtils.getRandomUpper(8);
		while (true) {
			User rUser = userRepository.findAllByUserName(randomUser);
			if (rUser == null) {
				break;
			} else {
				randomUser = StringBasicUtils.getRandomUpper(8);
			}
		}
		//保存用户名
		user.setUserName(randomUser);

		// 将用户密码进行加密
		String encrypt = MD5Utils.MD5Encrypt(user.getUserPassword());
		

		// 将用户注册的通过MD5加密之后在通过密钥再次进行unionid加密，双层加密
		UUID uuid = UUID.randomUUID();
		String codeKey = uuid.toString();
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String encodersalt = encoder.encodePassword(encrypt, codeKey);
		user.setUserPassword(encodersalt);

		// 密言存储到数据库中
		user.setUuid(codeKey);

		// 执行新增操作
		Integer result = userRepository.save(user.getActivated(), new Date(), user.getUserCode(), user.getUserName(), user.getUserPassword(), user.getUserType(), user.getUuid());
		if (result > 0) {

			// 将值存储到redis中
			redisTemplate.opsForValue().set("register:itrip_user:" + mac, user);
			redisTemplate.expire("register:itrip_user:" + mac, 1, TimeUnit.DAYS);

			return ResultUtil.getResult(ResultEnum.SUCCESS, true);
		} else {
			return ResultUtil.getResult(ResultEnum.SUCCESS, false);
		}
	}

	/**
	 * 验证手机号或邮箱是否注册过
	 * 
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Result<Boolean> verifyUserByCode(String userCode) throws Exception {

		User user = userRepository.findAllByUserCode(userCode);
		if (null == user) {
			return ResultUtil.getResult(ResultEnum.SUCCESS, true);
		} else {
			return ResultUtil.getResult(ResultEnum.SUCCESS, false);
		}
	}

	/**
	 * 
	 * @param type用户登录类型(1、自动登录
	 *            2、普通登录 3、就是验证码动态登录)
	 * @param user
	 *            用户登录信息
	 * @return
	 * @throws ClientException
	 */
	@SuppressWarnings("unchecked")
	public Result<Boolean> login(Integer type, User user, HttpServletRequest request) throws ClientException {
		RedisTemplate<String, Object> redisTemplate = redis.redisTemplate();
		// 获取mac值
		String mac = GetMacAddress.getMac(request);

		if (null != mac) {
			if (type == 1) {
				// 自动登录
				// 通过Mac值从redis缓存中获取用户信息
				User resUser = (User) redisTemplate.opsForValue().get("register:itrip_user:" + mac);

				if (null == resUser) {
					return ResultUtil.getResult(ResultEnum.SUCCESS, false);
				} else {
					// 通过redis中的用户信息为条件,到数据库中查询
					User dbUser = userRepository.findAllByUserCode(resUser.getUserCode());
					if (null == dbUser) {
						return ResultUtil.getResult(ResultEnum.SUCCESS, false);
					} else {
						// 匹配数据库中的密码和redis缓存中存储是否相等
						if (resUser.getUserPassword().equals(dbUser.getUserPassword())) {
							// 将数据库中的数据在重新赋值/存储
							redisTemplate.opsForValue().set("register:itrip_user:" + mac, dbUser);
							redisTemplate.expire("register:itrip_user:" + mac, 1, TimeUnit.DAYS);

							return ResultUtil.getResult(ResultEnum.SUCCESS, true);
						} else {
							return ResultUtil.getResult(ResultEnum.SUCCESS, false);
						}
					}
				}

			} else if (type == 2) {
				// 普通登录
				if (null == user) {
					// 用户不存在
					throw new EirunyeException(ResultEnum.USERNOTEXIST);
				} else {
					// 通过用户输入的手机号/邮箱进行查询
					User userResult = userRepository.findAllByUserCode(user.getUserCode());
					// 判断用户是否存在
					if (userResult != null) {
						// 将用户输入的密码进行md5加密
						String encrypt = MD5Utils.MD5Encrypt(user.getUserPassword());
						// 将查询出来的用户密码通过uuidd进行解密，在进行匹配
						Md5PasswordEncoder encoder = new Md5PasswordEncoder();
						boolean result=encoder.isPasswordValid(userResult.getUserPassword(), encrypt, userResult.getUuid());

						// 用户的密码与数据库的密码匹配成功
						if (result==true) {
							// 将值存储到redis中
							redisTemplate.opsForValue().set("register:itrip_user:" + mac, userResult);
							redisTemplate.expire("register:itrip_user:" + mac, 1, TimeUnit.DAYS);
							request.getSession().setAttribute("user", userResult);
							return ResultUtil.getResult(ResultEnum.SUCCESS, true);
						} else {
							throw new EirunyeException(ResultEnum.USERNOTEXIST);// 用户不存在
						}
					} else {
						throw new EirunyeException(ResultEnum.USERNOTEXIST);// 用户不存在
					}

				}

			} else if (type == 3) {
				// 动态验证登录
				if (null == user) {
					throw new EirunyeException(ResultEnum.USERNOTEXIST);// 用户不存在
				} else {
					if (null == user.getUserCode()) {
						throw new EirunyeException(ResultEnum.USERNOTEXIST);// 用户不存在
					} else {
						User userInfo = userRepository.findAllByUserCode(user.getUserCode());
						if (userInfo == null) {
							throw new EirunyeException(ResultEnum.USERNOTEXIST);// 用户不存在
						} else {
							// 将值存储到redis中
							redisTemplate.opsForValue().set("register:itrip_user:" + mac, userInfo);
							redisTemplate.expire("register:itrip_user:" + mac, 1, TimeUnit.DAYS);
							return ResultUtil.getResult(ResultEnum.SUCCESS, true);
						}

					}
				}
			}
		} else {
			throw new EirunyeException(ResultEnum.USERNOTEXIST);// 用户不存在
		}
		throw new EirunyeException(ResultEnum.USERNOTEXIST);// 用户不存在
	}

	/**
	 * 发送短信验证码
	 * 
	 * @return
	 * @throws ClientException
	 */
	@SuppressWarnings("unchecked")
	public Result<SendSmsResponse> sendMsg(String phone) throws ClientException {
		RedisTemplate<String, Object> redisTemplate = redis.redisTemplate();

		// 进行验证码的发送
		String random = AliyunMessageUtil.createRandomNum(6);
		//阿里云API接口
		SendSmsResponse response = AliyunMessageUtil.sendSms(phone, random);

		// 代表请求成功
		if (response.getCode() != null && response.getCode().equals("OK")) {
			// 将发送的验证码存到redis中
			redisTemplate.opsForValue().set("verCode:" + phone, random);
			redisTemplate.expire("verCode:" + phone, 1, TimeUnit.MINUTES);

			return ResultUtil.getResult(ResultEnum.SUCCESS, response);
		} else {
			return ResultUtil.error(-1, "验证码发送异常,请稍后进行尝试!");
		}
	}

	/**
	 * 核实验证码
	 * 
	 * @param phone电话号码
	 * @param code验证码
	 * @param type发送类型
	 *            1、注册 2、登录
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Boolean> verifyCode(String phone, String code) {
		RedisTemplate<String, Object> redisTemplate = redis.redisTemplate();
		String reCode = (String) redisTemplate.opsForValue().get("verCode:" + phone);
		if (null != reCode) {
			// 将redis缓存中的验证码删除
			boolean val = redisTemplate.delete("verCode:" + phone);
			if (val == true && reCode.equals(code)) {
				return ResultUtil.getResult(ResultEnum.SUCCESS, true);
			} else {
				return ResultUtil.getResult(ResultEnum.SUCCESS, false);
			}
		} else {
			return ResultUtil.getResult(ResultEnum.SUCCESS, false);
		}
	}

	/**
	 * 修改密码
	 * @param pwd 要修改的密码
	 * @param phone 用户的手机号 
	 * @param request ip地址
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Integer> updatePwdByUserCode(String pwd, String phone, HttpServletRequest request) {
		RedisTemplate<String, Object> redisTemplate = redis.redisTemplate();
		User dbUser = userRepository.findAllByUserCode(phone);
		if (dbUser == null) {
			return ResultUtil.getResult(ResultEnum.SUCCESS, 0);
		}
		// 将用户密码进行加密
		String encrypt = MD5Utils.MD5Encrypt(pwd);

		// 将用户注册的通过MD5加密之后在通过密钥再次进行unionid加密，双层加密
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String encodersalt = encoder.encodePassword(encrypt, dbUser.getUuid());
		pwd = encodersalt;

		Integer result = userRepository.updateByUserCode(pwd, phone);
		if (result > 0) {
			// 获取mac值
			String mac = GetMacAddress.getMac(request);
			dbUser.setUserPassword(pwd);
			// 将值存储到redis中
			redisTemplate.opsForValue().set("register:itrip_user:" + mac, dbUser);
			redisTemplate.expire("register:itrip_user:" + mac, 1, TimeUnit.DAYS);
			return ResultUtil.getResult(ResultEnum.SUCCESS, result);
		} else {
			return ResultUtil.getResult(ResultEnum.SUCCESS, result);
		}

	}

	/**
	 * 注销账号
	 * 
	 * @param userName
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<Boolean> cancellation(String userName, HttpServletRequest request) {
		RedisTemplate<String, Object> redisTemplate = redis.redisTemplate();
		// 获取mac值
		String mac = GetMacAddress.getMac(request);
		// 通过mac值获取用户信息
		User user = (User) redisTemplate.opsForValue().get("register:itrip_user:" + mac);
		if (user != null && user.getUserName().equals(userName)) {
			// 将redis中的数据进行注销
			boolean res = redisTemplate.delete("register:itrip_user:" + mac);
			if (res == true) {
				return ResultUtil.getResult(ResultEnum.SUCCESS, true);
			} else {
				return ResultUtil.getResult(ResultEnum.SUCCESS, false);
			}
		} else {
			return ResultUtil.getResult(ResultEnum.SUCCESS, false);
		}

	}

	/**
	 * 通过mac地址到redis缓存中获取用户信息
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<User> getUserInfo(HttpServletRequest request) {
		RedisTemplate<String, Object> redisTemplate = redis.redisTemplate();
		// 获取mac值
		String mac = GetMacAddress.getMac(request);
		// 通过mac值获取用户信息
		User user = (User) redisTemplate.opsForValue().get("register:itrip_user:" + mac);
		if (user != null) {
			// 通过redis中的用户信息为条件,到数据库中查询
			User dbUser = userRepository.findAllByUserCode(user.getUserCode());
			if (null == dbUser&&!dbUser.getUserPassword().equals(user.getUserPassword())) {
				return ResultUtil.getResult(ResultEnum.SUCCESS, null);
			} else {
				// 匹配数据库中的密码和redis缓存中存储是否相等
				if (user.getUserPassword().equals(dbUser.getUserPassword())) {
					// 将数据库中的数据在重新赋值/存储
					redisTemplate.opsForValue().set("register:itrip_user:" + mac, dbUser);
					redisTemplate.expire("register:itrip_user:" + mac, 1, TimeUnit.DAYS);

					return ResultUtil.getResult(ResultEnum.SUCCESS, dbUser);
				} else {
					return ResultUtil.getResult(ResultEnum.SUCCESS, null);
				}
			}
		}

		return ResultUtil.getResult(ResultEnum.SUCCESS, null);
	}
}
