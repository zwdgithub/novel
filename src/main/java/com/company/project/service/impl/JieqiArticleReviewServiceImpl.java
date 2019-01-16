package com.company.project.service.impl;

import com.company.project.dao.JieqiArticleReviewMapper;
import com.company.project.model.JieqiArticleReview;
import com.company.project.service.JieqiArticleReviewService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/01/15.
 */
@Service
@Transactional
public class JieqiArticleReviewServiceImpl extends AbstractService<JieqiArticleReview> implements JieqiArticleReviewService {
    @Resource
    private JieqiArticleReviewMapper jieqiArticleReviewMapper;

}
