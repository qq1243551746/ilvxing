package com.hc.rest.utils;

/**
 * Describe 返回状态处理，枚举
 */
public enum ResultEnum {

	UNKNOWN_ERROR(-1, "UNKNOW ERROR"), // 返回失败
	USERNOTEXIST(2, "USER NOT EXIST"), // 用户不存在
	SUCCESS(0, "SUCCESS"), /// 返回成功 
	NODATA(1,"没有找到相应的内容"),//返回数据为空
	;

	private Integer code; // 返回码 0表示成功，1表示失败，-1未知错误
	private String msg;

	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
