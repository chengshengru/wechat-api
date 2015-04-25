package com.qq.weixin.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 程胜儒 on 2015/2/5.
 */
public class Session implements Serializable {

    private ConcurrentHashMap<String,Object> mAttrs=new ConcurrentHashMap<String, Object>();


    private String sid;


    private boolean isOAuth=false;

    /**
     * 获取属性值
     * @param key
     * @param <T>
     * @return
     */
    public <T extends Object>T getAttibute(String key){
        return (T)mAttrs.get(key);
    }

    /**
     * 设置属性
     * @param key
     * @param value
     */
    public void setAttribute(String key,Object value){
        if(key!=null&&value!=null){
            mAttrs.put(key, value);
        }
    }

    /**
     * 移除某个属性
     * @param key
     */
    public void removeAttribute(String key){
        if(key!=null){
            mAttrs.remove(key);
        }
    }

    /**
     * 清楚属性
     */
    public void clear(){
        mAttrs.clear();
    }


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }


    public boolean isOAuth() {
        return isOAuth;
    }

    public void setOAuth(boolean isOAuth) {
        this.isOAuth = isOAuth;
    }

    @Override
    public String toString() {
        return "Session{" +
                "mAttrs=" + mAttrs +
                ", sid='" + sid + '\'' +
                ", isOAuth=" + isOAuth +
                '}';
    }
}
