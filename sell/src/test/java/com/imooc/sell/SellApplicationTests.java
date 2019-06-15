package com.imooc.sell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellApplicationTests {

    @Test
    public void contextLoads() {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);



        System.out.println(list.size());

    }

}
