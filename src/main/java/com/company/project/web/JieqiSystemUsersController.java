package com.company.project.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.JieqiSystemUsers;
import com.company.project.service.JieqiSystemUsersService;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Controller
@RequestMapping("users")
public class JieqiSystemUsersController {
	@Resource
	private JieqiSystemUsersService jieqiSystemUsersService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if (obj != null) {
			JieqiSystemUsers user = (JieqiSystemUsers) session.getAttribute("user");
			model.addAttribute("user", user);
			return "info";
		}
		model.addAttribute("msg", "用户名或密码错误");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, @RequestParam String account,
			@RequestParam String password) {
		HttpSession session = request.getSession();
		JieqiSystemUsers user = jieqiSystemUsersService.findByAccountAndPass(account, password);
		if (user != null) {
			session.setAttribute("user", user);
			return "forward:/users/login";
		}
		model.addAttribute("msg", "用户名或密码错误");
		return "login";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
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
	public Result<Map<String, Object>> addBookMark(HttpServletRequest request, @RequestParam("articleId")String articleId, 
			@RequestParam("chapterId")String chapterId, Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		return ResultGenerator.genSuccessResult(map);
	}
}
