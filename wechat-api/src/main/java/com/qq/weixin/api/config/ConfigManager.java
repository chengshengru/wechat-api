package com.qq.weixin.api.config;

import java.net.URL;
import java.util.Properties;

public class ConfigManager {

	private Properties mProperties;

	private static ConfigManager mInstance = null;

	private ConfigManager() {
		Properties properties = new Properties();
		try {
			URL url = ConfigManager.class.getClassLoader().getResource(
					"wechat.properties");
			properties.load(url.openStream());
			mProperties = properties;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Cannot Find wechat.properties in CLASSPATH");
		}
	}

	public static ConfigManager getInstance() {
		if (mInstance == null) {
			mInstance = new ConfigManager();
		}
		return mInstance;
	}

    /**
     * 开发者AppID
     * @return
     */
	public String getAppId() {
		if (mProperties != null) {
			return mProperties.getProperty("wechat.api.appid", null);
		}
		return null;
	}

    /**
     * 开发者AppSecret
     * @return
     */
	public String getAppSecret() {
		if (mProperties != null) {
			return mProperties.getProperty("wechat.api.appsecret", null);
		}
		return null;
	}

    /**
     * 与微信服务器对接的Token
     * @return
     */
	public String getToken() {
		if (mProperties != null) {
			return mProperties.getProperty("wechat.api.token", null);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T extends Object> T getProperty(String key) {
		if (mProperties != null) {
			return (T) mProperties.get(key);
		}
		return null;
	}


    /**
     * 授权回调地址
     * @return
     */
	public String getOAuthUrl(){
		if (mProperties != null) {
			return mProperties.getProperty("wechat.oauth.url", null);
		}
		return null;
	}

    /**
     * 公众号群发助手的微信号，为mphelper
     * @return
     */
    public String getWechatHelper(){
        if (mProperties != null) {
            return mProperties.getProperty("wechat.mp.helper", "mphelper");
        }
        return "mphelper";
    }


    public String getResponseTemplateDir(){
        if (mProperties!=null){
            return mProperties.getProperty("wechat.template.dir","");
        }
        return "";
    }


    public String getServerHost(){
        if (mProperties!=null){
            return mProperties.getProperty("system.server.host","");
        }
        return "";
    }
}
