package com.qq.weixin.api.service;

import com.qq.weixin.api.WechatService;
import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.model.message.*;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User : developer
 * Date : 2015/2/13
 * Version : 1.0.1
 */

@Service("wechatService")
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
}
