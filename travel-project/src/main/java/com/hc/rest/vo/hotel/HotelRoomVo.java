package com.hc.rest.vo.hotel;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hc.rest.entity.room.ItripImage;

public class HotelRoomVo {
	private Integer hotel_Id; //酒店ID
	private double Price;//价格
	private String address;//地址
	private Integer hotel_Type;//酒店类型
	private Integer city_Id; //所在城市ID;
	private Integer country_Id;//所在国家ID;
	private String details;//酒店介绍
	private String facilities;//酒店设施
	private Integer hotel_Level;//酒店级别
	private String hotel_Name;//酒店名称
	private String hotel_Policy;//酒店政策
	
	private Integer is_Group_Purchase;//是否是团购酒店
	private Integer province_Id;//所在省份ID;
	private String redundant_City_Name;//城市名称
	private String redundant_Country_Name;//国家名称
	private Integer redundant_Hotel_Store;//酒店库存
	private String redundant_Province_Name;//省名称
	
	private List<ItripImage> image; //图片
	
	private Integer pageNo;// 当前页码

	private Integer pageSize;// 当前页码显示数量

	private Integer count;// 总数

	private Integer countSize;// 总数据量
	
	

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

	public Integer getHotel_Id() {
		return hotel_Id;
	}

	public void setHotel_Id(Integer hotel_Id) {
		this.hotel_Id = hotel_Id;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getHotel_Type() {
		return hotel_Type;
	}

	public void setHotel_Type(Integer hotel_Type) {
		this.hotel_Type = hotel_Type;
	}

	public Integer getCity_Id() {
		return city_Id;
	}

	public void setCity_Id(Integer city_Id) {
		this.city_Id = city_Id;
	}

	public Integer getCountry_Id() {
		return country_Id;
	}

	public void setCountry_Id(Integer country_Id) {
		this.country_Id = country_Id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public Integer getHotel_Level() {
		return hotel_Level;
	}

	public void setHotel_Level(Integer hotel_Level) {
		this.hotel_Level = hotel_Level;
	}

	public String getHotel_Name() {
		return hotel_Name;
	}

	public void setHotel_Name(String hotel_Name) {
		this.hotel_Name = hotel_Name;
	}

	public String getHotel_Policy() {
		return hotel_Policy;
	}

	public void setHotel_Policy(String hotel_Policy) {
		this.hotel_Policy = hotel_Policy;
	}

	public Integer getIs_Group_Purchase() {
		return is_Group_Purchase;
	}

	public void setIs_Group_Purchase(Integer is_Group_Purchase) {
		this.is_Group_Purchase = is_Group_Purchase;
	}

	public Integer getProvince_Id() {
		return province_Id;
	}

	public void setProvince_Id(Integer province_Id) {
		this.province_Id = province_Id;
	}

	public String getRedundant_City_Name() {
		return redundant_City_Name;
	}

	public void setRedundant_City_Name(String redundant_City_Name) {
		this.redundant_City_Name = redundant_City_Name;
	}

	public String getRedundant_Country_Name() {
		return redundant_Country_Name;
	}

	public void setRedundant_Country_Name(String redundant_Country_Name) {
		this.redundant_Country_Name = redundant_Country_Name;
	}

	public Integer getRedundant_Hotel_Store() {
		return redundant_Hotel_Store;
	}

	public void setRedundant_Hotel_Store(Integer redundant_Hotel_Store) {
		this.redundant_Hotel_Store = redundant_Hotel_Store;
	}

	public String getRedundant_Province_Name() {
		return redundant_Province_Name;
	}

	public void setRedundant_Province_Name(String redundant_Province_Name) {
		this.redundant_Province_Name = redundant_Province_Name;
	}

	public List<ItripImage> getImage() {
		return image;
	}

	public void setImage(List<ItripImage> image) {
		this.image = image;
	}

	public HotelRoomVo() {
		super();
	}

	public HotelRoomVo(Integer hotel_Id, double price, String address, Integer hotel_Type, Integer city_Id,
			Integer country_Id, String details, String facilities, Integer hotel_Level, String hotel_Name,
			String hotel_Policy, Integer is_Group_Purchase, Integer province_Id, String redundant_City_Name,
			String redundant_Country_Name, Integer redundant_Hotel_Store, String redundant_Province_Name,
			List<ItripImage> image, Integer pageNo, Integer pageSize, Integer count, Integer countSize) {
		super();
		this.hotel_Id = hotel_Id;
		Price = price;
		this.address = address;
		this.hotel_Type = hotel_Type;
		this.city_Id = city_Id;
		this.country_Id = country_Id;
		this.details = details;
		this.facilities = facilities;
		this.hotel_Level = hotel_Level;
		this.hotel_Name = hotel_Name;
		this.hotel_Policy = hotel_Policy;
		this.is_Group_Purchase = is_Group_Purchase;
		this.province_Id = province_Id;
		this.redundant_City_Name = redundant_City_Name;
		this.redundant_Country_Name = redundant_Country_Name;
		this.redundant_Hotel_Store = redundant_Hotel_Store;
		this.redundant_Province_Name = redundant_Province_Name;
		this.image = image;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.count = count;
		this.countSize = countSize;
	}

	@Override
	public String toString() {
		return "HotelRoomVo [hotel_Id=" + hotel_Id + ", Price=" + Price + ", address=" + address + ", hotel_Type="
				+ hotel_Type + ", city_Id=" + city_Id + ", country_Id=" + country_Id + ", details=" + details
				+ ", facilities=" + facilities + ", hotel_Level=" + hotel_Level + ", hotel_Name=" + hotel_Name
				+ ", hotel_Policy=" + hotel_Policy + ", is_Group_Purchase=" + is_Group_Purchase + ", province_Id="
				+ province_Id + ", redundant_City_Name=" + redundant_City_Name + ", redundant_Country_Name="
				+ redundant_Country_Name + ", redundant_Hotel_Store=" + redundant_Hotel_Store
				+ ", redundant_Province_Name=" + redundant_Province_Name + ", image=" + image + ", pageNo=" + pageNo
				+ ", pageSize=" + pageSize + ", count=" + count + ", countSize=" + countSize + "]";
	}

}
