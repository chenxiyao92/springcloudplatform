package com.cxyhome.top.common.constant;

/**
 * 公共常量类
 */
public interface IBaseConstant
{
	/**
	 * 登录信息
	 */
	class Login
	{
		/**
		 * 登录信息中可以值
		 */
		public static final String LOGIN_HEADER_KEY = "KEY_USERINFO_IN_HTTP_HEADER";

		public static final String EXCEPTION_LOGIN_INFO = "登录信息设置失败";
	}

	/**
	 * consul 健康检查
	 */
	class Health
	{
		/**
		 * 检查检查返回值
		 */
		public static final String RETURN_STRING = "hello consul";
	}

	/**
	 * 公共常量
	 */
	class Public
	{
		/**
		 * null 字符串
		 */
		public static final String NULL_STRING = "null";

		/**
		 * 空字符串
		 */
		public static final String EMPTY_STRING = "";

		/**
		 * UTF-8 编码
		 */
		public static final String CHARSET_UTF8 = "UTF-8";
	}
}
