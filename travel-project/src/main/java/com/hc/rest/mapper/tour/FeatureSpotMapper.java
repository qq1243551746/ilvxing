package com.hc.rest.mapper.tour;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.hc.rest.entity.tour.FeatureSpot;
import com.hc.rest.entity.tour.ItripAreaDic;
import com.hc.rest.mapper.toursql.FindAllTourMapperSql;
import com.hc.rest.vo.tour.FeatureSpotVo;
import com.hc.rest.vo.tour.WholeVo;

@Mapper
public interface FeatureSpotMapper {

	/**
	 * 首页显示,国内景点,国外景点,当前景点,周边景点
	 * 
	 * @param featureSpot
	 *            景点
	 * @return
	 */
	@SelectProvider(method = "findAllTourInfo", type = FindAllTourMapperSql.class)
	public List<FeatureSpotVo> findAllTourInfo(FeatureSpot featureSpot, ItripAreaDic itripAreaDic);

	/**
	 * 地区,景点或者关键字(首页输入框)
	 * 
	 * @param all
	 *            景点,地区名称,关键字
	 * @param page
	 *            当前页码
	 * @param size
	 *            每页显示数量
	 * @return
	 */
	@SelectProvider(method = "findAllTourItripAreaDic", type = FindAllTourMapperSql.class)
	public List<WholeVo> findAllTourItripAreaDic(String all, Integer page, Integer size);

	/**
	 * 地区,景点或者关键字(首页输入框)==count(*)
	 * 
	 * @param all
	 *            景点,地区名称,关键字
	 * @return
	 */
	@SelectProvider(method = "findAllTourItripAreaDicCount", type = FindAllTourMapperSql.class)
	public List<WholeVo> findAllTourItripAreaDicCount(String all);

	/**
	 * 选择查询
	 * 
	 * @param featureSpotName
	 *            景点名称
	 * @param fatalism
	 *            行程天数(小于等于)
	 * @param hotelLevel
	 *            酒店等级
	 * @param name
	 *            地区名称
	 * @param address
	 *            关键字
	 * @return
	 */
	@SelectProvider(method = "findAllTourItripAreaDicText", type = FindAllTourMapperSql.class)
	public List<WholeVo> findAllTourItripAreaDicText(String featureSpotName, Integer fatalism, String hotelLevel,
			String name, String address, double price, String themeName, Integer page, Integer size);

	/**
	 * 查询总记录数(当做count(*))
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
	 * @return
	 */
	@SelectProvider(method = "findAllCount", type = FindAllTourMapperSql.class)
	public List<WholeVo> findAllCount(String featureSpotName, Integer fatalism, String hotelLevel, String name,
			String address, double price,String themeName);

	/**
	 * 景点详情根据id查询
	 * 
	 * @param id
	 *            景点id
	 * @return
	 */
	@SelectProvider(method = "findId", type = FindAllTourMapperSql.class)
	public List<WholeVo> findId(Integer id);
}
