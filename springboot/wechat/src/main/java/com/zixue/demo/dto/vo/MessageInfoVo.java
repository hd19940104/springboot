package com.zixue.demo.dto.vo;

import lombok.Data;

import java.util.Date;

/**
 * Description:
 * <p>
 * date: 2021/11/5 11:18 上午
 *
 * @author aidenhou@tencent.com
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class MessageInfoVo {
    private Integer id;

    private String msgType;

    private String fromUserName;

    private String toUserName;

    private String response;

    private String request;

    private String msgId;

    private Byte status;

    private String creator;

    private String updater;
}
