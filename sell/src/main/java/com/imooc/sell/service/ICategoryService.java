package com.imooc.sell.service;


import com.imooc.sell.bean.ProductCategory;

import java.util.List;

public interface ICategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

    ProductCategory insert(ProductCategory productCategory);

}
