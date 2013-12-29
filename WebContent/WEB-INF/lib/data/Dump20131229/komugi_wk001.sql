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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wk001`
--

LOCK TABLES `wk001` WRITE;
/*!40000 ALTER TABLE `wk001` DISABLE KEYS */;
INSERT INTO `wk001` VALUES (7,'2013-09-12',3,8,15,1,'祐樹','ゆうき',41,'1972-01-01',1,1,1,'116-0011','渋谷区','','111-1111-1111','999-9999-9999','','qiang@komugi.com','大学','文学',2,'1992-04-01','',2,'																		','1','1','1','','11','11','東京',1,'2013-11-13','2013-11-24','','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：'),(11,'2013-09-12',1,10,0,2,'小田','oda',16,'2013-09-12',1,2,0,'','新宿','','034-1111-1111','','','21111','大学','工学',1,'2013-09-12','',1,'																																																																						\r\n				\r\n				\r\n				\r\n				\r\n				\r\n				\r\n				\r\n				\r\n				\r\n				\r\n				\r\n				\r\n				\r\n				','','','','','','','',0,NULL,NULL,'','①会社名：111\r\n②勤務先TEL：222\r\n③会社概要：333\r\n④職位：444\r\n','①業務経験：55\r\n②職種・業種：66\r\n③資格：77\r\n④業界製品：88\r\n⑤スベシャリティ：99\r\n'),(12,'2013-12-24',2,21,0,1,'田中','たなか',20,'2012-12-12',1,0,1,'','渋谷','','034-1111-1111','','','qqqqq','大学','文学',2,'2013-09-12','',2,'														\r\n				\r\n				\r\n				','','','','','','','',0,NULL,NULL,'','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n'),(14,'2013-12-24',1,0,0,2,'渡辺','わたなべ',30,'2012-12-12',1,1,1,'','台東区','','033-3333-3333','','','kyo@yahoo.co.jp','専門学校','電子',1,'2013-09-12','',2,'					\r\n				','','','','','','','',0,NULL,NULL,'','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n'),(15,'2013-09-13',1,0,0,0,'qqq','',11111,'1972-01-01',1,0,0,'','wwwwww','','034-1111-1111','999-1111-1111','','qiang@komugi.com','大学','工学',0,'2013-09-12','',1,'					\r\n				','','','','','','','',0,NULL,NULL,'','①会社名：\r\n②勤務先TEL：\r\n③会社概要：\r\n④職位：\r\n','①業務経験：\r\n②職種・業種：\r\n③資格：\r\n④業界製品：\r\n⑤スベシャリティ：\r\n');
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

-- Dump completed on 2013-12-29 20:10:44
