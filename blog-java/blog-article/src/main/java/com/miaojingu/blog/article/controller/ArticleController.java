package com.miaojingu.blog.article.controller;


import com.miaojingu.blog.article.req.ArticleREQ;
import com.miaojingu.blog.article.service.IArticleService;
import com.miaojingu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文章信息表 前端控制器
 * </p>
 *
 * @author Jenson Miao
 * @since 2021-03-30
 */
@Api(value = "文章管理接口",description = "文章管理接口，提供文章的增删改查")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private IArticleService iArticleService;


    @ApiOperation("根据文章标题和状态查询文章分页列表接口")
    @PostMapping("/search")
    public Result search(@RequestBody ArticleREQ req) {
        return iArticleService.queryPage(req);
    }

    @ApiOperation("查询文章详情接口")
    @ApiImplicitParam(name = "id",value = "文章ID",required = true)
    @GetMapping("/{id}")
    public Result view(@PathVariable String id){
        return iArticleService.findArticleAndLabelById(id);
    }
}
