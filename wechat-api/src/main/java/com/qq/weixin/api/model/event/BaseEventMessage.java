package com.qq.weixin.api.model.event;

import com.qq.weixin.api.model.BaseMessage;

public class BaseEventMessage extends BaseMessage {

	private static final long serialVersionUID = 1L;
	/**
	 * 用户关注
	 */
	public static final String WX_MSG_TYPE_EVENT_SUBSCRIBE = "subscribe";

	/**
	 * 用户取消关注
	 */
	public static final String WX_MSG_TYPE_EVENT_UNSUBSCRIBE = "unsubscribe";
	/**
	 * 扫描事件
	 */
	public static final String WX_MSG_TYPE_EVENT_SCAN = "scan";

	/**
	 * 上报地理位置事件
	 */
	public static final String WX_MSG_TYPE_EVENT_LOCATION = "location";
	/**
	 * 自定义菜单事件
	 */
	public static final String WX_MSG_TYPE_EVENT_CLICK = "click";

	/**
	 * 点击菜单跳转链接时的事件推送
	 */
	public static final String WX_MSG_TYPE_EVENT_VIEW = "view";

	/**
	 * 弹出系统拍照发图的事件推送
	 */
	public static final String WX_MSG_TYPE_EVENT_PIC_SYSPHOTO = "pic_sysphoto";

	/**
	 * 弹出拍照或者相册发图的事件推送
	 */
	public static final String WX_MSG_TYPE_EVENT_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";

	public static final String WX_MSG_TYPE_EVENT_PIC_WEIXIN = "pic_weixin";

	protected String Event;

	public BaseEventMessage() {
		MsgType = WX_MSG_TYPE_EVENT;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

}
