package com.cxyhome.top.orderservicecompose.service;

import com.cxyhome.top.microserviceitem.info.Item;
import com.cxyhome.top.microserviceorderapi.info.Order;

public interface OrderService {

    Order queryOrderById(String id);
}
