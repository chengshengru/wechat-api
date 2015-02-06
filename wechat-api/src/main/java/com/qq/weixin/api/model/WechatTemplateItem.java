package com.qq.weixin.api.model;

import java.io.Serializable;

/**
 * Created by 程胜儒 on 2015/2/6.
 */
public class WechatTemplateItem implements Serializable{


    private String key;

    private String value;

    private String color = "#000000";


    public WechatTemplateItem() {
    }

    public WechatTemplateItem(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public WechatTemplateItem(String key, String color, String value) {
        this.key = key;
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    @Override
    public String toString() {
        return "WechatTemplateItem{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
