package com.hc.rest.service.planeticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.rest.entity.planeticket.ManageFlightInfor;
import com.hc.rest.mapper.planeticket.ManageFlightInforMapper;
import com.hc.rest.repository.planeticket.AirlineRepository;
import com.hc.rest.repository.planeticket.FlightInformationRepository;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;
import com.hc.rest.vo.airticket.ManageFlightInforVo;
import com.hc.rest.vo.planeticket.FlightVo;

@Service
public class ManageFlightInforService {

	@Autowired
	ManageFlightInforMapper mfMapper;

	@Autowired
	AirlineRepository airlineRepository;

	@Autowired
	FlightInformationRepository flightInformationRepository;

	@SuppressWarnings("unchecked")
	public Result<FlightVo> findFlightInforMation(FlightVo flightVo) {
		List<FlightVo> list = mfMapper.findInfoManageFlightInfor(flightVo);
		for (FlightVo flightVo2 : list) {
			flightVo2.setFlightInformations(flightInformationRepository.findByid(flightVo2.getId()));
		}
		if (list.size() > 0) {
			return ResultUtil.getResult(ResultEnum.SUCCESS, list);
		} else {
			return ResultUtil.getResult(ResultEnum.NODATA, list);
		}
	}

	/**
	 * 查询航班信息
	 * @param manageFlightInfor
	 * @param month
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<ManageFlightInforVo> findAllFlightInfo(ManageFlightInfor manageFlightInfor, Integer month) {
		List<ManageFlightInforVo> list = mfMapper.findAllFlightInfo(manageFlightInfor, month);
		return ResultUtil.getResult(ResultEnum.SUCCESS, list);
	}
}
