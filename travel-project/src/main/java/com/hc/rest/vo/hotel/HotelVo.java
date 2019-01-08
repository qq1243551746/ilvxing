package com.hc.rest.vo.hotel;

import java.util.List;

import com.hc.rest.entity.hotel.ItripHotel;
import com.hc.rest.entity.room.ItripImage;

public class HotelVo {
	private ItripHotel itripHotel;
	private List<ItripImage> image; //图片
	public ItripHotel getItripHotel() {
		return itripHotel;
	}
	public void setItripHotel(ItripHotel itripHotel) {
		this.itripHotel = itripHotel;
	}
	public List<ItripImage> getImage() {
		return image;
	}
	public void setImage(List<ItripImage> image) {
		this.image = image;
	}
	
}
