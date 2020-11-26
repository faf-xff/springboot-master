package com.example.demo.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 路径：com.example.demo.date
 * 类名：DateFormatUtils.java
 * 功能：常用日期类型转换工具类
 * 创建人：typ
 * 创建时间：2019/4/9 22:10
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class DateFormatUtils {

    public static void main(String[] args) {
        System.out.println(currentTime());
    }

    /**
     * 方法名：currentTime
     * 功能：获取当前时间
     * 描述：返回值为当前的Date值
     * 创建人：typ
     * 创建时间：2019/4/9 22:20
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static Date currentTime(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 方法名：format
     * 功能：String时间格式化为标准时间格式：yyyy-MM-dd HH:mm:ss
     * 描述：返回值为时间String
     * 创建人：typ
     * 创建时间：2019/4/9 22:14
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static String format(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format(format.parse(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 方法名：formatHour
     * 功能：获取某个时间内的时间段
     * 创建人：typ
     * 创建时间：2019/4/3 9:22
     * 入参：startDate：开始时间,endDate：结束时间
     * 出参：[07:00, 08:00, 09:00, 10:00, 11:00, 12:00, 13:00, 14:00, 15:00, 16:00, 17:00, 18:00, 19:00, 20:00, 21:00]
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    public static List<String> formatHour(String startStr, String endStr) {
        List<String> list = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date startDate = sdf.parse(startStr);
            Date endDate = sdf.parse(endStr);
            SimpleDateFormat format = new SimpleDateFormat("HH:00");
            list.add(format.format(startDate));
            // 设置开始时间
            Calendar start = Calendar.getInstance();
            start.setTime(startDate);
            // 设置结束时间
            Calendar end = Calendar.getInstance();
            end.setTime(endDate);
            while (endDate.after(start.getTime())) {
                start.add(Calendar.HOUR, 1);
                list.add(format.format(start.getTime()));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 方法名：formatWeek
     * 功能：获取某个时间内的周时间段
     * 创建人：typ
     * 创建时间：2019/4/3 9:22
     * 入参：startDate：开始时间,endDate：结束时间
     * 出参：[1, 2, 3, 4]
     * 修改人：
     * 修改时间：
     * 修改备注：
     */
    public static List<String> formatWeek(String startStr, String endStr){
        List<String> list = new ArrayList<>();
        try{
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
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
