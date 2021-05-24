package com.miaojingu.blog.article.api;

import com.miaojingu.blog.article.service.IArticleService;
import com.miaojingu.blog.util.base.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
public class ApiArticleController {

    @Autowired
    private IArticleService iArticleService;

    @ApiOperation("查询文章详情接口")
    @ApiImplicitParam(name = "id",value = "文章ID",required = true)
    @GetMapping("/{id}")
    public Result view(@PathVariable String id){
        return iArticleService.findArticleAndLabelById(id);
    }
}
