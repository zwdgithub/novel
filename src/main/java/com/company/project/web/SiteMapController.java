package com.company.project.web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sitemap")
public class SiteMapController {

	@GetMapping("m_index.xml")
	@ResponseBody
	public String sitemap() throws IOException {
		return FileUtils.readFileToString(new File("/home/www/html/2hxs/sitemap/m_index.xml"), "UTF-8");
		// return FileUtils.readFileToString(new File("e:/m_index.xml"), "UTF-8");
	}

	@GetMapping("m_index_{index}.xml")
	@ResponseBody
	public String sitemap_detail(@PathVariable String index) throws IOException {
		return FileUtils.readFileToString(new File("/home/www/html/2hxs/sitemap/m_index_" + index + ".xml"), "UTF-8");
		// return FileUtils.readFileToString(new File("e:/m_index_"+ index + ".xml"),
		// "UTF-8");
	}
}
