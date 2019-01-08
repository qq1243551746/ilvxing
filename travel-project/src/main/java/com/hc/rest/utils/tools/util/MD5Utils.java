package com.hc.rest.utils.tools.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hc.rest.utils.tools.constants.BasicCons;

/**
 * 采用MD5加密工具类
 * 
 * @author Justin Yang
 * @version 1.0
 * @since 2016-07-12
 *
 */
public class MD5Utils {
	private static Logger log = LoggerFactory.getLogger(MD5Utils.class);

	/**
	 * 根据密钥进行MD5加密
	 * 
	 * @param s
	 *            需要加密的字符串
	 * @return 加密后的字符串
	 */
	public final static String MD5Encrypt(String s) {
		char hexDigits[] = BasicCons.md5SecretKey.toCharArray();
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			log.info("MD5 encrypt has exception:", e);
			return null;
		}
	}

	public final static String MD5Encrypt(byte[] s) {
		char hexDigits[] = BasicCons.md5SecretKey.toCharArray();
		try {
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(s);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			log.info("MD5 encrypt has exception:", e);
			return null;
		}
	}

	public final static String MD5Encrypt(File f) {
		char hexDigits[] = BasicCons.md5SecretKey.toCharArray();
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(f, "r");

			byte[] buf = new byte[256];
			int read = -1;

			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");

			while ((read = raf.read(buf)) != -1) {
				// 使用指定的字节更新摘要
				mdInst.update(buf, 0, read);
			}

			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			log.info("MD5 encrypt has exception:", e);
			return null;
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(MD5Utils.MD5Encrypt("{\"appId\":\"ILorj0awFhox6DFoP2a0bo\",\"password\":\"e10adc3949ba59abbe56e057f20f883e\",\"cid\":\"d0471c6c8f4caaf580bfd33a462cd32b\",\"username\":\"17612222211\",\"appSecret\":\"ZWhmQbeAQVOuFJy4cltwje9CX4G14QFX\"}d0471c6c8f4caaf580bfd33a462cd32b"));
	}

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
}
