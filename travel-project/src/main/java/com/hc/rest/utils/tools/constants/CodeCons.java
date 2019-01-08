package com.hc.rest.utils.tools.constants;

public enum CodeCons {
	/**
	 * <p>
	 * 成功
	 * </p>
	 * 注：统一系统返回编码</br>
	 */
	SUCCESS(0, "成功"),

	/**
	 * <p>
	 * 失败、系统异常、未知异常
	 * </p>
	 * 注：统一系统返回编码</br>
	 */
	ERROR(-1, "系统异常"),

	/**
	 * <p>
	 * 新增平台根据平台号校验是否有
	 * </p>
	 */

	SERVICE(-1, "已有该服务，请重新输入！"),

	/**
	 * <p>
	 * 新增服务校验是否有
	 * </p>
	 */

	CONFLICT(-1, "已有该平台号，请重新输入！"),

	/**
	 * 授权—换取token时，无头部验证密钥
	 */
	OAUTH2_NO_HEAD(40000, "头部授权信息解析异常，请检查是否正确！"),

	/**
	 * 授权-换取token时，授权帐号信息错误
	 */
	OAUTH2_CLIENT_ERROR(40001, "请求授权接口帐号信息错误"),

	/**
	 * 授权-换取token，grant_type没传或错误
	 */
	OAUTH2_GRANT_TYPE_ERROR(40002, "请求授权接口，grant_type参数为空或错误"),

	/**
	 * 授权-换取token，如果有IP限制，则需要符合IP限制
	 */
	OAUTH2_IP_LIMIT(40003, "请求授权接口，不在ip白名单"),

	/**
	 * 授权-换取token时，如果是密码授权，需要校验用户名与密码是否为空
	 */
	OAUTH2_USER_PASS_NULL(40004, "获取密码授权token，用户或密码为空"),

	/**
	 * 授权-换取token时，刷新token，需要校验刷新token是否为空
	 */
	OAUTH2_REFRESH_NULL(40005, "获取刷新token，刷新token为空"),

	/**
	 * 授权-换取客户端token时，未知异常
	 */
	OAUTH2_CLIENT_TOKEN_ERROR(40006, "获取客户端token，未知异常"),

	/**
	 * 授权-获取密码token时，处理错误
	 */
	OAUTH2_PASSWORD_TOKEN_ERROR(40007, "获取密码token，未知异常"),

	/**
	 * 授权-刷新token时，处理错误
	 */
	OAUTH2_REFRESH_TOKEN_ERROR(40008, "获取刷新token，未知异常"),

	/**
	 * 请求接口，无token授权
	 */
	OAUTH2_TOKEN_NO(40009, "令牌不能为空，请传入有效令牌！"),

	/**
	 * 请求接口，token在redis缺失
	 */
	OAUTH2_TOKEN_INFO_NO(40010, "令牌无效，请重新申请令牌！"),

	/**
	 * 请求接口无权限访问
	 */
	OAUTH2_RESOURCES_NO_ACCESSS(40011, "当前令牌无权限访问该接口！"),

	/**
	 * 授权-获取密码授权，redis不存在密码信息
	 */
	OAUTH2_NO_PASSWORD_REDIS(40012, "Redis缺失密码信息，请联系管理员！"),

	/**
	 * 授权-获取密码授权，redis的密码与传入的密码不一致
	 */
	OAUTH2_ERROR_PASSWORD_REDIS(40013, "密码校验失败，请传入有效密码！"),

	/**
	 * 授权-刷新token，缓存中不存在token
	 */
	OAUTH2_NO_REFRESH_TOKEN(40014, "刷新令牌已经失效，请重新申请密码授权令牌！"),
	/**
	 * 公用属性，校验参数是否为空
	 */
	COMMON_CHECK_PARAM_NULL(50001, "请求参数不能为空"),
	/**
	 * 手机号码格式错误
	 */
	COMMON_CHECK_MOBILE_FORMAT(50002, "手机号格式错误"),
	/**
	 * 短信发送失败
	 */
	ERROR_sendSMS_FAILED(50003, "短信发送失败"),
	/**
	 * 短信不能频繁刷新请求
	 */
	ERROR_SMS_NO_OFTEN_FLUSH(50004, "不能频繁请求发送短信"),
	/**
	 * 校验短信验证码失败
	 */
	ERROR_checkMobileVerifyCode_FAILED(50005, "短信验证码校验失败"),
	/**
	 * 公用属性，校验参数长度超过了指点长度
	 */
	COMMON_CHECK_PARAM_LENGTH(50006, "参数长度超过指定长度"),
	// 用户号唯一错误
	USER_ONLY_ERROR(50007, "用户名已经存在"),

	/**
	 * 同一个父ID的菜单不能存在相同的菜单名
	 */
	ERROR_ADD_MENU_FAILED(50008, "子菜单不能存在相同菜单名"),
	/**
	 * 当前菜单下存在功能点，需删除功能点之后再删菜单
	 */
	ERROR_DELECT_MENU_FAILED(50009, "当前菜单存在功能点，无法删除"),

	/**
	 * 菜单已经被删除
	 */
	CHECK_MENU_EXISTS(50010, "菜单已经被删除"),
	/**
	 * 菜单下已经存在该功能点名称
	 */
	CHECK_MENU_FUNC_NAME_EXISTS(50011, "菜单下已经存在该功能点名称"),

	/**
	 * 菜单下已经存在该功能点Code
	 */
	CHECK_MENU_FUNC_CODE_EXISTS(50012, "菜单下已经存在该功能点Code"),
	/**
	 * 核验修改的功能点是否存在
	 */
	CHECK_MENU_FUNC_EXISTS(50013, "核验修改的功能点是否存在"),

	/**
	 * 用户为空的错误提示
	 */
	ERROR_MANAGER_USER_NULL(50014, "用户为空的错误提示"),

	/**
	 * 密码校验失败错误提示
	 */
	ERROR_MANAGER_USER_PASSWORD_FAILED(50015, "密码错误"),

	/**
	 * 图形校验码失效，在缓存中不存在
	 */
	ERROR_MANAGER_IMAGE_INVALID(50016, "图形校验码失效，在缓存中不存在"),
	/**
	 * 图形验证码校验失败
	 */
	ERROR_MANAGER_IMAGE_CHECK_FAILED(50017, "图形验证码校验失败"),

	/**
	 * 通过用户名查询不到手机号
	 */
	ERROR_MANAGER_USERNAME_NOT_MOBILE(50018, " 通过用户名查询不到手机号"),
	/**
	 * 检查菜单名是否存在
	 */
	CHECK_MENU_NAME_EXISTS(50019, "检查菜单名是否存在"),
	/**
	 * 检查角色名是否存在 存在为yes
	 */
	CHECK_ROLE_EXISTS_YES(50020, "检查角色名是否存在 存在为yes"),
	/**
	 * 检查角色名是否存在 不存在为no
	 */
	CHECK_ROLE_EXISTS_NO(50021, "检查角色名是否存在 不存在为no"),
	/**
	 * 检查角色是否已经存在
	 */
	CHECK_ROLE_NAME_EXISTS(50022, "检查角色是否已经存在"),

	/**
	 * 修改用户密码管理员密码不正确
	 * 
	 */
	ADMIN_PASSWORD_ERROR(50023, "修改用户密码管理员密码不正确"),
	/**
	 * 用户不存在
	 */
	USER_NOT_EXISTS(50024, "用户未注册"),
	/**
	 * 用户已经被禁用
	 */
	USER_IS_DISABLE(50025, "用户已经被禁用"),
	/**
	 * 用户是正常状态
	 */
	USER_IS_ENABLE(50026, "用户是正常状态"),

	/**
	 * 菜单不存在
	 */
	ERROR_MENU_ISNULL(50027, "菜单不存在"),

	/**
	 * 菜单无更新
	 */
	UPDATE_MENU_NO(50028, "菜单无更新"),

	/**
	 * 功能点无更新
	 */
	UPDATE_MENU_FUNC_NO(50029, "功能点无更新"),

	/**
	 * 角色无更新
	 */
	UPDATE_ROLE_NO(50030, "角色无更新"),
	/**
	 * 最顶层菜单不能为0
	 */
	MENU_ID_IS0(50031, "最顶层菜单不能为0"),
	/**
	 * 校验用户手机号是否存在，当前码表示存在
	 */
	CHECK_USER_MOBILE_EXISTS_YES(50032, "当前用户存在手机号"), //
	/**
	 * 用户名已经存在
	 */
	USERNAME_IS_EXISTS(50033, "用户名已经存在"),
	/**
	 * 通过手机号未查找到用户信息
	 */
	ERROR_MOBILE_NOT_FINDUSER(50034, "通过手机号未查找到用户信息"),
	/**
	 * 手机号已注册
	 */
	MOBILE_IS_REG_YES(50035, "手机号已注册"),
	/**
	 * 手机号未注册
	 */
	MOBILE_IS_REG_NO(50036, "手机号未注册"),
	/**
	 * 用户实名认证
	 */
	USER_HAS_CERT_IDCARD(50037, "用户已经实名认证，无需重复认证"),
	/**
	 * 阿里识别失败
	 */
	ALI_DISCERN_FAILED(50038, "阿里识别失败"),
	/**
	 * 证件不存在
	 */
	CREDENTIALS_NOT_EXISTS(50039, "证件不存在"),
	/**
	 * 身份证正面未上传
	 */
	IDCARD_FACE_NO_UPLOAD(50040, "身份证正面未上传"),
	/**
	 * 身份证反面未上传
	 */
	IDCARD_BACK_NO_UPLOAD(50041, "身份证反面未上传"),
	/**
	 * 驾驶证正面未上传
	 */
	DRIVER_FACE_NO_UPLOAD(50042, "驾驶证正面未上传"),
	/**
	 * 驾驶证反面未上传
	 */
	DRIVER_BACK_NO_UPLOAD(50043, "驾驶证反面未上传"),
	/**
	 * 行驶证未上传
	 */
	VEHICLE_NO_UPLAD(50044, "行驶证未上传"),
	/**
	 * 身份证正面解析失败
	 */
	IDCARD_FACE_DISCERN_FAILED(50045, "身份证正面解析失败"),
	/**
	 * 身份证反面解析失败
	 */
	IDCARD_BACK_DISCERN_FAILED(50046, "身份证反面解析失败"),
	/**
	 * 驾驶证正面解析失败
	 */
	DRIVER_FACE_DISCERN_FAILED(50047, "驾驶证正面解析失败"),
	/**
	 * 驾驶证反面解析失败
	 */
	DRIVER_BACK_DISCERN_FAILED(50048, "驾驶证反面解析失败"),
	/**
	 * 行驶证解析失败
	 */
	VEHICLE_DISCERN_FAILED(50049, "行驶证解析失败"),
	/**
	 * 车主认证需先实名认证
	 */
	DRIVER_CERT_NEED_CERT_IDCARD(50050, "车主认证需先实名认证"),
	/**
	 * 驾驶证、行驶证、身份证不匹配
	 */
	IDCARD_DRIVER_VEHICLE_UNMATCH(50051, "驾驶证、行驶证、身份证不匹配"),
	/**
	 * 车主已认证，无需重复认证
	 */
	DRIVER_HAS_CERT_IDCARD(50052, "车主已认证，无需重复认证"),
	/**
	 * 乘客打车，周边无司机
	 */
	PASSENGER_NO_DRIVER(50053, "乘客周边无司机，请隔一段时间刷新！"),
	/**
	 * 车主未认证
	 */
	DRIVER_NEED_CERT_DRIVER(50054, "司机未认证"),
	/**
	 * 文件不存在
	 */
	FILE_NOT_EXISTS(50055, "文件不存在"),
	/**
	 * 订单已取消，无需重复取消
	 */
	ORDER_CANCEL_IS(50056, "订单已取消，无需重复取消"),
	/**
	 * 订单处于未知状态，取消失败
	 */
	ORDER_CANCEL_OTHER(50057, "订单处于未知状态，取消失败"),
	/**
	 * 行程已经开始，无法取消订单
	 */
	ORDER_CANCEL_BEGIN(50058, "行程已经开始，无法取消订单"),
	/**
	 * 行程已经结束，无法取消订单
	 */
	ORDER_CANCEL_END(50059, "行程已经到达目的地，无法取消订单"),
	/**
	 * 行程待支付，无法取消订单
	 */
	ORDER_CANCEL_NO_PAY(50060, "行程待支付，无法取消订单"),
	/**
	 * 行程已完成支付，无法取消订单
	 */
	ORDER_CANCEL_YES_PAY(50061, "行程已完成支付，无法取消订单"),
	/**
	 * 行程已完成支付，无法取消订单
	 */
	ERROR_SMS(50064, "短信验证注册失败"),
	/**
	 * 该用户以认证
	 */
	DRIVER_CERT_IDCARD(50065, "该用户以认证"),
	/**
	 * 预定车型选择系统出错
	 */
	DRIVER_RESERVATION(50066, "预定车型选择系统出错"),

	/**
	 * 预定车型代理商选择系统出错
	 */
	DRIVER_THEAGENT(50067, "预定车型代理商选择系统出错"),
	/**
	 * 预定车型获取用户信息系统出错
	 */
	DRIVER_USERINFO(50068, "预定车型获取用户信息系统出错"),

	/**
	 * 预定失败没有库存
	 */
	DRIVER_INVENTORY(50069, "预定失败没有库存"),
	/**
	 * 小程序在缓存中不存在session信息
	 */
	ERROR_MINI_SESSION_REIDS_NULL(50070, "小程序在缓存中不存在session信息"),
	/**
	 * 小程序登录第三方授权session3rd验证失败
	 */
	ERROR_MINI_SESSION3RD(50071, "小程序登录第三方授权session3rd验证失败"),

	/**
	 * 小程序登录第三方授权session3rd验证失败
	 */
	ERROR_MINI_TOKEN(50072, "小程序登录第三方授权session3rd验证失败，code过期"),

	/**
	 * 小程序登录第三方授权session3rd验证失败
	 */
	ERROR_SESSIONKEY(50073, "小程序code已过期请重新登录"),

	/**
	 * 小程序登录第三方授权session3rd验证失败
	 */
	ERROR_MINI_PAY_TOKEN(50074, "小程序登录第三方授权session3rd验证失败，code过期,统一下单失败"),
	/**
	 * 还有订单未完结，不能收车
	 */
	DRIVER_HAS_ORDER_NOOVER(50062, "还有订单未完结，不能收车"), //
	EXCEPTION_DRIVER_UPLOAD_LOCATION(50063, "司机上传定位异常"), //
	EXCEPTION_OUTCAR(60064, "司机出车异常"), //
	EXCEPTION_DRIVER_INCAR(60065, "司机收车异常"), //
	LOGIN_SIGN_FAILED(60066, "登录签名校验失败"), //

	LOGIN_RSA_FAILED(60067, "登录参数解密失败"), //
	OLD_PASSWORD_ERROR(60068, "旧密码错误"), //
	CID_NO_REGISTER(60069, "个推CID未注册"), //
	OLDPASS_NEWPASS_EQUAL(60070, "旧密码与新密码不能相同"), //
	MEMBER_MINA_SESSION3RD(60071, "用户未绑定手机号，请绑定手机号！"), //
	MEMBER_MINA_NEED_UNION(60072, "未获取到unionId，需要前端调用wx.userinfo()接口，并传入用户信息"), //
	MEMBER_MINA_SESSION3RD_ERROR(60073, "session3rd校验失败，请重新拉取jsCode"), //
	MEMBER_MINA_USERINFO_SIGN_ERROR(60074, "获取用户信息签名失败！"), //
	ORDER_ERROR(60075, "没有查询到订单"), //
	SHAREID_NULL(60076, "没有该分享者"), //
	SPREE_DETAILS(60078, "没有该分享者"), //
	NO_SUPPORT_PAY(60077, "暂时不支持该支付方式，请重新选择。"), //
	NO_PASSWORD(60080, "你输入的密码不正确"), //
	PASSWORD_NULL(60079, "你还没有设置密码，请到安全中心设置支付密码."), //
	ORDER_NULL(60081, "你还有未支付订单，请到我的订单完成订单"), //
	USER_NULL(60082, "用户为空，系统错误"), //
	NONEXISTENT_ERROR(60079, "该信息不存在，修改错误！"), //
	ADDRESS_NULL(60080, "该信息不存在，修改错误！"), //
	NULL_ADDRESS(60083, "请填写地址"), //
	NULL_CONFIRM(60084, "确认订单为空"), //
	GOLD_NULL(60085, "获取金堡信息失败"), //
	SILVER_NULL(60086, "获取银堡信息失败"), //
	SILVERRECORD_NULL(60087, "获取银堡支付明细失败，没有查询到该明细"), //
	GOLD_WITHDRAWAL(60089, "您账户的可提现金额小于您申请的金额，请重新输入"), //
	GOLDRECORD_NULL(60088, "获取金堡支付明细失败，没有查询到该明细"), //
	GOLD_ACOUNT_NULL(60090, "您没有金堡账户信息，请联系管理人员"), //
	BANK_NULL(60091, "您还没有默认银行卡信息，请添加"),
	/**
	 * 授权-获取密码授权，redis的密码与传入的密码不一致
	 */
	OAUTH2_ERROR_PAY_PASSWORD_REDIS(60092, "支付密码错误，请确认密码是否正确！"), //
	PAY_WAY(60093, "您选择的支付方式与"), //
	NO_CERTIFICATION(60094, "您还为进行实名认证不可提现，请先进行实名认证！"), //
	NO_PAY(60095, "未支付订单");
	private final int code;

	private final String msg;

	private CodeCons(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
