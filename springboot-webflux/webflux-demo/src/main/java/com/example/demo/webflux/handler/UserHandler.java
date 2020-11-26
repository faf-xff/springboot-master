package com.example.demo.webflux.handler;

import com.alibaba.fastjson.JSON;
import com.example.demo.webflux.entity.User;
import com.example.demo.webflux.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 路径：com.example.demo.webflux.handler.UserHandle.java
 * 类名：UserHandle.java
 * 功能：用户处理器类
 * 备注：
 * 创建人：typ
 * 创建时间：2019/6/2 19:21
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@Component
public class UserHandler {

    private final UserMapper userMapper;

    @Autowired
    public UserHandler(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

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
    public Mono<User> qryById(String id) {
        log.info("请求 qryById start 入参：id:{}", id);
        Mono<User> user = Mono.justOrEmpty(userMapper.qryById(id));
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
    public Flux<User> qryAll() {
        log.info("请求 qryAll start 入参：{}");
        Flux<User> users = Flux.fromIterable(userMapper.qryAll());
        log.info("请求 qryAll end 出参：{}", JSON.toJSON(users));
        return users;
    }

    /**
     * 方法名：save
     * 功能：新增数据
     * 描述：
     * 创建人：typ
     * 创建时间：2019/6/2 20:39
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public Mono<Integer> save(User user) {
        log.info("请求 save start 入参：{}", JSON.toJSON(user));
        Mono<Integer> rows = Mono.justOrEmpty(userMapper.save(user));
        log.info("请求 save end 出参：{}", rows);
        return rows;
    }

    /**
     * 方法名：update
     * 功能：修改
     * 描述：
     * 创建人：typ
     * 创建时间：2019/6/2 20:39
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public Mono<Integer> update(User user) {
        log.info("请求 update start 入参：{}", JSON.toJSON(user));
        Mono<Integer> rows = Mono.justOrEmpty(userMapper.update(user));
        log.info("请求 update end 出参：{}", rows);
        return rows;
    }

    /**
     * 方法名：del
     * 功能：删除
     * 描述：
     * 创建人：typ
     * 创建时间：2019/6/2 20:39
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public Mono<Integer> del(String id) {
        log.info("请求 del start 入参：id:{}", id);
        Mono<Integer> rows = Mono.justOrEmpty(userMapper.del(id));
        log.info("请求 del end 出参：{}", rows);
        return rows;
    }
}
