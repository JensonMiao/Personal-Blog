package com.miaojingu.blog.article.service;

import com.miaojingu.blog.article.req.LabelREQ;
import com.miaojingu.blog.entities.Label;
import com.baomidou.mybatisplus.extension.service.IService;
import com.miaojingu.blog.util.base.Result;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author Jenson Miao
 * @since 2021-04-06
 */
public interface ILabelService extends IService<Label> {


    /**
     * 条件分页查询标签列表
     * @param req
     * @return
     */
    Result queryPage(LabelREQ req);

}
