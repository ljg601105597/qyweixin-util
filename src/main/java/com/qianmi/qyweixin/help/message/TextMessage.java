package com.qianmi.qyweixin.help.message;

import com.qianmi.qyweixin.help.IMessage;

/**
 * 接收普通消息
 * 普通消息是指成员向企业号应用发送的消息，包括文本、图片、语音、视频、地理位置等类型。普通消息会推送到每个应用在管理端设置的
 *
 * MsgType	消息类型，此时固定为：text
 */
public class TextMessage extends IMessage {
    /**
     *文本消息内容
     * */
    private String content;
    /**
     * 消息id，64位整型
     * */
    private String msgId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
