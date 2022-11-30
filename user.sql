/*
 Navicat Premium Data Transfer

 Source Server         : Product
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 192.168.120.71:53307
 Source Schema         : demo01

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 30/11/2022 10:34:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `age`) VALUES (1, 'Tom', 10);
INSERT INTO `user` (`id`, `name`, `age`) VALUES (2, 'Jim', 12);
INSERT INTO `user` (`id`, `name`, `age`) VALUES (3, 'Lily', 13);
INSERT INTO `user` (`id`, `name`, `age`) VALUES (4, 'Mike', 9);
INSERT INTO `user` (`id`, `name`, `age`) VALUES (5, 'Sum', 8);
INSERT INTO `user` (`id`, `name`, `age`) VALUES (6, 'Lucy', 16);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
