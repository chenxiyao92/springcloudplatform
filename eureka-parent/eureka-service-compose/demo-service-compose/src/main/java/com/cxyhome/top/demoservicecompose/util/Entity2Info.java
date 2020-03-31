package com.cxyhome.top.demoservicecompose.util;


import com.cxyhome.top.common.valiadator.CollectionValidator;
import com.cxyhome.top.demoserviceapi.info.DemoInfo;
import com.cxyhome.top.demoservicecompose.entity.Demo;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity2Info
{
	/**
	 * 私有化构造方法
	 */
	private Entity2Info ()
	{
	}

	public static List<DemoInfo> demo (List<Demo> demoList)
	{
		List<DemoInfo> infoList = new ArrayList<>();
		if (CollectionValidator.isNotEmpty(demoList))
		{
			for (Demo entity : demoList)
			{
				infoList.add(demo(entity));
			}
		}
		return infoList;
	}

	public static DemoInfo demo (Demo demo)
	{
		DemoInfo info = new DemoInfo();
		if (demo != null)
		{
			info.setId(demo.getDemoId());
			info.setCode(demo.getCode());
			info.setName(demo.getName());
		}
		return info;
	}
}
