package com.zixue.demo.robot.bean.request;

/**
 * @Description: 图灵机器人 基础请求实体类
 */
public class BaseReqMessage {
    private String key;
    private String info;
    private String userid;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
