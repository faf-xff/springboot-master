package com.example.caffeine.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;


/**
 * @path：com.example.caffeine.config.CaffeineConfig.java
 * @className：CaffeineConfig.java
 * @description： 配置缓存配置类 (直接引入 Caffeine 依赖，然后使用 Caffeine 方法实现缓存)
 * @author：tanyp
 * @dateTime：2020/3/24 20:46
 * @editNote：
 */
@Configuration
public class CaffeineConfig {

    @Bean
    public Cache<String, Object> caffeine() {
        return Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(60, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(1000)
                .build();
    }
}
