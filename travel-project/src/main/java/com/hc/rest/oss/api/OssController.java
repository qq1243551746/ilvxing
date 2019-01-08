package com.hc.rest.oss.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.oss.service.OssService;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;
import com.hc.rest.vo.ImageBase64Vo;

@RestController
@RequestMapping("/alioss")
public class OssController {

	private Logger log = LoggerFactory.getLogger(OssController.class);

	@Autowired
	private OssService ossService;

	/**
	 * 带参数上传图片-二进制流方式
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/uploadBinary")
	public Result<String> uploadBinary(HttpServletRequest request) {
		System.out.println("进来");
		try {
			return ossService.uploadBinary(request);
		} catch (Exception e) {
			log.error("带参数的二进制流上传，异常：", e);
			return ResultUtil.getResult(ResultEnum.UNKNOWN_ERROR, "带参数的二进制流上传，异常");
		}
	}

	/**
	 * 上传base64图片
	 */
	@PostMapping("/uploadBase64")
	public Result<String> uploadBase64(ImageBase64Vo vo) {
		vo.setTableName("nineline-goods");
		return ossService.uploadBase64(vo);
	}

	/**
	 * 下载base64图片
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/downloadBase64", method = { RequestMethod.POST, RequestMethod.GET })
	public Result<String> downloadBase64(String id) {
		try {
			return ossService.downloadBase64(id, "nineline-goods");
		} catch (Exception e) {
			log.error("带参数的二进制流上传，异常：", e);
			return ResultUtil.getResult(ResultEnum.UNKNOWN_ERROR, "带参数的二进制流上传，异常");
		}
	}

	/**
	 * 下载二进制流图片
	 */
	@RequestMapping(value = "/downloadBinary", method = { RequestMethod.POST, RequestMethod.GET })
	public void downloadBinary(String id, HttpServletResponse response) throws Exception {
		ossService.downloadBinary(id, "nineline-goods", response);
	}
}
