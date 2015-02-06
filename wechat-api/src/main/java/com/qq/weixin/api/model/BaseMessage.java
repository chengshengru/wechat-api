package com.qq.weixin.api.model;

import java.io.Serializable;

public abstract class BaseMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 文本消息
	 */
	public static final String WX_MSG_TYPE_TEXT = "text";

	/**
	 * 图片消息
	 */
	public static final String WX_MSG_TYPE_IMAGE = "image";

	/**
	 * 语音消息
	 */
	public static final String WX_MSG_TYPE_VOICE = "voice";

	/**
	 * 视频消息
	 */
	public static final String WX_MSG_TYPE_VIDEO = "video";

	/**
	 * 位置信息
	 */
	public static final String WX_MSG_TYPE_LOCATION = "location";

	/**
	 * 链接消息
	 */
	public static final String WX_MSG_TYPE_LINK = "link";

	/**
	 * 事件消息
	 */
	public static final String WX_MSG_TYPE_EVENT = "event";

	/**
	 * 回复图文消息
	 */
	public static final String WX_MSG_TYPE_NEWS = "news";

	/**
	 * 回复音乐消息
	 */
	public static final String WX_MSG_TYPE_MUSIC = "music";

	/**
	 * 多客服消息
	 */
	public static final String WX_MSG_TYPE_TRANSFER = "transfer_customer_service";

	protected String ToUserName;

	protected String FromUserName;

	protected String CreateTime;

	protected String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
