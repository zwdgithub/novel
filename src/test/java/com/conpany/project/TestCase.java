package com.conpany.project;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.Node;
import org.junit.Test;

import com.company.project.utils.Common;

public class TestCase extends Tester {

	@Test
	public void test() throws IOException {
		String content = FileUtils.readFileToString(new File("C:\\Users\\uper\\Desktop\\index.opf"), "gbk");
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
		for (Map<String, String> map : list) {
			System.out.println(map.get("chapterId"));
		}
		System.out.println(list.size());
	}

	@Test
	public void parseArticle() throws IOException, ParseException {
		HashMap<String, Object> map = new HashMap<>();
		String content = FileUtils.readFileToString(new File("d:/index.opf"), "GBK");
		Document document = Common.opfDocumnet(content);
		Node node = document.selectNodes("/package/metadata/dc-metadata").get(0);
		String articleName = node.selectSingleNode("./Title").getStringValue();
		String author = node.selectSingleNode("./Creator").getStringValue();
		String intro = node.selectSingleNode("./Description").getStringValue();
		String sortid = node.selectSingleNode("./Sortid").getStringValue();
		String updateTime = node.selectSingleNode("./Date").getStringValue();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = dateFormat.parse(updateTime);
		map.put("articlename", articleName);
		map.put("author", author);
		map.put("intro", intro);
		map.put("sortid", sortid);
		map.put("updateTime", dateFormat2.format(date));

		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

	}

}
