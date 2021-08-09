package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    private Integer id;
    private String name;
    private Float price;
    private Integer cid;
    private Category category;
    private List<OrderItem> pOrderItem;

    public List<OrderItem> getpOrderItem() {
        return pOrderItem;
    }

    public void setpOrderItem(List<OrderItem> pOrderItem) {
        this.pOrderItem = pOrderItem;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cid=" + cid +
                '}';
    }
}
