package com.hc.rest.controller.hotel;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
/*import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.hotel.ItripHotel;
import com.hc.rest.service.hotel.ItripHotelService;
import com.hc.rest.utils.EirunyeException;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.vo.hotel.HotelVo;

@RestController
@RequestMapping("/hotel")
public class ItripHotelController {
	@Autowired
	ItripHotelService itripHotelService;
	
	/*@GetMapping(value = "/info")
	public Result<ItripHotel> getItripHotelDataByhotelType(Pageable pageable){
		Sort sort = new Sort(Sort.Direction.ASC,"id");
		 pageable = new PageRequest(0,3,sort); 
		return itripHotelService.getItriplHotelDataByhotelType(pageable);
	}*/
	
	@GetMapping(value = "/infoId")
	public Result<HotelVo> getHotelDataById(Integer id) throws Exception {
		if (null == id)
			throw new EirunyeException(ResultEnum.UNKNOWN_ERROR);// 这里定义自己的提示错误信息,最好每个都有定义这样比较明确错误!!!
		return itripHotelService.findByHotelId(id);
	}

	@RequestMapping("/findAllHotelInfo")
	public Result<ItripHotel> findAllHotelInfo(ItripHotel itripHotel,String type,Integer Price,Date creationDate,Date modifyDate,Integer pageNo,Integer pageSize,Integer[] checkVal,Integer level,Integer money,Integer total,String cityName,String antistop,Integer[] moneyVal,Integer[] nameVal,Integer[] roomVal)throws Exception{
		/*if(null!=itripHotel)
			throw new EirunyeException(ResultEnum.UNKNOWN_ERROR);*/
		return itripHotelService.getAllHotelInfo(itripHotel, type, Price, creationDate, modifyDate, pageNo, pageSize, checkVal, level, money, total, cityName,antistop,moneyVal,nameVal,roomVal);
	}
}
		