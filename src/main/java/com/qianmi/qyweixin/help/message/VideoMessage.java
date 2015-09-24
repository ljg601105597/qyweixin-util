package com.qianmi.qyweixin.help.message;

import com.qianmi.qyweixin.help.IMessage;

/**
 * video消息
 * MsgType	消息类型，此时固定为：video
 */
public class VideoMessage extends IMessage {
    /**
     *视频媒体文件id，可以调用获取媒体文件接口拉取数据
     * */
    private String mediaId;
    /**
     * 视频消息缩略图的媒体id，可以调用获取媒体文件接口拉取数据
     * */
    private String thumbMediaId;
    /**
     * 消息id，64位整型
     * */
    private String msgId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
