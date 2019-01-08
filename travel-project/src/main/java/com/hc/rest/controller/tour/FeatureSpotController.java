package com.hc.rest.controller.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.tour.FeatureSpot;
import com.hc.rest.entity.tour.ItripAreaDic;
import com.hc.rest.service.tour.FeatureSpotService;
import com.hc.rest.utils.Result;

@RestController /* @Controller + @ResponseBody */
@RequestMapping("/text")
public class FeatureSpotController {
	@Autowired
	FeatureSpotService featureSpotService;

	/**
	 * 首页显示(出境旅游,国内旅游,周边旅游,当地旅游)
	 * 
	 * @param featureSpot
	 *            景点表
	 * @param itripAreaDic
	 *            地区表
	 * @param type
	 *            图片类型
	 * @return
	 */
	@RequestMapping("/homepage") // 传值:--图片类型,(地区id或者地区名称),比如:国内旅游就是:中国
	public Result<FeatureSpot> findAllTourInfo(FeatureSpot featureSpot, ItripAreaDic itripAreaDic, String type) {
		return featureSpotService.featureSpotList(featureSpot, itripAreaDic, type);
	}

	/**
	 * 按照旅游首页输入框,模糊查询Controller||景点显示首页+分页
	 * 
	 * @param featureSpotName
	 *            景点名称
	 * @param fatalism
	 *            行程天数
	 * @param hotelLevel
	 *            酒店等级
	 * @param name
	 *            地区名称
	 * @param address
	 *            景点关键字
	 * @param page
	 *            当前页码
	 * @param size
	 *            每页显示数量
	 * @param id
	 *            类型判断
	 * @param type
	 *            图片类型选择
	 * @return
	 */
	@GetMapping("/like")
	public Result<FeatureSpot> findAllTourItripAreaDic(String featureSpotName, Integer fatalism, String hotelLevel,
			String name, String address, double price, String themeName, Integer page, Integer size, String all,
			String type) {
		return featureSpotService.findAllTourItripAreaDic(featureSpotName, fatalism, hotelLevel, name, address, price,
				themeName, page, size, all, type);
	}

	/**
	 * 景点详情
	 * 
	 * @param id
	 *            景点id
	 * @param type
	 *            图片类型
	 * @return
	 */
	@GetMapping("/findid")
	public Result<FeatureSpot> findId(Integer id, String type) {
		System.out.println(id);
		return featureSpotService.findId(id, type);
	}
}