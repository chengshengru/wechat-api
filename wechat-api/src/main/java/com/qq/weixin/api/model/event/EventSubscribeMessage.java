package com.qq.weixin.api.model.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class EventSubscribeMessage extends BaseEventMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String EventKey;

	private String Ticket;

	public boolean isSubscribe() {
		return BaseEventMessage.WX_MSG_TYPE_EVENT_SUBSCRIBE
				.equalsIgnoreCase(Event);
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	@Override
	public String toString() {
		return "EventSubscribeMessage [EventKey=" + EventKey + ", Ticket="
				+ Ticket + ", Event=" + Event + ", ToUserName=" + ToUserName
				+ ", FromUserName=" + FromUserName + ", CreateTime="
				+ CreateTime + ", MsgType=" + MsgType + "]";
	}

	
}
