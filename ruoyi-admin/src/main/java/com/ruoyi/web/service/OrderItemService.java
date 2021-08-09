package com.ruoyi.web.service;

import com.ruoyi.web.domain.Order;
import com.ruoyi.web.domain.OrderItem;

import java.util.List;

public interface OrderItemService {
    public List<Order> orderItemlist();
    public int deleteOrder(Integer id);
    public int deleteOrderProduct(Integer oid,Integer pid);
    public int update(Integer id,Integer number,String code);
}
