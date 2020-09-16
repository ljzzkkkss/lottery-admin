package com.ljzzkkkss.lottery.admin.service.impl;

import com.ljzzkkkss.lottery.admin.mapper.ArticleMapper;
import com.ljzzkkkss.lottery.admin.mapper.MatchMapper;
import com.ljzzkkkss.lottery.admin.mapper.OddMapper;
import com.ljzzkkkss.lottery.admin.mapper.RecommendMapper;
import com.ljzzkkkss.lottery.admin.model.*;
import com.ljzzkkkss.lottery.admin.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticelServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private MatchMapper matchMapper;
    @Resource
    private OddMapper oddMapper;
    @Resource
    private RecommendMapper recommendMapper;

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
    @Override
    public Map<String, Object> getMatchNotStartList(Integer articleId) {

        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> matchMapList = new ArrayList<>();
        Map<String,Object> recommendMap = new HashMap<>();
        Article article = articleMapper.getArticleById(articleId);
        recommendMap.put("recommendGame",article.getRecommendGame());
        List<Recommend> recommendList = recommendMapper.getRecommendListByArticleId(articleId);
        for(Recommend recommend : recommendList){
            recommendMap.put(recommend.getMatchId() + "-" + recommend.getContent(),1);
        }
        result.put("recommend",recommendMap);
        List<Match> matchList = matchMapper.getMatchListNotStart();
        for(Match match : matchList){
            List<Odd> oddList = oddMapper.getOddListByMatchId(match.getId());
            Map<String,List<Odd>> oddMap = new HashMap<>();
            Map<String,Object> matchMap = new HashMap<>();
            for(Odd odd : oddList){
                if(null == oddMap.get(odd.getCategory())){
                    oddMap.put(odd.getCategory(),new ArrayList<>());
                }
                oddMap.get(odd.getCategory()).add(odd);
            }
            matchMap.put("match",match);
            matchMap.put("oddList",oddMap);
            matchMapList.add(matchMap);
        }
        result.put("match",matchMapList);
        return result;
    }

    @Override
    @Transactional
    public void insertRecommend(RecommendParam recommendParam) {
        Article article = new Article();
        article.setId(recommendParam.getArticleId());
        article.setRecommendGame(recommendParam.getRecommendGame());
        if(null == recommendParam.getRecommendList() || recommendParam.getRecommendList().isEmpty()){
            article.setHasRecommend(0);
        }else{
            article.setHasRecommend(1);
        }
        articleMapper.updateArticleById(article);
        recommendMapper.deleteRecommendByArticleId(recommendParam.getArticleId());
        for(Recommend recommend : recommendParam.getRecommendList()){
            recommendMapper.insertRecommend(recommend);
        }
    }
}
