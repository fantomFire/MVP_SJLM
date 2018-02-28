package com.zhss.sjlm.bean;

/**
 * Created by win7-64 on 2018/1/19.
 */

public class LoginBean {


        /**
         * id : 38
         * nicheng : 18192600365
         * mobile : 18192600365
         */

        private String id;
        private String nicheng;
        private String mobile;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNicheng() {
            return nicheng;
        }

        public void setNicheng(String nicheng) {
            this.nicheng = nicheng;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", nicheng='" + nicheng + '\'' +
                    ", mobile='" + mobile + '\'' +
                    '}';
        }
    }


