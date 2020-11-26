package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 路径：com.example.demo.dao
 * 类名：
 * 功能：查询接口继承自CrudRepository,CrudRepository 默认定义了部分增删改查方法
 * 备注：
 * 创建人：typ
 * 创建时间：2019/1/21 12:06
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * 方法名：
     * 功能：方法名遵循命名规范的查询
     * 描述：此方法的名称必须与实体的name名称对应，我这里是username所以方法名为findAllByusername()
     * 创建人：typ
     * 创建时间：2019/1/21 14:13
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    List<User> findAllByusername(String username);

    /**
     * 方法名：
     * 功能：分页排序查询
     * 描述：
     * 创建人：typ
     * 创建时间：2019/1/21 14:13
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    Page<User> findAll(Pageable pageable);

    /**
     * 方法名：
     * 功能：传入参数名称
     * 描述：使用@Query注解需要注意这里的SQL表名称是实体类的名称，而不是数据库表的名称；
     * 创建人：typ
     * 创建时间：2019/1/21 15:12
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Query("select u from User u where u.username = :username and u.password = :password")
    User findByParam(@Param("username") String username, @Param("password") String password);

    /**
     * 方法名：
     * 功能：占位符查询
     * 描述：使用@Query注解需要注意这里的SQL表名称是实体类的名称，而不是数据库表的名称；
     *      不能写成这样 @Query(value = "select u from User u where u.username = ? or u.password =  ?")，必须是这样的 @Query(value = "select u from User u where u.username = ?1 or u.password =  ?2")，否则会报错的。
     * 创建人：typ
     * 创建时间：2019/1/21 15:17
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Query(value = "select u from User u where u.username = ?1 or u.password =  ?2")
    List<User> findByConditionAndOrder(String username, String password);

}
