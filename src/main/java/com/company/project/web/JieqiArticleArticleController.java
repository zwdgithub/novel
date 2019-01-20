package com.company.project.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.model.JieqiArticleArticle;
import com.company.project.service.JieqiArticleArticleService;
import com.company.project.service.JieqiArticleChapterService;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Controller
@RequestMapping("article")
public class JieqiArticleArticleController {
	@Resource
	private JieqiArticleArticleService service;
	@Resource
	private JieqiArticleChapterService chapterService;
	@Value("${project.pcurl}")
	private String pcurl;

	@RequestMapping("/index")
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

	@RequestMapping("/info/{shortid}_{articleid}")
	public String info(HttpServletRequest request, Model model, @PathVariable("articleid") Integer articleid)
			throws IOException {
		JieqiArticleArticle article = service.info(articleid);
		LinkedHashMap<String, String> chapterList = service.chpaterListTopN(articleid, 20);
		model.addAttribute("chapterList", chapterList);
		model.addAttribute("article", article);
		Map<String, String> categorys = new HashMap<String, String>();
		model.addAttribute("categorys", categorys);
		return "info";
	}

	@RequestMapping("/chapter/{shortid}_{articleid}/{chapterid}")
	public String chapterContent(HttpServletRequest request, Model model, @PathVariable("articleid") Integer articleid,
			@PathVariable("chapterid") Integer chapterid) throws IOException {
		JieqiArticleArticle article = service.info(articleid);
		Map<String, Object> chapter = service.chapterContent(articleid, chapterid);
		model.addAttribute("chapter", chapter);
		model.addAttribute("article", article);
		return "chapter";
	}

	@RequestMapping("/category/{sortid}")
	public String list(HttpServletRequest request, Model model, @PathVariable("sortid") Integer classNum) {
		Integer limit = 10;
		Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
		List<JieqiArticleArticle> list = service.classList(classNum, (pageNo - 1) * limit, limit);
		model.addAttribute("list", list);
		model.addAttribute("pcurl", pcurl);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("classNum", classNum);
		return "sort";
	}

	@RequestMapping("/top{order}/{sortid}")
	public String top(HttpServletRequest request, Model model, @PathVariable("sortid") Integer classNum,
			@PathVariable("order") String order) {
		Integer limit = 10;
		Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
		switch (order) {
		case "week":
			order = "weekvisit";
		case "month":
			order = "monthvisit";
		case "all":
			order = "allvisit";
		default:
			order = "weekvisit";
		}
		List<JieqiArticleArticle> list = service.topClassList(classNum, (pageNo - 1) * limit, limit, order);
		model.addAttribute("list", list);
		model.addAttribute("pcurl", pcurl);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("classNum", classNum);
		return "sort";
	}

	@RequestMapping("/finish/{sortid}")
	public String finish(HttpServletRequest request, Model model, @PathVariable("sortid") Integer classNum) {
		Integer limit = 10;
		Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
		List<JieqiArticleArticle> list = service.finishClassList(classNum, (pageNo - 1) * limit, limit);
		model.addAttribute("list", list);
		model.addAttribute("pcurl", pcurl);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("classNum", classNum);
		return "sort";
	}

}
