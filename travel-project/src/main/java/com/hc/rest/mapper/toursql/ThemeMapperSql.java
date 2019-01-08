package com.hc.rest.mapper.toursql;

import com.hc.rest.entity.tour.Theme;

public class ThemeMapperSql {

	public String themeInfo(Theme theme) {// 根据传过来的对应主题的id进行查询
		StringBuffer sql = new StringBuffer(
				"select themeid,parent,level,theme_name themeName  from itrip_theme where level=2");
		if (theme.getParent() != null) {//父级区域
			sql.append(" and parent=" + theme.getParent());
		}
		return sql.toString();
	}

	public String themeParent() {//查询所有的主题
		StringBuffer sql = new StringBuffer("select themeid,parent,level,theme_name themeName from itrip_theme where level =0");
		return sql.toString();
	}
}
