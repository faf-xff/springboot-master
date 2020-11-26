package com.example.demo.mail.mapper;


import com.example.demo.mail.entity.Mail;
import com.example.demo.mail.entity.Template;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 路径：com.example.demo.mail.mapper
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/21 10:54
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Mapper
public interface MailMapper {

    @Select("select id,addresser,addressee,subject,content,filePath,imgPath,imgId from mail")
    Mail find();

    @Select("select id,user,name,company,product from template")
    Template getContent();
}
