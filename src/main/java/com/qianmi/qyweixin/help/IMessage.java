package com.qianmi.qyweixin.help;

/**
 * 微信回调接受的消息基本类
 */
public class IMessage {

    /**
     * 企业号CorpID
     * */
    protected String toUserName;
    /**
     * 成员UserID
     * */
    protected String fromUserName;
    /**
     * 消息创建时间 （整型）
     * */
    protected String createTime;

    /**
     * 消息类型
     * */
    protected String msgType;
    /**
     * 应用代理ID
     * */
    protected String agentID;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getAgentID() {
        return agentID;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }
}
