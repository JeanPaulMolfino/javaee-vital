-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 12, 2020 at 09:06 AM
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
  `idpaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pacientes`
--

CREATE TABLE `pacientes` (
  `ci` varchar(8) NOT NULL,
  `nombre` int(11) NOT NULL,
  `apellido` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `vemecs`
--

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
(1, 'Motorola', 'Alguna', 'pabellon 6', NULL),
(2, 'Motorola', 'Ninguna', 'pabellon 4', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `historiales`
--
ALTER TABLE `historiales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `historial_ibfk_1` (`idpaciente`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vemecs`
--
ALTER TABLE `vemecs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `historiales`
--
ALTER TABLE `historiales`
  ADD CONSTRAINT `historiales_ibfk_1` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`id`);

--
-- Constraints for table `vemecs`
--
ALTER TABLE `vemecs`
  ADD CONSTRAINT `vemecs_ibfk_2` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
