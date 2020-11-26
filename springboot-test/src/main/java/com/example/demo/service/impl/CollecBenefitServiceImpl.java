package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.CollecBenefitMapper;
import com.example.demo.service.CollecBenefitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 类名：CollecBenefitServiceImpl.java
 * 路径：com.winner.service.impl.smallprogram.CollecBenefitServiceImpl.java
 * 创建人：tanyp
 * 创建时间：2019/5/9 16:48
 * 功能：集客力效益
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
@Service
public class CollecBenefitServiceImpl implements CollecBenefitService {

    private static final Logger log = LoggerFactory.getLogger(CollecBenefitServiceImpl.class);

    @Autowired
    private CollecBenefitMapper collecBenefitMapper;

    /**
     * 方法名：getCollecTrafficRotio
     * 功能：日均集客力对比
     * 创建人：tanyp
     * 创建时间：2019/5/9 16:47
     * 入参：dateType:时间粒度(0、1、5:天，2、3、4:月，6:周，7:年)
     * 出参：
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    @Override
    public Map<String, Object> getCollecTrafficRotio(Map<String, Object> map) {
        log.info("请求 getCollecTrafficRotio  start ，入参：{}", JSON.toJSON(map));
        String datetype = String.valueOf(map.get("datetype"));
        String startYear = String.valueOf(map.get("startDate")).substring(0, 4);
        String endYear = String.valueOf(map.get("endDate")).substring(0, 4);
        if ("0".equals(datetype) || "1".equals(datetype) || "5".equals(datetype)) { // 天
            map.put("dataType", "1");
        } else if ("6".equals(datetype)) { // 周
            // 判断是否跨年
            if (!startYear.equals(endYear)) {
                map.put("year", startYear);
                map.put("endYear", endYear);
                map.put("startDate", getWeek(String.valueOf(map.get("startDate"))));
                map.put("endDate1", getWeek(String.valueOf(map.get("endDate"))));
                map.put("startDate1", 1);
                map.put("endDate", 52);
            } else {
                map.put("year", String.valueOf(map.get("startDate")).substring(0, 4));
                map.put("startDate", getWeek(String.valueOf(map.get("startDate"))));
                map.put("endDate", getWeek(String.valueOf(map.get("endDate"))));
            }
            map.put("dataType", "2");
        } else if ("2".equals(datetype) || "3".equals(datetype) || "4".equals(datetype)) { // 月
            if (!startYear.equals(endYear)) {
                map.put("year", startYear);
                map.put("endYear", endYear);
                map.put("startDate", Integer.parseInt(String.valueOf(map.get("startDate")).substring(5, 7)));
                map.put("endDate1", Integer.parseInt(String.valueOf(map.get("endDate")).substring(5, 7)));
                map.put("startDate1", 1);
                map.put("endDate", 12);
            } else {
                map.put("year", startYear);
                map.put("startDate", Integer.parseInt(String.valueOf(map.get("startDate")).substring(5, 7)));
                map.put("endDate", Integer.parseInt(String.valueOf(map.get("endDate")).substring(5, 7)));
            }
            map.put("dataType", "3");
        } else { // 年
            map.put("startDate", String.valueOf(map.get("startDate")).substring(0, 4));
            map.put("endDate", String.valueOf(map.get("endDate")).substring(0, 4));
            map.put("dataType", "4");
        }

        List<Double> values = new ArrayList<>();
        // 查询本广场集客力
        Double bgc = collecBenefitMapper.getCollecTrafficRotioBGC(map);
        if (bgc == null) {
            values.add(0.00d);
        } else {
            values.add(Double.parseDouble(String.format("%.2f", bgc)));
        }
        // 查询业态集客力
        Double yt = collecBenefitMapper.getCollecTrafficRotioYT(map);
        if (yt == null) {
            values.add(0.00d);
        } else {
            values.add(Double.parseDouble(String.format("%.2f", yt)));
        }
        // 查询品类集客力
        Double pl = collecBenefitMapper.getCollecTrafficRotioPL(map);
        if (pl == null) {
            values.add(0.00d);
        } else {
            values.add(Double.parseDouble(String.format("%.2f", pl)));
        }
        // 查询本店集客力
        Double bd = collecBenefitMapper.getCollecTrafficRotioBD(map);
        if (bd == null) {
            values.add(0.00d);
        } else {
            values.add(Double.parseDouble(String.format("%.2f", bd)));
        }

        Map<String, Object> result = new HashMap<>();
        List<String> names = Arrays.asList("本广场", "业态", "品类", "本店");
        result.put("names", names);
        result.put("values", values);
        log.info("请求 getCollecTrafficRotio  end ，出参：{}", JSON.toJSON(result));
        return result;
    }


    /**
     * 方法名：getCollecCompareTrend
     * 功能：集客力对比趋势
     * 创建人：tanyp
     * 创建时间：2019/5/9 16:47
     * 入参：dateType:时间粒度(0、1、5:天，2、3、4:月，6:周，7:年)
     * 出参：
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    @Override
    public List<Map<String, Object>> getCollecCompareTrend(Map<String, Object> map) {
        log.info("请求 getCollecCompareTrend  start ，入参：{}", JSON.toJSON(map));
        String startD = String.valueOf(map.get("startDate"));
        String endD = String.valueOf(map.get("endDate"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String datetype = String.valueOf(map.get("datetype"));
        String startYear = String.valueOf(map.get("startDate")).substring(0, 4);
        String endYear = String.valueOf(map.get("endDate")).substring(0, 4);
        boolean status = false;
        if ("0".equals(datetype) || "1".equals(datetype) || "5".equals(datetype)) { // 天
            map.put("dataType", "1");
        } else if ("6".equals(datetype)) { // 周
            // 判断是否跨年
            if (!startYear.equals(endYear)) {
                map.put("year", startYear);
                map.put("endYear", endYear);
                map.put("startDate", getWeek(String.valueOf(map.get("startDate"))));
                map.put("endDate1", getWeek(String.valueOf(map.get("endDate"))));
                map.put("startDate1", 1);
                map.put("endDate", 52);
            } else {
                map.put("year", String.valueOf(map.get("startDate")).substring(0, 4));
                map.put("startDate", getWeek(String.valueOf(map.get("startDate"))));
                map.put("endDate", getWeek(String.valueOf(map.get("endDate"))));
            }
            map.put("dataType", "2");
        } else if ("2".equals(datetype) || "3".equals(datetype) || "4".equals(datetype)) { // 月
            status = true;
            if (!startYear.equals(endYear)) {
                map.put("year", startYear);
                map.put("endYear", endYear);
                map.put("startDate", Integer.parseInt(String.valueOf(map.get("startDate")).substring(5, 7)));
                map.put("endDate1", Integer.parseInt(String.valueOf(map.get("endDate")).substring(5, 7)));
                map.put("startDate1", 1);
                map.put("endDate", 12);
            } else {
                map.put("year", startYear);
                map.put("startDate", Integer.parseInt(String.valueOf(map.get("startDate")).substring(5, 7)));
                map.put("endDate", Integer.parseInt(String.valueOf(map.get("endDate")).substring(5, 7)));
            }
            map.put("dataType", "3");
        } else { // 年
            map.put("startDate", String.valueOf(map.get("startDate")).substring(0, 4));
            map.put("endDate", String.valueOf(map.get("endDate")).substring(0, 4));
            map.put("dataType", "4");
        }

        /*
        // 查询本广场集客力
        List<Map<String, Object>> bgcList = collecBenefitMapper.getCollecCompareTrendBGC(map);
        List<String> bgcDatas = new ArrayList<>();
        List<Double> bgcValues = new ArrayList<>();
        for (Map<String, Object> objectMap : bgcList) {
            if (status) {
                try {
                    Date date = format.parse(String.valueOf(objectMap.get("datas")));
                    bgcDatas.add(format.format(date));
                } catch (Exception e) {
                    log.info("格式化日期异常：{}", e.getMessage());
                }
            } else {
                bgcDatas.add(String.valueOf(objectMap.get("datas")));
            }
            if (objectMap.get("num") == null) {
                bgcValues.add(0.00d);
            } else {
                bgcValues.add(Double.parseDouble(String.valueOf(objectMap.get("num"))));
            }
        }
        Map<String, Object> bgcResult = new HashMap<>();
        bgcResult.put("names", "本广场");
        bgcResult.put("datas", bgcDatas);
        bgcResult.put("values", bgcValues);

        // 查询业态集客力
        List<Map<String, Object>> ytList = collecBenefitMapper.getCollecCompareTrendYT(map);
        List<String> ytDatas = new ArrayList<>();
        List<Double> ytValues = new ArrayList<>();
        for (Map<String, Object> objectMap : ytList) {
            if (status) {
                try {
                    Date date = format.parse(String.valueOf(objectMap.get("datas")));
                    ytDatas.add(format.format(date));
                } catch (Exception e) {
                    log.info("格式化日期异常：{}", e.getMessage());
                }
            } else {
                ytDatas.add(String.valueOf(objectMap.get("datas")));
            }
            if (objectMap.get("num") == null) {
                ytValues.add(0.00d);
            } else {
                ytValues.add(Double.parseDouble(String.valueOf(objectMap.get("num"))));
            }
        }
        Map<String, Object> ytResult = new HashMap<>();
        ytResult.put("names", "业态");
        ytResult.put("datas", ytDatas);
        ytResult.put("values", ytValues);

        // 查询品类集客力
        List<Map<String, Object>> plList = collecBenefitMapper.getCollecCompareTrendPL(map);
        List<String> plDatas = new ArrayList<>();
        List<Double> plValues = new ArrayList<>();
        for (Map<String, Object> objectMap : plList) {
            if (status) {
                try {
                    Date date = format.parse(String.valueOf(objectMap.get("datas")));
                    plDatas.add(format.format(date));
                } catch (Exception e) {
                    log.info("格式化日期异常：{}", e.getMessage());
                }
            } else {
                plDatas.add(String.valueOf(objectMap.get("datas")));
            }
            if (objectMap.get("num") == null) {
                plValues.add(0.00d);
            } else {
                plValues.add(Double.parseDouble(String.valueOf(objectMap.get("num"))));
            }
        }
        Map<String, Object> plResult = new HashMap<>();
        plResult.put("names", "品类");
        plResult.put("datas", plDatas);
        plResult.put("values", plValues);

        // 查询本店集客力
        List<Map<String, Object>> bdList = collecBenefitMapper.getCollecCompareTrendBD(map);
        List<String> bdDatas = new ArrayList<>();
        List<Double> bdValues = new ArrayList<>();
        for (Map<String, Object> objectMap : bdList) {
            if (status) {
                try {
                    Date date = format.parse(String.valueOf(objectMap.get("datas")));
                    bdDatas.add(format.format(date));
                } catch (Exception e) {
                    log.info("格式化日期异常：{}", e.getMessage());
                }
            } else {
                bdDatas.add(String.valueOf(objectMap.get("datas")));
            }
            if (objectMap.get("num") == null) {
                bdValues.add(0.00d);
            } else {
                bdValues.add(Double.parseDouble(String.valueOf(objectMap.get("num"))));
            }
        }
        Map<String, Object> bdResult = new HashMap<>();
        bdResult.put("names", "本店");
        bdResult.put("datas", bdDatas);
        bdResult.put("values", bdValues);
        */

        // 查询本广场集客力
        List<Map<String, Object>> bgcList = collecBenefitMapper.getCollecCompareTrendBGC(map);
        Map<String, Object> bgcResult = result("本广场", bgcList, startD, endD, String.valueOf(map.get("dataType")));

        // 查询业态集客力
        List<Map<String, Object>> ytList = collecBenefitMapper.getCollecCompareTrendYT(map);
        Map<String, Object> ytResult = result("业态", ytList, startD, endD, String.valueOf(map.get("dataType")));

        // 查询品类集客力
        List<Map<String, Object>> plList = collecBenefitMapper.getCollecCompareTrendPL(map);
        Map<String, Object> plResult = result("品类", plList, startD, endD, String.valueOf(map.get("dataType")));

        // 查询本店集客力
        List<Map<String, Object>> bdList = collecBenefitMapper.getCollecCompareTrendBD(map);
        Map<String, Object> bdResult = result("本店", bdList, startD, endD, String.valueOf(map.get("dataType")));

        // 拼返回值
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(bgcResult);
        list.add(ytResult);
        list.add(plResult);
        list.add(bdResult);
        log.info("请求 getCollecCompareTrend  end ，出参：{}", JSON.toJSON(list));
        return list;
    }

    /**
     * 方法名：result
     * 功能：返回值封装
     * 创建人：tanyp
     * 创建时间：2019/5/13 9:27
     * 入参：
     * 出参：
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    public static Map<String, Object> result(String name, List<Map<String, Object>> list, String startDate, String endDate, String type) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");

        List<String> dateList = new ArrayList<>();
        List<Double> valueList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            if ("3".equals(type)) {
                try {
                    Date date = format.parse(String.valueOf(map.get("datas")));
                    dateList.add(format.format(date));
                } catch (Exception e) {
                    log.info("格式化日期异常：{}", e.getMessage());
                }
            } else {
                dateList.add(String.valueOf(map.get("datas")));
            }
            if (map.get("num") != null) {
                valueList.add(Double.parseDouble(String.valueOf(map.get("num"))));
            } else {
                valueList.add(0.00d);
            }
        }

        List<String> dates = formatDay(startDate, endDate, type);
        List<Double> newList = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            if (!dateList.contains(dates.get(i))) {
                newList.add(0.00d);
            } else {
                int index = dateList.indexOf(dates.get(i));
                newList.add(valueList.get(index));
            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("names", name);
        resultMap.put("datas", dates);
        resultMap.put("values", newList);
        return resultMap;
    }

    /**
     * 方法名：getWeek
     * 功能：获取周
     * 创建人：tanyp
     * 创建时间：2019/5/10 16:27
     * 入参：
     * 出参：
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    public static Integer getWeek(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = format.parse(date);
        } catch (Exception e) {
            log.info("格式化日期异常：{}", e.getMessage());
        }
        cal.setTime(d);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 方法名：formatDay
     * 功能：获取某个时间内的时间段
     * 创建人：typ
     * 创建时间：2019/5/12 9:22
     * 入参：startDate：开始时间,endDate：结束时间
     * 出参：
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    public static List<String> formatDay(String startStr, String endStr, String type) {
        List<String> list = new ArrayList<>();
        try {
            if ("1".equals(type)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = sdf.parse(startStr);
                Date endDate = sdf.parse(endStr);
                list.add(format.format(startDate));
                // 设置开始时间
                Calendar start = Calendar.getInstance();
                start.setTime(startDate);
                // 设置结束时间
                Calendar end = Calendar.getInstance();
                end.setTime(endDate);
                while (endDate.after(start.getTime())) {
                    start.add(Calendar.DATE, 1);
                    list.add(format.format(start.getTime()));
                }
            } else if ("2".equals(type)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = sdf.parse(startStr);
                Date endDate = sdf.parse(endStr);
                // 设置开始时间
                Calendar start = Calendar.getInstance();
                start.setTime(startDate);
                list.add(String.valueOf(start.get(Calendar.WEEK_OF_YEAR)));
                // 设置结束时间
                Calendar end = Calendar.getInstance();
                end.setTime(endDate);
                while (endDate.after(start.getTime())) {
                    start.add(Calendar.WEEK_OF_YEAR, 1);
                    list.add(String.valueOf(start.get(Calendar.WEEK_OF_YEAR)));
                }
            } else if ("3".equals(type)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
                Date startDate = sdf.parse(startStr);
                Date endDate = sdf.parse(endStr);
                list.add(format.format(startDate));
                // 设置开始时间
                Calendar start = Calendar.getInstance();
                start.setTime(startDate);
                // 设置结束时间
                Calendar end = Calendar.getInstance();
                end.setTime(endDate);
                while (endDate.after(start.getTime())) {
                    start.add(Calendar.MONDAY, 1);
                    list.add(format.format(start.getTime()));
                }
            } else if ("4".equals(type)) {
                String year = startStr.substring(0, 4);
                list.add(year);
                int start = Integer.parseInt(year);
                int end = Integer.parseInt(endStr.substring(0, 4));
                while (true) {
                    start++;
                    if (start > end) {
                        break;
                    }
                    list.add(String.valueOf(start));
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "2018-05-20";
        String s1 = "2018-05-20";
        System.out.println(formatDay(s, s1, "4"));
    }

}
