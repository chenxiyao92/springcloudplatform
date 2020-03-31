package com.cxyhome.top.common.annotation;


import com.cxyhome.top.common.result.LoginInfo;

public class UserInfoContext
{
	private static ThreadLocal<LoginInfo> userInfo = new ThreadLocal<>();

	public UserInfoContext ()
	{
	}

	public static LoginInfo getUser ()
	{
		return userInfo.get();
	}

	public static void setUser (LoginInfo user)
	{
		userInfo.set(user);
	}
}
