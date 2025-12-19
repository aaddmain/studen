/*
 Navicat Premium Data Transfer

 Source Server         : db_mobile
 Source Server Type    : MySQL
 Source Server Version : 80037
 Source Host           : localhost:3306
 Source Schema         : student_society

 Target Server Type    : MySQL
 Target Server Version : 80037
 File Encoding         : 65001

 Date: 19/12/2025 14:00:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `activityId` int NOT NULL AUTO_INCREMENT,
  `activity_societyId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '按照,分割协会id',
  `activity_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动名称',
  `activity_intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `activity_start_time` datetime NOT NULL COMMENT '活动开始时间',
  `activity_end_time` datetime NOT NULL COMMENT '活动结束时间',
  PRIMARY KEY (`activityId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (3, '8', '迎新会', '新学期迎接新成员3', '2022-09-02 09:00:00', '2022-09-02 11:00:00');
INSERT INTO `activity` VALUES (4, '8', '读书会', '周常活动，自愿参加', '2023-07-06 11:00:00', '2023-07-06 12:40:00');
INSERT INTO `activity` VALUES (5, '8', '读书会', '周常活动，自愿参加', '2023-07-13 11:00:00', '2023-07-13 13:40:00');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `memberId` int NOT NULL AUTO_INCREMENT,
  `memberStudentId` int NOT NULL,
  `joinDate` date NOT NULL COMMENT '加入日期',
  `memberStatus` int NOT NULL DEFAULT 1 COMMENT '1.正常；2.退出；3.申请退出',
  `memberPosition` tinyint NOT NULL DEFAULT 3 COMMENT '职位：1.会长、2.副会长、3.成员等',
  `member_societyId` int NOT NULL COMMENT '所属协会id',
  PRIMARY KEY (`memberId`) USING BTREE,
  UNIQUE INDEX `unique_student_society`(`memberStudentId` ASC, `member_societyId` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (4, 45, '2022-03-24', 1, 1, 8);
INSERT INTO `member` VALUES (5, 46, '2023-07-20', 1, 3, 8);
INSERT INTO `member` VALUES (21, 49, '2025-12-19', 1, 3, 3);
INSERT INTO `member` VALUES (22, 49, '2025-12-19', 4, 3, 8);

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `positionId` int NOT NULL AUTO_INCREMENT,
  `positionName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职务在协会中的名称',
  `positionSociety` int NULL DEFAULT NULL COMMENT '职务相关的协会',
  `positionLevel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职级：1.会长，2.副会长，3.成员',
  PRIMARY KEY (`positionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, '会长', 8, '1');
INSERT INTO `position` VALUES (2, '副会长', 8, '2');
INSERT INTO `position` VALUES (3, '会员', 8, '3');
INSERT INTO `position` VALUES (4, '帮主', 3, '1');
INSERT INTO `position` VALUES (5, '护法', 3, '2');
INSERT INTO `position` VALUES (6, '帮众', 3, '3');

-- ----------------------------
-- Table structure for society
-- ----------------------------
DROP TABLE IF EXISTS `society`;
CREATE TABLE `society`  (
  `societyId` int NOT NULL AUTO_INCREMENT,
  `society_creator` int NOT NULL COMMENT '创始人的学生id',
  `society_create_date` date NOT NULL COMMENT '创建时间',
  `society_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '协会名',
  `society_intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '协会简介',
  `society_status` tinyint NOT NULL DEFAULT 1 COMMENT '协会状态：1.正常；2.停招；3.停运',
  PRIMARY KEY (`societyId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of society
-- ----------------------------
INSERT INTO `society` VALUES (3, 45, '2021-03-03', '黄昏社团', '傍晚望天的组织', 1);
INSERT INTO `society` VALUES (8, 45, '2023-07-17', '异人联盟', '最强的就是要秃头', 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `studentId` int NOT NULL AUTO_INCREMENT,
  `studentNumber` int NOT NULL,
  `studentName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gender` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '男和女',
  `birthday` date NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `graduated` tinyint NOT NULL DEFAULT 1 COMMENT '1：未毕业；2.已毕业',
  `avatarPath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'assets/img/user.png',
  PRIMARY KEY (`studentId`) USING BTREE,
  UNIQUE INDEX `studentNumber`(`studentNumber` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (45, 2022034567, '张五', '男', '2006-06-07', '123456', 2, 'img/user.png');
INSERT INTO `student` VALUES (46, 2022034568, '李四', '女', '2005-07-13', '123456', 1, 'img/user.png');
INSERT INTO `student` VALUES (47, 20250901, '张三', '男', '2000-01-01', '123456', 1, NULL);
INSERT INTO `student` VALUES (48, 20250902, '李四', '女', '2000-02-02', '123456', 1, NULL);
INSERT INTO `student` VALUES (49, 20250903, '王五', '男', '2000-03-03', '123456', 1, NULL);
INSERT INTO `student` VALUES (50, 20250904, '赵六', '女', '2000-04-04', '123456', 1, NULL);
INSERT INTO `student` VALUES (51, 20250905, '孙七', '男', '2000-05-05', '123456', 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
