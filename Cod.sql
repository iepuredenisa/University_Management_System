CREATE DATABASE  IF NOT EXISTS `platforma_studiu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `platforma_studiu`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: platforma_studiu
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activitate_suplimentara`
--

DROP TABLE IF EXISTS `activitate_suplimentara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activitate_suplimentara` (
  `id_activ_sup` int NOT NULL AUTO_INCREMENT,
  `id_student` int DEFAULT NULL,
  `id_grup` int DEFAULT NULL,
  `id_profesor` int DEFAULT NULL,
  PRIMARY KEY (`id_activ_sup`),
  KEY `id_student` (`id_student`),
  KEY `id_grup` (`id_grup`),
  KEY `id_profesor` (`id_profesor`),
  CONSTRAINT `activitate_suplimentara_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE,
  CONSTRAINT `activitate_suplimentara_ibfk_2` FOREIGN KEY (`id_grup`) REFERENCES `grup_studiu` (`id_grup`) ON DELETE CASCADE,
  CONSTRAINT `activitate_suplimentara_ibfk_3` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id_profesor`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activitate_suplimentara`
--

LOCK TABLES `activitate_suplimentara` WRITE;
/*!40000 ALTER TABLE `activitate_suplimentara` DISABLE KEYS */;
INSERT INTO `activitate_suplimentara` VALUES (1,1,5,4),(2,1,2,NULL),(3,2,2,NULL),(4,3,1,NULL),(5,3,2,NULL),(6,1,1,NULL),(7,3,2,NULL);
/*!40000 ALTER TABLE `activitate_suplimentara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activitati`
--

DROP TABLE IF EXISTS `activitati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activitati` (
  `id_activitati` int NOT NULL AUTO_INCREMENT,
  `activitate_predata` varchar(45) DEFAULT NULL,
  `zi_lab` varchar(45) DEFAULT NULL,
  `zi_curs` varchar(45) DEFAULT NULL,
  `zi_seminar` varchar(45) DEFAULT NULL,
  `ora_lab` varchar(45) DEFAULT NULL,
  `ora_curs` varchar(45) DEFAULT NULL,
  `ora_seminar` varchar(45) DEFAULT NULL,
  `procent_lab` varchar(45) DEFAULT NULL,
  `procent_curs` varchar(45) DEFAULT NULL,
  `procent_seminar` varchar(45) DEFAULT NULL,
  `nr_ore_lab` int DEFAULT NULL,
  `nr_ore_curs` int DEFAULT NULL,
  `nr_ore_seminar` int DEFAULT NULL,
  `id_info` int DEFAULT NULL,
  PRIMARY KEY (`id_activitati`),
  KEY `id_info` (`id_info`),
  CONSTRAINT `activitati_ibfk_1` FOREIGN KEY (`id_info`) REFERENCES `informatii_profesor` (`id_info`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activitati`
--

LOCK TABLES `activitati` WRITE;
/*!40000 ALTER TABLE `activitati` DISABLE KEYS */;
INSERT INTO `activitati` VALUES (1,'MSI','Joi','Luni','Vineri','17:00','11:00','16:00','10','60','30',NULL,45,NULL,1),(2,'MSI','Joi','Luni','Vineri','17:00','11:00','16:00','10','60','30',NULL,NULL,45,2),(3,'MSI','Joi','Luni','Vineri','17:00','11:00','16:00','10','60','30',12,NULL,NULL,3);
/*!40000 ALTER TABLE `activitati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `id_administrator` int NOT NULL AUTO_INCREMENT,
  `CNP` varchar(13) NOT NULL,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `nr_telefon` varchar(10) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `IBAN` varchar(16) DEFAULT NULL,
  `nr_contract` int DEFAULT NULL,
  PRIMARY KEY (`id_administrator`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (1,'6020708314088','Ionescu','Augusta','Victoriei','0753883890','ionescuaugusta','87867765097',1),(2,'6020727774088','Iliescu','Ana','Viilor','0753866490','ianaesu','907654307',2);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendar`
--

DROP TABLE IF EXISTS `calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendar` (
  `id_calendar` int NOT NULL AUTO_INCREMENT,
  `data_partial` date DEFAULT NULL,
  `data_colocviu` date DEFAULT NULL,
  `data_examen` date DEFAULT NULL,
  `data_restanta_lab` date DEFAULT NULL,
  `data_restanta_curs` date DEFAULT NULL,
  `id_materie` int DEFAULT NULL,
  `id_info` int DEFAULT NULL,
  PRIMARY KEY (`id_calendar`),
  KEY `id_materie` (`id_materie`),
  KEY `id_info` (`id_info`),
  CONSTRAINT `calendar_ibfk_1` FOREIGN KEY (`id_materie`) REFERENCES `materie` (`id_materie`) ON DELETE CASCADE,
  CONSTRAINT `calendar_ibfk_2` FOREIGN KEY (`id_info`) REFERENCES `informatii_profesor` (`id_info`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendar`
--

LOCK TABLES `calendar` WRITE;
/*!40000 ALTER TABLE `calendar` DISABLE KEYS */;
INSERT INTO `calendar` VALUES (1,'2022-07-07','2022-12-12','2022-06-12','2022-04-09','2022-06-09',1,NULL),(2,'2021-07-07','2021-12-12','2021-06-12','2021-04-09','2021-06-09',2,NULL),(3,'2020-07-07','2020-12-12','2020-06-12','2020-04-09','2020-06-09',3,NULL),(4,'2023-01-31',NULL,'2023-01-19',NULL,'2023-01-31',2,1),(5,NULL,'2023-01-25',NULL,'2023-01-31',NULL,2,3);
/*!40000 ALTER TABLE `calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catalog`
--

DROP TABLE IF EXISTS `catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog` (
  `id_catalog` int NOT NULL AUTO_INCREMENT,
  `nota_finala` int DEFAULT NULL,
  `situatie_finala` varchar(30) DEFAULT NULL,
  `id_student` int DEFAULT NULL,
  `id_materie` int DEFAULT NULL,
  `id_info` int DEFAULT NULL,
  PRIMARY KEY (`id_catalog`),
  KEY `id_student` (`id_student`),
  KEY `id_materie` (`id_materie`),
  KEY `id_info` (`id_info`),
  CONSTRAINT `catalog_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE,
  CONSTRAINT `catalog_ibfk_2` FOREIGN KEY (`id_materie`) REFERENCES `materie` (`id_materie`) ON DELETE CASCADE,
  CONSTRAINT `catalog_ibfk_3` FOREIGN KEY (`id_info`) REFERENCES `informatii_profesor` (`id_info`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog`
--

LOCK TABLES `catalog` WRITE;
/*!40000 ALTER TABLE `catalog` DISABLE KEYS */;
INSERT INTO `catalog` VALUES (32,NULL,NULL,1,2,1),(33,10,'promovat',1,2,NULL),(34,8,'promovat',1,2,NULL),(35,3,NULL,1,2,NULL),(36,3,NULL,1,2,NULL),(37,3,'nepromovat',1,2,NULL);
/*!40000 ALTER TABLE `catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_studiu`
--

DROP TABLE IF EXISTS `contract_studiu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_studiu` (
  `id_contract` int NOT NULL AUTO_INCREMENT,
  `data_inscrierii` date DEFAULT NULL,
  `data_retragerii` date DEFAULT NULL,
  `id_student` int DEFAULT NULL,
  PRIMARY KEY (`id_contract`),
  KEY `id_student` (`id_student`),
  CONSTRAINT `contract_studiu_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_studiu`
--

LOCK TABLES `contract_studiu` WRITE;
/*!40000 ALTER TABLE `contract_studiu` DISABLE KEYS */;
INSERT INTO `contract_studiu` VALUES (1,'2021-07-09','2022-09-09',1),(2,'2021-08-04','2022-12-18',2),(3,'2021-09-12','2022-01-01',3);
/*!40000 ALTER TABLE `contract_studiu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curs`
--

DROP TABLE IF EXISTS `curs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curs` (
  `id_curs` int NOT NULL AUTO_INCREMENT,
  `nota_partial` double DEFAULT NULL,
  `nota_examen` double DEFAULT NULL,
  `nota_restanta` double DEFAULT NULL,
  `id_materie` int DEFAULT NULL,
  `id_info` int DEFAULT NULL,
  `id_student` int DEFAULT NULL,
  PRIMARY KEY (`id_curs`),
  KEY `id_student` (`id_student`),
  KEY `id_materie` (`id_materie`),
  KEY `id_info` (`id_info`),
  CONSTRAINT `curs_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE,
  CONSTRAINT `curs_ibfk_2` FOREIGN KEY (`id_materie`) REFERENCES `materie` (`id_materie`) ON DELETE CASCADE,
  CONSTRAINT `curs_ibfk_3` FOREIGN KEY (`id_info`) REFERENCES `informatii_profesor` (`id_info`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curs`
--

LOCK TABLES `curs` WRITE;
/*!40000 ALTER TABLE `curs` DISABLE KEYS */;
INSERT INTO `curs` VALUES (1,NULL,NULL,NULL,2,1,NULL),(2,5,3,0,2,1,1);
/*!40000 ALTER TABLE `curs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grup_studiu`
--

DROP TABLE IF EXISTS `grup_studiu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grup_studiu` (
  `id_grup` int NOT NULL AUTO_INCREMENT,
  `id_materie` int DEFAULT NULL,
  `nr_participanti` int DEFAULT NULL,
  `nr_max_participanti` int DEFAULT NULL,
  PRIMARY KEY (`id_grup`),
  KEY `id_materie` (`id_materie`),
  CONSTRAINT `grup_studiu_ibfk_1` FOREIGN KEY (`id_materie`) REFERENCES `materie` (`id_materie`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grup_studiu`
--

LOCK TABLES `grup_studiu` WRITE;
/*!40000 ALTER TABLE `grup_studiu` DISABLE KEYS */;
INSERT INTO `grup_studiu` VALUES (1,1,12,30),(2,2,18,40),(3,3,20,25),(4,3,NULL,NULL),(5,4,NULL,NULL),(6,4,NULL,NULL);
/*!40000 ALTER TABLE `grup_studiu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informatii_profesor`
--

DROP TABLE IF EXISTS `informatii_profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informatii_profesor` (
  `id_info` int NOT NULL AUTO_INCREMENT,
  `activitate_predata` varchar(45) DEFAULT NULL,
  `min_ore_predare` int DEFAULT NULL,
  `max_ore_predare` int DEFAULT NULL,
  `departament` varchar(45) DEFAULT NULL,
  `tip` varchar(40) DEFAULT NULL,
  `nr_max_stud` int DEFAULT NULL,
  `id_profesor` int DEFAULT NULL,
  PRIMARY KEY (`id_info`),
  KEY `id_profesor` (`id_profesor`),
  CONSTRAINT `informatii_profesor_ibfk_1` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id_profesor`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informatii_profesor`
--

LOCK TABLES `informatii_profesor` WRITE;
/*!40000 ALTER TABLE `informatii_profesor` DISABLE KEYS */;
INSERT INTO `informatii_profesor` VALUES (1,'MSI',10,30,'Calculatoare','curs',45,2),(2,'MSI',10,30,'Calculatoare','seminar',56,2),(3,'MSI',10,30,'Calculatoare','laborator',56,2);
/*!40000 ALTER TABLE `informatii_profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscriere`
--

DROP TABLE IF EXISTS `inscriere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscriere` (
  `id_inscriere` int NOT NULL AUTO_INCREMENT,
  `id_student` int DEFAULT NULL,
  `id_materie` int DEFAULT NULL,
  `id_profesor` int DEFAULT NULL,
  `data_inscrierii` date DEFAULT NULL,
  PRIMARY KEY (`id_inscriere`),
  KEY `id_student` (`id_student`),
  KEY `id_profesor` (`id_profesor`),
  KEY `id_materie` (`id_materie`),
  CONSTRAINT `inscriere_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE,
  CONSTRAINT `inscriere_ibfk_2` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id_profesor`) ON DELETE CASCADE,
  CONSTRAINT `inscriere_ibfk_3` FOREIGN KEY (`id_materie`) REFERENCES `materie` (`id_materie`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscriere`
--

LOCK TABLES `inscriere` WRITE;
/*!40000 ALTER TABLE `inscriere` DISABLE KEYS */;
INSERT INTO `inscriere` VALUES (1,NULL,2,2,'2023-01-19'),(2,1,2,2,'2023-01-19');
/*!40000 ALTER TABLE `inscriere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscriere_meet_grup`
--

DROP TABLE IF EXISTS `inscriere_meet_grup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscriere_meet_grup` (
  `id_inscriere_meet` int NOT NULL AUTO_INCREMENT,
  `data_meet` date DEFAULT NULL,
  `ora_meet` varchar(45) DEFAULT NULL,
  `timp_expirare` int DEFAULT NULL,
  `scriere` varchar(45) DEFAULT NULL,
  `ora_creare` time DEFAULT NULL,
  `id_meet` int DEFAULT NULL,
  `id_student` int DEFAULT NULL,
  PRIMARY KEY (`id_inscriere_meet`),
  KEY `id_meet` (`id_meet`),
  KEY `id_student` (`id_student`),
  CONSTRAINT `inscriere_meet_grup_ibfk_1` FOREIGN KEY (`id_meet`) REFERENCES `meet_grup` (`id_meet`) ON DELETE CASCADE,
  CONSTRAINT `inscriere_meet_grup_ibfk_2` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscriere_meet_grup`
--

LOCK TABLES `inscriere_meet_grup` WRITE;
/*!40000 ALTER TABLE `inscriere_meet_grup` DISABLE KEYS */;
INSERT INTO `inscriere_meet_grup` VALUES (1,NULL,NULL,NULL,'recuperare','20:58:22',NULL,1),(2,'2023-01-18','16:00',1,'pregatire','23:45:19',2,3),(3,'2023-01-19','13:00',1,'recapitulare','00:34:43',3,3);
/*!40000 ALTER TABLE `inscriere_meet_grup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscriere_student`
--

DROP TABLE IF EXISTS `inscriere_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscriere_student` (
  `id_inscriere_s` int NOT NULL AUTO_INCREMENT,
  `denumire_materie` varchar(45) DEFAULT NULL,
  `tip` varchar(45) DEFAULT NULL,
  `zi` varchar(45) DEFAULT NULL,
  `ora` varchar(45) DEFAULT NULL,
  `id_student` int DEFAULT NULL,
  PRIMARY KEY (`id_inscriere_s`),
  KEY `id_student` (`id_student`),
  CONSTRAINT `inscriere_student_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscriere_student`
--

LOCK TABLES `inscriere_student` WRITE;
/*!40000 ALTER TABLE `inscriere_student` DISABLE KEYS */;
INSERT INTO `inscriere_student` VALUES (1,'MSI','curs','Luni','11:00',1),(2,'MSI','seminar','Vineri','16:00',1),(3,'MSI','laborator','Joi','17:00',1);
/*!40000 ALTER TABLE `inscriere_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laborator`
--

DROP TABLE IF EXISTS `laborator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laborator` (
  `id_lab` int NOT NULL AUTO_INCREMENT,
  `nota_lab` double DEFAULT NULL,
  `nota_restanta` double DEFAULT NULL,
  `id_materie` int DEFAULT NULL,
  `id_info` int DEFAULT NULL,
  `id_student` int DEFAULT NULL,
  PRIMARY KEY (`id_lab`),
  KEY `id_student` (`id_student`),
  KEY `id_materie` (`id_materie`),
  KEY `id_info` (`id_info`),
  CONSTRAINT `laborator_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE,
  CONSTRAINT `laborator_ibfk_2` FOREIGN KEY (`id_materie`) REFERENCES `materie` (`id_materie`) ON DELETE CASCADE,
  CONSTRAINT `laborator_ibfk_3` FOREIGN KEY (`id_info`) REFERENCES `informatii_profesor` (`id_info`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laborator`
--

LOCK TABLES `laborator` WRITE;
/*!40000 ALTER TABLE `laborator` DISABLE KEYS */;
INSERT INTO `laborator` VALUES (1,NULL,NULL,2,3,NULL),(2,2,0,2,3,1);
/*!40000 ALTER TABLE `laborator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materie`
--

DROP TABLE IF EXISTS `materie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materie` (
  `id_materie` int NOT NULL AUTO_INCREMENT,
  `descriere` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_materie`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materie`
--

LOCK TABLES `materie` WRITE;
/*!40000 ALTER TABLE `materie` DISABLE KEYS */;
INSERT INTO `materie` VALUES (1,'MES'),(2,'MSI'),(3,'BD'),(4,'SDA'),(5,'OOP');
/*!40000 ALTER TABLE `materie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meet_grup`
--

DROP TABLE IF EXISTS `meet_grup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meet_grup` (
  `id_meet` int NOT NULL AUTO_INCREMENT,
  `data_meet` date DEFAULT NULL,
  `ora_meet` varchar(45) DEFAULT NULL,
  `nr_min_participanti` int DEFAULT NULL,
  `nr_curent_participanti` int DEFAULT NULL,
  `timp_expirare` int DEFAULT NULL,
  `ora_creare` time DEFAULT NULL,
  `scriere` varchar(45) DEFAULT NULL,
  `id_grup` int DEFAULT NULL,
  `id_profesor` int DEFAULT NULL,
  PRIMARY KEY (`id_meet`),
  KEY `id_grup` (`id_grup`),
  KEY `id_profesor` (`id_profesor`),
  CONSTRAINT `meet_grup_ibfk_1` FOREIGN KEY (`id_grup`) REFERENCES `grup_studiu` (`id_grup`) ON DELETE CASCADE,
  CONSTRAINT `meet_grup_ibfk_2` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id_profesor`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meet_grup`
--

LOCK TABLES `meet_grup` WRITE;
/*!40000 ALTER TABLE `meet_grup` DISABLE KEYS */;
INSERT INTO `meet_grup` VALUES (1,'2023-01-18','16:40',3,NULL,2,'20:49:58','recuperare',NULL,2),(2,'2023-01-18','16:00',2,NULL,1,'23:44:07','pregatire',2,2),(3,'2023-01-19','13:00',3,NULL,1,'00:34:32','recapitulare',2,2);
/*!40000 ALTER TABLE `meet_grup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesaje_grup`
--

DROP TABLE IF EXISTS `mesaje_grup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mesaje_grup` (
  `id_mesaj` int NOT NULL AUTO_INCREMENT,
  `text` varchar(400) DEFAULT NULL,
  `id_student` int DEFAULT NULL,
  `nume_t` varchar(45) DEFAULT NULL,
  `prenume_t` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_mesaj`),
  KEY `id_student` (`id_student`),
  CONSTRAINT `mesaje_grup_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesaje_grup`
--

LOCK TABLES `mesaje_grup` WRITE;
/*!40000 ALTER TABLE `mesaje_grup` DISABLE KEYS */;
INSERT INTO `mesaje_grup` VALUES (1,'Buna!',1,'Pavel','Madalina'),(2,'Bine',1,'Danciulescu','Bianca');
/*!40000 ALTER TABLE `mesaje_grup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `id_profesor` int NOT NULL AUTO_INCREMENT,
  `CNP` varchar(13) NOT NULL,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `nr_telefon` varchar(10) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `IBAN` varchar(16) DEFAULT NULL,
  `nr_contract` int DEFAULT NULL,
  PRIMARY KEY (`id_profesor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'6721223125678','Ivan','Cosmina','Pacii','075789567','ivan_cosmina','89867725364',9),(2,'6721897256789','Gavrea','Ioan','Salajului','0790786564','gavrea_ioan','87855555664',2),(3,'6721899125678','Radu','Munteanu','Parisului','0753880076','dan_morosanu','87867765624',1),(4,'6789056743213','Brehar','Raluca','Cluj','0789678543','ralu_breh','8907654321',345),(5,'5214367896451','Hulea','Andrei','Gilau','0758962314','huu-lea@yahoo.com','545445cdc45454',3028316);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seminar`
--

DROP TABLE IF EXISTS `seminar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seminar` (
  `id_seminar` int NOT NULL AUTO_INCREMENT,
  `nota_seminar` double DEFAULT NULL,
  `id_materie` int DEFAULT NULL,
  `id_info` int DEFAULT NULL,
  `id_student` int DEFAULT NULL,
  PRIMARY KEY (`id_seminar`),
  KEY `id_student` (`id_student`),
  KEY `id_materie` (`id_materie`),
  KEY `id_info` (`id_info`),
  CONSTRAINT `seminar_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE CASCADE,
  CONSTRAINT `seminar_ibfk_2` FOREIGN KEY (`id_materie`) REFERENCES `materie` (`id_materie`) ON DELETE CASCADE,
  CONSTRAINT `seminar_ibfk_3` FOREIGN KEY (`id_info`) REFERENCES `informatii_profesor` (`id_info`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seminar`
--

LOCK TABLES `seminar` WRITE;
/*!40000 ALTER TABLE `seminar` DISABLE KEYS */;
INSERT INTO `seminar` VALUES (1,NULL,2,2,NULL),(2,3,2,2,1);
/*!40000 ALTER TABLE `seminar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id_student` int NOT NULL AUTO_INCREMENT,
  `CNP` varchar(13) NOT NULL,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `nr_telefon` varchar(10) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `IBAN` varchar(16) DEFAULT NULL,
  `nr_contract` varchar(10) DEFAULT NULL,
  `an_studiu` varchar(10) DEFAULT NULL,
  `nr_ore` varchar(10) DEFAULT NULL,
  `id_grup` int DEFAULT NULL,
  PRIMARY KEY (`id_student`),
  KEY `id_grup` (`id_grup`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`id_grup`) REFERENCES `grup_studiu` (`id_grup`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'6020708314003','Iepure','Denisa','Iuliu Coroianu','0753883208','iepure_denisa','87867765664','5','2','12',NULL),(2,'6020708314002','Pavel','Madalina','Sesu de Sus','0723883208','iepure_nisa','87867735664','3','2','40',NULL),(3,'6020708314005','Danciulescu','Bianca','Moroianu','0753883108','iepure_densa','87867765624','6','2','22',NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `superadministrator`
--

DROP TABLE IF EXISTS `superadministrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `superadministrator` (
  `id_super_administrator` int NOT NULL AUTO_INCREMENT,
  `CNP` varchar(13) NOT NULL,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `nr_telefon` varchar(10) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `IBAN` varchar(16) DEFAULT NULL,
  `nr_contract` int DEFAULT NULL,
  `data_inceput` date DEFAULT NULL,
  `data_final` date DEFAULT NULL,
  PRIMARY KEY (`id_super_administrator`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `superadministrator`
--

LOCK TABLES `superadministrator` WRITE;
/*!40000 ALTER TABLE `superadministrator` DISABLE KEYS */;
INSERT INTO `superadministrator` VALUES (1,'6030708314088','Popescu','Andreea','Unirii','0741524852','popescuandreea','90863927',2,'2022-10-03','2023-03-03'),(2,'6030122125805','Pavel','Madalina','Ses','072789678','madapavel','5678902',2,'2022-10-03','2023-03-03');
/*!40000 ALTER TABLE `superadministrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'platforma_studiu'
--

--
-- Dumping routines for database 'platforma_studiu'
--
/*!50003 DROP FUNCTION IF EXISTS `full_name1` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `full_name1`(first_n char(20), last_n char(20)) RETURNS char(55) CHARSET utf8mb4
    DETERMINISTIC
return concat_ws(' ',first_n, last_n) ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `activitati_profesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `activitati_profesor`(in nume_prof varchar(45), in prenume_prof varchar(45))
begin
set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
 select informatii_profesor.tip, informatii_profesor.activitate_predata
  from informatii_profesor where  informatii_profesor.id_profesor=@IDprof;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `activitati_profesor1` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `activitati_profesor1`(in nume_prof varchar(45), in prenume_prof varchar(45))
begin
set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
 select count(*), informatii_profesor.tip, informatii_profesor.activitate_predata
  from informatii_profesor where  informatii_profesor.id_profesor=@IDprof;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `activitati_student10` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `activitati_student10`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in nume_curs varchar(45),in tip varchar(45),in oraa varchar(45),in zii varchar(45))
begin
set @Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=nume_curs);
SET @Idprof=(Select informatii_profesor.id_profesor FROM platforma_studiu.informatii_profesor where informatii_profesor.activitate_predata=nume_curs and informatii_profesor.tip=tip group by id_profesor order by COUNT(*) limit 1);
set @Idstudent=(SELECT student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @Idinfolab=(select informatii_profesor.id_info from informatii_profesor where informatii_profesor.id_profesor=@Idprof and informatii_profesor.activitate_predata=nume_curs and informatii_profesor.tip='laborator');
set @nr_max_stud_lab=(SELECT informatii_profesor.nr_max_stud from informatii_profesor where informatii_profesor.id_info=@Idinfolab);
set @Idinfocurs=(select informatii_profesor.id_info from informatii_profesor where informatii_profesor.id_profesor=@Idprof and informatii_profesor.activitate_predata=nume_curs and informatii_profesor.tip='curs');
set @nr_max_stud_curs=(SELECT informatii_profesor.nr_max_stud from informatii_profesor where informatii_profesor.id_info=@Idinfocurs);
set @Idinfosem=(select informatii_profesor.id_info from informatii_profesor where informatii_profesor.id_profesor=@Idprof and informatii_profesor.activitate_predata=nume_curs and informatii_profesor.tip='seminar');
set @nr_max_stud_sem=(SELECT informatii_profesor.nr_max_stud from informatii_profesor where informatii_profesor.id_info=@Idinfosem);
set @idstudocupat=(select inscriere_student.id_inscriere_s from inscriere_student where inscriere_student.ora=oraa and inscriere_student.zi=zii and inscriere_student.id_student=@Idstudent);


-- select @idstudocupat;

set @IDlab=( SELECT MAX(laborator.id_lab) FROM laborator) + 1;
if @IDlab IS NULL then
set @IDlab=1;
end if;

set @IDcurs=( SELECT MAX(curs.id_curs) FROM curs) + 1;
if @IDcurs IS NULL then
set @IDcurs=1;
end if;

set @IDsem=( SELECT MAX(seminar.id_seminar) FROM seminar) + 1;
if @IDsem IS NULL then
set @IDsem=1;
end if;


set @IDin=( SELECT MAX(inscriere.id_inscriere) FROM inscriere) + 1;
if @IDin IS NULL then
set @IDin=1;
end if;


if tip='laborator' then 
if (SELECT COUNT(*) from laborator where laborator.id_info=@Idinfolab )< @nr_max_stud_lab  then
insert into laborator values(@IDlab,NULL,NULL,@Idmaterie,@Idinfolab,@Idstudent);
end if;
end if;


-- if not exists (select inscriere_student.id_inscriere_s from inscriere_student where inscriere_student.ora=oraa and inscriere_student.zi=zii and inscriere_student.id_student=@Idstudent) then 
if tip='curs' then 
 IF (SELECT COUNT(*) from curs where curs.id_info=@Idinfocurs)< @nr_max_stud_curs  then
insert into platforma_studiu.curs values(@IDcurs,NULL,NULL,NULL,@Idmaterie,@Idinfocurs,@Idstudent);
insert into platforma_studiu.inscriere values(@IDin,@Idstudent,@Idmaterie,@Idprof, current_date());
insert into platforma_studiu.catalog values(@IDcatalog,NULL,NULL,@Idstudent,@Idmaterie,@Idinfocurs);
 end if;
 end if;


if tip='seminar' then 
IF (SELECT COUNT(*) from seminar where seminar.id_info=@Idinfosem)< @nr_max_stud_sem  then
insert into seminar values(@IDsem,NULL,@Idmaterie,@Idinfosem,@Idstudent);
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `adaugaprocente13` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adaugaprocente13`(in id_prof INT,in denumire_materie varchar(45),in procentcurs INT, in procentseminar INT,in procentlab INT)
begin

SET @IDmaterie=(SELECT materie.id_materie
                 from materie,profesor
                 where materie.descriere=denumire_materie
                 and profesor.id_profesor=id_prof
				);
                 
update activitati set activitati.procent_lab=procentlab where activitati.activitate_predata=denumire_materie;
update activitati set activitati.procent_seminar=procentseminar where activitati.activitate_predata=denumire_materie;
update activitati set activitati.procent_curs=procentcurs where activitati.activitate_predata=denumire_materie;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `adauga_note2` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adauga_note2`( in  nume_curs varchar(45), in nume_prof varchar(45), in prenume_prof varchar(45),in nume_stud varchar(45),in prenume_stud varchar(45),in CNP varchar(45),
in nota_lab double,in nota_res_lab double, nota_seminar double,nota_partial double,nota_examen double, nota_res_ex double)
begin
set @Idprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set @Idmaterie=(select materie.id_materie from materie where materie.descriere=nume_curs);
set @Idstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @Idinfolab=(select informatii_profesor.id_info from informatii_profesor where informatii_profesor.id_profesor=@Idprof and informatii_profesor.activitate_predata=nume_curs and informatii_profesor.tip='laborator');
set @Idinfocurs=(select informatii_profesor.id_info from informatii_profesor where informatii_profesor.id_profesor=@Idprof and informatii_profesor.activitate_predata=nume_curs and informatii_profesor.tip='curs');
set @Idinfosem=(select informatii_profesor.id_info from informatii_profesor where informatii_profesor.id_profesor=@Idprof and informatii_profesor.activitate_predata=nume_curs and informatii_profesor.tip='seminar');
if nota_lab IS NOT NULL then update laborator set laborator.nota_lab=nota_lab where laborator.id_info=@Idinfolab and laborator.id_student=@Idstud;
if nota_res_lab IS NOT NULL then update laborator set laborator.nota_restanta=nota_res_lab where laborator.id_info=@Idinfolab and laborator.id_student=@Idstud;
end if;
end if;

if nota_seminar IS NOT NULL then update seminar set seminar.nota_seminar=nota_seminar where seminar.id_info=@Idinfosem and seminar.id_student=@Idstud;
end if;

if nota_partial IS NOT NULL then update curs set curs.nota_partial=nota_partial   where curs.id_info=@Idinfocurs and curs.id_student=@Idstud;
if nota_examen IS NOT NULL then update curs set curs.nota_examen=nota_examen where curs.id_info=@Idinfocurs and curs.id_student=@Idstud;
if nota_res_ex IS NOT NULL then update curs set curs.nota_restanta=nota_res_ex where curs.id_info=@Idinfocurs and curs.id_student=@Idstud;
end if;
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `afiseaza_studenti` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afiseaza_studenti`( in descriere varchar(45))
begin
select student.nume, student.prenume from student, inscriere, materie where student.id_student=inscriere.id_student and 
materie.id_materie=inscriere.id_materie and materie.descriere=descriere;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `afiseaza_studenti1` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afiseaza_studenti1`( in descriere varchar(45), in nume_prof varchar(45), in prenume_prof varchar(45))
begin
set @Idprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set @Idmaterie=(select materie.id_materie from materie where materie.descriere=descriere);

 select student.nume, student.prenume, student.CNP
  from student, inscriere
 where student.id_student=inscriere.id_student
and 
 inscriere.id_materie=@Idmaterie and inscriere.id_profesor=@Idprof;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `catalog_note` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `catalog_note`(in nume varchar(30), in prenume varchar(30), in CNP varchar(13))
begin
set @IDstud=(select student.id_student from student where student.nume=nume and student.prenume=prenume and student.CNP=CNP);

select materie.descriere,catalog.nota_finala, catalog.situatie_finala   from catalog,materie where catalog.id_student=@IDstud 
and materie.id_materie=catalog.id_materie;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cauta_curs15` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cauta_curs15`( in descriere varchar(45))
begin
select profesor.nume, profesor.prenume from profesor, inscriere, materie where profesor.id_profesor=inscriere.id_profesor and 
materie.id_materie=inscriere.id_materie and materie.descriere=descriere;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `creare_grup` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `creare_grup`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45))
begin

set @ID_grup=( SELECT MAX(grup_studiu.id_grup) FROM platforma_studiu.grup_studiu) + 1;
if @ID_grup IS NULL then
set @ID_grup=1;
end if;

set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);
insert into grup_studiu values(@ID_grup,@Idmaterie,NULL,NULL);

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `creare_meet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `creare_meet`( in data_meet DATE, in ora_meet varchar(45), in nr_min_participanti int,in timp_expirare int, in descriere varchar(45),in nume_materie varchar(45),in nume_prof varchar(45))
begin

set @ID_meet=( SELECT MAX(meet_grup.id_meet) FROM platforma_studiu.meet_grup) + 1;
if @ID_meet IS NULL then
set @ID_meet=1;
end if;
set@IDmaterie=(SELECT materie.id_materie from materie where materie.descriere=nume_materie);
set@Idgrup=(SELECT grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@IDmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof);
insert into meet_grup values(@ID_meet,data_meet,ora_meet,nr_min_participanti,NULL,timp_expirare,current_time(),descriere,@Idgrup,@IDprof);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteadministrator` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteadministrator`(in CNP varchar(20), in nume varchar(20),in prenume varchar(13))
BEGIN
SET @idadm = (SELECT administrator.id_administrator
               from administrator
               where administrator.nume = nume 
               and administrator.prenume = prenume
               and  administrator.CNP = CNP);
DELETE  
FROM administrator
WHERE administrator.id_administrator = @idadm;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteprofesor2` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteprofesor2`(in CNP varchar(20), in nume varchar(20),in prenume varchar(13))
BEGIN
SET @idprof = (SELECT profesor.id_profesor
               from profesor
               where profesor.nume = nume
               and profesor.prenume = prenume
               and  profesor.CNP = CNP);
DELETE  
FROM profesor
WHERE profesor.id_profesor = @idprof;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deletestudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deletestudent`(in CNP varchar(20), in nume varchar(20),in prenume varchar(13))
BEGIN
SET @idstud = (SELECT student.id_student
               from student
               where student.nume = nume 
               and student.prenume = prenume
               and  student.CNP = CNP);
DELETE  
FROM student
WHERE student.id_student = @idstud;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inscriere_grup` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inscriere_grup`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45))
begin

set @ID_inscriereG=( SELECT MAX(activitate_suplimentara.id_activ_sup) FROM platforma_studiu.activitate_suplimentara) + 1;
if @ID_inscriereG IS NULL then
set @ID_inscriereG=1;
end if;

set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud);
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);
set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);

insert into activitate_suplimentara values(@ID_inscriereG,@IDstud,@IDgrup,NULL);

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inscriere_meet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inscriere_meet`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45))
begin

set @ID_inscriereM=( SELECT MAX(inscriere_meet_grup.id_inscriere_meet) FROM platforma_studiu.inscriere_meet_grup) + 1;
if @ID_inscriereM IS NULL then
set @ID_inscriereM=1;
end if;
-- select  concat_WS(' ',profesor.nume , profesor.prenume) as Nume 
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);
set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof);
update meet_grup set meet_grup.nr_curent_participanti=meet_grup.nr_curent_participanti+1 where meet_grup.id_grup=@IDgrup;

set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set@data_meet=(SELECT meet_grup.data_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and  meet_grup.id_profesor=@IDprof);
set@ora_meet=(SELECT meet_grup.ora_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and  meet_grup.id_profesor=@IDprof);
set@timp_expirare=(SELECT meet_grup.timp_expirare from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and  meet_grup.id_profesor=@IDprof);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
insert into inscriere_meet_grup values(@ID_inscriereM,@data_meet,@ora_meet,@timp_expirare,descriere_meet,current_time(),@IDmeet,@IDstud);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserare_activitate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserare_activitate`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in nume_curs varchar(45),in tip varchar(45),in ora varchar(45),in zi varchar(45))
begin
set @idex=0;
set @ID_inscriere=( SELECT MAX(inscriere_student.id_inscriere_s) FROM platforma_studiu.inscriere_student) + 1;
if @ID_inscriere IS NULL then
set @ID_inscriere=1;
end if;

set @id_student=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
IF NOT EXISTS (SELECT inscriere_student.id_inscriere_s from inscriere_student where inscriere_student.zi=zi and inscriere_student.ora=ora
 and inscriere_student.id_student=@id_student) then
 set @idex=1;
insert into inscriere_student values (@ID_inscriere,nume_curs,tip,zi,ora,@id_student);

end if;
select @idex;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertinformatii_profesor3` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertinformatii_profesor3`( in nume_curs varchar(45), in nume_prof varchar(20), 
in prenume_prof varchar(20), in nr_min int, in nr_max int, in departament varchar(20), in tip varchar(40),in nr_max_stud INT)
begin
set @ID_inscriere=( SELECT MAX(inscriere.id_inscriere) FROM inscriere) + 1;
if @ID_inscriere IS NULL then
set @ID_inscriere=1;
end if;
set @ID=( SELECT MAX(informatii_profesor.id_info) FROM informatii_profesor) + 1;
if @ID IS NULL then
set @ID=1;
end if;
set @IDlab=( SELECT MAX(laborator.id_lab) FROM laborator) + 1;
if @IDlab IS NULL then
set @IDlab=1;
end if;
set @IDcurs=( SELECT MAX(curs.id_curs) FROM curs) + 1;
if @IDcurs IS NULL then
set @IDcurs=1;
end if;
set @IDseminar=( SELECT MAX(seminar.id_seminar) FROM seminar) + 1;
if @IDseminar IS NULL then
set @IDseminar=1;
end if;

SET @IDmaterie = (SELECT materie.id_materie
               from materie
			   where materie.descriere=nume_curs);
               
SET @IDprof = (SELECT profesor.id_profesor
               from profesor
			   where profesor.nume = nume_prof
               and profesor.prenume = prenume_prof);
SELECT @IDprof;
-- AICIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
insert into platforma_studiu.informatii_profesor 
values (@ID,nume_curs, nr_min, nr_max,departament,tip,nr_max_stud, @IDprof); 

if(tip='laborator') then
insert into platforma_studiu.laborator 
values (@IDlab,NULL,NULL,@IDmaterie,@ID,NULL);
end if;

if(tip='seminar') then
insert into platforma_studiu.seminar 
values (@IDseminar,NULL,@IDmaterie,@ID,NULL); 
end if;

if(tip='curs') then
insert into platforma_studiu.curs 
values (@IDcurs,NULL,NULL,NULL,@IDmaterie,@ID,NULL); 
insert into platforma_studiu.inscriere
values(@ID_inscriere,NULL,@IDmaterie,@IDprof,CURDATE());
end if;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mesaj` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mesaj`(in nume varchar(30), in prenume varchar(30), in mesaj varchar(400),in nume_t varchar(45),in prenume_t varchar(45))
begin
set @IDstud=(select student.id_student from student where student.nume=nume and student.prenume=prenume);
set @ID_M=( SELECT MAX(mesaje_grup.id_mesaj) FROM platforma_studiu.mesaje_grup) + 1;
if @ID_M IS NULL then
set @ID_M=1;
end if;
insert into mesaje_grup values (@ID_M,mesaj, @IDstud,nume_t,prenume_t);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `minimstudenti23` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `minimstudenti23`(in denumire_materie varchar(45),in nume_stud varchar(45), in prenume_stud varchar(45),in CNP varchar(45))
begin


set @ID=( SELECT MAX(platforma_studiu.inscriere.id_inscriere) FROM platforma_studiu.inscriere) + 1;
if @ID IS NULL then
set @ID=1;
end if;

SET @IDstud=(SELECT student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
SET @IDmaterie=(SELECT materie.id_materie from materie where materie.descriere=denumire_materie);
SET @IDprof=(Select inscriere.id_profesor FROM platforma_studiu.inscriere where inscriere.id_materie=@IDmaterie group by id_profesor order by COUNT(*) limit 1);

 
 
 -- if exists ((select inscriere.id_inscriere from inscriere where (inscriere.id_profesor=@IDprof and inscriere.id_materie=@IDmaterie)) ) then 
-- insert into platforma_studiu.inscriere
-- values(@ID,@IDstud,@IDmaterie,@IDprof,CURDATE());
-- set @IDprof =(select informatii_profesor.id_profesor from informatii_profesor where informatii_profesor.activitate_predata=denumire_materie limit 1);

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `minimstudenti8` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `minimstudenti8`(in denumire_materie varchar(45),in nume_stud varchar(45), in prenume_stud varchar(45),in CNP varchar(45))
begin
set @ID=( SELECT MAX(platforma_studiu.inscriere.id_inscriere) FROM platforma_studiu.inscriere) + 1;
if @ID IS NULL then
set @ID=1;
end if;
SET @IDstud=(SELECT student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
SET @IDmaterie=(SELECT materie.id_materie from materie where materie.descriere=denumire_materie);
SET @IDprof=(Select inscriere.id_profesor FROM platforma_studiu.inscriere where inscriere.id_materie=@IDmaterie group by id_profesor order by COUNT(*) limit 1);
 SET @Idstuddd=(select inscriere.id_student from inscriere where (inscriere.id_profesor=@IDprof and inscriere.id_materie=@IDmaterie)) ;
 select @Idstuddd;
 if  @Idstuddd IS NULL THEN
 update platforma_studiu.inscriere 
 set inscriere.id_student=@IDstud;
else if exists ((select inscriere.id_student from inscriere where (inscriere.id_profesor=@IDprof and inscriere.id_materie=@IDmaterie)) ) then 
insert into platforma_studiu.inscriere
values(@ID,@IDstud,@IDmaterie,@IDprof,CURDATE());
-- set @IDprof =(select informatii_profesor.id_profesor from informatii_profesor where informatii_profesor.activitate_predata=denumire_materie limit 1);
 end if;
 end if;
-- AICIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `nota_finala5` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `nota_finala5`(in nume varchar (45), in prenume varchar(45), in CNP varchar(45), in nume_curs varchar(45))
begin


set @ID=( SELECT MAX(catalog.id_catalog) FROM platforma_studiu.catalog) + 1;
if @ID IS NULL then
set @ID=1;
end if;
-- SET @IDprofesor=(SELECT profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof limit 1);
-- SET @IDinfo=(SELECT informatii_profesor.id_info from informatii_profesor where informatii_profesor.id_profesor=@IDprofesor and informatii_profesor.activitate_predata=nume_curs and informatii_profesor.tip =tip limit 1);

SET @IDstudent=(SELECT student.id_student from student where student.nume=nume and student.prenume=prenume and student.CNP=CNP);
SET @IDmaterie=(SELECT materie.id_materie from materie where materie.descriere=nume_curs);
set @nota_colocviu =(select laborator.nota_lab from laborator WHERE laborator.id_student=@IDstudent and laborator.id_materie=@IDmaterie);
set @nota_restanta_lab =(select laborator.nota_restanta from laborator WHERE laborator.id_student=@IDstudent and laborator.id_materie=@IDmaterie);
if  @nota_restanta_lab > 0 then
set @nota_finala_lab = @nota_restanta_lab;
else
set @nota_finala_lab = @nota_colocviu;
end if;


set @nota_finala_seminar = (select seminar.nota_seminar from seminar WHERE seminar.id_student=@IDstudent and seminar.id_materie=@IDmaterie);


set @nota_partial =(select curs.nota_partial from curs WHERE curs.id_student=@IDstudent and curs.id_materie=@IDmaterie);
set @nota_restanta_curs =(select curs.nota_restanta from curs WHERE curs.id_student=@IDstudent and curs.id_materie=@IDmaterie);
set @nota_examen =(select curs.nota_examen from curs WHERE curs.id_student=@IDstudent and curs.id_materie=@IDmaterie);

if  @nota_restanta_curs > 0 then
set @nota_finala_curs = @nota_restanta_curs;
else
set @nota_finala_curs= (@nota_partial + @nota_examen) / 2;
end if;

set @procent_curs = 50;-- (select activitati.procent_curs from activitati where activitati.activitate_predata=nume_curs limit 1);
set @procent_lab =30;--  (select activitati.procent_lab from activitati where activitati.activitate_predata=nume_curs limit 1 );
set @procent_seminar =20;-- (select activitati.procent_seminar from activitati where activitati.activitate_predata=nume_curs limit 1);


set @nota_finala = ((@procent_lab/100) * @nota_finala_lab) + ((@procent_seminar/100) * @nota_finala_seminar) + ((@procent_curs/100) * @nota_finala_curs);
 if(@nota_finala <5) then
insert into catalog
values(@ID,@nota_finala,'nepromovat',@IDstudent,@IDmaterie,NULL);
else 
insert into catalog
values(@ID,@nota_finala,'promovat',@IDstudent,@IDmaterie,NULL);
end if;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtin_id_materie11` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtin_id_materie11`( id_profesor int)
BEGIN
SELECT inscriere.id_materie FROM  inscriere WHERE id_profesor = inscriere.id_profesor;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_coloviu_profesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_coloviu_profesor`(in nume_prof varchar(45), in prenume_prof varchar(45))
begin
set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
 select 'colocviu',calendar.data_colocviu, informatii_profesor.activitate_predata
  from  calendar,informatii_profesor where 
calendar.id_info=informatii_profesor.id_info and calendar.data_colocviu=current_date() and informatii_profesor.id_profesor=@IDprof;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_examene_profesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_examene_profesor`(in nume_prof varchar(45), in prenume_prof varchar(45))
begin
set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
 select 'examen',calendar.data_examen, informatii_profesor.activitate_predata
  from  calendar,informatii_profesor where 
calendar.id_info=informatii_profesor.id_info and calendar.data_examen=current_date() and informatii_profesor.id_profesor=@IDprof;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_partial_profesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_partial_profesor`(in nume_prof varchar(45), in prenume_prof varchar(45))
begin
set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
 select 'partial',calendar.data_partial, informatii_profesor.activitate_predata
  from  calendar,informatii_profesor where 
calendar.id_info=informatii_profesor.id_info and calendar.data_partial=current_date() and informatii_profesor.id_profesor=@IDprof;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_prof_curs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_prof_curs`(in nume_prof varchar(45), in prenume_prof varchar(45), in nume_zi varchar(30))
begin
set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
 select 'curs',activitati.activitate_predata, activitati.ora_curs
from  activitati,informatii_profesor where 
activitati.id_info=informatii_profesor.id_info and activitati.zi_curs=nume_zi and informatii_profesor.id_profesor=@IDprof;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_prof_laborator` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_prof_laborator`(in nume_prof varchar(45), in prenume_prof varchar(45), in nume_zi varchar(30))
begin
set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume_prof and profesor.prenume=prenume_prof);

     
 select 'laborator',activitati.activitate_predata, activitati.ora_lab
from  activitati,informatii_profesor where 
activitati.id_info=informatii_profesor.id_info and activitati.zi_lab=nume_zi and informatii_profesor.id_profesor=@IDprof;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_prof_seminar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_prof_seminar`(in nume_prof varchar(45), in prenume_prof varchar(45), in nume_zi varchar(30))
begin
set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
 select 'seminar',activitati.activitate_predata, activitati.ora_seminar
from  activitati,informatii_profesor where 
activitati.id_info=informatii_profesor.id_info and activitati.zi_seminar=nume_zi and informatii_profesor.id_profesor=@IDprof order by informatii_profesor.tip;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_restanta_c_profesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_restanta_c_profesor`(in nume_prof varchar(45), in prenume_prof varchar(45))
begin
set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
 select 'restanta curs',calendar.data_restanta_curs, informatii_profesor.activitate_predata
  from  calendar,informatii_profesor where 
calendar.id_info=informatii_profesor.id_info and calendar.data_restanta_curs=current_date() and informatii_profesor.id_profesor=@IDprof;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_restanta_l_profesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_restanta_l_profesor`(in nume_prof varchar(45), in prenume_prof varchar(45))
begin
set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
 select 'restanta laborator',calendar.data_restanta_lab, informatii_profesor.activitate_predata
  from  calendar,informatii_profesor where 
calendar.id_info=informatii_profesor.id_info and calendar.data_restanta_lab=current_date() and informatii_profesor.id_profesor=@IDprof;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_student` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_student`(in nume varchar(30), in prenume varchar(30))
begin
set @IDstud=(select student.id_student from student where student.nume=nume and student.prenume=prenume);

select inscriere_student.denumire_materie, inscriere_student.tip, inscriere_student.zi, inscriere_student.ora from 
inscriere_student where inscriere_student.id_student=@IDstud;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_student_meet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_student_meet`(in nume varchar(30), in prenume varchar(30))
begin
set @IDstud=(select student.id_student from student where student.nume=nume and student.prenume=prenume);

select  materie.descriere ,inscriere_meet_grup.scriere, inscriere_meet_grup.data_meet,inscriere_meet_grup.ora_meet from materie inner join  grup_studiu on materie.id_materie=grup_studiu.id_materie inner join
meet_grup on grup_studiu.id_grup=meet_grup.id_grup inner join inscriere_meet_grup on meet_grup.id_meet=inscriere_meet_grup.id_meet
and inscriere_meet_grup.id_student=@IDstud ;


end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_student_ZiCurenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_student_ZiCurenta`(in nume varchar(30), in prenume varchar(30), in zi varchar(30))
begin
set @IDstud=(select student.id_student from student where student.nume=nume and student.prenume=prenume);

select inscriere_student.denumire_materie, inscriere_student.tip, inscriere_student.zi, inscriere_student.ora from 
inscriere_student where inscriere_student.id_student=@IDstud and inscriere_student.zi=zi;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `orar_student_ZiCurenta_meet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `orar_student_ZiCurenta_meet`(in nume varchar(30), in prenume varchar(30))
begin
set @IDstud=(select student.id_student from student where student.nume=nume and student.prenume=prenume);

select  materie.descriere ,inscriere_meet_grup.scriere, inscriere_meet_grup.data_meet,inscriere_meet_grup.ora_meet from materie inner join  grup_studiu on materie.id_materie=grup_studiu.id_materie inner join
meet_grup on grup_studiu.id_grup=meet_grup.id_grup inner join inscriere_meet_grup on meet_grup.id_meet=inscriere_meet_grup.id_meet
and inscriere_meet_grup.id_student=@IDstud and inscriere_meet_grup.data_meet=current_date();


end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `programareactivitati28` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `programareactivitati28`( in nume_curs varchar(45),in nume_prof varchar(45),in prenume_prof varchar(45),in tip varchar(40),in nr_ore INT)
begin
set @ID_activ=( SELECT MAX(activitati.id_activitati) FROM activitati) + 1;
if @ID_activ IS NULL then
set @ID_activ=1;
end if;
SET @prlab=(SELECT activitati.procent_lab from activitati where activitati.activitate_predata=nume_curs limit 1);
SET @prcurs=(SELECT activitati.procent_curs from activitati where activitati.activitate_predata=nume_curs limit 1);
SET @prseminar=(SELECT activitati.procent_seminar from activitati where activitati.activitate_predata=nume_curs limit 1);
SET @IDprof=(SELECT profesor.id_profesor  from profesor 
              where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
SET @IDinfo = (SELECT informatii_profesor.id_info
               from informatii_profesor
			   where( informatii_profesor.id_profesor=@IDprof
                and informatii_profesor.tip=tip and informatii_profesor.activitate_predata=nume_curs));
               
  SELECT @IDinfo;

SET @IDmaterie = (SELECT materie.id_materie
               from materie
			   where materie.descriere=nume_curs);
               
-- SELECT @IDmaterie;
if(tip='laborator') then
IF EXISTS (SELECT * FROM  platforma_studiu.activitati WHERE activitati.id_info = @IDinfo) then
UPDATE platforma_studiu.activitati set activitati.nr_ore_lab=nr_ore;
ELSE
insert  into activitati  
VALUES(@ID_activ,nume_curs,NULL,NULL,NULL,NULL,NULL,NULL,@prlab,@prcurs,@prseminar,nr_ore,NULL,NULL,@IDinfo);
end if;
end if;

if(tip='seminar') then
IF EXISTS (SELECT * FROM  platforma_studiu.activitati WHERE activitati.id_info = @IDinfo) then
UPDATE platforma_studiu.activitati set activitati.nr_ore_seminar=nr_ore;
ELSE
insert  into activitati  
VALUES(@ID_activ,nume_curs,NULL,NULL,NULL,NULL,NULL,NULL,@prlab,@prcurs,@prseminar,NULL,NULL,nr_ore,@IDinfo);
end if;
end if;

if(tip='curs') then
IF EXISTS (SELECT * FROM  platforma_studiu.activitati WHERE activitati.id_info = @IDinfo) then
UPDATE platforma_studiu.activitati set activitati.nr_ore_curs=nr_ore;
ELSE
insert  into activitati  
VALUES(@ID_activ,nume_curs,NULL,NULL,NULL,NULL,NULL,NULL,@prlab,@prcurs,@prseminar,NULL,nr_ore,NULL,@IDinfo);
end if;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `programarecurs4` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `programarecurs4`(in nume varchar(40), in prenume varchar(40),in nume_curs varchar(45), in zi varchar(45), in ora varchar(45), data_examen DATE, data_partial DATE, data_restanta_curs DATE)
begin

set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume and profesor.prenume=prenume);

 set @IDinfo =(Select informatii_profesor.id_info from informatii_profesor
            where informatii_profesor.id_profesor=@IDprof and informatii_profesor.tip='curs' and informatii_profesor.activitate_predata=nume_curs limit 1);
	 	select @IDinfo;
set @ID=( SELECT MAX(calendar.id_calendar) FROM calendar) + 1;
if @ID IS NULL then
set @ID=1;
end if;
SET @IDmaterie = (SELECT materie.id_materie
               from materie
			   where materie.descriere=nume_curs);
update activitati set activitati.zi_curs=zi where activitati.activitate_predata=nume_curs;
update activitati set activitati.ora_curs=ora where activitati.activitate_predata=nume_curs;

IF EXISTS (SELECT * FROM  platforma_studiu.calendar WHERE calendar.id_info = @IDinfo) then
UPDATE platforma_studiu.calendar set calendar.data_examen=data_examen , calendar.data_partial=data_partial, calendar.data_restanta_curs=data_restanta_curs
 where calendar.id_materie=@IDmaterie and calendar.id_info=@IDinfo; 
ELSE
insert  into calendar  
VALUES(@ID,data_partial,NULL,data_examen,NULL,data_restanta_curs,@IDmaterie,@IDinfo);
end if;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `programarelabo1` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `programarelabo1`(in nume varchar(40), in prenume varchar(40),in nume_curs varchar(45), in zi varchar(45), in ora varchar(45), data_colocviu DATE, data_restanta_lab DATE)
begin

set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume and profesor.prenume=prenume);

set @IDinfo =(Select informatii_profesor.id_info from informatii_profesor
              where informatii_profesor.id_profesor=@IDprof and informatii_profesor.tip='laborator' and informatii_profesor.activitate_predata=nume_curs);
select @IDinfo;
set @ID=( SELECT MAX(calendar.id_calendar) FROM calendar) + 1;
if @ID IS NULL then
set @ID=1;
end if;
SET @IDmaterie = (SELECT materie.id_materie
               from materie
			   where materie.descriere=nume_curs);

update activitati set activitati.zi_lab=zi where activitati.activitate_predata=nume_curs;
update activitati set activitati.ora_lab=ora where activitati.activitate_predata=nume_curs;

IF EXISTS (SELECT * FROM  platforma_studiu.calendar WHERE calendar.id_info = @IDinfo) then
UPDATE platforma_studiu.calendar set calendar.data_colocviu=data_colocviu , calendar.data_restanta_lab=data_restanta_lab
 where calendar.id_materie=@IDmaterie and calendar.id_info=@IDinfo; 
ELSE
insert  into calendar  
VALUES(@ID,NULL,data_colocviu,NULL,data_restanta_lab,NULL,@IDmaterie,@IDinfo);
end if;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `programaresem2` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `programaresem2`(in nume varchar(40), in prenume varchar(40),in nume_curs varchar(45), in zi varchar(45), in ora varchar(45))
begin

set @IDprof = (Select profesor.id_profesor from profesor
              where profesor.nume=nume and profesor.prenume=prenume);

set @IDinfo =(Select informatii_profesor.id_info from informatii_profesor
              where informatii_profesor.id_profesor=@IDprof and informatii_profesor.tip='seminar');
select @IDinfo;
set @ID=( SELECT MAX(calendar.id_calendar) FROM calendar) + 1;
if @ID IS NULL then
set @ID=1;
end if;
SET @IDmaterie = (SELECT materie.id_materie
               from materie
			   where materie.descriere=nume_curs);

update activitati set activitati.zi_seminar=zi where activitati.activitate_predata=nume_curs;
update activitati set activitati.ora_seminar=ora where activitati.activitate_predata=nume_curs;



end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `renuntarecurs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `renuntarecurs`(in nume_curs varchar(20),in nume_stud varchar(45), in prenume_stud varchar(45),in CNP varchar(45))
BEGIN
set @IDmaterie=(select materie.id_materie from materie where materie.descriere=nume_curs);
SET @idstud = (SELECT student.id_student
               from student
               where student.nume = nume_stud
               and student.prenume = prenume_stud
               and  student.CNP = CNP);
DELETE  
FROM curs
WHERE curs.id_student = @idstud and curs.id_materie=@IDmaterie;

DELETE  
FROM seminar
WHERE seminar.id_student = @idstud and seminar.id_materie=@IDmaterie;

DELETE  
FROM laborator
WHERE laborator.id_student = @idstud and laborator.id_materie=@IDmaterie;

DELETE  
FROM inscriere
WHERE inscriere.id_student = @idstud and inscriere.id_materie=@IDmaterie;

DELETE  
FROM inscriere_student
WHERE inscriere_student.id_student = @idstud and inscriere_student.denumire_materie=nume_curs;

DELETE  
FROM catalog
WHERE catalog.id_student = @idstud and catalog.id_materie=@IDmaterie;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `search_prof` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_prof`( in nume varchar(45), in prenume varchar(45))
begin
SELECT *
FROM  profesor WHERE nume=profesor.nume and prenume=profesor.prenume;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `search_stud` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_stud`( in nume varchar(45), in prenume varchar(45))
begin
SELECT *
FROM student WHERE nume = student.nume and prenume=student.prenume ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `showInfoAdmin3` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `showInfoAdmin3`( in CNP varchar(13))
begin
SELECT *
FROM administrator
WHERE CNP = administrator.CNP;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `showInfoProf3` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `showInfoProf3`( in CNP varchar(13))
begin
SELECT *
FROM profesor
WHERE CNP = profesor.CNP;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `showInfoStud_1` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `showInfoStud_1`(in nume varchar(45), in prenume varchar(45), in CNP varchar(13))
begin
SELECT *
FROM student WHERE nume=student.nume AND prenume=student.prenume AND CNP=student.CNP;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `showInfoSuperAdmin5` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `showInfoSuperAdmin5`( in CNP varchar(13))
begin
SELECT *
FROM SuperAdministrator
WHERE CNP = SuperAdministrator.CNP;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin

set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);
set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);

set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);
set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet and inscriere_meet_grup.id_student=@IDstud);
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=meet_grup.nr_min_participanti and meet_grup.id_meet=@IDmeet and date_add(@ora_creare_meet,interval @timp_exp hour)<@ora_inscriere_copil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet1` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet1`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin

set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);
set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);

set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);
set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet and inscriere_meet_grup.id_student=@IDstud);
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=meet_grup.nr_min_participanti and meet_grup.id_meet=@IDmeet and date_add(@ora_creare_meet,interval 1 hour )<@ora_inscriere_copil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet10` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet10`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

select addtime(@ora_creare_meet, '1:00');

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
 
 select @ora_inscriere_copil;
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and addtime(@ora_creare_meet, '1:00')<@ora_inscriere_copil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet11` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet11`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

select addtime(@ora_creare_meet, '1:00');

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
 
 select @ora_inscriere_copil;
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and addtime(@ora_creare_meet, '1:00')<'23:00'then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet12` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet12`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

select addtime(@ora_creare_meet, '1:00');

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
 
 
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and addtime(@ora_creare_meet, '00:04')< @ora_inscriere_copil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet13` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet13`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

select addtime(@ora_creare_meet, '1:00');

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
 
 
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and addtime(@ora_creare_meet, '00:04')< '23:00' then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet14` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet14`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

select addtime(@ora_creare_meet, '1:00');

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
 
 
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and addtime(@ora_creare_meet, '00:04')< addtime(@ora_inscriere_copil,'00:00') then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet15` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet15`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

select addtime(@ora_creare_meet, '1:00');

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
 
 
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and addtime(@ora_creare_meet, '00:01')< addtime(@ora_inscriere_copil,'00:00') then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet16` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet16`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

select addtime(@ora_creare_meet, '1:00');

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
 
 set @timp_creare=addtime(@ora_creare_meet, '00:01');
 set @timpcopil=addtime(@ora_inscriere_copil,'00:00');
 
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and @timpcreare< @timpcopil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet17` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet17`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

select addtime(@ora_creare_meet, '1:00');

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
 
 select  @timp_creare=addtime(@ora_creare_meet, '00:01');
 select  @timpcopil=addtime(@ora_inscriere_copil,'00:00');
 
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and @timpcreare< @timpcopil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet18` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet18`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45),in inscrieree_ora time)
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

select addtime(@ora_creare_meet, '1:00');

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
 
 -- select  @timp_creare=addtime(@ora_creare_meet, '00:01');
 -- select  @timpcopil=addtime(@ora_inscriere_copil,'00:00');
 
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and addtime(@ora_creare_meet, '00:01')< inscrieree_ora then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet2` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet2`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin

set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);
set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=meet_grup.nr_min_participanti and meet_grup.id_meet=@IDmeet and date_add(@ora_creare_meet,interval 1 hour )<@ora_inscriere_copil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet20` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet20`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45),in inscrieree_ora time)
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

-- select addtime(@ora_creare_meet, '1:00');

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);

-- set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);

 
 -- select  @timp_creare=addtime(@ora_creare_meet, '00:01');
 -- select  @timpcopil=addtime(@ora_inscriere_copil,'00:00');
 
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet limit 1)  and addtime(@ora_creare_meet, '00:00:30')< inscrieree_ora then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet3` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet3`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin

set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);
set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup) and meet_grup.id_meet=@IDmeet and date_add(@ora_creare_meet,interval 1 hour )<@ora_inscriere_copil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet5` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet5`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);
set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and date_add(@ora_creare_meet,interval 1 hour )<@ora_inscriere_copil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet6` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet6`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);
set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and date_add(@ora_creare_meet,interval 1 hour )<@ora_inscriere_copil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;

select date_add(@ora_creare_meet,interval 1 hour );
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet7` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet7`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);
select date_add(@ora_creare_meet,interval 1 hour );

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and date_add(@ora_creare_meet,interval 1 hour )<@ora_inscriere_copil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet8` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet8`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);
select @ora_creare_meet;

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and date_add(@ora_creare_meet,interval 1 hour )<@ora_inscriere_copil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `validare_meet9` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `validare_meet9`( in nume_stud varchar(45), in prenume_stud varchar(45), in CNP varchar(45),in den_materie varchar(45), descriere_meet varchar(45), nume_prof varchar(45), prenume_prof varchar(45))
begin
set@Idmaterie=(SELECT materie.id_materie from materie where materie.descriere=den_materie);

set @IDgrup=(select grup_studiu.id_grup from grup_studiu where grup_studiu.id_materie=@Idmaterie);
set @IDprof=(select profesor.id_profesor from profesor where profesor.nume=nume_prof and profesor.prenume=prenume_prof);
set@IDmeet=(SELECT meet_grup.id_meet from meet_grup where meet_grup.id_grup=@IDgrup and meet_grup.scriere=descriere_meet and meet_grup.id_profesor=@IDprof); 
set @ora_creare_meet=(select meet_grup.ora_creare from meet_grup where meet_grup.id_meet=@IDmeet);

set @timp_exp=(select inscriere_meet_grup.timp_expirare from inscriere_meet_grup where id_meet=@IDmeet limit 1);
set @IDstud=(select student.id_student from student where student.nume=nume_stud and student.prenume=prenume_stud and student.CNP=CNP);
set @ora_inscriere_copil=(select inscriere_meet_grup.ora_creare from inscriere_meet_grup where inscriere_meet_grup.id_meet =@IDmeet
 and inscriere_meet_grup.id_student=@IDstud);
set @nr_ordine=(select count(*) from inscriere_meet_grup where inscriere_meet_grup.id_meet=@IDmeet);
if @nr_ordine=(select meet_grup.nr_min_participanti from meet_grup where meet_grup.id_meet=@IDmeet)  and addtime(@ora_creare_meet, '1:00')<@ora_inscriere_copil then
delete from meet_grup where meet_grup.id_meet=@IDmeet;


end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `viuzalizare_membrii_grup` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `viuzalizare_membrii_grup`(in materie_grup varchar(45))
begin

set @Idmaterie=(select materie.id_materie from materie where materie.descriere=materie_grup);
select student.nume, student.prenume from student inner join activitate_suplimentara 
on student.id_student=activitate_suplimentara.id_student inner join
grup_studiu on activitate_suplimentara.id_grup=grup_studiu.id_grup and grup_studiu.id_materie=@Idmaterie group by student.nume
order by student.nume;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-19 23:57:10
