package com.miaojingu.blog.article.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.miaojingu.blog.article.req.LabelREQ;
import com.miaojingu.blog.entities.Label;
import com.miaojingu.blog.article.mapper.LabelMapper;
import com.miaojingu.blog.article.service.ILabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miaojingu.blog.util.base.Result;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author Jenson Miao
 * @since 2021-04-06
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements ILabelService {

    @Override
    public Result queryPage(LabelREQ req) {
        IPage<Label> iPage = baseMapper.queryPage(req.getPage(),req);
        return Result.ok(iPage);
    }

    @Override
    public boolean updateById(Label label) {
        //设置更新时间
        label.setUpdateDate(new Date());
        return super.updateById(label);
    }
}
