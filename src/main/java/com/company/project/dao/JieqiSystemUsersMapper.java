package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.JieqiSystemUsers;

public interface JieqiSystemUsersMapper extends Mapper<JieqiSystemUsers> {

	JieqiSystemUsers findByAccountAndPassword(String account, String password);

}