package com.example.demo.mail.utils;

import com.example.demo.mail.entity.Mail;
import com.example.demo.mail.entity.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 路径：com.example.demo.mail.utils
 * 类名：
 * 功能：邮件发送工具类
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/21 11:34
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
public class MailUtil {

    /**
     * 方法名：
     * 功能：mail参数拼装
     * 描述：type：1、简单邮件 2、html邮件 3、附件邮件 4、图片邮件 5、模板邮件
     * 创建人：typ
     * 创建时间：2018/11/21 11:16
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static MimeMessage getMessage(MimeMessage message, Mail mail, Template template, TemplateEngine templateEngine, int type) {
        log.info("mail参数拼装 start");
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(mail.getAddresser()); // 发件人
            helper.setTo(mail.getAddressee()); // 收件人
            helper.setSubject(mail.getSubject()); // 标题
            // 普通邮件
            if (type == 1) {
                helper.setText(mail.getContent());
            } else {
                //true表示需要创建一个multipart message
                helper.setText(mail.getContent(), true);
            }
            // 添加图片
            if (type == 3) {
                helper.addInline(mail.getImgId(), file(mail.getImgPath()));
            }
            // 附件邮件
            if (type == 4) {
                FileSystemResource file = file(mail.getFilePath());
                helper.addAttachment(file.getFilename(), file);
            }
            // 模板邮件
            if (type == 5) {
                // 创建邮件正文
                Context context = new Context();
                context.setVariable("user", template.getUser());
                context.setVariable("name", template.getName());
                context.setVariable("company", template.getCompany());
                context.setVariable("product", template.getProduct());
                String text = templateEngine.process("emailTemplate", context);
                helper.setText(text, true);
            }
            log.info("mail参数拼装 end");
            return message;
        } catch (Exception e) {
            log.info("mail参数拼装异常：{}", e);
        }
        return null;
    }

    /**
     * 方法名：
     * 功能：读取文件
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/20 17:56
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public static FileSystemResource file(String path) {
        FileSystemResource file = null;
        if (path == null || "".equals(path)) {
            log.info("文件路径为空！");
            return null;
        }
        try {
            file = new FileSystemResource(new File(path));
            log.info("文件名：{}", file.getFilename());
        } catch (Exception e) {
            log.info("读取文件失败：{}", e);
        }
        return file;
    }

}
