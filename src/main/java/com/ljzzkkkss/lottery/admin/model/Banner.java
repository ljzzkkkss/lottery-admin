package com.ljzzkkkss.lottery.admin.model;

import java.io.Serializable;

public class Banner implements Serializable {
    private static final long serialVersionUID = -7564061990700141516L;

    private Integer id;
    private String img;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
