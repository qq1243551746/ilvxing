package com.hc.rest.vo.airticket;

public class ManageFlightInforVo {

	private String staciry;
	private String tarrcity;
	private String endingTime;
	private String startingTime;
	private String discount;
	private Double price;
	private Integer number;

	public ManageFlightInforVo() {
		super();
	}

	public ManageFlightInforVo(String staciry, String tarrcity, String endingTime, String startingTime, String discount, Double price, Integer number) {
		super();
		this.staciry = staciry;
		this.tarrcity = tarrcity;
		this.endingTime = endingTime;
		this.startingTime = startingTime;
		this.discount = discount;
		this.price = price;
		this.number = number;
	}

	public String getStaciry() {
		return staciry;
	}

	public void setStaciry(String staciry) {
		this.staciry = staciry;
	}

	public String getTarrcity() {
		return tarrcity;
	}

	public void setTarrcity(String tarrcity) {
		this.tarrcity = tarrcity;
	}

	public String getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(String endingTime) {
		this.endingTime = endingTime;
	}

	public String getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
