package com.example.demo.shiro.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 路径：com.example.demo.shiro.entity
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/9 9:59
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Data
public class RoleResources implements Serializable {

    @Id
    private Integer id;
    private Integer roleid;
    private String resourcesid;

}
