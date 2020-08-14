package com.zixue.demo.bean.response;

/**
 * @Author: Yun
 * @Description: 响应消息之语音消息
 * @Date: Created in 2017-11-29 11:29
 */
public class VoiceRespMessage extends  BaseRespMessage{
    // 语音
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
