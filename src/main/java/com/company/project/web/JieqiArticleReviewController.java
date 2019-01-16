package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.JieqiArticleReview;
import com.company.project.service.JieqiArticleReviewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/01/15.
*/
@RestController
@RequestMapping("/jieqi/article/review")
public class JieqiArticleReviewController {
    @Resource
    private JieqiArticleReviewService jieqiArticleReviewService;

    @PostMapping("/add")
    public Result add(JieqiArticleReview jieqiArticleReview) {
        jieqiArticleReviewService.save(jieqiArticleReview);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        jieqiArticleReviewService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(JieqiArticleReview jieqiArticleReview) {
        jieqiArticleReviewService.update(jieqiArticleReview);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        JieqiArticleReview jieqiArticleReview = jieqiArticleReviewService.findById(id);
        return ResultGenerator.genSuccessResult(jieqiArticleReview);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<JieqiArticleReview> list = jieqiArticleReviewService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
