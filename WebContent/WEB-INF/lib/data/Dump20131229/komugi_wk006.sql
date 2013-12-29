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
-- Table structure for table `wk006`
--

DROP TABLE IF EXISTS `wk006`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wk006` (
  `infoId` int(11) NOT NULL AUTO_INCREMENT,
  `tradeId` int(11) NOT NULL,
  `ReceptionDay` date NOT NULL COMMENT '受付年月日',
  `quantity` varchar(45) DEFAULT NULL COMMENT '求人数',
  `occupation` varchar(45) DEFAULT NULL COMMENT '職種',
  `workLocation` varchar(45) DEFAULT NULL COMMENT '就労場所',
  `period` varchar(45) DEFAULT NULL COMMENT '雇用期間',
  `wage` varchar(45) DEFAULT NULL COMMENT '賃金',
  `conditions` varchar(45) DEFAULT NULL COMMENT '処理状況',
  `place` varchar(45) DEFAULT NULL COMMENT '国内/海外',
  `recruitmentFrom` text COMMENT '求人事業者からの求人票',
  `recruitmentOwn` text COMMENT '自社の求人票\n',
  `secondMainId` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`infoId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='求人詳細情報';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wk006`
--

LOCK TABLES `wk006` WRITE;
/*!40000 ALTER TABLE `wk006` DISABLE KEYS */;
INSERT INTO `wk006` VALUES (3,16,'2013-09-12','10','','','','','','','','','0'),(4,17,'2013-09-12','19','','','','','','','','','0'),(5,18,'2013-12-02','10','111111','','','','','','','','0'),(6,18,'2013-12-03','11','222222','','','','','','','','0'),(16,19,'2013-12-02','19','111111','東京','3年','500万','処理中','国内','１求人事業者からの求人票','２自社の求人票','00037,00064'),(17,20,'2013-09-12','12','111','2222','3年','700万','処理','国内','１１１１１１１１１１１１１１１１１１１１１１１１１１','２２２２２２２２２２２２２２２２２２２２２２２２２２２２２２','00011');
/*!40000 ALTER TABLE `wk006` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-29 20:10:48
