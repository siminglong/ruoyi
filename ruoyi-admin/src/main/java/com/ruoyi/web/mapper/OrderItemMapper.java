package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.Order;
import com.ruoyi.web.domain.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    public List<Order> orderItemlist();
    public int deleteOrder(Integer id);
    public int deleteOrderProduct(@Param("oid")Integer oid, @Param("pid") Integer pid);
    public int update(@Param("id") Integer id,@Param("number") Integer number,@Param("code") String code);
}
