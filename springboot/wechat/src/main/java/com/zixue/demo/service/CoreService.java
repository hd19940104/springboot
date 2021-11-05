package com.zixue.demo.service;

import com.zixue.demo.bean.response.TextRespMessage;
import com.zixue.demo.robot.service.TlRobotService;
import com.zixue.demo.util.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: Yun
 * @Description:
 * @Date: Created in 2017-11-29 14:24
 */
@Service
public class CoreService {


    Logger logger=LoggerFactory.getLogger(CoreService.class);
    public String process(HttpServletRequest request){
        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "未知的消息类型！";
        try {
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtils.parseXml(request);

            logger.info("接收微信推送消息{}",requestMap.toString());
            // 发送方帐号
            String fromUserName = requestMap.get("FromUserName");
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");
            // 消息内容
            String info=requestMap.get("Content");
            String msgId=requestMap.get("MsgId");;
            // 回复文本消息
            TextRespMessage textMessage = new TextRespMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(System.currentTimeMillis());
            textMessage.setMsgType(MessageUtils.RESP_MESSAGE_TYPE_TEXT);

            // 文本消息
            if (msgType.equals(MessageUtils.REQ_MESSAGE_TYPE_TEXT)) {
                respContent= TlRobotService.getTextResponse(fromUserName,info);
            }
            // 图片消息
            else if (msgType.equals(MessageUtils.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息,小猴儿还不知道怎么回答嘛。。。";
            }
            // 语音消息
            else if (msgType.equals(MessageUtils.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是语音消息,小猴儿还不知道怎么回答嘛。。。";
            }
            // 视频消息
            else if (msgType.equals(MessageUtils.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "您发送的是视频消息,小猴儿还不知道怎么回答嘛。。。";
            }
            // 视频消息
            else if (msgType.equals(MessageUtils.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
                respContent = "您发送的是小视频消息,小猴儿还不知道怎么回答嘛。。。";
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtils.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息,小猴儿还不知道怎么回答嘛。。。";
            }
            // 链接消息
            else if (msgType.equals(MessageUtils.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息,小猴儿还不知道怎么回答嘛。。。";
            }
            // 事件推送
            else if (msgType.equals(MessageUtils.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 关注
                if (eventType.equals(MessageUtils.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "欢迎关注机器人小猴儿。。。。";
                }
                // 取消关注
                else if (eventType.equals(MessageUtils.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
                }
                // 扫描带参数二维码
                else if (eventType.equals(MessageUtils.EVENT_TYPE_SCAN)) {
                    // TODO 处理扫描带参数二维码事件
                }
                // 上报地理位置
                else if (eventType.equals(MessageUtils.EVENT_TYPE_LOCATION)) {
                    // TODO 处理上报地理位置事件
                }
                // 自定义菜单
                else if (eventType.equals(MessageUtils.EVENT_TYPE_CLICK)) {
                    // TODO 处理菜单点击事件
                }
            }
            // 设置文本消息的内容
            textMessage.setContent(respContent);
            // 将文本消息对象转换成xml
            respXml = MessageUtils.messageToXml(textMessage);
            logger.info("返回消息{}",respXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

}
