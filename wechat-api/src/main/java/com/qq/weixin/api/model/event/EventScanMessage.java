package com.qq.weixin.api.model.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class EventScanMessage extends BaseEventMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String EventKey;

	private String Ticket;

	public EventScanMessage() {
		super();
		Event = WX_MSG_TYPE_EVENT_SCAN;
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
		return "WechatEventScanMsg [EventKey=" + EventKey + ", Ticket="
				+ Ticket + ", Event=" + Event + ", ToUserName=" + ToUserName
				+ ", FromUserName=" + FromUserName + ", CreateTime="
				+ CreateTime + ", MsgType=" + MsgType + "]";
	}

}
