package com.example.demo.mail.service;

import com.example.demo.mail.entity.Mail;

/**
 * 路径：com.example.demo.mail.service
 * 类名：
 * 功能：定义邮件发送的方法
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/20 17:19
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public interface MailService {

    boolean sendSimpleMail();

    boolean sendHtmlMail();

    boolean sendImageMail();

    boolean sendAttachmentsMail();

    boolean sendTemplateMail();
}
