package com.example.demo.websocket.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 路径：com.example.demo.websocket.config
 * 类名：
 * 功能：提供一个PasswordEncorder的实例，否则后台会报错误
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/18 11:48
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class PasswordEncoderConfig implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
