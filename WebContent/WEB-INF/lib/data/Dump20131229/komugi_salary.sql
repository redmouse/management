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
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary` (
  `id` varchar(15) NOT NULL COMMENT '社員コード',
  `name` varchar(10) NOT NULL,
  `payDay` date NOT NULL COMMENT '支払日',
  `basePay` int(11) NOT NULL COMMENT '基本給',
  `commissionPay` int(11) NOT NULL COMMENT '歩合',
  `overtimePay` int(11) DEFAULT NULL COMMENT '残業代',
  `allowancePay` int(11) DEFAULT NULL COMMENT '手当',
  `advancePay` int(11) DEFAULT NULL COMMENT '前払金',
  `noPay` int(11) DEFAULT NULL COMMENT '未払金',
  `loanPay` int(11) DEFAULT NULL COMMENT '貸付金',
  `depositPay` int(11) DEFAULT NULL COMMENT '預かり金',
  `bonus` int(11) DEFAULT NULL COMMENT '賞与',
  `totalSalary` int(11) DEFAULT NULL COMMENT '給与計',
  `incomeTax` int(11) DEFAULT NULL COMMENT '源泉所得税',
  `municipalTax` int(11) DEFAULT NULL COMMENT '市民税',
  `healthIns` int(11) DEFAULT NULL COMMENT '健保金額',
  `annuityIns` int(11) DEFAULT NULL COMMENT '厚生年金',
  `unemploymentIns` int(11) DEFAULT NULL COMMENT '雇用保険',
  `refund` int(11) DEFAULT NULL COMMENT '還付金額（年末調整）',
  `commutingCost` int(11) DEFAULT NULL COMMENT '通勤費',
  `fareCost` int(11) DEFAULT NULL COMMENT '交通費',
  `expenseCost` int(11) DEFAULT NULL COMMENT '経費',
  `bankTransfer` int(11) DEFAULT NULL COMMENT '銀行振込額',
  PRIMARY KEY (`id`,`payDay`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES ('11','qiang','2013-11-12',0,0,500,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),('11','qiang','2013-11-13',1000,200,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1200),('55','li','2013-11-13',1100,100,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1200);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-12-29 20:10:34
