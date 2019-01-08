package com.hc.rest.mapper.planeticketsql;

import com.hc.rest.entity.planeticket.ManageFlightInfor;
import com.hc.rest.vo.planeticket.FlightVo;

public class ManageFlightInforMapperSql {
	
	@SuppressWarnings("unlikely-arg-type")
	public String findManageFlightInforInfo(FlightVo flightVo) {
		boolean ber = null!=flightVo.getBunkType();
		String str1 = ",itrip_flight_information f";
		String str2 = "";
		String str3 = " and f.fl_id=m.id";
		StringBuffer sql = new StringBuffer("select m.arriving_airport arrivingAirport,m.flight_name flightName,m.ending_time endingTime,m.starting_time startingTime,m.flight_type flightType,m.company company,m.id id,m.limit_cusmnum limitCusmnum,m.one_way_price oneWayprice,m.present_cusmnun presentCusmnun,m.staciry staciry,m.start_ariport startAriport,m.tarrcity,a.`name` name,TIMESTAMPDIFF(HOUR,m.starting_time,m.ending_time) AS diffhour,TIMESTAMPDIFF(MINUTE,m.starting_time,m.ending_time) AS diffminute,DATE_FORMAT(m.starting_time,'%H:%i') as startime,DATE_FORMAT(m.ending_time,'%H:%i') as endtime ");
		sql.append(" from itrip_manage_flight_infor m,itrip_airline a"+(ber==true?str1:str2));
		sql.append(" where m.company=a.id"+(ber==true?str3:str2));
		
		if(null!=flightVo.getStartingTime()&& !"".equals(flightVo.getStartingTime())) {
			sql.append(" and date_format(m.starting_time,'%Y-%m-%d')='"+flightVo.getStartingTime()+"'");
		}
		if(null!=flightVo.getEndingTime()&& !"".equals(flightVo.getEndingTime())){
			sql.append(" and date_format(m.starting_time,'%Y-%m-%d')='"+flightVo.getEndingTime()+"'");
		}
		if(null!=flightVo.getBunkType()&& !"".equals(flightVo.getBunkType())){
			sql.append(" and f.bunk_type="+flightVo.getBunkType());
		}
		if(null!=flightVo.getAirId()&& !"".equals(flightVo.getAirId())) {
			sql.append(" and a.id="+flightVo.getAirId());
		}
		if(null!=flightVo.getStaciry()&& !"".equals(flightVo.getStaciry())){
			sql.append(" and m.staciry like'%"+flightVo.getStaciry()+"%'");
		}
		if(null!=flightVo.getTarrcity()&& !"".equals(flightVo.getTarrcity())) {
			sql.append(" and m.tarrcity like'%"+flightVo.getTarrcity()+"%'");
		}
		if(null!=flightVo.getCompany() && !"".equals(flightVo.getCompany())) {
			sql.append(" and m.company="+flightVo.getCompany());
		}
		sql.append(" and m.starting_time>SYSDATE() group by m.id ");
		
	/*	if(null!=flightVo.getPageIndex()&& null!=flightVo.getPageSize()) {
			sql.append("limit "+(flightVo.getPageIndex()-1)*flightVo.getPageSize()+","+flightVo.getPageSize());
		}*/
		
		return sql.toString();
	}
	
	

	public String findAllFlightInfo(ManageFlightInfor manageFlightInfor, Integer month) {
		StringBuffer sql = new StringBuffer("SELECT mf.staciry staciry,mf.tarrcity tarrcity,mf.starting_time a,DATE_FORMAT(mf.starting_time,'%m月%d日') startingTime,DATE_FORMAT(mf.ending_time,'%m月%d日') endingTime,fma.discount discount,MIN(fma.price) price,(mf.limit_cusmnum-mf.present_cusmnun) number FROM itrip_manage_flight_infor mf LEFT JOIN itrip_flight_information fma ON mf.id=fma.fl_id GROUP BY mf.id HAVING  a>NOW() ");

		if (manageFlightInfor != null && manageFlightInfor.getStaciry() != null && !manageFlightInfor.getStaciry().equals("")) {
			sql.append(" and staciry like " + "'" + "%" + manageFlightInfor.getStaciry() + "%" + "'");
		}
		if (month != null && month != 0) {
			sql.append(" and MONTH(a)=" + month);
		}
		return sql.toString();

	}
	
	
}
