package com.qq.weixin.api.model.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class EventLocationMessage extends BaseEventMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double Latitude;

	private Double Longitude;

	private Double Precision;

	public EventLocationMessage() {
		super();
		Event = WX_MSG_TYPE_EVENT_LOCATION;
	}

	public Double getLatitude() {
		return Latitude;
	}

	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}

	public Double getPrecision() {
		return Precision;
	}

	public void setPrecision(Double precision) {
		Precision = precision;
	}

	@Override
	public String toString() {
		return "EventLocationMessage [Latitude=" + Latitude + ", Longitude="
				+ Longitude + ", Precision=" + Precision + ", Event=" + Event
				+ ", ToUserName=" + ToUserName + ", FromUserName="
				+ FromUserName + ", CreateTime=" + CreateTime + ", MsgType="
				+ MsgType + "]";
	}

}
