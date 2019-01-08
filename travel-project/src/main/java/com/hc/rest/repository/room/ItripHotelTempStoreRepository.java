package com.hc.rest.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hc.rest.entity.room.ItripHotelTempStore;

public interface ItripHotelTempStoreRepository extends JpaRepository<ItripHotelTempStore, Integer> {
	
	/**
	 * 查询此房间的库存
	 * @param roomId
	 * @return 
	 */
	ItripHotelTempStore findByRoomId(Integer roomId);
		
	/**
	 * 预订成功修改房间库存
	 * @param roomId
	 * @return 
	 */
	@Modifying
	@Query(value="update itrip_hotel_temp_store set store=store-:roomNum where room_id=:roomId",nativeQuery=true)
	Integer updateByStore(@Param("roomId")Integer roomId,@Param("roomNum") Integer roomNum);
	
	
}
