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
		String url = "http://wx.54868.net/push?key=785704b6974c6df7386e78fc6d9b4c52b0095c40&title=异常提醒&msg=";
		get(url + URLEncoder.encode(message, "utf-8"), 5000);
	}
}
