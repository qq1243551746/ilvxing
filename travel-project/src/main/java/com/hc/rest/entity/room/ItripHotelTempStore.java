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
 * 库存表
 * @author LCL
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="itrip_hotel_temp_store")
public class ItripHotelTempStore implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer id;   //主键
	
	@Column(name="hotelId", columnDefinition = "int(10) COMMENT '酒店ID'")
	private Integer hotelId; 
	
	@Column(name="roomId", columnDefinition = "int(10) COMMENT '商品id'")
	private Integer roomId;
	
	@Column(name="store", columnDefinition = "int(10) COMMENT '商品库存'")
	private Integer store; 
	
	@Column(name="recordDate", columnDefinition = "datetime COMMENT '记录时间'")
	private Date recordDate; 
	
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

	public ItripHotelTempStore() {
	}

	public ItripHotelTempStore(Integer id, Integer hotelId, Integer roomId, Integer store, Date recordDate,
			Date creationDate, Integer createdBy, Date modifyDate, Integer modifiedBy, Date createTime,
			Date updateTime) {
		this.id = id;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.store = store;
		this.recordDate = recordDate;
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

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getStore() {
		return store;
	}

	public void setStore(Integer store) {
		this.store = store;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
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
		return "itripHotelTempStore [id=" + id + ", hotelId=" + hotelId + ", roomId=" + roomId + ", store=" + store
				+ ", recordDate=" + recordDate + ", creationDate=" + creationDate + ", createdBy=" + createdBy
				+ ", modifyDate=" + modifyDate + ", modifiedBy=" + modifiedBy + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
	
	
}
