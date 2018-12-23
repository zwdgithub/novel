package com.company.project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.core.AbstractService;
import com.company.project.dao.JieqiArticleArticleMapper;
import com.company.project.model.JieqiArticleArticle;
import com.company.project.service.JieqiArticleArticleService;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Service
@Transactional
public class JieqiArticleArticleServiceImpl extends AbstractService<JieqiArticleArticle>
		implements JieqiArticleArticleService {
	@Resource
	private JieqiArticleArticleMapper jieqiArticleArticleMapper;

	@Cacheable(key = "#root.methodName", value = "index")
	@Override
	public List<JieqiArticleArticle> TopList() {
		List<JieqiArticleArticle> topList = jieqiArticleArticleMapper.topList();
		return topList;
	}

	@Cacheable(key = "#root.methodName", value = "index")
	@Override
	public Map<Integer, List<JieqiArticleArticle>> CategoryTopList() {
		Map<Integer, List<JieqiArticleArticle>> map = new HashMap<>();
		map.put(1, jieqiArticleArticleMapper.categoryTopList(1));
		map.put(2, jieqiArticleArticleMapper.categoryTopList(2));
		map.put(3, jieqiArticleArticleMapper.categoryTopList(3));
		map.put(4, jieqiArticleArticleMapper.categoryTopList(4));
		return map;
	}

	@Override
	public List<JieqiArticleArticle> classList(Integer sortid, Integer start, Integer limit) {
		return jieqiArticleArticleMapper.classList(sortid, start, limit);
	}

}
