package com.cxyhome.top.orderservicecompose.feign;

import com.cxyhome.top.microserviceitem.info.Item;
import com.cxyhome.top.orderservicecompose.fallback.ItemServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//这里定义的调用hystrix fallback 熔断的失败的方法
@FeignClient(value = "item-service-compose",fallback = ItemServiceFallback.class)
public interface ItemFeignClient {
    /**
     * 这里定义了类似于SpringMVC用法的方法，就可以进行RESTful方式的调用了
     *  这里定义是请求的发出绒球的URL
     * @param id
     * @return
     */
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    Item queryItemById(@PathVariable("id") Long id);
}