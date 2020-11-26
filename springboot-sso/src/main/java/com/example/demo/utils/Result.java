package com.example.demo.utils;

import lombok.Data;

/**
 * 路径：com.example.demo.utils
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/5 9:42
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Data
public class Result<T> {
    //状态码
    private Integer code;
    //提示信息
    private String message;
    //内容
    private Object data;
}
