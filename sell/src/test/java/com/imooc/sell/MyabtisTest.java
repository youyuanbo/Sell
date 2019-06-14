package com.imooc.sell;


import com.imooc.sell.bean.ProductInfo;
import com.imooc.sell.dao.ProductInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyabtisTest {

    //生成bean、dao、xml
    @Test
    public void testMybatis() throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        File configFile = new File("E:\\workspace\\IDEA\\Project\\Sell\\sell\\src\\main\\resources\\mybatis-generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }


    @Autowired
    ProductInfoMapper productInfoMapper;

    @Test
    public void testMapper(){
//
        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey("1");
        System.out.println(productInfo);

        ProductInfo productInfo1 = new ProductInfo();
        productInfo.setProductId("1");
        productInfoMapper.updateByPrimaryKey(productInfo1);

        ProductInfo productInfo2 = productInfoMapper.selectByPrimaryKey("1");
        System.out.println(productInfo2);

//        ProductInfo productInfo1 = new ProductInfo();
//        productInfo1.setProductId("2");
//        productInfo1.setProductName("Orange");
//        productInfo1.setProductPrice(BigDecimal.valueOf(16.32));
//        productInfo1.setProductStock(15);
//        productInfo1.setCategoryType(1);
//        productInfo1.setCreateTime(new Date());
//        productInfo1.setCreateTime(new Date());
//
//
//        int insert = productInfoMapper.insert(productInfo1);
//        System.out.println(insert);
    }
}
