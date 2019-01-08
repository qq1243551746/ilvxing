package com.hc.rest.entity.planeticket;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itrip_FlightInformation")
public class FlightInformation implements Serializable{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "flId", columnDefinition = "int(10) not null COMMENT'航班号'")
	private Integer flId;

	@Column(name = "bunkType", columnDefinition = "int(10) not null COMMENT'机舱类型'")
	private Integer bunkType;

	@Column(name = "whetherSell", columnDefinition = "int(10) not null COMMENT'是否已出售'")
	private Integer whetherSell;

	@Column(name = "discount", columnDefinition = "varchar(40) not null COMMENT'折扣'")
	private String discount;

	@Column(name = "price", columnDefinition = "decimal(20) not null COMMENT'价格'")
	private Double price;

	@Column(name = "changeDate", columnDefinition = "varchar(40) not null COMMENT'改期类型'")
	private String changeDate;

	public FlightInformation() {
		super();
	}

	public FlightInformation(Integer id, Integer flId, Integer bunkType, Integer whetherSell, String discount, Double price, String changeDate) {
		super();
		this.id = id;
		this.flId = flId;
		this.bunkType = bunkType;
		this.whetherSell = whetherSell;
		this.discount = discount;
		this.price = price;
		this.changeDate = changeDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFlId() {
		return flId;
	}

	public void setFlId(Integer flId) {
		this.flId = flId;
	}

	public Integer getBunkType() {
		return bunkType;
	}

	public void setBunkType(Integer bunkType) {
		this.bunkType = bunkType;
	}

	public Integer getWhetherSell() {
		return whetherSell;
	}

	public void setWhetherSell(Integer whetherSell) {
		this.whetherSell = whetherSell;
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

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	@Override
	public String toString() {
		return "Airline [id=" + id + ", flId=" + flId + ", bunkType=" + bunkType + ", whetherSell=" + whetherSell + ", discount=" + discount + ", price=" + price + ", changeDate=" + changeDate + "]";
	}
	
	
	

}
