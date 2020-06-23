-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 23, 2020 at 08:11 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaee`
--
CREATE DATABASE IF NOT EXISTS `javaee` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `javaee`;

-- --------------------------------------------------------

--
-- Table structure for table `historiales`
--

DROP TABLE IF EXISTS `historiales`;
CREATE TABLE `historiales` (
  `id` int(11) NOT NULL,
  `timestap` datetime NOT NULL,
  `presionmaxima` int(11) NOT NULL,
  `presionminima` int(11) NOT NULL,
  `volgasaporta` int(11) NOT NULL,
  `frecaporte` int(11) NOT NULL,
  `compomezcla` int(11) NOT NULL,
  `humedadaire` int(11) NOT NULL,
  `tempentrada` int(11) NOT NULL,
  `tempsalida` int(11) NOT NULL,
  `presentrada` int(11) NOT NULL,
  `pressalida` int(11) NOT NULL,
  `idvemec` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `historiales`
--

INSERT INTO `historiales` (`id`, `timestap`, `presionmaxima`, `presionminima`, `volgasaporta`, `frecaporte`, `compomezcla`, `humedadaire`, `tempentrada`, `tempsalida`, `presentrada`, `pressalida`, `idvemec`, `idpaciente`) VALUES
(178, '2020-06-23 03:09:39', 9, 4, 19, 17, 4, 38, 11, 14, 20, 22, 1, 1),
(179, '2020-06-23 03:09:41', 8, 6, 19, 15, 1, 37, 12, 13, 19, 20, 1, 1),
(180, '2020-06-23 03:09:43', 9, 3, 19, 15, 4, 38, 12, 11, 19, 18, 1, 1),
(181, '2020-06-23 03:09:45', 1, 1, 21, 15, 1, 36, 14, 11, 21, 19, 1, 1),
(182, '2020-06-23 03:09:48', 1, 1, 19, 16, 1, 34, 11, 11, 21, 21, 1, 1),
(183, '2020-06-23 03:09:50', 1, 1, 19, 13, 4, 38, 12, 10, 18, 18, 1, 1),
(184, '2020-06-23 03:09:52', 1, 1, 22, 15, 4, 36, 11, 10, 20, 20, 1, 1),
(185, '2020-06-23 03:09:54', 1, 1, 21, 13, 2, 36, 12, 14, 20, 22, 1, 1),
(186, '2020-06-23 03:09:56', 1, 1, 18, 16, 1, 36, 13, 10, 21, 21, 1, 1),
(187, '2020-06-23 03:09:58', 1, 1, 20, 17, 3, 35, 14, 10, 21, 18, 1, 1),
(188, '2020-06-23 03:10:00', 1, 1, 22, 16, 3, 35, 10, 14, 22, 19, 1, 1),
(189, '2020-06-23 03:10:02', 1, 1, 19, 17, 2, 38, 10, 14, 20, 21, 1, 1),
(190, '2020-06-23 03:10:04', 1, 1, 18, 13, 3, 36, 12, 13, 21, 18, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
CREATE TABLE `pacientes` (
  `ci` varchar(8) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `edad` varchar(3) NOT NULL,
  `id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pacientes`
--

INSERT INTO `pacientes` (`ci`, `nombre`, `apellido`, `edad`, `id`) VALUES
('46107694', 'Jean_Paul', 'Molfino', '25', 1),
('46107654', 'Jean Paul', 'Molfino', '25', 3);

-- --------------------------------------------------------

--
-- Table structure for table `vemecs`
--

DROP TABLE IF EXISTS `vemecs`;
CREATE TABLE `vemecs` (
  `id` int(11) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `idpaciente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vemecs`
--

INSERT INTO `vemecs` (`id`, `marca`, `modelo`, `ubicacion`, `idpaciente`) VALUES
(1, 'Motorola', 'Alguna', 'pabellon 6', 1),
(3, 'Alcatel', 'x21', 'pabellon 9', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `historiales`
--
ALTER TABLE `historiales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_vemec` (`idvemec`),
  ADD KEY `fk_paciente` (`idpaciente`);

--
-- Indexes for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ci` (`ci`);

--
-- Indexes for table `vemecs`
--
ALTER TABLE `vemecs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vemec_ibfk_2` (`idpaciente`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `historiales`
--
ALTER TABLE `historiales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=191;

--
-- AUTO_INCREMENT for table `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `vemecs`
--
ALTER TABLE `vemecs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `historiales`
--
ALTER TABLE `historiales`
  ADD CONSTRAINT `fk_paciente` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_vemec` FOREIGN KEY (`idvemec`) REFERENCES `vemecs` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `vemecs`
--
ALTER TABLE `vemecs`
  ADD CONSTRAINT `vemecs_ibfk_2` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
