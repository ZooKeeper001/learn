package com.alibaba.study.service.impl;

import com.alibaba.study.annotation.BaseService;
import com.alibaba.study.io.OperationResult;
import com.alibaba.study.io.input.UserInput;
import com.alibaba.study.io.output.UerResponse;
import com.alibaba.study.mapper.UserMapper;
import com.alibaba.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/9 10:59
 */
@BaseService
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public OperationResult queryUser() {

        List<UerResponse> uerResponse = userMapper.queryUser();

        return OperationResult.success(uerResponse);
    }
}
