package com.imooc.sell;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void testLogger(){


        log.trace("trace");
        log.debug("debug");
        log.info("info");
        //输出变量
        String username = "xiaoyou";
        String password = "xiaoyou";
        log.info("info--- username: {}, password: {}", username, password);
        log.warn("warn");
        log.error("error");
    }
}
