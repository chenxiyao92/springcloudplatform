package com.cxyhome.top.microserviceitem.api;


import com.cxyhome.top.microserviceitem.info.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface ItemServiceApi {

	@GetMapping("/item/{id}")
	 Item queryItemById(@PathVariable("id") String id);

}
