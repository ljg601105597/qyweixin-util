package com.qianmi.qyweixin.help.message;

import com.qianmi.qyweixin.help.IMessage;

/**
 * location消息
 * MsgType	消息类型，此时固定为：location
 */
public class LocationMessage extends IMessage {
    /**
     *地理位置纬度
     * */
    private String location_X;

    /**
     *地理位置经度
     * */
    private String location_Y;

    /**
     * 地图缩放大小
     * */
    private String scale;

    /**
     * 地理位置信息
     * */
    private String label;

    /**
     *消息id，64位整型
     * */
    private String msgId;

    public String getLocation_X() {
        return location_X;
    }

    public void setLocation_X(String location_X) {
        this.location_X = location_X;
    }

    public String getLocation_Y() {
        return location_Y;
    }

    public void setLocation_Y(String location_Y) {
        this.location_Y = location_Y;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
