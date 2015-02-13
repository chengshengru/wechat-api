package com.qq.weixin.api.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User : developer
 * Date : 2015/2/6
 * Version : 1.0.1
 * 微信素材
 */
public class WechatMedia implements Serializable{

    public static final String IMAGE_MEDIA_TYPE="image";

    public static final String VOICE_MEDIA_TYPE="voice";

    public static final String VIDEO_MEDIA_TYPE="video";

    public static final String THUMB_MEDIA_TYPE="thumb";

    public static final String NEWS_MEDIA_TYPE="news";

    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），次数为news，即图文消息
     */
    private String type;
    /**
     * 媒体文件/图文消息上传后获取的唯一标识
     */
    private String media_id;

    /**
     *
     * 媒体文件上传时间
     */
    private Long created_at;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }


    @Override
    public String toString() {
        return "WechatMedia{" +
                "type='" + type + '\'' +
                ", media_id='" + media_id + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
