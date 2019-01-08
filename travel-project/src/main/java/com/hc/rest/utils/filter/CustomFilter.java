package com.hc.rest.utils.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.aliyuncs.exceptions.ClientException;
import com.hc.rest.service.user.UserService;
import com.hc.rest.utils.Result;
import com.hc.rest.utils.ip.GetMacAddress;
import com.hc.rest.utils.redis.TravelRedisConfig;

@WebFilter(filterName = "CustomFilter", urlPatterns = { "/itrip-pc/*"})
public class CustomFilter implements Filter {

	@Autowired
	UserService userService;
	TravelRedisConfig redis = new TravelRedisConfig();

	public CustomFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
		try {
			String url;
			// 获取mac值
			String mac = GetMacAddress.getMac(httpRequest);

			url = (String) httpRequest.getRequestURI();
			if (url.equals("/itrip-pc/login.html")) {
				// 自动登录

				Result<Boolean> resUser = userService.login(1, null, httpRequest);

				if (resUser.getData() != false) {
					wrapper.sendRedirect("http://localhost:8020/itrip-pc/index.html");
				} else {
					wrapper.sendRedirect("http://localhost:8020" + url);
				}
			} else if (url.equals("/itrip-pc/travelcontact.html")) {
				Result<Boolean> resUser = userService.login(1, null, httpRequest);
				if (resUser.getData() != false) {
					wrapper.sendRedirect("http://localhost:8020" + url);
				} else {
					wrapper.sendRedirect("http://localhost:8020/itrip-pc/login.html");
				}
			} else if (url.equals("/itrip-pc/roomReserve.html")) {
				wrapper.sendRedirect("http://localhost:8020/itrip-pc/index.html");
			} else {
				wrapper.sendRedirect("http://localhost:8020" + url);

			}
		} catch (ClientException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {

	}
}
