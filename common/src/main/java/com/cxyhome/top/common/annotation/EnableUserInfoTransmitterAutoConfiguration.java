package com.cxyhome.top.common.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * EanbleUserInfoTransmitter 配置类
 */
@Configuration
public class EnableUserInfoTransmitterAutoConfiguration
{
	@Bean
	public TransmitUserInfoFeighClientIntercepter transmitUserInfo2FeighHttpHeader ()
	{
		return new TransmitUserInfoFeighClientIntercepter();
	}

	@Bean
	public TransmitUserInfoFilter transmitUserInfoFromHttpHeader ()
	{
		return new TransmitUserInfoFilter();
	}
}
