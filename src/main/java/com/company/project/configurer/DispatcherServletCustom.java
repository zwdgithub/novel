package com.company.project.configurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("serial")
public class DispatcherServletCustom extends DispatcherServlet {

	@Override
	protected void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String serverName = request.getServerName();
//		String viewName = mv.getViewName();
		super.render(mv, request, response);
	}

}
