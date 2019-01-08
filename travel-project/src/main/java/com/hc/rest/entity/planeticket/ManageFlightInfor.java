package com.hc.rest.entity.planeticket;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 航班信息类
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "itrip_manageFlightInfor")
public class ManageFlightInfor implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "company", columnDefinition = "int(10) not null COMMENT'航空公司'")
	private Integer company;

	@Column(name = "staciry", columnDefinition = "varchar(40) not null COMMENT'始发城市'")
	private String staciry;

	@Column(name = "tarrcity", columnDefinition = "varchar(40) not null COMMENT'目的城市'")
	private String tarrcity;

	@Column(name = "startingTime", columnDefinition = "datetime not null COMMENT'出发时间'")
	private Date startingTime;

	@Column(name = "endingTime", columnDefinition = "datetime not null COMMENT'到达时间'")
	private Date endingTime;

	@Column(name = "flightType", columnDefinition = "int(10) not null COMMENT'飞机类型'")
	private Integer flightType;// 1、中型机 2、大型机

	@Column(name = "flightName", columnDefinition = "varchar(40) not null COMMENT'飞机名称'")
	private String flightName;

	@Column(name = "startAriport", columnDefinition = "varchar(40) not null COMMENT'始发机场'")
	private String startAriport;

	@Column(name = "arrivingAirport", columnDefinition = "varchar(40) not null COMMENT'目的机场'")
	private String arrivingAirport;

	@Column(name = "limitCusmnum", columnDefinition = "int(10) not null COMMENT'限载旅客数量'")
	private Integer limitCusmnum;// 1、中型机 2、大型机

	@Column(name = "presentCusmnun", columnDefinition = "int(10) not null COMMENT'目前旅客数量'")
	private Integer presentCusmnun;// 1、中型机 2、大型机

	@Column(name = "oneWayPrice", columnDefinition = "decimal(20) not null COMMENT'机票基础价格'")
	private Double oneWayPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompany() {
		return company;
	}

	public void setCompany(Integer company) {
		this.company = company;
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

	public Date getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(Date startingTime) {
		this.startingTime = startingTime;
	}

	public Date getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(Date endingTime) {
		this.endingTime = endingTime;
	}

	public Integer getFlightType() {
		return flightType;
	}

	public void setFlightType(Integer flightType) {
		this.flightType = flightType;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getStartAriport() {
		return startAriport;
	}

	public void setStartAriport(String startAriport) {
		this.startAriport = startAriport;
	}

	public String getArrivingAirport() {
		return arrivingAirport;
	}

	public void setArrivingAirport(String arrivingAirport) {
		this.arrivingAirport = arrivingAirport;
	}

	public Integer getLimitCusmnum() {
		return limitCusmnum;
	}

	public void setLimitCusmnum(Integer limitCusmnum) {
		this.limitCusmnum = limitCusmnum;
	}

	public Integer getPresentCusmnun() {
		return presentCusmnun;
	}

	public void setPresentCusmnun(Integer presentCusmnun) {
		this.presentCusmnun = presentCusmnun;
	}

	public Double getOneWayPrice() {
		return oneWayPrice;
	}

	public void setOneWayPrice(Double oneWayPrice) {
		this.oneWayPrice = oneWayPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ManageFlightInfor(Integer id, Integer company, String staciry, String tarrcity, Date startingTime, Date endingTime, Integer flightType, String flightName, String startAriport, String arrivingAirport, Integer limitCusmnum, Integer presentCusmnun, Double oneWayPrice) {
		super();
		this.id = id;
		this.company = company;
		this.staciry = staciry;
		this.tarrcity = tarrcity;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.flightType = flightType;
		this.flightName = flightName;
		this.startAriport = startAriport;
		this.arrivingAirport = arrivingAirport;
		this.limitCusmnum = limitCusmnum;
		this.presentCusmnun = presentCusmnun;
		this.oneWayPrice = oneWayPrice;
	}

	public ManageFlightInfor() {
		super();
	}

	@Override
	public String toString() {
		return "ManageFlightInfor [id=" + id + ", company=" + company + ", staciry=" + staciry + ", tarrcity=" + tarrcity + ", startingTime=" + startingTime + ", endingTime=" + endingTime + ", flightType=" + flightType + ", flightName=" + flightName + ", startAriport=" + startAriport
				+ ", arrivingAirport=" + arrivingAirport + ", limitCusmnum=" + limitCusmnum + ", presentCusmnun=" + presentCusmnun + ", oneWayPrice=" + oneWayPrice + "]";
	}

}