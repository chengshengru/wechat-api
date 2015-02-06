package com.qq.weixin.api.annotation;

import java.lang.annotation.*;

/**
 * Created by 程胜儒 on 2015/2/5.
 */
@Target({ ElementType.METHOD , ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WechatFilter {
}
