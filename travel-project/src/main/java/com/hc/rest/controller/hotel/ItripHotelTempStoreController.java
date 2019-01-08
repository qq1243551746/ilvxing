package com.hc.rest.controller.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.room.ItripHotelTempStore;
import com.hc.rest.service.room.ItripHotelTempStoreService;
import com.hc.rest.utils.Result;

@RestController
@RequestMapping("/hotelStore")
public class ItripHotelTempStoreController {

	@Autowired
	ItripHotelTempStoreService itripHotelTempStoreService;
	
	@RequestMapping("/getRoomStore")
	public Result<ItripHotelTempStore> findByRoomStore(Integer roomId){
		return itripHotelTempStoreService.findAllByRoomStore(roomId);
	}
	
}
