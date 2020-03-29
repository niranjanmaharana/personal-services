-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.70-community-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for niranzan
CREATE DATABASE IF NOT EXISTS `niranzan` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `niranzan`;

-- Dumping structure for table niranzan.authority
CREATE TABLE IF NOT EXISTS `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT b'1',
  `create_date_time` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `update_date_time` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_ROLENAME` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table niranzan.authority: 3 rows
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` (`id`, `active`, `create_date_time`, `created_by`, `update_date_time`, `updated_by`, `valid_from`, `valid_to`, `version`, `name`) VALUES
	(1, b'1', '2020-03-29 21:25:51', NULL, '2020-03-29 21:25:52', NULL, '2020-03-29 21:25:53', '8888-12-31 21:25:54', 1, 'ROLE_SUPERADMIN'),
	(2, b'1', '2020-03-29 21:26:16', NULL, '2020-03-29 21:26:17', NULL, '2020-03-29 21:26:18', '8888-12-31 21:26:19', 1, 'ROLE_ADMIN'),
	(3, b'1', '2020-03-29 21:26:35', NULL, '2020-03-29 21:26:36', NULL, '2020-03-29 21:26:36', '8888-12-31 21:26:37', 1, 'ROLE_USER');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;

-- Dumping structure for table niranzan.user_authority
CREATE TABLE IF NOT EXISTS `user_authority` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKiwgsyem2maacfmh11eknji0se` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table niranzan.user_authority: 3 rows
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` (`user_id`, `role_id`) VALUES
	(1, 1),
	(1, 2),
	(1, 3);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;

-- Dumping structure for table niranzan.user_profile
CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT b'1',
  `create_date_time` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `update_date_time` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `profile_pic` varchar(200) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_USERNAME` (`username`),
  UNIQUE KEY `UNIQUE_EMAIL` (`email`),
  UNIQUE KEY `UNIQUE_MOBILE` (`mobile`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table niranzan.user_profile: 1 rows
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` (`id`, `active`, `create_date_time`, `created_by`, `update_date_time`, `updated_by`, `valid_from`, `valid_to`, `version`, `email`, `full_name`, `mobile`, `password`, `profile_pic`, `username`) VALUES
	(1, b'1', '2020-03-29 21:23:35', NULL, '2020-03-29 21:23:36', NULL, '2020-03-29 21:23:37', '8888-12-31 21:23:37', 1, 'niranjanmaharana95@gmail.com', 'Niranjan Maharana', '9556824846', '$HohklWeEWxn10sJiL9peB.wMNG.1anIwLQP2eAaUiv77xEPH41uAy', NULL, 'niranjan');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;

-- Dumping structure for table niranzan.user_type
CREATE TABLE IF NOT EXISTS `user_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT b'1',
  `create_date_time` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `update_date_time` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table niranzan.user_type: 0 rows
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;