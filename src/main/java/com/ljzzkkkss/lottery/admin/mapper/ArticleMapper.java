package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    List<Article> getArticleListByPage(@Param("start")Integer start,@Param("pageSize")Integer pageSize);
    Integer getArticleCount();
    Article getArticleById(@Param("id")Integer id);
    void insertArticle(Article article);
    void updateArticleById(Article article);
    void deleteArticleById(@Param("id")Integer id);
}
