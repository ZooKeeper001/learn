package com.alibaba.study.user;

import com.alibaba.study.io.OperationResult;
import com.alibaba.study.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/9 11:02
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {

    @Resource
    private UserService userService;

    @Test
    public void queryUser() {
        OperationResult operationResult = userService.queryUser();
        System.out.println(operationResult.toString());
    }
}
