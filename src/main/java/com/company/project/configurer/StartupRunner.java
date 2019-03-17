package com.company.project.configurer;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.company.project.service.AdService;
import com.company.project.service.JieqiArticleArticleService;
import com.company.project.utils.Common;

@Component
public class StartupRunner implements CommandLineRunner {

	@Resource
	private AdService service;
	@Resource
	private JieqiArticleArticleService articleService;

	@Override
	public void run(String... args) throws Exception {
		service.loadAdCode();
		Common.INDEX_PAGE_TOP_ARTICLE = articleService.CategoryTopList();
	}

}
