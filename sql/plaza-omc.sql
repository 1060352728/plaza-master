/*
Navicat MySQL Data Transfer

Source Server         : my_sql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : plaza-omc

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-21 17:24:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `order_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `product_id` varchar(45) COLLATE utf8_bin NOT NULL,
  `product_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `product_price` decimal(17,3) NOT NULL,
  `product_quantity` int(11) NOT NULL,
  `product_icon` varchar(45) COLLATE utf8_bin NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`detail_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1541123835005981509', '1541123833834409370', '1539050185101901877', '米饭', '1.000', '1', 'http://www.mifan.com', '2018-11-02 09:57:15', '2018-11-02 09:57:15');
INSERT INTO `order_detail` VALUES ('1541123835145864000', '1541123833834409370', '1539050185101901879', '瘦肉粥', '3.000', '4', 'http://www.shourouzhou.com', '2018-11-02 09:57:15', '2018-11-02 09:57:15');
INSERT INTO `order_detail` VALUES ('1541123913031474904', '1541123913011929341', '1539050185101901877', '米饭', '1.000', '1', 'http://www.mifan.com', '2018-11-02 09:58:33', '2018-11-02 09:58:33');
INSERT INTO `order_detail` VALUES ('1541123913038193336', '1541123913011929341', '1539050185101901879', '瘦肉粥', '3.000', '4', 'http://www.shourouzhou.com', '2018-11-02 09:58:33', '2018-11-02 09:58:33');
INSERT INTO `order_detail` VALUES ('1541127567761462691', '1541127567488863467', '1539050185101901877', '米饭', '1.000', '1', 'http://www.mifan.com', '2018-11-02 10:59:27', '2018-11-02 10:59:27');
INSERT INTO `order_detail` VALUES ('1541127567920232944', '1541127567488863467', '1539050185101901879', '瘦肉粥', '3.000', '4', 'http://www.shourouzhou.com', '2018-11-02 10:59:27', '2018-11-02 10:59:27');
INSERT INTO `order_detail` VALUES ('1541127644463355055', '1541127644451480942', '1539050185101901877', '米饭', '1.000', '1', 'http://www.mifan.com', '2018-11-02 11:00:44', '2018-11-02 11:00:44');
INSERT INTO `order_detail` VALUES ('1541127644480247077', '1541127644451480942', '1539050185101901879', '瘦肉粥', '3.000', '4', 'http://www.shourouzhou.com', '2018-11-02 11:00:44', '2018-11-02 11:00:44');
INSERT INTO `order_detail` VALUES ('1541127655252162605', '1541127655220595303', '1539050185101901877', '米饭', '1.000', '1', 'http://www.mifan.com', '2018-11-02 11:00:55', '2018-11-02 11:00:55');
INSERT INTO `order_detail` VALUES ('1541127655274609482', '1541127655220595303', '1539050185101901879', '瘦肉粥', '3.000', '4', 'http://www.shourouzhou.com', '2018-11-02 11:00:55', '2018-11-02 11:00:55');
INSERT INTO `order_detail` VALUES ('1541127660391234501', '1541127660381479301', '1539050185101901877', '米饭', '1.000', '1', 'http://www.mifan.com', '2018-11-02 11:01:00', '2018-11-02 11:01:00');
INSERT INTO `order_detail` VALUES ('1541127660407182735', '1541127660381479301', '1539050185101901879', '瘦肉粥', '3.000', '4', 'http://www.shourouzhou.com', '2018-11-02 11:01:00', '2018-11-02 11:01:00');
INSERT INTO `order_detail` VALUES ('1541128999302149991', '1541128999245120449', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-02 11:23:19', '2018-11-02 11:23:19');
INSERT INTO `order_detail` VALUES ('1541128999325367069', '1541128999245120449', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-02 11:23:19', '2018-11-02 11:23:19');
INSERT INTO `order_detail` VALUES ('1541129103910615076', '1541129103898930468', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-02 11:25:03', '2018-11-02 11:25:03');
INSERT INTO `order_detail` VALUES ('1541129103937991053', '1541129103898930468', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-02 11:25:03', '2018-11-02 11:25:03');
INSERT INTO `order_detail` VALUES ('1541488237833695619', '1541488237747153811', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-06 15:10:37', '2018-11-06 15:10:37');
INSERT INTO `order_detail` VALUES ('1541488237995919280', '1541488237747153811', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-06 15:10:37', '2018-11-06 15:10:37');
INSERT INTO `order_detail` VALUES ('1541490868981309606', '1541490868849430370', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-06 15:54:28', '2018-11-06 15:54:28');
INSERT INTO `order_detail` VALUES ('1541490869000167967', '1541490868849430370', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-06 15:54:29', '2018-11-06 15:54:29');
INSERT INTO `order_detail` VALUES ('1541492162772780017', '1541492162579546710', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-06 16:16:02', '2018-11-06 16:16:02');
INSERT INTO `order_detail` VALUES ('1541492162868867827', '1541492162579546710', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-06 16:16:02', '2018-11-06 16:16:02');
INSERT INTO `order_detail` VALUES ('1542003024389290127', '1542003024288336200', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-12 14:10:24', '2018-11-12 14:10:24');
INSERT INTO `order_detail` VALUES ('1542003024570136059', '1542003024288336200', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-12 14:10:24', '2018-11-12 14:10:24');
INSERT INTO `order_detail` VALUES ('1542004346479302990', '1542004346372641459', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-12 14:32:26', '2018-11-12 14:32:26');
INSERT INTO `order_detail` VALUES ('1542004346809814079', '1542004346372641459', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-12 14:32:26', '2018-11-12 14:32:26');
INSERT INTO `order_detail` VALUES ('1542173618322550844', '1542173617364941744', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-14 13:33:38', '2018-11-14 13:33:38');
INSERT INTO `order_detail` VALUES ('1542173618745860810', '1542173617364941744', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-14 13:33:38', '2018-11-14 13:33:38');
INSERT INTO `order_detail` VALUES ('1542173648984776197', '1542173648943891717', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-14 13:34:08', '2018-11-14 13:34:08');
INSERT INTO `order_detail` VALUES ('1542173649086463038', '1542173648943891717', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-14 13:34:09', '2018-11-14 13:34:09');
INSERT INTO `order_detail` VALUES ('1542173735361631760', '1542173734249412696', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-14 13:35:35', '2018-11-14 13:35:35');
INSERT INTO `order_detail` VALUES ('1542173735813784594', '1542173734249412696', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-14 13:35:35', '2018-11-14 13:35:35');
INSERT INTO `order_detail` VALUES ('1542173764207615082', '1542173764169228118', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-14 13:36:04', '2018-11-14 13:36:04');
INSERT INTO `order_detail` VALUES ('1542173764334836683', '1542173764169228118', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-14 13:36:04', '2018-11-14 13:36:04');
INSERT INTO `order_detail` VALUES ('1542173841302177717', '1542173840319494228', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-14 13:37:21', '2018-11-14 13:37:21');
INSERT INTO `order_detail` VALUES ('1542173841353496469', '1542173840319494228', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-14 13:37:21', '2018-11-14 13:37:21');
INSERT INTO `order_detail` VALUES ('1542270361296940805', '1542270361119890602', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-15 16:26:01', '2018-11-15 16:26:01');
INSERT INTO `order_detail` VALUES ('1542270362246125983', '1542270361119890602', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-15 16:26:02', '2018-11-15 16:26:02');
INSERT INTO `order_detail` VALUES ('1542276173360187768', '1542276172207571889', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-15 18:02:53', '2018-11-15 18:02:53');
INSERT INTO `order_detail` VALUES ('1542276173579745417', '1542276172207571889', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-15 18:02:53', '2018-11-15 18:02:53');
INSERT INTO `order_detail` VALUES ('1542791824445172955', '1542791824321894290', '1539050185101901880', '皮蛋', '1.000', '10', 'http://www.pidan.com', '2018-11-21 17:17:04', '2018-11-21 17:17:04');
INSERT INTO `order_detail` VALUES ('1542791824837410944', '1542791824321894290', '1539050185101901879', '瘦肉粥', '3.000', '10', 'http://www.shourouzhou.com', '2018-11-21 17:17:04', '2018-11-21 17:17:04');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `buyer_name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `buyer_phone` varchar(45) CHARACTER SET utf8 NOT NULL,
  `buyer_address` varchar(45) CHARACTER SET utf8 NOT NULL,
  `buyer_openid` varchar(45) COLLATE utf8_bin NOT NULL,
  `order_amount` decimal(17,3) NOT NULL,
  `order_status` int(11) NOT NULL,
  `pay_status` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1541123833834409370', 'member2', '13259102793', '西安科技四路209号', '222222', '13.000', '0', '0', '2018-11-06 16:08:49', '2018-11-06 16:08:49');
INSERT INTO `order_master` VALUES ('1541123913011929341', 'member2', '13259102793', '西安科技四路209号', '222222', '13.000', '0', '0', '2018-11-02 09:58:33', '2018-11-02 09:58:33');
INSERT INTO `order_master` VALUES ('1541127567488863467', 'member2', '13259102793', '西安科技四路209号', '222222', '13.000', '0', '0', '2018-11-02 10:59:28', '2018-11-02 10:59:28');
INSERT INTO `order_master` VALUES ('1541127644451480942', 'member2', '13259102793', '西安科技四路209号', '222222', '13.000', '0', '0', '2018-11-02 11:00:44', '2018-11-02 11:00:44');
INSERT INTO `order_master` VALUES ('1541127655220595303', 'member2', '13259102793', '西安科技四路209号', '222222', '13.000', '0', '0', '2018-11-02 11:00:55', '2018-11-02 11:00:55');
INSERT INTO `order_master` VALUES ('1541127660381479301', 'member2', '13259102793', '西安科技四路209号', '222222', '13.000', '0', '0', '2018-11-02 11:01:00', '2018-11-02 11:01:00');
INSERT INTO `order_master` VALUES ('1541128999245120449', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-02 11:23:19', '2018-11-02 11:23:19');
INSERT INTO `order_master` VALUES ('1541129103898930468', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-02 11:25:04', '2018-11-02 11:25:04');
INSERT INTO `order_master` VALUES ('1541488237747153811', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-06 15:10:38', '2018-11-06 15:10:38');
INSERT INTO `order_master` VALUES ('1541490868849430370', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-06 15:54:29', '2018-11-06 15:54:29');
INSERT INTO `order_master` VALUES ('1541492162579546710', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-06 16:16:03', '2018-11-06 16:16:03');
INSERT INTO `order_master` VALUES ('1542003024288336200', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-12 14:10:25', '2018-11-12 14:10:25');
INSERT INTO `order_master` VALUES ('1542004346372641459', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-12 14:32:27', '2018-11-12 14:32:27');
INSERT INTO `order_master` VALUES ('1542173617364941744', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-14 13:33:39', '2018-11-14 13:33:39');
INSERT INTO `order_master` VALUES ('1542173648943891717', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-14 13:34:09', '2018-11-14 13:34:09');
INSERT INTO `order_master` VALUES ('1542173734249412696', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-14 13:35:36', '2018-11-14 13:35:36');
INSERT INTO `order_master` VALUES ('1542173764169228118', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-14 13:36:04', '2018-11-14 13:36:04');
INSERT INTO `order_master` VALUES ('1542173840319494228', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-14 13:37:21', '2018-11-14 13:37:21');
INSERT INTO `order_master` VALUES ('1542270361119890602', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-15 16:26:03', '2018-11-15 16:26:03');
INSERT INTO `order_master` VALUES ('1542276172207571889', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-15 18:02:53', '2018-11-15 18:02:53');
INSERT INTO `order_master` VALUES ('1542791824321894290', 'member2', '13259102793', '西安科技四路209号', '222222', '40.000', '0', '0', '2018-11-21 17:17:05', '2018-11-21 17:17:05');
