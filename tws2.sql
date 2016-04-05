/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50617
Source Host           : 127.0.0.1:3306
Source Database       : tws2

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-04-05 21:48:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `COMPANY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOCATION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`COMPANY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', 'Xian', 'A');
INSERT INTO `company` VALUES ('2', 'Xian', 'B');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `DEPARTMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `COMPANY_ID` int(11) NOT NULL,
  PRIMARY KEY (`DEPARTMENT_ID`),
  KEY `FK_spu5g1aj55xrq2ymb3xsbc4o1` (`COMPANY_ID`),
  CONSTRAINT `FK_spu5g1aj55xrq2ymb3xsbc4o1` FOREIGN KEY (`COMPANY_ID`) REFERENCES `company` (`COMPANY_ID`),
  CONSTRAINT `FKf828hlteu96rlgxienbmh1414` FOREIGN KEY (`COMPANY_ID`) REFERENCES `company` (`COMPANY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '计算机修理部', '1');
INSERT INTO `department` VALUES ('2', '汽车修理', '2');
INSERT INTO `department` VALUES ('3', '计算机', '2');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `EMPLOYEE_TYPE` varchar(31) NOT NULL,
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_NAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `DEPARTMENT_ID` int(11) DEFAULT NULL,
  `COMPANY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`),
  KEY `FK_n65lxopo5ycytxgi38vneifps` (`COMPANY_ID`),
  KEY `FK_hy51t1ghy9d2pvy1jjgy6bjim` (`DEPARTMENT_ID`),
  CONSTRAINT `FK_hy51t1ghy9d2pvy1jjgy6bjim` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `department` (`DEPARTMENT_ID`),
  CONSTRAINT `FK8fslohklyv7h7794crablcbqm` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `department` (`DEPARTMENT_ID`),
  CONSTRAINT `FKkcgp98qp1232p52bldftyaikq` FOREIGN KEY (`COMPANY_ID`) REFERENCES `company` (`COMPANY_ID`),
  CONSTRAINT `FK_n65lxopo5ycytxgi38vneifps` FOREIGN KEY (`COMPANY_ID`) REFERENCES `company` (`COMPANY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('一般员工', '1', 'bb', '123456', '1', null);
INSERT INTO `employee` VALUES ('专家', '2', 'a', '123456', null, '1');
INSERT INTO `employee` VALUES ('一般员工', '3', '小强', '123', '1', null);
INSERT INTO `employee` VALUES ('管理员', '4', 'admin', 'admin', null, '1');

-- ----------------------------
-- Table structure for employeerequest
-- ----------------------------
DROP TABLE IF EXISTS `employeerequest`;
CREATE TABLE `employeerequest` (
  `REQUEST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `REQUEST_STATUS` int(11) DEFAULT NULL,
  `REQUEST_TIME` datetime DEFAULT NULL,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `TOOL_ID` int(11) NOT NULL,
  PRIMARY KEY (`REQUEST_ID`),
  KEY `FK_j5ikrsxfwhktf3g3h6r0c5nw3` (`EMPLOYEE_ID`),
  KEY `FK_nl3walmraw917yibukwq42vu6` (`TOOL_ID`),
  CONSTRAINT `FK_nl3walmraw917yibukwq42vu6` FOREIGN KEY (`TOOL_ID`) REFERENCES `tool` (`TOOL_ID`),
  CONSTRAINT `FK_j5ikrsxfwhktf3g3h6r0c5nw3` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`EMPLOYEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeerequest
-- ----------------------------
INSERT INTO `employeerequest` VALUES ('1', '2', '2016-03-30 17:52:57', '2', '1');
INSERT INTO `employeerequest` VALUES ('2', '2', '2016-03-30 18:01:29', '2', '1');
INSERT INTO `employeerequest` VALUES ('3', '1', '2016-03-30 18:04:36', '2', '2');
INSERT INTO `employeerequest` VALUES ('6', '2', '2016-04-05 21:33:26', '1', '1');
INSERT INTO `employeerequest` VALUES ('7', '1', '2016-04-05 21:33:32', '1', '1');
INSERT INTO `employeerequest` VALUES ('8', '1', '2016-04-05 21:33:37', '1', '1');
INSERT INTO `employeerequest` VALUES ('9', '1', '2016-04-05 21:33:47', '1', '1');
INSERT INTO `employeerequest` VALUES ('10', '1', '2016-04-05 21:33:51', '1', '1');
INSERT INTO `employeerequest` VALUES ('11', '1', '2016-04-05 21:33:55', '1', '1');

-- ----------------------------
-- Table structure for employee_tools
-- ----------------------------
DROP TABLE IF EXISTS `employee_tools`;
CREATE TABLE `employee_tools` (
  `EMPLOYEE_ID` int(11) DEFAULT NULL,
  `TOOL_ID` int(11) NOT NULL,
  PRIMARY KEY (`TOOL_ID`),
  KEY `FK_562x1seqb2lkyyt4fj6gf6uks` (`EMPLOYEE_ID`),
  CONSTRAINT `FK_orf4htr2pbp89cjaueyilqm34` FOREIGN KEY (`TOOL_ID`) REFERENCES `tool` (`TOOL_ID`),
  CONSTRAINT `FK_562x1seqb2lkyyt4fj6gf6uks` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_tools
-- ----------------------------
INSERT INTO `employee_tools` VALUES ('1', '1');

-- ----------------------------
-- Table structure for lend
-- ----------------------------
DROP TABLE IF EXISTS `lend`;
CREATE TABLE `lend` (
  `LEND_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LEND_OPERATE` int(11) DEFAULT NULL,
  `LEND_TIME` datetime DEFAULT NULL,
  `EMPLOYEE_ID` int(11) NOT NULL,
  `TOOL_ID` int(11) NOT NULL,
  PRIMARY KEY (`LEND_ID`),
  KEY `FK_ghe3bi79ejpm6mchiaucrd3oh` (`EMPLOYEE_ID`),
  KEY `FK_6fnfuv5b585ga4xpmr2cdhism` (`TOOL_ID`),
  CONSTRAINT `FK_6fnfuv5b585ga4xpmr2cdhism` FOREIGN KEY (`TOOL_ID`) REFERENCES `tool` (`TOOL_ID`),
  CONSTRAINT `FK_ghe3bi79ejpm6mchiaucrd3oh` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `employee` (`EMPLOYEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lend
-- ----------------------------
INSERT INTO `lend` VALUES ('1', '1', '2016-03-30 18:49:00', '2', '3');
INSERT INTO `lend` VALUES ('3', '2', '2016-03-30 18:49:27', '2', '3');
INSERT INTO `lend` VALUES ('4', '1', '2016-03-30 20:49:00', '2', '3');
INSERT INTO `lend` VALUES ('5', '2', '2016-03-30 23:24:23', '2', '3');
INSERT INTO `lend` VALUES ('6', '2', '2016-03-31 08:02:32', '2', '3');
INSERT INTO `lend` VALUES ('7', '1', '2016-03-31 08:26:44', '2', '1');
INSERT INTO `lend` VALUES ('8', '1', '2016-03-31 08:33:22', '2', '1');
INSERT INTO `lend` VALUES ('9', '1', '2016-03-31 08:39:02', '2', '1');
INSERT INTO `lend` VALUES ('10', '1', '2016-03-31 08:39:56', '2', '2');
INSERT INTO `lend` VALUES ('11', '1', '2016-03-31 08:40:50', '2', '2');
INSERT INTO `lend` VALUES ('12', '1', '2016-03-31 08:44:13', '2', '2');
INSERT INTO `lend` VALUES ('13', '1', '2016-03-31 08:44:37', '2', '1');
INSERT INTO `lend` VALUES ('14', '1', '2016-03-31 08:45:14', '2', '1');
INSERT INTO `lend` VALUES ('15', '1', '2016-03-31 08:45:24', '2', '1');
INSERT INTO `lend` VALUES ('16', '1', '2016-03-31 08:46:52', '2', '1');
INSERT INTO `lend` VALUES ('17', '1', '2016-03-31 08:48:41', '2', '1');
INSERT INTO `lend` VALUES ('18', '1', '2016-03-31 08:50:12', '2', '1');
INSERT INTO `lend` VALUES ('19', '1', '2016-03-31 08:50:46', '2', '1');
INSERT INTO `lend` VALUES ('20', '1', '2016-03-31 08:53:56', '2', '1');
INSERT INTO `lend` VALUES ('21', '1', '2016-03-31 08:55:40', '2', '2');
INSERT INTO `lend` VALUES ('22', '1', '2016-03-31 08:58:31', '2', '2');
INSERT INTO `lend` VALUES ('23', '1', '2016-03-31 08:59:51', '2', '2');
INSERT INTO `lend` VALUES ('24', '1', '2016-03-31 09:17:27', '2', '1');
INSERT INTO `lend` VALUES ('25', '1', '2016-03-31 13:46:13', '2', '2');
INSERT INTO `lend` VALUES ('26', '2', '2016-03-31 13:46:34', '2', '1');
INSERT INTO `lend` VALUES ('27', '2', '2016-03-31 13:46:37', '2', '2');
INSERT INTO `lend` VALUES ('28', '1', '2016-04-05 21:36:49', '1', '1');

-- ----------------------------
-- Table structure for robot
-- ----------------------------
DROP TABLE IF EXISTS `robot`;
CREATE TABLE `robot` (
  `ROBOT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROBOT_STATUS` int(11) DEFAULT NULL,
  `COMPANY_ID` int(11) NOT NULL,
  PRIMARY KEY (`ROBOT_ID`),
  KEY `FK_66l9rq698qbg3ydpsiugl26kp` (`COMPANY_ID`),
  CONSTRAINT `FK_66l9rq698qbg3ydpsiugl26kp` FOREIGN KEY (`COMPANY_ID`) REFERENCES `company` (`COMPANY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of robot
-- ----------------------------
INSERT INTO `robot` VALUES ('1', '1', '1');
INSERT INTO `robot` VALUES ('2', '1', '1');
INSERT INTO `robot` VALUES ('3', '1', '1');
INSERT INTO `robot` VALUES ('5', '1', '1');
INSERT INTO `robot` VALUES ('6', '1', '1');
INSERT INTO `robot` VALUES ('7', '1', '1');

-- ----------------------------
-- Table structure for tool
-- ----------------------------
DROP TABLE IF EXISTS `tool`;
CREATE TABLE `tool` (
  `TOOL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TOOL_NAME` varchar(255) DEFAULT NULL,
  `TOOL_STATUS` int(11) DEFAULT NULL,
  `TOOL_TYPE` varchar(255) NOT NULL,
  `DEPARTMENT_ID` int(11) NOT NULL,
  PRIMARY KEY (`TOOL_ID`),
  KEY `FK_hon05lmn7520ce52ijkh024bd` (`DEPARTMENT_ID`),
  CONSTRAINT `FK_hon05lmn7520ce52ijkh024bd` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `department` (`DEPARTMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tool
-- ----------------------------
INSERT INTO `tool` VALUES ('1', '螺丝刀', '2', '廉价工具', '1');
INSERT INTO `tool` VALUES ('2', '板子', '1', '廉价工具', '1');
INSERT INTO `tool` VALUES ('3', '电钻', '1', '贵重工具', '1');
INSERT INTO `tool` VALUES ('4', '托盘', '1', '贵重工具', '2');
INSERT INTO `tool` VALUES ('6', '板子', '1', '廉价工具', '2');
