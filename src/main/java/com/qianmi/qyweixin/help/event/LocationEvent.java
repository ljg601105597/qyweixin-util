package com.qianmi.qyweixin.help.event;

import com.qianmi.qyweixin.help.IMessage;

/**
 * 上报地理位置事件
 *
 * 成员同意上报地理位置后，每次在进入应用会话时都会上报一次地理位置，或在进入应用会话后每5秒上报一次地理位置。
 * 企业可以在管理端修改应用的以上设置。上报地理位置时，微信会将此事件推送到企业应用在管理端设置的URL
 */
public class LocationEvent extends IMessage {

    /**
     *事件类型，此时固定为：LOCATION
     * */
    private String event;

    /**
     *地理位置纬度
     * */
    private String latitude;

    /**
     *地理位置经度
     * */
    private String longitude;

    /**
     *地理位置精度
     * */
    private String precision;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
