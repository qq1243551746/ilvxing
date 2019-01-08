package com.hc.rest.utils;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class OrderNumber {
	
	/**
	 * 订单号
	 * @param id 传入用户ID 用户拼接到最后
	 * @return 返回订单号
	 */
	public String getNumber(Integer id) {
		String NumberStr = "HC-000";
		Long count;
		Date date = new Date();
		count = date.getTime();
		count *= 10000;
		count += 1;
		NumberStr += count.toString();
		NumberStr += id.toString();
		return NumberStr;
	}
	
	/**
	 * 计算时间天数差
	 * @param currentDate 
	 * @param endOutDate
	 * @return 返回天数
	 */
	public int calculateTimeDifferenceBySimpleDateFormat(Date currentDate,Date endOutDate) {
		Long curDate = currentDate.getTime();
		Long endDate = endOutDate.getTime();
		int day = (int) ((endDate - curDate) / (1000 * 60 * 60 * 24));
		return day;
	}
	
}
