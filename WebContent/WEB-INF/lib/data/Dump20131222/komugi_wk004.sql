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
-- Table structure for table `wk004`
--

DROP TABLE IF EXISTS `wk004`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wk004` (
  `dataId` int(11) NOT NULL AUTO_INCREMENT,
  `mainId` int(10) NOT NULL,
  `hopePosition` varchar(45) DEFAULT NULL,
  `forBusiness` varchar(45) DEFAULT NULL,
  `introductionDay` date DEFAULT NULL,
  `interviewDay` date DEFAULT NULL,
  PRIMARY KEY (`dataId`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wk004`
--

LOCK TABLES `wk004` WRITE;
/*!40000 ALTER TABLE `wk004` DISABLE KEYS */;
INSERT INTO `wk004` VALUES (121,35,'','作業会社',NULL,NULL),(122,35,'','作業１',NULL,NULL),(123,37,'営業','会社１','2013-11-11','2013-11-12'),(124,37,'営業','会社2','2013-11-11','2013-11-12'),(125,37,'総務','会社3','2013-11-11','2013-11-12'),(126,37,'営業','会社4','2013-11-11','2013-11-12'),(127,7,'営業','会社１','2013-11-11','2013-11-12'),(128,7,'営業','会社2','2013-11-11','2013-11-12'),(129,7,'総務','会社3','2013-11-11','2013-11-12'),(130,7,'営業','会社4','2013-11-11','2013-11-12'),(131,38,'qq','qq','2013-09-12','2013-11-12'),(132,41,'qqq','',NULL,NULL),(133,41,'','qqq',NULL,NULL),(134,41,'','','2013-09-12',NULL),(135,41,'','',NULL,'2013-11-12'),(144,42,'111','',NULL,NULL),(145,42,'','222',NULL,NULL),(146,42,'','','2013-09-12',NULL),(147,42,'','',NULL,'2013-11-12');
/*!40000 ALTER TABLE `wk004` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-22 18:55:51
