package com.zhss.sjlm.bean;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/13.
 */

public class resulet {
    private String status;
    private String msg;

    public List<Data> getContent() {
        return content;
    }

    public void setContent(List<Data> content) {
        this.content = content;
    }

    private List<Data> content;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "resulet{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    private class Data {
        private String userid;
    }
}
