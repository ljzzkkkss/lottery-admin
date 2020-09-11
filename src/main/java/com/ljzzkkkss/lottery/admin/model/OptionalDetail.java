package com.ljzzkkkss.lottery.admin.model;

import java.io.Serializable;

public class OptionalDetail implements Serializable {
    private static final long serialVersionUID = 4434586851712540852L;

    private Integer id;
    private Long matchId;
    private Integer optionalId;
    private String category;
    private String rate;
    private String content;
    private Integer times;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Integer getOptionalId() {
        return optionalId;
    }

    public void setOptionalId(Integer optionalId) {
        this.optionalId = optionalId;
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

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
