package com.example.demo.crud.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 路径：com.example.demo.crud.entity
 * 类名：
 * 功能：1.使用mybatis plus的一般形式
 *      2.使用myBatis Plus继承Model的形式
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/23 14:09
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
//1.使用mybatis plus的一般形式
/*@Data
public class User {

    private Integer id;

    private String username;

    private String password;

}*/

//2.使用myBatis Plus继承Model的形式
@Data
public class User extends Model<User> {

    private Integer id;

    private String username;

    private String password;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
