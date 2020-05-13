package com.alibaba.study.service.impl;

import com.alibaba.study.annotation.BaseService;
import com.alibaba.study.io.OperationResult;
import com.alibaba.study.service.RedisTestService;
import com.alibaba.study.util.RedisUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn (Shawn_0108@163.com)
 * @version 1.0
 * @date 2020/5/9 13:58
 */
@BaseService
public class RedisTestImpl implements RedisTestService {

    @Override
    public OperationResult setPartMsg(String partMessage) {
        RedisUtil.put("part",partMessage);
        return OperationResult.success();
    }


    /**
     * 获取redis公园信息
     *
     * @return
     */
    @Override
    public OperationResult getPartMsg() {
        Map<String, Object> resultMap = new HashMap<>(1);

        String part = (String) RedisUtil.get("part");
        resultMap.put("part",part);
        return OperationResult.success(resultMap);
    }

}
