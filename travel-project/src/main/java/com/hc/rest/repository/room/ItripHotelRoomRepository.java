package com.hc.rest.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hc.rest.entity.room.ItripHotelRoom;



/**
 * 酒店房间
 * @author LCL
 *
 */	
public interface ItripHotelRoomRepository extends JpaRepository<ItripHotelRoom, Integer> {

	ItripHotelRoom findAllById(Integer id);
	
}
