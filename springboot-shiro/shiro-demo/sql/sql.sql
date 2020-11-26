# Host: 127.0.0.1  (Version 5.7.21)
# Date: 2018-10-08 22:26:32
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "shiro_user"
#

DROP TABLE IF EXISTS `shiro_user`;
CREATE TABLE `shiro_user` (
  `id` varchar(32) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "shiro_user"
#

INSERT INTO `shiro_user` VALUES ('1','test@shiro.com','123456');


#
# Structure for table "shiro_user_role"
#

DROP TABLE IF EXISTS `shiro_user_role`;
CREATE TABLE `shiro_user_role` (
  `id` varchar(32) DEFAULT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "shiro_user_role"
#

INSERT INTO `shiro_user_role` VALUES ('1','admin','test@shiro.com'),('2','test','test@shiro.com');

#
# Structure for table "shiro_role_permission"
#

DROP TABLE IF EXISTS `shiro_role_permission`;
CREATE TABLE `shiro_role_permission` (
  `id` varchar(32) DEFAULT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `perm_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "shiro_role_permission"
#

INSERT INTO `shiro_role_permission` VALUES ('1','admin','perm1'),('2','test','guest');