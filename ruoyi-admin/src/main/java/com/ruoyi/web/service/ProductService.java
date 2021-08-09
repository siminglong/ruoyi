package com.ruoyi.web.service;

import com.ruoyi.web.domain.Product;

import java.util.List;

public interface ProductService {
    public Product selectProduct(Integer id);
    public List<Product> listProduct();
}
