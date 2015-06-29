package com.qq.weixin.api.network;

import com.qq.weixin.api.cache.TokenCacheAware;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.qq.weixin.api.exception.HttpRequestException;
import com.qq.weixin.api.exception.InvalidWechatException;

public final class WechatHttpUtils {

	private static final Logger log = Logger.getLogger(WechatHttpUtils.class);

	@SuppressWarnings("deprecation")
	private static final String CHATSET = HTTP.UTF_8;



	private static TokenCacheAware mAware=null;

	/**
	 * POST
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, String data) throws Exception {
		if (!StringUtils.isEmpty(url)) {
			HttpPost post = new HttpPost(url);
			try {
				if (data != null) {
					HttpEntity entity = new StringEntity(data, CHATSET);
					post.setEntity(entity);
				}
				HttpClient client = WechatHttpClient.getHttpClient();
				HttpResponse response = client.execute(post);
				String result = handleResponse(response);
				log.debug(result);
				return result;
			} catch (Exception e) {
				post.abort();
			}
		
			
		}
		return null;
	}

	/**
	 * GET
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String get(String url) throws Exception {
		if (!StringUtils.isEmpty(url)) {
			HttpGet get = new HttpGet(url);
			HttpClient client = WechatHttpClient.getHttpClient();
			HttpResponse response = client.execute(get);
			String result = handleResponse(response);
			log.debug(result);
			return result;
		}
		return null;
	}

	private static String handleResponse(HttpResponse response)
			throws Exception {
		if (response != null) {
			int code = response.getStatusLine().getStatusCode();
			HttpEntity entity=null;
			try {
				if (code == HttpStatus.SC_OK) {
					entity = response.getEntity();
					if (entity != null) {
						return EntityUtils.toString(entity, CHATSET);
					}

				} else {
					throw new HttpRequestException(code, "Request Error:"
							+ response.getStatusLine().getReasonPhrase() + "("
							+ code + ")");

				}
			} catch (Exception e) {
				throw e;
			} finally {
				EntityUtils.consumeQuietly(entity);
			}
		} else {
			throw new Exception("请求失败");
		}
		return null;
	}

	/**
	 * Wechat POST
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String postWechat(String url, String data) throws Exception {
		String result = post(url, data);
		if (!StringUtils.isEmpty(result) && result.contains("errmsg")) {
			JSONObject obj = JSONObject.fromObject(result);
			if (obj.containsKey("errcode")) {
				int code = obj.optInt("errcode", 0);
				if (code != 0) {
					clearToken(code);
					throw new InvalidWechatException(code, obj.optString(
							"errmsg", ""));
				}
			}
		}
		return result;
	}

	/**
	 * Wechat GET
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String getWechat(String url) throws Exception {
		String result = get(url);
		if (!StringUtils.isEmpty(result) && result.contains("errmsg")) {
			JSONObject obj = JSONObject.fromObject(result);
			if (obj.containsKey("errcode")) {
				int code = obj.optInt("errcode", 0);
				if (code != 0) {
					clearToken(code);
					throw new InvalidWechatException(code, obj.optString(
							"errmsg", ""));
				}
			}
		}
		return result;
	}


	/**
	 * 获取HttpEntity对象（多媒体文件下载使用）
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static HttpEntity getHttpEntity(String url) throws Exception{




		return null;
	}


	private static  void clearToken(int code){
		switch (code){
			case 40001:
			case 40002:
				if(mAware!=null){
					try {
						mAware.clearAccessToken(TokenCacheAware.ACCESS_TOKEN);
					}catch (Exception e){
						log.error("Clear Token Error",e);
					}

				}
				break;
		}
	}

	public static void setCacheAware(TokenCacheAware aware){
		mAware=aware;
	}
}
