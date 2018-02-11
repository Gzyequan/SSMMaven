package com.yequan.type;

import com.yequan.model.User;

import java.util.List;

public class ResultUser {
    private int code;//1：获取成功；0：没有数据；
    private String reason;
    private List<User> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
