package com.imooc.sell.service.impl;

import com.imooc.sell.bean.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    CategoryServiceImpl categoryService;


    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        System.out.println(productCategory);
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategories = categoryService.findAll();
        for (ProductCategory productCategory : productCategories) {
            System.out.println(productCategory);
        }
    }

    @Test
    public void findByCategoryTypeIn() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(list);
        for (ProductCategory productCategory : productCategoryList) {
            System.out.println(productCategory);
        }
    }

    @Test
    public void save() {
        ProductCategory productCategory = categoryService.findOne(1);
        productCategory.setCategoryName("Grain");

        ProductCategory productCategorySave = categoryService.save(productCategory);
        System.out.println(productCategorySave);
    }

    @Test
    public void insert() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("fruit");
        productCategory.setCategoryType(1);
        ProductCategory productCategory1 = categoryService.insert(productCategory);
        System.out.println(productCategory1);
    }
}



