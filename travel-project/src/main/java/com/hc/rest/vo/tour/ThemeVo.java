package com.hc.rest.vo.tour;

import java.util.List;

import com.hc.rest.entity.tour.ItripAreaDic;
import com.hc.rest.entity.tour.Theme;

/**
 * 主题vo(主题和地区)
 * 
 * @author MaiBenBen
 *
 */
public class ThemeVo {
	private Integer themeid;// 主题主键

	private Integer parent;// 父级区域

	private String themeName;// 主题名称

	private String name;// 地区名称

	private String isChina;// 地区表:国外国内

	private String id;// 地区id

	private Integer level;// 区域级别(0:主题 1:主题子类 2:地区(市级)子子类级别)

	private List<ItripAreaDic> itripAreaDic;// 地区表

	private List<Theme> theme;// 主题表

	public Integer getThemeid() {
		return themeid;
	}

	public void setThemeid(Integer themeid) {
		this.themeid = themeid;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsChina() {
		return isChina;
	}

	public void setIsChina(String isChina) {
		this.isChina = isChina;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<ItripAreaDic> getItripAreaDic() {
		return itripAreaDic;
	}

	public void setItripAreaDic(List<ItripAreaDic> itripAreaDic) {
		this.itripAreaDic = itripAreaDic;
	}

	public List<Theme> getTheme() {
		return theme;
	}

	public void setTheme(List<Theme> theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "ThemeVo [themeid=" + themeid + ", parent=" + parent + ", themeName=" + themeName + ", name=" + name
				+ ", isChina=" + isChina + ", id=" + id + ", level=" + level + ", itripAreaDic=" + itripAreaDic
				+ ", theme=" + theme + "]";
	}

	public ThemeVo(Integer themeid, Integer parent, String themeName, String name, String isChina, String id,
			Integer level, List<ItripAreaDic> itripAreaDic, List<Theme> theme) {
		super();
		this.themeid = themeid;
		this.parent = parent;
		this.themeName = themeName;
		this.name = name;
		this.isChina = isChina;
		this.id = id;
		this.level = level;
		this.itripAreaDic = itripAreaDic;
		this.theme = theme;
	}

	public ThemeVo() {
		super();
	}

}
