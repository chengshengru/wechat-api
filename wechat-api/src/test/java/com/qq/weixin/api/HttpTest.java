package com.qq.weixin.api;

import com.qq.weixin.api.network.WechatHttpUtils;

import junit.framework.TestCase;

public class HttpTest extends TestCase {

	
	
	public void test(){
		
		try {
			String result=WechatHttpUtils.get("http://tiku.exueda.com/question/1141051.html");
		
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
