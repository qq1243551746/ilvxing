package com.hc.rest.utils.tools.util;

public class MapUtils {
	/**
	 * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
	 * 
	 */
	public static double getDistance(double[] position1, double[] position2) {
		double radLat1 = rad(position1[1]);
		double radLat2 = rad(position2[1]);
		double a = radLat1 - radLat2;
		double b = rad(position1[0]) - rad(position2[0]);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * 6378137;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	public static double rad(double d) {
		return d * Math.PI / 180.0;
	}
}
