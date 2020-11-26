# Host: 127.0.0.1  (Version 5.7.21)
# Date: 2018-11-21 12:23:02
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "template"
#

DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `user` varchar(50) DEFAULT NULL COMMENT '用户名',
  `name` varchar(200) DEFAULT NULL COMMENT '网名',
  `company` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `product` varchar(200) DEFAULT NULL COMMENT '产品',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "template"
#

INSERT INTO `template` VALUES (1,'测试人','测试公司名称','测试网址','测试产品');
