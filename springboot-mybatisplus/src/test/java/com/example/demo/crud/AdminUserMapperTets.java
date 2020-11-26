package com.example.demo.crud;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.crud.entity.AdminUserOV;
import com.example.demo.crud.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 路径：com.example.demo.crud
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/27 10:41
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserMapperTets {

    @Autowired
    AdminMapper adminMapper;

    @Test
    public void select(){
        List<AdminUserOV> list = adminMapper.find(new Page<AdminUserOV>(1,3));
        System.out.println(list);
    }
}
