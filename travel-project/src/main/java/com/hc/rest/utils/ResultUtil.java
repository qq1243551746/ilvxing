package com.hc.rest.utils;

/**
 * 结果公共类
 */
public class ResultUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Result getResult(ResultEnum resultEnum, Object object) {
		Result result = new Result();
		result.setCode(resultEnum.getCode());
		result.setMsg(resultEnum.getMsg());
		result.setData(object);
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static Result error(Integer code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);

		return result;
	}
}
