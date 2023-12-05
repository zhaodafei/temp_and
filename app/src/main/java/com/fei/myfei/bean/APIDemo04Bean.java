package com.fei.myfei.bean;

import java.util.List;

public class APIDemo04Bean {
    // 后端接口返回json格式为: {"error":10000,"msg":"1111111","data":[],"page_count":0}
    private Integer    error;
    private String    msg;
    private Integer    page_count;
    private List<String> data;

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getPage_count() {
        return page_count;
    }

    public void setPage_count(Integer page_count) {
        this.page_count = page_count;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "APIDemo04Bean{" +
                "error=" + error +
                ", msg='" + msg + '\'' +
                ", page_count=" + page_count +
                ", data=" + data +
                '}';
    }
}
