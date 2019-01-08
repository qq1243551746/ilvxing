package com.hc.rest.vo.tour;

import java.util.List;

import com.hc.rest.entity.room.ItripImage;

/**
 * 首页:景点,地区,景点图片vo
 * 
 * 
 * @author MaiBenBen
 *
 */
public class FeatureSpotVo {
	/*
	 * private Integer hotelId;// 酒店外键
	 * 
	 * private Integer themeId;// 主题外键
	 * 
	 * private Integer arrangeId;// 行程外键
	 */
	private Integer id;// 地区id

	private Integer fatalism;// 景点天数

	private Integer isChina;// '1:国内 2：国外',

	private Integer idName;// 地区外键

	private String name;// 地区名称

	private Integer fid;// 景点id

	private Integer imgId;// 图片外键

	private String address;// 景点关键字

	private String featureSpotName;// 景点名称

	private double price;// 景点价钱

	private List<ItripImage> image;// 图片List

	@Override
	public String toString() {
		return "FeatureSpotVo [id=" + id + ", fatalism=" + fatalism + ", isChina=" + isChina + ", idName=" + idName
				+ ", name=" + name + ", fid=" + fid + ", imgId=" + imgId + ", address=" + address + ", featureSpotName="
				+ featureSpotName + ", price=" + price + ", image=" + image + "]";
	}

	public FeatureSpotVo(Integer id, Integer fatalism, Integer isChina, Integer idName, String name, Integer fid,
			Integer imgId, String address, String featureSpotName, double price, List<ItripImage> image) {
		super();
		this.id = id;
		this.fatalism = fatalism;
		this.isChina = isChina;
		this.idName = idName;
		this.name = name;
		this.fid = fid;
		this.imgId = imgId;
		this.address = address;
		this.featureSpotName = featureSpotName;
		this.price = price;
		this.image = image;
	}

	public FeatureSpotVo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFatalism() {
		return fatalism;
	}

	public void setFatalism(Integer fatalism) {
		this.fatalism = fatalism;
	}

	public Integer getIsChina() {
		return isChina;
	}

	public void setIsChina(Integer isChina) {
		this.isChina = isChina;
	}

	public Integer getIdName() {
		return idName;
	}

	public void setIdName(Integer idName) {
		this.idName = idName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFeatureSpotName() {
		return featureSpotName;
	}

	public void setFeatureSpotName(String featureSpotName) {
		this.featureSpotName = featureSpotName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<ItripImage> getImage() {
		return image;
	}

	public void setImage(List<ItripImage> image) {
		this.image = image;
	}

}
