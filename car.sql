/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : carsys

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2020-03-26 21:27:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `carmessage`
-- ----------------------------
DROP TABLE IF EXISTS `carmessage`;
CREATE TABLE `carmessage` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `carName` varchar(100) NOT NULL,
  `carType` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `carSeries` varchar(100) NOT NULL,
  `stock` int(100) NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carmessage
-- ----------------------------
INSERT INTO `carmessage` VALUES ('2', '奥迪', '中型车', '28.5-70.0万', 'A级', '10');
INSERT INTO `carmessage` VALUES ('3', '宝马', 'SUV', '30.8-56.3万', 'X1', '5');
INSERT INTO `carmessage` VALUES ('4', '宝马', 'SUV', '30.8-56.3万', 'X3', '10');
INSERT INTO `carmessage` VALUES ('5', '宝马', 'SUV', '30.8-56.3万', 'X5', '5');
INSERT INTO `carmessage` VALUES ('6', '宝马', '轿车', '30.8-56.3万', '宝马3系', '20');
INSERT INTO `carmessage` VALUES ('7', '宝马', '轿车', '30.8-56.3万', '宝马1系', '5');
INSERT INTO `carmessage` VALUES ('8', '宝马', '轿车', '30.8-56.3万', '宝马2系', '10');
INSERT INTO `carmessage` VALUES ('9', '宝马', '轿车', '30.8-56.3万', '宝马4系', '15');
INSERT INTO `carmessage` VALUES ('10', '奔驰', '中型车', '28.5-70.0万', 'C级', '8');
INSERT INTO `carmessage` VALUES ('11', '宾利', '中型车', '128.5-170.0万', '高级', '20');