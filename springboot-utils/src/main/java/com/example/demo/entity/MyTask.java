package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @path：com.example.demo.entity.MyTask.java
 * @className：MyTask.java
 * @description：任务实体
 * @author：tanyp
 * @dateTime：2020/7/23 21:41 
 * @editNote：
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyTask {

    /**
     * 任务id
     */
    private String taskId;

    /**
     * 任务执行规则时间
     */
    private String expression;
}
