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
 * 图片表 
 * @author LCL
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "itrip_image")
public class ItripImage implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;   //主键
	
	@Column(name="type", columnDefinition = "varchar(255) COMMENT '图片类型(0:酒店图片1:房间图片2:评论图片)'")
	private String type; //酒店ID
	
	@Column(name="indexImgType", columnDefinition = "varchar(255) COMMENT '是否是首页图片(0:不是1:是)'")
	private String indexImgType;
	
	@Column(name="targetId" , columnDefinition = "bigint(11) COMMENT '关联id'")
	private Integer targetId; // 房间名称
	
	@Column(name="position" , columnDefinition = "int(2)  COMMENT '图片上传顺序位置'")
	private Integer position; // 房间价格
		
	@Column(name="imgUrl" , columnDefinition = "varchar(255) COMMENT '图片地址'")
	private String imgUrl;
	
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

	public ItripImage() {
	}

	public ItripImage(Integer id, String type, Integer targetId, Integer position, String imgUrl, Date creationDate,
			Integer createdBy, Date modifyDate, Integer modifiedBy, Date createTime, Date updateTime) {
		this.id = id;
		this.type = type;
		this.targetId = targetId;
		this.position = position;
		this.imgUrl = imgUrl;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

	public String getIndexImgType() {
		return indexImgType;
	}

	public void setIndexImgType(String indexImgType) {
		this.indexImgType = indexImgType;
	}

	@Override
	public String toString() {
		return "ItripImage [id=" + id + ", type=" + type + ", indexImgType=" + indexImgType + ", targetId=" + targetId
				+ ", position=" + position + ", imgUrl=" + imgUrl + ", creationDate=" + creationDate + ", createdBy="
				+ createdBy + ", modifyDate=" + modifyDate + ", modifiedBy=" + modifiedBy + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}


	
	
}
