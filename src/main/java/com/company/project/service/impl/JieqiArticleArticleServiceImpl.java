package com.company.project.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.core.AbstractService;
import com.company.project.dao.JieqiArticleArticleMapper;
import com.company.project.model.JieqiArticleArticle;
import com.company.project.service.JieqiArticleArticleService;
import com.company.project.utils.Common;

/**
 * Created by CodeGenerator on 2018/09/10.
 */
@Service
@Transactional
public class JieqiArticleArticleServiceImpl extends AbstractService<JieqiArticleArticle>
		implements JieqiArticleArticleService {
	@Resource
	private JieqiArticleArticleMapper jieqiArticleArticleMapper;

	@Cacheable(key = "#root.methodName", value = "index")
	@Override
	public List<JieqiArticleArticle> TopList() {
		List<JieqiArticleArticle> topList = jieqiArticleArticleMapper.topList();
		return topList;
	}

	@Cacheable(key = "#root.methodName", value = "index")
	@Override
	public Map<Integer, List<JieqiArticleArticle>> CategoryTopList() {
		Map<Integer, List<JieqiArticleArticle>> map = new HashMap<>();
		map.put(1, jieqiArticleArticleMapper.categoryTopList(1));
		map.put(2, jieqiArticleArticleMapper.categoryTopList(2));
		map.put(3, jieqiArticleArticleMapper.categoryTopList(3));
		map.put(4, jieqiArticleArticleMapper.categoryTopList(4));
		return map;
	}

	@Override
	public List<JieqiArticleArticle> classList(Integer sortid, Integer start, Integer limit) {
		return jieqiArticleArticleMapper.classList(sortid, start, limit);
	}

	@Cacheable(key = "#chapterId", value = "chapterContent")
	public Map<String, Object> chapterContent(Integer articleId, Integer chapterId) throws IOException {
		String txtFile = Common.articleTxtFileFullPath(articleId, chapterId);
		String content = FileUtils.readFileToString(new File(txtFile), "GBK");
		content = content.replaceAll("\\r\\n\\r\\n", "<br/><br/>");
		content = content.replaceAll("\\r\\n", "<br/><br/>    ");
		content = content.replaceAll("<br />", "<br/>");
		content = content.replaceAll(" ", "&nbsp;");
		LinkedHashMap<String, String> chapters = this.chpaterList(articleId, true);
		Map<String, Object> chapter = new HashMap<>();
		chapter.put("content", content);
		chapter.put("chapterId", chapterId);
		chapter.put("chapterName", chapters.get(Integer.toString(chapterId)));
		return chapter;
	}

	@Cacheable(key = "#articleId", value = "chpaterListTopN")
	public LinkedHashMap<String, String> chpaterListTopN(Integer articleId, Integer chpaterNum) throws IOException {
		String opfFile = Common.articleOpfFileFullPath(articleId);
		String content = FileUtils.readFileToString(new File(opfFile), "GBK");
		return Common.parseChapterList(chpaterNum, false, Common.opfDocumnet(content));
	}

	@Cacheable(key = "#articleId", value = "chpaterList")
	public LinkedHashMap<String, String> chpaterList(Integer articleId, Boolean start) throws IOException {
		String opfFile = Common.articleOpfFileFullPath(articleId);
		String content = FileUtils.readFileToString(new File(opfFile), "GBK");
		return Common.parseChapterList(1000000, start, Common.opfDocumnet(content));
	}

	@Override
	@Cacheable(key = "#articleId", value = "info")
	public JieqiArticleArticle info(Integer articleId) {
		return findById(articleId);
	}

	@Override
	public List<JieqiArticleArticle> topClassList(Integer sortid, Integer start, Integer limit, String order) {
		return jieqiArticleArticleMapper.topClassList(sortid, start, limit, order);
	}

	@Override
	public List<JieqiArticleArticle> finishClassList(Integer sortid, Integer start, Integer limit) {
		return jieqiArticleArticleMapper.finishClassList(sortid, start, limit);
	}

	@Override
	public void dayVisitIncr(Integer articleid) {
		jieqiArticleArticleMapper.dayVisitIncr(articleid);
	}

	@Override
	public List<JieqiArticleArticle> search(String keyword) {
		return jieqiArticleArticleMapper.search(keyword);
	}
}
