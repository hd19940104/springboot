package com.zixue.demo.bean.response;

/**
 * @Author: Yun
 * @Description: 响应消息之音乐消息
 * @Date: Created in 2017-11-29 11:32
 */
public class MusicRespMessage extends BaseRespMessage{
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
