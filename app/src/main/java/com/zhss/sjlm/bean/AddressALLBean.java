package com.zhss.sjlm.bean;

import java.util.List;

/**
 * Created by win7-64 on 2018/3/15.
 */

public class AddressALLBean {

    /**
     * status : 200
     * data : {"address":[{"address_id":"5","uid":"38","true_name":"丽丽","area_info":"21312314","address":"32423d","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"6","uid":"38","true_name":"丽丽","area_info":"21312314","address":"32423d","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"7","uid":"38","true_name":"丽丽","area_info":"21312314","address":"32423d","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"8","uid":"38","true_name":"丽丽","area_info":"21312314","address":"32423d","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"12","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"13","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"14","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"15","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"16","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"17","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"18","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"19","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"20","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""}],"count":"13"}
     * msg : 返回数据
     */

    private String status;
    private DataBean data;
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * address : [{"address_id":"5","uid":"38","true_name":"丽丽","area_info":"21312314","address":"32423d","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"6","uid":"38","true_name":"丽丽","area_info":"21312314","address":"32423d","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"7","uid":"38","true_name":"丽丽","area_info":"21312314","address":"32423d","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"8","uid":"38","true_name":"丽丽","area_info":"21312314","address":"32423d","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"12","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"13","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"14","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"15","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"16","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"17","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"18","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"19","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""},{"address_id":"20","uid":"38","true_name":"丽丽","area_info":"北京市北京市昌平区","address":"咯哦哦么","tel_phone":"18192600365","is_default":"0","postcode":""}]
         * count : 13
         */

        private String count;
        private List<AddressBean> address;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<AddressBean> getAddress() {
            return address;
        }

        public void setAddress(List<AddressBean> address) {
            this.address = address;
        }

        public static class AddressBean {
            /**
             * address_id : 5
             * uid : 38
             * true_name : 丽丽
             * area_info : 21312314
             * address : 32423d
             * tel_phone : 18192600365
             * is_default : 0
             * postcode :
             */

            private String address_id;
            private String uid;
            private String true_name;
            private String area_info;
            private String address;
            private String tel_phone;
            private String is_default;
            private String postcode;

            public String getAddress_id() {
                return address_id;
            }

            public void setAddress_id(String address_id) {
                this.address_id = address_id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getTrue_name() {
                return true_name;
            }

            public void setTrue_name(String true_name) {
                this.true_name = true_name;
            }

            public String getArea_info() {
                return area_info;
            }

            public void setArea_info(String area_info) {
                this.area_info = area_info;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getTel_phone() {
                return tel_phone;
            }

            public void setTel_phone(String tel_phone) {
                this.tel_phone = tel_phone;
            }

            public String getIs_default() {
                return is_default;
            }

            public void setIs_default(String is_default) {
                this.is_default = is_default;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }
        }
    }
}
