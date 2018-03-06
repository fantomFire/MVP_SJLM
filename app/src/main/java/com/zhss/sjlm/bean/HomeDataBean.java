package com.zhss.sjlm.bean;

import java.util.List;

/**
 * Created by win7-64 on 2018/2/1.
 */

public class HomeDataBean {


    /**
     * status : 200
     * msg : 请求数据成功
     * data : {"banner":[{"ba_url":"http://sjlm.test.zhonghuass.cn/admin/public/upload/Category/17-08-07/5987bff652353.jpg","ba_link":"1","ba_sort":"1"},{"ba_url":"http://sjlm.test.zhonghuass.cn/admin/public/upload/Category/17-08-07/5987d243309a2.jpg","ba_link":"1","ba_sort":"2"},{"ba_url":"http://sjlm.test.zhonghuass.cn/admin/public/upload/Category/17-08-07/59882482a3cc0.jpg","ba_link":"1","ba_sort":"3"}],"navtitile":[{"nav_title":"酒店住宿","nav_id":"1","nav_url":null},{"nav_title":"休闲娱乐","nav_id":"2","nav_url":null},{"nav_title":"美食店铺","nav_id":"3","nav_url":null},{"nav_title":"各类超市","nav_id":"4","nav_url":null},{"nav_title":"美容美发","nav_id":"5","nav_url":null},{"nav_title":"婚纱摄影","nav_id":"6","nav_url":null},{"nav_title":"游泳健身","nav_id":"7","nav_url":null}],"position1":{"rec_id":"1","title":"美食之旅","content":[{"store_id":"1","store_name":"gg","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"28"},{"store_id":"2","store_name":"store2","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"39"},{"store_id":"3","store_name":"store3","live_store_address":"碑林区3环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"109"},{"store_id":"4","store_name":"store4","live_store_address":"碑林区2环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"88"}]},"position2":{"rec_id":"2","title":"宜居易尚","content":[{"store_id":"1","store_name":"gg","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"28"},{"store_id":"2","store_name":"store2","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"39"},{"store_id":"3","store_name":"store3","live_store_address":"碑林区3环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"109"},{"store_id":"4","store_name":"store4","live_store_address":"碑林区2环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"88"}]},"position3":{"rec_id":"3","title":"盛世之美","content":[{"store_id":"2","store_name":"store2","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"39"},{"store_id":"3","store_name":"store3","live_store_address":"碑林区3环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"109"},{"store_id":"4","store_name":"store4","live_store_address":"碑林区2环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"88"},{"store_id":"5","store_name":"store5","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"66"}]}}
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
         * banner : [{"ba_url":"http://sjlm.test.zhonghuass.cn/admin/public/upload/Category/17-08-07/5987bff652353.jpg","ba_link":"1","ba_sort":"1"},{"ba_url":"http://sjlm.test.zhonghuass.cn/admin/public/upload/Category/17-08-07/5987d243309a2.jpg","ba_link":"1","ba_sort":"2"},{"ba_url":"http://sjlm.test.zhonghuass.cn/admin/public/upload/Category/17-08-07/59882482a3cc0.jpg","ba_link":"1","ba_sort":"3"}]
         * navtitile : [{"nav_title":"酒店住宿","nav_id":"1","nav_url":null},{"nav_title":"休闲娱乐","nav_id":"2","nav_url":null},{"nav_title":"美食店铺","nav_id":"3","nav_url":null},{"nav_title":"各类超市","nav_id":"4","nav_url":null},{"nav_title":"美容美发","nav_id":"5","nav_url":null},{"nav_title":"婚纱摄影","nav_id":"6","nav_url":null},{"nav_title":"游泳健身","nav_id":"7","nav_url":null}]
         * position1 : {"rec_id":"1","title":"美食之旅","content":[{"store_id":"1","store_name":"gg","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"28"},{"store_id":"2","store_name":"store2","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"39"},{"store_id":"3","store_name":"store3","live_store_address":"碑林区3环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"109"},{"store_id":"4","store_name":"store4","live_store_address":"碑林区2环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"88"}]}
         * position2 : {"rec_id":"2","title":"宜居易尚","content":[{"store_id":"1","store_name":"gg","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"28"},{"store_id":"2","store_name":"store2","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"39"},{"store_id":"3","store_name":"store3","live_store_address":"碑林区3环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"109"},{"store_id":"4","store_name":"store4","live_store_address":"碑林区2环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"88"}]}
         * position3 : {"rec_id":"3","title":"盛世之美","content":[{"store_id":"2","store_name":"store2","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"39"},{"store_id":"3","store_name":"store3","live_store_address":"碑林区3环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"109"},{"store_id":"4","store_name":"store4","live_store_address":"碑林区2环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"88"},{"store_id":"5","store_name":"store5","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"66"}]}
         */

        private Position1Bean position1;
        private Position2Bean position2;
        private Position3Bean position3;
        private List<BannerBean> banner;
        private List<NavtitileBean> navtitile;

        public Position1Bean getPosition1() {
            return position1;
        }

        public void setPosition1(Position1Bean position1) {
            this.position1 = position1;
        }

        public Position2Bean getPosition2() {
            return position2;
        }

        public void setPosition2(Position2Bean position2) {
            this.position2 = position2;
        }

        public Position3Bean getPosition3() {
            return position3;
        }

        public void setPosition3(Position3Bean position3) {
            this.position3 = position3;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<NavtitileBean> getNavtitile() {
            return navtitile;
        }

        public void setNavtitile(List<NavtitileBean> navtitile) {
            this.navtitile = navtitile;
        }

        public static class Position1Bean {
            /**
             * rec_id : 1
             * title : 美食之旅
             * content : [{"store_id":"1","store_name":"gg","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"28"},{"store_id":"2","store_name":"store2","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"39"},{"store_id":"3","store_name":"store3","live_store_address":"碑林区3环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"109"},{"store_id":"4","store_name":"store4","live_store_address":"碑林区2环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"88"}]
             */

            private String rec_id;
            private String title;
            private List<ContentBean> content;

            public String getRec_id() {
                return rec_id;
            }

            public void setRec_id(String rec_id) {
                this.rec_id = rec_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ContentBean> getContent() {
                return content;
            }

            public void setContent(List<ContentBean> content) {
                this.content = content;
            }

            public static class ContentBean {
                /**
                 * store_id : 1
                 * store_name : gg
                 * live_store_address : 碑林区二环南路
                 * store_image : http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png
                 * consume : 28
                 */

                private String store_id;
                private String store_name;
                private String live_store_address;
                private String store_image;
                private String consume;

                public String getStore_id() {
                    return store_id;
                }

                public void setStore_id(String store_id) {
                    this.store_id = store_id;
                }

                public String getStore_name() {
                    return store_name;
                }

                public void setStore_name(String store_name) {
                    this.store_name = store_name;
                }

                public String getLive_store_address() {
                    return live_store_address;
                }

                public void setLive_store_address(String live_store_address) {
                    this.live_store_address = live_store_address;
                }

                public String getStore_image() {
                    return store_image;
                }

                public void setStore_image(String store_image) {
                    this.store_image = store_image;
                }

                public String getConsume() {
                    return consume;
                }

                public void setConsume(String consume) {
                    this.consume = consume;
                }
            }
        }

        public static class Position2Bean {
            /**
             * rec_id : 2
             * title : 宜居易尚
             * content : [{"store_id":"1","store_name":"gg","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"28"},{"store_id":"2","store_name":"store2","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"39"},{"store_id":"3","store_name":"store3","live_store_address":"碑林区3环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"109"},{"store_id":"4","store_name":"store4","live_store_address":"碑林区2环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"88"}]
             */

            private String rec_id;
            private String title;
            private List<ContentBeanX> content;

            public String getRec_id() {
                return rec_id;
            }

            public void setRec_id(String rec_id) {
                this.rec_id = rec_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ContentBeanX> getContentX() {
                return content;
            }

            public void setContentX(List<ContentBeanX> content) {
                this.content = content;
            }

            public static class ContentBeanX {
                /**
                 * store_id : 1
                 * store_name : gg
                 * live_store_address : 碑林区二环南路
                 * store_image : http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png
                 * consume : 28
                 */

                private String store_id;
                private String store_name;
                private String live_store_address;
                private String store_image;
                private String consume;

                public String getStore_id() {
                    return store_id;
                }

                public void setStore_id(String store_id) {
                    this.store_id = store_id;
                }

                public String getStore_name() {
                    return store_name;
                }

                public void setStore_name(String store_name) {
                    this.store_name = store_name;
                }

                public String getLive_store_address() {
                    return live_store_address;
                }

                public void setLive_store_address(String live_store_address) {
                    this.live_store_address = live_store_address;
                }

                public String getStore_image() {
                    return store_image;
                }

                public void setStore_image(String store_image) {
                    this.store_image = store_image;
                }

                public String getConsume() {
                    return consume;
                }

                public void setConsume(String consume) {
                    this.consume = consume;
                }
            }
        }

        public static class Position3Bean {
            /**
             * rec_id : 3
             * title : 盛世之美
             * content : [{"store_id":"2","store_name":"store2","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"39"},{"store_id":"3","store_name":"store3","live_store_address":"碑林区3环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"109"},{"store_id":"4","store_name":"store4","live_store_address":"碑林区2环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"88"},{"store_id":"5","store_name":"store5","live_store_address":"碑林区二环南路","store_image":"http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png","consume":"66"}]
             */

            private String rec_id;
            private String title;
            private List<ContentBeanXX> content;

            public String getRec_id() {
                return rec_id;
            }

            public void setRec_id(String rec_id) {
                this.rec_id = rec_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ContentBeanXX> getContentXX() {
                return content;
            }

            public void setContentXX(List<ContentBeanXX> content) {
                this.content = content;
            }

            public static class ContentBeanXX {
                /**
                 * store_id : 2
                 * store_name : store2
                 * live_store_address : 碑林区二环南路
                 * store_image : http://sjlm.test.zhonghuass.cn/Api/public/image/store/chuang.png
                 * consume : 39
                 */

                private String store_id;
                private String store_name;
                private String live_store_address;
                private String store_image;
                private String consume;

                public String getStore_id() {
                    return store_id;
                }

                public void setStore_id(String store_id) {
                    this.store_id = store_id;
                }

                public String getStore_name() {
                    return store_name;
                }

                public void setStore_name(String store_name) {
                    this.store_name = store_name;
                }

                public String getLive_store_address() {
                    return live_store_address;
                }

                public void setLive_store_address(String live_store_address) {
                    this.live_store_address = live_store_address;
                }

                public String getStore_image() {
                    return store_image;
                }

                public void setStore_image(String store_image) {
                    this.store_image = store_image;
                }

                public String getConsume() {
                    return consume;
                }

                public void setConsume(String consume) {
                    this.consume = consume;
                }
            }
        }

        public static class BannerBean {
            /**
             * ba_url : http://sjlm.test.zhonghuass.cn/admin/public/upload/Category/17-08-07/5987bff652353.jpg
             * ba_link : 1
             * ba_sort : 1
             */

            private String ba_url;
            private String ba_link;
            private String ba_sort;

            public String getBa_url() {
                return ba_url;
            }

            public void setBa_url(String ba_url) {
                this.ba_url = ba_url;
            }

            public String getBa_link() {
                return ba_link;
            }

            public void setBa_link(String ba_link) {
                this.ba_link = ba_link;
            }

            public String getBa_sort() {
                return ba_sort;
            }

            public void setBa_sort(String ba_sort) {
                this.ba_sort = ba_sort;
            }
        }

        public static class NavtitileBean {
            /**
             * nav_title : 酒店住宿
             * nav_id : 1
             * nav_url : null
             */

            private String nav_title;
            private String nav_id;
            private Object nav_url;

            public String getNav_title() {
                return nav_title;
            }

            public void setNav_title(String nav_title) {
                this.nav_title = nav_title;
            }

            public String getNav_id() {
                return nav_id;
            }

            public void setNav_id(String nav_id) {
                this.nav_id = nav_id;
            }

            public Object getNav_url() {
                return nav_url;
            }

            public void setNav_url(Object nav_url) {
                this.nav_url = nav_url;
            }
        }
    }
}
