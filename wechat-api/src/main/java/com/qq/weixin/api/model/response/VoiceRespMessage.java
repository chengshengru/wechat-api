package com.qq.weixin.api.model.response;

import com.qq.weixin.api.model.BaseMessage;
import com.qq.weixin.api.model.Voice;

public class VoiceRespMessage extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Voice Voice;

	public VoiceRespMessage() {
		super();
		MsgType = WX_MSG_TYPE_VOICE;
	}

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}

}
