package com.company.project.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.core.AbstractService;
import com.company.project.dao.JieqiArticleBookcaseMapper;
import com.company.project.model.JieqiArticleBookcase;
import com.company.project.service.JieqiArticleBookcaseService;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Service
@Transactional
public class JieqiArticleBookcaseServiceImpl extends AbstractService<JieqiArticleBookcase>
		implements JieqiArticleBookcaseService {
	@Resource
	private JieqiArticleBookcaseMapper jieqiArticleBookcaseMapper;

	@Override
	public void addBookCase(JieqiArticleBookcase bookCase) {
		JieqiArticleBookcase old = jieqiArticleBookcaseMapper.bookCaseByUseridAndArticleid(bookCase.getUserid(),
				bookCase.getArticleid());
		if (old != null) {
			if (bookCase.getChapterid() == 0) {
				bookCase.setChapterid(old.getChapterid());
			}
			bookCase.setCaseid(old.getCaseid());
			update(bookCase);
		} else {
			save(bookCase);
		}
	}

	@Override
	public List<JieqiArticleBookcase> userBookCase(Integer uid) {
		return jieqiArticleBookcaseMapper.userBookCase(uid);
	}

	@Override
	public void delBookcase(Integer uid, Integer articleid) {
		jieqiArticleBookcaseMapper.delBookcase(uid, articleid);
	}

}
