package com.alibaba.study.service;

import com.alibaba.study.io.OperationResult;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/9 13:54
 */
public interface RedisTestService {

    /**
     * redis存储公园信息
     *
     * @param partMessage
     * @return
     */
    OperationResult setPartMsg (String partMessage) ;

    /**
     * 获取redis公园信息
     *
     * @return
     */
    OperationResult getPartMsg () ;

}
