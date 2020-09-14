package com.ljzzkkkss.lottery.admin.model;

import java.io.Serializable;

public class Match implements Serializable {
    private static final long serialVersionUID = -3066329975304077394L;

    private Long id;
    private String mainTeam;
    private String clientTeam;
    private String halfScore;
    private String totalScore;
    private String match;
    private String round;
    private String matchTime;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainTeam() {
        return mainTeam;
    }

    public void setMainTeam(String mainTeam) {
        this.mainTeam = mainTeam;
    }

    public String getClientTeam() {
        return clientTeam;
    }

    public void setClientTeam(String clientTeam) {
        this.clientTeam = clientTeam;
    }

    public String getHalfScore() {
        return halfScore;
    }

    public void setHalfScore(String halfScore) {
        this.halfScore = halfScore;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
