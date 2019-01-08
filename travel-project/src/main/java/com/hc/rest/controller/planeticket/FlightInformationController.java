package com.hc.rest.controller.planeticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.planeticket.FlightInformation;
import com.hc.rest.service.planeticket.FlightInformationService;
import com.hc.rest.utils.Result;

@RestController
@RequestMapping("/flightInfo")
public class FlightInformationController {

	@Autowired
	FlightInformationService flightInformationService;
	
	@RequestMapping("/getFlightInfo")
	public Result<FlightInformation> getFlightInfo(Integer fId){
		return flightInformationService.findFlightInformationInfo(fId);
	}
	
}
