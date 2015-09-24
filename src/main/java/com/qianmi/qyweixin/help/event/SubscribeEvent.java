package com.qianmi.qyweixin.help.event;

import com.qianmi.qyweixin.help.IMessage;

/**
 * 成员关注/取消关注事件
 * 成员关注、取消关注企业号的事件，会推送到每个应用在管理端设置的URL；特别的，默认企业小助手可以用于获取整个企业号的关注状况
 */
public class SubscribeEvent extends IMessage {

    /**
     *事件类型，subscribe(订阅)、unsubscribe(取消订阅)
     * */
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
