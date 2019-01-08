package com.hc.rest.utils.md5;

import com.hc.rest.utils.tools.md5.Md5PasswordEncoder;
import com.hc.rest.utils.tools.util.MD5Utils;

public class MD5Test {
	public static void main(String[] args) {
		String string = "lk123456";
		String encrypt = MD5Utils.MD5Encrypt(string);
		System.out.println("MD5" + encrypt);

		String salt = "14b02f67-ae0c-4d23-96d8-a3b0f72f0b0e";
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String encodersalt = encoder.encodePassword(encrypt, salt);
		System.out.println(encodersalt);

	}
}
