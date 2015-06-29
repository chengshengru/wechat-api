package com.qq.weixin.api.cache;

/**
 * 缓存管理
 * Created by chengshengru on 15-6-29.
 */
public interface CacheAware {

    /**
     * 添加缓存
     * @param key
     * @param value
     */
    public void addCache(String key,Object value);

    public void addCache(String key,int expire,Object value);

    /**
     * 获取缓存中数据
     * @param key
     * @param <T>
     * @return
     */
    public  <T extends Object> T getCache(String key);

    /**
     * 删除缓存
     * @param key
     */
    public void delCache(String key);
}
