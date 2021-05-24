package com.miaojingu.blog.article.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.miaojingu.blog.article.req.LabelREQ;
import com.miaojingu.blog.entities.Label;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 标签表 Mapper 接口
 * </p>
 *
 * @author Jenson Miao
 * @since 2021-04-06
 */
public interface LabelMapper extends BaseMapper<Label> {

    /**
     * 如果自定义sql要分页查询，只要在Mapper中写不带分页功能的查询语句，mybatis-plus会自动将sql分页
     * 第1个参数必须传入分页对象 Page， 第2个参数是查询条件的参数
     * 最终将会查询到的数据封装到IPage实现类中
     * @return
     */
    IPage<Label> queryPage(IPage<Label> page,@Param("req") LabelREQ req);
}
