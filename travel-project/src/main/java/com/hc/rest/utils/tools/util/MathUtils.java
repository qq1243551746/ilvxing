package com.hc.rest.utils.tools.util;

public class MathUtils {

	/**
	 * 将价格转换为long类型
	 * 
	 * @param price
	 * @return
	 */
	public static long priceDoubleToLong(double price) {
		long realPrice = Math.round(price * 100);
		return realPrice;
	}

	/**
	 * 将long类型的jiage精确到小数点后2两位
	 * 
	 * @param price
	 *            long类型的价格
	 * @return 计算后的价格
	 */
	public static String priceLongToString(long price) {
		String realPrice = price + "";
		if (realPrice.length() >= 3) {
			realPrice = realPrice.substring(0, realPrice.length() - 2) + "." + realPrice.substring(realPrice.length() - 2, realPrice.length());
		} else if (realPrice.length() == 2) {
			realPrice = "0." + realPrice;
		} else {
			realPrice = "0.0" + realPrice;
		}
		return realPrice;
	}

	public static void main(String[] args) {
		System.out.println(priceLongToString(238923));
	}
}
