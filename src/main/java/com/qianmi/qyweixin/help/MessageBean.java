package com.qianmi.qyweixin.help;


import com.qianmi.qyweixin.exception.WeChatException;
import com.qianmi.qyweixin.help.message.*;

/**
 * 接受消息的枚举
 */
public enum MessageBean {

    TEXT("text", TextMessage.class),
    IMAGE("image", ImageMessage.class),
    VOICE("voice", VoiceMessage.class),
    VIDEO("video", VideoMessage.class),
    SHORTVIDEO("shortvideo",ShortVideoMessage.class),
    LOCATION("location",LocationMessage.class);

    private String value;
    private Class c;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Class getC() {
        return c;
    }

    public void setC(Class c) {
        this.c = c;
    }

    MessageBean(String value, Class c){
        this.value = value;
        this.c=c;
    }

    public static Class getClassByValue(String value){
        for (MessageBean bean: MessageBean.values()){
            if(bean.getValue().equals(value)){
                return bean.getC();
            }
        }
        throw new WeChatException("无法匹配的消息类型。");
    }

}
