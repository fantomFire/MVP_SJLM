package com.zhss.sjlm.bean;

/**
 * Created by win7-64 on 2018/3/7.
 */

public class MineInfoBean {

    /**
     * status : 200
     * msg : 用户信息
     * data : {"uid":"38","avatar":"","money":"0.00","identity_pic":"","identity_card":"","sex":"男","birthday":"1970-01-01","nickname":"","is_identity":"0","truename":"","introduction":"","phone":"","addr":""}
     */

    private String status;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 38
         * avatar :
         * money : 0.00
         * identity_pic :
         * identity_card :
         * sex : 男
         * birthday : 1970-01-01
         * nickname :
         * is_identity : 0
         * truename :
         * introduction :
         * phone :
         * addr :
         */

        private String uid;
        private String avatar;
        private String money;
        private String identity_pic;
        private String identity_card;
        private String sex;
        private String birthday;
        private String nickname;
        private String is_identity;
        private String truename;
        private String introduction;
        private String phone;
        private String addr;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getIdentity_pic() {
            return identity_pic;
        }

        public void setIdentity_pic(String identity_pic) {
            this.identity_pic = identity_pic;
        }

        public String getIdentity_card() {
            return identity_card;
        }

        public void setIdentity_card(String identity_card) {
            this.identity_card = identity_card;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getIs_identity() {
            return is_identity;
        }

        public void setIs_identity(String is_identity) {
            this.is_identity = is_identity;
        }

        public String getTruename() {
            return truename;
        }

        public void setTruename(String truename) {
            this.truename = truename;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }
    }
}
