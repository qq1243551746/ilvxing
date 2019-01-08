package com.hc.rest.service.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.rest.entity.tour.FeatureSpot;
import com.hc.rest.entity.tour.ItripAreaDic;
import com.hc.rest.mapper.tour.FeatureSpotMapper;
import com.hc.rest.repository.room.ItripImageRepository;
import com.hc.rest.repository.tour.FeatureSpotRepository;
import com.hc.rest.repository.tour.ItripAreaDicRepository;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;
import com.hc.rest.vo.tour.FeatureSpotVo;
import com.hc.rest.vo.tour.WholeVo;

@Service
@Transactional
public class FeatureSpotService {
	@Autowired
	FeatureSpotRepository featureSpotRepository;// 景点

	@Autowired
	ItripImageRepository itripImageRepository;// 图片

	@Autowired
	ItripAreaDicRepository itripAreaDicRepository;// 地区

	@Autowired
	FeatureSpotMapper featureSpotMapper;// 景点Mapper

	// 首页显示(出境旅游,国内旅游,周边旅游,当地旅游)
	@SuppressWarnings("unchecked")
	public Result<FeatureSpot> featureSpotList(FeatureSpot featureSpot, ItripAreaDic itripAreaDic, String type) {
		List<FeatureSpotVo> list = featureSpotMapper.findAllTourInfo(featureSpot, itripAreaDic);

		for (FeatureSpotVo featureSpotVo : list) {
			featureSpotVo.setImage(itripImageRepository.obtainHotelImage(featureSpotVo.getImgId(), type));// 图片显示
		}
		return ResultUtil.getResult(ResultEnum.SUCCESS, list);
	}

	// 按照首页输入框,模糊查询,分页
	@SuppressWarnings({ "unchecked" })
	public Result<FeatureSpot> findAllTourItripAreaDic(String featureSpotName, Integer fatalism, String hotelLevel,
			String name, String address, double price, String themeName, Integer page, Integer size, String all,
			String type) {

		List<WholeVo> listCount = null;// (count*)
		List<WholeVo> list = null;// 接受数据
		// size = 5;// 每页显示数量
		int pageCount = 0;// 总记录数

		if (all != null && !"".equals(all)) {// 如果不等于空,就是首页输入框中的值
			listCount = featureSpotMapper.findAllTourItripAreaDicCount(all);// 输入框(count*)

			pageCount = listCount.size() % size == 0 ? listCount.size() / size : listCount.size() / size + 1;// 总记录数

			if (page == null || page < 1) {// 判断
				page = 1;
			} else if (page > pageCount) {
				page = pageCount;
			}
			list = featureSpotMapper.findAllTourItripAreaDic(all, page, size);// 输入框查询+分页

		} else if (all == null || all == "") {
			listCount = featureSpotMapper.findAllCount(featureSpotName, fatalism, hotelLevel, name, address, price,
					themeName);// 总条目数

			pageCount = listCount.size() % size == 0 ? listCount.size() / size : listCount.size() / size + 1;// 总记录数

			if (page == null || page < 1) {// 判断
				page = 1;
			} else if (page > pageCount) {
				page = pageCount;
			}
			list = featureSpotMapper.findAllTourItripAreaDicText(featureSpotName, fatalism, hotelLevel, name, address,
					price, themeName, page, size);// 选择性查询+分页
		}

		for (WholeVo wholeVo : list) {// 循环放入
			wholeVo.setImage(itripImageRepository.obtainHotelImage(wholeVo.getImgId(), type));// 图片显示
			wholeVo.setCount(pageCount);// 总页码
			wholeVo.setCountSize(listCount.size());// 总数据量
			wholeVo.setPage(page);// 当前页码
			wholeVo.setSize(size);// 每页显示数量
		}
		return ResultUtil.getResult(ResultEnum.SUCCESS, list);
	}

	// 景点详情
	@SuppressWarnings("unchecked")
	public Result<FeatureSpot> findId(Integer id, String type) {
		List<WholeVo> list = featureSpotMapper.findId(id);

		for (WholeVo wholeVo : list) {
			wholeVo.setImage(itripImageRepository.obtainHotelImage(wholeVo.getImgId(), type));// 图片显示
		}
		return ResultUtil.getResult(ResultEnum.SUCCESS, list);
	}
}
