-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: groupfive
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `hud`
--

DROP TABLE IF EXISTS `hud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hud` (
  `idhud` int(11) NOT NULL AUTO_INCREMENT,
  `services` varchar(255) DEFAULT NULL,
  `languages` varchar(255) DEFAULT NULL,
  `adr2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `adr1` varchar(255) DEFAULT NULL,
  `agc_ADDR_LONGITUDE` varchar(255) DEFAULT NULL,
  `parentid` varchar(45) DEFAULT NULL,
  `county_NME` varchar(255) DEFAULT NULL,
  `phone2` varchar(45) DEFAULT NULL,
  `mailingadr1` varchar(255) DEFAULT NULL,
  `mailingadr2` varchar(255) DEFAULT NULL,
  `mailingcity` varchar(255) DEFAULT NULL,
  `mailingzipcd` varchar(45) DEFAULT NULL,
  `mailingstatecd` varchar(45) DEFAULT NULL,
  `state_NME` varchar(45) DEFAULT NULL,
  `state_FIPS_CODE` varchar(45) DEFAULT NULL,
  `faithbased` varchar(45) DEFAULT NULL,
  `colonias_IND` varchar(45) DEFAULT NULL,
  `migrantwkrs_IND` varchar(45) DEFAULT NULL,
  `agc_SRC_CD` varchar(45) DEFAULT NULL,
  `agc_STATUS` varchar(255) DEFAULT NULL,
  `counslg_METHOD` varchar(255) DEFAULT NULL,
  `agcid` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `nme` varchar(255) DEFAULT NULL,
  `phone1` varchar(45) DEFAULT NULL,
  `statecd` varchar(45) DEFAULT NULL,
  `weburl` varchar(255) DEFAULT NULL,
  `zipcd` varchar(45) DEFAULT NULL,
  `agc_ADDR_LATITUDE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idhud`),
  UNIQUE KEY `idhud_UNIQUE` (`idhud`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='pulls from hud api in order to generate url for directions and distance from google api';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hud`
--

LOCK TABLES `hud` WRITE;
/*!40000 ALTER TABLE `hud` DISABLE KEYS */;
/*!40000 ALTER TABLE `hud` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-05  9:24:33
