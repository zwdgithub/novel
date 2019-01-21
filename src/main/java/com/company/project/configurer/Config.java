package com.company.project.configurer;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "project.conf")
public class Config {

	private Map<String, String> categorys = new HashMap<>();

	public Map<String, String> getCategorys() {
		return categorys;
	}

	public void setCategorys(Map<String, String> categorys) {
		categorys.forEach((k, v) -> {
			try {
				System.out.println(new String(v.getBytes("iso8859-1"), "utf-8"));
				categorys.put(k, new String(v.getBytes("iso8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		});
		this.categorys = categorys;
	}

}
