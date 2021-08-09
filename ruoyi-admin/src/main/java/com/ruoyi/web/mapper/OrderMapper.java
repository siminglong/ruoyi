package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    public List<Order> orderlist();
    public Order getOrder(Integer id);
    public Order newOrder();
    public int updateOrder(Order order);
    public int insertOrder1(String code);
    public int insertOrder2(@Param("oid") Integer oid, @Param("pid") Integer pid, @Param("number") Integer number);
}
