package com.hc.rest.utils.tools.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static SimpleDateFormat timeSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat dateSdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 计算当前时间是否在指定的时间范围之内
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return 是否在时间范围内
	 */
	public static boolean isInTime(String startTime, String endTime, Long calcTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String curTime = sdf.format(new Date(calcTime));
		try {
			long now = sdf.parse(curTime).getTime();
			long start = sdf.parse(startTime).getTime();
			long end = sdf.parse(endTime).getTime();
			if (endTime.equals("00:00")) {
				endTime = "24:00";
			}
			if (end < start) {
				if (now >= end && now < start) {
					return false;
				} else {
					return true;
				}
			} else {
				if (now >= start && now < end) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 获取当前字符串时间，格式为："yyyy-MM-dd HH:mm:ss"
	 * 
	 * @return 时间字符串
	 */
	public static String getNowStr() {
		return timeSdf.format(new Date());
	}

	public static String getDateStr() {
		return dateSdf.format(new Date());
	}

	public static String getDateyyyyMMhh() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		return sf.format(new Date());
	}

	/**
	 * 计算过期的日期
	 * 
	 * @param day
	 * @return
	 */
	public static Date getExpiresDate(int day) {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, day);
		return ca.getTime();
	}

	/**
	 * 计算开始时间到时间段结束时间的时间差
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param endHour
	 *            结束时间段
	 * @return 在时间段内的分钟数
	 * @throws Exception
	 *             异常信息
	 */
	public static Long getEndMinute(Long startTime, Long endTime, String endHour) throws Exception {
		String endStr = dateSdf.format(new Date(endTime));
		String hourStr = endStr + " " + endHour + ":00";
		long hour = timeSdf.parse(hourStr).getTime();
		long minute = (hour - startTime) / 60 * 1000;
		return minute;
	}

	/**
	 * 计算开始时间段到结束时间的时间差
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param startHourt
	 *            开始时间段
	 * @return 在时间段的分钟数
	 * @throws Exception
	 *             异常信息
	 */
	public static Long getStartMinute(Long startTime, Long endTime, String startHourt) throws Exception {
		String startStr = dateSdf.format(new Date(startTime));
		String hourStr = startStr + " " + startHourt + ":00";
		long hour = timeSdf.parse(hourStr).getTime();
		long minute = (endTime - hour) / 60 * 1000;
		return minute;
	}

	public static void main(String[] args) throws Exception {
		SimpleDateFormat timeSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(timeSdf.format(getNextMonth(2)));
	}

	/**
	 * 比较日期是否过期
	 * 
	 * @param cpExpiresDate
	 * @return
	 */
	public static boolean compareExpiresDate(Date cpExpiresDate) {
		long nowTime = System.currentTimeMillis();
		if (nowTime >= cpExpiresDate.getTime()) {
			return true;
		}
		return false;
	}

	public static String getNowMinute(long time) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(new Date(time));
	}

	public static Date getNextMonth(int i) {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.MONTH, i);
		return ca.getTime();
	}

	public static Long getNextMonthLong(int i) {
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.MONTH, i);
		return ca.getTime().getTime();
	}

	public static Integer getMonth() {
		SimpleDateFormat timeSdf = new SimpleDateFormat("yyyyMM");
		return Integer.parseInt(timeSdf.format(new Date()));
	}

	public static String getDate(Date date) {
		SimpleDateFormat timeSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return timeSdf.format(date);
	}

}