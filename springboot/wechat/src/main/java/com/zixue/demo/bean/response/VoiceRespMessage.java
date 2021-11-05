package com.zixue.demo.bean.response;

/**
 * @Description: 响应消息之语音消息
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
