package com.qianmi.qyweixin.bean;

import com.qianmi.qyweixin.help.decrypt.AesException;
import com.qianmi.qyweixin.help.decrypt.WXBizMsgCrypt;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Arrays;

public class MessageEntity implements Serializable{

    private static final long serialVersionUID = -6141971101867074159L;
    
    private String echostr;
    
	private String signature;
	
	private String nonce;
	
	private String timestamp;
	
	private String msg_signature;
	
    public String getEchostr() {
        return echostr;
    }
    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public String getNonce() {
        return nonce;
    }
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getMsg_signature() {
		return msg_signature;
	}
	public void setMsg_signature(String msg_signature) {
		this.msg_signature = msg_signature;
	}
	
	public boolean match(String token){
        if(StringUtils.isBlank(signature) || StringUtils.isBlank(timestamp) || StringUtils.isBlank(nonce)){
            return false;
        }
        String[] dataStrings = new String[] { token, timestamp, nonce };
        Arrays.sort(dataStrings);
        String data = dataStrings[0] + dataStrings[1] + dataStrings[2];
        String flag = DigestUtils.sha1Hex(data);
        if (flag.equalsIgnoreCase(signature)) {
            return true;
        } else {
            return false;
        }
    }
	
	public String decrypt(String token,String corpId,String aesKey){
        try {
			if(StringUtils.isBlank(msg_signature) || StringUtils.isBlank(timestamp) || StringUtils.isBlank(nonce)){
			    return null;
			}
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, aesKey, corpId);
			String result = wxcpt.VerifyURL(msg_signature, timestamp,
					nonce, echostr);
			System.out.println(result);
			return result;
		} catch (AesException e) {
			return null;
		}
    }
	
	public String decryptMsg(String token,String corpId,String aesKey,String message){
        try {
			if(StringUtils.isBlank(msg_signature) || StringUtils.isBlank(timestamp) || StringUtils.isBlank(nonce)){
			    return null;
			}
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, aesKey, corpId);
			String result = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, message);
			return result;
		} catch (AesException e) {
			return null;
		}
    }
	
	public String encryptMsg(String token,String corpId,String aesKey,String message){
        try {
			if(StringUtils.isBlank(msg_signature) || StringUtils.isBlank(timestamp) || StringUtils.isBlank(nonce)){
			    return null;
			}
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, aesKey, corpId);
			String result = wxcpt.EncryptMsg(message, timestamp, nonce);
			return result;
		} catch (AesException e) {
			return null;
		}
    }
}
