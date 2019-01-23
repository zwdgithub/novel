package com.company.project.service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.company.project.core.Service;
import com.company.project.model.JieqiArticleArticle;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
public interface JieqiArticleArticleService extends Service<JieqiArticleArticle> {

	public List<JieqiArticleArticle> TopList();

	public Map<Integer, List<JieqiArticleArticle>> CategoryTopList();

	public List<JieqiArticleArticle> classList(Integer sortid, Integer start, Integer limit);
	
	public List<JieqiArticleArticle> topClassList(Integer sortid, Integer start, Integer limit, String order);
	
	public List<JieqiArticleArticle> finishClassList(Integer sortid, Integer start, Integer limit);

	public Map<String, Object> chapterContent(Integer articleId, Integer chapterId) throws IOException;

	public LinkedHashMap<String, Map<String, String>> chpaterList(Integer articleId, Boolean start) throws IOException;
	
	public LinkedHashMap<String, Map<String, String>> chpaterListTopN(Integer articleId, Integer chpaterNum) throws IOException;

	public JieqiArticleArticle info(Integer articleId);
	
	public void dayVisitIncr(Integer articleid);
	
	public List<JieqiArticleArticle> search(String keyword);

}
