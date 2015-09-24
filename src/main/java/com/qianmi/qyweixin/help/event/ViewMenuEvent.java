package com.qianmi.qyweixin.help.event;

import com.qianmi.qyweixin.help.IMessage;

/**
 * 点击菜单跳转链接的事件推送
 */
public class ViewMenuEvent extends IMessage {

    /**
     *事件类型，此时固定为：VIEW
     * */
    private String event;

    /**
     *事件KEY值，设置的跳转URL
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
