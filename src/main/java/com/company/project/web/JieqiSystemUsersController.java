package com.company.project.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.JieqiSystemUsers;
import com.company.project.service.JieqiSystemUsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@RestController
@RequestMapping("/users")
public class JieqiSystemUsersController {
	@Resource
	private JieqiSystemUsersService jieqiSystemUsersService;

	@PostMapping("/add")
	public Result add(JieqiSystemUsers jieqiSystemUsers) {
		jieqiSystemUsersService.save(jieqiSystemUsers);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		jieqiSystemUsersService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(JieqiSystemUsers jieqiSystemUsers) {
		jieqiSystemUsersService.update(jieqiSystemUsers);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		JieqiSystemUsers jieqiSystemUsers = jieqiSystemUsersService.findById(id);
		return ResultGenerator.genSuccessResult(jieqiSystemUsers);
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<JieqiSystemUsers> list = jieqiSystemUsersService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

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
