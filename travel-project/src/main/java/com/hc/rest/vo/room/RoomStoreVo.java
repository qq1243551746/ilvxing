package com.hc.rest.vo.room;

import java.sql.Date;
import java.util.List;

import com.hc.rest.entity.room.ItripImage;
/**
 * 房间列表VO层
 * @author LCL
 *
 */
/**
 * @author LCL
 *
 */
public class RoomStoreVo {

	private Integer hotel_Id; //酒店ID
	
	private Integer room_Id; //房间ID 

	private String room_Title; // 房间名称
	
	private Double room_Price; // 房间价格
		
	private Integer room_Bed_Type_Id; //酒店床型
	
	private Integer is_Having_Breakfast; //是否包含早餐
	
	private Integer pay_Type; //1:在线付 2:到店付 3:不限
	
	private Double satisfaAtion; //满意度（冗余字段，在用户评论后更新）
	
	private Integer is_Book; //是否可预订(0:不可以 1:可以)
	
	private Integer is_Cancel; //是否可取消(0:不可 1:可以)
	
	private Integer is_Timely_Response; //是否及时响应(0:不及时 1:及时)
	
	private Integer product_Type;  //商品类型(0:旅游产品 1:酒店产品 2:机票产品)
	
	private Date creation_Date;//入住时间
	
	private Integer product_Id;  //'商品id'
	
	private Integer store; //'商品库存'
	
	private List<ItripImage> image; //图片
	

	public RoomStoreVo() {
	}


	public RoomStoreVo(Integer hotel_Id, Integer room_Id, String room_Title, Double room_Price,
			Integer room_Bed_Type_Id, Integer is_Having_Breakfast, Integer pay_Type, Double satisfaAtion,
			Integer is_Book, Integer is_Cancel, Integer is_Timely_Response, Integer product_Type, Date creation_Date,
			Integer product_Id, Integer store, List<ItripImage> image) {
		this.hotel_Id = hotel_Id;
		this.room_Id = room_Id;
		this.room_Title = room_Title;
		this.room_Price = room_Price;
		this.room_Bed_Type_Id = room_Bed_Type_Id;
		this.is_Having_Breakfast = is_Having_Breakfast;
		this.pay_Type = pay_Type;
		this.satisfaAtion = satisfaAtion;
		this.is_Book = is_Book;
		this.is_Cancel = is_Cancel;
		this.is_Timely_Response = is_Timely_Response;
		this.product_Type = product_Type;
		this.creation_Date = creation_Date;
		this.product_Id = product_Id;
		this.store = store;
		this.image = image;
	}


	public Integer getHotel_Id() {
		return hotel_Id;
	}


	public void setHotel_Id(Integer hotel_Id) {
		this.hotel_Id = hotel_Id;
	}


	public Integer getRoom_Id() {
		return room_Id;
	}


	public void setRoom_Id(Integer room_Id) {
		this.room_Id = room_Id;
	}


	public String getRoom_Title() {
		return room_Title;
	}


	public void setRoom_Title(String room_Title) {
		this.room_Title = room_Title;
	}


	public Double getRoom_Price() {
		return room_Price;
	}


	public void setRoom_Price(Double room_Price) {
		this.room_Price = room_Price;
	}


	public Integer getRoom_Bed_Type_Id() {
		return room_Bed_Type_Id;
	}


	public void setRoom_Bed_Type_Id(Integer room_Bed_Type_Id) {
		this.room_Bed_Type_Id = room_Bed_Type_Id;
	}


	public Integer getIs_Having_Breakfast() {
		return is_Having_Breakfast;
	}


	public void setIs_Having_Breakfast(Integer is_Having_Breakfast) {
		this.is_Having_Breakfast = is_Having_Breakfast;
	}


	public Integer getPay_Type() {
		return pay_Type;
	}


	public void setPay_Type(Integer pay_Type) {
		this.pay_Type = pay_Type;
	}


	public Double getSatisfaAtion() {
		return satisfaAtion;
	}


	public void setSatisfaAtion(Double satisfaAtion) {
		this.satisfaAtion = satisfaAtion;
	}


	public Integer getIs_Book() {
		return is_Book;
	}


	public void setIs_Book(Integer is_Book) {
		this.is_Book = is_Book;
	}


	public Integer getIs_Cancel() {
		return is_Cancel;
	}


	public void setIs_Cancel(Integer is_Cancel) {
		this.is_Cancel = is_Cancel;
	}


	public Integer getIs_Timely_Response() {
		return is_Timely_Response;
	}


	public void setIs_Timely_Response(Integer is_Timely_Response) {
		this.is_Timely_Response = is_Timely_Response;
	}


	public Integer getProduct_Type() {
		return product_Type;
	}


	public void setProduct_Type(Integer product_Type) {
		this.product_Type = product_Type;
	}


	public Date getCreation_Date() {
		return creation_Date;
	}


	public void setCreation_Date(Date creation_Date) {
		this.creation_Date = creation_Date;
	}


	public Integer getProduct_Id() {
		return product_Id;
	}


	public void setProduct_Id(Integer product_Id) {
		this.product_Id = product_Id;
	}


	public Integer getStore() {
		return store;
	}


	public void setStore(Integer store) {
		this.store = store;
	}


	public List<ItripImage> getImage() {
		return image;
	}


	public void setImage(List<ItripImage> image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "RoomStoreVo [hotel_Id=" + hotel_Id + ", room_Id=" + room_Id + ", room_Title=" + room_Title
				+ ", room_Price=" + room_Price + ", room_Bed_Type_Id=" + room_Bed_Type_Id + ", is_Having_Breakfast="
				+ is_Having_Breakfast + ", pay_Type=" + pay_Type + ", satisfaAtion=" + satisfaAtion + ", is_Book="
				+ is_Book + ", is_Cancel=" + is_Cancel + ", is_Timely_Response=" + is_Timely_Response
				+ ", product_Type=" + product_Type + ", creation_Date=" + creation_Date + ", product_Id=" + product_Id
				+ ", store=" + store + ", images=" + image + "]";
	}

	
}
