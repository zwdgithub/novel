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
//		HashMap<String, Object> map = new HashMap<>();
//		String content = FileUtils.readFileToString(new File("d:/index.opf"), "GBK");
//		Document document = Common.opfDocumnet(content);
//		Node node = document.selectNodes("/package/metadata/dc-metadata").get(0);
//		String articleName = node.selectSingleNode("./Title").getStringValue();
//		String author = node.selectSingleNode("./Creator").getStringValue();
//		String intro = node.selectSingleNode("./Description").getStringValue();
//		String sortid = node.selectSingleNode("./Sortid").getStringValue();
//		String updateTime = node.selectSingleNode("./Date").getStringValue();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = dateFormat.parse(updateTime);
//		map.put("articlename", articleName);
//		map.put("author", author);
//		map.put("intro", intro);
//		map.put("sortid", sortid);
//		map.put("updateTime", dateFormat2.format(date));
//
//		for (Map.Entry<String, Object> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		}

		System.out.println(map_tx2bd(39.936890, 116.328530));
		
	}


/**
	 * 坐标转换，腾讯地图转换成百度地图坐标
	 * @param lat 腾讯纬度
	 * @param lon 腾讯经度
	 * @return 返回结果：经度,纬度
	 */
	public static String map_tx2bd(double lat, double lon){
		double bd_lat;
		double bd_lon;
		double x_pi=3.14159265358979324;
	    double x = lon, y = lat;
	    double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
	    double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
	    bd_lon = z * Math.cos(theta) + 0.0065;
	    bd_lat = z * Math.sin(theta) + 0.006;
	    
	    System.out.println("bd_lat:"+bd_lat);
	    System.out.println("bd_lon:"+bd_lon);
	    return bd_lon+","+bd_lat;
	}
 
	 
	/**
	 * 坐标转换，百度地图坐标转换成腾讯地图坐标
	 * @param lat  百度坐标纬度
	 * @param lon  百度坐标经度
	 * @return 返回结果：纬度,经度
	 */
	public static String map_bd2tx(double lat, double lon){
		double tx_lat;
		double tx_lon;
		double x_pi=3.14159265358979324;
		double x = lon - 0.0065, y = lat - 0.006;
	    double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
	    double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
	    tx_lon = z * Math.cos(theta);
	    tx_lat = z * Math.sin(theta);
	    return tx_lat+","+tx_lon;
	}

	
}
