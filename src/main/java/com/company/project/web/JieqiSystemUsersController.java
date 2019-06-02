package com.company.project.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.JieqiArticleBookcase;
import com.company.project.model.JieqiSystemUsers;
import com.company.project.service.JieqiArticleBookcaseService;
import com.company.project.service.JieqiSystemUsersService;
import com.company.project.utils.Common;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Controller
@RequestMapping("users")
public class JieqiSystemUsersController {
	@Resource
	private JieqiSystemUsersService jieqiSystemUsersService;
	@Resource
	private JieqiArticleBookcaseService bookCaseService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj != null) {
			JieqiSystemUsers user = (JieqiSystemUsers) session.getAttribute("user");
			model.addAttribute("user", user);
			return "user";
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam String account, @RequestParam String password) {
		HttpSession session = request.getSession();
		JieqiSystemUsers user = jieqiSystemUsersService.findByAccountAndPass(account, password);
		if (user != null) {
			session.setAttribute("user", user);
			session.setAttribute("userName", user.getUname());
			Cookie cookie = new Cookie("_17mb_username", account);// 创建新cookie
			Cookie cookie2 = new Cookie("_17mb_userpass", password);// 创建新cookie
			cookie.setMaxAge(60 * 60 * 24 * 30);// 设置存在时间为5分钟
			cookie2.setMaxAge(60 * 60 * 24 * 30);// 设置存在时间为5分钟
			cookie.setPath("/");// 设置作用域
			cookie2.setPath("/");// 设置作用域
			response.addCookie(cookie);// 将cookie添加到response的cookie数组中返回给客户端
			response.addCookie(cookie2);
			return "user";
		}
		model.addAttribute("msg", "用户名或密码错误");
		return "login";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		JieqiSystemUsers obj = (JieqiSystemUsers) session.getAttribute("user");
		if (obj != null) {
			session.removeAttribute("user");
		}
		return "redirect:/";
	}

	@GetMapping("/read-record")
	public String readRecord(HttpServletRequest request, Model model) {
		return "newcase";
	}

	@PostMapping("/add-bookmark")
	@ResponseBody
	public Result<Map<String, Object>> addBookMark(HttpServletRequest request,
			@RequestBody JieqiArticleBookcase bookCase, Model model) {
		Map<String, Object> map = new HashMap<>();
		JieqiSystemUsers user = Common.currentUser(request);
		if (user == null) {
			return ResultGenerator.genSuccessResult(map);
		}
		bookCase.setUserid(user.getUid());
		bookCase.setJoindate(System.currentTimeMillis() / 1000);
		bookCaseService.addBookCase(bookCase);

		map.put("success", true);
		return ResultGenerator.genSuccessResult(map);
	}

	@GetMapping("/mybook")
	public String mybook(HttpServletRequest request, Model model) {
		JieqiSystemUsers user = Common.currentUser(request);
		if (user == null) {
			return "redirect:/users/login";
		}
		List<JieqiArticleBookcase> list = bookCaseService.userBookCase(user.getUid());
		model.addAttribute("list", list);
		return "mybook";
	}

	@GetMapping("/del-bookcase")
	public String delMybook(HttpServletRequest request, Model model) {
		JieqiSystemUsers user = Common.currentUser(request);
		if (user == null) {
			return "redirect:/users/login";
		}
		String articleid = request.getParameter("articleid");
		bookCaseService.delBookcase(user.getUid(), Integer.valueOf(articleid));
		return "redirect:/users/mybook";
	}

	@GetMapping("/register-page")
	public String registerPage(HttpServletRequest request, Model model) {

		return "register";
	}

	@PostMapping("/register")
	public String register(HttpServletRequest request, Model model) {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		JieqiSystemUsers temp = jieqiSystemUsersService.findByAccount(uname);
		if (temp != null) {
			model.addAttribute("msg", "用户名已存在");
			return "register";
		}
		JieqiSystemUsers user = new JieqiSystemUsers();
		user.setUname(uname);
		user.setPass(DigestUtils.md5Hex(upass));
		user.setGroupid(3);
		user.setEmail(user.getUname() + "@qq.com");
		user.setSign("0");
		user.setIntro("0");
		user.setSetting("0");
		user.setBadges("0");
		user.setLastlogin(0);
		user.setViewemail(false);
		user.setNotifymode(false);
		user.setIntro("0");
		user.setAdminemail(false);
		user.setMonthscore(0);
		user.setWeekscore(0);
		user.setDayscore(0);
		user.setLastscore(0);
		user.setExperience(0);
		user.setScore(0);
		user.setEgold(0);
		user.setEsilver(0);
		user.setCredit(0);
		user.setGoodnum(0);
		user.setBadnum(0);
		user.setIsvip(false);
		user.setOvertime(0);
		user.setState(false);
		user.setRegdate(System.currentTimeMillis() / 1000);
		jieqiSystemUsersService.save(user);
		JieqiSystemUsers u = jieqiSystemUsersService.findByAccount(uname);
		request.getSession().setAttribute("user", u);
		return "redirect:/users/mybook";
	}

}
