package com.hc.rest.entity.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 订单表
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@Entity
@Table(name="itrip_hotel_order")
public class HotelOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="userId",columnDefinition = "bigint(11) NOT NULL COMMENT '用户id'")
	private Integer userId;  //用户id
	
	@Column(name="orderType",columnDefinition = "int(11) COMMENT '订单类型(0:旅游产品 1:酒店产品 2：机票产品)'")
	private Integer orderType;
	
	@Column(name="orderNo",columnDefinition = "varchar(255) not null COMMENT '订单号'")
	private String orderNo;
	
	@Column(name="tradeNo",columnDefinition = "varchar(255)  COMMENT '交易编号'")
	private String tradeNo;
	
	@Column(name="hotelId",columnDefinition = "bigint(20)  COMMENT '冗余字段 酒店id'")
	private Integer hotelId;
	
	@Column(name="hotelName",columnDefinition = "varchar(255)  COMMENT '冗余字段 酒店名称'")
	private String hotelName;
	
	@Column(name="roomId",columnDefinition = "bigint(11) not null  COMMENT '房间id'")
	private Integer roomId;
	
	@Column(name="count",columnDefinition = "int(11) not null  COMMENT '消耗数量'")
	private Integer count;
	
	@Column(name="bookingDays",columnDefinition="int(255) not null comment'预订天数'")
	private Integer bookingDays;
	
	@Column(name="checkInDate",columnDefinition = "datetime not null  COMMENT '入住时间'")
	private Date checkInDate;
	
	@Column(name="checkOutDate",columnDefinition = "datetime not null  COMMENT '退房时间'")
	private Date checkOutDate;
	
	@Column(name="orderStatus",columnDefinition = "int(255) not null  COMMENT '订单状态（0：待支付 1:已取消 2:支付成功 3:已消费 4：已点评）'")
	private Integer orderStatus;
	
	@Column(name="payAmount",columnDefinition = "decimal(20)  COMMENT '支付金额'")
	private Double payAmount;
 
	@Column(name="payType" ,columnDefinition = "int(255)  COMMENT '支付方式:1:支付宝 2:微信 3:到店付'")
	private Integer payType;
	
	@Column(name="noticePhone",columnDefinition = "varchar(255) COMMENT '联系手机号'")
	private String noticePhone;
	
	@Column(name="noticeEmail",columnDefinition = "varchar(255) COMMENT '联系邮箱'")
	private String noticeEmail;
	
	@Column(name="specialRequirement",columnDefinition = "text COMMENT '特殊需求'")
	private String specialRequirement;
	
	@Column(name="isNeedInvoice",columnDefinition = "int(1) COMMENT '是否需要发票（0：不需要 1：需要）'")
	private Integer isNeedInvoice;
	
	@Column(name="invoiceType",columnDefinition = "int(255) COMMENT '发票类型（0：个人 1：公司）'")
	private Integer invoiceType;
	
	@Column(name="invoiceHead",columnDefinition = "varchar(255) COMMENT '发票抬头'")
	private String invoiceHead;
	
	@Column(name="linkUserName",columnDefinition = "varchar(255) COMMENT '入住人名称'")
	private String linkUserName;
	
	@Column(name="bookType",columnDefinition="int(1) COMMENT'0:WEB端 1:手机端 2:其他客户端'")
	private Integer bookType;
	
	@Column(name="creationDate",columnDefinition="datetime not null COMMENT'预定时间'")
	private Date creationDate;
	
	@Column(name="createdBy",columnDefinition="bigint(11) COMMENT''")
	private Integer createdBy;
	
	@Column(name="modifyDate",columnDefinition="datetime COMMENT'支付完成时间'")
	private Date modifyDate;
	
	@Column(name="modifiedBy",columnDefinition="bigint(11) COMMENT''")
	private Integer modifiedBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
	private Date createTime; // 创建时间

	@Temporal(TemporalType.DATE)
	@Column(name = "update_time", columnDefinition = "datetime DEFAULT NULL COMMENT '更新时间'")
	private Date updateTime;// 更新时间

	
	
	@Override
	public String toString() {
		return "HotelOrder [id=" + id + ", userId=" + userId + ", orderType=" + orderType + ", orderNo=" + orderNo
				+ ", tradeNo=" + tradeNo + ", hotelId=" + hotelId + ", hotelName=" + hotelName + ", roomId=" + roomId
				+ ", count=" + count + ", bookingDays=" + bookingDays + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", orderStatus=" + orderStatus + ", payAmount=" + payAmount
				+ ", payType=" + payType + ", noticePhone=" + noticePhone + ", noticeEmail=" + noticeEmail
				+ ", specialRequirement=" + specialRequirement + ", isNeedInvoice=" + isNeedInvoice + ", invoiceType="
				+ invoiceType + ", invoiceHead=" + invoiceHead + ", linkUserName=" + linkUserName + ", bookType="
				+ bookType + ", creationDate=" + creationDate + ", createdBy=" + createdBy + ", modifyDate="
				+ modifyDate + ", modifiedBy=" + modifiedBy + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	

	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}


	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}


	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}


	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public void setBookingDays(Integer bookingDays) {
		this.bookingDays = bookingDays;
	}


	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}


	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}


	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}


	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}


	public void setPayType(Integer payType) {
		this.payType = payType;
	}


	public void setNoticePhone(String noticePhone) {
		this.noticePhone = noticePhone;
	}


	public void setNoticeEmail(String noticeEmail) {
		this.noticeEmail = noticeEmail;
	}


	public void setSpecialRequirement(String specialRequirement) {
		this.specialRequirement = specialRequirement;
	}


	public void setIsNeedInvoice(Integer isNeedInvoice) {
		this.isNeedInvoice = isNeedInvoice;
	}


	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}


	public void setInvoiceHead(String invoiceHead) {
		this.invoiceHead = invoiceHead;
	}


	public void setLinkUserName(String linkUserName) {
		this.linkUserName = linkUserName;
	}


	public void setBookType(Integer bookType) {
		this.bookType = bookType;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}


	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public Integer getId() {
		return id;
	}

	public Integer getUseId() {
		return userId;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getBookingDays() {
		return bookingDays;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public Double getPayAmount() {
		return payAmount;
	}

	public Integer getPayType() {
		return payType;
	}

	public String getNoticePhone() {
		return noticePhone;
	}

	public String getNoticeEmail() {
		return noticeEmail;
	}

	public String getSpecialRequirement() {
		return specialRequirement;
	}

	public Integer getIsNeedInvoice() {
		return isNeedInvoice;
	}

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public String getInvoiceHead() {
		return invoiceHead;
	}

	public String getLinkUserName() {
		return linkUserName;
	}

	public Integer getBookType() {
		return bookType;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
	
	

}
