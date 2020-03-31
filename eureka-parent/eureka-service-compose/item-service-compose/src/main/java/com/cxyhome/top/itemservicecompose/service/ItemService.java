package com.cxyhome.top.itemservicecompose.service;

import com.cxyhome.top.microserviceitem.info.Item;
import org.springframework.stereotype.Service;

public interface ItemService {

    Item queryItemById(String id);
}
