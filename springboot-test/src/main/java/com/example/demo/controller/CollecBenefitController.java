package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.CollecBenefitService;
import com.example.demo.utils.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名：CollecBenefitController.java
 * 路径：com.winner.controller.smallprogram.v2.CollecBenefitController.java
 * 创建人：tanyp
 * 创建时间：2019/5/9 16:52
 * 功能：集客力效益
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
@RestController("collecBenefitController")
@RequestMapping("/smallprogram/v2")
public class CollecBenefitController {

    private static final Logger log = LoggerFactory.getLogger(CollecBenefitController.class);

    @Autowired
    private CollecBenefitService collecBenefitService;

    /**
     * 方法名：getCollecTrafficRotio
     * 功能：日均集客力对比
     * 创建人：tanyp
     * 创建时间：2019/5/9 16:55
     * 入参：openid：微信用户标识,datetype：日期类型,startDate：查询开始日期,endDate：查询结束日期,siteKey: 场所编号
     * 出参：
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    @RequestMapping("/getCollecTrafficRotio")
    public Msg getCollecTrafficRotio(String openid, String datetype, String startDate, String endDate, String siteKey) {
        log.info("请求 getCollecTrafficRotio  start ，入参：{}，{}，{}，{}，{}", openid, datetype, startDate, endDate, siteKey);
        Map<String,Object> map = new HashMap<>();
        if(StringUtils.isEmpty(openid)){
            return Msg.fail().add("openid为空");
        }
        if(StringUtils.isEmpty(datetype)){
            return Msg.fail().add("datetype为空");
        }
        if(StringUtils.isEmpty(startDate)){
            return Msg.fail().add("startDate为空");
        }
        if(StringUtils.isEmpty(endDate)){
            return Msg.fail().add("endDate为空");
        }
        if(StringUtils.isEmpty(siteKey)){
            return Msg.fail().add("siteKey为空");
        }
        map.put("openid",openid);
        map.put("datetype",datetype);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("siteKey",siteKey);
        try {
            Map<String, Object> result = collecBenefitService.getCollecTrafficRotio(map);
            log.info("请求 getCollecTrafficRotio  emd ，出参：{}", JSON.toJSON(result));
            return Msg.success().add(result);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("请求 getCollecTrafficRotio 异常：{}", e.getMessage());
            return Msg.unknownError().add("接口异常");
        }
    }

    /**
     * 方法名：getCollecCompareTrend
     * 功能：集客力对比趋势
     * 创建人：tanyp
     * 创建时间：2019/5/9 16:55
     * 入参：datetype：日期类型,startDate：查询开始日期,endDate：查询结束日期,siteKey: 场所编号
     * 出参：
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    @RequestMapping("/getCollecCompareTrend")
    public Msg getCollecCompareTrend(String datetype, String startDate, String endDate, String siteKey) {
        log.info("请求 getCollecCompareTrend  start ，入参：{}，{}，{}，{}", datetype, startDate, endDate, siteKey);
        Map<String,Object> map = new HashMap<>();
        if(StringUtils.isEmpty(datetype)){
            return Msg.fail().add("datetype为空");
        }
        if(StringUtils.isEmpty(startDate)){
            return Msg.fail().add("startDate为空");
        }
        if(StringUtils.isEmpty(endDate)){
            return Msg.fail().add("endDate为空");
        }
        if(StringUtils.isEmpty(siteKey)){
            return Msg.fail().add("siteKey为空");
        }
        map.put("datetype",datetype);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("siteKey",siteKey);
        try {
            List<Map<String, Object>> result = collecBenefitService.getCollecCompareTrend(map);
            log.info("请求 getCollecCompareTrend  emd ，出参：{}", JSON.toJSON(result));
            return Msg.success().add(result);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("请求 getCollecCompareTrend 异常：{}", e.getMessage());
            return Msg.unknownError().add("接口异常");
        }
    }
}
