package com.hc.rest.service.room;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.rest.entity.room.ItripHotelRoom;
import com.hc.rest.entity.room.ItripImage;
import com.hc.rest.mapper.room.ItripHotelRoomMapper;
import com.hc.rest.repository.room.ItripHotelRoomRepository;
import com.hc.rest.repository.room.ItripImageRepository;
import com.hc.rest.repository.room.ItripProductStoreRepository;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;
import com.hc.rest.vo.room.RoomStoreVo;

@Service
public class ItripHotelRoomService {

	@Autowired
	ItripHotelRoomRepository itripHotelRoomRepository;
	
	@Autowired
	ItripProductStoreRepository itripProductStoreRepository;
	
	@Autowired
	ItripHotelRoomMapper itripHotelRoomMapper;
	
	@Autowired
	ItripImageRepository  itripImageRepository;
	
	/**
	 *  查询房间 以及房间的图片的信息
	 * @param itripHotelRoom -- 查询对象的参数
	 * @param type  -- 图片类型(0:酒店图片1:房间图片2:评论图片)
	 * @return  Result<ItripHotelRoom>
	 */
	@SuppressWarnings("unchecked")
	public Result<ItripHotelRoom> findAllRoomInfo(ItripHotelRoom itripHotelRoom,String type){
		List<RoomStoreVo> list = itripHotelRoomMapper.findAllRoomInfo(itripHotelRoom);
		for (RoomStoreVo roomStore : list) {
			roomStore.setImage(itripImageRepository.obtainHotelImage(roomStore.getRoom_Id(),type));
		}	
		if(list.size()>0) {
			return ResultUtil.getResult(ResultEnum.SUCCESS, list);
		}else {
			return ResultUtil.getResult(ResultEnum.NODATA, list);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Result<ItripImage> img(String img,String type){
		List<ItripImage> list=itripImageRepository.image(img, type);
		if(list.size()>0) {
			return ResultUtil.getResult(ResultEnum.SUCCESS, list);
		}else {
			return ResultUtil.getResult(ResultEnum.NODATA, list);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Result<ItripHotelRoom> findByIdRoomInfo(Integer id){
		Optional<ItripHotelRoom>  itripHotelRoom= itripHotelRoomRepository.findById(id);
		return ResultUtil.getResult(ResultEnum.SUCCESS, itripHotelRoom);
	}
	
	
}
