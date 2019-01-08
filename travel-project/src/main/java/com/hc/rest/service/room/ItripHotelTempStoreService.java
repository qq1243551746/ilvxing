package com.hc.rest.service.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.rest.entity.room.ItripHotelTempStore;
import com.hc.rest.repository.room.ItripHotelTempStoreRepository;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;

@Service
public class ItripHotelTempStoreService {
	
	
	@Autowired
	ItripHotelTempStoreRepository itripHotelTempStoreRepository;
	
	@SuppressWarnings("unchecked")
	public Result<ItripHotelTempStore> findAllByRoomStore(Integer roomId){
		ItripHotelTempStore itripHotelTempStore = itripHotelTempStoreRepository.findByRoomId(roomId);
		return ResultUtil.getResult(ResultEnum.SUCCESS, itripHotelTempStore);
	}
	
}
