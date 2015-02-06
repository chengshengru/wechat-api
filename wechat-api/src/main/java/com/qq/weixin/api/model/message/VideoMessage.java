package com.qq.weixin.api.model.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class VideoMessage extends BaseWechatMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String MediaId;
	
	String ThumbMediaId;

	public VideoMessage() {
		MsgType = WX_MSG_TYPE_VIDEO;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
