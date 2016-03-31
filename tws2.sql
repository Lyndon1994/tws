/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50617
Source Host           : 127.0.0.1:3306
Source Database       : tws2

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-03-30 12:45:53
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '计算机修理部', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('一般员工', '1', 'bb', '123456', '1', null);
INSERT INTO `employee` VALUES ('专家', '2', 'a', '1234', null, '1');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employeerequest
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lend
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of robot
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tool
-- ----------------------------
