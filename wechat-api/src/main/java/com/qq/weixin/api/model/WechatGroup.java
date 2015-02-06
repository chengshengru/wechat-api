package com.qq.weixin.api.model;

import java.io.Serializable;

/**
 * Created by 程胜儒 on 2015/2/5.
 *
 * 微信分组
 */

public class WechatGroup implements Serializable {

    /**
     * 分组id，由微信分配
     */
    private Long id;
    /**
     * 分组名字，UTF8编码
     */
    private String name;
    /**
     * 分组内用户数量
     */
    private long count=0;


    public WechatGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public WechatGroup() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WechatGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
