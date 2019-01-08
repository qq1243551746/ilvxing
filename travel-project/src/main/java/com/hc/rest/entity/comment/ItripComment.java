package com.hc.rest.entity.comment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 评论表
 * @author JAY
 *
 */
@Entity
@Table(name = "itrip_comment")
public class ItripComment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "content", columnDefinition = "text COMMENT '评论内容'")
    private String content;//评论内容
    
    @Column(name = "createdBy", columnDefinition = "bigint(11) DEFAULT NULL")
    private int createdBy;
    
    @Column(name = "creationDate", columnDefinition = "datetime NOT NULL")
    private Date creationDate;
    
    @Column(name = "facilitiesScore", columnDefinition = "int(255) DEFAULT NULL COMMENT '设施评分'")
    private int facilitiesScore;//设施评分
    
    @Column(name = "hotelId", columnDefinition = "bigint(20) DEFAULT NULL")
    private int hotelId;//酒店id
    
    @Column(name = "hygieneScore", columnDefinition = " int(255) NOT NULL COMMENT '卫生评分'")
    private int hygieneScore;//卫生评分
    
    @Column(name = "isHavingImg", columnDefinition = "int(255) NOT NULL COMMENT '是否包含图片(当用户上传评论时检测)0:无图片 1:有图片'")
    private int isHavingImg;//是否包含图片(当用户上传评论时检测)0:无图片 1:有图片
    
    @Column(name = "isOk", columnDefinition = "int(255) DEFAULT NULL COMMENT '是否满意（0：有待改善 1：值得推荐）'")
    private int isOk;//是否满意（0：有待改善 1：值得推荐）
    
    @Column(name = "modifiedBy", columnDefinition = "bigint(11) DEFAULT NULL")
    private int modifiedBy;
    
    @Column(name = "modifyDate", columnDefinition = "datetime DEFAULT NULL")
    private Date modifyDate;
    
    @Column(name = "orderId", columnDefinition = "bigint(11) DEFAULT NULL COMMENT '订单id'")
    private int orderId;//订单id
    
    @Column(name = "positionScore", columnDefinition = "int(255) DEFAULT NULL COMMENT '位置评分'")
    private int positionScore;//位置评分
    
    @Column(name = "productId", columnDefinition = "bigint(11) NOT NULL COMMENT '商品id'")
    private int productId;//商品id
    
    @Column(name = "productType", columnDefinition = "int(255) NOT NULL COMMENT '商品类型(0:旅游产品 1:酒店产品 2:机票产品)'")
    private int productType;//商品类型（0：旅游产品1：酒店产品2：机票产品）
    
    @Column(name = "score", columnDefinition = "int(255) DEFAULT NULL COMMENT '综合评分'")
    private int score;//综合评分
    
    @Column(name = "serviceScore", columnDefinition = "int(255) DEFAULT NULL COMMENT '服务评分'")
    private int serviceScore;//服务评分
    
    @Column(name = "tripMode", columnDefinition = "bigint(11) DEFAULT NULL COMMENT '出游类型'")
    private int tripMode;//出游类型
    
    @Column(name = "userId", columnDefinition = "bigint(11) NOT NULL COMMENT '用户编号'")
    private int userId;//用户编号

    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public int getCreatedBy() {
        return createdBy;
    }


    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }


    public Date getCreationDate() {
        return creationDate;
    }


    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public int getFacilitiesScore() {
        return facilitiesScore;
    }


    public void setFacilitiesScore(int facilitiesScore) {
        this.facilitiesScore = facilitiesScore;
    }


    public int getHotelId() {
        return hotelId;
    }


    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }


    public int getHygieneScore() {
        return hygieneScore;
    }


    public void setHygieneScore(int hygieneScore) {
        this.hygieneScore = hygieneScore;
    }


    public int getIsHavingImg() {
        return isHavingImg;
    }


    public void setIsHavingImg(int isHavingImg) {
        this.isHavingImg = isHavingImg;
    }


    public int getIsOk() {
        return isOk;
    }


    public void setIsOk(int isOk) {
        this.isOk = isOk;
    }


    public int getModifiedBy() {
        return modifiedBy;
    }


    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }


    public Date getModifyDate() {
        return modifyDate;
    }


    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }


    public int getOrderId() {
        return orderId;
    }


    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public int getPositionScore() {
        return positionScore;
    }


    public void setPositionScore(int positionScore) {
        this.positionScore = positionScore;
    }


    public int getProductId() {
        return productId;
    }


    public void setProductId(int productId) {
        this.productId = productId;
    }


    public int getProductType() {
        return productType;
    }


    public void setProductType(int productType) {
        this.productType = productType;
    }


    public int getScore() {
        return score;
    }


    public void setScore(int score) {
        this.score = score;
    }


    public int getServiceScore() {
        return serviceScore;
    }


    public void setServiceScore(int serviceScore) {
        this.serviceScore = serviceScore;
    }


    public int getTripMode() {
        return tripMode;
    }


    public void setTripMode(int tripMode) {
        this.tripMode = tripMode;
    }


    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
	return "ItripComment [id=" + id + ", content=" + content + ", createdBy=" + createdBy + ", creationDate="
		+ creationDate + ", facilitiesScore=" + facilitiesScore + ", hotelId=" + hotelId + ", hygieneScore="
		+ hygieneScore + ", isHavingImg=" + isHavingImg + ", isOk=" + isOk + ", modifiedBy=" + modifiedBy
		+ ", modifyDate=" + modifyDate + ", orderId=" + orderId + ", positionScore=" + positionScore
		+ ", productId=" + productId + ", productType=" + productType + ", score=" + score + ", serviceScore="
		+ serviceScore + ", tripMode=" + tripMode + ", userId=" + userId + "]";
    }

   
    
    

}
