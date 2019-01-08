package com.hc.rest.service.hotel;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;*/
import org.springframework.stereotype.Service;

import com.hc.rest.entity.hotel.ItripHotel;
import com.hc.rest.mapper.hotel.ItripHotelMapper;
import com.hc.rest.repository.hotel.ItripHotelRepository;
import com.hc.rest.repository.room.ItripImageRepository;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;
import com.hc.rest.vo.hotel.HotelRoomVo;
import com.hc.rest.vo.hotel.HotelVo;


@Service
public class ItripHotelService {
	@Autowired
	ItripHotelRepository itripHotelRepository;
	@Autowired
	ItripImageRepository itripImageRepository;
	@Autowired
	ItripHotelMapper itripHotelMapper;
	
	/*@SuppressWarnings("unchecked")
	public Result<ItripHotel> getItriplHotelDataByhotelType(Pageable pageable){
		Page<ItripHotel> itripHotel=itripHotelRepository.findAllByhotelType(pageable);
		return ResultUtil.getResult(ResultEnum.SUCCESS,itripHotel);
	}*/
	
	@SuppressWarnings("unchecked")
	public Result<HotelVo> findByHotelId(Integer id) {
		ItripHotel itripHotel = itripHotelRepository.findAllById(id);
		HotelVo hotelVo = new HotelVo();

		hotelVo.setItripHotel(itripHotel);
		/*for(HotelVo hotelVo1:itripHotel) {
			hotelVo.setImage(itripImageRepository.obtainHotelImage(hotelVo.getItripHotel().getId(), type));
		}*/
		return ResultUtil.getResult(ResultEnum.SUCCESS, hotelVo);
		
	}
	
	@SuppressWarnings({ "unchecked"})
	/*int getTotalPages() 总页数
	long getTotalElements() 总记录数
	List getContent() 返回此次查询的结果集*/
	public Result<ItripHotel> getAllHotelInfo(ItripHotel itripHotel,String type,Integer Price,Date creationDate,Date modifyDate,Integer pageNo,Integer pageSize,Integer[] checkVal,Integer level,Integer money,Integer total,String cityName,String antistop,Integer[] moneyVal,Integer[] nameVal,Integer[] roomVal){
		/*Pageable pageable = null;
		if(pageNo!=null && pageSize!=null){
			pageable= new PageRequest((pageNo - 1)*pageSize, pageSize);
		}*/
		List<HotelRoomVo> listCount=null;
		List<HotelRoomVo> list = itripHotelMapper.findAllHotelInfo(itripHotel, Price, creationDate, modifyDate, checkVal, level, money, total, pageNo, pageSize, cityName,antistop,moneyVal,nameVal,roomVal);
		//Page<HotelRoomVo> page=	new PageImpl<>(list, pageable,list.size());
		int pageCount=0;
		listCount=itripHotelMapper.findAllHotelInfoCount(itripHotel, Price, creationDate, modifyDate, checkVal, level, money, total, pageNo, pageSize, cityName, antistop, moneyVal, nameVal,roomVal);
		pageCount= listCount.size() % pageSize == 0 ? listCount.size() / pageSize : listCount.size() / pageSize + 1;// 总记录数
		 if(pageNo==null||pageNo<1) {
			 pageNo=1;
		 }else if(pageNo> pageCount) {
			 pageNo = pageCount;
		 }
		for (HotelRoomVo hotelRoom : list) {
			hotelRoom.setImage(itripImageRepository.obtainHotelImage(hotelRoom.getHotel_Id(),type));
			hotelRoom.setCount(pageCount);
			hotelRoom.setCountSize(listCount.size());
			hotelRoom.setPageNo(pageNo);
			hotelRoom.setPageSize(pageSize);
		}	
		return ResultUtil.getResult(ResultEnum.SUCCESS, list);
	}
}
