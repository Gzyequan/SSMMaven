/*
Navicat MySQL Data Transfer

Source Server         : AREdu
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : chatrobot

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-02-11 11:02:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(127) NOT NULL,
  `email` varchar(255) NOT NULL COMMENT '用户邮箱',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `username` varchar(255) NOT NULL COMMENT '用户昵称',
  `role` varchar(255) NOT NULL COMMENT '用户身份',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `regTime` datetime NOT NULL COMMENT '注册时间',
  `regIp` varchar(255) NOT NULL COMMENT '注册IP',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xxx', 'xxxxx', 'xxxxx', 'root', '0', '2017-03-28 09:40:31', '127.0.0.1');
INSERT INTO `user` VALUES ('2', '673541964@qq.com', '123', 'Lily', 'consumer', '0', '2017-03-28 09:40:31', '127.0.0.1');
INSERT INTO `user` VALUES ('3', '1635125609@qq.com', '123', 'yequan', 'root', '0', '2018-01-30 15:15:31', '127.0.0.1');
INSERT INTO `user` VALUES ('712676003053855', '1635125608@qq.com', '123', 'Tom', 'consumer', '0', '2018-01-31 17:28:45', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('712683250827551', '123@qq.com', '123', 'Tom', 'consumer', '0', '2018-01-31 17:29:12', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('712713584066847', '1@qq.com', '123', 'Tom', 'consumer', '0', '2018-01-31 17:31:05', '192.168.1.133');
INSERT INTO `user` VALUES ('728757165911894', '5@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 10:07:12', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('728788036005718', '6@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 10:09:07', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('729054323949756', '7@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 10:25:39', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('729779368121036', '4@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 11:10:41', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('729911169927588', '8@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 11:18:51', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('729929691990436', '9@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 11:20:01', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('730070352163795', '10@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 11:28:45', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('730193564036528', '11@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 11:36:23', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('730219602278442', '12@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 11:38:05', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('730242419308586', '13@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 11:39:25', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('730369389260382', '18@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 11:47:18', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('730404554321502', '19@qq.com', '123', 'Tom', 'consumer', '0', '2018-02-01 11:49:29', '192.168.1.155');
INSERT INTO `user` VALUES ('732163343404827', '20@qq.com', '123', 'Jack', 'root', '0', '2018-02-01 13:38:41', '0:0:0:0:0:0:0:1');
INSERT INTO `user` VALUES ('732178107371291', '21@qq.com', '123', 'Rose', 'root', '0', '2018-02-01 13:39:36', '192.168.1.155');
INSERT INTO `user` VALUES ('732448690327323', '22@qq.com', '123', 'Rose', 'root', '0', '2018-02-01 13:56:24', '192.168.1.155');
SET FOREIGN_KEY_CHECKS=1;
