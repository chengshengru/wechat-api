package com.qq.weixin.api.model.response;

import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.model.Image;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class ImageRespMessage extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Image Image;

	public ImageRespMessage() {
		super();
		MsgType = WX_MSG_TYPE_IMAGE;
	}

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		this.Image = image;
	}

}
