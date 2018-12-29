package com.company.project.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.service.JieqiArticleChapterService;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Controller
@RequestMapping("chapter")
public class JieqiArticleChapterController {
	@Resource
	private JieqiArticleChapterService jieqiArticleChapterService;

	@GetMapping("/chapter/{id}")
	public String chpater(@PathVariable(name = "id") String chpaterId) {
		
		return "chapter";
	}
}
