package com.zixue.demo.bean.response;

/**
 * @Author: Yun
 * @Description: 响应消息之文本响应消息
 * @Date: Created in 2017-11-29 11:23
 */
public class TextRespMessage extends BaseRespMessage{
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
