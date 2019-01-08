package com.hc.rest.service.planeticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.rest.entity.planeticket.Airline;
import com.hc.rest.repository.planeticket.AirlineRepository;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;

@Service
public class AirlineService{
	
	@Autowired
	AirlineRepository airlineRepository;
	
	@SuppressWarnings("unchecked")
	public Result<Airline> findAirlineInfo(){
		List<Airline> list = airlineRepository.findAll();
		return ResultUtil.getResult(ResultEnum.SUCCESS, list);
	}
	
}
