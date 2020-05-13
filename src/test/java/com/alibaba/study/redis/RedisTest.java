package com.alibaba.study.redis;

import com.alibaba.study.io.OperationResult;
import com.alibaba.study.service.RedisTestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/9 14:00
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedisTest {

    @Autowired
    private RedisTestService redisTest;

    @Test
    public void setRedisTest() {
        OperationResult operationResult = redisTest.setPartMsg("111111111111111111111111111111111111111111111111");

    }

    @Test
    public void getRedis() {
        OperationResult operationResult = redisTest.getPartMsg();
        System.out.println(operationResult.toString());
    }
}
