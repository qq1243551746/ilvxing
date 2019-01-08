package com.hc.rest.service.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.rest.entity.hotel.ItripHotel;
import com.hc.rest.entity.order.HotelOrder;
import com.hc.rest.entity.room.ItripHotelRoom;
import com.hc.rest.repository.hotel.ItripHotelRepository;
import com.hc.rest.repository.order.HotelOrderRepository;
import com.hc.rest.repository.room.ItripHotelRoomRepository;
import com.hc.rest.repository.room.ItripHotelTempStoreRepository;
import com.hc.rest.utils.EirunyeException;
import com.hc.rest.utils.OrderNumber;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;
import com.hc.rest.vo.order.OrderDetailsVo;
import com.hc.rest.vo.room.InsuredAndBeSuredVo;

@Service
public class HotelOrderService {

	@Autowired
	HotelOrderRepository hotelOrderRepository;

	@Autowired
	ItripHotelRoomRepository itripHotelRoomRepository;

	@Autowired
	ItripHotelRepository itripHotelRepository;

	@Autowired
	ItripHotelTempStoreRepository itripHotelTempStoreRepository;

	@Autowired
	OrderNumber orderNumber;

	/**
	 * 按照id删除订单
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<String> deleteById(Integer id) {
		hotelOrderRepository.deleteById(id);

		HotelOrder hotelOrder = hotelOrderRepository.findAllById(id);
		if (hotelOrder == null) {
			throw new EirunyeException(ResultEnum.SUCCESS);
		} else {
			return ResultUtil.error(-1, "删除数据失败!!!");
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Result<String> updataById(String orderStatus,Integer id){
		if(hotelOrderRepository.updateById(orderStatus, id)>0){
			throw new EirunyeException(ResultEnum.SUCCESS);
		}else {
			return ResultUtil.error(-1, "修改失败");
		}
	}
	



	/**
	 * 多条件查询数据
	 * 
	 * @param hotelOrder
	 *            条件
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            页数大小
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "serial", "unchecked", "deprecation" })
	public Result<List<HotelOrder>> findGetOrder(HotelOrder hotelOrder, Integer pageNo, Integer pageSize) throws Exception {
		List<HotelOrder> list = null;
		Pageable pageable = null;

		pageable = new PageRequest(pageNo, pageSize);
		list = hotelOrderRepository.findAll(new Specification<HotelOrder>() {
			public Predicate toPredicate(Root<HotelOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predList = new ArrayList<Predicate>();

				String search = "%" + hotelOrder.getLinkUserName() + "%";
				if (null != hotelOrder.getOrderStatus()) {
					predList.add(cb.and(cb.equal(root.get("orderStatus"), hotelOrder.getOrderStatus())));
				}
				if (null != hotelOrder.getOrderType()) {
					predList.add(cb.and(cb.equal(root.get("orderType"), hotelOrder.getOrderType())));
				}
				if (null != hotelOrder.getLinkUserName()) {
					predList.add(cb.and(cb.like(root.get("linkUserName"), search)));
				}
				if (null != hotelOrder.getCheckInDate() && null == hotelOrder.getCheckOutDate()) {
					predList.add(cb.and(cb.greaterThanOrEqualTo(root.get("checkInDate"), hotelOrder.getCheckInDate())));
				} else if (null != hotelOrder.getCheckOutDate() & null == hotelOrder.getCheckInDate()) {
					predList.add(cb.and(cb.lessThanOrEqualTo(root.get("checkInDate"), hotelOrder.getCheckOutDate())));
				} else if (null != hotelOrder.getCheckInDate() && null != hotelOrder.getCheckOutDate()) {
					predList.add(cb.and(cb.between(root.get("checkInDate"), hotelOrder.getCheckInDate(), hotelOrder.getCheckOutDate())));
				}
				return cb.and(predList.toArray(new Predicate[predList.size()]));
			}

		}, pageable);
		return ResultUtil.getResult(ResultEnum.SUCCESS, list);
	}

	/**
	 * 订单详情页面
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Result<OrderDetailsVo> findById(Integer id) {
		HotelOrder hotelOrder = hotelOrderRepository.findAllById(id);
		OrderDetailsVo orderDetailsVo = new OrderDetailsVo();

		orderDetailsVo.setHotelOrder(hotelOrder);
		orderDetailsVo.setItripHotelRoom(itripHotelRoomRepository.findAllById(hotelOrder.getRoomId()));
		orderDetailsVo.setItripHotel(itripHotelRepository.findAllById(hotelOrder.getHotelId()));
		return ResultUtil.getResult(ResultEnum.SUCCESS, orderDetailsVo);
	}

	/**
	 * 根据id
	 *
	 * @param id
	 *            参数id
	 * @return Json hotelOrder
	 */
	@SuppressWarnings("unchecked")
	public Result<HotelOrder> getHotelOrderDataById(Integer id) throws Exception {
		HotelOrder hotelOrder = hotelOrderRepository.findAllById(id);
		if (null == hotelOrder) {
			throw new EirunyeException(ResultEnum.USERNOTEXIST);// 用户不存在
		} else
			return ResultUtil.getResult(ResultEnum.SUCCESS, hotelOrder);
	}

	/**
	 * 预订业务接口
	 * 
	 * @param insuredAndBeSuredVo
	 * @return
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public Result<String> addBookOrder(InsuredAndBeSuredVo insuredAndBeSuredVo,Integer userId) {
		HotelOrder order = new HotelOrder();
		ItripHotelRoom room = itripHotelRoomRepository.findAllById(insuredAndBeSuredVo.getItripHotelRoom().getId());// 根据房间Id查询房间
		ItripHotel hotel = itripHotelRepository.findAllById(room.getHotelId());// 根据酒店ID查询酒店信息
		order.setNoticePhone(insuredAndBeSuredVo.getContacts().getLinkPhone());// 电话号码
		order.setLinkUserName(insuredAndBeSuredVo.getLinkUserName());// 联系人名称	
		order.setCount(insuredAndBeSuredVo.getRoomNumber());// 房间数量
		order.setOrderType(1);// 酒店订单
		order.setOrderNo(orderNumber.getNumber(userId));// 传入一个用户的ID
		order.setHotelId(room.getHotelId());// 传入酒店ID
		order.setHotelName(hotel.getHotelName());// 酒店名称
		order.setRoomId(room.getId());// 房间ID
		order.setCheckInDate(insuredAndBeSuredVo.getItripHotelRoom().getCreationDate());// 入住时间
		order.setCheckOutDate(insuredAndBeSuredVo.getItripHotelRoom().getModifyDate());// 退房时间
		order.setOrderStatus(0);// 待支付订单
		order.setPayAmount(insuredAndBeSuredVo.getPayAmount());// 总金额

		order.setCreateTime(new Date());// 创建时间
		// 传入两个时间计算之间的时间天数差
		order.setBookingDays(orderNumber.calculateTimeDifferenceBySimpleDateFormat(insuredAndBeSuredVo.getItripHotelRoom().getCreationDate(), insuredAndBeSuredVo.getItripHotelRoom().getModifyDate()));
		order.setUserId(userId);// 传入用户ID

		HotelOrder orderRs = hotelOrderRepository.save(order);
		if (orderRs != null) {
			itripHotelTempStoreRepository.updateByStore(room.getId(),insuredAndBeSuredVo.getRoomNumber());
			return ResultUtil.getResult(ResultEnum.SUCCESS, "0");
		} else {
			return ResultUtil.getResult(ResultEnum.UNKNOWN_ERROR, "-1");
		}
	}

}
