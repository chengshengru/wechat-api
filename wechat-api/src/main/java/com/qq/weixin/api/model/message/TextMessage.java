package com.qq.weixin.api.model.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文本消息
 * 
 * @author chengshengru
 *
 */
@XStreamAlias("xml")
public class TextMessage extends BaseWechatMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Content;

	public TextMessage() {
		MsgType = WX_MSG_TYPE_TEXT;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		return "TextMessage [Content=" + Content + ", ToUserName=" + ToUserName
				+ ", FromUserName=" + FromUserName + ", CreateTime="
				+ CreateTime + ", MsgType=" + MsgType + "]";
	}



}
