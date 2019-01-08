package com.hc.rest.vo.comment;

import java.util.Date;
import java.util.List;

import com.hc.rest.entity.room.ItripImage;

public class CommentVo {
    private List<ItripImage> imgUrl;//图片地址
    
    private String userName;// 用户名
    
    private int tripMode;//出游类型
    
    private int userId;//用户编号
    
    private int serviceScore;//服务评分
    
    private int score;//综合评分
    
    private int productType;//商品类型（0：旅游产品1：酒店产品2：机票产品）
    
    private int productId;//商品id
    
    private int positionScore;//位置评分
    
    private int orderId;//订单id
    
    private Date modifyDate;
    
    private int modifiedBy;
    
    private int isOk;//是否满意（0：有待改善 1：值得推荐）
    
    private int isHavingImg;//是否包含图片(当用户上传评论时检测)0:无图片 1:有图片
    
    private int id;
    
    private int hygieneScore;//卫生评分
    
    private int hotelId;//酒店id
    
    private int facilitiesScore;//设施评分
    
    private Date creationDate;
    
    private int createdBy;
    
    private String content;//评论内容
    
    private Integer pageNo;//当前页面
    
    private Integer pageCount;//总页数
    
    private Integer commentCount;//总评论数
    
    private Integer imgCommentCount;//有图片的评论总数
    
    private Integer num;//用来判断查询状态（0，查询全部评论 1，查询有图片的评论）

    public CommentVo() {
	super();
    }
    
    public CommentVo(List<ItripImage> imgUrl, String userName, int tripMode, int userId, int serviceScore, int score,
	    int productType, int productId, int positionScore, int orderId, Date modifyDate, int modifiedBy, int isOk,
	    int isHavingImg, int id, int hygieneScore, int hotelId, int facilitiesScore, Date creationDate,
	    int createdBy, String content, Integer pageNo, Integer pageCount, Integer commentCount,
	    Integer imgCommentCount, Integer num) {
	super();
	this.imgUrl = imgUrl;
	this.userName = userName;
	this.tripMode = tripMode;
	this.userId = userId;
	this.serviceScore = serviceScore;
	this.score = score;
	this.productType = productType;
	this.productId = productId;
	this.positionScore = positionScore;
	this.orderId = orderId;
	this.modifyDate = modifyDate;
	this.modifiedBy = modifiedBy;
	this.isOk = isOk;
	this.isHavingImg = isHavingImg;
	this.id = id;
	this.hygieneScore = hygieneScore;
	this.hotelId = hotelId;
	this.facilitiesScore = facilitiesScore;
	this.creationDate = creationDate;
	this.createdBy = createdBy;
	this.content = content;
	this.pageNo = pageNo;
	this.pageCount = pageCount;
	this.commentCount = commentCount;
	this.imgCommentCount = imgCommentCount;
	this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getImgCommentCount() {
        return imgCommentCount;
    }

    public void setImgCommentCount(Integer imgCommentCount) {
        this.imgCommentCount = imgCommentCount;
    }

    public List<ItripImage> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<ItripImage> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getServiceScore() {
        return serviceScore;
    }

    public void setServiceScore(int serviceScore) {
        this.serviceScore = serviceScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPositionScore() {
        return positionScore;
    }

    public void setPositionScore(int positionScore) {
        this.positionScore = positionScore;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public int getIsOk() {
        return isOk;
    }

    public void setIsOk(int isOk) {
        this.isOk = isOk;
    }

    public int getIsHavingImg() {
        return isHavingImg;
    }

    public void setIsHavingImg(int isHavingImg) {
        this.isHavingImg = isHavingImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHygieneScore() {
        return hygieneScore;
    }

    public void setHygieneScore(int hygieneScore) {
        this.hygieneScore = hygieneScore;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getFacilitiesScore() {
        return facilitiesScore;
    }

    public void setFacilitiesScore(int facilitiesScore) {
        this.facilitiesScore = facilitiesScore;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    

    
    
    
   
   
    


    
    

}
