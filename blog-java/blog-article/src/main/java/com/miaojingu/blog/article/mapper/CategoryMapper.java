package com.miaojingu.blog.article.mapper;

import com.miaojingu.blog.entities.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 文章分类表 Mapper 接口
 * </p>
 *
 * @author Jenson Miao
 * @since 2021-03-30
 */
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查询正常状态的分类及分类下的所有标签
     * @return
     */
    List<Category> findCategoryAndLabel();

}
