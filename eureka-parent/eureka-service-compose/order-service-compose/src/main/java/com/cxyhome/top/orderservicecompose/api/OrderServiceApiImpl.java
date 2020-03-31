package com.cxyhome.top.orderservicecompose.api;

import com.cxyhome.top.microserviceitem.info.Item;
import com.cxyhome.top.microserviceorderapi.api.OrderServiceApi;
import com.cxyhome.top.microserviceorderapi.info.Order;
import com.cxyhome.top.orderservicecompose.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderServiceApiImpl implements OrderServiceApi {

	@Autowired
	private OrderService orderService;

	@Override
	public Order queryOrderById(String orderId) {
		return	orderService.queryOrderById(orderId);
	}
}
