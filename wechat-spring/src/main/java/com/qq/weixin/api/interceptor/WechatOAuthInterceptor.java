package com.qq.weixin.api.interceptor;

import com.qq.weixin.api.Session;
import com.qq.weixin.api.SessionCache;
import com.qq.weixin.api.WechatService;
import com.qq.weixin.api.annotation.WechatFilter;
import com.qq.weixin.api.annotation.WechatJSRequire;
import com.qq.weixin.api.annotation.WechatOauth;
import com.qq.weixin.api.config.ConfigManager;
import com.qq.weixin.api.security.WechatSecurity;
import com.qq.weixin.api.service.DefaultWechatService;
import com.qq.weixin.api.service.WechatRequestService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 程胜儒 on 2015/2/5.
 */
public class WechatOAuthInterceptor implements HandlerInterceptor {

    private static final String WX_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";


    @Autowired
    private WechatService wechatService = new DefaultWechatService();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            request.setAttribute("wechat_appid", ConfigManager.getInstance().getAppId());
            boolean isWechat = isWechat(request.getHeader("User-Agent"));
            request.setAttribute("isWechat", isWechat);
            HandlerMethod hm = (HandlerMethod) handler;

            Object bean = hm.getBean();
            Method method = hm.getMethod();
            /**********微信JSSDK校验************/
            WechatJSRequire require = null;
            require = method.getAnnotation(WechatJSRequire.class);
            if (require == null) {
                require = bean.getClass().getAnnotation(WechatJSRequire.class);
            }
            if (require != null && require.required() && isWechat) {
                StringBuffer sb = request.getRequestURL();
                String qs = request.getQueryString();
                if (!StringUtils.isEmpty(qs)) {
                    sb.append("?");
                    sb.append(qs);
                }
                Map<String, String> map = WechatRequestService.getInstance().getJsSign(sb
                        .toString());
                if (map != null) {
                    request.setAttribute("jsapi_map", map);
                }
                request.setAttribute("required_wechat_js", true);
            }


            WechatFilter filter = method.getAnnotation(WechatFilter.class);
            if (filter == null) {
                bean.getClass().getAnnotation(WechatFilter.class);
            }
            if (filter == null) {
                /**********微信授权***************/
                WechatOauth oauth = method.getAnnotation(WechatOauth.class);
                if (oauth == null) {
                    oauth = bean.getClass().getAnnotation(WechatOauth.class);
                }
                if (oauth != null && oauth.required()) {
                    if (wechatService != null) {
                        Session session = wechatService.validateWechat(request, response);
                        if (session != null) {
                            session.setSid(createSessionId());
                            SessionCache.addCache(session);
                            if (session.isOAuth()) {
                                String url = URLEncoder.encode(ConfigManager.getInstance().getOAuthUrl(), "utf-8");
                                response.sendRedirect(getAuthorUrl(oauth.value(), url, session.getSid()));
                                return false;
                            }
                        }

                    }
                }
            }
        }
        return true;
    }


    /**
     * 是否是微信浏览器
     *
     * @param userAgent
     * @return
     */
    private boolean isWechat(String userAgent) {
        if (StringUtils.isNotEmpty(userAgent)) {
            String tmp = userAgent.toLowerCase();
            return tmp.indexOf("micromessenger") > -1;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 拼接请求微信授权URL
     * @param scope 获取用户信息的范围
     * @param url 授权回调URL
     * @param state 带过去的code
     * @return
     */
    private String getAuthorUrl(String scope, String url, String state) {
        return String.format(WX_AUTHORIZE_URL, ConfigManager.getInstance().getAppId(), url, scope, state);
    }

    /**
     * 生成sid
     * @return
     */
    private String createSessionId() {
        return WechatSecurity.encode("MD5", UUID.randomUUID().toString()
                + new Date());
    }

}
