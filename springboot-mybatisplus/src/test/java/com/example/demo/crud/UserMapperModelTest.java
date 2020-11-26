package com.example.demo.crud;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.crud.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 路径：com.example.demo.crud
 * 类名：
 * 功能：使用myBatis Plus继承Model的形式
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/27 10:04
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperModelTest {

    /**
     * 方法名：
     * 功能：insert
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/27 10:06
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void testInsert(){
        User user = new User();
        //注意查询语法，与普通的有所不一样
        user.setId(12);
        user.setUsername("dhsfg");
        user.setPassword("11111");
        Boolean result = user.insert();
        System.out.println(result);
    }

    /**
     * 方法名：
     * 功能：select
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/27 10:06
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void testSelect(){
        User user = new User();
        //注意查询语法，与普通的有所不一样
        user.setId(12);
        User result = user.selectById();
        System.out.println(result);
    }

    /**
     * 方法名：
     * 功能：selectPage
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/27 10:06
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void testSelectPage(){
        User user = new User();
        //注意查询语法，与普通的有所不一样
        user.setId(12);
        IPage<User> result = user.selectPage(new Page<User>(1,2),null);
        System.out.println(result.getRecords());
    }
}
