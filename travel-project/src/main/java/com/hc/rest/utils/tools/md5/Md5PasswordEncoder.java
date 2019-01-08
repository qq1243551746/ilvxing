package com.hc.rest.utils.tools.md5;

public class Md5PasswordEncoder extends MessageDigestPasswordEncoder {

	public Md5PasswordEncoder() {
		super("MD5");
	}

	public static String encode(String pass, String salt) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		return encoder.encodePassword(pass, salt);
	}
}
