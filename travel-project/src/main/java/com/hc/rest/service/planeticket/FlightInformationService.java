package com.hc.rest.service.planeticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.rest.entity.planeticket.FlightInformation;
import com.hc.rest.repository.planeticket.FlightInformationRepository;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;
 
@Service
public class FlightInformationService {

	@Autowired
	FlightInformationRepository flightInformationRepository;
	
	@SuppressWarnings("unchecked")
	public Result<FlightInformation> findFlightInformationInfo(Integer fId){
		List<FlightInformation> list = flightInformationRepository.findByid(fId);
		if(list.size()>0) {
			return ResultUtil.getResult(ResultEnum.SUCCESS, list);
		}else {
			return ResultUtil.getResult(ResultEnum.NODATA, list);
		}
	}
	
	
}
 