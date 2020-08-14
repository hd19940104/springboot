package com.zixue.demo.bean.button;

import java.util.List;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-11-29 15:32
 */
public class Button {

    private String name;//菜单标题
    private String type;//菜单响应动作类型
    private String key;//菜单key值,用于消息接口推送
    private String url;//菜单链接
    private String media_id;
    private List<Button> sub_button;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public List<Button> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Button> sub_button) {
        this.sub_button = sub_button;
    }
}
