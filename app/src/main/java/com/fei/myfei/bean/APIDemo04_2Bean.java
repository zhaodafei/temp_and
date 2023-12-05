package com.fei.myfei.bean;

import java.util.List;

public class APIDemo04_2Bean {
    // 用网站: https://message.bilibili.com/api/tooltip/query.list.do 做api请求的demo
    // 后端接口返回json格式为: { "code": 0, "msg": "ok", "message": "ok", "data": [] }
    private Integer    code;
    private String    msg;
    private String    message;
    private List<String> data;

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getData() {
        return this.data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "APIDemo04_2Bean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
