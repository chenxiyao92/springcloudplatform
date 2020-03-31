package com.cxyhome.top.demoservicecompose.util;


import com.cxyhome.top.demoserviceapi.info.DemoInfo;
import com.cxyhome.top.demoservicecompose.entity.Demo;

public abstract class Info2Entity
{
	private Info2Entity ()
	{
	}

	public static Demo demo (DemoInfo info)
	{
		Demo entity = new Demo();
		entity.setDemoId(info.getId());
		entity.setCode(info.getCode());
		entity.setName(info.getName());
		return entity;
	}
}
