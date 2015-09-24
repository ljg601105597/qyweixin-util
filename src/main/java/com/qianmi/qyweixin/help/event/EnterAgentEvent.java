package com.qianmi.qyweixin.help.event;

import com.qianmi.qyweixin.help.IMessage;

/**
 * 成员进入应用的事件推送
 */
public class EnterAgentEvent extends IMessage {

    /**
     *事件类型，此时固定为：enter_agent
     * */
    private String event;

    /**
     *事件KEY值，此事件该值为空
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
