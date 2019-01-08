package com.hc.rest.test;

import com.hc.rest.utils.tools.md5.Md5PasswordEncoder;
import com.hc.rest.utils.tools.util.MD5Utils;

public class MD5Test {
	public static void main(String[] args) {
		String string = "123456";
		String encrypt = MD5Utils.MD5Encrypt(string);
		System.out.println("MD5" + encrypt);

		String salt = "9b17fa5e30f8424d8631fa9a6da7d2b5";
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String encodersalt = encoder.encodePassword(encrypt, salt);
		System.out.println(encodersalt);

	}
}
