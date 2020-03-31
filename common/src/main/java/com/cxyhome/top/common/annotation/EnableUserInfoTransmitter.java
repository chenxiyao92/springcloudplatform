package com.cxyhome.top.common.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 传递request header 中的登录信息
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({EnableUserInfoTransmitterAutoConfiguration.class})
public @interface EnableUserInfoTransmitter
{
}