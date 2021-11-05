package com.zixue.demo.service;

import com.zixue.demo.bean.response.TextRespMessage;
import com.zixue.demo.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description:
 */
@Service
@Slf4j
public class CoreService {

    @Autowired
    private MessagehandlerService messagehandlerService;



    public String process(HttpServletRequest request){
        // xml格式的消息数据
        String respXml = null;

        try {
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtils.parseXml(request);

            log.info("接收微信推送消息{}",requestMap.toString());

            TextRespMessage textMessage = messagehandlerService.parseMessage(requestMap);

            // 将文本消息对象转换成xml
            respXml = MessageUtils.messageToXml(textMessage);
            log.info("返回消息{}",respXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }




}
