package com.qq.weixin.api.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Video")
public class Video {

	public String MediaId;
	
	public String Title;
	
	public String Description;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
