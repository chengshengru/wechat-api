package com.qq.weixin.api.model.message;

import com.qq.weixin.api.model.BaseMessage;

public abstract class BaseWechatMessage extends BaseMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long MsgId;

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}

}
