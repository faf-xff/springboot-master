package com.example.demo.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 路径：com.example.demo.number
 * 类名：DecimalPointUtils.java
 * 功能：常用数值保留小数点的工具类
 * 创建人：typ
 * 创建时间：2019/4/9 21:29
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class DecimalPointUtils {

    /**
     * 方法名：formatToDouble
     * 功能：double类型数值保留两位小数
     * 描述：返回值为double
     * 创建人：typ
     * 创建时间：2019/4/9 21:44
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static double formatToDouble(double number) {
        BigDecimal bigDecimal = new BigDecimal(number);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 方法名：formatToString
     * 功能：double类型的数值保留两位小数
     * 描述：返回值为String
     * 创建人：typ
     * 创建时间：2019/4/9 21:47
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static String formatToString(double number) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(number);
    }

    /**
     * 方法名：formatToStr
     * 功能：double 类型的数值保留两位小数
     * 描述：返回值为String
     * 创建人：typ
     * 创建时间：2019/4/9 21:52
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static String formatToStr(double number) {
        return String.format("%.2f", number);
    }

    /**
     * 方法名：formatToStr
     * 功能：String 类型的数值保留两位小数
     * 描述：返回值为String
     * 创建人：typ
     * 创建时间：2019/4/9 22:05
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static String formatToStr(String str){
        if(str != null && str.length() > 0){
            DecimalFormat format = new DecimalFormat("0.00");
            BigDecimal bigDecimal = new BigDecimal(str);
            return format.format(bigDecimal);
        }
        return "0.00";
    }

    public static void main(String[] args) {
        System.out.println(formatToStr("0"));
    }
}
