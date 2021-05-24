package com.miaojingu.blog.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.miaojingu.blog.article.req.ArticleREQ;
import com.miaojingu.blog.entities.Article;
import com.miaojingu.blog.article.mapper.ArticleMapper;
import com.miaojingu.blog.article.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaojingu.blog.util.base.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章信息表 服务实现类
 * </p>
 *
 * @author Jenson Miao
 * @since 2021-03-30
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Override
    public Result queryPage(ArticleREQ req) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper();
        //标题
        if(StringUtils.isNotEmpty(req.getTitle())){
            queryWrapper.like("title",req.getTitle());
        }
        //状态
        if(req.getStatus() != null){
            queryWrapper.eq("status",req.getStatus());
        }
        queryWrapper.orderByDesc("update_date");
        IPage<Article> iPage = baseMapper.selectPage(req.getPage(),queryWrapper);
        return Result.ok(iPage);
    }

    @Override
    public Result findArticleAndLabelById(String id) {
        return Result.ok(baseMapper.findArticleAndLabelById(id));
    }
}
