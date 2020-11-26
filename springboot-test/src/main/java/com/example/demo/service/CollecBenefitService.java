package com.example.demo.service;

import java.util.List;
import java.util.Map;

/**
 * 类名：CollecBenefitService.java
 * 路径：com.winner.service.smallprogram.CollecBenefitService.java
 * 创建人：tanyp
 * 创建时间：2019/5/9 16:48
 * 功能：集客力效益
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
public interface CollecBenefitService {

    /**
     * 方法名：getCollecTrafficRotio
     * 功能：日均集客力对比
     * 创建人：tanyp
     * 创建时间：2019/5/9 16:47
     * 入参：
     * 出参：
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    Map<String,Object> getCollecTrafficRotio(Map<String, Object> map);

    /**
     * 方法名：getCollecCompareTrend
     * 功能：集客力对比趋势
     * 创建人：tanyp
     * 创建时间：2019/5/9 16:47
     * 入参：
     * 出参：
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    List<Map<String,Object>> getCollecCompareTrend(Map<String, Object> map);
}
