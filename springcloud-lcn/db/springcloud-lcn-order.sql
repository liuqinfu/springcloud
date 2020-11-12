/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100411
 Source Host           : localhost:3306
 Source Schema         : springcloud-lcn-order

 Target Server Type    : MySQL
 Target Server Version : 100411
 File Encoding         : 65001

 Date: 12/11/2020 23:46:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '商品名',
  `status` int(1) NOT NULL COMMENT '订单状态：1-待支付  0-未支付',
  `mount` decimal(10,2) NOT NULL COMMENT '订单金额',
  `good_id` int(11) NOT NULL COMMENT '商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
