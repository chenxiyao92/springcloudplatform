package com.cxyhome.top.demoservicecompose.api;

import com.cxyhome.top.demoserviceapi.api.DemoServiceApi;
import com.cxyhome.top.demoserviceapi.info.DemoInfo;
import com.cxyhome.top.demoservicecompose.mapper.DemoMapper;
import com.cxyhome.top.demoservicecompose.util.Entity2Info;
import com.cxyhome.top.demoservicecompose.util.Info2Entity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DemoServiceApiImpl implements DemoServiceApi
{

	@Resource
	private DemoMapper demoMapper;

	@Override
	public List<DemoInfo> findAll ()
	{
		return Entity2Info.demo(demoMapper.findAll());
	}

	@Override
	public DemoInfo getDemoByCode (String code)
	{
		return Entity2Info.demo(demoMapper.getDemoByCode(code));
	}

	@Override
	public void addDemo (DemoInfo demoInfo)
	{
		demoMapper.save(Info2Entity.demo(demoInfo));
	}

	@Override
	public void delDemo (DemoInfo demoInfo)
	{
		demoMapper.delete(demoInfo.getId());
	}

	@Override
	public void modifyDemo (DemoInfo demoInfo)
	{
		demoMapper.update(Info2Entity.demo(demoInfo));
	}
}
