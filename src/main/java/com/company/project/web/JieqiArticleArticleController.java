package com.company.project.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.JieqiArticleArticle;
import com.company.project.service.JieqiArticleArticleService;
import com.company.project.utils.ConfigProperties;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Controller
@RequestMapping("article")
public class JieqiArticleArticleController {
	@Resource
	private JieqiArticleArticleService service;
	@Value("${project.pcurl}")
	private String pcurl;

	@PostMapping("/add")
	public Result add(JieqiArticleArticle jieqiArticleArticle) {
		service.save(jieqiArticleArticle);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		service.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(JieqiArticleArticle jieqiArticleArticle) {
		service.update(jieqiArticleArticle);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		JieqiArticleArticle jieqiArticleArticle = service.findById(id);
		return ResultGenerator.genSuccessResult(jieqiArticleArticle);
	}

	@RequestMapping("/index")
	public String list(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.setAttribute("user", session.getAttribute("user"));
		Map<Integer, List<JieqiArticleArticle>> categorys = service.CategoryTopList();
		List<JieqiArticleArticle> top = service.TopList();
		model.addAttribute("top", top);
		model.addAttribute("pcurl", pcurl);
		model.addAttribute("categorys", categorys);
		System.out.println("----------" + ConfigProperties.TXT_PATH);
		return "index";
	}

	@RequestMapping("/info/{shortid}_{articleid}/")
	public String info(HttpServletRequest request, Model model, @PathVariable("articleid") Integer articleid) {
		JieqiArticleArticle article = service.findById(articleid);
		model.addAttribute("article", article);
		return "info";
	}

}
