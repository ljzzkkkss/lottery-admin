package com.ljzzkkkss.lottery.admin.model;

import java.io.Serializable;

public class Log implements Serializable {
    private static final long serialVersionUID = -6217993592126281385L;

    private Long id;
    private String content;
    private String phone;
    private String logTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }
}
