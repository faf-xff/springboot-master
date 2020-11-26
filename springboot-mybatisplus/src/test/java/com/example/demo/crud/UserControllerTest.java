package com.example.demo.crud;

import com.example.demo.crud.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 路径：com.example.demo.crud
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/23 16:38
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    /**
     * 方法名：
     * 功能：id查询
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/23 17:05
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void getById() {
        String user = userController.getById(10);
        System.out.println("user:" + user);
    }

    /**
     * 方法名：
     * 功能：分页
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/23 17:05
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void find() {
        userController.find(0,2,"AAA");
    }
}
