package com.hc.rest.controller.userinfo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.oss.ClientException;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.hc.rest.entity.user.User;
import com.hc.rest.service.user.UserService;
import com.hc.rest.utils.EirunyeException;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 登录
	 * 
	 * @param type
	 *            1、自动登录 2、普通登录 3、动态手机登录
	 * @param user
	 *            登录用户信息
	 * @param request
	 * @return
	 * @throws ClientException
	 * @throws com.aliyuncs.exceptions.ClientException
	 */
	@GetMapping(value = "/info/login")
	public Result<Boolean> login(Integer type, User user, HttpServletRequest request) throws ClientException, com.aliyuncs.exceptions.ClientException {

		return userService.login(type, user, request);

	}

	/**
	 * 获取登录用户信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/info/getUserInfo")
	public Result<User> getUserInfo(HttpServletRequest request) throws Exception {
		return userService.getUserInfo(request);
	}

	/**
	 * 插入数据(用户注册时进行插入数据)
	 * 
	 * @param user
	 *            需要注册的用户信息
	 * @param request
	 *            用于获取访问的mac值
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/info/save")
	public Result<Boolean> saveUser(User user, HttpServletRequest request) throws Exception {

		if (null == user) {
			throw new EirunyeException(ResultEnum.UNKNOWN_ERROR);// 这里定义自己的提示错误信息,最好每个都有定义这样比较明确错误!!!
		} else {
			// 执行新增操作
			return userService.userRegister(user, request);
		}

	}

	/**
	 * 通过(手机号/邮箱)验证是否注册过用户
	 * 
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/info/findByUserCode")
	public Result<Boolean> findByuserCode(String userCode) throws Exception {
		if (null == userCode) {
			return ResultUtil.error(-1, "验证码/手机号不能为空!");
		} else {
			return userService.verifyUserByCode(userCode);
		}

	}

	/**
	 * 发送短信验证码
	 * 
	 * @param phone电话号码
	 * @return
	 * @throws ClientException
	 * @throws com.aliyuncs.exceptions.ClientException
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/info/sendMsg")
	public Result<SendSmsResponse> sendMsg(String phone) throws ClientException, com.aliyuncs.exceptions.ClientException {
		if (null == phone) {
			return ResultUtil.error(-1, "手机号不能为空!");
		}
		return userService.sendMsg(phone);
	}

	/**
	 * 核实验证码是否正确
	 * 
	 * @param phone
	 * @param code
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/info/verifyCode")
	public Result<Boolean> verifyCode(String phone, String code) {
		if (null == phone) {
			return ResultUtil.error(-1, "手机号不能为空!");
		} else if (null == code) {
			return ResultUtil.error(-1, "验证码不能为空!");
		} else {
			return userService.verifyCode(phone, code);
		}

	}

	/**
	 * 账号注销
	 * 
	 * @param userName
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/info/cancellation")
	public Result<Boolean> cancellation(String userName, HttpServletRequest request) throws Exception {
		if (userName == null) {
			return ResultUtil.error(-1, "用户名不能为空!");
		}
		return userService.cancellation(userName, request);
	}

	/**
	 * 修改密码
	 * 
	 * @param userName
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/info/modifyUserPwd")
	public Result<Integer> modifyUserPwd(String pwd, String phone, HttpServletRequest request) throws Exception {
		if (phone == null) {
			return ResultUtil.error(-1, "手机号为空!");
		} else if (pwd == null) {
			return ResultUtil.error(-1, "密码不能为空!");
		}
		return userService.updatePwdByUserCode(pwd, phone, request);
	}

}
