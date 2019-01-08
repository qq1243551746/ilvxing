package com.hc.rest.repository.order;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hc.rest.entity.order.HotelOrder;

/**
 * 酒店订单
 * @author Administrator
 *
 */
public interface HotelOrderRepository extends JpaRepository<HotelOrder, Integer> {
	
	HotelOrder findAllById(Integer id);
	
	List<HotelOrder> findByUserId(Integer userId); 
	
	List<HotelOrder> findAll(Specification<HotelOrder> specification,Pageable pageable);
	
	@Modifying
	@Query(value="UPDATE itrip_hotel_order SET order_status=:orderStatus where id=:id",nativeQuery=true)
     Integer updateById(@Param("orderStatus")String orderStatus,@Param("id")Integer id);
	
	
	
}
