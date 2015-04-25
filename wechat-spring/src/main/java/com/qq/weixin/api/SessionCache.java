package com.qq.weixin.api;

import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created with IntelliJ IDEA.
 * User : developer
 * Date : 2015/2/25
 * Version : 1.0.1
 */
public class SessionCache {

    public static Map<String,Session> SESSION_CACHE=new ConcurrentSkipListMap<String, Session>();

    /**
     *
     * @param session
     */
    public static void addCache(Session session){
        if(session!=null&&StringUtils.isNotEmpty(session.getSid())){
            SESSION_CACHE.put(session.getSid(),session);
        }
    }



    public static void delCache(String key){
        if(StringUtils.isNotEmpty(key)&&SESSION_CACHE.containsKey(key)){
            SESSION_CACHE.remove(key);
        }
    }

    /**
     * 获取并从缓存中删除
     * @param key
     * @return
     */
    public static Session consumeCache(String key){
        if(StringUtils.isNotEmpty(key)&&SESSION_CACHE.containsKey(key)){
            Session session=SESSION_CACHE.get(key);
            SESSION_CACHE.remove(key);
            return session;
        }
        return null;
    }


    /**
     * 获取缓存
     * @param key
     * @return
     */
    public static Session getCache(String key){
        if(StringUtils.isNotEmpty(key)&&SESSION_CACHE.containsKey(key)){
            Session session=SESSION_CACHE.get(key);
            return session;
        }
        return null;
    }

}
