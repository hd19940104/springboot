package com.zixue.demo.enums;

import lombok.Getter;

/**
 * Description:
 * <p>
 * date: 2021/11/5 10:05 上午
 *
 * @author aidenhou@tencent.com
 * @version 1.0
 * @since JDK 1.8
 */
@Getter
public enum MessageTypeEnum {
    /**
     * 请求消息类型：文本
     */
    REQ_MESSAGE_TYPE_TEXT("text"),
    /**
     * 请求消息类型：图片
     */
    REQ_MESSAGE_TYPE_IMAGE("image"),
    /**
     * 请求消息类型：语音
     */
    REQ_MESSAGE_TYPE_VOICE("voice"),
    /**
     * 请求消息类型：视频
     */
    REQ_MESSAGE_TYPE_VIDEO("video"),
    /**
     * 请求消息类型：小视频
     */
    REQ_MESSAGE_TYPE_SHORTVIDEO("shortvideo"),
    /**
     * 请求消息类型：地理位置
     */
    REQ_MESSAGE_TYPE_LOCATION("location"),
    /**
     * 请求消息类型：链接
     */
    REQ_MESSAGE_TYPE_LINK("link"),
    /**
     * 请求消息类型：事件推送
     */
    REQ_MESSAGE_TYPE_EVENT("event"),
    ;
    private String value;

    MessageTypeEnum(String value) {
        this.value = value;
    }


}
