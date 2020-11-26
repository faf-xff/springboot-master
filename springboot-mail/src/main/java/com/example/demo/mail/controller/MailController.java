package com.example.demo.mail.controller;

import com.example.demo.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;

/**
 * 路径：com.example.demo.mail.controller
 * 类名：发送邮件
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/20 17:28
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    /**
     * 方法名：
     * 功能：普通邮件
     * 描述：http://localhost:8081/mail/sendSimpleMail
     * 创建人：typ
     * 创建时间：2018/11/20 17:29
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @RequestMapping("/sendSimpleMail")
    public String sendSimpleMail() {
        boolean result = mailService.sendSimpleMail();
        if(result){
            return "发送成功！";
        }
        return "发送失败！";
    }

    /**
     * 方法名：
     * 功能：发送Html格式的邮件
     * 描述：http://localhost:8081/mail/sendHtmlMail
     * 创建人：typ
     * 创建时间：2018/11/20 17:29
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @RequestMapping("/sendHtmlMail")
    public String sendHtmlMail() {
        boolean result = mailService.sendHtmlMail();
        if(result){
            return "发送成功！";
        }
        return "发送失败！";
    }

    /**
     * 方法名：
     * 功能：发送带图片的邮件(收件人，主题，内容)
     * 描述：http://localhost:8081/mail/sendImageMail
     * 创建人：typ
     * 创建时间：2018/11/20 18:18
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @RequestMapping("/sendImageMail")
    public String sendImageMail(){
        boolean result = mailService.sendImageMail();
        if(result){
            return "发送成功！";
        }
        return "发送失败！";
    }

    /**
     * 方法名：
     * 功能：发送带有附件的邮件
     * 描述：http://localhost:8081/mail/sendAttachmentsMail
     * 创建人：typ
     * 创建时间：2018/11/20 17:30
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @RequestMapping("/sendAttachmentsMail")
    public String sendAttachmentsMail() {
        boolean result = mailService.sendAttachmentsMail();
        if(result){
            return "发送成功！";
        }
        return "发送失败！";
    }

    /**
     * 方法名：
     * 功能：发送模板邮件
     * 描述：http://localhost:8081/mail/sendTemplateMail
     * 创建人：typ
     * 创建时间：2018/11/20 17:30
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @RequestMapping("/sendTemplateMail")
    public String sendTemplateMail() {
        boolean result = mailService.sendTemplateMail();
        if(result){
            return "发送成功！";
        }
        return "发送失败！";
    }
}
