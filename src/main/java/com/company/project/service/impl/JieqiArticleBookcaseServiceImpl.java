package com.company.project.service.impl;

import com.company.project.dao.JieqiArticleBookcaseMapper;
import com.company.project.model.JieqiArticleBookcase;
import com.company.project.service.JieqiArticleBookcaseService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Service
@Transactional
public class JieqiArticleBookcaseServiceImpl extends AbstractService<JieqiArticleBookcase> implements JieqiArticleBookcaseService {
    @Resource
    private JieqiArticleBookcaseMapper jieqiArticleBookcaseMapper;

}
