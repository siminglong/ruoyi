package com.ruoyi.web.service.ipml;

import com.ruoyi.web.domain.Order;
import com.ruoyi.web.domain.OrderItem;
import com.ruoyi.web.mapper.OrderItemMapper;
import com.ruoyi.web.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<Order> orderItemlist() {
        return orderItemMapper.orderItemlist();
    }

    @Override
    public int deleteOrder(Integer id) {
        return orderItemMapper.deleteOrder(id);
    }

    @Override
    public int deleteOrderProduct(Integer oid, Integer pid) {
        return orderItemMapper.deleteOrderProduct(oid, pid);
    }

    @Override
    public int update(Integer id, Integer number, String code) {
        return orderItemMapper.update(id, number, code);
    }
}
