package com.example.demo.crud;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.crud.entity.User;
import com.example.demo.crud.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 路径：com.example.demo.crud
 * 类名：
 * 功能：使用mybatis plus的一般形式
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/23 14:13
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    /**
     * 方法名：
     * 功能：查询
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/23 15:07
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void  select(){
        //------------------selectById------------------------------
        User user = userMapper.selectById(1);
        System.out.println("user:"+user.toString());

        //--------------------selectList--------------------
        List<User> list = userMapper.selectList(null);
        System.out.println("list:"+ Arrays.toString(list.toArray()));

        //------------------------selectByMap----------------
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("username","root");
        List<User> maps = userMapper.selectByMap(map);
        System.out.println("map:"+maps.toString());

        //------------------selectPage------------------------------------
        User u = new User();
        u.setUsername("AAA");
        QueryWrapper<User> query = new QueryWrapper<>(u);
        IPage<User> pages = userMapper.selectPage(new Page<>(0,10),query);
        System.out.println("pages:"+pages.getRecords());

        //---------------------------------selectMapsPage-------------------------------------
        User uMap = new User();
        uMap.setUsername("AAA");
        QueryWrapper<User> queryMap = new QueryWrapper<>(uMap);
        IPage<Map<String, Object>>  mapPages = userMapper.selectMapsPage(new Page<>(0,10),queryMap);
        System.out.println("mapPages:"+mapPages.getRecords());
    }

    /**
     * 方法名：
     * 功能：插入操作
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/23 14:41
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("AAA");
        user.setPassword("AAAAA");
        Integer result = userMapper.insert(user);
        // 插入成功放回值
        System.out.println("result:"+result);
    }

    /**
     * 方法名：
     * 功能：修改
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/23 15:01
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void update(){
        User user = new User();
        user.setId(8);
        user.setUsername("AAA");
        user.setPassword("AAAAA");
        Integer result = userMapper.updateById(user);
        System.out.println("result:"+result);
    }

    /**
     * 方法名：
     * 功能：删除
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/23 15:05
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void del(){
        Integer row = userMapper.deleteById(8);
        System.out.println("result:"+row);
    }

}
