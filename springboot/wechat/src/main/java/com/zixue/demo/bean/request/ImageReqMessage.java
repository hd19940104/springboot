package com.zixue.demo.bean.request;

/**
 * @Author: Yun
 * @Description: 请求消息之图片消息
 * @Date: Created in 2017-11-29 11:06
 */
public class ImageReqMessage extends BaseReqMessage {
    // 图片链接
    private String PicUrl;
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

}