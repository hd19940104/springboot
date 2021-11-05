package com.zixue.demo.robot.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zixue.demo.robot.bean.request.BaseReqMessage;
import com.zixue.demo.robot.bean.response.BaseRespMessage;
import com.zixue.demo.robot.bean.response.RobotResponTypeEnum;
import com.zixue.demo.robot.common.BaseCommon;
import com.zixue.demo.robot.util.HttpRequestUtil;

/**
 * @Description: 图灵机器人的服务类
 */
public class TlRobotService {

    /**
     * 调用图灵的问答API,并返回文本响应值
     * @param userid
     * @param info
     * @return
     */
    public static String getTextResponse(String userid,String info){
        //封装请求参数对象
        BaseReqMessage reqMessage=new BaseReqMessage();
        reqMessage.setKey(BaseCommon.TL_ROBOT_API_KEY);
        reqMessage.setInfo(info);
        reqMessage.setUserid(userid);
        //转换为json
        ObjectMapper mapper=new ObjectMapper();
        try {
            String json=mapper.writeValueAsString(reqMessage);
            String result= HttpRequestUtil.doPost(BaseCommon.TL_ROBOT_API_URL,json,"UTF-8");
            BaseRespMessage respMessage=mapper.readValue(result,BaseRespMessage.class);
            RobotResponTypeEnum robotResponTypeEnum=RobotResponTypeEnum.getRobotResponseType(respMessage.getCode(),respMessage.getText());
            return robotResponTypeEnum.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
