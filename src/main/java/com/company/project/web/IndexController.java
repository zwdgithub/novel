package com.company.project.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.model.JieqiArticleArticle;
import com.company.project.service.JieqiArticleArticleService;
import com.company.project.service.JieqiArticleChapterService;

@Controller
public class IndexController {

	@Resource
	private JieqiArticleArticleService service;
	@Resource
	private JieqiArticleChapterService chapterService;
	@Value("${project.pcurl}")
	private String pcurl;

	@RequestMapping("/")
	public String list(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.setAttribute("user", session.getAttribute("user"));
		Map<Integer, List<JieqiArticleArticle>> categorys = service.CategoryTopList();
		List<JieqiArticleArticle> top = service.TopList();
		model.addAttribute("top", top);
		model.addAttribute("pcurl", pcurl);
		model.addAttribute("categorys", categorys);
		return "index";
	}
}
