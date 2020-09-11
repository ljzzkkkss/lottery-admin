package com.ljzzkkkss.lottery.admin.service;

import com.ljzzkkkss.lottery.admin.model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService {
    List<Article> getArticleListByPage(Integer pageIndex, Integer pageSize);
    Article getArticleById(Integer id);
    void insertArticle(Article article);
    void updateArticleById(Article article);
    void deleteArticleById(Integer id);
}
