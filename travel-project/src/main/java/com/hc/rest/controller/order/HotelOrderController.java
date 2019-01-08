package com.hc.rest.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.order.HotelOrder;
import com.hc.rest.service.order.HotelOrderService;
import com.hc.rest.utils.EirunyeException;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.vo.order.OrderDetailsVo;

@RestController
@RequestMapping("/hotelOrder")
public class HotelOrderController {
	
	
	@Autowired
	HotelOrderService hotelOrderService;
	
	
	/**
	 * 通过ID参数
	 *
	 * @param id
	 *            参数id
	 * @return 返回提示 参数成功或者失败
	 */
	@GetMapping(value = "/info/delete")
	public Result<String> deleteHotelOrderInfo(Integer id) throws Exception {
		
		if (null == id)
			throw new EirunyeException(ResultEnum.UNKNOWN_ERROR);

		return hotelOrderService.deleteById(id);
	}
	
	
	@GetMapping(value="/info/list")
	public Result<OrderDetailsVo> findByIdDate(Integer id) throws Exception{
		if(null==id)
			throw new EirunyeException(ResultEnum.UNKNOWN_ERROR);
		
		return hotelOrderService.findById(id);
	}
	/**
	 * @param hotelOrder
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/info/listAll")
	public Result<List<HotelOrder>> findByHotelOrderPageDate(HotelOrder hotelOrder,Integer pageNo,Integer pageSize)throws Exception{
		
		
		return hotelOrderService.findGetOrder(hotelOrder, pageNo, pageSize);
	}
	
	@RequestMapping(value="/info/update")
	public Result<String> update(String orderStatus,Integer id){
		
		return hotelOrderService.updataById(orderStatus, id);
		
	}
	
	
}

