package com.cxyhome.top.common.annotation;

import com.cxyhome.top.common.constant.IBaseConstant;
import com.cxyhome.top.common.result.LoginInfo;
import com.cxyhome.top.common.util.JwtUtil;
import com.cxyhome.top.common.valiadator.StringValidator;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 登录信息对象拦截器
 */
@Slf4j
public class TransmitUserInfoFilter implements Filter
{

	@Override
	public void init (FilterConfig filterConfig)
	{
	}

	@Override
	public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		this.initUserInfo((HttpServletRequest) request);
		chain.doFilter(request, response);
	}

	/**
	 * 从request 的header 中取出登录信息，放入共享线程中
	 *
	 * @param request
	 */
	private void initUserInfo (HttpServletRequest request)
	{
		String userJson = request.getHeader(IBaseConstant.Login.LOGIN_HEADER_KEY);
		if (StringValidator.isNotEmpty(userJson))
		{
			try
			{
				userJson = URLDecoder.decode(userJson, IBaseConstant.Public.CHARSET_UTF8);
                LoginInfo userInfo = JwtUtil.parseJWTToLogininfo(userJson);
//                LoginInfo userInfo = JSON.parseObject(userJson, LoginInfo.class);
				//将UserInfo放入上下文中
				UserInfoContext.setUser(userInfo);
			} catch (UnsupportedEncodingException e)
			{
				log.error(IBaseConstant.Login.EXCEPTION_LOGIN_INFO, e);
			}
		}
	}

	@Override
	public void destroy ()
	{
	}
}
