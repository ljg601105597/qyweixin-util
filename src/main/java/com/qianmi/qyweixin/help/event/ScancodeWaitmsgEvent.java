package com.qianmi.qyweixin.help.event;

import com.qianmi.qyweixin.help.IMessage;

/**
 * 扫码推事件且弹出“消息接收中”提示框的事件推送
 */
public class ScancodeWaitmsgEvent extends IMessage {

    /**
     *事件类型，此时固定为：scancode_waitmsg
     * */
    private String event;

    /**
     *事件KEY值，由开发者在创建菜单时设定
     * */
    private String eventKey;

    /**
     *扫描信息
     * */
    private String scanCodeInfo;

    /**
     *扫描类型，一般是qrcode
     * */
    private String scanType;
    /**
     *扫描结果，即二维码对应的字符串信息
     * */
    private String scanResult;

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

    public String getScanCodeInfo() {
        return scanCodeInfo;
    }

    public void setScanCodeInfo(String scanCodeInfo) {
        this.scanCodeInfo = scanCodeInfo;
    }

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    public String getScanResult() {
        return scanResult;
    }

    public void setScanResult(String scanResult) {
        this.scanResult = scanResult;
    }
}
