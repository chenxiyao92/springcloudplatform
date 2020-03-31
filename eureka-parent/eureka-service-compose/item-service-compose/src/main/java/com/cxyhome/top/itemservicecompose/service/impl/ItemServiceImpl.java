package com.cxyhome.top.itemservicecompose.service.impl;

import com.cxyhome.top.itemservicecompose.mapper.ItemMapper;
import com.cxyhome.top.itemservicecompose.service.ItemService;
import com.cxyhome.top.microserviceitem.info.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Item queryItemById(String id) {
        System.out.println("调用item的服务查询服务");
        return itemMapper.queryItemById(id);
    }
}
