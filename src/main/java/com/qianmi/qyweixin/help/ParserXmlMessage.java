package com.qianmi.qyweixin.help;


import com.alibaba.fastjson.JSON;
import com.qianmi.qyweixin.exception.WeChatException;
import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 处理消息   将xml 信息转成bean
 */
public class ParserXmlMessage {
    public static IMessage parse(String msg){
        IMessage iMessage=null;
        Class rc=null;
        if(StringUtils.isBlank(msg)){
            return null;
        }
        try {
            // 创建一个新的字符串
            StringReader read = new StringReader(msg);
            // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
            InputSource source = new InputSource(read);

            // 创建一个新的SAXBuilder
            SAXBuilder sb = new SAXBuilder();
            // 通过输入源构造一个Document
            Document doc =  sb.build(source);
            Element root = doc.getRootElement();// 指向根节点

            String msgType=root.getChild("MsgType").getValue();
            if("event".equals(msgType)){
                //事件
                String event=root.getChild("Event").getValue();
                rc= EventBean.getClassByValue(event);
            }else if("text".equals(msgType)){
                //消息
                rc= MessageBean.getClassByValue(msgType);
            }
            if(rc==null){
                throw new WeChatException("找不到该消息类型");
            }
            iMessage=(IMessage)rc.newInstance();
            List<Element> es = root.getChildren();
            for (int i=0;es!=null&&i<es.size();i++){
                Element node=es.get(i);
                String name=node.getName();
                String value=node.getValue();
                Method method= rc.getMethod("set" + name.substring(0, 1).toUpperCase() + name.substring(1),String.class);
                method.invoke(iMessage,value);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return iMessage;

    }

    public static void main(String[] args) {
        IMessage obj=parse("<xml><ToUserName><![CDATA[wxc09a2bf3e18e4519]]></ToUserName>\n" +
                "<FromUserName><![CDATA[OF1245]]></FromUserName>\n" +
                "<CreateTime>1443060395</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<AgentID>1</AgentID>\n" +
                "<Event><![CDATA[click]]></Event>\n" +
                "<EventKey><![CDATA[sm11]]></EventKey>\n" +
                "</xml>");
        System.out.println(JSON.toJSONString(obj));
    }
}
