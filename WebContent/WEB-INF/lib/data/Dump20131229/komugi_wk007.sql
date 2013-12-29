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
-- Table structure for table `wk007`
--

DROP TABLE IF EXISTS `wk007`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wk007` (
  `fileId` int(10) NOT NULL AUTO_INCREMENT,
  `mainId` int(10) NOT NULL,
  `fileName` varchar(128) NOT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `uploadedDate` datetime DEFAULT NULL,
  `deleteFlag` tinyint(4) DEFAULT NULL COMMENT '0:有効 1:削除',
  `deleteDate` datetime DEFAULT NULL,
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='ファイルテーブル';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wk007`
--

LOCK TABLES `wk007` WRITE;
/*!40000 ALTER TABLE `wk007` DISABLE KEYS */;
INSERT INTO `wk007` VALUES (1,7,'macro.chm','C://fileUpload//7//macro.chm','2013-12-29 00:00:00',1,'2013-12-29 00:00:00'),(2,7,'macro.chm','C://fileUpload//7//macro.chm','2013-12-29 00:00:00',1,'2013-12-29 00:00:00'),(3,7,'bsd_license.txt','C://fileUpload//7//bsd_license.txt','2013-12-29 00:00:00',0,NULL),(4,7,'sakura.exe.ini','C://fileUpload//7//sakura.exe.ini','2013-12-29 00:00:00',0,NULL),(5,7,'sakura.exe.manifest','C://fileUpload//7//sakura.exe.manifest','2013-12-29 20:08:36',1,'2013-12-29 20:09:14');
/*!40000 ALTER TABLE `wk007` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-29 20:10:36
