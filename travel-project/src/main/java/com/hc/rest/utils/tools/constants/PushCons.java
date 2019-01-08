package com.hc.rest.utils.tools.constants;

public enum PushCons {
	PASSENGER_CALL_CAR(60000, "实时普通单"), //
	PASSENGER_CANCEL_ORDER(60001, "乘客取消订单"), //
	DRIVER_ARRIVE_START_DESTINATION(60002, "司机已到达目的地"), //
	DRIVER_RECEIVED_PASSENGER(60003, "司机已接到乘客"), //
	DRIVER_ARRIVE_END_DESTINATION(60004, "已到达乘客目的地"), //
	DRIVER_REAL_PRICE(60005, "实时价格推送"), //
	DRIVER_CONFIRM_ACCOUNT(60006, "司机已经确认账单");
	private final int code;

	private final String msg;

	private PushCons(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
