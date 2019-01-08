package com.hc.rest.entity.room;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 保险表
 * @author LCL
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "itrip_insurance")
public class ItripInsurance implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer id;   //主键
	
	@Column(name="payMoney", columnDefinition = "decimal(20) COMMENT '支付金额'")
	private Double payMoney; //支付金额
	
	@Column(name="type", columnDefinition = "int(20) COMMENT '保险种类(1、普通版 2、标准版 3、尊贵版)'")
	private Integer type; //保险种类
	
	@Column(name="number", columnDefinition = "decimal(20) COMMENT '份数'")
	private Integer number; //份数

	public ItripInsurance() {
	}

	public ItripInsurance(Integer id, Double payMoney, Integer type, Integer number) {
		super();
		this.id = id;
		this.payMoney = payMoney;
		this.type = type;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "ItripInsurance [id=" + id + ", payMoney=" + payMoney + ", type=" + type + ", number=" + number;
	}
	
}
