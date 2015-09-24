package com.qianmi.qyweixin.help.message;

import com.qianmi.qyweixin.help.IMessage;

/**
 * image消息
 * MsgType	消息类型，此时固定为：image
 */
public class ImageMessage extends IMessage {
    /**
     *图片链接
     * */
    private String picUrl;

    /**
     *图片媒体文件id，可以调用获取媒体文件接口拉取数据
     * */
    private String mediaId;

    /**
     *消息id，64位整型
     * */
    private String msgId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
