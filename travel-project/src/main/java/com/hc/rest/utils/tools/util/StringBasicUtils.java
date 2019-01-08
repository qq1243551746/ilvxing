package com.hc.rest.utils.tools.util;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class StringBasicUtils {
	/**
	 * 随机生成指定字符串
	 * 
	 * @param length
	 *            字符串长度
	 * @return 随机生成字符串
	 */
	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 数字生成随机字符串<br/>
	 * &nbsp;&nbsp;1.需要指定长度生成，默认为16位长度； <br/>
	 * &nbsp;&nbsp;2.随机生成字符串规则，需要根据指定加密基数
	 * 
	 */
	public static String getRandomNum() { // length表示生成字符串的长度
		String base = "0123456789";
		return randomStr(0, base);
	}

	/**
	 * 小写、数字生成随机字符串<br/>
	 * &nbsp;&nbsp;1.需要指定长度生成，默认为16位长度； <br/>
	 * &nbsp;&nbsp;2.随机生成字符串规则，需要根据指定加密基数
	 * 
	 */
	public static String getRandomLower() { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		return randomStr(0, base);
	}

	/**
	 * 大写、小写、数字生成随机字符串<br/>
	 * &nbsp;&nbsp;1.需要指定长度生成，默认为16位长度； <br/>
	 * &nbsp;&nbsp;2.随机生成字符串规则，需要根据指定加密基数
	 * 
	 */
	public static String getRandomUpper() { // length表示生成字符串的长度
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		return randomStr(0, base);
	}

	/**
	 * 特殊字符串、大写、小写、数字生成随机字符串<br/>
	 * &nbsp;&nbsp;1.需要指定长度生成，默认为16位长度； <br/>
	 * &nbsp;&nbsp;2.随机生成字符串规则，需要根据指定加密基数
	 * 
	 */
	public static String getRandomSpecial() { // length表示生成字符串的长度
		String base = "!@#$%^&*ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		return randomStr(0, base);
	}

	/**
	 * 数字生成随机字符串<br/>
	 * &nbsp;&nbsp;1.需要指定长度生成，默认为16位长度； <br/>
	 * &nbsp;&nbsp;2.随机生成字符串规则，需要根据指定加密基数
	 * 
	 */
	public static String getRandomNum(int length) { // length表示生成字符串的长度
		String base = "0123456789";
		return randomStr(length, base);
	}

	/**
	 * 小写、数字生成随机字符串<br/>
	 * &nbsp;&nbsp;1.需要指定长度生成，默认为16位长度； <br/>
	 * &nbsp;&nbsp;2.随机生成字符串规则，需要根据指定加密基数
	 * 
	 */
	public static String getRandomLower(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		return randomStr(length, base);
	}

	/**
	 * 大写、小写、数字生成随机字符串<br/>
	 * &nbsp;&nbsp;1.需要指定长度生成，默认为16位长度； <br/>
	 * &nbsp;&nbsp;2.随机生成字符串规则，需要根据指定加密基数
	 * 
	 */
	public static String getRandomUpper(int length) { // length表示生成字符串的长度
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		return randomStr(length, base);
	}

	/**
	 * 特殊字符串、大写、小写、数字生成随机字符串<br/>
	 * &nbsp;&nbsp;1.需要指定长度生成，默认为16位长度； <br/>
	 * &nbsp;&nbsp;2.随机生成字符串规则，需要根据指定加密基数
	 * 
	 */
	public static String getRandomSpecial(int length) { // length表示生成字符串的长度
		String base = "!@#$%^&*ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		return randomStr(length, base);
	}

	/**
	 * 随机生成字符串
	 * 
	 * @param length
	 * @param base
	 * @return
	 */
	private static String randomStr(int length, String base) {
		if (length == 0) {
			length = 16;
		}
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getRandomSpecial(16));
	}

	/**
	 * <p>
	 * Checks if a CharSequence is whitespace, empty ("") or null.
	 * </p>
	 *
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * StringUtils.isBlank("  null  ") = true
	 * </pre>
	 *
	 * @param cs
	 *            the CharSequence to check, may be null
	 * @return {@code true} if the CharSequence is null, empty or whitespace
	 * @since 2.0
	 * @since 3.0 Changed signature from isBlank(String) to isBlank(CharSequence)
	 */
	public static boolean isBlank(String string) {
		if (StringUtils.isBlank(string) || string.equalsIgnoreCase("null")) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Title: isContainChinese @Description: 判断字符串里面是否含有中文 @param @param str @param @return 设定文件 @return boolean 返回类型 @throws
	 */
	public static boolean isContainChinese(String str) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}

	public static String getRepUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}

	/**
	 * 将经纬度的字符串转换为double数组
	 * 
	 * @param position
	 *            字符串
	 * @return 经纬度坐标数组
	 */
	public static double[] changePosition(String position) {
		String[] temp = position.split(",");
		double[] response = new double[] { new BigDecimal(temp[0]).doubleValue(), new BigDecimal(temp[1]).doubleValue() };
		return response;
	}

	/**
	 * 将经纬度的字符串转换为double数组
	 * 
	 * @param position
	 *            字符串
	 * @return 经纬度坐标数组
	 */
	public static double[] changePosition1(String position) {
		String[] temp = position.split(",");
		double[] response = new double[] { new BigDecimal(temp[0]).doubleValue() };
		return response;
	}

	/**
	 * 将经纬度的double转换为字符串
	 * 
	 * @param position
	 *            字符串
	 * @return 经纬度坐标数组
	 */
	public static String changePosition(double[] position) {
		return position[0] + "," + position[1];
	}
}
