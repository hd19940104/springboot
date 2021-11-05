package com.zixue.demo.robot.bean.response;

/**
 * @Description:
 */
public enum RobotResponTypeEnum {

    /**
     *
     *   100000	文本类
         200000	链接类
         302000	新闻类
         308000	菜谱类

         40001	参数key错误
         40002	请求内容info为空
         40004	当天请求次数已使用完
         40007	数据格式异常
     */
    TEXT_RESPONSE(100000,""),
    LINK_RESPONSE(200000,""),
    NEWS_RESPONSE(302000,""),
    FOODER_RESPONSE(308000,""),

    KEY_ERROR_RESPONSE(40001,"么么哒....机器人小云的API_KEY值错误了...快跑去报告给你的主人哦。。。"),
    INFO_ERROR_RESPONSE(40002,"么么哒...请不要发送空的内容给宝宝嘛...."),
    LEFT_ERROR_RESPONSE(40004,"小云今天的问答次数没有了哦,请明天再来吧..."),
    DATA_ERROR_RESPONSE(40007,"么么哒...数据格式异常了哦....请把错误报告给你的老公大人哦"),

    NO_RESPONSE_ERROR(1,"么么哒,你这个问题把宝宝难住了呢。。。换一个嘛。。。。");


    private Integer code;
    private String text;

    RobotResponTypeEnum(Integer code, String text){
        this.code=code;
        this.text=text;
    }

    public static RobotResponTypeEnum getRobotResponseType(Integer code,String text){
        RobotResponTypeEnum[] enums=values();
        for(RobotResponTypeEnum robotResponTypeEnum:enums){
            if(robotResponTypeEnum.getCode().equals(code)){
                if(code.equals(100000)||code.equals(200000)||code.equals(302000)||code.equals(308000)){
                    robotResponTypeEnum.setText(text);
                }
                return robotResponTypeEnum;
            }
        }
        return NO_RESPONSE_ERROR;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
