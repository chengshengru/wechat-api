package com.qq.weixin.api.model.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 图片消息
 * 
 * @author chengshengru
 *
 */
@XStreamAlias("xml")
public class ImageMessage extends BaseWechatMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String PicUrl;

	private String MediaId;

	public ImageMessage() {
		MsgType = WX_MSG_TYPE_IMAGE;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	@Override
	public String toString() {
		return "ImageMessage [PicUrl=" + PicUrl + ", MediaId=" + MediaId
				+ ", ToUserName=" + ToUserName + ", FromUserName="
				+ FromUserName + ", CreateTime=" + CreateTime + ", MsgType="
				+ MsgType + "]";
	}



}
