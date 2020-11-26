package com.example.demo.thymeleaf.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.thymeleaf.entity.User;
import com.example.demo.thymeleaf.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 路径：com.example.demo.thymeleaf.controller
 * 类名：DemoController
 * 功能：请求跳转到 classpath:/templates/home.html 页面
 * 备注：
 * 创建人：typ
 * 创建时间：2019/3/14 14:35
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@Controller
@RequestMapping("/")
public class DemoController {

    @Autowired
    private UserService userService;

    /**
     * 方法名：getMap
     * 功能：简单的Map传参
     * 描述：
     * 创建人：typ
     * 创建时间：2019/3/14 14:36
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/index")
    public String getMap(Map<String, Object> map) {
        log.info("DemoController-index 请求开始 入参：{}");
        map.put("id", 1);
        map.put("name", "zhangsan");
        map.put("age", 20);
        map.put("sex", "男");
        log.info("DemoController-index 请求结束 出参：{}", JSON.toJSON(map));
        return "index";
    }

    /**
     * 方法名：getUser
     * 功能：使用实体类传参
     * 描述：
     * 创建人：typ
     * 创建时间：2019/3/14 14:57
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/user")
    public String getUser(Model model) {
        log.info("DemoController-user 请求开始 入参：{}");
        User user = userService.getUser("10001");
        if (user != null) {
            model.addAttribute("user", user);
        }
        log.info("DemoController-user 请求结束 出参：{}", JSON.toJSON(user));
        return "user";
    }

    /**
     * 方法名：list
     * 功能：列表
     * 描述：
     * 创建人：typ
     * 创建时间：2019/3/14 14:57
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/list")
    public String list(Model model) {
        log.info("DemoController-user 请求开始 入参：{}");
        List<User> userList = userService.list();
        if (userList != null && userList.size() > 0) {
            model.addAttribute("userList", userList);
        }
        log.info("DemoController-user 请求结束 出参：{}", JSON.toJSON(userList));
        return "list";
    }
}
