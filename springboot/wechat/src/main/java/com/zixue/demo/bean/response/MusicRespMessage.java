package com.zixue.demo.bean.response;

/**
 *
 * @Description: 响应消息之音乐消息
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
