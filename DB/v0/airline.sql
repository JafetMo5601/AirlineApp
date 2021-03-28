-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 17, 2021 at 11:16 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airline`
--
CREATE DATABASE IF NOT EXISTS `airline` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `airline`;

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `CreateUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateUser` (IN `user_id` INT(12), IN `name` VARCHAR(30), IN `last_name` VARCHAR(50), IN `birthday` DATE, IN `email` VARCHAR(255), IN `password` VARCHAR(90), IN `sex` CHAR(1), IN `address` VARCHAR(255))  BEGIN
	INSERT INTO users (`user_id`, `name`, `last_name`, `birthday`, `email`, `password`, `sex`, `address`) 
    VALUES (user_id,name,last_name,birthday,email,password,sex,address);
END$$

DROP PROCEDURE IF EXISTS `CreateWorker`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateWorker` (IN `user_id` INT(12), IN `name` VARCHAR(30), IN `last_name` VARCHAR(50), IN `birthday` DATE, IN `email` VARCHAR(255), IN `password` VARCHAR(90), IN `sex` CHAR(1), IN `address` VARCHAR(255), IN `admin_access` INT(1))  BEGIN
	INSERT INTO workers (`user_id`, `name`, `last_name`, `birthday`, `email`, `password`, `sex`, `address`, `admin_access_id`) 
    VALUES (user_id,name,last_name,birthday,email,password,sex,address,admin_access);
END$$

DROP PROCEDURE IF EXISTS `LoginUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `LoginUser` (IN `uEmail` VARCHAR(255), IN `uPassword` BINARY(64))  BEGIN 
	SELECT u.name, u.email FROM users u
	WHERE u.email = uEmail AND u.password = uPassword;
END$$

DROP PROCEDURE IF EXISTS `UserRetrieve`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UserRetrieve` (IN `in_email` VARCHAR(255), OUT `out_user_id` VARCHAR(12), OUT `out_name` VARCHAR(30), OUT `out_last_name` VARCHAR(50))  BEGIN

SELECT `user_id`, `name`, `last_name` 
INTO out_user_id, out_name, out_last_name
FROM users WHERE `email` = in_email;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(12) NOT NULL,
  `name` varchar(30) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(90) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `last_name`, `birthday`, `email`, `password`, `sex`, `address`) VALUES
(208180603, 'Jafet', 'Mora Ugalde', '2001-06-05', 'jafet.moraugalde15@gmail.com', 'f10b7247f971f2c92b5b5b31f40dd76bebca82e5c29420dbddaafa10da3a8eb0', 'M', 'Ciruelas, Alajuela');

-- --------------------------------------------------------

--
-- Table structure for table `workers`
--

DROP TABLE IF EXISTS `workers`;
CREATE TABLE `workers` (
  `user_id` int(12) NOT NULL,
  `name` varchar(30) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(90) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `admin_access_id` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `workers_admin_access`
--

DROP TABLE IF EXISTS `workers_admin_access`;
CREATE TABLE `workers_admin_access` (
  `admin_access_id` int(1) NOT NULL,
  `admin_access_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `workers`
--
ALTER TABLE `workers`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `admin_access_id` (`admin_access_id`);

--
-- Indexes for table `workers_admin_access`
--
ALTER TABLE `workers_admin_access`
  ADD PRIMARY KEY (`admin_access_id`),
  ADD UNIQUE KEY `admin_access_name` (`admin_access_name`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `workers`
--
ALTER TABLE `workers`
  ADD CONSTRAINT `workers_ibfk_1` FOREIGN KEY (`admin_access_id`) REFERENCES `workers_admin_access` (`admin_access_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
