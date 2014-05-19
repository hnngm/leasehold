CREATE DATABASE `leasehold` ;
USE `highwaywebgis` ;
--创建用户表
DROP TABLE IF EXISTS `sys_user` ;

CREATE TABLE `sys_user` (
  `user_id` VARCHAR (40) NOT NULL COMMENT 'user_id',
  `username` VARCHAR (40) DEFAULT NULL COMMENT '用户名',
  `email` VARCHAR (80) DEFAULT NULL COMMENT 'email',
  `password` VARCHAR (64) DEFAULT NULL COMMENT '密码',
  `real_name` VARCHAR (30) DEFAULT NULL COMMENT '真实名',
  `salt` VARCHAR (64) DEFAULT NULL COMMENT 'salt',
  `unit_code` VARCHAR (30) DEFAULT NULL COMMENT '单位编码',
  `enable` INT DEFAULT NULL COMMENT '是否可用',
  `last_login_time` DATETIME DEFAULT NULL COMMENT '最后登录时间',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 ;

INSERT INTO `sys_user` 
VALUES
  (
    '38f223f7-71ed-4b8f-987c-d4ac122a4064',
    'admin',
    'admin@163.com',
    '829c935ac53c86f8b6496db84230dd7b1ca54f34',
    'fsasda',
    'af620640aea8a309',
    1,
    '1986-10-28 00:00:00',
    '1986-10-28 00:00:00',
    '1986-10-28 00:00:00'
  ) ;