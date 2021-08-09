package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="order",description = "订单")
public class  Order {
    @ApiModelProperty("订单ID")
    private Integer id;
    @ApiModelProperty("订单CODE")
    private String code;
    private List<OrderItem> oOrderItemList;

    public List<OrderItem> getoOrderItemList() {
        return oOrderItemList;
    }

    public void setoOrderItemList(List<OrderItem> oOrderItemList) {
        this.oOrderItemList = oOrderItemList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
