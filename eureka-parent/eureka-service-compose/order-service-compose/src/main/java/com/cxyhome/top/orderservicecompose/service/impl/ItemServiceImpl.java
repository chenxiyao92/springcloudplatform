package com.cxyhome.top.orderservicecompose.service.impl;

import com.cxyhome.top.microserviceitem.info.Item;
import com.cxyhome.top.orderservicecompose.feign.ItemFeignClient;
import com.cxyhome.top.orderservicecompose.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;


@Service
public class ItemServiceImpl implements ItemService {

    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Resource(name = "myRestTemplate")
    private RestTemplate restTemplate;

    @Autowired
    private ItemFeignClient itemFeignClient;

    /**
     * 使用@LoadBanlance的restTemplate
     *  海鲜
     */
    @Override
    //不在方法上使用@HystrixCommand注解
    //一般在实际开发中fallback 方法不会直接写在接口方法所在类里，那样太杂乱
    //@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")
    public Item queryItemById(Long id) {
        //使用eureka代替硬编码
//        return this.restTemplate.getForObject("http://127.0.0.1:9111/item/"
//                + id, Item.class);
        //改造2
//        String itemUrl = "http://item-service-compose/item/{id}";
//        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
//        System.out.println("订单系统调用商品服务,result:" + result);
//        return result;
        //改造3
        System.out.println("调用接口查询");
        //如果报错直接会返回 fail的方法
        Item result = itemFeignClient.queryItemById(id);
        System.out.println("===========HystrixCommand queryItemById-线程池名称：" + Thread.currentThread().getName() + "订单系统调用商品服务,result:" + result);
        return result;
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     *  获取所有实例, 自己选择一个实例完成
     */
//    public Item queryItemById(Long id) {
//
//        String serviceId = "item-service-compose";
//        List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
//        if(instances.isEmpty()){
//            return null;
//        }
//        // 为了演示，在这里只获取第一个实例
//        ServiceInstance serviceInstance = instances.get(0);
//        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
//        return this.restTemplate.getForObject("http://" + url + "/item/" + id, Item.class);
//    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    /**
     * 第三种使用loadbanler来实现负载均衡
     *
     */
//    @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")
//    public Item queryItemById(Long id) {
//        String serviceId = "item-service-compose";
//        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
//        if(serviceInstance ==null){
//            return null;
//        }
//        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
//        System.out.println("获取服务的url:"+url);
//        return this.restTemplate.getForObject("http://" + url + "/item/" + id, Item.class);
//    }

    /**
     * 请求失败执行的方法
     * fallbackMethod的方法参数个数类型要和原方法一致
     *
     * @param id
     * @return
     */
    public Item queryItemByIdFallbackMethod(Long id) {
        return new Item(id, "查询商品信息出错!", null, null, null);
    }




}
