package com.hc.rest.mapper.room;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.hc.rest.entity.room.ItripHotelRoom;
import com.hc.rest.mapper.roomsql.ItripHotelRoomMapperSql;
import com.hc.rest.vo.room.RoomStoreVo;

@Mapper
public interface ItripHotelRoomMapper {
	
	/**
	 * 查询房间的信息 
	 * @param itripHotelRoom 传入对象参数
	 * @return 返回一个VO层的对象集合 
	 */
	@SelectProvider(method = "findAllRoomInfo", type = ItripHotelRoomMapperSql.class)
	public List<RoomStoreVo> findAllRoomInfo(ItripHotelRoom itripHotelRoom);
	
}
