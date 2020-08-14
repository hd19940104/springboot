package com.zixue.demo.bean.request;

/**
 * @Author: Yun
 * @Description: 请求消息之视频消息
 * @Date: Created in 2017-11-29 11:09
 */
public class VideoReqMessage extends BaseReqMessage {

    // 媒体ID
    private String MediaId;
    // 语音格式
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    public String getThumbMediaId() {
        return ThumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }



}
