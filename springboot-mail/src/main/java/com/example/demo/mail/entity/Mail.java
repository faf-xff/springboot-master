package com.example.demo.mail.entity;

import lombok.Data;

/**
 * 路径：com.example.demo.mail.entity
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/21 9:45
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Data
public class Mail {

    //id
    private Integer id;
    // 发件人
    private String addresser;
    // 收件人
    private String addressee;
    // 主题
    private String subject;
    // 内容
    private String content;
    // 文件路径
    private String filePath;
    // 图片路径
    private String imgPath;
    // 图片ID
    private String imgId;
}
