package com.company.project.dao;

import java.util.List;

import com.company.project.core.Mapper;
import com.company.project.model.JieqiArticleBookcase;

public interface JieqiArticleBookcaseMapper extends Mapper<JieqiArticleBookcase> {

	JieqiArticleBookcase bookCaseByUseridAndArticleid(Integer userid, Integer articleid);

	List<JieqiArticleBookcase> userBookCase(Integer uid);
	
	void delBookcase(Integer uid, Integer articleid);
	
}