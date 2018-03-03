package com.zhss.sjlm.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zhss.sjlm.common.Contacts;

/**
 * Created by win7-64 on 2018/1/29.
 */

public class DiscoverBean implements MultiItemEntity {


    public int getStyle() {
        return Style;
    }

    public void setStyle(int style) {
        Style = style;
    }

    /**
         * store_name : gg
         * store_id : 1
         * store_image : http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png
         * live_store_address : 碑林区二环南路
         */
        private int Style;
        private String store_name;
        private String store_id;
        private String store_image;
        private String live_store_address;

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getStore_image() {
            return store_image;
        }

        public void setStore_image(String store_image) {
            this.store_image = store_image;
        }

        public String getLive_store_address() {
            return live_store_address;
        }

        public void setLive_store_address(String live_store_address) {
            this.live_store_address = live_store_address;
        }

    @Override
    public int getItemType() {
        switch (getStyle()){
            case 1:
                return Contacts.TYPE_DISCOVER_ONE_IMG;
            case 2:
                return Contacts.TYPE_DISCOVER_MULTI_IMG;
            default:
                return Contacts.TYPE_DISCOVER_ONE_IMG;
        }

    }
}
