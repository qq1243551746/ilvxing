package com.hc.rest.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	/**
	 * 系统异常捕获
	 * 
	 * @param e
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if (e instanceof EirunyeException) {
			EirunyeException hxExpection = (EirunyeException) e;
			return ResultUtil.error(hxExpection.getCode(), hxExpection.getMessage());
		} else {
			logger.error("系统异常{}", e);
			return ResultUtil.error(-1, "unknow error");
		}

	}
}
