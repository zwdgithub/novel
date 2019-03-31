package com.company.project.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.model.JieqiArticleArticle;
import com.company.project.model.JieqiSystemUsers;
import com.company.project.service.JieqiArticleArticleService;
import com.company.project.service.JieqiArticleChapterService;
import com.company.project.service.JieqiSystemUsersService;
import com.company.project.utils.Common;

@Controller
public class IndexController {

	@Resource
	private JieqiArticleArticleService service;
	@Resource
	private JieqiArticleChapterService chapterService;
	@Resource
	private JieqiSystemUsersService jieqiSystemUsersService;
	@Value("${project.pcurl}")
	private String pcurl;

	@RequestMapping("/")
	public String list(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		JieqiSystemUsers user = Common.currentUser(request);
		if (user == null) {
			String uname = "";
			String upass = "";
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("_17mb_username")) {
						uname = cookie.getValue();
					}
					if (cookie.getName().equals("_17mb_userpass")) {
						upass = cookie.getValue();
					}
				}
				if (StringUtils.isNoneBlank(uname) && StringUtils.isNotBlank(upass)) {
					JieqiSystemUsers u = jieqiSystemUsersService.findByAccountAndPass(uname, upass);
					if (u != null) {
						session.setAttribute("user", u);
					}
				}
			}
		}
//		Map<Integer, List<JieqiArticleArticle>> categorys = Common.INDEX_PAGE_TOP_ARTICLE;
		// List<JieqiArticleArticle> top = service.TopList();
		model.addAttribute("top", Common.TOP_ARTICLE);
		model.addAttribute("pcurl", pcurl);
		model.addAttribute("categorys", Common.INDEX_PAGE_TOP_ARTICLE);
		return "index";
	}
}
