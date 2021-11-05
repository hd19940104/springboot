package com.zixue.demo.bean.response;

/**
 * @Description: 响应消息之图片消息
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
