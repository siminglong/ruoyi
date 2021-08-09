package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.Product;

import java.util.List;

public interface ProductMapper {
    public Product selectProduct(Integer id);
    public List<Product> listProduct();
}
