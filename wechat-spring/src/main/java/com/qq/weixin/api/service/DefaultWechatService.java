package com.qq.weixin.api.service;

import com.qq.weixin.api.Session;
import com.qq.weixin.api.WechatService;
import com.qq.weixin.api.config.ConfigManager;
import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.model.message.*;
import com.qq.weixin.api.model.response.NewsRespMessage;
import com.qq.weixin.api.service.impl.WechatXmlResponseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User : developer
 * Date : 2015/2/13
 * Version : 1.0.1
 */

public class DefaultWechatService extends WechatService{


    private WechatResponseService mResponseService=new WechatXmlResponseService();


    @Override
    public BaseMessage handleWechatTextMessage(TextMessage msg) throws Exception {





        return null;
    }

    @Override
    public BaseMessage handleWechatImageMessage(ImageMessage msg) throws Exception {
        return null;
    }

    @Override
    public BaseMessage handleWechatVoiceMessage(VoiceMessage msg) throws Exception {
        return null;
    }

    @Override
    public BaseMessage handleWechatVideoMessage(VideoMessage msg) throws Exception {
        return null;
    }

    @Override
    public BaseMessage handleWechatLocationMessage(LocationMessage msg) throws Exception {
        return null;
    }

    @Override
    public BaseMessage handleWechatLinkMessage(LinkMessage msg) throws Exception {
        return null;
    }

    @Override
    public Session validateWechat(HttpServletRequest request, HttpServletResponse response) {



        return null;
    }


    /**
     * 转换成回复给微信的id
     * @param openId
     * @param wechatId
     * @param url
     * @param message
     * @return
     */
    private BaseMessage getReallyMessage(String openId,String wechatId,String url,BaseMessage message){

        BaseMessage msg=null;
        if(message instanceof TextMessage){
            TextMessage text=(TextMessage)msg;
            TextMessage reply=new TextMessage();
            reply.setCreateTime(String.valueOf(System.currentTimeMillis()/1000));
            reply.setFromUserName(wechatId);
            reply.setToUserName(openId);

            String content=replacePlaceholder(text.getContent(), openId, url);
            reply.setContent(content);
            msg=reply;

        }else if(message instanceof NewsRespMessage){

        }
        return msg;
    }


    private String replacePlaceholder(String src,String openId,String url){
        if(StringUtils.isNotEmpty(src)){
            if(src.contains("$host$")){
                src=src.replace("$host$", ConfigManager.getInstance().getServerHost());
            }

            if(src.contains("$openId$")){
                src=src.replace("$openId$",openId);
            }



        }
        return src;
    }
}
