package com.company.project.model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ad_code")
public class AdCode {
	@Id
	private Integer id;

	private String code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}