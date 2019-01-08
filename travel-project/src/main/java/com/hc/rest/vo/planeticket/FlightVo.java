package com.hc.rest.vo.planeticket;

import java.sql.Date;
import java.util.List;

import com.hc.rest.entity.planeticket.FlightInformation;

public class FlightVo {
	
	private String name;
	
	private Integer id;
	
	private Integer airId;
	
	private Integer company;
	
	private String staciry;
	
	private String tarrcity;
	
	private Date startingTime;
	
	private Date endingTime;
	
	private Integer flightType;
	
	private String flightName;
	
	private String startAriport;
	
	private String arrivingAirport;
	
	private Integer limitCusmnum;
	
	private Integer presentCusmnun;
	
	private Double oneWayPrice;
	
	private Integer bunkType;
	
	private Integer pageIndex;
	
	private Integer pageSize;
	
	private Integer diffhour;
	
	private Integer diffminute; 
	
	private String startime;
	
	private String endtime;
	
	private List<FlightInformation> flightInformations;
	
	public FlightVo() {
	}

	public FlightVo(String name, Integer id, Integer airId, Integer company, String staciry, String tarrcity,
			Date startingTime, Date endingTime, Integer flightType, String flightName, String startAriport,
			String arrivingAirport, Integer limitCusmnum, Integer presentCusmnun, Double oneWayPrice, Integer bunkType,
			Integer pageIndex, Integer pageSize, Integer diffhour, Integer diffminute, String startime, String endtime,
			List<FlightInformation> flightInformations) {
		this.name = name;
		this.id = id;
		this.airId = airId;
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
		this.bunkType = bunkType;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.diffhour = diffhour;
		this.diffminute = diffminute;
		this.startime = startime;
		this.endtime = endtime;
		this.flightInformations = flightInformations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAirId() {
		return airId;
	}

	public void setAirId(Integer airId) {
		this.airId = airId;
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

	public Integer getBunkType() {
		return bunkType;
	}

	public void setBunkType(Integer bunkType) {
		this.bunkType = bunkType;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getDiffhour() {
		return diffhour;
	}

	public void setDiffhour(Integer diffhour) {
		this.diffhour = diffhour;
	}

	public Integer getDiffminute() {
		return diffminute;
	}

	public void setDiffminute(Integer diffminute) {
		this.diffminute = diffminute;
	}

	public String getStartime() {
		return startime;
	}

	public void setStartime(String startime) {
		this.startime = startime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public List<FlightInformation> getFlightInformations() {
		return flightInformations;
	}

	public void setFlightInformations(List<FlightInformation> flightInformations) {
		this.flightInformations = flightInformations;
	}

	@Override
	public String toString() {
		return "FlightVo [name=" + name + ", id=" + id + ", airId=" + airId + ", company=" + company + ", staciry="
				+ staciry + ", tarrcity=" + tarrcity + ", startingTime=" + startingTime + ", endingTime=" + endingTime
				+ ", flightType=" + flightType + ", flightName=" + flightName + ", startAriport=" + startAriport
				+ ", arrivingAirport=" + arrivingAirport + ", limitCusmnum=" + limitCusmnum + ", presentCusmnun="
				+ presentCusmnun + ", oneWayPrice=" + oneWayPrice + ", bunkType=" + bunkType + ", pageIndex="
				+ pageIndex + ", pageSize=" + pageSize + ", diffhour=" + diffhour + ", diffminute=" + diffminute
				+ ", startime=" + startime + ", endtime=" + endtime + ", flightInformations=" + flightInformations
				+ "]";
	}
	

}