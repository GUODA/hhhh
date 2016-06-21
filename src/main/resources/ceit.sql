/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : ceit

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2016-06-10 18:55:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '在支持支持', '213123', '123123');

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for `ceitinfo`
-- ----------------------------
DROP TABLE IF EXISTS `ceitinfo`;
CREATE TABLE `ceitinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `notice` varchar(45) DEFAULT NULL,
  `teacher` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ceitinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `certification`
-- ----------------------------
DROP TABLE IF EXISTS `certification`;
CREATE TABLE `certification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `competdate_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `competdate_id` (`competdate_id`),
  CONSTRAINT `certification_ibfk_1` FOREIGN KEY (`competdate_id`) REFERENCES `competdate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of certification
-- ----------------------------

-- ----------------------------
-- Table structure for `competdate`
-- ----------------------------
DROP TABLE IF EXISTS `competdate`;
CREATE TABLE `competdate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `material` varchar(45) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `competdate_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competdate
-- ----------------------------

-- ----------------------------
-- Table structure for `competition`
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `proccess` varchar(45) DEFAULT NULL,
  `certification_id` int(11) DEFAULT NULL,
  `competype_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `certification_id` (`certification_id`),
  KEY `competype_id` (`competype_id`),
  CONSTRAINT `competition_ibfk_1` FOREIGN KEY (`certification_id`) REFERENCES `certification` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `competition_ibfk_2` FOREIGN KEY (`competype_id`) REFERENCES `competype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competition
-- ----------------------------

-- ----------------------------
-- Table structure for `competype`
-- ----------------------------
DROP TABLE IF EXISTS `competype`;
CREATE TABLE `competype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competype
-- ----------------------------

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `sncode` varchar(45) DEFAULT NULL,
  `madetime` datetime DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `version` varchar(45) DEFAULT NULL,
  `devicetype_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `devicetype_id` (`devicetype_id`),
  CONSTRAINT `device_ibfk_1` FOREIGN KEY (`devicetype_id`) REFERENCES `devicetype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------

-- ----------------------------
-- Table structure for `devicetype`
-- ----------------------------
DROP TABLE IF EXISTS `devicetype`;
CREATE TABLE `devicetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of devicetype
-- ----------------------------

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `types` int(11) DEFAULT NULL,
  `resourse` varchar(255) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `instance` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `resoursePerm` tinyint(1) NOT NULL,
  `systemPerm` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for `permission_role`
-- ----------------------------
DROP TABLE IF EXISTS `permission_role`;
CREATE TABLE `permission_role` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `permission_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `permission_role_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission_role
-- ----------------------------

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `teacher` varchar(45) DEFAULT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `projecttype_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `projecttype_id` (`projecttype_id`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`projecttype_id`) REFERENCES `projecttype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for `projecttype`
-- ----------------------------
DROP TABLE IF EXISTS `projecttype`;
CREATE TABLE `projecttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projecttype
-- ----------------------------

-- ----------------------------
-- Table structure for `project_user`
-- ----------------------------
DROP TABLE IF EXISTS `project_user`;
CREATE TABLE `project_user` (
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`project_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `project_user_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `project_user_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_user
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `isDelete` tinyint(4) DEFAULT NULL,
  `sort` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `system` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '2016-06-01 18:26:35', '超级管理员', '0', '1', '1', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `account` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `create_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', 'admin', null, null);

-- ----------------------------
-- Table structure for `user_message`
-- ----------------------------
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `loginIp` varchar(255) DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_message_ibfk_1` (`user_id`),
  CONSTRAINT `user_message_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_message
-- ----------------------------
INSERT INTO `user_message` VALUES ('4', null, null, null, null, null, '127.0.0.1', '2016-06-10 18:51:10', '1', null, null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `web`
-- ----------------------------
DROP TABLE IF EXISTS `web`;
CREATE TABLE `web` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `webtype_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `webtype_id` (`webtype_id`),
  CONSTRAINT `web_ibfk_1` FOREIGN KEY (`webtype_id`) REFERENCES `webtype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web
-- ----------------------------
INSERT INTO `web` VALUES ('1', '阿诗丹顿', 'sdkfjsd', 'sdfsdf', '1');
INSERT INTO `web` VALUES ('2', 'qw', 'dfgsd', 'sdgs', '3');
INSERT INTO `web` VALUES ('3', '撒旦', 'sdfs', 'fsdf', '3');

-- ----------------------------
-- Table structure for `webtype`
-- ----------------------------
DROP TABLE IF EXISTS `webtype`;
CREATE TABLE `webtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of webtype
-- ----------------------------
INSERT INTO `webtype` VALUES ('1', '快递收发货的');
INSERT INTO `webtype` VALUES ('2', '放的地方');
INSERT INTO `webtype` VALUES ('3', 'sf');
