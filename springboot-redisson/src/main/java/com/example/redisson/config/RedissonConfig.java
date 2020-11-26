package com.example.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @path：com.example.redisson.config.RedissonConfig.java
 * @className：RedissonConfig.java
 * @description：Redisson配置类
 * @author：tanyp
 * @dateTime：2020/3/22 19:34
 * @editNote：
 */
@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+host+":"+port);
        return Redisson.create(config);
    }
}
