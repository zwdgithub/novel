package com.company.project.dao;

import java.util.List;

import com.company.project.core.Mapper;
import com.company.project.model.JieqiArticleArticle;

public interface JieqiArticleArticleMapper extends Mapper<JieqiArticleArticle> {

	public List<JieqiArticleArticle> topList();

	public List<JieqiArticleArticle> categoryTopList(Integer sortId);
}