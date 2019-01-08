package com.hc.rest.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hc.rest.entity.room.ItripProductStore;

public interface ItripProductStoreRepository extends JpaRepository<ItripProductStore, Integer> {
	
	/**
	 *  
	 * @param rooId 根据房间ID查询房间的库存数量
	 * @return 返回当前查询对象
	 */
	@Query(value="select s from ItripProductStore s where s.productId =:rooId")
	ItripProductStore obtainRoomStore(@Param("rooId")Integer rooId);
	
}
