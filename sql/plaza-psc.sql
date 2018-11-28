/*
Navicat MySQL Data Transfer

Source Server         : my_sql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : plaza-psc

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-21 17:24:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product_categroy
-- ----------------------------
DROP TABLE IF EXISTS `product_categroy`;
CREATE TABLE `product_categroy` (
  `categroy_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类目id',
  `categroy_name` varchar(45) CHARACTER SET utf8 DEFAULT NULL COMMENT '类目名',
  `categroy_type` int(11) DEFAULT NULL COMMENT '类目编号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`categroy_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of product_categroy
-- ----------------------------
INSERT INTO `product_categroy` VALUES ('1', '热榜', '1', '2018-10-08 20:21:09', '2018-10-08 20:21:09');
INSERT INTO `product_categroy` VALUES ('2', '好吃的', '2', '2018-10-08 20:21:09', '2018-10-08 20:21:09');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` varchar(45) COLLATE utf8_bin NOT NULL COMMENT '产品编号',
  `product_name` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '产品名称',
  `product_price` decimal(17,3) DEFAULT NULL COMMENT '产品单价',
  `product_stock` int(11) DEFAULT NULL COMMENT '产品库存',
  `product_description` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '产品描述',
  `product_icon` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '图标地址',
  `product_status` int(11) DEFAULT NULL COMMENT '产品状态０正常１下架',
  `categroy_type` int(11) DEFAULT NULL COMMENT '产品类目编号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('1539050185101901877', '米饭', '1.000', '1224', '香喷喷的米饭', 'http://www.mifan.com', '0', '1', '2018-10-08 20:25:33', '2018-10-08 20:25:33');
INSERT INTO `product_info` VALUES ('1539050185101901879', '瘦肉粥', '3.000', '1840', '好喝的瘦肉粥', 'http://www.shourouzhou.com', '0', '1', '2018-10-08 20:25:33', '2018-10-08 20:25:33');
INSERT INTO `product_info` VALUES ('1539050185101901880', '皮蛋', '1.000', '1692', '好吃的皮蛋', 'http://www.pidan.com', '0', '2', '2018-10-08 20:25:33', '2018-10-08 20:25:33');
INSERT INTO `product_info` VALUES ('1539050185101901891', '菜花', '8.000', '1211', '炒菜花', 'http://www.caihua.com', '1', '2', '2018-10-09 09:59:21', '2018-10-09 09:59:24');
