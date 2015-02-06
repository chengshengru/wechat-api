package com.qq.weixin.api;

public final class WechatConstant {

	public static final String WX_API_URL = "https://api.weixin.qq.com";
	/**
	 * 微信api地址
	 */
	public static final String WX_API_SERVICE_URL = WX_API_URL + "/cgi-bin";

	public static final String WX_GET_TOKEN_URL = WX_API_SERVICE_URL
			+ "/token?grant_type=client_credential&appid=%s&secret=%s";
	/**
	 * 创建分组
	 */
	public static final String WX_CREATE_GROUP_URL = WX_API_SERVICE_URL
			+ "/groups/create?access_token=%s";
	/**
	 * 获取分组
	 */
	public static final String WX_GET_GROUP_URL = WX_API_SERVICE_URL
			+ "/groups/get?access_token=%s";

	/**
	 * 查询用户所在分组
	 */
	public static final String WX_GET_USER_GROUP_URL = WX_API_SERVICE_URL
			+ "/groups/getid?access_token=%s";

	/**
	 * 修改分组名
	 */
	public static final String WX_UPDATE_GROUP_URL = WX_API_SERVICE_URL
			+ "/groups/update?access_token=%s";

	/**
	 * 移动用户分组
	 */
	public static final String WX_UPDATE_USER_URL = WX_API_SERVICE_URL
			+ "/groups/members/update?access_token=%s";

	/**
	 * 获取用户的信息
	 */
	public static final String WX_GET_USER_INFO_URL = WX_API_SERVICE_URL
			+ "/user/info?access_token=%s&openid=%s&lang=zh_CN";

	/**
	 * 获取关注者列表
	 */
	public static final String WX_GET_USERS_URL = WX_API_SERVICE_URL
			+ "/user/get?access_token=";

	/**
	 * 创建二维码Ticket
	 */
	public static final String WX_CREATE_QRCODE_URL = WX_API_SERVICE_URL
			+ "/qrcode/create?access_token=%s";

	public static final String WX_SEND_MESSAGE_URL = WX_API_SERVICE_URL
			+ "/message/custom/send?access_token=%s";

	/**
	 * 短码
	 */
	public static final String WX_SHORT_URL = WX_API_SERVICE_URL
			+ "/shorturl?access_token=%s";

	public static final String WX_API_SNS_URL = WX_API_URL + "/sns";

	/**
	 * OAuth2 授权地址
	 */
	public static final String WX_SNS_OAUTHOR2_URL = WX_API_SNS_URL
			+ "/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

	/**
	 * 网页授权获取用户信息
	 */
	public static final String WX_SNS_GET_USER_INFO_URL = WX_API_URL
			+ "/userinfo?access_token=%s&openId=%s";

	/**
	 * 刷新用户Token
	 */
	public static final String WX_SNS_REFRESH_USER_TOKEN = WX_API_SNS_URL
			+ "/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";

	public static final String WX_API_MEDIA_URL = WX_API_URL + "/media";

	/**
	 * 上传图文消息素材【订阅号与服务号认证后均可用】
	 */
	public static final String WX_UPLOAD_MEDIA_URL = WX_API_MEDIA_URL
			+ "/uploadnews?access_token=";

	public static final String WX_API_MESSAGE_MASS_URL = WX_API_URL
			+ "/message/mass";

	/**
	 * 根据分组进行群发【订阅号与服务号认证后均可用】
	 */
	public static final String WX_MESSAGE_SEND_ALL_URL = WX_API_MESSAGE_MASS_URL
			+ "/sendall?access_token=";
	/**
	 * 删除群发【订阅号与服务号认证后均可用】
	 */
	public static final String WX_MESSAGE_DELETE_URL = WX_API_MESSAGE_MASS_URL
			+ "/sendall?access_token=";
	/**
	 * 预览接口【订阅号与服务号认证后均可用】
	 */
	public static final String WX_MESSAGE_PREVIEW_URL = WX_API_MESSAGE_MASS_URL
			+ "/preview?access_token=";

	/**
	 * 查询群发消息发送状态【订阅号与服务号认证后均可用】
	 */
	public static final String WX_MESSAGE_GET_STATUS_URL = WX_API_MESSAGE_MASS_URL
			+ "/get?access_token=";


    /**
     * JSSDK Ticket
     */
    public static final String WX_JS_TICKET_URL=WX_API_SERVICE_URL+"/ticket/getticket?type=jsapi&access_token=%s";
    /**
     * 模板消息发送
     */
    public static final String WX_SEND_TEMPLATE_URL=WX_API_SERVICE_URL+"/message/template/send?access_token=%s";


}
