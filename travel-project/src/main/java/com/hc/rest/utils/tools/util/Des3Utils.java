
package com.hc.rest.utils.tools.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import com.hc.rest.utils.tools.constants.BasicCons;

/**
 * 采用Des3加密解密工具类
 * 
 * @author Justin Yang
 * @version 1.0
 * @since 2016-07-12
 *
 */
public class Des3Utils {

	private static Logger log = LoggerFactory.getLogger(Des3Utils.class);

	public static void main(String[] args) {
		String des = encrypt("123456");
		System.out.println(des);
		System.out.println(decrypt(des));
	}

	/**
	 * 加密，将字符串进行加密
	 * 
	 * @param str
	 *            等待加密的字符串
	 * @return 加密以后的字符串
	 */
	public static String encrypt(String str) {
		return encrypt(str, BasicCons.des3SecretKey, BasicCons.des3Parameter);
	}

	/**
	 * 解密，将字符串进行解密
	 * 
	 * @param str
	 *            加过密的字符串
	 * @return 解密后的字符串
	 */
	public static String decrypt(String str) {
		return decrypt(str, BasicCons.des3SecretKey, BasicCons.des3Parameter);
	}

	/**
	 * 加密，将字符串进行加密
	 * 
	 * @param str
	 *            等待加密的字符串
	 * @param desedeKey
	 *            密钥
	 * @param ivParameters
	 *            CBS初始化参数
	 * @return 加密以后的字符串
	 */
	public static String encrypt(String str, String desedeKey, String ivParameters) {
		String new_str = null;
		byte[] old_str = null;
		try {
			// 创建一个密钥
			byte[] encryptKey = desedeKey.getBytes();
			// 为上一密钥创建一个指定的 DESSede key
			DESedeKeySpec spec = new DESedeKeySpec(encryptKey);
			// 得到 DESSede keys
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
			// 生成一个 DESede 密钥对象
			SecretKey theKey = keyFactory.generateSecret(spec);
			// 创建一个 DESede 密码
			Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			// 为 CBC 模式创建一个用于初始化的 vector 对象
			IvParameterSpec IvParameters = new IvParameterSpec(ivParameters.getBytes());
			// 以加密模式初始化密钥
			cipher.init(Cipher.ENCRYPT_MODE, theKey, IvParameters);
			// 加密前的字符串
			byte[] plainttext = str.getBytes();
			// 加密密码
			old_str = cipher.doFinal(plainttext);
			// 转成字符串，得到加密后的密码（新）
			new_str = new String(Base64Utils.encode(old_str));
		} catch (Exception e) {
			// 记录加密错误
			log.info("DES3 encrypt has exception:", e);
		}
		return new_str;
	}

	/**
	 * 解密，将字符串进行解密
	 * 
	 * @param str
	 *            加过密的字符串
	 * @param desedeKey
	 *            密钥
	 * @param ivParameters
	 *            CBS初始化参数
	 * @return 解密后的字符串
	 */
	public static String decrypt(String str, String desedeKey, String ivParameters) {
		String new_str = null;
		try {
			// 创建一个密钥
			byte[] encryptKey = desedeKey.getBytes();
			// 为上一密钥创建一个指定的 DESSede key
			DESedeKeySpec spec = new DESedeKeySpec(encryptKey);
			// 得到 DESSede keys
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
			// 生成一个 DESede 密钥对象
			SecretKey theKey = keyFactory.generateSecret(spec);
			// 创建一个 DESede 密码
			Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			// 为 CBC 模式创建一个用于初始化的 vector 对象
			IvParameterSpec IvParameters = new IvParameterSpec(ivParameters.getBytes());
			// 以解密模式初始化密钥
			cipher.init(Cipher.DECRYPT_MODE, theKey, IvParameters);
			// 构造解密前的密码
			byte[] decryptedPassword = Base64Utils.decode(str.getBytes());
			// 解密密码
			byte[] decrypted_pwd = cipher.doFinal(decryptedPassword);
			// 得到结果
			new_str = new String(decrypted_pwd);
		} catch (Exception e) {
			// 记录解密错误
			log.info("DES3 decrypt has exception:", e);
		}
		return new_str;
	}

}
