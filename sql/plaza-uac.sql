/*
Navicat MySQL Data Transfer

Source Server         : my_sql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : plaza-uac

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-17 13:26:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `menu_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES ('1', '完结订单', '/api-omc/order/finish', '/api-omc/order/finish');
INSERT INTO `menu_info` VALUES ('2', '创建订单', '/api-omc/order/creat', '/api-omc/order/creat');
INSERT INTO `menu_info` VALUES ('3', '订单列表', '/api-omc/order/list', '/api-omc/order/list');
INSERT INTO `menu_info` VALUES ('4', '查询订单', '/api-omc/order/findbyid', '/api-omc/order/findbyid');
INSERT INTO `menu_info` VALUES ('5', '查询产品', '/api-psc/product/list', '/api-psc/product/list');
INSERT INTO `menu_info` VALUES ('6', '用户查询', '/api-uac/user/findbyusername', '/api-uac/user/findbyusername');

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('1', '卖家', 'seller');
INSERT INTO `role_info` VALUES ('2', '买家', 'buyer');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1');
INSERT INTO `role_menu` VALUES ('2', '1', '3');
INSERT INTO `role_menu` VALUES ('3', '1', '4');
INSERT INTO `role_menu` VALUES ('4', '1', '5');
INSERT INTO `role_menu` VALUES ('5', '1', '6');
INSERT INTO `role_menu` VALUES ('6', '2', '2');
INSERT INTO `role_menu` VALUES ('7', '2', '3');
INSERT INTO `role_menu` VALUES ('8', '2', '4');
INSERT INTO `role_menu` VALUES ('9', '2', '5');
INSERT INTO `role_menu` VALUES ('10', '2', '6');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` varchar(32) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `openid` varchar(64) DEFAULT NULL,
  `role` int(11) NOT NULL COMMENT '1买家,2卖家',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1233232421435', 'seller', '{bcrypt}$2a$10$tcOu52t.W/UUapQbEsflu.6IeRhpsSbBe1llg4cYLwwlwjGqqf4E6', '222222', '1', '2018-11-21 10:10:16', '2018-11-21 10:10:16');
INSERT INTO `user_info` VALUES ('1241231323321', 'buyer', '{bcrypt}$2a$10$tcOu52t.W/UUapQbEsflu.6IeRhpsSbBe1llg4cYLwwlwjGqqf4E6', '111111', '2', '2018-11-21 10:10:19', '2018-11-21 10:10:19');
