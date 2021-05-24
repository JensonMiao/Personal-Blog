package com.miaojingu.blog.article.service;

import com.miaojingu.blog.article.req.ArticleREQ;
import com.miaojingu.blog.entities.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.miaojingu.blog.util.base.Result;

/**
 * <p>
 * 文章信息表 服务类
 * </p>
 *
 * @author Jenson Miao
 * @since 2021-03-30
 */
public interface IArticleService extends IService<Article> {

    /**
     * 条件分页查询文章列表
     * @param req
     * @return
     */
    Result queryPage(ArticleREQ req);

    /**
     * 通过文章id查询文章详情及标签
     * @param id
     * @return
     */
    Result findArticleAndLabelById(String id);
}
