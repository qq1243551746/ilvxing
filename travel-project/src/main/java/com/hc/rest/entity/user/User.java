package com.hc.rest.entity.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "itrip_user")
public class User implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;// 标示编号

	@Column(name = "userName", columnDefinition = "VARCHAR(255) NOT NULL COMMENT '用户昵称'", unique = true)
	@NotBlank(message = "userName can't be null")
	private String userName;// 用户名

	@Column(name = "userPassword", columnDefinition = "VARCHAR(255) DEFAULT NULL COMMENT '若是第三方登录，系统将自动生成唯一密码；自注册用户则为自定义密码'")
	@NotBlank(message = "userPassword can't be nullf")
	private String userPassword;// 密码

	@Column(name = "userCode", columnDefinition = "VARCHAR(255) DEFAULT NULL COMMENT '若是第三方登录，系统将自动生成唯一账号；自注册用户则为邮箱或者手机号'")
	@NotBlank(message = "userCode can't be null")
	private String userCode;// 邮箱或者手机号

	@Column(name = "userType", columnDefinition = "INT(5) DEFAULT NULL COMMENT '用户类型（标识：0 自注册用户 1 微信登录 2 QQ登录 3 微博登录）'")
	@NotBlank(message = "userType can't be null")
	private Integer userType;// 用户类型(标识:0自注册用户、1微信登录、2qq登录、3微博登录)

	@Column(name = "flatId", columnDefinition = "BIGINT(20) DEFAULT NULL COMMENT '平台ID（根据不同登录用户，进行相应存入：自注册用户主键ID、微信ID、QQID、微博ID）'")
	@NotBlank(message = "flatId can't be null")
	private Integer flatId;// 平台ID（根据不同登录用户，进行相应存入：自注册用户主键ID、微信ID、QQID、微博ID）',

	@Column(name = "weChat", columnDefinition = "VARCHAR(255) DEFAULT NULL COMMENT '微信号'")
	@NotBlank(message = "weChat can't be null")
	private String weChat;// 微信号

	@Column(name = "QQ", columnDefinition = "VARCHAR(255) DEFAULT NULL COMMENT 'qq账号'")
	@NotBlank(message = "QQ can't be null")
	private String QQ;// QQ账号

	@Column(name = "weibo", columnDefinition = "VARCHAR(255) DEFAULT NULL COMMENT '微博账号'")
	@NotBlank(message = "weibo can't be null")
	private String weibo;// 微博账号

	@Column(name = "baidu", columnDefinition = "VARCHAR(255) DEFAULT NULL COMMENT '百度账号'")
	@NotBlank(message = "baidu can't be null")
	private String baidu;// 百度账号

	@Temporal(TemporalType.DATE)
	@Column(name = "createDate", columnDefinition = "DATETIME DEFAULT NULL  COMMENT '创建/注册时间'")
	private Date createDate;// 创建/注册时间

	@Column(name = "createdBy", columnDefinition = "BIGINT(11) DEFAULT NULL COMMENT '由……创建'")
	@NotBlank(message = "createdBy can't be null")
	private Integer createdBy;// 由什么创建的

	@Temporal(TemporalType.DATE)
	@Column(name = "modifyDate", columnDefinition = "DATETIME DEFAULT NULL COMMENT '修改时间'")
	private Date modifyDate;// 修改时间

	@Column(name = "modifiedBy", columnDefinition = "bigint(11) DEFAULT NULL COMMENT '由……修改'")
	@NotBlank(message = "modifiedBy can't be null")
	private Integer modifiedBy;// 由谁修改的

	@Column(name = "activated", columnDefinition = "INT(1) DEFAULT NULL COMMENT '是否激活,(0 false，1 true,默认是0)'")
	@NotBlank(message = "activated can't be null")
	private Integer activated;// 是否激活(0 false，1 true,默认是0)

	@Column(name = "uuid", columnDefinition = "VARCHAR(255) NOT NULL COMMENT 'uuid'", unique = true)
	@NotBlank(message = "uuid can't be null")
	private String uuid;

	public User() {
		super();
	}

	public User(Integer id, @NotBlank(message = "userName can't be null") String userName, @NotBlank(message = "userPassword can't be nullf") String userPassword, @NotBlank(message = "userCode can't be null") String userCode, @NotBlank(message = "userType can't be null") Integer userType,
			@NotBlank(message = "flatId can't be null") Integer flatId, @NotBlank(message = "weChat can't be null") String weChat, @NotBlank(message = "QQ can't be null") String qQ, @NotBlank(message = "weibo can't be null") String weibo, @NotBlank(message = "baidu can't be null") String baidu,
			Date createDate, @NotBlank(message = "createdBy can't be null") Integer createdBy, Date modifyDate, @NotBlank(message = "modifiedBy can't be null") Integer modifiedBy, @NotBlank(message = "activated can't be null") Integer activated,
			@NotBlank(message = "uuid can't be null") String uuid) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userCode = userCode;
		this.userType = userType;
		this.flatId = flatId;
		this.weChat = weChat;
		QQ = qQ;
		this.weibo = weibo;
		this.baidu = baidu;
		this.createDate = createDate;
		this.createdBy = createdBy;
		this.modifyDate = modifyDate;
		this.modifiedBy = modifiedBy;
		this.activated = activated;
		this.uuid = uuid;
	}

	/*
	 * 封装
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getFlatId() {
		return flatId;
	}

	public void setFlatId(Integer flatId) {
		this.flatId = flatId;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getBaidu() {
		return baidu;
	}

	public void setBaidu(String baidu) {
		this.baidu = baidu;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date creationDate) {
		this.createDate = creationDate;
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

	public Integer getActivated() {
		return activated;
	}

	public void setActivated(Integer activated) {
		this.activated = activated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", userCode=" + userCode + ", userType=" + userType + ", flatId=" + flatId + ", weChat=" + weChat + ", QQ=" + QQ + ", weibo=" + weibo + ", baidu=" + baidu + ", createDate=" + createDate + ", createdBy="
				+ createdBy + ", modifyDate=" + modifyDate + ", modifiedBy=" + modifiedBy + ", activated=" + activated + ", uuid=" + uuid + "]";
	}

}
