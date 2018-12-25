package com.company.project.service.impl;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.core.AbstractService;
import com.company.project.dao.JieqiSystemUsersMapper;
import com.company.project.model.JieqiSystemUsers;
import com.company.project.service.JieqiSystemUsersService;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Service
@Transactional
public class JieqiSystemUsersServiceImpl extends AbstractService<JieqiSystemUsers> implements JieqiSystemUsersService {
	@Resource
	private JieqiSystemUsersMapper jieqiSystemUsersMapper;

	@Override
	public JieqiSystemUsers findByAccountAndPass(String account, String password) {
		JieqiSystemUsers user = jieqiSystemUsersMapper.findByAccountAndPassword(account, DigestUtils.md5Hex(password));
		return user;
	}

}
