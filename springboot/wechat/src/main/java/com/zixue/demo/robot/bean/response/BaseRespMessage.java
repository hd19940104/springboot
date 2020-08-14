package com.zixue.demo.robot.bean.response;

/**
 * @Author: Yun
 * @Description: 图灵 基础回复消息实体
 * @Date: Created in 2017-11-30 10:46
 */
public class BaseRespMessage {
    private String text;
    private Integer code;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
