package com.example.bookpower.home.bean;

import java.util.List;

/**
 * 这个类用于解析json为bean对象，适用于home页
 */
public class ResultData {

    /**
     * code : 200
     * msg : 请求成功
     * result : {"act_info":[{"icon_url":"img/icon3.png","name":"图书专区","url":"html的路径"},{"icon_url":"img/icon3.png","name":"图书非专区","url":"html的路径"}],"banner_info":[{"icon_url":"img/icon_01.png","name":"图书专区","url":"html的路径"},{"icon_url":"img/icon_06.png","name":"图书专区","url":"html的路径"},{"icon_url":"img/icon3.png","name":"图书专区","url":"html的路径"}],"channel_info":[{"channel_name":"图书","image":"路径","option":2,"type":1,"value":{"channel_kl":"8"}}]}
     */

    private int code;
    private String msg;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<ActInfoBean> act_info;
        private List<BannerInfoBean> banner_info;
        private List<ChannelInfoBean> channel_info;

        public List<ActInfoBean> getAct_info() {
            return act_info;
        }

        public void setAct_info(List<ActInfoBean> act_info) {
            this.act_info = act_info;
        }

        public List<BannerInfoBean> getBanner_info() {
            return banner_info;
        }

        public void setBanner_info(List<BannerInfoBean> banner_info) {
            this.banner_info = banner_info;
        }

        public List<ChannelInfoBean> getChannel_info() {
            return channel_info;
        }

        public void setChannel_info(List<ChannelInfoBean> channel_info) {
            this.channel_info = channel_info;
        }

        public static class ActInfoBean {
            /**
             * icon_url : img/icon3.png
             * name : 图书专区
             * url : html的路径
             */

            private String icon_url;
            private String name;
            private String url;

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class BannerInfoBean {
            /**
             * icon_url : img/icon_01.png
             * name : 图书专区
             * url : html的路径
             */

            private String icon_url;
            private String name;
            private String url;

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ChannelInfoBean {
            /**
             * channel_name : 图书
             * image : 路径
             * option : 2
             * type : 1
             * value : {"channel_kl":"8"}
             */

            private String channel_name;
            private String image;
            private int option;
            private int type;
            private ValueBean value;

            public String getChannel_name() {
                return channel_name;
            }

            public void setChannel_name(String channel_name) {
                this.channel_name = channel_name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getOption() {
                return option;
            }

            public void setOption(int option) {
                this.option = option;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public ValueBean getValue() {
                return value;
            }

            public void setValue(ValueBean value) {
                this.value = value;
            }

            public static class ValueBean {
                /**
                 * channel_kl : 8
                 */

                private String channel_kl;

                public String getChannel_kl() {
                    return channel_kl;
                }

                public void setChannel_kl(String channel_kl) {
                    this.channel_kl = channel_kl;
                }
            }
        }
    }
}
