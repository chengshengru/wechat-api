package com.qq.weixin.api.service;

import com.qq.weixin.api.Session;
import com.qq.weixin.api.WechatService;
import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.model.message.*;
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
}
