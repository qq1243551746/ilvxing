package com.hc.rest.vo.tour;

import java.util.List;

import com.hc.rest.entity.room.ItripImage;

/**
 * 6表连接(酒店表,图片表,地区表,景点表)
 * 
 * @author MaiBenBen
 *
 */
public class WholeVo {
	private String themeName;// 主题名称

	private Integer id;// 地区id

	private Integer idName;// 地区外键

	private Integer isChina;// '1:国内 2：国外',

	private Integer fid;// 景点id

	private Integer fatalism;// 行程天数

	private Integer hotelLevel;// 酒店等级(1:经济酒店 2:二星级酒店 3:三星级 4:四星酒店 5星酒店)

	private Integer imgId;// 图片外键

	private String name;// '地区区域名称',

	private String address;// 景点详细地址

	private String featureSpotName;// 景点名称

	private double price;// 景点价钱

	private String hotelName; // 酒店名称

	private List<ItripImage> image;// 图片List

	private Integer page;// 当前页码

	private Integer size;// 当前页码显示数量

	private Integer count;// 总页码

	private Integer countSize;// 总数据量

	private String quantity;// 旅游人数

	@Override
	public String toString() {
		return "WholeVo [themeName=" + themeName + ", id=" + id + ", idName=" + idName + ", isChina=" + isChina
				+ ", fid=" + fid + ", fatalism=" + fatalism + ", hotelLevel=" + hotelLevel + ", imgId=" + imgId
				+ ", name=" + name + ", address=" + address + ", featureSpotName=" + featureSpotName + ", price="
				+ price + ", hotelName=" + hotelName + ", image=" + image + ", page=" + page + ", size=" + size
				+ ", count=" + count + ", countSize=" + countSize + ", quantity=" + quantity + "]";
	}

	public WholeVo(String themeName, Integer id, Integer idName, Integer isChina, Integer fid, Integer fatalism,
			Integer hotelLevel, Integer imgId, String name, String address, String featureSpotName, double price,
			String hotelName, List<ItripImage> image, Integer page, Integer size, Integer count, Integer countSize,
			String quantity) {
		super();
		this.themeName = themeName;
		this.id = id;
		this.idName = idName;
		this.isChina = isChina;
		this.fid = fid;
		this.fatalism = fatalism;
		this.hotelLevel = hotelLevel;
		this.imgId = imgId;
		this.name = name;
		this.address = address;
		this.featureSpotName = featureSpotName;
		this.price = price;
		this.hotelName = hotelName;
		this.image = image;
		this.page = page;
		this.size = size;
		this.count = count;
		this.countSize = countSize;
		this.quantity = quantity;
	}

	public WholeVo() {
		super();
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdName() {
		return idName;
	}

	public void setIdName(Integer idName) {
		this.idName = idName;
	}

	public Integer getIsChina() {
		return isChina;
	}

	public void setIsChina(Integer isChina) {
		this.isChina = isChina;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Integer getFatalism() {
		return fatalism;
	}

	public void setFatalism(Integer fatalism) {
		this.fatalism = fatalism;
	}

	public Integer getHotelLevel() {
		return hotelLevel;
	}

	public void setHotelLevel(Integer hotelLevel) {
		this.hotelLevel = hotelLevel;
	}

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public List<ItripImage> getImage() {
		return image;
	}

	public void setImage(List<ItripImage> image) {
		this.image = image;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCountSize() {
		return countSize;
	}

	public void setCountSize(Integer countSize) {
		this.countSize = countSize;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
