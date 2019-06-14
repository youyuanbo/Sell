package com.imooc.sell.service.impl;

import com.imooc.sell.bean.ProductCategory;
import com.imooc.sell.bean.ProductCategoryExample;
import com.imooc.sell.dao.ProductCategoryMapper;
import com.imooc.sell.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryMapper.selectByExample(null);
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        ProductCategoryExample example = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryTypeIn(categoryTypeList);
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        productCategoryMapper.updateByPrimaryKey(productCategory);
        return productCategoryMapper.selectByPrimaryKey(productCategory.getCategoryId());
    }

    @Override
    public ProductCategory insert(ProductCategory productCategory) {
        productCategoryMapper.insert(productCategory);

        ProductCategoryExample example = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryTypeEqualTo(productCategory.getCategoryType());
        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(example);

        return productCategories.get(0);
    }
}
