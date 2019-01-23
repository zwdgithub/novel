package com.company.project.utils;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.company.project.configurer.WebMvcConfigurer;
import com.company.project.model.JieqiSystemUsers;

@Component
public class Common {

	private static Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

	public static Map<Integer, String> CATEGORYS = new HashMap<>();

	static {
		/**
		 * project.conf.categorys[class1]=玄幻小说 project.conf.categorys[class2]=仙侠小说
		 * project.conf.categorys[class3]=都市小说 project.conf.categorys[class4]=军史小说
		 * project.conf.categorys[class5]=网游小说 project.conf.categorys[class6]=科幻小说
		 * project.conf.categorys[class7]=其他小说 project.conf.categorys[class8]=言情小说
		 */
		CATEGORYS.put(0, "分类");
		CATEGORYS.put(1, "玄幻小说");
		CATEGORYS.put(2, "仙侠小说");
		CATEGORYS.put(3, "都市小说");
		CATEGORYS.put(4, "军史小说");
		CATEGORYS.put(5, "网游小说");
		CATEGORYS.put(6, "科幻小说");
		CATEGORYS.put(7, "其他小说");
		CATEGORYS.put(8, "言情小说");
	}

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

	public static LinkedHashMap<String, Map<String, String>> parseChapterList(Integer length, Boolean start,
			Document document) {
		// Document document = opfDocumnet(content);
		logger.info("parseChapterList >>>>>>>>>>>>>>>>>>>>>>>>>>> 执行");
		LinkedHashMap<String, Map<String, String>> map = new LinkedHashMap<>();
		List<Node> nodes = document.selectNodes("/package/manifest/item");
		if (!start) {
			Collections.reverse(nodes);
		}
		String preChpaterId = null;
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			String contentType = node.selectNodes("@content-type").get(0).getText();
			if (contentType.equals("chapter")) {
				String chapterName = node.selectNodes("@id").get(0).getText();
				String chapterId = node.selectNodes("@href").get(0).getText().replaceAll(".txt", "");
				Map<String, String> item = new HashMap<>();
				if (preChpaterId != null) {
					map.get(preChpaterId).put("next", chapterId);
				}
				item.put(chapterId, chapterName);
				item.put("pre", preChpaterId);
				preChpaterId = chapterId;
				map.put(chapterId, item);
				if (map.size() == length) {
					break;
				}
			}
		}
		return map;
	}

	// public static void parseArticleInfo(Document document) {
	// List<Node> nodes = document.selectNodes("/package/metadata/dc-metadata");
	// System.out.println(nodes);
	// }

	public static String articleTxtFileFullPath(Integer articleId, Integer chapterId) {
		Integer shortId = articleId / 1000;
		return ConfigProperties.TXT_PATH + shortId + File.separator + articleId + File.separator + chapterId + ".txt";
	}

	public static String articleOpfFileFullPath(Integer articleId) {
		Integer shortId = articleId / 1000;
		return ConfigProperties.TXT_PATH + shortId + File.separator + +articleId + File.separator + "index.opf";
	}

	public static JieqiSystemUsers currentUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		JieqiSystemUsers user = (JieqiSystemUsers) session.getAttribute("user");
		return user;
	}
}
