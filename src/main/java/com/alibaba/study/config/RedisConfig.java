package com.alibaba.study.config;

import com.alibaba.study.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置
 *
 * @author: huangtt(bleuhtt @ 163.com)
 * @date: 2019/5/11
 * @version: 1.0
 */
@Configuration
public class RedisConfig extends JCacheConfigurerSupport {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // 配置redis服务器信息
        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration(redisProperties.getHostName(), redisProperties.getPort());
        standaloneConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
        standaloneConfiguration.setDatabase(redisProperties.getDatabase());

        // 创建redis工厂
        JedisConnectionFactory fac = new JedisConnectionFactory(standaloneConfiguration);

        // 配置redis连接池属性
        fac.getPoolConfig().setMinIdle(redisProperties.getMinIdle());
        fac.getPoolConfig().setMaxIdle(redisProperties.getMaxIdle());
        fac.getPoolConfig().setMaxTotal(redisProperties.getMaxTotal());
        fac.getPoolConfig().setMaxWaitMillis(redisProperties.getMaxWaitMillis());
        fac.getPoolConfig().setTestOnBorrow(redisProperties.getTestOnBorrow());
        fac.getPoolConfig().setTestWhileIdle(redisProperties.getTestWhileIdle());
        fac.getPoolConfig().setTimeBetweenEvictionRunsMillis(redisProperties.getTimeBetweenEvictionRunsMillis());
        fac.getPoolConfig().setNumTestsPerEvictionRun(redisProperties.getNumTestsPerEvictionRun());
        return fac;
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redis = new RedisTemplate();
        redis.setConnectionFactory(redisConnectionFactory);
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new JdkSerializationRedisSerializer());
        redis.afterPropertiesSet();

        RedisUtil.setRedisTemplate(redis);
        RedisUtil.setSessionTimeoutMinuters(redisProperties.getSessionTimeoutMinuters());
        return redis;
    }

}
