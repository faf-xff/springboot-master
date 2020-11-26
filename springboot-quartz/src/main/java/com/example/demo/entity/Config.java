package com.example.demo.entity;

import lombok.Data;

/**
 * 路径：com.example.demo.entity
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/10 12:00
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Data
public class Config {

    private Integer id;
    //任务调度表达式（"0/5 * * * * ? "），每个5秒执行一次
    private String cron;

}
