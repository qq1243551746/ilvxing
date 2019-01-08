package com.hc.rest.vo.room;

import com.hc.rest.entity.personal.Contact;
import com.hc.rest.entity.room.ItripHotelRoom;
/**
 * 预订Vo
 * @author LCL
 *
 */
public class InsuredAndBeSuredVo {

	private ItripHotelRoom itripHotelRoom;
	
	private Double payAmount;
	
	private Contact contacts;
	
	private String linkUserName;
	
	private Integer roomNumber;

	
	public InsuredAndBeSuredVo() {
	}


	public InsuredAndBeSuredVo(ItripHotelRoom itripHotelRoom, Double payAmount, Contact contacts, String linkUserName,
			Integer roomNumber) {
		this.itripHotelRoom = itripHotelRoom;
		this.payAmount = payAmount;
		this.contacts = contacts;
		this.linkUserName = linkUserName;
		this.roomNumber = roomNumber;
	}


	public ItripHotelRoom getItripHotelRoom() {
		return itripHotelRoom;
	}


	public void setItripHotelRoom(ItripHotelRoom itripHotelRoom) {
		this.itripHotelRoom = itripHotelRoom;
	}


	public Double getPayAmount() {
		return payAmount;
	}


	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}


	public Contact getContacts() {
		return contacts;
	}


	public void setContacts(Contact contacts) {
		this.contacts = contacts;
	}


	public String getLinkUserName() {
		return linkUserName;
	}


	public void setLinkUserName(String linkUserName) {
		this.linkUserName = linkUserName;
	}


	public Integer getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	@Override
	public String toString() {
		return "InsuredAndBeSuredVo [itripHotelRoom=" + itripHotelRoom + ", payAmount=" + payAmount + ", contacts="
				+ contacts + ", linkUserName=" + linkUserName + ", roomNumber=" + roomNumber + "]";
	}

}
