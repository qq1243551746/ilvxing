package com.hc.rest.vo.order;

import com.hc.rest.entity.hotel.ItripHotel;
import com.hc.rest.entity.order.HotelOrder;
import com.hc.rest.entity.room.ItripHotelRoom;
import com.hc.rest.entity.user.User;

public class OrderDetailsVo {
	private HotelOrder hotelOrder;
	
	private ItripHotelRoom itripHotelRoom;

	private User user;
	
	private ItripHotel itripHotel;

	public OrderDetailsVo() {
	}

	public OrderDetailsVo(HotelOrder hotelOrder, ItripHotelRoom itripHotelRoom, User user, ItripHotel itripHotel) {
		this.hotelOrder = hotelOrder;
		this.itripHotelRoom = itripHotelRoom;
		this.user = user;
		this.itripHotel = itripHotel;
	}

	public HotelOrder getHotelOrder() {
		return hotelOrder;
	}

	public void setHotelOrder(HotelOrder hotelOrder) {
		this.hotelOrder = hotelOrder;
	}

	public ItripHotelRoom getItripHotelRoom() {
		return itripHotelRoom;
	}

	public void setItripHotelRoom(ItripHotelRoom itripHotelRoom) {
		this.itripHotelRoom = itripHotelRoom;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ItripHotel getItripHotel() {
		return itripHotel;
	}

	public void setItripHotel(ItripHotel itripHotel) {
		this.itripHotel = itripHotel;
	}

	@Override
	public String toString() {
		return "OrderDetailsVo [hotelOrder=" + hotelOrder + ", itripHotelRoom=" + itripHotelRoom + ", user=" + user
				+ ", itripHotel=" + itripHotel + "]";
	}
	
}
