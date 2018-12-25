package com.company.project.web;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.model.JieqiArticleArticle;
import com.company.project.service.JieqiArticleArticleService;
import com.company.project.service.JieqiArticleChapterService;
import com.company.project.utils.Common;

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
		JieqiArticleArticle article = service.findById(articleid);
		String opfFile = Common.articleOpfFileFullPath(articleid);
		String content = FileUtils.readFileToString(new File(opfFile), "GBK");
		LinkedHashMap<String, String> chapterList = Common.chpaterList(articleid, 20, false, Common.opfDocumnet(content));
		model.addAttribute("chapterList", chapterList);
		model.addAttribute("article", article);
		return "info";
	}

	@RequestMapping("/chapter/{shortid}_{articleid}/{chapterid}")
	public String chapterContent(HttpServletRequest request, Model model, @PathVariable("articleid") Integer articleid,
			@PathVariable("chapterid") Integer chapterid) throws IOException {
		String content = Common.chapterContent(articleid, chapterid);
		content = content.replaceAll("\\r\\n\\r\\n", "<br />");
		content = content.replaceAll("\\r\\n", "<br />");
		model.addAttribute("content", content);
		return "chapter";
	}

}
