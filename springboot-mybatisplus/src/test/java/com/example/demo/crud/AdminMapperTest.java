package com.example.demo.crud;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.crud.entity.Admin;
import com.example.demo.crud.entity.User;
import com.example.demo.crud.mapper.AdminMapper;
import com.example.demo.crud.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径：com.example.demo.crud
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/27 10:31
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminMapperTest {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    public void select(){
        Admin admin = adminMapper.selectById(1);
        System.out.println(admin);
    }

    /**
     * 方法名：
     * 功能：未完成，待测试
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/27 12:05
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void selectPage(){
        IPage<Object> page = new Page<Object>(1,2);
        List<Object> list = new ArrayList<>();
//        List<Admin> adminList = adminMapper.selectList(null);
//        List<User> userList = userMapper.selectList(null);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        page.setRecords(list);
        System.out.println(page.getRecords());
    }
}
