package com.example.demo.utils;

/**
 * 路径：com.example.demo.utils
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/5 9:44
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class ResultUtils<T> {

    /**
     * 方法名：success
     * 功能：请求成功
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/5 9:50
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static Result success(Integer code,String msg,Object obj){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(obj);
        return result;
    }

    /**
     * 方法名：error
     * 功能：请求失败
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/5 9:50
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(null);
        return result;
    }
}
