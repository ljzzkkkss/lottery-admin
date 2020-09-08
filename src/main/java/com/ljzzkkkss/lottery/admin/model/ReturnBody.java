package com.ljzzkkkss.lottery.admin.model;

public class ReturnBody {
    private String code;
    private String message;
    private Object data;

    public ReturnBody(Object data){
        this.code = "0000";
        this.message = "操作成功";
        this.data = data;
    }

    public ReturnBody(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
