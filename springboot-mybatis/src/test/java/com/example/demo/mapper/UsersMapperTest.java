package com.example.demo.mapper;

import com.alibaba.fastjson.JSON;
import com.example.demo.enitiy.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * 路径：com.example.demo.mapper
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/1/28 15:26
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersMapperTest {

    @Autowired
    UsersMapper userMapper;

    @Test
    public void list() {
        List<User> userList = userMapper.list();
        System.out.println(JSON.toJSON(userList));
    }

    @Test
    public void qryById() {
        User userList = userMapper.qryById("1");
        System.out.println(JSON.toJSON(userList));
    }

    @Test
    public void insertByBatch(){
        List<User> users = new ArrayList<>();
        User user1 = new User("1001","张三","123456");
        User user2 = new User("1002","李素","123456");
        User user3 = new User("1003","王伟","123456");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        userMapper.insertByBatch(users);
    }

    /**
     * 方法名：
     * 功能：《用一句话描述一下》
     * 描述：批量修改连接数据库时必须添加 allowMultiQueries=true，否则会报错
     * 创建人：typ
     * 创建时间：2019/1/28 16:10
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void updateByBatch(){
        List<User> users = new ArrayList<>();
        User user1 = new User("1001","zhangsan","123456");
        User user2 = new User("1002","lisi","11111");
        User user3 = new User("1003","wangwu","123456");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        userMapper.updateByBatch(users);
    }
}
