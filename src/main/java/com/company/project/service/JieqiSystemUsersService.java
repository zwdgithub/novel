package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.JieqiSystemUsers;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
public interface JieqiSystemUsersService extends Service<JieqiSystemUsers> {

	JieqiSystemUsers findByAccountAndPass(String account, String pass);

}
