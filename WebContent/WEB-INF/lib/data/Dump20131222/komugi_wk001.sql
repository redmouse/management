CREATE DATABASE  IF NOT EXISTS `komugi` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `komugi`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: komugi
-- ------------------------------------------------------
-- Server version	5.5.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `wk001`
--

DROP TABLE IF EXISTS `wk001`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wk001` (
  `mainId` int(11) NOT NULL AUTO_INCREMENT,
  `receptionDay` date NOT NULL,
  `level1Id` int(11) DEFAULT NULL,
  `level2Id` int(11) DEFAULT NULL,
  `level3Id` int(11) DEFAULT NULL,
  `place` int(11) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `hurigana` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `birthDay` date NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `marriage` int(11) DEFAULT NULL,
  `foreigner` int(11) DEFAULT NULL,
  `postcode` varchar(45) DEFAULT NULL,
  `address` varchar(120) NOT NULL,
  `family` varchar(150) DEFAULT NULL,
  `homePhone` varchar(45) DEFAULT NULL,
  `mobilePhone` varchar(45) DEFAULT NULL,
  `contactMethod` varchar(45) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  `lastDegree` varchar(45) DEFAULT NULL,
  `specialty` varchar(45) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  `graduationDay` date DEFAULT NULL,
  `schoolOther` varchar(45) DEFAULT NULL,
  `englishLevel` int(11) DEFAULT NULL,
  `selfAssessment` varchar(300) DEFAULT NULL,
  `toeic` varchar(30) DEFAULT NULL,
  `toefl` varchar(30) DEFAULT NULL,
  `etest` varchar(30) DEFAULT NULL,
  `requirements` varchar(150) DEFAULT NULL,
  `annualIncomeNow` varchar(45) DEFAULT NULL,
  `annualIncomeHope` varchar(45) DEFAULT NULL,
  `workLocation` varchar(45) DEFAULT NULL,
  `bachelor` int(11) DEFAULT NULL,
  `inaugurationDay` date DEFAULT NULL,
  `turnoverDay` date DEFAULT NULL,
  `fee` varchar(45) DEFAULT NULL,
  `companyInfo` text,
  `workContents` text,
  PRIMARY KEY (`mainId`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wk001`
--

LOCK TABLES `wk001` WRITE;
/*!40000 ALTER TABLE `wk001` DISABLE KEYS */;
INSERT INTO `wk001` VALUES (7,'2013-09-12',3,8,15,1,'祐樹','ゆうき',41,'1972-01-01',1,1,1,'116-0011','渋谷区','','111-1111-1111','999-9999-9999','','qiang@komugi.com','大学','文学',2,'1992-04-01','',2,'																		','1','1','1','','11','11','東京',1,'2013-11-13','2013-11-24','','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：'),(10,'2013-10-11',0,0,0,0,'小田','おだ',19,'1994-11-11',1,2,1,'','新宿区','母親\r\n','','','','','大学','物流',2,'2013-09-12','',2,'			','22','22','22','','111','222','東京',1,'2013-11-13','2013-11-15','','①会社名：あああ\r\n②勤務先TEL：いいい\r\n③会社概要：ううう\r\n④職位：ええええ	\r\n			\r\n			\r\n			\r\n			\r\n		\r\n	','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ： \r\n		\r\n			\r\n			\r\n			\r\n			\r\n		\r\n	'),(19,'2013-12-02',1,3,6,2,'Sam','サム',31,'1984-12-12',1,2,1,'','','','','','','','','',0,NULL,'',0,'									','','','','','','','',0,NULL,NULL,'','①会社名：qqqqqq\r\n②勤務先TEL：wwwww\r\n③会社概要：eeeeee\r\n④職位：ttttt','①業務経験： \r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：'),(20,'2013-09-12',1,2,3,1,'ｗｗｗeee','wwwee',20,'1985-04-17',1,0,0,'','','','','','','','','',0,NULL,'',0,'												','','','','','','','',0,NULL,NULL,'','								①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n\r\n			\r\n			\r\n			','①業務経験： \r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：'),(25,'2013-09-12',1,1,1,1,'dddd','dddd',23,'2013-12-04',1,2,0,'','','','','','','','','',0,NULL,'',0,'									','','','','','','','',0,NULL,NULL,'','①会社名：11111111111111\r\n②勤務先TEL：222222222222222223\r\n③会社概要：3333333333333\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n'),(26,'2013-09-12',0,0,0,0,'次郎','ジロウ',25,'2013-09-12',1,0,0,'','','','','','','','','',0,'2013-09-12','',0,'			','','','','','','','',0,'2013-09-12','2013-09-12','','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n'),(27,'2013-09-12',0,0,0,0,'次郎','ジロウ',25,'2013-09-12',1,0,0,'111','','','','','','','','',0,'2013-09-12','',0,'						','','','','','','','',0,'2013-09-12','2013-09-12','','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n'),(28,'2013-09-12',0,0,0,0,'次郎','ジロウ',25,'2013-09-12',1,0,0,'','','','','','','','','',0,'2013-09-12','',0,'			','','','','','','','',0,'2013-09-12','2013-09-12','','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n'),(33,'2013-09-12',0,0,0,0,'次郎','ジロウ',25,'2013-09-12',1,0,0,'','','','','','','','','',0,'2013-09-12','',0,'			','','','','','','','',0,'2013-09-12','2013-09-12','','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n'),(35,'2013-09-12',0,0,0,0,'次郎','ジロウ',25,'2013-09-12',1,0,0,'','','','','','','','','',0,'2013-09-12','',0,'						','','','','','','','',0,'2013-09-12','2013-09-12','','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n'),(36,'2013-10-11',0,0,0,0,'次郎','ジロウ',25,'2013-09-12',1,0,0,'','','','','','','','','',0,'2013-09-12','',0,'			','','','','','','','',0,'2013-09-12','2013-09-12','','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n'),(37,'2013-09-12',1,1,1,1,'大田','おおだ',29,'2013-09-12',1,2,0,'111111','新宿','','','','','','','',1,'2013-09-12','',3,'			','','','','','','','',1,NULL,NULL,'','①会社名：aaaaaa\r\n②勤務先TEL：ssssss\r\n③会社概要：dddd\r\n④職位：ffff\r\n','①業務経験：qqq\r\n②職種・業種：www\r\n③資格：eee\r\n④業界製品：rrr\r\n⑤スベシャリティ：\r\n'),(38,'2013-09-12',1,0,0,1,'大田','おおだ',29,'2013-09-12',1,2,0,'111111','新宿','','','','','','','',1,'2013-09-12','',3,'			','','','','','','','',1,NULL,NULL,'','①会社名：aaaaaa\r\n②勤務先TEL：ssssss\r\n③会社概要：dddd\r\n④職位：ffff\r\n','①業務経験：qqq\r\n②職種・業種：www\r\n③資格：eee\r\n④業界製品：rrr\r\n⑤スベシャリティ：\r\n'),(39,'2013-09-12',0,0,0,0,'次郎','ジロウ',25,'2013-09-12',1,0,0,'','','','','','','','','',0,'2013-09-12','',0,'			','','','','','','','',0,'2013-09-12','2013-09-12','','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n'),(40,'2013-09-12',0,0,0,0,'次郎','ジロウ',25,'2013-09-12',1,0,0,'','','','','','','','','',0,'2013-09-12','',0,'			','','','','','','','',0,'2013-09-12','2013-09-12','','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n'),(41,'2013-12-11',3,9,18,1,'田中','たなか',28,'1985-04-17',1,2,0,'111-1111','渋谷区','両親','034-1111-1111','000-0000-0000','','','大学','',1,'2012-04-10','',2,'			','','','','','','','',1,NULL,NULL,'','①会社名：11111\r\n②勤務先TEL：11111111\r\n③会社概要：11\r\n④職位：11111\r\n\r\n①会社名：11111\r\n②勤務先TEL：11111111\r\n③会社概要：11\r\n④職位：11111','①業務経験：22\r\n②職種・業種：2222\r\n③資格：2222222\r\n④業界製品：2\r\n⑤スベシャリティ：2222\r\n'),(42,'2013-12-02',3,9,18,1,'qqq','aaa',23,'2013-09-12',1,2,0,'116-0011','新宿','両親','034-1111-1111','','','','','',1,NULL,'',0,'									','','','','','','','',0,NULL,NULL,'','①会社名：1\r\n②勤務先TEL：11\r\n③会社概要：111\r\n④職位：1111\r\n\r\n①会社名：2\r\n②勤務先TEL：22\r\n③会社概要：222\r\n④職位：2222','①業務経験：3\r\n②職種・業種：33\r\n③資格：333\r\n④業界製品：3333\r\n⑤スベシャリティ：3333\r\n');
/*!40000 ALTER TABLE `wk001` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-22 18:55:55
