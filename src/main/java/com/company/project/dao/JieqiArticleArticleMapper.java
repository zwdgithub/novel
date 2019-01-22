package com.company.project.dao;

import java.util.List;

import com.company.project.core.Mapper;
import com.company.project.model.JieqiArticleArticle;

public interface JieqiArticleArticleMapper extends Mapper<JieqiArticleArticle> {

	public List<JieqiArticleArticle> topList();

	public List<JieqiArticleArticle> categoryTopList(Integer sortId);
	
	public List<JieqiArticleArticle> classList(Integer sortid, Integer start, Integer limit);
	
	public List<JieqiArticleArticle> topClassList(Integer sortid, Integer start, Integer limit, String orderColumn);
	
	public List<JieqiArticleArticle> finishClassList(Integer sortid, Integer start, Integer limit);
	
	public void dayVisitIncr(Integer articleid);
		
	public List<JieqiArticleArticle> search(String keyword) ;
}