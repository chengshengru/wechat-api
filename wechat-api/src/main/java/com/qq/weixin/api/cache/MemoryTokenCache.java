package com.qq.weixin.api.cache;

import com.qq.weixin.api.model.AccessToken;

/**
 * 内存缓存Token
 */
public class MemoryTokenCache implements TokenCacheAware {

    private volatile AccessToken mToken = null;

    private volatile AccessToken mJsTicket = null;


    @Override
    public void handleAccessToken(int type, AccessToken token) throws Exception {
        if (token != null) {
            token.setExpires_in(token.getExpires_in() * 1000 + System.currentTimeMillis());
        }
        switch (type) {
            case ACCESS_TOKEN:
                mToken = token;
                break;
            case JS_TICKET:
                mJsTicket = token;
                break;
        }
    }

    @Override
    public AccessToken getAccessToken(int type) throws Exception {
        switch (type) {
            case ACCESS_TOKEN:
                if (mToken != null
                        && mToken.getExpires_in() >= System.currentTimeMillis()) {
                    mToken = null;
                }
                return mToken;
            case JS_TICKET:
                if (mJsTicket != null
                        && mJsTicket.getExpires_in() >= System.currentTimeMillis()) {
                    mJsTicket = null;
                }
                return mJsTicket;
            default:
        }
        return null;
    }

    @Override
    public void clearAccessToken(int type) throws Exception {
        switch (type) {
            case ACCESS_TOKEN: {
                mToken = null;
            }
            break;
            case JS_TICKET: {
                mJsTicket = null;
            }

            break;


        }
    }
}
