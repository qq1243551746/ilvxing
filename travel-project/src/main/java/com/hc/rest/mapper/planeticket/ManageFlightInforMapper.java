package com.hc.rest.mapper.planeticket;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.hc.rest.entity.planeticket.ManageFlightInfor;
import com.hc.rest.mapper.planeticketsql.ManageFlightInforMapperSql;
import com.hc.rest.vo.airticket.ManageFlightInforVo;
import com.hc.rest.vo.planeticket.FlightVo;

@Mapper
public interface ManageFlightInforMapper {
	
	
	@SelectProvider(method="findManageFlightInforInfo",type=ManageFlightInforMapperSql.class)
	List<FlightVo> findInfoManageFlightInfor(FlightVo flightVo);
	
	/**
	 * 查询航班信息
	 * 
	 * @param manageFlightInfor
	 * @return
	 */
	@SelectProvider(method = "findAllFlightInfo", type = ManageFlightInforMapperSql.class)
	public List<ManageFlightInforVo> findAllFlightInfo(ManageFlightInfor manageFlightInfor, Integer month);
	
}
