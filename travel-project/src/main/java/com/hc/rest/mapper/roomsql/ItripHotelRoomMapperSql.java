package com.hc.rest.mapper.roomsql;

import com.hc.rest.entity.room.ItripHotelRoom;

public class ItripHotelRoomMapperSql {

	public String findAllRoomInfo(ItripHotelRoom itripHotelRoom) {
		StringBuffer sql = new StringBuffer("select r.id room_id,r.room_title,r.hotel_id,r.is_book,r.is_cancel,r.is_having_breakfast,r.is_timely_response,r.pay_type," + 
				"r.room_bed_type_id,r.room_price,r.satisfaction,r.creation_date,r.modify_date,r.creation_date," + 
				"s.product_id,s.product_type,s.store" + 
				" from itrip_product_store s,itrip_hotel_room r where s.product_id=r.id" + 
				" and s.product_type = 1 ");
			
			//时间范围
			if(null!=itripHotelRoom.getCreationDate() && null==itripHotelRoom.getModifyDate()) {
				sql.append(" and r.creation_date >='"+itripHotelRoom.getCreationDate()+"'");
			}else if(null!=itripHotelRoom.getModifyDate() && null!=itripHotelRoom.getCreationDate()) {
				sql.append(" and r.creation_date BETWEEN '"+itripHotelRoom.getCreationDate()+"' and '"+itripHotelRoom.getModifyDate()+"'");
			}
			 		
			//酒店ID
			if(null!=itripHotelRoom.getHotelId()) {
				sql.append(" and r.hotel_Id="+ itripHotelRoom.getHotelId());
			}
			//是否可预订
			if(null!=itripHotelRoom.getIsBook()) {
				sql.append(" and r.is_Book="+ itripHotelRoom.getIsBook());
			}
			//是否可取消
			if(null!=itripHotelRoom.getIsCancel()) {
				sql.append(" and r.is_Cancel="+ itripHotelRoom.getIsCancel());
			}
			//是否包含早餐
			if(null!=itripHotelRoom.getIsHavingBreakfast()) {
				sql.append(" and r.is_having_breakfast="+ itripHotelRoom.getIsHavingBreakfast());
			}
			//付款类型
			if(null!=itripHotelRoom.getPayType()) {
				sql.append(" and r.pay_Type="+ itripHotelRoom.getPayType());
			}
			//酒店床型
			if(null!=itripHotelRoom.getRoomBedTypeId()) {
				sql.append(" and r.room_bed_type_id="+ itripHotelRoom.getRoomBedTypeId());
			}
		return sql.toString();
	}
	
}
