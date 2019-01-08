package com.hc.rest.utils.tools.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件相关辅助类
 * 
 * @author JustinYang
 * @version V1.0
 * @since 2016-07-05
 *
 */
public class FileUtils {
	private static Logger log = LoggerFactory.getLogger(FileUtils.class);

	/**
	 * 校验路径最后是否添加"/"
	 * 
	 * @param path
	 *            路径名
	 * @return 新路径
	 */
	public static String addPathLastString(String path) {
		if (!path.endsWith("/")) {
			path += File.separator;
		}
		return path;
	}

	/**
	 * 根据路径读取逐行读取文件内容，并存入list列表
	 * 
	 * @param path
	 *            文件路径
	 * @return 文件内容结果集
	 */
	public static List<String> getCreateTableSql(String path) {
		List<String> listContent = new ArrayList<String>();
		try {
			InputStream is = FileUtils.class.getResourceAsStream(path);
			String charset = "UTF-8";
			InputStreamReader inRead = new InputStreamReader(is, charset);
			BufferedReader reader = new BufferedReader(inRead);
			String tmp = "";

			while ((tmp = reader.readLine()) != null) {
				// 如果为空，或者没有数据，就不需要添加进去
				if (StringUtils.isBlank(tmp)) {
					continue;
				}
				listContent.add(tmp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listContent;
	}

	/**
	 * 判断文件的编码格式<br/>
	 * 只能判断文本文件
	 * 
	 * @param file
	 *            文本文件
	 * @return 编码
	 * @throws IOException
	 */
	public static String getCharset(File file) throws IOException {
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
		byte[] b = new byte[10];
		bin.read(b, 0, b.length);
		int i;
		StringBuffer buf = new StringBuffer("");
		int len = b.length;
		for (int offset = 0; offset < len; offset++) {
			i = b[offset];
			if (i < 0)
				i += 256;
			if (i < 16)
				buf.append("0");
			buf.append(Integer.toHexString(i));
		}
		String first = buf.toString().toUpperCase();
		// 这里可以看到各种编码的前几个字符是什么，gbk编码前面没有多余的
		String code = null;
		if (first.startsWith("EFBBBF")) {
			code = "UTF-8";
		} else if (first.startsWith("FEFF00")) {
			code = "UTF-16BE";
		} else if (first.startsWith("FFFE")) {
			code = "Unicode";
		} else if (first.startsWith("FFFE")) {
			code = "Unicode";
		} else {
			code = "GBK";
		}
		bin.close();
		return code;
	}

	/**
	 * 读取文件的内容，并进行转码
	 * 
	 * @param fileTxt
	 *            需要读取的文件
	 * @return
	 */
	public static List<String> getContentByReader(File file) {
		InputStream in = null;
		InputStreamReader inRead = null;
		BufferedReader reader = null;
		List<String> listContent = new ArrayList<String>();
		try {
			// 开始读取文件内容
			in = new FileInputStream(file);
			// 获取TXT本身的格式
			String charset = FileUtils.getCharset(file);
			inRead = new InputStreamReader(in, charset);
			reader = new BufferedReader(inRead);
			String tmp = "";
			while ((tmp = reader.readLine()) != null) {
				// 如果为空，或者没有数据，都不需要添加进去
				if (StringUtils.isBlank(tmp)) {
					continue;
				}

				listContent.add(tmp);
			}
		} catch (Exception e) {
			log.info("Get content by reader has exception:", e);
		} finally {
			try {
				reader.close();
				inRead.close();
				in.close();
			} catch (Exception e) {
				log.info("Close content by reader has exception:", e);
			}
		}
		return listContent;
	}

	public static byte[] base64ToBinary(String base64Str) {
		if (base64Str == null || "".equals(base64Str)) {
			return null;
		}
		try {
			byte[] b = Base64.decodeBase64(base64Str);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			return b;
		} catch (Exception e) {
			log.error("转二进制流异常：", e);
			return null;
		}
	}
}
