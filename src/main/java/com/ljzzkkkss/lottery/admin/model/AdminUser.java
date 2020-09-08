package com.ljzzkkkss.lottery.admin.model;

import java.io.Serializable;

public class AdminUser implements Serializable {
    private static final long serialVersionUID = 1146442421485029787L;
    private Integer id;
    private String username;
    private String password;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
