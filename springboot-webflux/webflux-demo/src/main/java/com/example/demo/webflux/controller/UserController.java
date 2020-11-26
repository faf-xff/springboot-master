package com.example.demo.webflux.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.webflux.entity.User;
import com.example.demo.webflux.handler.UserHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 路径：com.example.demo.webflux.controller.UserController.java
 * 类名：UserController.java
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/6/2 19:56
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserHandler userHandler;

    /**
     * 方法名：qryById
     * 功能：根据id查询
     * 描述：
     * 创建人：typ
     * 创建时间：2019/6/2 20:33
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/qryById")
    public Mono<User> qryById(String id) {
        log.info("请求 qryById start 入参：id:{}", id);
        Mono<User> user = userHandler.qryById(id);
        log.info("请求 qryById end 出参：{}", JSON.toJSON(user));
        return user;
    }

    /**
     * 方法名：qryAll
     * 功能：查询所有列表
     * 描述：
     * 创建人：typ
     * 创建时间：2019/6/2 20:33
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/qryAll")
    public Flux<User> qryAll() {
        log.info("请求 qryAll start 入参：{}");
        Flux<User> users = userHandler.qryAll();
        log.info("请求 qryById end 出参：{}", JSON.toJSON(users));
        return users;
    }

    /**
     * 方法名：save
     * 功能：新增
     * 描述：
     * 创建人：typ
     * 创建时间：2019/6/2 2:33
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @PostMapping("/save")
    public Mono<Integer> save(@RequestBody User user) {
        log.info("请求 save start 入参：{}", JSON.toJSON(user));
        Mono<Integer> rows = userHandler.save(user);
        log.info("请求 save end 出参：{}", rows);
        return rows;
    }

    /**
     * 方法名：update
     * 功能：修改
     * 描述：
     * 创建人：typ
     * 创建时间：2019/6/2 2:33
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @PostMapping("/update")
    public Mono<Integer> update(@RequestBody User user) {
        log.info("请求 update start 入参：{}", JSON.toJSON(user));
        Mono<Integer> rows = userHandler.update(user);
        log.info("请求 update end 出参：{}", rows);
        return rows;
    }

    /**
     * 方法名：del
     * 功能：删除
     * 描述：
     * 创建人：typ
     * 创建时间：2019/6/2 2:33
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/del")
    public Mono<Integer> del(String id) {
        log.info("请求 del start 入参：id:{}", id);
        Mono<Integer> rows = userHandler.del(id);
        log.info("请求 del end 出参：{}", rows);
        return rows;
    }
}
