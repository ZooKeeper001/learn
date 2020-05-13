package com.alibaba.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * redis配置属性
 *
 * @author: huangtt(bleuhtt @ 163.com)
 * @date: 2019/5/11
 * @version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    /**
     * 默认session超时时间
     */
    private int sessionTimeoutMinuters;

    /**
     * redis服务器地址
     */
    private String hostName;

    /**
     * 服务器端口
     */
    private int port;

    /**
     * 数据库序号
     */
    private int database;

    /**
     * 服务器密码
     */
    private String password;

    /**
     * 连接超时
     */
    private String timeout;

    /**
     * 最小空闲数量
     */
    private int minIdle;

    /**
     * 最大空闲数
     */
    private int maxIdle;

    /**
     * 控制一个pool可分配多少个jedis实例,用来替换上面的redis.maxActive,如果是jedis 2.4以后用该属性
     */
    private int maxTotal;

    /**
     * 最大建立连接等待时间。如果超过此时间将接到异常。设为-1表示无限制
     */
    private int maxWaitMillis;

    /**
     * 连接的最小空闲时间 默认1800000毫秒(30分钟)
     */
    private int minEvictableIdleTimeMillis;

    /**
     * 每次释放连接的最大数目,默认3
     */
    private int numTestsPerEvictionRun;

    /**
     * 逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
     */
    private int timeBetweenEvictionRunsMillis;

    /**
     *  是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
     */
    private boolean testOnBorrow;

    /**
     * 在空闲时检查有效性, 默认false
     */
    private boolean testWhileIdle;

    public boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }
}
