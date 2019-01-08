package com.hc.rest.entity.hotel;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 酒店表
 * @author yeung
 *
 */
@Entity
@Table(name = "itrip_hotel")
public class ItripHotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private  Integer id; //主键
	
	@Column(name="hotelName" , columnDefinition = "varchar(255) COMMENT '酒店名称'")
	private String hotelName; //酒店名称
	
	@Column(name="countryId", columnDefinition = "bigint(11) COMMENT '所在国家id'")
	private Integer countryId; //所在国家id
	
	@Column(name="provinceId", columnDefinition = "bigint(11) COMMENT '所在省份id'")
	private Integer provinceId; //所在省份id
	
	@Column(name="cityId", columnDefinition = "bigint(11) COMMENT '所在城市id'")
	private Integer cityId; //所在城市id
	
	@Column(name="address" , columnDefinition = "varchar(255) COMMENT '酒店所在地址'")
	private String address;//酒店所在地址
	
	@Column(name="details" , columnDefinition = "text COMMENT '酒店介绍'")
	private String details;//酒店介绍
	
	@Column(name="facilities" , columnDefinition = "text COMMENT '酒店设施'")
	private String facilities;//酒店设施
	
	@Column(name="hotelPolicy" , columnDefinition = "text COMMENT '酒店政策'")
	private String hotelPolicy;//酒店政策
	
	@Column(name="hotelType" , columnDefinition = "int(1) COMMENT '酒店类型(1:国内酒店 2:国际酒店)'")
	private Integer hotelType;//酒店类型(1:国内酒店 2:国际酒店)
	
	@Column(name="hotelLevel" , columnDefinition = "int(1) COMMENT '(1:经济酒店 2:二星级酒店 3:三星级 4:四星酒店 5星酒店)'")
	private Integer hotelLevel;//(1:经济酒店 2:二星级酒店 3:三星级 4:四星酒店 5星酒店)
	
	@Column(name="isGroupPurchase" , columnDefinition = "int(1) COMMENT '是否是团购酒店'")
	private Integer isGroupPurchase;//是否是团购酒店
	
	@Column(name="redundantCityName" , columnDefinition = "varchar(255) COMMENT '城市名称 冗余字段'")
	private String redundantCityName;//城市名称
	
	@Column(name="redundantProvinceName" , columnDefinition = "varchar(255) COMMENT '省名称 冗余字段'")
	private String redundantProvinceName;//省名称
	
	@Column(name="redundantCountryName" , columnDefinition = "varchar(255) COMMENT '国家名称 冗余字段'")
	private String redundantCountryName;//国家名称
	
	@Column(name="redundantHotelStore" , columnDefinition = "int(22) COMMENT '酒店库存（冗余，每天开定时任务的时候更新）'")
	private Integer redundantHotelStore;//酒店库存
	
	@Column(name="creationDate", columnDefinition = "datetime")
	private Date creationDate; 
	
	@Column(name="createdBy", columnDefinition = "bigint(11)")
	private Integer createdBy;
	
	@Column(name="modifyDate", columnDefinition = "datetime")
	private Date modifyDate;
	
	@Column(name="modifiedBy", columnDefinition = "bigint(11)")
	private Integer modifiedBy;
	
	@Column(name = "create_time", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
	private Date createTime; // 创建时间

	@Column(name = "update_time", columnDefinition = "datetime DEFAULT NULL COMMENT '更新时间'")
	private Date updateTime;// 更新时间

	public ItripHotel() {
		super();
	}

	public ItripHotel(Integer id, String hotelName, Integer countryId, Integer provinceId, Integer cityId,
			String address, String details, String facilities, String hotelPolicy, Integer hotelType,
			Integer hotelLevel, Integer isGroupPurchase, String redundantCityName, String redundantProvinceName,
			String redundantCountryName, Integer redundantHotelStore, Date creationDate, Integer createdBy,
			Date modifyDate, Integer modifiedBy, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.countryId = countryId;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.address = address;
		this.details = details;
		this.facilities = facilities;
		this.hotelPolicy = hotelPolicy;
		this.hotelType = hotelType;
		this.hotelLevel = hotelLevel;
		this.isGroupPurchase = isGroupPurchase;
		this.redundantCityName = redundantCityName;
		this.redundantProvinceName = redundantProvinceName;
		this.redundantCountryName = redundantCountryName;
		this.redundantHotelStore = redundantHotelStore;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.modifyDate = modifyDate;
		this.modifiedBy = modifiedBy;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getHotelPolicy() {
		return hotelPolicy;
	}

	public void setHotelPolicy(String hotelPolicy) {
		this.hotelPolicy = hotelPolicy;
	}

	public Integer getHotelType() {
		return hotelType;
	}

	public void setHotelType(Integer hotelType) {
		this.hotelType = hotelType;
	}

	public Integer getHotelLevel() {
		return hotelLevel;
	}

	public void setHotelLevel(Integer hotelLevel) {
		this.hotelLevel = hotelLevel;
	}

	public Integer getIsGroupPurchase() {
		return isGroupPurchase;
	}

	public void setIsGroupPurchase(Integer isGroupPurchase) {
		this.isGroupPurchase = isGroupPurchase;
	}

	public String getRedundantCityName() {
		return redundantCityName;
	}

	public void setRedundantCityName(String redundantCityName) {
		this.redundantCityName = redundantCityName;
	}

	public String getRedundantProvinceName() {
		return redundantProvinceName;
	}

	public void setRedundantProvinceName(String redundantProvinceName) {
		this.redundantProvinceName = redundantProvinceName;
	}

	public String getRedundantCountryName() {
		return redundantCountryName;
	}

	public void setRedundantCountryName(String redundantCountryName) {
		this.redundantCountryName = redundantCountryName;
	}

	public Integer getRedundantHotelStore() {
		return redundantHotelStore;
	}

	public void setRedundantHotelStore(Integer redundantHotelStore) {
		this.redundantHotelStore = redundantHotelStore;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "ItripHotel [id=" + id + ", hotelName=" + hotelName + ", countryId=" + countryId + ", provinceId="
				+ provinceId + ", cityId=" + cityId + ", address=" + address + ", details=" + details + ", facilities="
				+ facilities + ", hotelPolicy=" + hotelPolicy + ", hotelType=" + hotelType + ", hotelLevel="
				+ hotelLevel + ", isGroupPurchase=" + isGroupPurchase + ", redundantCityName=" + redundantCityName
				+ ", redundantProvinceName=" + redundantProvinceName + ", redundantCountryName=" + redundantCountryName
				+ ", redundantHotelStore=" + redundantHotelStore + ", creationDate=" + creationDate + ", createdBy="
				+ createdBy + ", modifyDate=" + modifyDate + ", modifiedBy=" + modifiedBy + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
	
	
}
