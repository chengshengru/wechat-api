package com.qq.weixin.api.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Image")
public class Image {

	public String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
