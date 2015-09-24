package com.qianmi.qyweixin.help.event;


import com.qianmi.qyweixin.help.IMessage;

/**
 * 弹出微信相册发图器的事件推送
 */
public class PicWeiXinEvent extends IMessage {

    /**
     *事件类型，此时固定为：pic_weixin
     * */
    private String event;

    /**
     *事件KEY值，由开发者在创建菜单时设定
     * */
    private String eventKey;

    /**
     *发送的图片信息
     * */
    private String sendPicsInfo;

    /**
     *发送的图片数量
     * */
    private String count;
    /**
     *图片列表
     * */
    private String picList;

    /**
     *图片的MD5值，开发者若需要，可用于验证接收到图片
     * */
    private String picMd5Sum;

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

    public String getSendPicsInfo() {
        return sendPicsInfo;
    }

    public void setSendPicsInfo(String sendPicsInfo) {
        this.sendPicsInfo = sendPicsInfo;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPicList() {
        return picList;
    }

    public void setPicList(String picList) {
        this.picList = picList;
    }

    public String getPicMd5Sum() {
        return picMd5Sum;
    }

    public void setPicMd5Sum(String picMd5Sum) {
        this.picMd5Sum = picMd5Sum;
    }
}
