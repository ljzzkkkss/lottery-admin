package com.ljzzkkkss.lottery.admin.service.impl;

import com.ljzzkkkss.lottery.admin.mapper.ArticleMapper;
import com.ljzzkkkss.lottery.admin.model.Article;
import com.ljzzkkkss.lottery.admin.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticelServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Map<String, Object> getArticleListByPage(Integer pageIndex, Integer pageSize) {
        Integer start = pageSize * (pageIndex - 1);
        List<Article> dataList = articleMapper.getArticleListByPage(start,pageSize);
        Integer count = articleMapper.getArticleCount();
        Map<String,Object> result = new HashMap<>();
        result.put("data",dataList);
        result.put("itemsCount",count);
        return result;
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    @Override
    public void updateArticleById(Article article) {
        articleMapper.updateArticleById(article);
    }

    @Override
    public void deleteArticleById(Integer id) {
        articleMapper.deleteArticleById(id);
    }
}
