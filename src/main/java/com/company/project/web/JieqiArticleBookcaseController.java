package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.JieqiArticleBookcase;
import com.company.project.service.JieqiArticleBookcaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/09/10.
*/
@RestController
@RequestMapping("/jieqi/article/bookcase")
public class JieqiArticleBookcaseController {
    @Resource
    private JieqiArticleBookcaseService jieqiArticleBookcaseService;

    @PostMapping("/add")
    public Result add(JieqiArticleBookcase jieqiArticleBookcase) {
        jieqiArticleBookcaseService.save(jieqiArticleBookcase);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        jieqiArticleBookcaseService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(JieqiArticleBookcase jieqiArticleBookcase) {
        jieqiArticleBookcaseService.update(jieqiArticleBookcase);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        JieqiArticleBookcase jieqiArticleBookcase = jieqiArticleBookcaseService.findById(id);
        return ResultGenerator.genSuccessResult(jieqiArticleBookcase);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<JieqiArticleBookcase> list = jieqiArticleBookcaseService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
