package com.hc.rest.controller.planeticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.planeticket.Airline;
import com.hc.rest.service.planeticket.AirlineService;
import com.hc.rest.utils.Result;

@RestController
@RequestMapping("/airLine")
public class AirLineController {

	@Autowired
	AirlineService airlineService;
	
	@RequestMapping("/airInfo")
	public Result<Airline> getAirLineInfo(){
		return airlineService.findAirlineInfo();
	}
	
	
}
