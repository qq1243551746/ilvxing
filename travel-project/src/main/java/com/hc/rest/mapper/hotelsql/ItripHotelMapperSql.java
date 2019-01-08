package com.hc.rest.mapper.hotelsql;

import java.util.Date;


import com.hc.rest.entity.hotel.ItripHotel;

public class ItripHotelMapperSql {
	
	public String findAllHotelInfo(ItripHotel itripHotel,Integer Price,Date creationDate,Date modifyDate,Integer[] checkVal,Integer level,Integer money,Integer total,Integer pageNo,Integer pageSize,String cityName,String antistop,Integer[] moneyVal,Integer[] nameVal,Integer[] roomVal) {
		StringBuffer sql = new StringBuffer("select  h.`id` hotel_Id,MIN(r.`room_price`)  as price,h.`address`,h.`hotel_type`,h.`city_id`,h.`country_id`,h.`details`,"
				+ "h.`facilities`,h.`hotel_level`,h.`hotel_name`,h.`hotel_policy`,h.`is_group_purchase`,h.`province_id`,h.`redundant_city_name`,h.`redundant_country_name`,h.`redundant_hotel_store`,"
	+"h.`redundant_province_name`,h.`creation_date`,h.`modify_date`,r.`is_book`,r.room_title,r.`pay_type` from itrip_hotel as h, itrip_hotel_room as r"
	+" where r.`hotel_id`=h.`id` group by h.`id` having  h.`redundant_hotel_store`>0  ");	
		
		/*if(null!=creationDate && null==modifyDate) {
			sql.append(" and r.creation_date >='"+creationDate+"'");
		}else if(null!=modifyDate && null!=creationDate) {
			sql.append(" and r.creation_date BETWEEN '"+creationDate+"' and '"+modifyDate+"'");
		}*/
			if(null!=cityName&&!"".equals(cityName)) {
				sql.append(" and (h.redundant_city_name like '%" + cityName + "%' or h.redundant_country_name like '%" + cityName
						+ "%' or h.redundant_province_name like '%" + cityName + "%') ");
				System.out.println("目的地："+sql);
			}
			if(null!=antistop&&!"".equals(antistop)) {
				sql.append(" and (h.`address` like '%" + antistop + "%' or h.`hotel_name` like '%" + antistop
						+ "%' or redundant_country_name like '%" + antistop + "%') ");
				System.out.println("关键词:"+sql);
			}
			if(null!=itripHotel.getRedundantCountryName()) {
				sql.append(" and h.redundant_country_name like "+"'"+"%"+ itripHotel.getRedundantCountryName()+"%"+"'");
			}
			if(null!=roomVal) {
				if(roomVal[0]==1) {
					sql.append(" and r.`is_book`=1");
				}
				if(roomVal[0]==2) {
					sql.append(" and r.`pay_type`=1");
				}
				if(roomVal[0]==3) {
					sql.append(" and r.`room_title` like '%钟点房%'");
				}
				for(int i=1;i<roomVal.length;i++) {
					if(roomVal[i]==1) {
						sql.append(" and r.`is_book`=1");
					}
					if(roomVal[i]==2) {
						sql.append(" and r.`pay_type`=1");
					}
					if(roomVal[i]==3) {
						sql.append(" and r.`room_title` like '%钟点房%'");
					}
				}
				System.out.println("room:"+sql);
			}
			if(null!=checkVal) {
				sql.append(" and (h.`hotel_level`="+checkVal[0]);
				for(int i=1;i<checkVal.length;i++) {
					sql.append(" or h.`hotel_level`="+checkVal[i]);
				}
				sql.append(")");
				System.out.println("星级:"+sql);
			}
			
		if (null != moneyVal) {
				if(moneyVal[0]==1) {
					sql.append(" and (price<150");
				}
				if(moneyVal[0]==2) {
					sql.append(" and (price>=150 and price<=300");
				}
				if(moneyVal[0]==3) {
					sql.append(" and (price>=301 and price<=450");
				}
				if(moneyVal[0]==4) {
					sql.append(" and (price>450");
				}
			for(int i=1;i<moneyVal.length;i++) {
					if(moneyVal[i]==1) {
						sql.append(" or price<150");
					}
					if(moneyVal[i]==2) {
						sql.append(" or price>=150 or price<=300");
					}
					if(moneyVal[i]==3) {
						sql.append(" or price>=301 or price<=450");
					}
					if(moneyVal[i]==4) {
						sql.append(" or price>450");
					}
			}
			sql.append(")");
			System.out.println("价钱：" + sql);
		}
		if(null!=nameVal) {
			if(nameVal[0]==1) {
				sql.append(" and h.`facilities` like '%无线上网%'");
			}
			if(nameVal[0]==2) {
				sql.append(" and h.`facilities` like '%停车场%'");
			}
			if(nameVal[0]==3) {
				sql.append(" and h.`facilities` like '%会议厅%'");
			}
			if(nameVal[0]==4) {
				sql.append(" and h.`facilities` like '%游泳池%'");
			}
			if(nameVal[0]==5) {
				sql.append(" and h.`facilities` like '%景阳台%'");
			}
			if(nameVal[0]==6) {
				sql.append(" and h.`facilities` like '%餐厅%'");
			}
			for(int i=1;i<nameVal.length;i++) {
				if(nameVal[i]==1) {
					sql.append(" and h.`facilities` like '%无线上网%'");
				}
				if(nameVal[i]==2) {
					sql.append(" and h.`facilities` like '%停车场%'");
				}
				if(nameVal[i]==3) {
					sql.append(" and h.`facilities` like '%会议厅%'");
				}
				if(nameVal[i]==4) {
					sql.append(" and h.`facilities` like '%游泳池%'");
				}
				if(nameVal[i]==5) {
					sql.append(" and h.`facilities` like '%景阳台%'");
				}
				if(nameVal[i]==6) {
					sql.append(" and h.`facilities` like '%餐厅%'");
				}
			}
			System.out.println("设施："+sql);
		}
			if(null!=itripHotel.getHotelType()) {
				sql.append(" and h.hotel_type="+ itripHotel.getHotelType());
			}
			
			if(level!=null) {
				if(level==1) {
					sql.append(" order by h.`hotel_level` desc");
				}else if(level==2) {
					sql.append(" order by h.`hotel_level` ");
				}
				System.out.println("level排序:"+sql);
			}
			
			if(money!=null) {
				if(money==1) {
					sql.append(" order by price");
				}else if(money==2) {
					sql.append(" order by price desc");
				}
				System.out.println("money排序:"+sql);
			}
			Integer pageIndex = (pageNo - 1) * pageSize;// 计算当前页码
			if(pageIndex!=null&&pageSize!=null) {
				sql.append(" limit " + pageIndex + "," + pageSize + "");
				System.out.println("分页："+sql);
			}
		return sql.toString();
	}
	
	public String findAllHotelInfoCount(ItripHotel itripHotel,Integer Price,Date creationDate,Date modifyDate,Integer[] checkVal,Integer level,Integer money,Integer total,Integer pageNo,Integer pageSize,String cityName,String antistop,Integer[] moneyVal,Integer[] nameVal,Integer[] roomVal) {
		StringBuffer sql = new StringBuffer("select  h.`id` hotel_Id,MIN(r.`room_price`)  as price,h.`address`,h.`hotel_type`,h.`city_id`,h.`country_id`,h.`details`,"
				+ "h.`facilities`,h.`hotel_level`,h.`hotel_name`,h.`hotel_policy`,h.`is_group_purchase`,h.`province_id`,h.`redundant_city_name`,h.`redundant_country_name`,h.`redundant_hotel_store`,"
	+"h.`redundant_province_name`,h.`creation_date`,h.`modify_date`,r.`is_book`,r.room_title,r.`pay_type` from itrip_hotel as h, itrip_hotel_room as r"
	+" where r.`hotel_id`=h.`id` group by h.`id` having  h.`redundant_hotel_store`>0  ");	
					
					/*if(null!=creationDate && null==modifyDate) {
						sql.append(" and r.creation_date >='"+creationDate+"'");
					}else if(null!=modifyDate && null!=creationDate) {
						sql.append(" and r.creation_date BETWEEN '"+creationDate+"' and '"+modifyDate+"'");
					}*/
		if(null!=cityName&&!"".equals(cityName)) {
			sql.append(" and (h.redundant_city_name like '%" + cityName + "%' or h.redundant_country_name like '%" + cityName
					+ "%' or h.redundant_province_name like '%" + cityName + "%') ");
			System.out.println("目的地："+sql);
		}
		if(null!=antistop&&!"".equals(antistop)) {
			sql.append(" and (h.`address` like '%" + antistop + "%' or h.`hotel_name` like '%" + antistop
					+ "%' or redundant_country_name like '%" + antistop + "%') ");
			System.out.println("关键词:"+sql);
		}
		if(null!=itripHotel.getRedundantCountryName()) {
			sql.append(" and h.redundant_country_name like "+"'"+"%"+ itripHotel.getRedundantCountryName()+"%"+"'");
		}
		if(null!=roomVal) {
			if(roomVal[0]==1) {
				sql.append(" and r.`is_book`=1");
			}
			if(roomVal[0]==2) {
				sql.append(" and r.`pay_type`=1");
			}
			if(roomVal[0]==3) {
				sql.append(" and r.`room_title` like '%钟点房%'");
			}
			for(int i=1;i<roomVal.length;i++) {
				if(roomVal[i]==1) {
					sql.append(" and r.`is_book`=1");
				}
				if(roomVal[i]==2) {
					sql.append(" and r.`pay_type`=1");
				}
				if(roomVal[i]==3) {
					sql.append(" and r.`room_title` like '%钟点房%'");
				}
			}
			System.out.println("room:"+sql);
		}
		if(null!=checkVal) {
			sql.append(" and (h.`hotel_level`="+checkVal[0]);
			for(int i=1;i<checkVal.length;i++) {
				sql.append(" or h.`hotel_level`="+checkVal[i]);
			}
			sql.append(")");
			System.out.println("星级:"+sql);
		}
		
	if (null != moneyVal) {
			if(moneyVal[0]==1) {
				sql.append(" and (price<150");
			}
			if(moneyVal[0]==2) {
				sql.append(" and (price>=150 and price<=300");
			}
			if(moneyVal[0]==3) {
				sql.append(" and (price>=301 and price<=450");
			}
			if(moneyVal[0]==4) {
				sql.append(" and (price>450");
			}
		for(int i=1;i<moneyVal.length;i++) {
				if(moneyVal[i]==1) {
					sql.append(" or price<150");
				}
				if(moneyVal[i]==2) {
					sql.append(" or price>=150 or price<=300");
				}
				if(moneyVal[i]==3) {
					sql.append(" or price>=301 or price<=450");
				}
				if(moneyVal[i]==4) {
					sql.append(" or price>450");
				}
		}
		sql.append(")");
		System.out.println("价钱：" + sql);
	}
	if(null!=nameVal) {
		if(nameVal[0]==1) {
			sql.append(" and h.`facilities` like '%无线上网%'");
		}
		if(nameVal[0]==2) {
			sql.append(" and h.`facilities` like '%停车场%'");
		}
		if(nameVal[0]==3) {
			sql.append(" and h.`facilities` like '%会议厅%'");
		}
		if(nameVal[0]==4) {
			sql.append(" and h.`facilities` like '%游泳池%'");
		}
		if(nameVal[0]==5) {
			sql.append(" and h.`facilities` like '%景阳台%'");
		}
		if(nameVal[0]==6) {
			sql.append(" and h.`facilities` like '%餐厅%'");
		}
		for(int i=1;i<nameVal.length;i++) {
			if(nameVal[i]==1) {
				sql.append(" and h.`facilities` like '%无线上网%'");
			}
			if(nameVal[i]==2) {
				sql.append(" and h.`facilities` like '%停车场%'");
			}
			if(nameVal[i]==3) {
				sql.append(" and h.`facilities` like '%会议厅%'");
			}
			if(nameVal[i]==4) {
				sql.append(" and h.`facilities` like '%游泳池%'");
			}
			if(nameVal[i]==5) {
				sql.append(" and h.`facilities` like '%景阳台%'");
			}
			if(nameVal[i]==6) {
				sql.append(" and h.`facilities` like '%餐厅%'");
			}
		}
		System.out.println("设施："+sql);
	}
		if(null!=itripHotel.getHotelType()) {
			sql.append(" and h.hotel_type="+ itripHotel.getHotelType());
		}
		
		if(level!=null) {
			if(level==1) {
				sql.append(" order by h.`hotel_level` desc");
			}else if(level==2) {
				sql.append(" order by h.`hotel_level` ");
			}
			System.out.println("level排序:"+sql);
		}
		
		if(money!=null) {
			if(money==1) {
				sql.append(" order by price");
			}else if(money==2) {
				sql.append(" order by price desc");
			}
			System.out.println("money排序:"+sql);
		}
						
		return sql.toString();
	}
}
