package com.qianmi.qyweixin.help.event;

import com.qianmi.qyweixin.help.IMessage;

/**
 * 弹出地理位置选择器的事件推送
 */
public class LocationSelectEvent extends IMessage {

    /**
     *事件类型，此时固定为：location_select
     * */
    private String event;

    /**
     *事件KEY值，由开发者在创建菜单时设定
     * */
    private String eventKey;

    /**
     *发送的位置信息
     * */
    private String sendLocationInfo;

    /**
     *X坐标信息
     * */
    private String location_X;

    /**
     *Y坐标信息
     * */
    private String location_Y;

    /**
     *精度，可理解为精度或者比例尺、越精细的话 scale越高
     * */
    private String scale;

    /**
     *地理位置的字符串信息
     * */
    private String label;

    /**
     *朋友圈POI的名字，可能为空
     * */
    private String poiname;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getSendLocationInfo() {
        return sendLocationInfo;
    }

    public void setSendLocationInfo(String sendLocationInfo) {
        this.sendLocationInfo = sendLocationInfo;
    }

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

    public String getPoiname() {
        return poiname;
    }

    public void setPoiname(String poiname) {
        this.poiname = poiname;
    }
}
