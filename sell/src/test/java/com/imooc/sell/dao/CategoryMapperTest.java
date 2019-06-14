package com.imooc.sell.dao;

import com.imooc.sell.bean.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTest {

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Test
    public void testSelectByPrimaryKey(){
        ProductCategory productCategory = productCategoryMapper.selectByPrimaryKey(1);
        System.out.println(productCategory);

    }

}
