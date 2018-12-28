package com.company.project.utils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.springframework.cache.annotation.Cacheable;

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

	public static Document opfDocumnet(String content) {
		content = content.replaceAll("<dc:", "<").replaceAll("</dc:", "</");
		return Common.load(content);
	}

	public static LinkedHashMap<String, String> parseChapterList(Integer length, Boolean start, Document document) {
		// Document document = opfDocumnet(content);
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		List<Node> nodes = document.selectNodes("/package/manifest/item");
		if (!start) {
			Collections.reverse(nodes);
		}
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			String contentType = node.selectNodes("@content-type").get(0).getText();
			if (contentType.equals("chapter")) {
				String chapterName = node.selectNodes("@id").get(0).getText();
				String chapterId = node.selectNodes("@href").get(0).getText().replaceAll(".txt", "");
				map.put(chapterId, chapterName);
				if (map.size() == length) {
					break;
				}
			}
		}
		return map;
	}

	public static void parseArticleInfo(Document document) {
		List<Node> nodes = document.selectNodes("/package/metadata/dc-metadata");
		System.out.println(nodes);
	}

	public static String articleTxtFileFullPath(Integer articleId, Integer chapterId) {
		Integer shortId = articleId / 1000;
		return ConfigProperties.TXT_PATH + shortId + File.separator + articleId + File.separator + chapterId + ".txt";
	}

	public static String articleOpfFileFullPath(Integer articleId) {
		Integer shortId = articleId / 1000;
		return ConfigProperties.TXT_PATH + shortId + File.separator + +articleId + File.separator + "index.opf";
	}

	@Cacheable(key = "#chapterId", value = "chapterContent")
	public static String chapterContent(Integer articleId, Integer chapterId) throws IOException {
		String txtFile = articleTxtFileFullPath(articleId, chapterId);
		return FileUtils.readFileToString(new File(txtFile), "GBK");
	}

	@Cacheable(key = "#articleId", value = "chapterContent")
	public static LinkedHashMap<String, String> chpaterList(Integer articleId, Integer chpaterNum, Boolean start,
			Document document) throws IOException {
		return parseChapterList(chpaterNum, start, document);
	}
}
