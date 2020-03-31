package com.cxyhome.top.itemservicecompose.api;

import com.cxyhome.top.itemservicecompose.service.ItemService;
import com.cxyhome.top.microserviceitem.api.ItemServiceApi;
import com.cxyhome.top.microserviceitem.info.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.soap.Addressing;
import java.util.HashMap;
import java.util.Map;


@RestController
public class ItemServiceApiImpl implements ItemServiceApi {

	@Autowired
	private ItemService itemService;

	@Override
	public Item queryItemById(String id) {
		return itemService.queryItemById(id);
	}
}
