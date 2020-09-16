package com.ljzzkkkss.lottery.admin.model;

import java.util.List;
import java.util.Map;

public class RecommendParam {
    private Integer articleId;
    private String recommendGame;
    private List<Map<String,Object>> recommendList;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getRecommendGame() {
        return recommendGame;
    }

    public void setRecommendGame(String recommendGame) {
        this.recommendGame = recommendGame;
    }

    public List<Map<String, Object>> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<Map<String, Object>> recommendList) {
        this.recommendList = recommendList;
    }
}
