package com.company.project.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.core.AbstractService;
import com.company.project.model.AdCode;
import com.company.project.service.AdService;
import com.company.project.utils.Common;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Service
@Transactional
public class AdServiceImpl extends AbstractService<AdCode> implements AdService {

	private final Logger logger = LoggerFactory.getLogger(AdServiceImpl.class);

	@Override
	public void loadAdCode() {
		List<AdCode> list = findAll();
		for (AdCode item : list) {
			Common.ADMaps.put(item.getId(), item.getCode());
			logger.info(String.format("id: %d, code:%s", item.getId(), item.getCode()));
		}
	}

	@Override
	public List<AdCode> listCodes() {
		return null;
	}

}
