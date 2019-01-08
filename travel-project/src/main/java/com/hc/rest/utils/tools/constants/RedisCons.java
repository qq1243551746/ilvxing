package com.hc.rest.utils.tools.constants;

public class RedisCons {

	/**
	 * 全局变量
	 */
	public static final String REDIS_GLOBAL_CODE = "global_code";

	/**
	 * 短信校验码
	 */
	public static final String MOBILE_VERIFY_CODE = "code:sms:";

	/**
	 * 图形验证码
	 */
	public static final String IMAGE_VERIFY_CODE = "code:image:";

	/**
	 * 短信唯一ID
	 */
	public static final String SMS_UUID = "sms:uuid:";

	/**
	 * 授权帐号存储，key为授权帐号名
	 */
	public static final String OAUTH2_CLIENT_ID = "oauth2:clientid:";
	/**
	 * 授权帐号存储，key为渠道码
	 */
	public static final String OAUTH2_CLIENT_CODE = "oauth2:clientcode:";

	/**
	 * 客户端授权token存储
	 */
	public static final String OAUTH2_TOKEN_CLIENT = "oauth2:token_client:";
	/**
	 * 密码授权token存储
	 */
	public static final String OAUTH2_TOKEN_PASSWORD = "oauth2:token_password:";

	/**
	 * 刷新授权token存储
	 */
	public static final String OAUTH2_TOKEN_REFRESH = "oauth2:token_refresh:";

	/**
	 * token为key，相关授权主体信息为值
	 */
	public static final String OAUTH2_TOKEN = "oauth2:token:";
	/**
	 * 小程序第三方授权信息
	 */
	public static final String USERS_MINI_SESSION3rd = "oauth2:user_mini_session3rd:";

	/**
	 * OAuth2相关资源信息
	 */
	public static final String OAUTH2_RESOURCES = "oauth2:resources:";

	/**
	 * 用户在线token存储
	 */
	public static final String ONLINE_USER = "oauth2:onlineuser:";

	/**
	 * 存储用户信息
	 */
	public static final String OAUTH2_USER = "oauth2:user:";

	/**
	 * 司机出车，需要将信息发布到redis中。
	 */
	public static final String DRIVER_OUT_CAR = "driver:outcar:";

	/**
	 * 司机正在订单中
	 */
	public static final String DRIVER_IN_ORDER = "driver:inorder:";
	/**
	 * 订单计价时间
	 */
	public static final String ORDER_VALUATION_TIME = "order:valuation:time";

	/**
	 * 获取管理员密码
	 */
	public static final String OAUTH2_USER_NAME = "oauth2:user:0:";

	/**
	 * 存储微信access_token
	 */
	public static final String WX_ACCESS_TOKEN = "oauth2:wx_access_token:";

	/**
	 * 存储微信ticket
	 */
	public static final String WX_TICKET = "oauth2:wx_ticket:";
	/**
	 * 存储微信openid
	 */
	public static final String WX_OPENID = "oauth2:wx_openid:";

	public static final String ORDER_CONFORM = "oauth2:order:conform:";

	public static final String MEMBER_MINA_SESSION3RD = "weixin:session:";

	public static final String WX_SHAER = "weixin:share:";

	public static final String MEMBER_MINA_ACCESS_TOKEN = "weixin:token:member";

}
