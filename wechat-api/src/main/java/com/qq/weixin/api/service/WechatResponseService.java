package com.qq.weixin.api.service;

import com.qq.weixin.api.model.BaseMessage;

/**
 * Created with IntelliJ IDEA.
 * User : developer
 * Date : 2015/4/28
 * Version : 1.0.1
 */
public interface WechatResponseService {

    /**
     * 根据key获取反馈消息对象
     * @param key
     * @return
     */
    BaseMessage getMessageByKey(String key);

    /**
     * 清掉缓存
     * @param key
     */
    void clearMessageByKey(String key);

}
