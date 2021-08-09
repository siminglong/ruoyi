package com.ruoyi.web.service.ipml;

import com.ruoyi.web.domain.Order;
import com.ruoyi.web.domain.OrderItem;
import com.ruoyi.web.mapper.OrderMapper;
import com.ruoyi.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> orderlist() {
        return orderMapper.orderlist();
    }

    @Override
    public Order getOrder(Integer id) {
        return orderMapper.getOrder(id);
    }

    @Override
    public Order newOrder() {
        return orderMapper.newOrder();
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    @Override
    public int insertOrder1(String code) {
        return orderMapper.insertOrder1(code);
    }

    @Override
    public int insertOrder2(Integer oid, Integer pid, Integer number) {
        return orderMapper.insertOrder2(oid,pid,number);
    }
}
