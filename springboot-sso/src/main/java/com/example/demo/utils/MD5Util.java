package com.example.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 路径：com.example.demo.utils
 * 类名：MD5Util
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/4 18:02
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class MD5Util {

    /**
     * 方法名：getMD5
     * 功能：《用一句话描述一下》
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/5 9:36
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static String getMD5(String str) {
        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes()); // 通过使用 update 方法处理数据,使指定的 byte数组更新摘要
            byte[] encryptStr = md.digest(); // 获得密文完成哈希计算,产生128 位的长整数
            char s[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对每一个字节,转换成 16 进制字符的转换
                byte byte0 = encryptStr[i]; // 取第 i 个字节
                s[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
                s[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            return new String(s); // 换后的结果转换为字符串
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        String s = "123";
        System.out.println(getMD5(s));
    }
}
