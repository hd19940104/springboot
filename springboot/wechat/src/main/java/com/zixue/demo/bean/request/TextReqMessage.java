package com.zixue.demo.bean.request;

/**
 * @Author: Yun
 * @Description: 请求消息之文本消息
 * @Date: Created in 2017-11-29 11:03
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