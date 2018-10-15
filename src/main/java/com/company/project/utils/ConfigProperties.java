package com.company.project.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigProperties {

	public static String TXT_PATH;

	@Value("${project.txtpath}")
	public void setTxtPath(String txtPath) {
		TXT_PATH = txtPath;
	}

}
