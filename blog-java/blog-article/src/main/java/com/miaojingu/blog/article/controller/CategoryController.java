package com.miaojingu.blog.article.controller;


import com.miaojingu.blog.article.req.CategoryREQ;
import com.miaojingu.blog.article.service.ICategoryService;
import com.miaojingu.blog.entities.Category;
import com.miaojingu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文章分类表 前端控制器
 * </p>
 *
 * @author Jenson Miao
 * @since 2021-03-30
 */
@Api(value = "分类管理接口", description = "分类管理接口，提供分类的增删改查") //Swagger
@RestController //所有方法都会返回json字符串进行响应
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    /**
     * 分页条件查询分类信息
     *
     * @param req
     * @return
     */
    @ApiOperation("根据分类名称与状态查询分类列表接口") //Swagger对接口的介绍
    @PostMapping("/search") //请求路径： /category/search
    public Result search(@RequestBody CategoryREQ req) {

        return iCategoryService.queryPage(req);
    }

    @ApiOperation("查询类别详情接口")
    @ApiImplicitParam(name = "id", value = "类别id", required = true) // 在swagger中对参数做出解释
    @GetMapping("/{id}") // /category/{id}
    public Result view(@PathVariable("id") String id) {
        Category category = iCategoryService.getById(id);// getById方法是Mybatis-plus中提供的
        return Result.ok(category);
    }

    @ApiOperation("修改类别信息接口")
    @PutMapping // put方式 接口名：/category
    public Result update(@RequestBody Category category) {
        iCategoryService.updateById(category);
        return Result.ok();
    }

    @ApiOperation("新增类别信息接口")
    @PostMapping // post方式 接口名：/category
    public Result save(@RequestBody Category category){
        iCategoryService.save(category);
        return Result.ok();
    }

    @ApiOperation("删除分类")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id){
        iCategoryService.removeById(id);
        return Result.ok();
    }

    @ApiOperation("获取所有正常状态的分类接口")
    @GetMapping("/list") // 请求 /category/list
    public Result list(){
        return iCategoryService.findAllNormal();
    }

    @ApiOperation("查询正常状态的分类及分类下的所有标签接口")
    @GetMapping("/label/list") // localhost:8001/article/category/label/list
    public Result findCategoryAndLabel() {
        return iCategoryService.findCategoryAndLabel();
    }
}
