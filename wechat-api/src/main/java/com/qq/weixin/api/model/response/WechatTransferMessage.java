package com.qq.weixin.api.model.response;

import com.qq.weixin.api.model.BaseMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 转接到多客服系统
 * @author chengshengru
 *
 */
@XStreamAlias("xml")
public class WechatTransferMessage extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WechatTransferMessage() {
		MsgType=WX_MSG_TYPE_TRANSFER;
	}

	
}
