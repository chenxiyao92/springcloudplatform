package com.cxyhome.top.orderservicecompose.mapper;

import com.cxyhome.top.microserviceorderapi.info.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

	Order queryItemById(String id);
}
