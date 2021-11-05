package com.zixue.demo.bean.request;

/**
 * @Description: 请求消息之文本消息
 */
public class TextReqMessage extends BaseReqMessage {

    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}