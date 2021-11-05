package com.zixue.demo.enums;

/**
 * Description:
 * <p>
 * date: 2021/11/5 10:15 上午
 *
 * @author aidenhou@tencent.com
 * @version 1.0
 * @since JDK 1.8
 */
public enum MessageResponseEnum {


    /**
     * 响应消息类型：文本
     */
    RESP_MESSAGE_TYPE_TEXT("text"),
    /**
     * 响应消息类型：图片
     */
    RESP_MESSAGE_TYPE_IMAGE("image"),
    /**
     * 响应消息类型：语音
     */
    RESP_MESSAGE_TYPE_VOICE("voice"),
    /**
     * 响应消息类型：视频
     */
    RESP_MESSAGE_TYPE_VIDEO("video"),
    /**
     * 响应消息类型：音乐
     */
    RESP_MESSAGE_TYPE_MUSIC("music"),
    /**
     * 响应消息类型：图文
     */
    RESP_MESSAGE_TYPE_NEWS("news"),

    ;
    private String value;

    MessageResponseEnum(String value) {
        this.value = value;
    }
}
