package com.example.caffeine.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @path：com.example.caffeine.config.CacheConfig.java
 * @className：CacheConfig.java
 * @description： 配置缓存配置类(引入 Caffeine 和 Spring Cache 依赖 ， 使用 SpringCache 注解方法实现缓存)
 * @author：tanyp
 * @dateTime：2020/3/24 21:31
 * @editNote：
 */
@Configuration
public class CacheConfig {

    @Bean("caffeineCacheManager")
    public CacheManager cacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(60, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                // 缓存的最大条数
                .maximumSize(1000));
        return caffeineCacheManager;
    }
}
