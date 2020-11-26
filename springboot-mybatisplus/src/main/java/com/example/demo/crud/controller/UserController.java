package com.example.demo.crud.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.crud.entity.User;
import com.example.demo.crud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

/**
 * 路径：com.example.demo.crud.controller
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/23 16:29
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@RestController
@RequestMapping("/crud")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getById")
    public String getById(Integer id) {
        log.info("find start id:{}", id);
        User user = userService.getById(id);
        log.info("find end result:{}", JSON.toJSON(user));
        return user.toString();
    }

    @ResponseBody
    @GetMapping("/find")
    public IPage<User> find(Integer pageNum, Integer pageSize, String name) {
        log.info("find start pageNum:{},pageSize:{},name:{}", pageNum, pageSize, name);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", name);

        IPage<User> page = userService.page(new Page<>(pageNum, pageSize), queryWrapper);
        log.info("find end result:{}", JSON.toJSON(page));
        return page;
    }
}
