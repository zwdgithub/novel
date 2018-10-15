package com.company.project.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
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

	public static List<Map<String, String>> parseChapterList(String content, Integer length, Integer start) {
		content = content.replaceAll("<dc:", "<").replaceAll("</dc:", "</");
		Document document = Common.load(content);
		List<Node> nodes = document.selectNodes("/package/manifest/item");
		List<Map<String, String>> list = new ArrayList<>();
		if (start == 0) {
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
					if (list.size() == length) {
						break;
					}
				}
			}
		} else {
			for (int i = nodes.size()-1; i > 0; i--) {
				Node node = nodes.get(i);
				String contentType = node.selectNodes("@content-type").get(0).getText();
				if (contentType.equals("chapter")) {
					Map<String, String> map = new HashMap<>();
					String chapterName = node.selectNodes("@id").get(0).getText();
					String chapterId = node.selectNodes("@href").get(0).getText().replaceAll(".txt", "");
					map.put("chapterId", chapterId);
					map.put("chapterName", chapterName);
					list.add(map);
					if (list.size() == length) {
						break;
					}
				}
			}
		}
		return list;
	}

	public static String articleTxtFileFullPath(Integer articleId, Integer chapterId) {
		Integer shortId = articleId / 1000;
		return ConfigProperties.TXT_PATH + shortId + File.separator + articleId + File.separator + chapterId + ".txt";
	}

	public static String articleOpfFileFullPath(Integer articleId) {
		Integer shortId = articleId / 1000;
		return ConfigProperties.TXT_PATH + shortId + File.separator + +articleId + File.separator + "index.opf";
	}

	public static String chapterContent(Integer articleId, Integer chapterId) throws IOException {
		String txtFile = articleTxtFileFullPath(articleId, chapterId);
		return FileUtils.readFileToString(new File(txtFile), "GBK");
	}

	public static List<Map<String, String>> chpaterList(Integer articleId, Integer chpaterNum, Integer start)
			throws IOException {
		String opfFile = articleOpfFileFullPath(articleId);
		String content = FileUtils.readFileToString(new File(opfFile), "GBK");
		return parseChapterList(content, chpaterNum, start);
	}
}
