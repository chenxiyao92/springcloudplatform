package com.cxyhome.top.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 下拉信息
 *
 * @author fq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DropDownInfo implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = -8523119844895070917L;
	//id
	private String id;
	//code值
	private String code;
	//属性值
	private String name;

}
