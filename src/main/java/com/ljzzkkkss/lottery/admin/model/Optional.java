package com.ljzzkkkss.lottery.admin.model;

import java.io.Serializable;

public class Optional implements Serializable {
    private static final long serialVersionUID = 7201201657467771832L;

    private Integer id;
    private Integer userId;
    private String lotteryImg;
    private String lotteryImg2;
    private Integer status;
    private String name;
    private String cost;
    private Integer times;
    private String game;
    private Integer noteNumber;
    private String optionDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLotteryImg() {
        return lotteryImg;
    }

    public void setLotteryImg(String lotteryImg) {
        this.lotteryImg = lotteryImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptionDate() {
        return optionDate;
    }

    public void setOptionDate(String optionDate) {
        this.optionDate = optionDate;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Integer getNoteNumber() {
        return noteNumber;
    }

    public void setNoteNumber(Integer noteNumber) {
        this.noteNumber = noteNumber;
    }

    public String getLotteryImg2() {
        return lotteryImg2;
    }

    public void setLotteryImg2(String lotteryImg2) {
        this.lotteryImg2 = lotteryImg2;
    }
}
