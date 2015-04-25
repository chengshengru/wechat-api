package com.qq.weixin.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD , ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WechatOauth {
    /**
     * Scope 应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo
     * （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
     *
     * @return
     */
    String value() default "snsapi_base";
    /**
     * 是否需要授权
     * @return
     */
    boolean required() default true;
    /**
     * 传给微信参数
     * @return
     */
    String state() default "";

    /**
     * 微信页面回调地址
     * @return
     */
    String callback() default "";
    /**
     * 是否强制要授权(可以用来只有微信才能访问功能)
     * @return
     */
    boolean force() default false;
}
