package com.zhss.sjlm.bean;

import java.util.List;

/**
 * Created by win7-64 on 2018/1/22.
 */

public class CategreyBean {

        private String class_id;
        private String class_name;
        private String class_image;
        private String class_parent_id;
        private List<ContentBean> content;

        public String getClass_id() {
            return class_id;
        }

        public void setClass_id(String class_id) {
            this.class_id = class_id;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public String getClass_image() {
            return class_image;
        }

        public void setClass_image(String class_image) {
            this.class_image = class_image;
        }

        public String getClass_parent_id() {
            return class_parent_id;
        }

        public void setClass_parent_id(String class_parent_id) {
            this.class_parent_id = class_parent_id;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public static class ContentBean {
            /**
             * class_id : 2
             * class_name : 园林酒店
             * class_parent_id : 1
             * content : []
             */

            private String class_id;
            private String class_name;
            private String class_parent_id;
            private List<?> content;

            public String getClass_id() {
                return class_id;
            }

            public void setClass_id(String class_id) {
                this.class_id = class_id;
            }

            public String getClass_name() {
                return class_name;
            }

            public void setClass_name(String class_name) {
                this.class_name = class_name;
            }

            public String getClass_parent_id() {
                return class_parent_id;
            }

            public void setClass_parent_id(String class_parent_id) {
                this.class_parent_id = class_parent_id;
            }

            public List<?> getContent() {
                return content;
            }

            public void setContent(List<?> content) {
                this.content = content;
            }
        }

    @Override
    public String toString() {
        return "CategreyBean{" +
                "class_id='" + class_id + '\'' +
                ", class_name='" + class_name + '\'' +
                ", class_image='" + class_image + '\'' +
                ", class_parent_id='" + class_parent_id + '\'' +
                ", content=" + content +
                '}';
    }
}

