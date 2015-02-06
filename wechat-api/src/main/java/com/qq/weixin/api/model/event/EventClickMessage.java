package com.qq.weixin.api.model.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class EventClickMessage extends BaseEventMessage {

	private static final long serialVersionUID = 1L;
	private String EventKey;

	public EventClickMessage() {
		super();
		Event = WX_MSG_TYPE_EVENT_CLICK;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	@Override
	public String toString() {
		return "EventClickMessage [EventKey=" + EventKey + ", Event=" + Event
				+ ", ToUserName=" + ToUserName + ", FromUserName="
				+ FromUserName + ", CreateTime=" + CreateTime + ", MsgType="
				+ MsgType + "]";
	}

}
