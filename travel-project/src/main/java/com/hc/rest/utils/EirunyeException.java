package com.hc.rest.utils;

public class EirunyeException extends RuntimeException {
	/**
	 * 接口返回信息公共类
	 */
	private static final long serialVersionUID = 1L;
	private Integer code;

	public EirunyeException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
