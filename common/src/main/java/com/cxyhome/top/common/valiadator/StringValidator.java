package com.cxyhome.top.common.valiadator;


import com.cxyhome.top.common.constant.IBaseConstant;

/**
 * 字符串 公共校验类
 */
public abstract class StringValidator
{
	/**
	 * 私有化构造方法
	 */
	private StringValidator ()
	{
	}

	public static boolean isEmpty (String key)
	{
		return !isNotEmpty(key);
	}

	public static boolean isNotEmpty (String key)
	{
		return key != null && !IBaseConstant.Public.EMPTY_STRING.equals(key.trim());
	}
}
