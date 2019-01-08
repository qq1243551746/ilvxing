package com.hc.rest.oss.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.hc.rest.utils.ImageUtils;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;
import com.hc.rest.utils.StringBasicUtils;
import com.hc.rest.vo.ImageBase64Vo;

@Service
@Transactional
public class OssService {

	// endpoint以杭州为例，其它region请按实际情况填写。
	private String endpoint = "oss-cn-shenzhen.aliyuncs.com";
	// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
	private String accessKeyId = "LTAIIawIEPaLK2q7";
	private String accessKeySecret = "61nCBV11ZKOqc05U8buh3MM5a0oNEF";

	@SuppressWarnings({ "unchecked" })
	public Result<String> uploadBinary(HttpServletRequest request) throws Exception {
		Part part = request.getPart("image");
		String suffix = request.getParameter("suffix");
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		String fileName = StringBasicUtils.getRepUUID() + "." + suffix;
		// 上传文件流
		ossClient.putObject("travel-hc", fileName, part.getInputStream());
		// 关闭client
		ossClient.shutdown();
		return ResultUtil.getResult(ResultEnum.SUCCESS, fileName);
	}

	@SuppressWarnings({ "unchecked" })
	public Result<String> uploadBase64(ImageBase64Vo vo) {
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		String fileName = StringBasicUtils.getRepUUID() + "." + vo.getSuffix();
		// 上传文件流
		ossClient.putObject(vo.getTableName(), fileName, new ByteArrayInputStream(ImageUtils.base64ToImage(vo.getImage())));
		// 关闭client
		ossClient.shutdown();
		return ResultUtil.getResult(ResultEnum.SUCCESS, fileName);
	}

	@SuppressWarnings({ "unchecked" })
	public Result<String> downloadBase64(String objectName, String bucketName) throws Exception {
		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// ossObject实例包含文件所在的存储空间（Bucket）、文件的名称、Object Meta以及一个输入流。
		OSSObject ossObject = ossClient.getObject(bucketName, objectName);
		// 读Object内容。
		InputStream is = ossObject.getObjectContent();
		byte[] byt = new byte[is.available()];
		is.read(byt);
		String base64 = ImageUtils.imageToBase64(byt);
		return ResultUtil.getResult(ResultEnum.SUCCESS, base64);

	}

	public void downloadBinary(String objectName, String bucketName, HttpServletResponse response) throws Exception {
		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// ossObject实例包含文件所在的存储空间（Bucket）、文件的名称、Object Meta以及一个输入流。
		OSSObject ossObject = ossClient.getObject(bucketName, objectName);
		// 读Object内容。
		InputStream is = ossObject.getObjectContent();
		byte[] byt = new byte[is.available()];
		is.read(byt);
		OutputStream os = response.getOutputStream();// 获得servlet的servletoutputstream对象
		os.write(byt);
		os.close();
	}

}
