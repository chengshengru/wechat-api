package com.qq.weixin.api.annotation;

import java.lang.annotation.*;

/**
 *
 * 过滤无需微信授权也可访问的页面
 *
 */
@Target({ ElementType.METHOD , ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WechatFilter {
}
