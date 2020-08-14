package com.zixue.demo.bean.request;

/**
 * @Author: Yun
 * @Description: 请求消息之语音消息
 * @Date: Created in 2017-11-29 11:08
 */
public class VoiceReqMessage extends BaseReqMessage {

    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
