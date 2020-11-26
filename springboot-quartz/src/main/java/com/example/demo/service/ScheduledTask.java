package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * 路径：com.example.demo.service
 * 类名：
 * 功能：任务类
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/10 12:03
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@Configuration
@Component
@EnableScheduling
public class ScheduledTask {

    public void sayHello(){
        log.info("Hello world, i'm the king of the world!!!");
    }
}
