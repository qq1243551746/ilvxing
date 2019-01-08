package com.hc.rest.repository.hotel;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hc.rest.entity.hotel.ItripHotel;

public interface ItripHotelRepository extends JpaRepository<ItripHotel, Integer>{
	List<ItripHotel> findAllByhotelType(Integer hotelType,Pageable pageable);
	
	ItripHotel findAllById(Integer id);
	
	List<ItripHotel> findAll(Specification<ItripHotel> specification,Pageable pageable);
}
