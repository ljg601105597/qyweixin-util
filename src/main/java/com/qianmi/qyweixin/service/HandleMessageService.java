package com.qianmi.qyweixin.service;

import com.qianmi.qyweixin.help.IMessage;
import com.qianmi.qyweixin.help.event.*;
import com.qianmi.qyweixin.help.message.*;
import me.chanjar.weixin.cp.api.WxCpService;

/**
 * 企业微信回调处理消息和事件
 */
public class HandleMessageService {

    public void doHandle(IMessage message,WxCpService wxCpService){
        //处理消息
        if(message instanceof TextMessage){
            doHandleTextMessage((TextMessage)message,wxCpService);
        }else  if(message instanceof ImageMessage){
            doHandleImageMessage((ImageMessage) message, wxCpService);
        }else  if(message instanceof VoiceMessage){
            doHandleVoiceMessage((VoiceMessage) message, wxCpService);
        }else  if(message instanceof VideoMessage){
            doHandleVideoMessage((VideoMessage) message, wxCpService);
        }else  if(message instanceof ShortVideoMessage){
            doHandleShortVideoMessage((ShortVideoMessage) message, wxCpService);
        }else  if(message instanceof LocationMessage){
            doHandleLocationMessage((LocationMessage) message, wxCpService);
        }
        //处理事件
        else  if(message instanceof SubscribeEvent){
            doHandleSubscribeEvent((SubscribeEvent) message, wxCpService);
        }else  if(message instanceof LocationEvent){
            doHandleLocationEvent((LocationEvent) message, wxCpService);
        }else  if(message instanceof ClickMenuEvent){
            doHandleClickMenuEvent((ClickMenuEvent) message, wxCpService);
        }else  if(message instanceof ViewMenuEvent){
            doHandleViewMenuEvent((ViewMenuEvent) message, wxCpService);
        }else  if(message instanceof ScancodePushEvent){
            doHandleScancodePushEvent((ScancodePushEvent) message, wxCpService);
        }else  if(message instanceof ScancodeWaitmsgEvent){
            doHandleScancodeWaitmsgEvent((ScancodeWaitmsgEvent) message, wxCpService);
        }else  if(message instanceof PicSysPhotoEvent){
            doHandlePicSysPhotoEvent((PicSysPhotoEvent) message, wxCpService);
        }else  if(message instanceof PicPhotoOrAlbumEvent){
            doHandlePicPhotoOrAlbumEvent((PicPhotoOrAlbumEvent) message, wxCpService);
        }else  if(message instanceof PicWeiXinEvent){
            doHandlePicWeiXinEvent((PicWeiXinEvent) message, wxCpService);
        }else  if(message instanceof LocationSelectEvent){
            doHandleLocationSelectEvent((LocationSelectEvent) message, wxCpService);
        }else  if(message instanceof EnterAgentEvent){
            doHandleEnterAgentEvent((EnterAgentEvent) message, wxCpService);
        }else  if(message instanceof BatchJobResultEvent){
            doHandleBatchJobResultEvent((BatchJobResultEvent) message, wxCpService);
        }
    }
    /**
     * 处理 接收普通消息 text
     * */
    protected  void doHandleTextMessage(TextMessage textMessage,WxCpService wxCpService){}

    /**
     * 处理 image消息
     * */
    protected  void doHandleImageMessage(ImageMessage imageMessage,WxCpService wxCpService){}

    /**
     * 处理 voice消息
     * */
    protected  void doHandleVoiceMessage(VoiceMessage voiceMessage,WxCpService wxCpService){}
    /**
     * 处理 video消息
     * */
    protected  void doHandleVideoMessage(VideoMessage videoMessage,WxCpService wxCpService){}

    /**
     * 处理 小视频消息
     * */
    protected  void doHandleShortVideoMessage(ShortVideoMessage shortVideoMessage,WxCpService wxCpService){}

    /**
     * 处理 location消息
     * */
    protected  void doHandleLocationMessage(LocationMessage locationMessage,WxCpService wxCpService){}

    /**
     * 处理  成员关注/取消关注事件
     * */
    protected  void doHandleSubscribeEvent(SubscribeEvent subscribeEvent,WxCpService wxCpService){}

    /**
     * 处理  上报地理位置事件
     * */
    protected  void doHandleLocationEvent(LocationEvent locationEvent,WxCpService wxCpService){}

    /**
     * 处理  点击菜单拉取消息的事件推送
     * */
    protected  void doHandleClickMenuEvent(ClickMenuEvent llickMenuEvent,WxCpService wxCpService){}

    /**
     * 处理  点击菜单跳转链接的事件推送
     * */
    protected  void doHandleViewMenuEvent(ViewMenuEvent viewMenuEvent,WxCpService wxCpService){}

    /**
     * 处理  扫码推事件的事件推送
     * */
    protected  void doHandleScancodePushEvent(ScancodePushEvent scancodePushEvent,WxCpService wxCpService){}

    /**
     * 处理  扫码推事件且弹出“消息接收中”提示框的事件推送
     * */
    protected  void doHandleScancodeWaitmsgEvent(ScancodeWaitmsgEvent scancodeWaitmsgEvent,WxCpService wxCpService){}

    /**
     * 处理  弹出系统拍照发图的事件推送
     * */
    protected  void doHandlePicSysPhotoEvent(PicSysPhotoEvent picSysPhotoEvent,WxCpService wxCpService){}

    /**
     * 处理  弹出拍照或者相册发图的事件推送
     * */
    protected  void doHandlePicPhotoOrAlbumEvent(PicPhotoOrAlbumEvent picPhotoOrAlbumEvent,WxCpService wxCpService){}

    /**
     * 处理  弹出微信相册发图器的事件推送
     * */
    protected  void doHandlePicWeiXinEvent(PicWeiXinEvent picWeiXinEvent,WxCpService wxCpService){}

    /**
     * 处理  弹出地理位置选择器的事件推送
     * */
    protected  void doHandleLocationSelectEvent(LocationSelectEvent locationSelectEvent,WxCpService wxCpService){}

    /**
     * 处理  成员进入应用的事件推送
     * */
    protected  void doHandleEnterAgentEvent(EnterAgentEvent enterAgentEvent,WxCpService wxCpService){}

    /**
     * 处理  异步任务完成事件推送
     * */
    protected  void doHandleBatchJobResultEvent(BatchJobResultEvent batchJobResultEvent,WxCpService wxCpService){}


}
