package com.hc.rest.mapper.hotel;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;


import com.hc.rest.entity.hotel.ItripHotel;
import com.hc.rest.mapper.hotelsql.ItripHotelMapperSql;
import com.hc.rest.vo.hotel.HotelRoomVo;

@Mapper
public interface ItripHotelMapper {
	/**
	 * 查询酒店的信息
	 * @param itripHotel 传入对象参数
	 * @return 返回一个VO层的对象集合 
	 */
	@SelectProvider(method = "findAllHotelInfo", type = ItripHotelMapperSql.class)
	public List<HotelRoomVo> findAllHotelInfo(ItripHotel itripHotel,Integer Price,Date creationDate,Date modifyDate,Integer[] checkVal,Integer level,Integer money,Integer total,Integer pageNo, Integer pageSize,String cityName,String antistop,Integer[] moneyVal,Integer[] nameVal,Integer[] roomVal);
	
	@SelectProvider(method = "findAllHotelInfoCount", type = ItripHotelMapperSql.class)
	public List<HotelRoomVo> findAllHotelInfoCount(ItripHotel itripHotel,Integer Price,Date creationDate,Date modifyDate,Integer[] checkVal,Integer level,Integer money,Integer total,Integer pageNo, Integer pageSize,String cityName,String antistop,Integer[] moneyVal,Integer[] nameVal,Integer[] roomVal);
}
