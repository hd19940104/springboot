package com.zixue.demo.enums;

import lombok.Getter;

/**
 * Description:
 * <p>
 * date: 2021/11/5 10:12 上午
 *
 * @author aidenhou@tencent.com
 * @version 1.0
 * @since JDK 1.8
 */
@Getter
public enum MessageEventEnum {

    /**
     * 事件类型：subscribe(订阅)
     */
    EVENT_TYPE_SUBSCRIBE("subscribe"),/**/
    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    EVENT_TYPE_UNSUBSCRIBE("unsubscribe"),
    /**
     * 事件类型：scan(用户已关注时的扫描带参数二维码)
     */
    EVENT_TYPE_SCAN("scan"),
    /**
     * 事件类型：LOCATION(上报地理位置)
     */
    EVENT_TYPE_LOCATION("LOCATION"),
    /**
     * 事件类型：CLICK(自定义菜单)
     */
    EVENT_TYPE_CLICK("CLICK"),

    ;

    private String value;

    MessageEventEnum(String value) {
        this.value = value;
    }
}
