package com.example.demo;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDateJpaApplicationTests {

    @Autowired
    private UserRepository repository;

    /**
     * 方法名：
     * 功能：保存单条数据
     * 描述：
     * 创建人：typ
     * 创建时间：2019/1/21 14:57
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void save() {
        repository.save(new User(13, "hello", "hello"));

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
    @Test
    public void saves() {
        List<User> user = new ArrayList<>();
        user.add(new User(1, "hello1", "hello"));
        user.add(new User(1, "hello2", "hello"));
        user.add(new User(1, "hello3", "hello"));
        user.add(new User(1, "hello4", "hello"));
        repository.saveAll(user);
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
    @Test
    public void findByName() {
        List<User> users = repository.findAllByusername("hello");
        users.forEach(System.out::println);
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
    @Test
    public void findByParam(){
        User user = repository.findByParam("hello","hello");
        System.out.println(user);
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
    @Test
    public void findByConditionAndOrder(){
        List<User> users = repository.findByConditionAndOrder("hello","hello");
        users.forEach(System.out::println);
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
    @Test
    public void page() {
        Page<User> page = repository.findAll(PageRequest.of(0, 10));
        page.forEach(System.out::println);
    }

    /**
     * 方法名：
     * 功能：更新数据
     * 描述：保存主键相同的数据就认为是更新操作
     * 创建人：typ
     * 创建时间：2019/1/21 14:58
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Test
    public void update() {
        repository.save(new User(12, "hello1", "0123456"));
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
    @Test
    public void delete() {
        repository.deleteById(12);
    }

}

