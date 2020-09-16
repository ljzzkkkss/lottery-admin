package com.ljzzkkkss.lottery.admin.model;

import java.util.List;

public class RecommendParam {
    private Integer articleId;
    private String recommendGame;
    private List<Recommend> recommendList;

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

    public List<Recommend> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<Recommend> recommendList) {
        this.recommendList = recommendList;
    }
}
