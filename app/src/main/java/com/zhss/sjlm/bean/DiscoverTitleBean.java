package com.zhss.sjlm.bean;

import java.util.List;

/**
 * Created by win7-64 on 2018/1/29.
 */

public class DiscoverTitleBean {

    /**
     * status : 200
     * msg : succ
     * data : [{"find_id":"1","find_name":"美食之旅"},{"find_id":"2","find_name":"异域风情"},{"find_id":"3","find_name":"大美之美"},{"find_id":"4","find_name":"城市特色"}]
     */

    private int status;
    private String msg;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * find_id : 1
         * find_name : 美食之旅
         */

        private String find_id;
        private String find_name;

        public String getFind_id() {
            return find_id;
        }

        public void setFind_id(String find_id) {
            this.find_id = find_id;
        }

        public String getFind_name() {
            return find_name;
        }

        public void setFind_name(String find_name) {
            this.find_name = find_name;
        }
    }

    @Override
    public String toString() {
        return "DiscoverTitleBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
