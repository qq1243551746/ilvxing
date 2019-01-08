package com.hc.rest.entity.personal;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 	常用联系人表
 * @author 邓爱青
 *
 */
@Entity
@Table(name = "itrip_user_link_user")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "linkUserName", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '常用联系人姓名'")
    private String linkUserName;//常用联系人姓名
    
    
    @Column(name = "linkIdCard", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '证件号码'")
    private String linkIdCard;// 证件号码
    
    @Column(name = "linkPhone", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '常用联系人电话'")
    private String linkPhone;//常用联系人电话
    
    @Column(name = "userId", columnDefinition = "int(11) DEFAULT NULL COMMENT '用户id'")
    private Integer userId;//用户id
    
    @Column(name = "creationDate", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
    private Date creationDate; // 创建时间
    
    @Column(name = "createdBy", columnDefinition = "bigint(11)")
    private Integer createdBy;
    
    @Column(name = "modifyDate", columnDefinition = "datetime DEFAULT NULL COMMENT '更新时间'")
    private Date modifyDate;// 更新时间
    
    @Column(name = "modifiedBy", columnDefinition = "bigint(11)")
    private Integer modifiedBy;
    
    @Column(name = "linkIdCardType", columnDefinition = "int(1) DEFAULT NULL COMMENT '证件类型：(0-身份证，1-护照，2-学生证，3-军人证，4-驾驶证，5-旅行证)'")
    private Integer linkIdCardType;//证件类型：(0-身份证，1-护照，2-学生证，3-军人证，4-驾驶证，5-旅行证)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkUserName() {
        return linkUserName;
    }

    public void setLinkUserName(String linkUserName) {
        this.linkUserName = linkUserName;
    }

    public String getLinkIdCard() {
        return linkIdCard;
    }

    public void setLinkIdCard(String linkIdCard) {
        this.linkIdCard = linkIdCard;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getLinkIdCardType() {
        return linkIdCardType;
    }

    public void setLinkIdCardType(Integer linkIdCardType) {
        this.linkIdCardType = linkIdCardType;
    }

    @Override
    public String toString() {
	return "Contact [id=" + id + ", linkUserName=" + linkUserName + ", linkIdCard=" + linkIdCard + ", linkPhone="
		+ linkPhone + ", userId=" + userId + ", creationDate=" + creationDate + ", createdBy=" + createdBy
		+ ", modifyDate=" + modifyDate + ", modifiedBy=" + modifiedBy + ", linkIdCardType=" + linkIdCardType
		+ "]";
    }
    
    

    public Contact() {
	super();
    }

    public Contact(Integer id, String linkUserName, String linkIdCard, String linkPhone, Integer userId,
	    Date creationDate, Integer createdBy, Date modifyDate, Integer modifiedBy, Integer linkIdCardType) {
	super();
	this.id = id;
	this.linkUserName = linkUserName;
	this.linkIdCard = linkIdCard;
	this.linkPhone = linkPhone;
	this.userId = userId;
	this.creationDate = creationDate;
	this.createdBy = createdBy;
	this.modifyDate = modifyDate;
	this.modifiedBy = modifiedBy;
	this.linkIdCardType = linkIdCardType;
    }

 
    
}
