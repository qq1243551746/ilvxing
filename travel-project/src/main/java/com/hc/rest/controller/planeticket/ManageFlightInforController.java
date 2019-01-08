package com.hc.rest.controller.planeticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.planeticket.ManageFlightInfor;
import com.hc.rest.service.planeticket.ManageFlightInforService;
import com.hc.rest.utils.Result;
import com.hc.rest.vo.airticket.ManageFlightInforVo;
import com.hc.rest.vo.planeticket.FlightVo;

@RestController
@RequestMapping("/managerFlightInfo")
public class ManageFlightInforController {

	@Autowired
	ManageFlightInforService manageFlightInforService;

	@RequestMapping("getManagerInfo")
	public Result<FlightVo> getManagerInfo(FlightVo flightVo) {
		return manageFlightInforService.findFlightInforMation(flightVo);
	}


	/**
	 * 查询特价航班信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/info/getFlightInfor")
	public Result<ManageFlightInforVo> findAllFlightInfo(ManageFlightInfor manageFlightInfor, Integer month) {

		return manageFlightInforService.findAllFlightInfo(manageFlightInfor, month);
	}
}
