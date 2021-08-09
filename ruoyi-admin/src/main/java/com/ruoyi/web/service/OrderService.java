package com.ruoyi.web.service;

import com.ruoyi.web.domain.Order;

import java.util.List;

public interface OrderService {
    //查询order
    public List<Order> orderlist();
    public Order getOrder(Integer id);
    public Order newOrder();
    public int updateOrder(Order order);
    public int insertOrder1(String code);
    public int insertOrder2(Integer oid, Integer pid, Integer number);
}
