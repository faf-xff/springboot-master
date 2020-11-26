package com.example.demo.crud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 路径：com.example.demo.crud.entity
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/27 10:38
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Data
public class AdminUserOV {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private Integer userId;

    private String name;

    private String username;
}
