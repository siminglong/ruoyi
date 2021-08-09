package com.ruoyi.web.service.ipml;

import com.ruoyi.web.domain.Category;
import com.ruoyi.web.mapper.CategoryMapper;
import com.ruoyi.web.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> listCategory() {
        return categoryMapper.listCategory();
    }

    @Override
    public List<Category> listCategory(Integer id) {
        return categoryMapper.listCategory1(id);
    }
}
