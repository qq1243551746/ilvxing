package com.hc.rest.utils.tools.constants;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Pattern;

public class BasicCons {
	/**
	 * 遍历公用变量,通常用于树形结构<br/>
	 * 0：否，不遍历<br/>
	 * 1：是，遍历循环<br/>
	 */
	public static final int FETCH_CHILD = 0;
	/**
	 * 短信发送，同一个码可以发送5次
	 */
	public static final Integer SMS_FLUSH_COUNT = 5;
	/**
	 * 短信失效时间值，默认1分钟
	 */
	public static final long SMS_CODE_FLUSHTIME = 1;

	/**
	 * 短信验证码缓存失效时间,默认15分钟
	 */
	public static final long SMS_CODE_REDIS_FLUSHTIME = 15;
	/**
	 * 短信验证码长度，默认6位
	 */
	public static final int SMS_CODE_LENGTH = 6; // 短信校验码长度
	/**
	 * 短信获取类型<br/>
	 * 前端注册用户获取短信验证，默认：0
	 */
	public static final int SMS_CODE_TYPE_REG = 0;
	/**
	 * 短信获取类型<br/>
	 * 管理后台用户获取短信验证，默认：1
	 */
	public static final int SMS_CODE_TYPE_SYS = 1;
	/**
	 * Redis存储短信失效时间<br/>
	 * 注册用户短信失效时间存储
	 */
	public static final String SMS_CODE_TYPE_REG_TIME = "SMS_CODE_REG_TIME";
	/**
	 * Redis存储短信失效时间<br/>
	 * 管理后台用户短信失效时间存储
	 */
	public static final String SMS_CODE_TYPE_SYS_TIME = "SMS_CODE_SYS_TIME";
	/**
	 * Redis存储短信验证码<br/>
	 * 注册用户短信验证码存储
	 */
	public static final String SMS_CODE_TYPE_REG_CODE = "SMS_CODE_REG_CODE";
	/**
	 * Redis存储短信验证码<br/>
	 * 管理用户短信验证码存储
	 */
	public static final String SMS_CODE_TYPE_SYS_CODE = "SMS_CODE_SYS_CODE";
	/**
	 * 
	 * 
	 * 正则表达式校验手机号
	 */
	public static final String REGEX_MOBILE = "^1(3|4|5|7|8)\\d{9}$";
	/**
	 * 正则表达式校验数字
	 */
	public static final String REGEX_NUMBER = "^[0-9]*$"; // 正则表达式，校验数字
	/**
	 * 本地线程， 存储用户信息
	 */
	// public static final ThreadLocal<PrincipalVo> OAUTH2_THREADLOCAL = new ThreadLocal<>();

	public static Map<String, Object> htAllConfig = new Hashtable<>(); // 全局配置缓存

	/**
	 * DES3加密字符串密钥
	 */
	public static String des3SecretKey = "ydd0mj2snhzc2ilhsmf8xnibay7t8wgr";
	/**
	 * DES3加密算法参数值
	 */
	public static String des3Parameter = "oxy4u3e4";// 加密算法值
	/**
	 * MD5加密基数值</br>
	 * 所谓加密基数值，就是加密之后呈现的字符串由该26个字母与数字组合，也可以为纯字符串，也可以为大写，也可以为大小写等
	 * 
	 */
	public static String md5SecretKey = "0123456789abcdefghijklmnopqrstuvwxyz";
	/**
	 * SHA1加密基数值</br>
	 * 所谓加密基数值，就是加密之后呈现的字符串由该26个字母与数字组合，也可以为纯字符串，也可以为大写，也可以为大小写等
	 */
	public static String sha1SecretKey = "0123456789abcdefghijklmnopqrstuvwxyz";

	public static final int CLIENT_TYPE_PALTFORM = 1;

	public static final int CLIENT_TYPE_CLIENT = 2;

	public static final int CLIENT_TYPE_PASSWORD = 3;

	/**
	 * 
	 */
	public static final String OAUTH2_GRANT_CLIENT = "client_credentials";

	/**
	 * 获取密码授权token的固定值
	 */
	public static final String OAUTH2_GRANT_PASSWORD = "password";
	/**
	 * 刷新token固定值
	 */
	public static final String OAUTH2_GRANT_REFRESH = "refresh_token";
	/**
	 * redis授权db下标值
	 */
	public static final int REDIS_AUTH_DB = 1;

	/**
	 * 授权token类型
	 */
	public static final String OAUTH2_BEARER = "bearer";

	/**
	 * 请求token的授权前缀
	 */
	public static final String OAUTH2_BASIC = "basic";

	/**
	 * 校验手机号是否符合规则
	 * 
	 * @param mobile
	 * @return true:校验通过，false：校验不通过
	 */
	public static boolean checkMobile(String mobile) {
		return Pattern.matches(REGEX_MOBILE, mobile);
	}

	/**
	 * 管理后台登录类型<br/>
	 * 图形验证码登录，默认0
	 */
	public static final int SYS_LOGIN_TYPE_IMG = 0;
	/**
	 * 管理后台登录类型<br/>
	 * 短信验证码登录，默认1
	 */
	public static final int SYS_LOGIN_TYPE_SMS = 1;

	/**
	 * 状态值<br/>
	 * 有效：默认1
	 */
	public static final int STATE_VALID = 1;
	/**
	 * 状态值<br/>
	 * 无效：默认0
	 */
	public static final int STATE_INVALID = 0;

	/**
	 * 模版类型: 验证码 <br/>
	 * 模版名称: 身份验证验证码 <br/>
	 * 模版CODE: SMS_109650014 <br/>
	 * 模版内容: 验证码${code}，您正在进行身份验证，打死不要告诉别人哦！
	 */
	public static final String SMS_109650014 = "SMS_109650014";

	/**
	 * 模版类型: 验证码<br/>
	 * 模版名称: 登录确认验证码<br/>
	 * 模版CODE: SMS_109650012<br/>
	 * 模版内容: 验证码${code}，您正在登录，若非本人操作，请勿泄露。<br/>
	 */
	public static final String SMS_109650012 = "SMS_127166759";

	/**
	 * 模版类型: 验证码<br/>
	 * 模版名称: 登录异常验证码<br/>
	 * 模版CODE: SMS_109650011<br/>
	 * 模版内容: 验证码${code}，您正尝试异地登录，若非本人操作，请勿泄露。<br/>
	 */
	public static final String SMS_109650011 = "SMS_109650011";

	/**
	 * 模版类型: 验证码<br/>
	 * 模版名称: 用户注册验证码<br/>
	 * 模版CODE: SMS_109650010<br/>
	 * 模版内容: 验证码${code}，您正在注册成为新用户，感谢您的支持！<br/>
	 */
	public static final String SMS_109650010 = "SMS_109650010";

	/**
	 * 模版类型: 验证码<br/>
	 * 模版名称: 修改密码验证码<br/>
	 * 模版CODE: SMS_109650009<br/>
	 * 模版内容: 验证码${code}，您正在尝试修改登录密码，请妥善保管账户信息。
	 */
	public static final String SMS_109650009 = "SMS_109650009";
	/**
	 * 模版类型: 验证码<br/>
	 * 模版名称: 信息变更验证码<br/>
	 * 模版CODE: SMS_109650008<br/>
	 * 模版内容: 验证码${code}，您正在尝试变更重要信息，请妥善保管账户信息。<br/>
	 */
	public static final String SMS_109650008 = "SMS_109650008";

	/**
	 * 出行渠道
	 */
	public static final int CHANNEL_CHE = 1;
	/**
	 * 优惠券状态，待使用
	 */
	public static final int COUPON_STATE_NOUSE = 0;

	/**
	 * 优惠券状态，未使用
	 */
	public static final int COUPON_STATE_USER = 1;
	/**
	 * 优惠券状态，已使用
	 */
	public static final int COUPON_STATE_EXPIRES = 2;
	/**
	 * 优惠券状态，已冻结，待支付，而未支付
	 */
	public static final int COUPON_STATE_FREEZE = 3;
	/**
	 * 司机与乘客的打车距离，单位公里
	 */
	public static final int DRIVER_CAR_DISTANCE = 1;
	/**
	 * 设备类型之ios
	 */
	public static final int DEVICE_TYPE_IOS = 2;
	/**
	 * 设备类型之android
	 */
	public static final int DEVICE_TYPE_ANDROID = 1;
	/**
	 * 司机接乘客需要在10分钟内赶到
	 */
	public static final int DRIVER_TO_PASSGENER_MINUTE = 10;
	/**
	 * 订单状态<br/>
	 * 0：乘客取消订单；<br/>
	 * 1：司机已接单，乘客等待接驾，司机赶往乘客；<br/>
	 * 2：到达约定地点；<br/>
	 * 3：接到乘客，乘客行程开始；<br/>
	 * 4：到达目的地,乘客行程结束；<br/>
	 * 5：司机确认账单，乘客待支付；<br/>
	 * 6：乘客支付完成，订单结束；
	 */
	public static final int ORDER_STATE_0 = 0;
	/**
	 * 订单状态<br/>
	 * 0：乘客取消订单；<br/>
	 * 1：司机已接单，乘客等待接驾，司机赶往乘客；<br/>
	 * 2：到达约定地点；<br/>
	 * 3：接到乘客，乘客行程开始；<br/>
	 * 4：到达目的地,乘客行程结束；<br/>
	 * 5：司机确认账单，乘客待支付；<br/>
	 * 6：乘客支付完成，订单结束；
	 */
	public static final int ORDER_STATE_1 = 1;
	/**
	 * 订单状态<br/>
	 * 0：乘客取消订单；<br/>
	 * 1：司机已接单，乘客等待接驾，司机赶往乘客；<br/>
	 * 2：到达约定地点；<br/>
	 * 3：接到乘客，乘客行程开始；<br/>
	 * 4：到达目的地,乘客行程结束；<br/>
	 * 5：司机确认账单，乘客待支付；<br/>
	 * 6：乘客支付完成，订单结束；
	 */
	public static final int ORDER_STATE_2 = 2;
	/**
	 * 订单状态<br/>
	 * 0：乘客取消订单；<br/>
	 * 1：司机已接单，乘客等待接驾，司机赶往乘客；<br/>
	 * 2：到达约定地点；<br/>
	 * 3：接到乘客，乘客行程开始；<br/>
	 * 4：到达目的地,乘客行程结束；<br/>
	 * 5：司机确认账单，乘客待支付；<br/>
	 * 6：乘客支付完成，订单结束；
	 */
	public static final int ORDER_STATE_3 = 3;
	/**
	 * 订单状态<br/>
	 * 0：乘客取消订单；<br/>
	 * 1：司机已接单，乘客等待接驾，司机赶往乘客；<br/>
	 * 2：到达约定地点；<br/>
	 * 3：接到乘客，乘客行程开始；<br/>
	 * 4：到达目的地,乘客行程结束；<br/>
	 * 5：司机确认账单，乘客待支付；<br/>
	 * 6：乘客支付完成，订单结束；
	 */
	public static final int ORDER_STATE_4 = 4;
	/**
	 * 订单状态<br/>
	 * 0：乘客取消订单；<br/>
	 * 1：司机已接单，乘客等待接驾，司机赶往乘客；<br/>
	 * 2：到达约定地点；<br/>
	 * 3：接到乘客，乘客行程开始；<br/>
	 * 4：到达目的地,乘客行程结束；<br/>
	 * 5：司机确认账单，乘客待支付；<br/>
	 * 6：乘客支付完成，订单结束；
	 */
	public static final int ORDER_STATE_5 = 5;
	/**
	 * 订单状态<br/>
	 * 0：乘客取消订单；<br/>
	 * 1：司机已接单，乘客等待接驾，司机赶往乘客；<br/>
	 * 2：到达约定地点；<br/>
	 * 3：接到乘客，乘客行程开始；<br/>
	 * 4：到达目的地,乘客行程结束；<br/>
	 * 5：司机确认账单，乘客待支付；<br/>
	 * 6：乘客支付完成，订单结束；
	 */
	public static final int ORDER_STATE_6 = 6;

	/**
	 * 是否通过验证值<br/>
	 * 有效：默认1
	 */
	public static final int CERT_VALID = 1;
	/**
	 * 是否通过验证值<br/>
	 * 无效：默认0
	 */
	public static final int CERT_INVALID = 0;

	/**
	 * 登录的私钥
	 */
	public static final String LOGIN_PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIqMxRB4bax/bhUVvvR2CfI5889K675vZ+UGmdbb8A8n3D9yzVwI5qs6kccazIV22ktXrgwIgP4dHwhmoGIrwsO5wF9fNu2wXTP18uBjppZi6eXdlHN39zjorSI8lSdg3LF1b1fTIgycyxCWFB9mDK5qpuc9sPey9V071gbTyI3/AgMBAAECgYEAht10Tg4MJCd+zoN2d5wXHnSPAa9aPutO5L9CLMW2reoNGK31fKslbnP6xyctApWo9EILJ6d3eOR7+r97S1RxpokHk9aLUwbtkUA9BbF0LwNLeJIe3mT13oXp5+R5i7BwmMuLcKkLHJIqHeZEdBhX8ubwiTYBMeiDP26oHkI0AzECQQDHHiomldU0jlpocvxMlzLksTA69tZnraGzfo83bEw7HgcoWdyVWDdBbkRiU1wnCYeqYTjvBrR0pdgTpBACCBP9AkEAsiEqQecI0v+O0SPkINgWumGX+S8/jBvkxTAPUp6BjhyQAgZ/EVeejSbpdnp0dhwGxce5DTyjXrbcagyHKaREqwJAIusqTyv1gMr6FdkcX74gQbTFFYIWJYZwlg66xOhsEe35KV1g7pvSzNmuimO+BGaKcRmtp1VQrigrVX5vBDwwbQJAHsgGYl8HMlcBGfjmyhotS0XkGiZlB9QmI0Eb1L4ZSzJ6XC89NAT9HA02WMfuah6LuQ+7VaM94/cbfaPuk26UgwJBAJuWhd9pM2XH3nN9MMNWnKi24vovtiv/WiiGdNRN2mvz6I5qDB3cIt0y6sm7dhKSioXaZM1mhNoD9Cd3M5Fk2cI=";
	/**
	 * 登录的公钥
	 */
	public static final String LOGIN_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKjMUQeG2sf24VFb70dgnyOfPPSuu+b2flBpnW2/APJ9w/cs1cCOarOpHHGsyFdtpLV64MCID+HR8IZqBiK8LDucBfXzbtsF0z9fLgY6aWYunl3ZRzd/c46K0iPJUnYNyxdW9X0yIMnMsQlhQfZgyuaqbnPbD3svVdO9YG08iN/wIDAQAB";
	/**
	 * 乘客的个推类型值，value=0
	 */
	public static final int GETUI_TYPE_PASSENGER = 0;
	/**
	 * 司机的个推类型值，value=1
	 */
	public static final int GETUI_TYPE_DRIVER = 1;
	/**
	 * 司机收益的占比，90%
	 */
	public static final BigDecimal PRICE_DRIVER_PERCENT = new BigDecimal(0.9);
	/**
	 * 平台抽取的服务费，10%
	 */
	public static final BigDecimal PRICE_PLATFORM_PERCENT = new BigDecimal(0.1);
	/**
	 * 补贴给实际的价格，目前为0
	 */
	public static final BigDecimal PRICE_DRIVER_SUBSIDY = new BigDecimal(0.00);
	/**
	 * 乘客的保险费，目前为0
	 */
	public static final BigDecimal PRICE_PASSENGER_INSURANCE = new BigDecimal(0.00);
	public static final String ALIPAY_PUBLIC_KEY = null;
	public static final String ALIPAY_CHARSET = "utf-8";
	public static final int PAY_STATE_0 = 0;
	public static final int PAY_STATE_1 = 1;
	public static final int PAY_TYPE_ALPAY = 51;
	public static final int PAY_TYPE_WXPAY = 52;

	/**
	 * 小程序登录，通过微信code换取session信息
	 */
	public static final String MINI_PROGRAM_URL_LOGIN_SESSION = "https://api.weixin.qq.com/sns/jscode2session";
	public static final Integer CAR_BRAND = 1;
	public static final Integer CAR_COMPONY = 2;
	public static final Integer CAR_MODEL = 3;
	public static final Integer CAR_DETAIL = 4;

	public static final Long USER_NO_BASIC = 82220000000000l;
	public static final String WX = "微信";
	public static final Integer CANAEL_ORDER = 2; // 取消订单
	public static final Integer DELETE_BAN = 2; // 删除银行卡
	/**
	 * 下单默认地址标识位
	 */
	public static final Integer DEFAULT_ADDRESS = 1;

	public static final Long USER_ROLE_NORMAL = 1l;
	public static final String USER_ROLE_NORMAL_NAME = "普通用户";

	/**
	 * 大礼包的订单支付状态<br/>
	 * 0. 未支付<br/>
	 * 1. 已支付 不需要上传资料<br/>
	 * 2. 已支付 需要上传资料，且未上传资料。<br/>
	 * 3. 已支付 需要上传资料，且上传资料成功。<br/>
	 * 4. 手动取消订单<br/>
	 * 5. 超时取消订单<br/>
	 */
	public static final int SPREE_ORDER_STATE_NOPAY = 0; // 未支付
	/**
	 * 大礼包的订单支付状态<br/>
	 * 0. 未支付<br/>
	 * 1. 已支付 不需要上传资料<br/>
	 * 2. 已支付 需要上传资料，且未上传资料。<br/>
	 * 3. 已支付 需要上传资料，且上传资料成功。<br/>
	 * 4. 手动取消订单<br/>
	 * 5. 超时取消订单<br/>
	 */
	public static final int SPREE_ORDER_STATE_PAY = 1; // 已支付 不需要上传资料
	/**
	 * 大礼包的订单支付状态<br/>
	 * 0. 未支付<br/>
	 * 1. 已支付 不需要上传资料<br/>
	 * 2. 已支付 需要上传资料，且未上传资料。<br/>
	 * 3. 已支付 需要上传资料，且上传资料成功。<br/>
	 * 4. 手动取消订单<br/>
	 * 5. 超时取消订单<br/>
	 */
	public static final int SPREE_ORDER_STATE_NEED_VL = 2; // 已支付 需要上传资料，且未上传资料。

	/**
	 * 大礼包的订单支付状态<br/>
	 * 0. 未支付<br/>
	 * 1. 已支付 不需要上传资料<br/>
	 * 2. 已支付 需要上传资料，且未上传资料。<br/>
	 * 3. 已支付 需要上传资料，且上传资料成功。<br/>
	 * 4. 手动取消订单<br/>
	 * 5. 超时取消订单<br/>
	 */
	public static final int SPREE_ORDER_STATE_HAVE_VL = 3; // 已支付 需要上传资料，且上传资料成功。
	/**
	 * 大礼包的订单支付状态<br/>
	 * 0. 未支付<br/>
	 * 1. 已支付 不需要上传资料<br/>
	 * 2. 已支付 需要上传资料，且未上传资料。<br/>
	 * 3. 已支付 需要上传资料，且上传资料成功。<br/>
	 * 4. 手动取消订单<br/>
	 * 5. 超时取消订单<br/>
	 */
	public static final int SPREE_ORDER_STATE_HAND_CANCEL = 4; // 手动取消订单
	/**
	 * 大礼包的订单支付状态<br/>
	 * 0. 未支付<br/>
	 * 1. 已支付 不需要上传资料<br/>
	 * 2. 已支付 需要上传资料，且未上传资料。<br/>
	 * 3. 已支付 需要上传资料，且上传资料成功。<br/>
	 * 4. 手动取消订单<br/>
	 * 5. 超时取消订单<br/>
	 */
	public static final int SPREE_ORDER_STATE_AUTO_CANCEL = 5; // 超时取消订单
	/**
	 * 行驶证上传状态<br/>
	 * 0:未上传<br/>
	 * 1:已上传<br/>
	 * 
	 */
	public static final int SPREE_ORDER_STATE_VL_NO = 0;
	/**
	 * 行驶证上传状态<br/>
	 * 0:未上传<br/>
	 * 1:已上传<br/>
	 * 
	 */
	public static final int SPREE_ORDER_STATE_VL_YES = 1;

	public static final Integer BANK_STATE = 2;
	public static final Integer VEHICLE_STATE = 2;
	public static final Integer UPLOAD_VL = 3;

	/**
	 * 银堡类型<br/>
	 * 1.礼包购买获得银堡(收入)<br/>
	 * 2.银堡转换为金堡(支出)<br/>
	 * 3.通过分享获得银堡(收入)<br/>
	 */
	public static final long SILVER_TYPE_SILVER_BUY = 1l;
	/**
	 * 银堡类型<br/>
	 * 1.礼包购买获得银堡(收入)<br/>
	 * 2.银堡转换为金堡(支出)<br/>
	 * 3.通过分享获得银堡(收入)<br/>
	 */
	public static final long SILVER_TYPE_SILVER_TO_GOLD = 2l;
	/**
	 * 银堡类型<br/>
	 * 1.礼包购买获得银堡(收入)<br/>
	 * 2.银堡转换为金堡(支出)<br/>
	 * 3.通过分享获得银堡(收入)<br/>
	 */
	public static final long SILVER_TYPE_SILVER_TO_SHARE = 3l;

	/**
	 * 微信支付状态<br/>
	 * 0：未回调<br/>
	 * 1: 回调成功<br/>
	 * 2: 回调失败<br/>
	 */
	public static final int WX_PAY_NOTIFY_NO = 0;
	/**
	 * 微信支付状态<br/>
	 * 0：未回调<br/>
	 * 1: 回调成功<br/>
	 * 2: 回调失败<br/>
	 */
	public static final int WX_PAY_NOTIFY_SUCCESS = 1;
	/**
	 * 微信支付状态<br/>
	 * 0：未回调<br/>
	 * 1: 回调成功<br/>
	 * 2: 回调失败<br/>
	 */
	public static final int WX_PAY_NOTIFY_ERROR = 2;
	public static String APIINFO_TITLE = "";
	public static String APIINFO_DESCRIPTION = "";
}
