package com.cxyhome.top.common.annotation;


import com.alibaba.fastjson.JSON;
import com.cxyhome.top.common.constant.IBaseConstant;
import com.cxyhome.top.common.result.LoginInfo;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * feign 远程调用拦截
 */
@Slf4j
public class TransmitUserInfoFeighClientIntercepter implements RequestInterceptor
{
	@Override
	public void apply (RequestTemplate requestTemplate)
	{
		//从应用上下文中取出user信息，放入Feign的请求头中
		LoginInfo user = UserInfoContext.getUser();
		if (user != null)
		{
			try
			{
				String userJson = JSON.toJSONString(user);
				requestTemplate.header(IBaseConstant.Login.LOGIN_HEADER_KEY, new String[]{URLDecoder.decode(userJson, IBaseConstant.Public.CHARSET_UTF8)});
			} catch (UnsupportedEncodingException e)
			{
				log.error(IBaseConstant.Login.EXCEPTION_LOGIN_INFO, e);
			}
		}
	}
}