package com.miaojingu.blog.article.api;

import com.miaojingu.blog.article.service.ICategoryService;
import com.miaojingu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 此控制层接口不需要通过身份认证就可以请求调用
 */
@Api(value = "分类管理接口", description = "分类管理接口，不需要通过身份认证") //Swagger
@RestController //所有方法都会返回json字符串进行响应
@RequestMapping("/api/category")
public class ApiCategoryController {

    @Autowired
    private ICategoryService iCategoryService;


    @ApiOperation("获取所有正常状态的分类-公开API接口")
    @GetMapping("/list") // 请求 /category/list
    public Result list(){
        return iCategoryService.findAllNormal();
    }

    @ApiOperation("查询正常状态的分类及分类下的所有标签-公开API接口")
    @GetMapping("/label/list") // localhost:8001/article/category/label/list
    public Result findCategoryAndLabel() {
        return iCategoryService.findCategoryAndLabel();
    }
}
