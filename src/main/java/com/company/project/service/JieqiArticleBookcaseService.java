package com.company.project.service;

import java.util.List;

import com.company.project.core.Service;
import com.company.project.model.JieqiArticleBookcase;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
public interface JieqiArticleBookcaseService extends Service<JieqiArticleBookcase> {

	void addBookCase(JieqiArticleBookcase bookCase);

	List<JieqiArticleBookcase> userBookCase(Integer uid);
	
	void delBookcase(Integer uid, Integer articleid);
}
