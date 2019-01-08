package com.hc.rest.mapper.toursql;

import org.springframework.beans.factory.annotation.Autowired;

import com.hc.rest.entity.tour.FeatureSpot;
import com.hc.rest.entity.tour.ItripAreaDic;
import com.hc.rest.mapper.tour.FeatureSpotMapper;

/**
 * 景点sql
 * 
 * @author MaiBenBen
 *
 */
public class FindAllTourMapperSql {

	@Autowired
	FeatureSpotMapper featureSpotMapper;// 景点Mapper

	/**
	 * 首页显示(出境旅游,国内旅游,周边旅游,当地旅游)&&(旅游首页)
	 * 
	 * @param featureSpot
	 *            景点
	 * @param itripAreaDic
	 *            地区
	 * @return
	 */
	public String findAllTourInfo(FeatureSpot featureSpot, ItripAreaDic itripAreaDic) {
		StringBuffer sql = new StringBuffer(
				"select fe.fid fid,fe.id_name idName,fe.quantity,fe.img_id imgId,fe.address,fe.fatalism,fe.feature_spot_name featureSpotName,"
						+ "fe.price,ar.is_china isChina,ar.name,ar.id from itrip_feature_spot fe"
						+ " join itrip_area_dic ar on fe.id_name=ar.id"
						+ " join itrip_image img on fe.img_id=img.target_id where 1=1");
		if (featureSpot.getIdName() != null) {// 地区id
			sql.append(" and fe.id_name=" + featureSpot.getIdName() + " ");
		}
		if (itripAreaDic.getName() != null && !"".equals(itripAreaDic.getName())) {// 地区名称
			sql.append(" and ar.name='" + itripAreaDic.getName() + "' ");
		}
		if (itripAreaDic.getIsChina() != null) {// 地区区域国内国外
			sql.append(" and ar.is_china='" + itripAreaDic.getIsChina() + "' ");
		}
		sql.append(" group by fid order by fe.price");
		return sql.toString();
	}

	/**
	 * 地区,景点或者关键字(景点首页输入框)
	 * 
	 * @param id
	 *            类型判断
	 * @param featureSpotName
	 *            景点名称
	 * @param address
	 *            景点关键字
	 * @param name
	 *            地区名称
	 * @return
	 */
	public String findAllTourItripAreaDic(String all, Integer page, Integer size) {
		StringBuffer sql = new StringBuffer(
				"select fe.fid fid,fe.address,fe.feature_spot_name featureSpotName,fe.quantity,fe.fatalism,fe.img_id imgId,fe.price,ar.is_china isChina,ar.id,"
						+ "ar.name,ho.hotel_name hotelName,ho.hotel_level hotelLevel,th.theme_name themeName from itrip_feature_spot fe"
						+ " join itrip_area_dic ar on fe.id_name=ar.id"
						+ " join itrip_image img on fe.img_id=img.target_id"
						+ " join itrip_theme th on fe.theme_id=th.themeid"
						+ " join itrip_hotel ho on fe.hotel_id=ho.id  where 1=1");
		if (all != null && !"".equals(all)) {// 游玩线路:||fe景点表
			if ("国内".equals(all)) {
				sql.append(" and ar.is_china=1");
			} else if ("国外".equals(all)) {
				sql.append(" and ar.is_china=2");
			} else {
				sql.append(" and fe.feature_spot_name like '%" + all + "%' or fe.address like '%" + all
						+ "%' or ar.name like '%" + all + "%' ");
			}
		}
		sql.append(" group by fid order by fe.price");
		int pageIndex;
		if (page >= 1) {
			pageIndex = (page - 1) * size;// 计算当前页码
		} else {
			pageIndex = 1;
		}
		sql.append(" limit " + pageIndex + "," + size + "");
		System.out.println("(景点首页输入框):" + sql);
		return sql.toString();
	}

	/**
	 * 地区,景点或者关键字(景点首页输入框)==count(*)
	 * 
	 * @param id
	 *            类型判断
	 * @param featureSpotName
	 *            景点名称
	 * @param address
	 *            景点关键字
	 * @param name
	 *            地区名称
	 * @return
	 */
	public String findAllTourItripAreaDicCount(String all) {
		StringBuffer sql = new StringBuffer(
				"select fe.fid fid,fe.address,fe.feature_spot_name featureSpotName,fe.quantity,fe.fatalism,fe.img_id imgId,fe.price,ar.is_china isChina,ar.id,"
						+ "ar.name,ho.hotel_name hotelName,ho.hotel_level hotelLevel,th.theme_name themeName  from itrip_feature_spot fe"
						+ " join itrip_area_dic ar on fe.id_name=ar.id"
						+ " join itrip_image img on fe.img_id=img.target_id"
						+ " join itrip_theme th on fe.theme_id=th.themeid"
						+ " join itrip_hotel ho on fe.hotel_id=ho.id  where 1=1");
		if (all != null && !"".equals(all)) {// 游玩线路:||fe景点表
			if ("国内".equals(all)) {
				sql.append(" and ar.is_china=1");
			} else if ("国外".equals(all)) {
				sql.append(" and ar.is_china=2");
			} else {
				sql.append(" and fe.feature_spot_name like '%" + all + "%' or fe.address like '%" + all
						+ "%' or ar.name like '%" + all + "%' ");
			}
		}
		sql.append(" group by fid");
		System.out.println("(景点首页输入框count*):" + sql);
		return sql.toString();
	}

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
	public String findAllCount(String featureSpotName, Integer fatalism, String hotelLevel, String name, String address,
			double price, String themeName) {
		StringBuffer sql = new StringBuffer(
				"select fe.fid fid,fe.address,fe.feature_spot_name featureSpotName,fe.quantity,fe.fatalism,fe.img_id imgId,fe.price,ar.is_china isChina,ar.id,"
						+ "ar.name,ar.is_china isChina,ho.hotel_name hotelName,ho.hotel_level hotelLevel,th.theme_name themeName"
						+ " from itrip_feature_spot fe" + " join itrip_area_dic ar on fe.id_name=ar.id"
						+ " join itrip_image img on fe.img_id=img.target_id"
						+ " join itrip_theme th on fe.theme_id=th.themeid" + " join itrip_hotel ho on fe.hotel_id=ho.id "
						+ " where 1=1");
		if (featureSpotName != null && !"".equals(featureSpotName)) {// 游玩线路:||fe景点表
			sql.append(" and fe.feature_spot_name like '%" + featureSpotName + "%' ");
		}
		if (fatalism != null && fatalism > 0) {
			sql.append(" and fe.fatalism<=" + fatalism + " ");// 行程天数||fe景点表(小于等于)
		}
		if (hotelLevel != null && !"".equals(hotelLevel)) {// 酒店等级:2||ho酒店表
			sql.append(" and ho.hotel_level= " + hotelLevel + " ");
		}
		if (name != null && !"".equals(name)) {// 出发城市:3||ar地区表
			sql.append(" and ar.name like '%" + name + "%' ");
		}
		if (address != null && !"".equals(address)) {// 景点关键字||fe景点表
			sql.append(" and fe.address like '%" + address + "%' ");
		}
		if (price > 0) {// 景点价钱
			if (price == 300) {
				sql.append(" and fe.price>=150 and fe.price<=300");
			}
			if (price == 600) {
				sql.append(" and fe.price>=300 and fe.price<=600");
			}
			if (price == 1000) {
				sql.append(" and fe.price>=600 and fe.price<=1000");
			}
			if (price == 1500) {
				sql.append(" and fe.price>=1000 and fe.price<=1500");
			}
			if (price == 2000) {
				sql.append(" and fe.price>=1500 and fe.price<=2000");
			}
			if (price == 3000) {
				sql.append(" and fe.price>=2000 and fe.price<=3000");
			}
			if (price == 5000) {
				sql.append(" and fe.price>=5000");
			}
		}
		if (themeName != null && !"".equals(themeName)) {// 主题名称
			sql.append(" and th.theme_name ='" + themeName + "' ");
		}
		sql.append(" group by fid");
		System.out.println("查询总记录数(当做count(*)):" + sql);
		return sql.toString();
	}

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
	public String findAllTourItripAreaDicText(String featureSpotName, Integer fatalism, String hotelLevel, String name,
			String address, double price, String themeName, Integer page, Integer size) {
		StringBuffer sql = new StringBuffer(
				"select fe.fid fid,fe.address,fe.feature_spot_name featureSpotName,fe.quantity,fe.fatalism,fe.img_id imgId,fe.price,ar.is_china isChina,ar.id,"
						+ "ar.name,ar.is_china isChina,ho.hotel_name hotelName,ho.hotel_level hotelLevel,th.theme_name themeName"
						+ " from itrip_feature_spot fe" + " join itrip_area_dic ar on fe.id_name=ar.id"
						+ " join itrip_image img on fe.img_id=img.target_id"
						+ " join itrip_theme th on fe.theme_id=th.themeid" + " join itrip_hotel ho on fe.hotel_id=ho.id "
						+ " where 1=1");
		if (featureSpotName != null && !"".equals(featureSpotName)) {// 游玩线路:||fe景点表
			sql.append(" and fe.feature_spot_name like '%" + featureSpotName + "%' ");
		}
		if (fatalism != null && fatalism > 0) {
			sql.append(" and fe.fatalism<=" + fatalism + " ");// 行程天数||fe景点表(小于等于)
		}
		if (hotelLevel != null && !"".equals(hotelLevel)) {// 酒店等级:2||ho酒店表
			sql.append(" and ho.hotel_level= '" + hotelLevel + "' ");
		}
		if (name != null && !"".equals(name)) {// 出发城市:3||ar地区表
			sql.append(" and ar.name like '%" + name + "%' ");
		}
		if (address != null && !"".equals(address)) {// 景点关键字||fe景点表
			sql.append(" and fe.address like '%" + address + "%' ");
		}
		if (price > 0) {// 景点价钱
			if (price == 300) {
				sql.append(" and fe.price>=150 and fe.price<=300");
			}
			if (price == 600) {
				sql.append(" and fe.price>=300 and fe.price<=600");
			}
			if (price == 1000) {
				sql.append(" and fe.price>=600 and fe.price<=1000");
			}
			if (price == 1500) {
				sql.append(" and fe.price>=1000 and fe.price<=1500");
			}
			if (price == 2000) {
				sql.append(" and fe.price>=1500 and fe.price<=2000");
			}
			if (price == 3000) {
				sql.append(" and fe.price>=2000 and fe.price<=3000");
			}
			if (price == 5000) {
				sql.append(" and fe.price>=5000");
			}
		}
		if (themeName != null && !"".equals(themeName)) {// 主题名称
			sql.append(" and th.theme_name ='" + themeName + "' ");
		}
		if (fatalism != null && fatalism > 0) {// 行程天數
			sql.append(" group by fid order by fe.fatalism desc");
		} else {
			sql.append(" group by fid order by fe.price");
		}

		int pageIndex;
		if (page >= 1) {
			pageIndex = (page - 1) * size;// 计算当前页码
		} else {
			pageIndex = 1;
		}
		sql.append(" limit " + pageIndex + "," + size + "");
		System.out.println("选择查询:" + sql);
		return sql.toString();
	}

	/**
	 * 景点详情根据id查询
	 * 
	 * @param id
	 *            景点id
	 * @return
	 */
	public String findId(Integer id) {
		StringBuffer sql = new StringBuffer(
				"select fe.fid fid,fe.address,fe.feature_spot_name featureSpotName,fe.quantity,fe.fatalism,fe.img_id imgId,fe.price,ar.is_china isChina,ar.id,"
						+ "ar.name,ho.hotel_name hotelName,ho.hotel_level hotelLevel  from itrip_feature_spot fe"
						+ " join itrip_area_dic ar on fe.id_name=ar.id"
						+ " join itrip_image img on fe.img_id=img.target_id"
						+ " join itrip_hotel ho on fe.hotel_id=ho.id  where fe.fid=" + id);
		sql.append(" group by fid");
		System.out.println(sql);
		return sql.toString();
	}
}