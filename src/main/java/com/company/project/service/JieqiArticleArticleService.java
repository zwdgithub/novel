package com.company.project.service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;

import com.company.project.core.Service;
import com.company.project.model.JieqiArticleArticle;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
public interface JieqiArticleArticleService extends Service<JieqiArticleArticle> {

	public List<JieqiArticleArticle> TopList();

	public Map<Integer, List<JieqiArticleArticle>> CategoryTopList();

	public List<JieqiArticleArticle> classList(Integer sortid, Integer start, Integer limit);

	public String chapterContent(Integer articleId, Integer chapterId) throws IOException;

	public LinkedHashMap<String, String> chpaterList(Integer articleId, Integer chpaterNum, Boolean start) throws IOException;

	public JieqiArticleArticle info(Integer articleId);

}
