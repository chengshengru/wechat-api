package com.qq.weixin.api.service;

import com.qq.weixin.api.model.WechatResponse;

import java.util.List;


public interface IWechatResponseService {
	
	WechatResponse getResponseByKey(String key);
	
	/**
	 * 获取所有的自动回复消息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<WechatResponse> getAllResponse(int page, int pageSize);
	
	/**
	 * 添加自动回复消息
	 * @param res
	 * @return
	 */
	Integer addWechatResponse(WechatResponse res);
	
	/**
	 * 更新回复消息
	 * @param res
	 * @return
	 */
	Integer updateWechatResponse(WechatResponse res);
	
	
}
