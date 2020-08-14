package com.zixue.demo.bean.response;

/**
 * @Author: Yun
 * @Description: 响应消息之视频消息
 * @Date: Created in 2017-11-29 11:31
 */
public class VideoRespMessage extends BaseRespMessage{
    // 视频
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
