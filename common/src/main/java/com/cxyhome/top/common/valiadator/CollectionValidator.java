package com.cxyhome.top.common.valiadator;

import java.util.Collection;

/**
 * 集合校验类
 */
public abstract class CollectionValidator
{
	/**
	 * 私有化构造方法
	 */
	private CollectionValidator ()
	{
	}

	/**
	 * 判断集合不为空
	 *
	 * @param collection 集合
	 * @return true-不为空;false-为空
	 */
	public static boolean isNotEmpty (Collection collection)
	{
		return !isEmpty(collection);
	}

	/**
	 * 判断集合为空
	 *
	 * @param collection 集合
	 * @return true-为空;false-为空
	 */
	public static boolean isEmpty (Collection collection)
	{
		return collection == null || collection.isEmpty();
	}
}
