package com.hc.rest.controller.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.rest.entity.tour.Theme;
import com.hc.rest.service.tour.ThemeService;
import com.hc.rest.utils.Result;

@RestController /* @Controller + @ResponseBody */
@RequestMapping("/theme")
public class ThemeController {

	@Autowired
	ThemeService themeService;

	/**
	 * 查询主题地区和地区表连接查询
	 * 
	 * @param theme
	 *            主题表
	 * @return
	 */
	@RequestMapping("/themeInfo")
	public Result<Theme> ThemeName(Theme theme) {

		return themeService.themeList(theme);
	}

	/**
	 * 主题查询全部
	 * 
	 * @return
	 */
	@RequestMapping("/themeParent")
	public Result<Theme> ThemeParent() {

		return themeService.themeParent();
	}
}
