package com.cxyhome.top.demoserviceapi.api;

import com.cxyhome.top.demoserviceapi.info.DemoInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface DemoServiceApi
{

	@GetMapping
	List<DemoInfo> findAll();

	@GetMapping("/{code}")
	DemoInfo getDemoByCode(@PathVariable("code") String code);

	@PutMapping
	void addDemo(@RequestBody DemoInfo demoInfo);

	@DeleteMapping
	void delDemo(@RequestBody DemoInfo demoInfo);

	@PostMapping
	void modifyDemo(@RequestBody DemoInfo demoInfo);

}
