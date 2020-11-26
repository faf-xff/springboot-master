package com.example.redisson.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @path：com.example.redisson.controller.TestController.java
 * @className：TestController.java
 * @description：测试
 * @author：tanyp
 * @dateTime：2020/3/22 19:26
 * @editNote：
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("test")
    public String test(String id) {
        RLock rLock = redissonClient.getLock(id);
        try {
            boolean bs = rLock.tryLock(5, 6, TimeUnit.SECONDS);
            if (bs) {
                // 业务代码
                log.info("进入业务代码: " + id);
                rLock.unlock();
                return "请求成功";
            } else {
                return "服务器繁忙，请稍后再试！";
            }
        } catch (Exception e) {
            log.error("请求异常：{}", e);
            rLock.unlock();
        }
        return "请求失败";
    }
}
