package com.qq.weixin.api.model.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 地理位置消息
 * 
 * @author chengshengru
 *
 */
@XStreamAlias("xml")
public class LocationMessage extends BaseWechatMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double Location_X;

	private Double Location_Y;

	private Integer Scale;

	private String Label;

	
	
	public LocationMessage() {
		MsgType=WX_MSG_TYPE_LOCATION;
	}

	public Double getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(Double location_X) {
		Location_X = location_X;
	}

	public Double getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(Double location_Y) {
		Location_Y = location_Y;
	}

	public Integer getScale() {
		return Scale;
	}

	public void setScale(Integer scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	@Override
	public String toString() {
		return "WechatLocationMsg [Location_X=" + Location_X + ", Location_Y="
				+ Location_Y + ", Scale=" + Scale + ", Label=" + Label + "]";
	}

	
	
}
