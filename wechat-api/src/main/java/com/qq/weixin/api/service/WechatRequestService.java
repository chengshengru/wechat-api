package com.qq.weixin.api.service;

import com.qq.weixin.api.WechatConstant;
import com.qq.weixin.api.cache.MemoryTokenCache;
import com.qq.weixin.api.cache.TokenCacheAware;
import com.qq.weixin.api.config.ConfigManager;
import com.qq.weixin.api.model.*;
import com.qq.weixin.api.network.WechatHttpUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class WechatRequestService {


    private static WechatRequestService mInstance = null;

    private TokenCacheAware mCacheAware = null;


    private WechatRequestService() {

    }

    public static synchronized WechatRequestService getInstance() {
        if (mInstance == null) {
            mInstance = new WechatRequestService();
        }
        return mInstance;
    }


    public void setTokenCacheAware(TokenCacheAware aware) {
        mCacheAware = aware;
    }

    private TokenCacheAware getCacheAware() {
        if (mCacheAware == null) {
            mCacheAware = new MemoryTokenCache();
        }
        return mCacheAware;
    }

    /**
     * 获取AccessToken
     *
     * @return
     */
    public AccessToken getAccessToken() throws Exception {
        TokenCacheAware aware = getCacheAware();
        AccessToken token = aware.getAccessToken(TokenCacheAware.ACCESS_TOKEN);
        if (token == null) {
            String result = WechatHttpUtils.getWechat(String.format(
                    WechatConstant.WX_GET_TOKEN_URL, ConfigManager.getInstance().getAppId(),
                    ConfigManager.getInstance().getAppSecret()));
            JSONObject obj = JSONObject.fromObject(result);
            token = new AccessToken();
            token.setAccess_token(obj.optString("access_token", null));
            token.setExpires_in(obj.optLong("expires_in", 7200));
            aware.handleAccessToken(TokenCacheAware.ACCESS_TOKEN, token);
        }
        return token;
    }

    /**
     * 获取Token
     *
     * @return
     */
    public String getWechatToken() throws Exception {
        AccessToken token = getAccessToken();
        if (token != null) {
            return token.getAccess_token();
        }
        return null;
    }


    /**
     * 获取JS-SDK Ticket
     *
     * @return
     */
    public String getJsTicket() throws Exception {
        TokenCacheAware aware = getCacheAware();
        AccessToken ticket = aware.getAccessToken(TokenCacheAware.JS_TICKET);
        if (ticket == null) {
            String result = WechatHttpUtils
                    .getWechat(String.format(WechatConstant.WX_JS_TICKET_URL
                            , getWechatToken()));
            JSONObject obj = JSONObject.fromObject(result);
            ticket = new AccessToken();
            ticket.setAccess_token(obj.optString("access_token", null));
            ticket.setExpires_in(obj.optLong("expires_in", 7200));
            aware.handleAccessToken(TokenCacheAware.JS_TICKET, ticket);
        }
        return ticket.getAccess_token();
    }


    /**
     * 创建微信分组
     *
     * @param name:分组名
     * @return
     */
    public WechatGroup createWechatGroup(String name) throws Exception {
        if (StringUtils.isNotEmpty(name)) {
            String token = getWechatToken();
            JSONObject obj = new JSONObject();
            JSONObject group = new JSONObject();
            group.put("name", name);
            obj.put("group", group);
            String result = WechatHttpUtils.postWechat(
                    String.format(WechatConstant.WX_CREATE_GROUP_URL, token), obj.toString());
            obj = JSONObject.fromObject(result);
            obj = obj.getJSONObject("group");
            return new WechatGroup(obj.optLong("id", -1), obj.optString("name",
                    ""));

        }
        return null;
    }

    /**
     * 获取微信分组
     *
     * @return
     * @throws Exception
     */
    public List<WechatGroup> getWechatGroups() throws Exception {
        String token = getWechatToken();
        String result = WechatHttpUtils
                .getWechat(String.format(WechatConstant.WX_GET_GROUP_URL, token));
        JSONObject obj = JSONObject.fromObject(result);
        JSONArray groups = obj.getJSONArray("groups");
        if (groups != null && groups.size() > 0) {
            ArrayList<WechatGroup> list = new ArrayList<WechatGroup>();
            WechatGroup group = null;
            for (int i = 0; i < groups.size(); i++) {
                obj = groups.getJSONObject(i);
                group = new WechatGroup(obj.optLong("id", -1),
                        obj.optString("name"));
                group.setCount(obj.optLong("count", 0));
                list.add(group);
            }
            return list;
        }
        return null;
    }

    /**
     * 获取用户所在的分组
     *
     * @param openId 用户OpenId
     * @return
     * @throws Exception
     */
    public WechatGroup getGroupByOpenId(String openId) throws Exception {
        String token = getWechatToken();
        String result = WechatHttpUtils
                .getWechat(String.format(WechatConstant.WX_GET_GROUP_URL, token));
        JSONObject obj = JSONObject.fromObject(result);
        WechatGroup group = new WechatGroup();
        group.setId(obj.optLong("groupid", -1));
        return group;
    }

    /**
     * 更新微信分组信息
     *
     * @param group
     * @return
     * @throws Exception
     */
    public boolean updateWechatGroup(WechatGroup group) throws Exception {
        if (group != null) {
            String token = getWechatToken();
            JSONObject obj = new JSONObject();
            obj.put("id", group.getId());
            obj.put("name", group.getName());
            String result = WechatHttpUtils.postWechat(
                    String.format(WechatConstant.WX_UPDATE_GROUP_URL, token),
                    obj.toString());
            if (result != null && result.contains("ok")) {
                return true;
            }
        }
        return false;
    }


    /**
     * 更新用户所在的分组
     *
     * @param openId  用户微信OpenId
     * @param groupId 微信分组Id
     * @return
     * @throws Exception
     */
    public boolean updateUserWechatGroup(String openId, Long groupId) throws Exception {
        if (!StringUtils.isEmpty(openId) && groupId != null) {
            String token = getWechatToken();
            JSONObject obj = new JSONObject();
            obj.put("openid", openId);
            obj.put("to_groupid", groupId);
            String result = WechatHttpUtils.postWechat(
                    String.format(WechatConstant.WX_UPDATE_USER_URL, token),
                    obj.toString());
            if (result != null && result.contains("ok")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取微信用户的基本信息
     *
     * @param openId
     * @return
     * @throws Exception
     */
    public WechatUserInfo getWechatUserInfo(String openId) throws Exception {
        if (StringUtils.isNotEmpty(openId)) {
            String result = WechatHttpUtils
                    .getWechat(String.format(WechatConstant.WX_GET_USER_INFO_URL
                            , getWechatToken(), openId));
            JSONObject obj = JSONObject.fromObject(result);
            return new WechatUserInfo(obj);
        }
        return null;
    }

    /**
     * 创建场景二维码Ticket
     *
     * @param id
     * @param time
     * @return
     * @throws Exception
     */
    public WechatQrcodeTicket createQrcodeTicket(long id, int time) throws Exception {
        JSONObject data = new JSONObject();
        if (time <= 0) {
            if (id < 1) {
                throw new RuntimeException("Id Must large than 1");
            } else if (id > 100000) {
                throw new RuntimeException("Id Must less than 100000");
            }
            data.put("action_name", "QR_LIMIT_SCENE");
        } else {
            if (time > 1800) {
                time = 1800;
            }
            data.put("action_name", "QR_SCENE");
            data.put("expire_seconds", time);
        }
        JSONObject info = new JSONObject();
        JSONObject scene = new JSONObject();
        scene.put("scene_id", id);
        info.put("scene", scene);
        data.put("action_info", info);

        String result = WechatHttpUtils.post(
                String.format(WechatConstant.WX_CREATE_QRCODE_URL, getWechatToken()),
                data.toString());
        JSONObject res = JSONObject.fromObject(result);
        WechatQrcodeTicket ticket = new WechatQrcodeTicket();
        ticket.setExpireSeconds(res.optInt("expire_seconds", 0));
        ticket.setTicket(res.getString("ticket"));
        ticket.setUrl(res.getString("url"));
        return ticket;
    }

    /**
     * 长地址转短地址
     *
     * @param longUrl
     * @return
     * @throws Exception
     */
    public String shortUrl(String longUrl) throws Exception {
        if (StringUtils.isNotEmpty(longUrl)) {
            JSONObject request = new JSONObject();
            request.put("action", "long2short");
            request.put("long_url", longUrl);
            String result = WechatHttpUtils.postWechat(
                    String.format(WechatConstant.WX_SHORT_URL, getWechatToken()),
                    request.toString());
            JSONObject res = JSONObject.fromObject(result);
            return res.optString("short_url", null);
        }
        return null;
    }

    /**
     * 根据网页授权后的code获取token
     *
     * @param code
     * @return
     * @throws Exception
     */
    public AccessToken getOAuthToken(String code) throws Exception {
        if (StringUtils.isNotEmpty(code)) {
            String data = WechatHttpUtils
                    .getWechat(String.format(WechatConstant.WX_SNS_OAUTHOR2_URL
                            , ConfigManager.getInstance().getAppId(), ConfigManager.getInstance().getAppSecret(), code));
            JSONObject obj = JSONObject.fromObject(data);
            AccessToken token = new AccessToken();
            token.setAccess_token(obj.optString("access_token"));
            token.setExpires_in(obj.optLong("expires_in"));
            token.setRefresh_token(obj.optString("refresh_token"));
            token.setOpenId(obj.optString("openid"));
            return token;
        }
        return null;
    }

    /**
     * 网页授权获取用户信息
     *
     * @param token  OAuthor Token
     * @param openId User Wechat OpenId
     * @return
     * @throws Exception
     */
    public WechatUserInfo getOAuthUserInfo(String token, String openId) throws Exception {

        if (StringUtils.isNotEmpty(token) && StringUtils.isNotEmpty(openId)) {
            String result = WechatHttpUtils
                    .getWechat(String.format(WechatConstant.WX_SNS_GET_USER_INFO_URL
                            , token, openId));
            JSONObject obj = JSONObject.fromObject(result);
            WechatUserInfo info = new WechatUserInfo(obj);
            return info;
        }
        return null;
    }

    /**
     * 刷新网页授权Token
     *
     * @param refreshToken 刷新Token
     * @return
     * @throws Exception
     */
    public AccessToken refreshOAuthToken(String refreshToken) throws Exception {
        if (StringUtils.isNotEmpty(refreshToken)) {
            String data = WechatHttpUtils
                    .getWechat(String.format(WechatConstant.WX_SNS_REFRESH_USER_TOKEN,
                            ConfigManager.getInstance().getAppId(), refreshToken));
            JSONObject obj = JSONObject.fromObject(data);
            AccessToken token = new AccessToken();
            token.setAccess_token(obj.optString("access_token"));
            token.setExpires_in(obj.optLong("expires_in"));
            token.setRefresh_token(obj.optString("refresh_token"));
            token.setOpenId(obj.optString("openid"));
            return token;
        }
        return null;
    }

    /**
     * 发送模板消息
     *
     * @param template 模板消息
     * @param openId   用户OpenId
     * @return
     * @throws Exception
     */
    public Long sendTemplateMessage(WechatTemplate template, String openId) throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("touser", openId);
        obj.put("template_id", template.getTemplateId());
        List<WechatTemplateItem> data = template.getData();
        if (data != null && data.size() > 0) {
            JSONObject jd = new JSONObject();
            JSONObject item = null;
            for (WechatTemplateItem d : data) {
                if (d != null) {
                    item = new JSONObject();
                    item.put("value", d.getValue());
                    item.put("color", d.getColor());
                    jd.put(d.getKey(), item);
                }
            }
            obj.put("data", jd);
        }
        String result = WechatHttpUtils.postWechat(
                String.format(WechatConstant.WX_SEND_TEMPLATE_URL, getWechatToken()),
                obj.toString());
        JSONObject res = JSONObject.fromObject(result);
        return res.optLong("msgid", -1l);
    }

    /**
     * 发送文本消息
     *
     * @param openId 用户OpenId
     * @param msg    消息内容
     * @throws Exception
     */
    public void sendTextMessage(String openId, String msg) throws Exception {
        if (!StringUtils.isEmpty(openId) && !StringUtils.isEmpty(msg)) {
            JSONObject request = new JSONObject();
            request.put("touser", openId);
            request.put("msgtype", "text");
            JSONObject content = new JSONObject();
            content.put("content", msg);
            request.put("text", content);
            WechatHttpUtils.postWechat(String.format(WechatConstant.WX_SEND_MESSAGE_URL
                    , getWechatToken()), request.toString());

        } else {
            throw new Exception("OpenId(" + openId + ") Or Message(" + msg
                    + ") is NULL!");
        }
    }

    /**
     * 发送图片消息
     *
     * @param openId   用户OpenId
     * @param articles 图文消息
     * @throws Exception
     */
    public void sendNewsMessage(String openId, List<Article> articles) throws Exception {
        if (!StringUtils.isEmpty(openId) && articles != null
                && articles.size() > 0) {

            if (articles.size() > 10) {
                throw new Exception("News' Size() Must less than 10");
            }

            JSONObject request = new JSONObject();
            request.put("touser", openId);
            request.put("msgtype", "news");

            JSONObject news = new JSONObject();

            JSONArray arr = new JSONArray();
            JSONObject item = null;

            for (Article article : articles) {
                if (article != null) {
                    item = new JSONObject();
                    item.put("title", article.getTitle());
                    item.put("description", article.getDescription());
                    item.put("url", article.getUrl());
                    item.put("picurl", article.getPicUrl());
                    arr.add(item);
                }
            }
            news.put("articles", arr);
            request.put("news", news);
            WechatHttpUtils.postWechat(String.format(WechatConstant.WX_SEND_MESSAGE_URL
                    , getWechatToken()), request.toString());

        } else {
            throw new Exception("OpenId(" + openId
                    + ") Or News is NULL or Empty!");
        }
    }


}
