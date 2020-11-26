# Host: 127.0.0.1  (Version 5.7.21)
# Date: 2018-11-21 12:22:54
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "mail"
#

DROP TABLE IF EXISTS `mail`;
CREATE TABLE `mail` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `addresser` varchar(50) DEFAULT NULL COMMENT '发件人',
  `addressee` varchar(50) DEFAULT NULL COMMENT '收件人',
  `subject` varchar(200) DEFAULT NULL COMMENT '主题',
  `content` text COMMENT '内容',
  `filePath` varchar(200) DEFAULT NULL COMMENT '文件路径',
  `imgPath` varchar(200) DEFAULT NULL COMMENT '图片路径',
  `imgId` varchar(50) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "mail"
#

INSERT INTO `mail` VALUES (1,'typ1805@163.com','742354529@qq.com','测试邮件','您好！我是来自测试的邮件信息。','F:/test.txt','F:/test.jpg','test');
