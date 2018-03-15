package com.zhss.sjlm.bean;

/**
 * Created by 解晓辉  on 2017/6/4 13:54 *
 * QQ  ：811733738
 * 作用:
 */

public class BaseResult<T> {

    public static final String SUCCESS = "200";
    public static final String ERROR = "400";
    private String status;
    private String msg;
    private T data;


    public boolean isSuccess() {
        return (status.equals(SUCCESS));
    }


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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
