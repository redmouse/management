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
-- Table structure for table `wk005`
--

DROP TABLE IF EXISTS `wk005`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wk005` (
  `tradeId` int(11) NOT NULL AUTO_INCREMENT,
  `forBusiness` varchar(45) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `representative` varchar(45) DEFAULT NULL COMMENT '代表者氏名',
  `charger` varchar(45) DEFAULT NULL COMMENT '担当連絡者',
  `remarks` varchar(500) DEFAULT NULL COMMENT '備考',
  PRIMARY KEY (`tradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='求人事業者情報';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wk005`
--

LOCK TABLES `wk005` WRITE;
/*!40000 ALTER TABLE `wk005` DISABLE KEYS */;
INSERT INTO `wk005` VALUES (1,'三洋会社','新宿','小田','小田','特にない'),(2,NULL,'','','',''),(3,NULL,'渋谷','田中','田中','重要'),(4,NULL,'東京','川田','川田','何も'),(5,NULL,'東京','川田','川田','何も'),(6,NULL,'東京','川田','川田','何も'),(7,NULL,'222','333','444','4'),(8,NULL,'222','333','444','4'),(9,NULL,'','','',''),(10,NULL,'','','',''),(11,NULL,'','','',''),(12,NULL,'渋谷','','',''),(13,NULL,NULL,NULL,NULL,NULL),(14,'日立製作','大阪','','',''),(15,'松本','九州','','',''),(16,'三菱会社','新宿','川田','',''),(17,'三菱会社','222','小田','',''),(18,'松下','大阪','涼','涼','');
/*!40000 ALTER TABLE `wk005` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-22 18:55:50
