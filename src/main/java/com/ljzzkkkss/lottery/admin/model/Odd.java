package com.ljzzkkkss.lottery.admin.model;

import java.io.Serializable;

public class Odd implements Serializable {
    private static final long serialVersionUID = -6862918345642963116L;

    private Long id;
    private Long matchId;
    private String category;
    private String rate;
    private String content;
    private Integer single;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSingle() {
        return single;
    }

    public void setSingle(Integer single) {
        this.single = single;
    }
}
