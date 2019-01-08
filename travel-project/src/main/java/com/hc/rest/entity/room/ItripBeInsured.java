package com.hc.rest.entity.room;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 被保险人表
 * @author LCL
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "itrip_beinsured")
public class ItripBeInsured implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;   //主键
	
	@Column(name="insurerName", columnDefinition = "varchar(20) COMMENT '被保险人姓名'")
	private String insurerName; //被保险人姓名
	
	@Column(name="insurerCard", columnDefinition = "varchar(20) COMMENT '被保险人身份证'")
	private String insurerCard; //被保险人身份证
	
	@Column(name="insurerPhone", columnDefinition = "varchar(20) COMMENT '被保险人手机号码'")
	private String insurerPhone; //手机号码

	@Column(name="surId", columnDefinition = "int  COMMENT '保险表外键'")
	private Integer surId;//保险表外键

	
	public ItripBeInsured() {
		 
	}
	
	public ItripBeInsured(Integer id, String insurerName, String insurerCard, String insurerPhone, Integer surId) {
		this.id = id;
		this.insurerName = insurerName;
		this.insurerCard = insurerCard;
		this.insurerPhone = insurerPhone;
		this.surId = surId;
	}
	
	public Integer getId() {
		return id;
	} 
	public void setId(Integer id) {
		this.id = id;
	} 
	public String getInsurerName() {
		return insurerName;
	} 
	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	} 
	public String getInsurerCard() {
		return insurerCard;
	} 
	public void setInsurerCard(String insurerCard) {
		this.insurerCard = insurerCard;
	} 
	public String getInsurerPhone() {
		return insurerPhone;
	} 
	public void setInsurerPhone(String insurerPhone) {
		this.insurerPhone = insurerPhone;
	} 
	public Integer getSurId() {
		return surId;
	} 
	public void setSurId(Integer surId) {
		this.surId = surId;
	} 
	@Override
	public String toString() {
		return "ItripBeInsured [id=" + id + ", insurerName=" + insurerName + ", insurerCard=" + insurerCard
				+ ", insurerPhone=" + insurerPhone + ", surId=" + surId + "]";
	}
	
}
