package com.qianmi.qyweixin.help;


import com.qianmi.qyweixin.exception.WeChatException;
import com.qianmi.qyweixin.help.event.*;

/**
 * 接受事件的枚举
 */
public enum EventBean {

    LOCATION("LOCATION", LocationEvent.class),
    CLICK("CLICK", ClickMenuEvent.class),
    VIEW("VIEW", ViewMenuEvent.class),
    SCAN_PUSH("scancode_push", ScancodePushEvent.class),
    SCAN_WAITMSG("scancode_waitmsg", ScancodeWaitmsgEvent.class),
    PIC_SYSPHOTO("pic_sysphoto",PicSysPhotoEvent.class),
    PIC_PHOTOORALBUM("pic_photo_or_album",PicPhotoOrAlbumEvent.class),
    PIC_WEIXIN("pic_weixin",PicWeiXinEvent.class),
    LOCATION_SELECT("location_select",LocationSelectEvent.class),
    ENTERAGENT("enter_agent",EnterAgentEvent.class),
    BATH_JOB_RESULT("batch_job_result",BatchJobResultEvent.class);

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

    EventBean(String value,Class c){
        this.value = value;
        this.c=c;
    }

    public static Class getClassByValue(String value){
        for (EventBean bean: EventBean.values()){
            if(bean.getValue().equalsIgnoreCase(value)){
                return bean.getC();
            }
        }
        throw new WeChatException("无法匹配的消息类型。");
    }

}
