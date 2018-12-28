package com.company.project.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.service.JieqiArticleBookcaseService;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@RestController
@RequestMapping("/jieqi/article/bookcase")
public class JieqiArticleBookcaseController {
	@Resource
	private JieqiArticleBookcaseService jieqiArticleBookcaseService;

	@GetMapping("bookcase")
	public String bookcase(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj == null) {
			return "login";
		}
		
		return "";
	}
}
