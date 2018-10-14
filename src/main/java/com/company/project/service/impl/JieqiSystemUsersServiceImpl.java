package com.company.project.service.impl;

import com.company.project.dao.JieqiSystemUsersMapper;
import com.company.project.model.JieqiSystemUsers;
import com.company.project.service.JieqiSystemUsersService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Service
@Transactional
public class JieqiSystemUsersServiceImpl extends AbstractService<JieqiSystemUsers> implements JieqiSystemUsersService {
    @Resource
    private JieqiSystemUsersMapper jieqiSystemUsersMapper;

}
