package com.hc.rest.entity.room;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 酒店房间表
 * @author LCL
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "itrip_hotel_room")
public class ItripHotelRoom implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer id;   //主键
	 
	@Column(name="hotelId", columnDefinition = "bigint(11) COMMENT '酒店ID'")
	private Integer hotelId; //酒店ID
	
	@Column(name="roomTitle" , columnDefinition = "varchar(255) COMMENT '房间名称'")
	private String roomTitle; // 房间名称
	
	@Column(name="roomPrice" , columnDefinition = "decimal(20)  COMMENT '房间价格'")
	private Double roomPrice; // 房间价格
		
	@Column(name="roomBedTypeId" , columnDefinition = "bigint(11) COMMENT '酒店床型'")
	private Integer roomBedTypeId; //酒店床型
	
	@Column(name="isHavingBreakfast", columnDefinition = "int(255) COMMENT '是否包含早餐'")
	private Integer isHavingBreakfast; //是否包含早餐
	
	@Column(name="payType", columnDefinition = "int(1) COMMENT'1:在线付 2:到店付 3:不限'")
	private Integer payType; //1:在线付 2:到店付 3:不限
	
	@Column(name="satisfaction", columnDefinition = "decimal(11) COMMENT '满意度（冗余字段，在用户评论后更新）'")
	private Double satisfaAtion; //满意度（冗余字段，在用户评论后更新）
	
	@Column(name="isBook", columnDefinition = "int(1) COMMENT '是否可预订(0:不可以 1:可以)'")
	private Integer isBook; //是否可预订(0:不可以 1:可以)
	
	@Column(name="isCancel", columnDefinition = "int(1) COMMENT '是否可取消(0:不可 1:可以)'")
	private Integer isCancel; //是否可取消(0:不可 1:可以)
	
	@Column(name="isTimelyResponse", columnDefinition = "int(11) COMMENT '是否可取消(0:不可 1:可以)'")
	private Integer isTimelyResponse; //是否及时响应(0:不及时 1:及时)
	
	@Column(name="creationDate", columnDefinition = "datetime  COMMENT '入住时间'")
	private Date creationDate; //入住时间
	
	@Column(name="createdBy", columnDefinition = "bigint(11)")
	private Integer createdBy;
	
	@Column(name="modifyDate", columnDefinition = "datetime  COMMENT '退房时间'")
	private Date modifyDate;//退房时间
	
	@Column(name="modifiedBy", columnDefinition = "bigint(11)")
	private Integer modifiedBy;
	
	@Column(name = "create_time", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
	private Date createTime; // 创建时间

	@Column(name = "update_time", columnDefinition = "datetime DEFAULT NULL COMMENT '更新时间'")
	private Date updateTime;// 更新时间
	
	
	public ItripHotelRoom() {
	}
	 

	public ItripHotelRoom(Integer id, Integer hotelId, String roomTitle, Double roomPrice, Integer roomBedTypeId,
			Integer isHavingBreakfast, Integer payType, Double satisfaAtion, Integer isBook, Integer isCancel,
			Integer isTimelyResponse, Date creationDate, Integer createdBy, Date modifyDate, Integer modifiedBy,
			Date createTime, Date updateTime) {
		this.id = id;
		this.hotelId = hotelId;
		this.roomTitle = roomTitle;
		this.roomPrice = roomPrice;
		this.roomBedTypeId = roomBedTypeId;
		this.isHavingBreakfast = isHavingBreakfast;
		this.payType = payType;
		this.satisfaAtion = satisfaAtion;
		this.isBook = isBook;
		this.isCancel = isCancel;
		this.isTimelyResponse = isTimelyResponse;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.modifyDate = modifyDate;
		this.modifiedBy = modifiedBy;
		this.createTime = createTime;
		this.updateTime = updateTime;
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


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomTitle() {
		return roomTitle;
	}

	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	public Double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(Double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Integer getRoomBedTypeId() {
		return roomBedTypeId;
	}

	public void setRoomBedTypeId(Integer roomBedTypeId) {
		this.roomBedTypeId = roomBedTypeId;
	}

	public Integer getIsHavingBreakfast() {
		return isHavingBreakfast;
	}

	public void setIsHavingBreakfast(Integer isHavingBreakfast) {
		this.isHavingBreakfast = isHavingBreakfast;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Double getSatisfaAtion() {
		return satisfaAtion;
	}

	public void setSatisfaAtion(Double satisfaAtion) {
		this.satisfaAtion = satisfaAtion;
	}

	public Integer getIsBook() {
		return isBook;
	}

	public void setIsBook(Integer isBook) {
		this.isBook = isBook;
	}

	public Integer getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(Integer isCancel) {
		this.isCancel = isCancel;
	}

	public Integer getIsTimelyResponse() {
		return isTimelyResponse;
	}

	public void setIsTimelyResponse(Integer isTimelyResponse) {
		this.isTimelyResponse = isTimelyResponse;
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


	@Override
	public String toString() {
		return "ItripHotelRoom [id=" + id + ", hotelId=" + hotelId + ", roomTitle=" + roomTitle + ", roomPrice="
				+ roomPrice + ", roomBedTypeId=" + roomBedTypeId + ", isHavingBreakfast=" + isHavingBreakfast
				+ ", payType=" + payType + ", satisfaAtion=" + satisfaAtion + ", isBook=" + isBook + ", isCancel="
				+ isCancel + ", isTimelyResponse=" + isTimelyResponse + ", creationDate=" + creationDate
				+ ", createdBy=" + createdBy + ", modifyDate=" + modifyDate + ", modifiedBy=" + modifiedBy
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
	
}
