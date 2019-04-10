/*
Navicat MySQL Data Transfer

Source Server         : 192.168.10.2
Source Server Version : 50633
Source Host           : 192.168.10.2:3306
Source Database       : brant_test

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2019-04-09 18:28:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for table_audit_record
-- ----------------------------
DROP TABLE IF EXISTS `table_audit_record`;
CREATE TABLE `table_audit_record` (
  `id` varchar(50) NOT NULL,
  `tlr_id` varchar(50) DEFAULT NULL,
  `update_meta` varchar(100) DEFAULT NULL,
  `before` varchar(255) DEFAULT NULL,
  `after` varchar(255) DEFAULT NULL,
  `update_sql` varchar(255) DEFAULT NULL,
  `create_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for table_logic_relation
-- ----------------------------
DROP TABLE IF EXISTS `table_logic_relation`;
CREATE TABLE `table_logic_relation` (
  `id` varchar(50) NOT NULL,
  `db_name` varchar(100) DEFAULT NULL,
  `table_name` varchar(100) DEFAULT NULL,
  `column_name` varchar(100) DEFAULT NULL,
  `column_type` varchar(20) DEFAULT NULL,
  `column_length` int(11) DEFAULT NULL,
  `mapping_type` varchar(255) DEFAULT NULL,
  `column_desc` varchar(255) DEFAULT NULL,
  `required_flag` varchar(1) DEFAULT NULL,
  `null_able` varchar(1) DEFAULT NULL,
  `primary_key_flag` varchar(1) DEFAULT NULL,
  `index_flag` varchar(1) DEFAULT NULL,
  `index_type` varchar(50) DEFAULT NULL,
  `index_desc` varchar(255) DEFAULT NULL,
  `related_table` varchar(100) DEFAULT NULL,
  `related_table_field` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
