package com.example.demo.shiro.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * 路径：com.example.demo.shiro.entity
 * 类名：
 * 功能：资源实体类
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/9 9:53
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Data
public class Resources implements Serializable {

    //id
    @Id
    private Integer id;
    //资源名称
    private String name;
    //资源url
    private String resurl;
    //资源类型 1：菜单 2：按钮
    private Integer type;
    //父资源
    private Integer parentid;
    //排序
    private Integer sort;
    //是否选中
    @Transient
    private String checked;
}
