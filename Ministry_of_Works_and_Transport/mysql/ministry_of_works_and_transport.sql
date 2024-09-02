-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 17, 2023 at 04:58 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ministry_of_works_and_transport`
--
CREATE DATABASE IF NOT EXISTS `ministry_of_works_and_transport` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ministry_of_works_and_transport`;

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE IF NOT EXISTS `administrator` (
  `administratorid` varchar(20) NOT NULL,
  `stardate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fname` varchar(15) NOT NULL,
  `lname` varchar(15) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `srole` varchar(20) NOT NULL,
  `apassword` varchar(64) NOT NULL,
  PRIMARY KEY (`administratorid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`administratorid`, `stardate`, `fname`, `lname`, `dob`, `srole`, `apassword`) VALUES
('admin1234', '2022-12-25 01:00:12', 'John', 'Doe', '20-02-1987', 'Manager', 'e7cf3ef4f17c3999a94f2c6f612e8a888e5b1026878e4e19398b23bd38ec221a'),
('admin1235', '2022-12-25 01:00:31', 'Jane ', 'Doe', '20-02-1986', 'Manager', 'e7cf3ef4f17c3999a94f2c6f612e8a888e5b1026878e4e19398b23bd38ec221a');

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `contactid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) NOT NULL,
  `csubject` varchar(30) NOT NULL,
  `cemail` varchar(30) NOT NULL,
  `cmessage` mediumtext NOT NULL,
  `cdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`contactid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`contactid`, `cname`, `csubject`, `cemail`, `cmessage`, `cdate`) VALUES
(1, 'John Doe', 'Information Request', 'johndoe@gmail.com', 'I would like to know if my information has been processed.', '2022-12-14 07:50:07'),
(2, 'Ada Lovelace', 'Information Request', 'ada12@gmail.com', 'I would like to know if my information has been processed.', '2022-12-14 07:50:07'),
(4, 'Jane Doe', 'Information Request', '', 'I would like to know if my information has been processed.', '2023-01-14 04:08:17');

-- --------------------------------------------------------

--
-- Table structure for table `lrappointment`
--

DROP TABLE IF EXISTS `lrappointment`;
CREATE TABLE IF NOT EXISTS `lrappointment` (
  `appointmentid` int(11) NOT NULL AUTO_INCREMENT,
  `appmade` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uname` varchar(40) NOT NULL,
  `dpnumber` varchar(7) NOT NULL,
  `appdate` date NOT NULL,
  `apptime` time NOT NULL,
  PRIMARY KEY (`appointmentid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lrappointment`
--

INSERT INTO `lrappointment` (`appointmentid`, `appmade`, `uname`, `dpnumber`, `appdate`, `apptime`) VALUES
(1, '2023-01-17 04:44:05', 'John Doe', '1234565', '2023-01-17', '08:30:00'),
(2, '2023-01-17 04:47:36', 'Ada Lovelace', '1636589', '2023-01-17', '08:30:00'),
(3, '2023-01-17 04:50:43', 'Tippie Tambo', '1234567', '2023-01-17', '08:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
CREATE TABLE IF NOT EXISTS `register` (
  `uname` varchar(15) NOT NULL,
  `rdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uimage` varchar(255) NOT NULL,
  `remail` varchar(30) NOT NULL,
  `rpassword` varchar(64) NOT NULL,
  `fname` varchar(15) NOT NULL,
  `lname` varchar(15) NOT NULL,
  `dob` date NOT NULL,
  `lnumber` varchar(15) NOT NULL,
  `pnumber` varchar(15) NOT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`uname`, `rdate`, `uimage`, `remail`, `rpassword`, `fname`, `lname`, `dob`, `lnumber`, `pnumber`) VALUES
('123Ada', '2022-11-15 15:22:17', '../uploads/profile_image_three.png', 'ada12@gmail.com', 'e7cf3ef4f17c3999a94f2c6f612e8a888e5b1026878e4e19398b23bd38ec221a', 'Ada', 'Lovelace', '1987-05-15', '1636589', '+18687343453'),
('123Janedoe', '2022-11-15 15:16:45', '../uploads/profile_image_two.png', 'janedoe@gmail.com', 'e7cf3ef4f17c3999a94f2c6f612e8a888e5b1026878e4e19398b23bd38ec221a', 'Jane', 'Doe', '1989-07-15', '1234543', '+18683333432'),
('123Johndoe', '2022-11-15 03:39:45', '../uploads/profile_image_one.png', 'johndoe@gmail.com         ', 'e7cf3ef4f17c3999a94f2c6f612e8a888e5b1026878e4e19398b23bd38ec221a', 'John', 'Doe', '1983-06-18', '1234565', '1868-342-4454'),
('123TTam', '2023-01-16 23:44:29', '../uploads/profile_image_one.png', 'happyTippy@live.com', 'e7cf3ef4f17c3999a94f2c6f612e8a888e5b1026878e4e19398b23bd38ec221a', 'Tippie', 'Tambo', '2023-01-10', '1234567', '+18683333432');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `staffid` varchar(10) NOT NULL,
  `stardate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fname` varchar(15) NOT NULL,
  `lname` varchar(15) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `srole` varchar(20) NOT NULL,
  `spassword` varchar(64) NOT NULL,
  PRIMARY KEY (`staffid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffid`, `stardate`, `fname`, `lname`, `dob`, `srole`, `spassword`) VALUES
('00001234', '2022-12-25 00:34:03', 'John ', 'Doe', '20-02-1988', 'Clerk', 'e7cf3ef4f17c3999a94f2c6f612e8a888e5b1026878e4e19398b23bd38ec221a'),
('00001235', '2022-12-25 00:35:11', 'Jane ', 'Doe', '20-02-1989', 'Clerk', 'e7cf3ef4f17c3999a94f2c6f612e8a888e5b1026878e4e19398b23bd38ec221a');

-- --------------------------------------------------------

--
-- Table structure for table `staffloginlog`
--

DROP TABLE IF EXISTS `staffloginlog`;
CREATE TABLE IF NOT EXISTS `staffloginlog` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `logtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `staffid` varchar(10) NOT NULL,
  `fname` varchar(15) NOT NULL,
  `lname` varchar(15) NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staffloginlog`
--

INSERT INTO `staffloginlog` (`logid`, `logtime`, `staffid`, `fname`, `lname`) VALUES
(1, '2023-01-17 04:53:28', '00001234', 'John ', 'Doe');

-- --------------------------------------------------------

--
-- Table structure for table `stafflogoutlog`
--

DROP TABLE IF EXISTS `stafflogoutlog`;
CREATE TABLE IF NOT EXISTS `stafflogoutlog` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `logtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `staffid` varchar(10) NOT NULL,
  `fname` varchar(15) NOT NULL,
  `lname` varchar(15) NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stafflogoutlog`
--

INSERT INTO `stafflogoutlog` (`logid`, `logtime`, `staffid`, `fname`, `lname`) VALUES
(1, '2023-01-17 04:54:52', '00001234', 'John ', 'Doe');

-- --------------------------------------------------------

--
-- Table structure for table `subscribe`
--

DROP TABLE IF EXISTS `subscribe`;
CREATE TABLE IF NOT EXISTS `subscribe` (
  `subemail` varchar(30) NOT NULL,
  `sdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`subemail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subscribe`
--

INSERT INTO `subscribe` (`subemail`, `sdate`) VALUES
('ada12@gmail.com', '2022-12-14 08:11:32'),
('janedoe@gmail.com', '2022-12-14 08:11:32'),
('johndoe@gmail.com', '2022-12-14 08:11:32');

-- --------------------------------------------------------

--
-- Table structure for table `viappointment`
--

DROP TABLE IF EXISTS `viappointment`;
CREATE TABLE IF NOT EXISTS `viappointment` (
  `appointmentid` int(11) NOT NULL AUTO_INCREMENT,
  `appmade` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uname` varchar(40) NOT NULL,
  `dpnumber` varchar(7) NOT NULL,
  `lpnumber` varchar(8) NOT NULL,
  `appdate` date NOT NULL,
  `apptime` time NOT NULL,
  PRIMARY KEY (`appointmentid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `viappointment`
--

INSERT INTO `viappointment` (`appointmentid`, `appmade`, `uname`, `dpnumber`, `lpnumber`, `appdate`, `apptime`) VALUES
(1, '2023-01-17 04:46:10', 'John Doe', '1234565', 'PBH 6568', '2023-01-17', '08:30:00'),
(2, '2023-01-17 04:49:15', 'Ada Lovelace', '1636589', 'PBH 6569', '2023-01-17', '08:30:00'),
(3, '2023-01-17 04:52:26', 'Tippie Tambo', '1234567', 'PBH 6462', '2023-01-17', '08:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `vrappointment`
--

DROP TABLE IF EXISTS `vrappointment`;
CREATE TABLE IF NOT EXISTS `vrappointment` (
  `appointmentid` int(11) NOT NULL AUTO_INCREMENT,
  `appmade` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uname` varchar(40) NOT NULL,
  `lpnumber` varchar(8) NOT NULL,
  `dpnumber` varchar(7) NOT NULL,
  `appdate` date NOT NULL,
  `apptime` time NOT NULL,
  PRIMARY KEY (`appointmentid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vrappointment`
--

INSERT INTO `vrappointment` (`appointmentid`, `appmade`, `uname`, `lpnumber`, `dpnumber`, `appdate`, `apptime`) VALUES
(1, '2023-01-17 04:45:25', 'John Doe', 'PBH 6567', '1234565', '2023-01-17', '08:30:00'),
(2, '2023-01-17 04:48:38', 'Ada Lovelace', 'PBH 6269', '1636589', '2023-01-17', '08:30:00'),
(3, '2023-01-17 04:51:46', 'Tippie Tambo', 'PBH 6567', '1234567', '2023-01-17', '08:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `vtappointment`
--

DROP TABLE IF EXISTS `vtappointment`;
CREATE TABLE IF NOT EXISTS `vtappointment` (
  `appointmentid` int(11) NOT NULL AUTO_INCREMENT,
  `appmade` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uname` varchar(40) NOT NULL,
  `dpnumber` varchar(7) NOT NULL,
  `vtype` varchar(5) NOT NULL,
  `appdate` date NOT NULL,
  `apptime` time NOT NULL,
  PRIMARY KEY (`appointmentid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vtappointment`
--

INSERT INTO `vtappointment` (`appointmentid`, `appmade`, `uname`, `dpnumber`, `vtype`, `appdate`, `apptime`) VALUES
(1, '2023-01-17 04:44:33', 'John Doe', '1234565', 'Truck', '2023-01-17', '08:30:00'),
(2, '2023-01-17 04:48:00', 'Ada Lovelace', '1636589', 'Truck', '2023-01-17', '08:30:00'),
(3, '2023-01-17 04:51:07', 'Tippie Tambo', '1234567', 'Truck', '2023-01-17', '08:30:00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
