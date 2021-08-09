package com.ruoyi.web.service;

import com.ruoyi.web.domain.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> listCategory ();
    public List<Category> listCategory (Integer id);
}
