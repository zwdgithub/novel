package com.company.project.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.JieqiArticleChapter;
import com.company.project.service.JieqiArticleChapterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Controller
@RequestMapping("chapter")
public class JieqiArticleChapterController {
	@Resource
	private JieqiArticleChapterService jieqiArticleChapterService;

	@PostMapping("/add")
	public Result add(JieqiArticleChapter jieqiArticleChapter) {
		jieqiArticleChapterService.save(jieqiArticleChapter);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam Integer id) {
		jieqiArticleChapterService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/update")
	public Result update(JieqiArticleChapter jieqiArticleChapter) {
		jieqiArticleChapterService.update(jieqiArticleChapter);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam Integer id) {
		JieqiArticleChapter jieqiArticleChapter = jieqiArticleChapterService.findById(id);
		return ResultGenerator.genSuccessResult(jieqiArticleChapter);
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<JieqiArticleChapter> list = jieqiArticleChapterService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@GetMapping("/chapter/{id}")
	public String chpater(@PathVariable(name = "id") String chpaterId) {
		
		return "chapter";
	}
}
