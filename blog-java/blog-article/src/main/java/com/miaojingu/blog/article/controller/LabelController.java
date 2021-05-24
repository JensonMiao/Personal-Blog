package com.miaojingu.blog.article.controller;


import com.miaojingu.blog.article.req.LabelREQ;
import com.miaojingu.blog.article.service.ILabelService;
import com.miaojingu.blog.entities.Label;
import com.miaojingu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author Jenson Miao
 * @since 2021-04-06
 */
@Api(value = "标签管理接口",description="标签管理接口，提供标签的增删改查")
@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private ILabelService iLabelService;

    @ApiOperation("根据标签名称与分类id查询页面分页列表接口")
    @PostMapping("/search")
    public Result search(@RequestBody LabelREQ req){
        return iLabelService.queryPage(req);
    }

    @ApiImplicitParam(name="id",value = "标签id",required = true)
    @ApiOperation("查询标签详情接口")
    @GetMapping("/{id}")
    public Result view(@PathVariable String id){
        Label label = iLabelService.getById(id);
        return Result.ok(label);
    }

    @ApiOperation("修改标签信息接口")
    @PutMapping // put请求
    public Result update(@RequestBody Label label){
        iLabelService.updateById(label);
        return Result.ok();
    }

    @ApiOperation("新增标签信息接口")
    @PostMapping
    public Result save(@RequestBody Label label){
        iLabelService.save(label);
        return Result.ok();

    }

    @ApiImplicitParam(name="id",value = "标签id",required = true)
    @ApiOperation("删除标签信息接口")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){
        iLabelService.removeById(id);
        return Result.ok();
    }

}
