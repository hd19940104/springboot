package com.zixue.demo.bean.response;

/**
 * @Author: Yun
 * @Description: 响应消息之图片消息
 * @Date: Created in 2017-11-29 11:27
 */
public class ImageRespMessage extends  BaseRespMessage{
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
