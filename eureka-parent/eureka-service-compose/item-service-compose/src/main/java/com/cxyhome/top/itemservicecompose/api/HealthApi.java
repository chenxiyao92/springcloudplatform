package com.cxyhome.top.itemservicecompose.api;

import com.cxyhome.top.common.constant.IBaseConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthApi
{
	@GetMapping("/health")
	public String health ()
	{
		return IBaseConstant.Health.RETURN_STRING;
	}
}
