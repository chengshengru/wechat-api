package com.qq.weixin.api.model.response;

import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.model.Video;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class VideoRespMessage extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Video Video;

	public VideoRespMessage() {
		super();
		MsgType = WX_MSG_TYPE_VIDEO;
	}

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}

}
