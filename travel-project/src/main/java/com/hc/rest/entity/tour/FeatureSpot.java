package com.hc.rest.entity.tour;

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

/**
 * 景点
 * 
 * @author MaiBenBen
 *
 */
@Entity
@Table(name = "itrip_FeatureSpot")
public class FeatureSpot implements Serializable {
	private static final long serialVersionUID = 3283929045367456142L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer fid;// 景点id

	@Column(name = "idName", columnDefinition = "int NOT NULL COMMENT '地区外键'")
	private Integer idName;// 地区外键

	@Column(name = "imgId", columnDefinition = "int NOT NULL COMMENT '图片外键'")
	private Integer imgId;// 图片外键

	@Column(name = "hotelId", columnDefinition = "int NOT NULL COMMENT '酒店外键'")
	private Integer hotelId;// 酒店外键

	@Column(name = "themeId", columnDefinition = "int NOT NULL COMMENT '主题外键'")
	private Integer themeId;// 主题外键

	@Column(name = "arrangeId", columnDefinition = "int NOT NULL COMMENT '行程外键'")
	private Integer arrangeId;// 行程外键

	@Column(name = "feature_spot_name", columnDefinition = "VARCHAR(200) NOT NULL COMMENT '景点名称!'")
	private String featureSpotName;// 景点名称

	@Column(name = "address", columnDefinition = "VARCHAR(800) NOT NULL COMMENT '景点关键字!'")
	private String address;// 景点关键字

	@Column(name = "price", columnDefinition = "decimal(15,1) NOT NULL COMMENT '景点价钱!'")
	private double price;// 景点价钱

	@Column(name = "fatalism", columnDefinition = "int(11) NOT NULL COMMENT '行程天数!'")
	private Integer fatalism;// 行程天数

	@Column(name = "quantity", columnDefinition = "VARCHAR(200) NOT NULL COMMENT '旅游人数!'")
	private String quantity;// 旅游人数

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", columnDefinition = "datetime DEFAULT NULL COMMENT '创建时间'")
	private Date createTime; // 创建时间

	@Temporal(TemporalType.DATE)
	@Column(name = "update_time", columnDefinition = "datetime DEFAULT NULL COMMENT '更新时间'")
	private Date updateTime;// 更新时间

	@Override
	public String toString() {
		return "FeatureSpot [fid=" + fid + ", idName=" + idName + ", imgId=" + imgId + ", hotelId=" + hotelId
				+ ", themeId=" + themeId + ", arrangeId=" + arrangeId + ", featureSpotName=" + featureSpotName
				+ ", address=" + address + ", price=" + price + ", fatalism=" + fatalism + ", quantity=" + quantity
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

	public FeatureSpot(Integer fid, Integer idName, Integer imgId, Integer hotelId, Integer themeId, Integer arrangeId,
			String featureSpotName, String address, double price, Integer fatalism, String quantity, Date createTime,
			Date updateTime) {
		super();
		this.fid = fid;
		this.idName = idName;
		this.imgId = imgId;
		this.hotelId = hotelId;
		this.themeId = themeId;
		this.arrangeId = arrangeId;
		this.featureSpotName = featureSpotName;
		this.address = address;
		this.price = price;
		this.fatalism = fatalism;
		this.quantity = quantity;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public FeatureSpot() {
		super();
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Integer getIdName() {
		return idName;
	}

	public void setIdName(Integer idName) {
		this.idName = idName;
	}

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getThemeId() {
		return themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public Integer getArrangeId() {
		return arrangeId;
	}

	public void setArrangeId(Integer arrangeId) {
		this.arrangeId = arrangeId;
	}

	public String getFeatureSpotName() {
		return featureSpotName;
	}

	public void setFeatureSpotName(String featureSpotName) {
		this.featureSpotName = featureSpotName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getFatalism() {
		return fatalism;
	}

	public void setFatalism(Integer fatalism) {
		this.fatalism = fatalism;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
