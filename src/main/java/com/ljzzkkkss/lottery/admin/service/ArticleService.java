package com.ljzzkkkss.lottery.admin.service;

import com.ljzzkkkss.lottery.admin.model.Article;
import com.ljzzkkkss.lottery.admin.model.Recommend;
import com.ljzzkkkss.lottery.admin.model.RecommendParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    Map<String,Object> getArticleListByPage(Integer pageIndex, Integer pageSize);
    Article getArticleById(Integer id);
    void insertArticle(Article article);
    void updateArticleById(Article article);
    void deleteArticleById(Integer id);
    Map<String, Object> getMatchNotStartList(Integer articleId);
    void insertRecommend(RecommendParam recommendParam);
}
