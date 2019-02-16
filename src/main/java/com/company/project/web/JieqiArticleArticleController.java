package com.company.project.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.project.configurer.Config;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.JieqiArticleArticle;
import com.company.project.service.JieqiArticleArticleService;
import com.company.project.service.JieqiArticleChapterService;
import com.company.project.utils.Common;
import com.company.project.utils.HttpUtils;

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
	@Resource
	private Config config;
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
		LinkedHashMap<String, Map<String, String>> chapterList = service.chpaterListTopN(articleid, 20);
		model.addAttribute("chapterList", chapterList);
		model.addAttribute("article", article);
		model.addAttribute("pcurl", pcurl);
		model.addAttribute("categorys", Common.CATEGORYS);
		new Thread(() -> service.dayVisitIncr(articleid)).start();
		return "info";
	}

	@RequestMapping("/chapters/{shortid}_{articleid}")
	public String chapters(HttpServletRequest request, Model model, @PathVariable("articleid") Integer articleid)
			throws IOException {
		JieqiArticleArticle article = service.info(articleid);
		LinkedHashMap<String, Map<String, String>> chapterList = service.chpaterList(articleid, true);
		model.addAttribute("chapterList", chapterList);
		model.addAttribute("article", article);
		return "chapterlist";
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
		model.addAttribute("sortName", Common.CATEGORYS.get(classNum));
		model.addAttribute("categorys", Common.CATEGORYS);
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
			break;
		case "month":
			order = "monthvisit";
			break;
		case "all":
			order = "allvisit";
			break;
		default:
			order = "weekvisit";
		}
		List<JieqiArticleArticle> list = service.topClassList(classNum, (pageNo - 1) * limit, limit, order);
		model.addAttribute("list", list);
		model.addAttribute("pcurl", pcurl);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("classNum", classNum);
		model.addAttribute("sortName", Common.CATEGORYS.get(classNum));
		model.addAttribute("categorys", Common.CATEGORYS);
		return "top";
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
		model.addAttribute("sortName", Common.CATEGORYS.get(classNum));
		model.addAttribute("categorys", Common.CATEGORYS);
		return "finish";
	}

	@PostMapping(value = "/remind")
	@ResponseBody
	public Result<Map<String, Object>> visit(HttpServletRequest request) {
		String message = request.getParameter("aid");
		try {
			HttpUtils.pushMessage(message);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		return ResultGenerator.genSuccessResult(map);
	}

	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) {
		String keyword = request.getParameter("keyword").trim();
		List<JieqiArticleArticle> result = service.search(keyword);
		model.addAttribute("categorys", Common.CATEGORYS);
		model.addAttribute("result", result);
		model.addAttribute("keyword", keyword);
		return "s";
	}
}
