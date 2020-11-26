package com.example.demo.mail.service.impl;

import com.example.demo.mail.entity.Mail;
import com.example.demo.mail.entity.Template;
import com.example.demo.mail.mapper.MailMapper;
import com.example.demo.mail.service.MailService;
import com.example.demo.mail.utils.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 路径：com.example.demo.mail.service.impl
 * 类名：
 * 功能：邮件发送实现类
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/20 17:20
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@Service
@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private MailMapper mailMapper;

    /**
     * 方法名：
     * 功能：普通邮件
     * 描述：type：1
     * 创建人：typ
     * 创建时间：2018/11/20 17:22
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public boolean sendSimpleMail() {
        try {
            Mail mail = mailMapper.find();
            MimeMessage mag = javaMailSender.createMimeMessage();
            MimeMessage message = MailUtil.getMessage(mag,mail,null,null,1);
            javaMailSender.send(message);
            log.info("普通邮件发送成功！");
            return true;
        } catch (Exception e) {
            log.info("发送普通邮件时发生异常:{}", e);
        }
        return false;
    }

    /**
     * 方法名：
     * 功能：发送Html邮件
     * 描述：type：2
     * 创建人：typ
     * 创建时间：2018/11/20 17:23
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public boolean sendHtmlMail() {
        try {
            Mail mail = mailMapper.find();
            MimeMessage mag = javaMailSender.createMimeMessage();
            MimeMessage message = MailUtil.getMessage(mag,mail,null,null,2);
            javaMailSender.send(message);
            log.info("html邮件发送成功");
            return true;
        } catch (Exception e) {
            log.info("发送html邮件时发生异常:{}", e);
        }
        return false;
    }

    /**
     * 方法名：
     * 功能：发送带图片的邮件
     * 描述：type:3
     * to：发送目标邮箱
     * subject：邮件标题
     * content：邮件内容
     * imgPath：图片路径
     * imgId：图片id，在img标签里使用
     * 创建人：typ
     * 创建时间：2018/11/20 18:13
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public boolean sendImageMail() {
        try {
            Mail mail = mailMapper.find();
            MimeMessage mag = javaMailSender.createMimeMessage();
            MimeMessage message = MailUtil.getMessage(mag,mail,null,null,3);
            javaMailSender.send(message);
            log.info("带图片的邮件已经发送。");
            return true;
        } catch (Exception e) {
            log.info("发送带图片的邮件失败：{}", e);
        }
        return false;
    }

    /**
     * 方法名：
     * 功能：发送带附件的邮件
     * 描述：type:4
     * 创建人：typ
     * 创建时间：2018/11/20 17:23
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public boolean sendAttachmentsMail() {
        try {
            Mail mail = mailMapper.find();
            MimeMessage mag = javaMailSender.createMimeMessage();
            MimeMessage message = MailUtil.getMessage(mag,mail,null,null,4);
            javaMailSender.send(message);
            log.info("带附件的邮件已经发送。");
            return true;
        } catch (Exception e) {
            log.info("发送带附件的邮件时发生异常:{}", e);
        }
        return false;
    }

    /**
     * 方法名：
     * 功能：发送模板邮件
     * 描述：type:5
     * 创建人：typ
     * 创建时间：2018/11/21 10:20
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public boolean sendTemplateMail() {
        try {
            Mail mail = mailMapper.find();
            MimeMessage mag = javaMailSender.createMimeMessage();
            Template template = mailMapper.getContent();
            MimeMessage message = MailUtil.getMessage(mag,mail,template,templateEngine,5);
            javaMailSender.send(message);
            log.info("模板邮件已经发送。");
            return true;
        } catch (Exception e) {
            log.info("模板邮件发送时发生异常:{}", e);
        }
        return false;
    }
}
