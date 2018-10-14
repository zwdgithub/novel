package com.conpany.project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
		String content = FileUtils.readFileToString(new File("e:/index.opf"), "gbk");
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
