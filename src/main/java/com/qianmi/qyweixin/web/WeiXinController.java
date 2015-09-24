package com.qianmi.qyweixin.web;

import com.qianmi.qyweixin.bean.MessageEntity;
import com.qianmi.qyweixin.help.IMessage;
import com.qianmi.qyweixin.help.ParserXmlMessage;
import com.qianmi.qyweixin.service.HandleMessageService;
import com.qianmi.qyweixin.web.base.BaseController;
import me.chanjar.weixin.cp.api.WxCpInMemoryConfigStorage;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.WxCpServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/qyweixin")
public  class WeiXinController  extends BaseController {

    private String corpId;
    private String EncodingAESKey;
    private String corpSecret;

    private HandleMessageService handleMessageService;
    /**
     * 开通企业微信应用回调
     */
    @RequestMapping(value = "/api/{appId}/{token}",method = RequestMethod.GET)
    @ResponseBody
    private String callback(MessageEntity entity,@PathVariable String appId,@PathVariable String token) {
        try {
            if(StringUtils.isNotBlank(entity.getEchostr())){
                //返回解密结果
                return entity.decrypt(token,corpId,EncodingAESKey);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 企业微信应用回调方法
     */
    @RequestMapping(value = "/api/{appId}/{token}",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> callback(MessageEntity entity,@PathVariable String appId,@PathVariable String token,@RequestBody String postData) {
        try {
            String msgText = entity.decryptMsg(token, corpId, EncodingAESKey, postData);
            IMessage iMessage= ParserXmlMessage.parse(msgText);
            WxCpInMemoryConfigStorage config=new WxCpInMemoryConfigStorage();
            config.setCorpId(corpId);      // 设置微信企业号的appid
            config.setCorpSecret(corpSecret);  // 设置微信企业号的app corpSecret
            config.setAgentId(appId);     // 设置微信企业号应用ID
            config.setToken(token);       // 设置微信企业号应用的token
            config.setAesKey(EncodingAESKey);      // 设置微信企业号应用的EncodingAESKey
            WxCpService wxCpService = new WxCpServiceImpl();
            wxCpService.setWxCpConfigStorage(config);
            //处理
            handleMessageService.doHandle(iMessage, wxCpService);
            return getSuccessResult("处理成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getFailResult("处理失败");
    }
}
