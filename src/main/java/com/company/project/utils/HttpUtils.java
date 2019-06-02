package com.company.project.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class.getName());

	public static boolean get(String serverUrl, int timeout) {
		URL url;
		try {
			LOGGER.info(serverUrl);
			url = new URL(serverUrl);
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(timeout);
			conn.getInputStream();
			return true;
		} catch (IOException e) {
			LOGGER.error("", e);
		} finally {
		}
		return false;
	}

	public static void pushMessage(String message) throws UnsupportedEncodingException {
		LOGGER.info("文章异常提醒："+ message);
		String url = "https://sc.ftqq.com/SCU13868Te3a23c4efa4dc26084d9efa9ab100e7559e088f342df1.send?text=";
		get(url + URLEncoder.encode(message, "utf-8"), 5000);
	}
}
