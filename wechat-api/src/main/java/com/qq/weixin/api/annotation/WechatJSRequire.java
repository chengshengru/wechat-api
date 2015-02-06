package com.qq.weixin.api.annotation;

import java.lang.annotation.*;


@Target({ ElementType.METHOD , ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WechatJSRequire {
}
