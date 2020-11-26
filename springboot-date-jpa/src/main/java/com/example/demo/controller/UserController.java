package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 路径：com.example.demo.controller
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/1/21 12:06
 * 修改人：
 * 修改备注：
 * 修改时间：
 */

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 方法名：
     * 功能：保存单条数据 & 传入id为修改操作
     * 描述：
     * 创建人：typ
     * 创建时间：2019/1/21 14:57
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @PostMapping("/save")
    public String save(User user) {
        log.info("save 入参：{}", user);
        try {
            userService.save(user);
            log.info("save 出参：保存成功");
            return "保存成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("save 出参：保存失败");
        return "保存失败";
    }

    /**
     * 方法名：
     * 功能：保存多条数据
     * 描述：
     * 创建人：typ
     * 创建时间：2019/1/21 14:56
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @PostMapping("/saves")
    public String saves(List<User> users) {
        log.info("saves 入参：{}", users);
        try {
            userService.saveAll(users);
            log.info("saves 出参：保存成功");
            return "保存成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("saves 出参：保存失败");
        return "保存失败";
    }

    /**
     * 方法名：
     * 功能：遵循命名规范的查询
     * 描述：
     * 创建人：typ
     * 创建时间：2019/1/21 14:56
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/findByName")
    public List<User> findByName(String name) {
        log.info("findByName 入参：name:{}", name);
        List<User> users = userService.findAllByName(name);
        log.info("findByName 出参：{}", users);
        return users;
    }

    /**
     * 方法名：
     * 功能：传入参数名称
     * 描述：
     * 创建人：typ
     * 创建时间：2019/1/21 15:13
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/findByParam")
    public User findByParam(String name, String password) {
        log.info("findByParam 入参：name:{},password:{}", name, password);
        User user = userService.findByParam(name, password);
        log.info("findByParam 出参：{}", user);
        return user;
    }

    /**
     * 方法名：
     * 功能：占位符查询
     * 描述：
     * 创建人：typ
     * 创建时间：2019/1/21 15:17
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/findByConditionAndOrder")
    public List<User> findByConditionAndOrder(String name, String password) {
        log.info("findByConditionAndOrder 入参：name:{},password:{}", name, password);
        List<User> users = userService.findByConditionAndOrder(name, password);
        log.info("findByConditionAndOrder 出参：{}", users);
        return users;
    }

    /**
     * 方法名：
     * 功能：分页查询
     * 描述：
     * 创建人：typ
     * 创建时间：2019/1/21 14:58
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/list")
    public Page<User> list(Integer pageNum, Integer pageSize) {
        log.info("list 入参：pageNum:{},pageSize:{}", pageNum, pageSize);
        Page<User> page = userService.findAll(PageRequest.of(pageNum, pageSize));
        log.info("list 出参：{}", page);
        return page;
    }

    /**
     * 方法名：
     * 功能：删除数据
     * 描述：
     * 创建人：typ
     * 创建时间：2019/1/21 15:04
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/del")
    public String delete(Integer id) {
        log.info("del 入参：id:{}", id);
        try {
            userService.del(id);
            log.info("del 出参：删除成功");
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("del 出参：删除失败");
        return "删除失败";
    }
}
