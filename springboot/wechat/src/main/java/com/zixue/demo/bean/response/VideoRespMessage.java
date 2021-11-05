package com.zixue.demo.bean.response;

/**
 * @Description: 响应消息之视频消息
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
