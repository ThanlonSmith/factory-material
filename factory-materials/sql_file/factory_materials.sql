-- MySQL dump 10.13  Distrib 8.0.20, for Linux (x86_64)
--
-- Host: 47.102.145.225    Database: factory_materials
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'thanlon','ea48576f30be1669971699c09ad05c94'),(2,'admin','ea48576f30be1669971699c09ad05c94');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'销售部门'),(2,'行政部门'),(3,'内勤部门');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `depart_id` int(11) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `depart_id` (`depart_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`depart_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (3,'zhangzhi',1,'ea48576f30be1669971699c09ad05c94','18767837767','张志'),(6,'lizhi',1,'ea48576f30be1669971699c09ad05c94','17867678979','李志'),(7,'zhangzhi',1,'ea48576f30be1669971699c09ad05c94','15667678979','张志');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `godown`
--

DROP TABLE IF EXISTS `godown`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `godown` (
  `id` int(11) NOT NULL,
  `material_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `godown`
--

LOCK TABLES `godown` WRITE;
/*!40000 ALTER TABLE `godown` DISABLE KEYS */;
INSERT INTO `godown` VALUES (1,65),(2,146),(3,210),(5,120);
/*!40000 ALTER TABLE `godown` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `godown_keeper`
--

DROP TABLE IF EXISTS `godown_keeper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `godown_keeper` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `godown_id` int(11) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `godown_id` (`godown_id`),
  CONSTRAINT `godown_keeper_ibfk_1` FOREIGN KEY (`godown_id`) REFERENCES `godown` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `godown_keeper`
--

LOCK TABLES `godown_keeper` WRITE;
/*!40000 ALTER TABLE `godown_keeper` DISABLE KEYS */;
INSERT INTO `godown_keeper` VALUES (100001,'keeper1',2,'ea48576f30be1669971699c09ad05c94','18767678978','刘好'),(100003,'keeper3',1,'ea48576f30be1669971699c09ad05c94','18767678980','张雨'),(100004,'keeper5',2,'ea48576f30be1669971699c09ad05c94','18656563478','立志');
/*!40000 ALTER TABLE `godown_keeper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `unit_price` int(11) DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `godown_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `godown_id` (`godown_id`),
  CONSTRAINT `material_ibfk_1` FOREIGN KEY (`godown_id`) REFERENCES `godown` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'物料1',40,50,1),(2,'物料2',40,50,1),(3,'物料3',40,50,2),(4,'物料4',30,50,2),(5,'物料5',60,70,1),(6,'物料6',80,40,2),(7,'物料7',90,40,2),(8,'物料8',90,40,1);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_apply`
--

DROP TABLE IF EXISTS `material_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `mobile_nubmer` varchar(11) DEFAULT NULL,
  `others` varchar(255) DEFAULT NULL,
  `applicant` varchar(255) DEFAULT NULL,
  `flag` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_apply`
--

LOCK TABLES `material_apply` WRITE;
/*!40000 ALTER TABLE `material_apply` DISABLE KEYS */;
INSERT INTO `material_apply` VALUES (1,'物料1','安徽省宿州市','18512152001','请抓紧时间发货，谢谢','user',1);
/*!40000 ALTER TABLE `material_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','ea48576f30be1669971699c09ad05c94',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-15 22:11:26
