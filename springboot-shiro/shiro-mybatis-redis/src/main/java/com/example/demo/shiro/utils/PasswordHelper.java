package com.example.demo.shiro.utils;

import com.example.demo.shiro.entity.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 路径：com.example.demo.shiro.utils
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/9 9:43
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class PasswordHelper {

    private String algorithmName = "md5";
    private int hashIterations = 2;

    /**
     * 方法名：
     * 功能：生成密码
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/9 9:49
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public void encryptPassword(User user){
        String newPassword = new SimpleHash(algorithmName,user.getPassword(), ByteSource.Util.bytes(user.getUsername()),hashIterations).toHex();
        user.setPassword(newPassword);
    }

    public static void main(String[] args) {
        PasswordHelper helper = new PasswordHelper();
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        helper.encryptPassword(user);
        System.out.println(user);
    }
}
