package com.zixue.demo.controller;


import com.zixue.demo.service.CoreService;
import com.zixue.demo.utils.PrintLog;
import com.zixue.demo.utils.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信对外接口
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    CoreService coreService;

    @Autowired
    SignUtil signUtil;
    @Autowired
    PrintLog printLog;

    @RequestMapping("/detail")
    @ResponseBody
    public String detail(){
        return "this is detail";
    }

    /**
     * 确认请求来自微信服务器
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param echostr 随机字符串
     */
    @ResponseBody
    @GetMapping("/access")
    public String access(String signature,String timestamp,String nonce,String echostr){
        printLog.log("start..."+signature+"=="+timestamp+"=="+nonce+"=="+echostr);
        Boolean bool=signUtil.checkSignature(signature,timestamp,nonce);
        printLog.log(bool.toString());
        if(bool){
            return echostr;
        }
        return null;
    }
    @ResponseBody
    @PostMapping("/access")
    public String access(HttpServletRequest request){

        return coreService.process(request);
    }
}
