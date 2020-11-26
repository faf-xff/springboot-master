package com.example.demo.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 类名：CollecBenefitMapper.java
 * 路径：com.winner.dao.smallprogram.CollecBenefitMapper.java
 * 创建人：tanyp
 * 创建时间：2019/5/9 16:48
 * 功能：集客力效益
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
@Mapper
public interface CollecBenefitMapper {
    
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
    Double getCollecTrafficRotioPL(Map<String, Object> map);

    Double getCollecTrafficRotioYT(Map<String, Object> map);

    Double getCollecTrafficRotioBD(Map<String, Object> map);

    Double getCollecTrafficRotioBGC(Map<String, Object> map);

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
    List<Map<String,Object>> getCollecCompareTrendYT(Map<String, Object> map);

    List<Map<String,Object>> getCollecCompareTrendPL(Map<String, Object> map);

    List<Map<String,Object>> getCollecCompareTrendBD(Map<String, Object> map);

    List<Map<String,Object>> getCollecCompareTrendBGC(Map<String, Object> map);
}
