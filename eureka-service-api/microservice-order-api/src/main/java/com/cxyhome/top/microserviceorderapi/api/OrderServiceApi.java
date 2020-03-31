package com.cxyhome.top.microserviceorderapi.api;


import com.cxyhome.top.microserviceorderapi.info.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface OrderServiceApi {

    @GetMapping(value = "order/{orderId}")
    public Order queryOrderById(@PathVariable("orderId") String orderId) ;


}
