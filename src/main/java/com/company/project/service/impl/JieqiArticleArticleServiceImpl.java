package com.company.project.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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
@EnableScheduling
public class JieqiArticleArticleServiceImpl extends AbstractService<JieqiArticleArticle>
		implements JieqiArticleArticleService {

	private final Logger logger = LoggerFactory.getLogger(AdServiceImpl.class);

	@Resource
	private JieqiArticleArticleMapper jieqiArticleArticleMapper;

	@CachePut(key = "#root.methodName", value = "index")
	public List<JieqiArticleArticle> TopListPut() {
		List<JieqiArticleArticle> topList = jieqiArticleArticleMapper.topList();
		return topList;
	}

	@Cacheable(key = "#root.methodName", value = "index")
	@Override
	public List<JieqiArticleArticle> TopList() {
		List<JieqiArticleArticle> topList = jieqiArticleArticleMapper.topList();
		return topList;
	}

	@CachePut(key = "#root.methodName", value = "index")
	public Map<Integer, List<JieqiArticleArticle>> CategoryTopListPut() {
		Map<Integer, List<JieqiArticleArticle>> map = new HashMap<>();
		map.put(1, jieqiArticleArticleMapper.categoryTopList(1));
		map.put(2, jieqiArticleArticleMapper.categoryTopList(2));
		map.put(3, jieqiArticleArticleMapper.categoryTopList(3));
		map.put(4, jieqiArticleArticleMapper.categoryTopList(4));
		return map;
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

	@CachePut(key = "#chapterId", value = "chapterContent")
	public Map<String, Object> chapterContentPut(Integer articleId, Integer chapterId) throws IOException {
		String txtFile = Common.articleTxtFileFullPath(articleId, chapterId);
		String content = FileUtils.readFileToString(new File(txtFile), "GBK");
		content = content.replaceAll("\\r\\n\\r\\n", "<br/><br/>");
		content = content.replaceAll("\\r\\n", "<br/><br/>    ");
		content = content.replaceAll("<br />", "<br/>");
		content = content.replaceAll(" ", "&nbsp;");
		LinkedHashMap<String, Map<String, String>> chapters = this.chpaterList(articleId, true);
		Map<String, Object> chapter = new HashMap<>();
		chapter.put("content", content);
		chapter.put("chapterId", chapterId);
		String cid = Integer.toString(chapterId);
		chapter.put("chapterName", chapters.get(cid).get(cid));
		chapter.put("pre", chapters.get(cid).get("pre"));
		chapter.put("next", chapters.get(cid).get("next"));
		return chapter;
	}

	@Cacheable(key = "#chapterId+'_'+#index", value = "chapterContent")
	public Map<String, Object> chapterContent(Integer articleId, Integer chapterId, Integer index) throws IOException {
		String txtFile = Common.articleTxtFileFullPath(articleId, chapterId);
		String content = FileUtils.readFileToString(new File(txtFile), "GBK");
		content = content.trim();
		content = content.replaceAll("\\r\\n\\r\\n", "<br/><br/>");
		content = content.replaceAll("\\r\\n", "<br/><br/>    ");
		content = content.replaceAll("<br />", "<br/>");
		content = content.replaceAll("<p>", "<br/>");
		content = content.replaceAll("</p>", "<br/>");
		content = content.replaceAll(" ", "&nbsp;");
		String[] split = content.split("<br/>");
		Integer n = split.length / 2;
		String[] copyOfRange;

		LinkedHashMap<String, Map<String, String>> chapters = this.chpaterList(articleId, true);
		Map<String, Object> chapter = new HashMap<>();
		chapter.put("chapterId", chapterId);
		String cid = Integer.toString(chapterId);
		chapter.put("chapterName", chapters.get(cid).get(cid));
		chapter.put("pre", chapters.get(cid).get("pre"));
		String hasNextPage = "";
		if (index == 0 && content.length() > 500) {
			copyOfRange = Arrays.copyOfRange(split, n * index, n * (index + 1));
			chapter.put("next", String.valueOf(chapterId) + "_1");
			chapter.put("pre", chapters.get(cid).get("pre"));
			hasNextPage = "(1/2)本章未完，请继续阅读";
		} else {
			copyOfRange = Arrays.copyOfRange(split, n * index, split.length);
			chapter.put("next", chapters.get(cid).get("next"));
			if (content.length() > 500) {
				chapter.put("pre", String.valueOf(chapterId));
			} else {
				chapter.put("pre", chapters.get(cid).get("pre"));
			}
		}
		chapter.put("hasNextPage", hasNextPage);
		content = String.join("<br/>", copyOfRange);
		// if (index == 0) {
		// content = "&nbsp;&nbsp;&nbsp;&nbsp;一秒记住：m.ihxs.la 爱好小说 <br>" + content;
		// }
		chapter.put("content", content);
		return chapter;
	}

	@CachePut(key = "#articleId", value = "chpaterListTopN")
	public LinkedHashMap<String, Map<String, String>> chpaterListTopNPut(Integer articleId, Integer chpaterNum)
			throws IOException {
		String opfFile = Common.articleOpfFileFullPath(articleId);
		String content = FileUtils.readFileToString(new File(opfFile), "GBK");
		return Common.parseChapterList(chpaterNum, false, Common.opfDocumnet(content));
	}

	@Cacheable(key = "#articleId", value = "chpaterListTopN")
	public LinkedHashMap<String, Map<String, String>> chpaterListTopN(Integer articleId, Integer chpaterNum)
			throws IOException {
		String opfFile = Common.articleOpfFileFullPath(articleId);
		String content = FileUtils.readFileToString(new File(opfFile), "GBK");
		return Common.parseChapterList(chpaterNum, false, Common.opfDocumnet(content));
	}

	@CachePut(key = "#articleId", value = "chpaterList")
	public LinkedHashMap<String, Map<String, String>> chpaterListPut(Integer articleId, Boolean start)
			throws IOException {
		String opfFile = Common.articleOpfFileFullPath(articleId);
		String content = FileUtils.readFileToString(new File(opfFile), "GBK");
		return Common.parseChapterList(1000000, start, Common.opfDocumnet(content));
	}

	@Cacheable(key = "#articleId", value = "chpaterList")
	public LinkedHashMap<String, Map<String, String>> chpaterList(Integer articleId, Boolean start) throws IOException {
		String opfFile = Common.articleOpfFileFullPath(articleId);
		String content = FileUtils.readFileToString(new File(opfFile), "GBK");
		return Common.parseChapterList(1000000, start, Common.opfDocumnet(content));
	}

	@CachePut(key = "#articleId", value = "info")
	public JieqiArticleArticle infoPut(Integer articleId) {
		return findById(articleId);
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
		logger.info(String.format("搜索小说: %s", keyword));
		return jieqiArticleArticleMapper.search(keyword);
	}

	@Scheduled(cron = "0/20 * * * * ?")
	public void Events() {
		Common.TOP_ARTICLE = TopList();
	}

	@Scheduled(cron = "0 0 3 * * ?")
	public void updateVisit() {
		for (Map.Entry<Integer, Integer> entry : Common.VISIT.entrySet()) {
			if (entry.getValue() > 0) {
				jieqiArticleArticleMapper.updateVisit(entry.getKey(), entry.getValue());
				Common.VISIT.put(entry.getKey(), 0);
			}
		}
	}

	public void initSearchMap() {
		List<JieqiArticleArticle> list = findAll();
		Map<String, List<JieqiArticleArticle>> m = new HashMap<>();
		for (JieqiArticleArticle item : list) {
			buildKey(item.getArticlename(), m, item);
		}

		for (Map.Entry<String, List<JieqiArticleArticle>> item : m.entrySet()) {
			System.out.println(item.getKey());
		}
	}

	// def build_key(l):
	// for i, a in enumerate(list(l)):
	// ll = list(l[i + 1:])
	// m.append(a)
	// for j, b in enumerate(ll):
	// m.append(a + "".join(ll[0:len(ll) - j]))

	public void buildKey(String l, Map<String, List<JieqiArticleArticle>> m, JieqiArticleArticle item) {
		for (int i = 0; i < l.length(); i++) {
			String ll = l.substring(i + 1);
			String c = l.substring(i, i + 1);
			List<JieqiArticleArticle> list = m.get(c);
			if (CollectionUtils.isEmpty(list)) {
				list = new ArrayList<>();
			}
			list.add(item);
			for (int j = 0; j < ll.length(); j++) {
				List<JieqiArticleArticle> list2 = m.get(c + ll.substring(0, ll.length() - j));
				if (CollectionUtils.isEmpty(list2)) {
					list2 = new ArrayList<>();
				}
				list2.add(item);
			}
		}
	}

}
