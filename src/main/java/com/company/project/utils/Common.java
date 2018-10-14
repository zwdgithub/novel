package com.company.project.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

public class Common {

	public static Document load(String text) {
		Document document = null;
		try {
			document = DocumentHelper.parseText(text);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}

	public void ChapterList(String content) {
		content = content.replaceAll("<dc:", "<").replaceAll("</dc:", "</");
		Document document = Common.load(content);
		List<Node> nodes = document.selectNodes("/package/manifest/item");
		List<Map<String, String>> list = new ArrayList<>();
		Integer length = 20;
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			String contentType = node.selectNodes("@content-type").get(0).getText();
			if (contentType.equals("chapter")) {
				Map<String, String> map = new HashMap<>();
				String chapterName = node.selectNodes("@id").get(0).getText();
				String chapterId = node.selectNodes("@href").get(0).getText().replaceAll(".txt", "");
				map.put("chapterId", chapterId);
				map.put("chapterName", chapterName);
				list.add(map);
				if (i == length) {
					break;
				}
			}
		}
		System.out.println(list.size());
	}
}
