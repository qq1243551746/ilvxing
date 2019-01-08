package com.hc.rest.controller.room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.room.ItripHotelRoom;
import com.hc.rest.entity.room.ItripImage;
import com.hc.rest.entity.user.User;
import com.hc.rest.service.order.HotelOrderService;
import com.hc.rest.service.room.ItripHotelRoomService;
import com.hc.rest.service.user.UserService;
import com.hc.rest.utils.Result;
import com.hc.rest.vo.room.InsuredAndBeSuredVo;
/**
 * 房间
 * @author LCL
 *
 */                                                         
@RestController                                             
@RequestMapping("/room")                                    
public class RoomController {                               
		                                                    
	@Autowired                                              
	ItripHotelRoomService itripHotelRoomService;
	
	@Autowired
	HotelOrderService   hotelOrderService;
	
	@Autowired
	HttpServletResponse response;   
	
	@Autowired
	UserService userService; 
	
	@RequestMapping("/findAllRoomInfo")
	public Result<ItripHotelRoom> findAllRoomInfo(ItripHotelRoom itripHotelRoom,String type)throws Exception{
		//response.setHeader("Access-Control-Allow-Origin", "*");
		return itripHotelRoomService.findAllRoomInfo(itripHotelRoom,type);
	}
	
	/**
	 * web端订单提交接口
	 * @param insuredAndBeSuredVo
	 * @param request
	 * @return
	 */
	@RequestMapping("/roomBookInfo")
	public Result<String> roomBookInfo(InsuredAndBeSuredVo insuredAndBeSuredVo, HttpServletRequest request){
		Result<User> ResUser = userService.getUserInfo(request);
		return hotelOrderService.addBookOrder(insuredAndBeSuredVo,ResUser.getData().getId());
	}
	
	/**
	 * 手机端订单提交接口
	 * @param insuredAndBeSuredVo
	 * @param userId
	 * @return
	 */
	@RequestMapping("/roomBookInfoMobile")
	public Result<String> roomBookInfoMobile(InsuredAndBeSuredVo insuredAndBeSuredVo,Integer userId){ 
		return hotelOrderService.addBookOrder(insuredAndBeSuredVo,userId);
	}
	
	@RequestMapping("/byRoomInfo")
	public Result<ItripHotelRoom> findByIdRoomInfo(Integer id){
		return itripHotelRoomService.findByIdRoomInfo(id);
	}
	
	@RequestMapping("/findByImgType")
	public Result<ItripImage> findByImg(String img,String type){
		return itripHotelRoomService.img(img, type);
	}
	
}
