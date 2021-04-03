-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 02, 2021 at 10:35 PM
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

DROP PROCEDURE IF EXISTS `DeleteWorker`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteWorker` (IN `wId` VARCHAR(255))  BEGIN

	DELETE FROM workers
    WHERE `user_id` = wId;

END$$

DROP PROCEDURE IF EXISTS `LoginUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `LoginUser` (IN `uEmail` VARCHAR(255), IN `uPassword` VARCHAR(64), OUT `out_name` VARCHAR(30), OUT `out_email` VARCHAR(50))  BEGIN 
	SELECT `name`, `email` 
    INTO out_name, out_email
    FROM users
	WHERE `email` = uEmail AND `password` = uPassword;
END$$

DROP PROCEDURE IF EXISTS `UpdateWorkerAccess`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateWorkerAccess` (IN `wId` INT(12), IN `wAccess` VARCHAR(1))  BEGIN
	UPDATE `workers` 
    SET `admin_access_id` = wAccess 
    WHERE `workers`.`user_id` = wId;
END$$

DROP PROCEDURE IF EXISTS `UpdateWorkerEmail`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateWorkerEmail` (IN `wEmail` VARCHAR(255), IN `wId` INT(12))  BEGIN
	UPDATE `workers` 
    SET `email` = 'wEmail' 
    WHERE `workers`.`user_id` = wId;
END$$

DROP PROCEDURE IF EXISTS `UserRetrieve`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `UserRetrieve` (IN `in_email` VARCHAR(255), OUT `out_user_id` VARCHAR(12), OUT `out_name` VARCHAR(30), OUT `out_last_name` VARCHAR(50))  BEGIN

SELECT `user_id`, `name`, `last_name` 
INTO out_user_id, out_name, out_last_name
FROM users WHERE `email` = in_email;

END$$

DROP PROCEDURE IF EXISTS `WorkerRetrieve`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `WorkerRetrieve` (IN `wId` INT(12), OUT `out_user_id` INT(12), OUT `out_name` VARCHAR(30), OUT `out_last_name` VARCHAR(50), OUT `out_birthday` DATE, OUT `out_email` VARCHAR(255), OUT `out_sex` CHAR(1), OUT `out_address` VARCHAR(255), OUT `out_admin_access` INT(1))  BEGIN

	SELECT `user_id`
		,`name`
        ,`last_name`
        ,`birthday`
        ,`email`
        ,`sex`
        ,`address`
        ,`admin_access_id`
    INTO out_user_id
    	,out_name
        ,out_last_name
        ,out_birthday
        ,out_email
        ,out_sex
        ,out_address
        ,out_admin_access
    FROM `workers` 
    WHERE `workers`.`user_id` = wId;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--
-- Creation: Mar 17, 2021 at 06:41 AM
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
(208180603, 'Jafet', 'Mora Ugalde', '2001-06-01', 'jafet.moraugalde15@gmail.com', 'aCrL7C/tUwDB7yxhrfH+ZOqv4CEHLLcgtY34c8/oEss=', 'M', 'Alajuela, Costa Rica'),
(208880888, 'Testeo', 'Testeo Testeo', '2021-03-17', 'testeo.testeo@gmail.com', '0Z7Ep9n214F9zj3/bRLqww==', 'M', 'Testeo, Costa Rica');

-- --------------------------------------------------------

--
-- Table structure for table `workers`
--
-- Creation: Mar 17, 2021 at 06:48 AM
-- Last update: Apr 02, 2021 at 08:34 PM
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

--
-- Dumping data for table `workers`
--

INSERT INTO `workers` (`user_id`, `name`, `last_name`, `birthday`, `email`, `password`, `sex`, `address`, `admin_access_id`) VALUES
(2008180603, 'Jafet', 'Mora', '2021-04-19', 'jafet.mora@airlineapp.com', '12345678', 'M', 'Ciruelas, Alajuela', 1);

-- --------------------------------------------------------

--
-- Table structure for table `workers_admin_access`
--
-- Creation: Mar 17, 2021 at 03:26 AM
-- Last update: Apr 02, 2021 at 07:06 PM
--

DROP TABLE IF EXISTS `workers_admin_access`;
CREATE TABLE `workers_admin_access` (
  `admin_access_id` int(1) NOT NULL,
  `admin_access_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `workers_admin_access`
--

INSERT INTO `workers_admin_access` (`admin_access_id`, `admin_access_name`) VALUES
(0, 'admin'),
(1, 'vendor');

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
