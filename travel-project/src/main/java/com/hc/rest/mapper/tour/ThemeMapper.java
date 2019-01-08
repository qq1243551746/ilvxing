package com.hc.rest.mapper.tour;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.hc.rest.entity.tour.Theme;
import com.hc.rest.mapper.toursql.ThemeMapperSql;
import com.hc.rest.vo.tour.ThemeVo;

@Mapper
public interface ThemeMapper {

	/**
	 * 主题查询
	 * 
	 * @return list主题对象集合
	 */
	@SelectProvider(method = "themeInfo", type = ThemeMapperSql.class)
	public List<ThemeVo> findAllTheme(Theme theme);
	
	/**
	 * 主题查询
	 * 
	 * @return list主题对象集合
	 */
	@SelectProvider(method = "themeParent", type = ThemeMapperSql.class)
	public List<ThemeVo> findAlld();

}
