package com.ruoyi.web.service.ipml;

import com.ruoyi.web.domain.Product;
import com.ruoyi.web.mapper.ProductMapper;
import com.ruoyi.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Product selectProduct(Integer id) {
        return productMapper.selectProduct(id);
    }

    @Override
    public List<Product> listProduct() {
        return productMapper.listProduct();
    }
}
