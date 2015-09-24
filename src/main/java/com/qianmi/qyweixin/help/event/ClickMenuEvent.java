package com.qianmi.qyweixin.help.event;

import com.qianmi.qyweixin.help.IMessage;

/**
 * 点击菜单拉取消息的事件推送
 */
public class ClickMenuEvent extends IMessage {

    /**
     *事件类型，此时固定为：CLICK
     * */
    private String event;

    /**
     *事件KEY值，与自定义菜单接口中KEY值对应
     * */
    private String eventKey;

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
}
