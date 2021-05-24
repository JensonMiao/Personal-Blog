package com.miaojingu.blog.article.mapper;

import com.miaojingu.blog.entities.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 文章信息表 Mapper 接口
 * </p>
 *
 * @author Jenson Miao
 * @since 2021-03-30
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 通过文章id查询文章详情及标签
     * @param id
     * @return
     */
    Article findArticleAndLabelById(String id);
}
