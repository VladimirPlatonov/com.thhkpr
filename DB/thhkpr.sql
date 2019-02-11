-- MySQL dump 10.13  Distrib 5.5.61, for Win32 (AMD64)
--
-- Host: localhost    Database: thhkpr
-- ------------------------------------------------------
-- Server version	5.5.61

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
-- Current Database: `thhkpr`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `thhkpr` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `thhkpr`;

--
-- Table structure for table `settings`
--

DROP TABLE IF EXISTS `settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings` (
  `settings_id` int(11) NOT NULL AUTO_INCREMENT,
  `settings_name` varchar(255) NOT NULL,
  `settings_value` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`settings_id`),
  UNIQUE KEY `settings_id` (`settings_id`),
  UNIQUE KEY `settings_settings_name_uindex` (`settings_name`),
  KEY `settings_settings_id_index` (`settings_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings`
--

LOCK TABLES `settings` WRITE;
/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
INSERT INTO `settings` VALUES (1,'name','Владимир'),(2,'locale','ru-ru'),(3,'time-zone','RTZ4'),(4,'default_place_id','1'),(5,'name_foregn','Владимир');
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage` (
  `storage_id` int(11) NOT NULL AUTO_INCREMENT,
  `storage_name` varchar(500) NOT NULL,
  `storage_describe` varchar(4000) DEFAULT NULL,
  `storage_place` varchar(500) DEFAULT NULL,
  `sys_date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sys_date_update` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `sys_who_update_name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`storage_id`),
  UNIQUE KEY `storage_id` (`storage_id`),
  KEY `storage_name_index` (`storage_name`(255)),
  KEY `storage_place_index` (`storage_place`(255)),
  KEY `storage_storage_id_index` (`storage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` VALUES (1,'кабинет, подоконник','напротив двери','Малиновый','2018-07-23 12:40:13','2018-07-23 09:31:16','undefined'),(2,'Подвал, полка большая под залом','как входишь в подвальную комнату, справа','Малиновый','2018-07-23 09:31:16','2018-07-23 09:31:16','undefined'),(10,'зал, за телеком LG','за большим телевизором полка','Малиновый','2018-12-25 02:54:52','2018-12-25 02:54:52','undefined user'),(11,'зал, за телеком LG','за большим телевизором полка','Малиновый','2018-12-26 07:46:11','2018-12-26 07:46:11','undefined user');
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `things`
--

DROP TABLE IF EXISTS `things`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `things` (
  `thing_id` int(11) NOT NULL AUTO_INCREMENT,
  `thing_name` varchar(4000) NOT NULL,
  `thing_describe` varchar(4000) DEFAULT NULL,
  `thing_voice` blob,
  `sys_date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sys_date_update` timestamp NOT NULL,
  `sys_who_update_name` varchar(500) DEFAULT NULL,
  `storage_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`thing_id`),
  UNIQUE KEY `thing_id` (`thing_id`),
  KEY `things_thing_id_index` (`thing_id`),
  KEY `things_thing_name_index` (`thing_name`(255)),
  KEY `things_storage_id_index` (`storage_id`),
  CONSTRAINT `storage_id_fk` FOREIGN KEY (`storage_id`) REFERENCES `storage` (`storage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `things`
--

LOCK TABLES `things` WRITE;
/*!40000 ALTER TABLE `things` DISABLE KEYS */;
INSERT INTO `things` VALUES (2,'Штука1','Неведомая фигня',NULL,'2018-07-23 12:40:25','2018-07-23 05:02:14','undefined user',NULL),(3,'Штука2','Неведомая фигня',NULL,'2018-07-23 05:36:39','2018-07-23 05:36:39','undefined user',NULL),(4,'Штука3','Неведомая фигня',NULL,'2018-07-23 12:40:25','2018-07-23 05:36:45','undefined user',NULL),(5,'Штука4','Неведомая фигня',NULL,'2018-07-23 12:40:25','2018-07-23 05:36:46','undefined user',NULL);
/*!40000 ALTER TABLE `things` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(500) NOT NULL,
  `user_login` varchar(80) NOT NULL,
  `user_password` varchar(80) DEFAULT NULL,
  `user_active` int(11) DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`),
  KEY `users_user_id_index` (`user_id`),
  KEY `users_user_name_user_login_index` (`user_name`(255),`user_login`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'SERJ','srj_edit2','pass1112',1),(2,'Петров','gtnh3','empty',1),(3,'Костин','kst99','null',1),(4,'SERJ','srj_edit2','pass1112',1),(5,'Хренков','рк2011','passnotvaid',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-15 22:25:01
