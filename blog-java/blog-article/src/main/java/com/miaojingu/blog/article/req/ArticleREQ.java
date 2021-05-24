package com.miaojingu.blog.article.req;

import com.miaojingu.blog.entities.Article;
import com.miaojingu.blog.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "ArticleREQ对象",description = "文章查询条件")
public class ArticleREQ extends BaseRequest<Article> {

    @ApiModelProperty(value = "文章标题")
    private String title;
    @ApiModelProperty(value = "状态")
    private Integer status;
}
