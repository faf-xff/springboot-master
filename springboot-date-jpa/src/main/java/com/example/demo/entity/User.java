package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 路径：com.example.demo.entity
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 *  @Entity 表示该类是一个数据库表映射实体
 *  @NoArgsConstructor: 自动生成无参数构造函数。
 *  @AllArgsConstructor: 自动生成全参数构造函数。
 * 创建人：typ
 * 创建时间：2019/1/21 12:06
 * 修改人：
 * 修改备注：
 * 修改时间：
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    private Integer id;

    private String username;

    private String password;
}
