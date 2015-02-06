package com.qq.weixin.api.model;

import java.io.Serializable;

/**
 * Created by 程胜儒 on 2015/2/5.
 */
public class WechatQrcodeTicket implements Serializable {

    private String ticket;

    private int expireSeconds = 0;

    private String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    @Override
    public String toString() {
        return "WechatQrcodeTicket{" +
                "ticket='" + ticket + '\'' +
                ", expireSeconds=" + expireSeconds +
                ", url='" + url + '\'' +
                '}';
    }
}
