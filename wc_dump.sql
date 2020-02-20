-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: wildcircus
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
-- Current Database: `wildcircus`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `wildcircus` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `wildcircus`;

--
-- Table structure for table `artiste`
--

DROP TABLE IF EXISTS `artiste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artiste` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `presentation` varchar(255) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artiste`
--

LOCK TABLES `artiste` WRITE;
/*!40000 ALTER TABLE `artiste` DISABLE KEYS */;
INSERT INTO `artiste` VALUES (4,'Tim moté','Clown','https://scontent-cdg2-1.xx.fbcdn.net/v/t1.0-9/81233463_10216008748147092_523635579435352064_o.jpg?_nc_cat=110&_nc_ohc=48IQuXo52jsAX_PWEXV&_nc_ht=scontent-cdg2-1.xx&oh=52627217efa5aaaacf46b8deb0fa10ca&oe=5EB967B7'),(5,'lady one','Danseuse','https://www.codeur.com/system/user_profiles/avatars/000/275/418/large/avatar.jpg?1555654739'),(6,'Rom un','Dompteur de lions','https://cefii.fr/wp-content/uploads/2018/12/RomainClair.jpg');
/*!40000 ALTER TABLE `artiste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spectacle`
--

DROP TABLE IF EXISTS `spectacle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spectacle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `description` text NOT NULL,
  `name` varchar(255) NOT NULL,
  `places` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spectacle`
--

LOCK TABLES `spectacle` WRITE;
/*!40000 ALTER TABLE `spectacle` DISABLE KEYS */;
INSERT INTO `spectacle` VALUES (3,'2020-02-29 00:00:00','Petits et grands, embarquez pour le plus gigantesque, chic et authentique des spectacles de cirque !\r\nSous le plus beau chapiteau de France, numéros irrésistibles et attractions monumentales vous feront tourner la tête et chavirer de bonheur.\r\nEntre exploits, magie et poésie, nos bêtes de cirque créent un embrasement d’émotions comme vous n’en vivrez nulle part ailleurs.','Plus fort et sauvage',302,25,'Rouen','https://cdn.pixabay.com/photo/2018/02/11/21/39/weightlifter-3146825_1280.jpg'),(4,'2020-02-21 00:00:00','Dans ce spectacle mis en scène par \"Rom un\", héro à la personnalité marginale, vous mène au cœur d’une aventure exaltante alors qu’elle plonge dans un univers surréel issu de son imagination. Sentez l’adrénaline monter alors qu’elle plonge dans ce monde fantastique pour accomplir sa destinée et devenir un homme confiant, curieux et créatif. il vous invite à suspendre la réalité et à glisser dans un monde d’où jaillit une vie colorée, avec des projections visuelles incroyables et une bande sonore qui fusionne harmonieusement la musique populaire avec la sonorisation typique du wild circus. Ce spectacle convient à tous les publics.','les betes du cirque',143,25,'Tours','https://cdn.pixabay.com/photo/2018/07/31/22/08/lion-3576045__480.jpg'),(5,'2020-02-29 00:00:00',' Un humour bouffon décapant et des numéros acrobatiques inspirés du cirque .\r\nVéritable retour aux sources pour le Wild circus, il entremêle acrobaties et humour clownesque pour explorer les thèmes de la peur, de l\'identité, de la reconnaissance et du pouvoir. Le parcours de l\'Innocent lui fait rencontrer de drôles de personnages d\'un univers électrifiant débordant de surprises, de frissons, d\'audace et de dépassement.','le bouffon sauvage',250,25,'Paris','https://cdn.pixabay.com/photo/2020/02/11/21/36/street-artists-4841012_1280.jpg');
/*!40000 ALTER TABLE `spectacle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spectacle_artistes`
--

DROP TABLE IF EXISTS `spectacle_artistes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spectacle_artistes` (
  `spectacles_id` bigint(20) NOT NULL,
  `artistes_id` bigint(20) NOT NULL,
  PRIMARY KEY (`spectacles_id`,`artistes_id`),
  KEY `FK29q9v3wsq049c6s5vtsp26rne` (`artistes_id`),
  CONSTRAINT `FK29q9v3wsq049c6s5vtsp26rne` FOREIGN KEY (`artistes_id`) REFERENCES `artiste` (`id`),
  CONSTRAINT `FK8gf7647j9xdpwdnd1ij4k5i3i` FOREIGN KEY (`spectacles_id`) REFERENCES `spectacle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spectacle_artistes`
--

LOCK TABLES `spectacle_artistes` WRITE;
/*!40000 ALTER TABLE `spectacle_artistes` DISABLE KEYS */;
INSERT INTO `spectacle_artistes` VALUES (3,4),(4,4),(5,4),(3,5),(4,5),(4,6);
/*!40000 ALTER TABLE `spectacle_artistes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-20 14:46:09
