package com.alibaba.study.util;

import lombok.Setter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * redis基本操作封装
 *
 * @author: huangtt(bleuhtt @ 163.com)
 * @date: 2019/5/11
 * @version: 1.0
 */
@Component
public class RedisUtil {

    @Setter
    private static RedisTemplate<String, Object> redisTemplate;

    @Setter
    private static int sessionTimeoutMinuters;

    /**
     * 存储数据
     *
     * @param key
     * @param value
     * @param minuters
     */
    public static void put(String key, Object value, int minuters) {
        redisTemplate.boundValueOps(key).set(value, minuters, TimeUnit.MINUTES);
    }

    /**
     * 存储数据
     *
     * @param key
     * @param value
     */
    public static void put(String key, Object value) {
        put(key, value, sessionTimeoutMinuters);
    }

    /**
     * 删除数据
     * @param key
     * @return
     * @throws Exception
     */
    public static boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 获取数据，并刷新缓存
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        Object object = redisTemplate.boundValueOps(key).get();
        refreshCache(key);
        return object;
    }

    /**
     * 获取数据，并刷新缓存
     *
     * @param key
     * @return
     */
    public static Object get(String key, String sessionMapKey) {
        Map<String, Object> sessionMap = (Map<String, Object>) redisTemplate.boundValueOps(key).get();
        refreshCache(key);
        return sessionMap.get(sessionMapKey);
    }

    /**
     * 刷新数据超时时间
     * @param key
     */
    private static void refreshCache(String key, int minuters) {
        redisTemplate.boundValueOps(key).expire(minuters, TimeUnit.MINUTES);
    }

    /**
     * 刷新数据
     * @param key
     */
    public static void refreshCache(String key) {
        refreshCache(key, sessionTimeoutMinuters);
    }

    /**
     * 是否存在
     * @param key
     * @return
     */
    public static boolean isExist(String key) {
        return redisTemplate.hasKey(key);
    }

}
