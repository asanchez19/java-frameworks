-- phpMyAdmin SQL Dump
-- version 4.4.15.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 25, 2017 at 12:22 AM
-- Server version: 5.6.25
-- PHP Version: 5.5.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `progra3`
--

-- --------------------------------------------------------

--
-- Table structure for table `email`
--

CREATE TABLE IF NOT EXISTS `email` (
  `id_email` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `email` text NOT NULL,
  `tipo` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `email`
--

INSERT INTO `email` (`id_email`, `id_empleado`, `email`, `tipo`) VALUES
(5, 12, 'mike_email@mike.com', 'personal'),
(6, 14, 'mike_email@mike.com', 'personal'),
(7, 15, 'mike_empleado@mike.com', 'personal'),
(8, 18, 'mike_email@mike.com', 'personal'),
(9, 19, 'mike_empleado@mike.com', 'personal'),
(10, 22, 'mike_email@mike.com', 'personal'),
(11, 23, 'mike_empleado@mike.com', 'personal'),
(12, 26, 'mike_email@mike.com', 'personal'),
(13, 27, 'mike_empleado@mike.com', 'personal'),
(14, 30, 'mike_email@mike.com', 'personal'),
(15, 31, 'mike_empleado@mike.com', 'personal'),
(16, 34, 'mike_email@mike.com', 'personal'),
(17, 35, 'mike_empleado@mike.com', 'personal'),
(18, 38, 'mike_email@mike.com', 'personal'),
(19, 39, 'mike_empleado@mike.com', 'personal'),
(20, 42, 'mike_email@mike.com', 'personal'),
(21, 43, 'mike_empleado@mike.com', 'personal'),
(22, 46, 'mike_email@mike.com', 'personal'),
(23, 47, 'mike_empleado@mike.com', 'personal'),
(24, 50, 'mike_email@mike.com', 'personal'),
(25, 51, 'mike_empleado@mike.com', 'personal'),
(26, 54, 'mike_email@mike.com', 'personal'),
(27, 55, 'mike_empleado@mike.com', 'personal'),
(28, 58, 'mike_email@mike.com', 'personal'),
(29, 59, 'mike_empleado@mike.com', 'personal'),
(30, 62, 'mike_email@mike.com', 'personal'),
(31, 63, 'mike_empleado@mike.com', 'personal'),
(32, 66, 'mike_email@mike.com', 'personal'),
(33, 67, 'mike_empleado@mike.com', 'personal'),
(34, 70, 'mike_email@mike.com', 'personal'),
(35, 71, 'mike_empleado@mike.com', 'personal'),
(36, 74, 'mike_email@mike.com', 'personal'),
(37, 75, 'mike_empleado@mike.com', 'personal'),
(38, 78, 'mike_email@mike.com', 'personal'),
(39, 79, 'mike_empleado@mike.com', 'personal'),
(40, 82, 'mike_email@mike.com', 'personal'),
(41, 83, 'mike_empleado@mike.com', 'personal'),
(42, 86, 'mike_email@mike.com', 'personal'),
(43, 87, 'mike_empleado@mike.com', 'personal'),
(44, 90, 'mike_email@mike.com', 'personal'),
(45, 91, 'mike_empleado@mike.com', 'personal'),
(46, 94, 'mike_email@mike.com', 'personal'),
(47, 95, 'mike_empleado@mike.com', 'personal'),
(48, 98, 'mike_email@mike.com', 'personal'),
(49, 99, 'mike_empleado@mike.com', 'personal'),
(50, 102, 'mike_email@mike.com', 'personal'),
(51, 103, 'mike_empleado@mike.com', 'personal'),
(52, 106, 'mike_email@mike.com', 'personal'),
(53, 107, 'mike_empleado@mike.com', 'personal'),
(54, 110, 'mike_email@mike.com', 'personal'),
(55, 111, 'mike_empleado@mike.com', 'personal'),
(56, 114, 'mike_email@mike.com', 'personal'),
(57, 115, 'mike_empleado@mike.com', 'personal'),
(58, 118, 'mike_email@mike.com', 'personal'),
(59, 119, 'mike_empleado@mike.com', 'personal'),
(60, 122, 'mike_email@mike.com', 'personal'),
(61, 123, 'mike_empleado@mike.com', 'personal'),
(62, 126, 'mike_email@mike.com', 'personal'),
(63, 127, 'mike_empleado@mike.com', 'personal'),
(64, 130, 'mike_email@mike.com', 'personal'),
(65, 131, 'mike_empleado@mike.com', 'personal'),
(66, 134, 'mike_email@mike.com', 'personal'),
(67, 135, 'mike_empleado@mike.com', 'personal'),
(68, 138, 'mike_email@mike.com', 'personal'),
(69, 139, 'mike_empleado@mike.com', 'personal'),
(70, 142, 'mike_email@mike.com', 'personal'),
(71, 143, 'mike_empleado@mike.com', 'personal'),
(72, 146, 'mike_email@mike.com', 'personal'),
(73, 147, 'mike_empleado@mike.com', 'personal'),
(74, 150, 'mike_email@mike.com', 'personal'),
(75, 151, 'mike_empleado@mike.com', 'personal'),
(76, 154, 'mike_email@mike.com', 'personal'),
(77, 155, 'mike_empleado@mike.com', 'personal');

-- --------------------------------------------------------

--
-- Table structure for table `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `id_empleado` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `salario` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `nombre`, `salario`) VALUES
(11, 'Mike', 1000),
(12, 'Mike Email', 1000),
(13, 'Mike', 1000),
(14, 'Mike Email', 1000),
(15, 'Mike Empleado', 1000),
(16, 'Mike', 1000),
(17, 'Mike', 1000),
(18, 'Mike Email', 1000),
(19, 'Mike Empleado', 1000),
(20, 'Mike', 1000),
(21, 'Mike', 1000),
(22, 'Mike Email', 1000),
(23, 'Mike Empleado', 1000),
(24, 'Mike', 1000),
(25, 'Mike', 1000),
(26, 'Mike Email', 1000),
(27, 'Mike Empleado', 1000),
(28, 'Mike', 1000),
(29, 'Mike', 1000),
(30, 'Mike Email', 1000),
(31, 'Mike Empleado', 1000),
(32, 'Mike', 1000),
(33, 'Mike', 1000),
(34, 'Mike Email', 1000),
(35, 'Mike Empleado', 1000),
(36, 'Mike', 1000),
(37, 'Mike', 1000),
(38, 'Mike Email', 1000),
(39, 'Mike Empleado', 1000),
(40, 'Mike', 1000),
(41, 'Mike', 1000),
(42, 'Mike Email', 1000),
(43, 'Mike Empleado', 1000),
(44, 'Mike', 1000),
(45, 'Mike', 1000),
(46, 'Mike Email', 1000),
(47, 'Mike Empleado', 1000),
(48, 'Mike', 1000),
(49, 'Mike', 1000),
(50, 'Mike Email', 1000),
(51, 'Mike Empleado', 1000),
(52, 'Mike', 1000),
(53, 'Mike', 1000),
(54, 'Mike Email', 1000),
(55, 'Mike Empleado', 1000),
(56, 'Mike', 1000),
(57, 'Mike', 1000),
(58, 'Mike Email', 1000),
(59, 'Mike Empleado', 1000),
(60, 'Mike', 1000),
(61, 'Mike', 1000),
(62, 'Mike Email', 1000),
(63, 'Mike Empleado', 1000),
(64, 'Mike', 1000),
(65, 'Mike', 1000),
(66, 'Mike Email', 1000),
(67, 'Mike Empleado', 1000),
(68, 'Mike', 1000),
(69, 'Mike', 1000),
(70, 'Mike Email', 1000),
(71, 'Mike Empleado', 1000),
(72, 'Mike', 1000),
(73, 'Mike', 1000),
(74, 'Mike Email', 1000),
(75, 'Mike Empleado', 1000),
(76, 'Mike', 1000),
(77, 'Mike', 1000),
(78, 'Mike Email', 1000),
(79, 'Mike Empleado', 1000),
(80, 'Mike', 1000),
(81, 'Mike', 1000),
(82, 'Mike Email', 1000),
(83, 'Mike Empleado', 1000),
(84, 'Mike', 1000),
(85, 'Mike', 1000),
(86, 'Mike Email', 1000),
(87, 'Mike Empleado', 1000),
(88, 'Mike', 1000),
(89, 'Mike', 1000),
(90, 'Mike Email', 1000),
(91, 'Mike Empleado', 1000),
(92, 'Mike', 1000),
(93, 'Mike', 1000),
(94, 'Mike Email', 1000),
(95, 'Mike Empleado', 1000),
(96, 'Mike', 1000),
(97, 'Mike', 1000),
(98, 'Mike Email', 1000),
(99, 'Mike Empleado', 1000),
(100, 'Mike', 1000),
(101, 'Mike', 1000),
(102, 'Mike Email', 1000),
(103, 'Mike Empleado', 1000),
(104, 'Mike', 1000),
(105, 'Mike', 1000),
(106, 'Mike Email', 1000),
(107, 'Mike Empleado', 1000),
(108, 'Mike', 1000),
(109, 'Mike', 1000),
(110, 'Mike Email', 1000),
(111, 'Mike Empleado', 1000),
(112, 'Mike', 1000),
(113, 'Mike', 1000),
(114, 'Mike Email', 1000),
(115, 'Mike Empleado', 1000),
(116, 'Mike', 1000),
(117, 'Mike', 1000),
(118, 'Mike Email', 1000),
(119, 'Mike Empleado', 1000),
(120, 'Mike', 1000),
(121, 'Mike', 1000),
(122, 'Mike Email', 1000),
(123, 'Mike Empleado', 1000),
(124, 'Mike', 1000),
(125, 'Mike', 1000),
(126, 'Mike Email', 1000),
(127, 'Mike Empleado', 1000),
(128, 'Mike', 1000),
(129, 'Mike', 1000),
(130, 'Mike Email', 1000),
(131, 'Mike Empleado', 1000),
(132, 'Mike', 1000),
(133, 'Mike', 1000),
(134, 'Mike Email', 1000),
(135, 'Mike Empleado', 1000),
(136, 'Mike', 1000),
(137, 'Mike', 1000),
(138, 'Mike Email', 1000),
(139, 'Mike Empleado', 1000),
(140, 'Mike', 1000),
(141, 'Mike', 1000),
(142, 'Mike Email', 1000),
(143, 'Mike Empleado', 1000),
(144, 'Mike', 1000),
(145, 'Mike', 1000),
(146, 'Mike Email', 1000),
(147, 'Mike Empleado', 1000),
(148, 'Mike', 1000),
(149, 'Mike', 1000),
(150, 'Mike Email', 1000),
(151, 'Mike Empleado', 1000),
(152, 'Mike', 1000),
(153, 'Mike', 1000),
(154, 'Mike Email', 1000),
(155, 'Mike Empleado', 1000),
(156, 'Mike', 1000);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `course` text NOT NULL,
  `rating` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `course`, `rating`) VALUES
(1, 'Mike', 'Progamación III', 'A+'),
(3, 'Juan', 'Progra III', 'B+'),
(5, 'juan', 'progra III', 'A -'),
(11, 'Sebastian', 'progra III', 'A+');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `email`
--
ALTER TABLE `email`
  ADD PRIMARY KEY (`id_email`);

--
-- Indexes for table `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `email`
--
ALTER TABLE `email`
  MODIFY `id_email` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=78;
--
-- AUTO_INCREMENT for table `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=157;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
