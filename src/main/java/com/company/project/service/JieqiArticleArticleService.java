package com.company.project.service;

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

}
