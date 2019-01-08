package com.hc.rest.service.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.rest.entity.tour.Theme;
import com.hc.rest.mapper.tour.ThemeMapper;
import com.hc.rest.repository.tour.ItripAreaDicRepository;
import com.hc.rest.repository.tour.ThemeRepository;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ResultEnum;
import com.hc.rest.utils.ResultUtil;
import com.hc.rest.vo.tour.ThemeVo;

/**
 * 首页主题查询
 * 
 * @author MaiBenBen
 *
 */
@Service
@Transactional
@SuppressWarnings("unchecked")
public class ThemeService {
	@Autowired
	ItripAreaDicRepository itripAreaDicRepository;// 地区

	@Autowired
	ThemeRepository themeRepository;// 主题

	@Autowired
	ThemeMapper themeMapper;// 主题

	// 查询主题地区和地区表连接查询
	public Result<Theme> themeList(Theme theme) {
		List<ThemeVo> list = themeMapper.findAllTheme(theme);// 首页子类内部主题

		for (ThemeVo themeVo : list) {// 传值:名称或者子主题的id
			if (themeVo.getLevel() == 2) {
				themeVo.setItripAreaDic(itripAreaDicRepository.idInfo(themeVo.getThemeid()));
			}
		}
		return ResultUtil.getResult(ResultEnum.SUCCESS, list);
	}

	// 查询所有主题
	public Result<Theme> themeParent() {
		List<ThemeVo> list = themeMapper.findAlld();// 查询全部

		for (ThemeVo themeVo : list) {// 传值:(id)进行连接查询
			themeVo.setTheme(themeRepository.parentList(themeVo.getThemeid()));
		}
		return ResultUtil.getResult(ResultEnum.SUCCESS, list);
	}
}
