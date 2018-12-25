package com.company.project.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.model.JieqiSystemUsers;
import com.company.project.service.JieqiSystemUsersService;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@RestController
@RequestMapping("/users")
public class JieqiSystemUsersController {
	@Resource
	private JieqiSystemUsersService jieqiSystemUsersService;

	@PostMapping("/login")
	public String login(HttpServletRequest request, Model model, @RequestParam String account,
			@RequestParam String password) {
		HttpSession session = request.getSession();
		JieqiSystemUsers user = jieqiSystemUsersService.findByAccountAndPass(account, password);
		if (user != null) {
			session.setAttribute("user", user);
			return "index";
		}
		model.addAttribute("msg", "用户名或密码错误");
		return "";
	}
}
