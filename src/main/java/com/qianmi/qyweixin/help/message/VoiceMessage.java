package com.qianmi.qyweixin.help.message;

import com.qianmi.qyweixin.help.IMessage;

/**
 * voice消息
 * MsgType	消息类型，此时固定为：voice
 */
public class VoiceMessage extends IMessage {
    /**
     *语音媒体文件id，可以调用获取媒体文件接口拉取数据
     * */
    private String mediaId;
    /**
     * 语音格式，如amr，speex等
     * */
    private Long format;

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

    public Long getFormat() {
        return format;
    }

    public void setFormat(Long format) {
        this.format = format;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
