package com.zixue.demo.service;

import com.alibaba.fastjson.JSON;
import com.zixue.demo.bean.response.TextRespMessage;
import com.zixue.demo.contants.Contants;
import com.zixue.demo.dto.vo.MessageInfoVo;
import com.zixue.demo.enums.MessageEventEnum;
import com.zixue.demo.enums.MessageResponseEnum;
import com.zixue.demo.enums.MessageTypeEnum;
import com.zixue.demo.repository.MessageInfoRepository;
import com.zixue.demo.robot.service.TlRobotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Description:
 * <p>
 * date: 2021/11/5 10:34 上午
 *
 * @author aidenhou@tencent.com
 * @version 1.0
 * @since JDK 1.8
 */
@Service
@Slf4j
public class MessagehandlerService {
    @Autowired
    private MessageInfoRepository messageInfoRepository;

    /**
     * 解析请求内容
     *
     * @return
     */
    public TextRespMessage parseMessage(Map<String, String> requestMap) {
        // 默认返回的文本消息内容
        String respContent = Contants.NO;
        // 发送方帐号
        String fromUserName = requestMap.get("FromUserName");

        // 消息类型
        String msgType = requestMap.get("MsgType");
        // 消息内容
        String info = requestMap.get("Content");

        if ((MessageTypeEnum.REQ_MESSAGE_TYPE_TEXT.getValue().equals(msgType))) {
            respContent = TlRobotService.getTextResponse(fromUserName, info);
        } else if (MessageTypeEnum.REQ_MESSAGE_TYPE_IMAGE.getValue().equals(msgType)) {
            respContent = Contants.REQ_MESSAGE_TYPE_IMAGE;
        } else if (MessageTypeEnum.REQ_MESSAGE_TYPE_VOICE.getValue().equals(msgType)) {
            respContent = Contants.REQ_MESSAGE_TYPE_VOICE;
        } else if (MessageTypeEnum.REQ_MESSAGE_TYPE_VIDEO.getValue().equals(msgType)) {
            respContent = Contants.REQ_MESSAGE_TYPE_VIDEO;
        } else if (MessageTypeEnum.REQ_MESSAGE_TYPE_SHORTVIDEO.getValue().equals(msgType)) {
            respContent = Contants.REQ_MESSAGE_TYPE_SHORTVIDEO;
        } else if (MessageTypeEnum.REQ_MESSAGE_TYPE_LOCATION.getValue().equals(msgType)) {
            respContent = Contants.REQ_MESSAGE_TYPE_LOCATION;
        } else if (MessageTypeEnum.REQ_MESSAGE_TYPE_LINK.getValue().equals(msgType)) {
            respContent = Contants.REQ_MESSAGE_TYPE_LINK;
        } else if (MessageTypeEnum.REQ_MESSAGE_TYPE_EVENT.getValue().equals(msgType)) {
            // 事件类型
            String eventType = requestMap.get("Event");
            // 关注
            if (MessageEventEnum.EVENT_TYPE_SUBSCRIBE.getValue().equals(eventType)) {
                respContent = Contants.EVENT_TYPE_SUBSCRIBE;
            }
            // 取消关注
            else if (MessageEventEnum.EVENT_TYPE_UNSUBSCRIBE.getValue().equals(eventType)) {
                // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
            }
            // 扫描带参数二维码
            else if (MessageEventEnum.EVENT_TYPE_SCAN.getValue().equals(eventType)) {
                // TODO 处理扫描带参数二维码事件
            }
            // 上报地理位置
            else if (MessageEventEnum.EVENT_TYPE_LOCATION.getValue().equals(eventType)) {
                // TODO 处理上报地理位置事件
            }
            // 自定义菜单
            else if (MessageEventEnum.EVENT_TYPE_CLICK.getValue().equals(eventType)) {
                // TODO 处理菜单点击事件
            }
        }
        // 开发者微信号
        String toUserName = requestMap.get("ToUserName");
        String msgId = requestMap.get("MsgId");
        // 回复文本消息
        TextRespMessage textMessage = new TextRespMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(System.currentTimeMillis());
        textMessage.setMsgType(MessageResponseEnum.RESP_MESSAGE_TYPE_TEXT.getValue());
        textMessage.setContent(respContent);

        MessageInfoVo messageInfoVo = new MessageInfoVo();
        messageInfoVo.setCreator(fromUserName);
        messageInfoVo.setFromUserName(fromUserName);
        messageInfoVo.setMsgId(msgId);
        messageInfoVo.setMsgType(msgType);
        messageInfoVo.setRequest(info);
        messageInfoVo.setResponse(respContent);
        messageInfoVo.setStatus((byte) 1);
        messageInfoVo.setToUserName(toUserName);
        messageInfoVo.setUpdater(fromUserName);

        messageInfoRepository.saveMessageInfo(messageInfoVo);
        log.info("返回文本内容:{}", JSON.toJSONString(textMessage));
        return textMessage;
    }

}
