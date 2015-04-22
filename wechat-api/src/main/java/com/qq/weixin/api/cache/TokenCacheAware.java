package com.qq.weixin.api.cache;

import com.qq.weixin.api.model.AccessToken;

/**
 * Created by 程胜儒 on 2015/2/6.
 */
public interface TokenCacheAware {

    public static final int ACCESS_TOKEN=0x1;

    public static final int JS_TICKET = 0x2;

    /**
     * 处理Token
     * @param type
     * @param token
     * @throws Exception
     */
    void handleAccessToken(int type,AccessToken token) throws Exception;

    /**
     * 获取Token
     * @param type
     * @return
     */
    AccessToken getAccessToken(int type) throws Exception;

    /**
     * 清掉Token
     * @throws Exception
     */
    void clearAccessToken(int type) throws Exception;

}
