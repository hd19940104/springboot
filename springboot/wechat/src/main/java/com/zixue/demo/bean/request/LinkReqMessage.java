package com.zixue.demo.bean.request;

/**
 * @Author: Yun
 * @Description: 请求消息之链接消息
 * @Date: Created in 2017-11-29 11:11
 */
public class LinkReqMessage extends BaseReqMessage {

    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
