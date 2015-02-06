package com.qq.weixin.api.network;

import java.security.cert.X509Certificate;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;

@SuppressWarnings("deprecation")
public final class WechatHttpClient {

	private static final Logger log = Logger
			.getLogger(WechatHttpClient.class);

	private static HttpClient mClient = null;

	public final static int MAX_ROUTE_CONNECTIONS = 400; 
	
	public final static int MAX_TOTAL_CONNECTIONS = 800; 
	
	private WechatHttpClient() {

	}

	public static synchronized HttpClient getHttpClient() {
		if (null == mClient) {
			HttpParams params = new BasicHttpParams();
			// 设置一些基本参数
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
			HttpProtocolParams.setUseExpectContinue(params, true);
			HttpProtocolParams
					.setUserAgent(
							params,
							"Mozilla/5.0(Linux;U;Android 2.2.1;en-us;Nexus One Build.FRG83) "
									+ "AppleWebKit/553.1(KHTML,like Gecko) Version/4.0 Mobile Safari/533.1");
			// 超时设置
			/* 从连接池中取连接的超时时间 */
			ConnManagerParams.setTimeout(params, 1000);
			/* 连接超时 */
			HttpConnectionParams.setConnectionTimeout(params, 2000);
			/* 请求超时 */
			HttpConnectionParams.setSoTimeout(params, 4000);
			ConnManagerParams.setMaxTotalConnections(params, MAX_TOTAL_CONNECTIONS);  
			// 设置每个路由最大连接数  
	        ConnPerRouteBean connPerRoute = new ConnPerRouteBean(MAX_ROUTE_CONNECTIONS);  
	        ConnManagerParams.setMaxConnectionsPerRoute(params,connPerRoute); 
			// 设置我们的HttpClient支持HTTP和HTTPS两种模式
			SchemeRegistry schReg = new SchemeRegistry();
			schReg.register(new Scheme("http", 80, PlainSocketFactory
					.getSocketFactory()));
			try {
				TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
					public boolean isTrusted(X509Certificate[] certificate,
							String authType) {
						return true;
					}
				};
				SSLSocketFactory sf = new SSLSocketFactory(
						acceptingTrustStrategy,
						SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
				schReg.register(new Scheme("https", 443, sf));
			} catch (Exception e) {
				log.error("Init HttpClient SSL Error!", e);
			}
			// 使用线程安全的连接管理来创建HttpClient
			ClientConnectionManager conMgr = new ThreadSafeClientConnManager(
					params, schReg);
			mClient = new DefaultHttpClient(conMgr, params);

		}
		return mClient;
	}
}
