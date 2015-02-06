package com.qq.weixin.api.model.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 语音消息
 * 
 * @author chengshengru
 *
 */
@XStreamAlias("xml")
public class VoiceMessage extends BaseWechatMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String MediaId;

	private String Format;

	/**
	 * 识别结果
	 */
	private String Recognition;

	public VoiceMessage() {
		MsgType = WX_MSG_TYPE_VOICE;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	@Override
	public String toString() {
		return "WechatVoiceMsg [MediaId=" + MediaId + ", Format=" + Format
				+ ", MsgType=" + MsgType + "]";
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

}
