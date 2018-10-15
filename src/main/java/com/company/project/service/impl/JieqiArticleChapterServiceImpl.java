package com.company.project.service.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.core.AbstractService;
import com.company.project.dao.JieqiArticleChapterMapper;
import com.company.project.model.JieqiArticleChapter;
import com.company.project.service.JieqiArticleChapterService;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Service
@Transactional
public class JieqiArticleChapterServiceImpl extends AbstractService<JieqiArticleChapter>
		implements JieqiArticleChapterService {
	@Resource
	private JieqiArticleChapterMapper jieqiArticleChapterMapper;

	public String chpater(String id) throws IOException {
		String fileName = "";
		String content = FileUtils.readFileToString(new File(fileName), "GBK");

		return content;
	}

}
