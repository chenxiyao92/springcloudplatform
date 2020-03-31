package com.cxyhome.top.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * ID 生成类
 */
public class IdGenerator
{

	private final static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
			'Z'};

	private final static Map<Character, Integer> digitMap = new HashMap<>();

	static
	{
		for (int i = 0; i < digits.length; i++)
		{
			digitMap.put(digits[i], i);
		}
	}

	/**
	 * 支持的最大进制数
	 */
	private static final int MAX_RADIX = digits.length;

	/**
	 * 支持的最小进制数
	 */
	private static final int MIN_RADIX = 2;

	/**
	 * 将长整型数值转换为指定的进制数（最大支持62进制，字母数字已经用尽）
	 *
	 * @param i     序号
	 * @param radix 精度
	 * @return 字符串
	 */
	private static String toString (long i, int radix)
	{
		if (radix < MIN_RADIX || radix > MAX_RADIX)
			radix = 10;
		if (radix == 10)
			return Long.toString(i);

		final int size = 65;
		int charPos = 64;

		char[] buf = new char[size];
		boolean negative = (i < 0);

		if (!negative)
		{
			i = -i;
		}

		while (i <= -radix)
		{
			buf[charPos--] = digits[(int) (-(i % radix))];
			i = i / radix;
		}
		buf[charPos] = digits[(int) (-i)];

		if (negative)
		{
			buf[--charPos] = '-';
		}

		return new String(buf, charPos, (size - charPos));
	}

	private static String digits (long val, int digits)
	{
		long hi = 1L << (digits << 2);
		return toString(hi | (val & (hi - 1)), MAX_RADIX)
				.substring(1);
	}

	/**
	 * 以62进制（字母加数字）生成19位UUID，最短的UUID
	 *
	 * @return 19位UUID
	 */
	public static String uuid ()
	{
		UUID uuid = UUID.randomUUID();
		long mostSignificantBits = uuid.getMostSignificantBits();
		long leastSignificantBits = uuid.getLeastSignificantBits();
		StringBuilder sb = new StringBuilder();
		sb.append(digits(mostSignificantBits >> 32, 8));
		sb.append(digits(mostSignificantBits >> 16, 4));
		sb.append(digits(mostSignificantBits, 4));
		sb.append(digits(leastSignificantBits >> 48, 4));
		sb.append(digits(leastSignificantBits, 12));
		return sb.toString();
	}

	public static void main (String[] args)
	{
		System.out.println(IdGenerator.uuid());
	}

}
