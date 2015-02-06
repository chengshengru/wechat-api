package com.qq.weixin.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 微信模版消息
 *
 * Created by 程胜儒 on 2015/2/6.
 */
public class WechatTemplate implements Serializable{

    private String topColor = "#FF0000";

    private String templateId;

    private String url;

    private List<WechatTemplateItem> data;


    public String getTopColor() {
        return topColor;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    public void addTemplate(WechatTemplateItem item) {
        if (item != null) {
            if (data != null) {
                data = new ArrayList<WechatTemplateItem>();
            }
            data.add(item);
        }
    }

    public List<WechatTemplateItem> getData() {
        return data;
    }

    public void setData(List<WechatTemplateItem> data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
