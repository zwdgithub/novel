package com.company.project.service;

import java.util.List;

import com.company.project.core.Service;
import com.company.project.model.AdCode;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
public interface AdService extends Service<AdCode> {

	public void loadAdCode();

	public List<AdCode> listCodes();

}
