package com.alibaba.study.annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

/**
 * 服务注解
 *
 * @author: huangtt(bleuhtt @ 163.com)
 * @date: 2019/4/29
 * @version: 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Transactional(rollbackFor = {Exception.class})
@Documented
@Service
public @interface BaseService {
    String value() default "";
}
