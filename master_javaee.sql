-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 20, 2020 at 08:53 AM
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
-- Database: `master_javaee`
--
CREATE DATABASE IF NOT EXISTS `master_javaee` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `master_javaee`;

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `iddepartamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
CREATE TABLE `departamentos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `codigo` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `departamentos`
--

INSERT INTO `departamentos` (`id`, `nombre`, `codigo`) VALUES
(1, 'Artigas', 'UY-AR'),
(2, 'Canelones', 'UY-CA'),
(3, 'Cerro Largo', 'UY-CL'),
(4, 'Colonia', 'UY-CO'),
(5, 'Durazno', 'UY-DU'),
(6, 'Flores', 'UY-FS'),
(7, 'Florida', 'UY-FD'),
(8, 'Lavalleja', 'UY-LA'),
(9, 'Maldonado', 'UY-MA'),
(10, 'Montevideo', 'UY-MO'),
(11, 'Paysandú', 'UY-PA'),
(12, 'Río Negro', 'UY-RN'),
(13, 'Rivera', 'UY-RV'),
(14, 'Rocha', 'UY-RO'),
(15, 'Salto', 'UY-SA'),
(16, 'San José', 'UY-SJ'),
(17, 'Soriano', 'UY-SO'),
(18, 'Tacuarembó', 'UY-TA'),
(19, 'Treinta y Tres', 'UY-TT');

-- --------------------------------------------------------

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
CREATE TABLE `direcciones` (
  `id` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `localidad` varchar(5) NOT NULL,
  `iddepartamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `niveles`
--

DROP TABLE IF EXISTS `niveles`;
CREATE TABLE `niveles` (
  `id` int(11) NOT NULL,
  `estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `niveles`
--

INSERT INTO `niveles` (`id`, `estado`) VALUES
(0, 'Bajo');

-- --------------------------------------------------------

--
-- Table structure for table `pacientedirecciones`
--

DROP TABLE IF EXISTS `pacientedirecciones`;
CREATE TABLE `pacientedirecciones` (
  `id` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `iddireccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `id` int(20) NOT NULL,
  `nacionalidad` varchar(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `idcategoria` int(11) DEFAULT NULL,
  `idpeligro` int(11) NOT NULL DEFAULT 0,
  `sexo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pacientes`
--

INSERT INTO `pacientes` (`ci`, `nombre`, `apellido`, `edad`, `id`, `nacionalidad`, `email`, `idcategoria`, `idpeligro`, `sexo`) VALUES
('46107694', 'Jean Paul', 'Molfino', '25', 1, 'uruguayo', '', NULL, 0, 0),
('47128976', 'Maximiliano', 'Nuñez', '24', 3, 'uruguayo', '', NULL, 0, 0),
('48659873', 'Manuel', 'Gomez', '33', 4, 'uruguayo', '', NULL, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `promedios`
--

DROP TABLE IF EXISTS `promedios`;
CREATE TABLE `promedios` (
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

-- --------------------------------------------------------

--
-- Table structure for table `referentes`
--

DROP TABLE IF EXISTS `referentes`;
CREATE TABLE `referentes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `filial` varchar(50) NOT NULL,
  `idpaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `telefonos`
--

DROP TABLE IF EXISTS `telefonos`;
CREATE TABLE `telefonos` (
  `id` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `numero` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `updatetime`
--

DROP TABLE IF EXISTS `updatetime`;
CREATE TABLE `updatetime` (
  `id` int(11) NOT NULL,
  `minutos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `updatetime`
--

INSERT INTO `updatetime` (`id`, `minutos`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `vemecs`
--

DROP TABLE IF EXISTS `vemecs`;
CREATE TABLE `vemecs` (
  `id` int(11) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `idpaciente` int(11) DEFAULT NULL,
  `alerta` tinyint(1) NOT NULL DEFAULT 0,
  `alertab` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vemecs`
--

INSERT INTO `vemecs` (`id`, `marca`, `modelo`, `idpaciente`, `alerta`, `alertab`) VALUES
(1, 'Motorola', 'T420', 1, 0, 0),
(3, 'Alcatel', 'X666', 3, 1, 0),
(4, 'Samsung', 'G119', 4, 1, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoriadepartamento` (`iddepartamento`);

--
-- Indexes for table `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `direcciones`
--
ALTER TABLE `direcciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `departamentodireccion` (`iddepartamento`);

--
-- Indexes for table `niveles`
--
ALTER TABLE `niveles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pacientedirecciones`
--
ALTER TABLE `pacientedirecciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pacientedireccionpaciente` (`idpaciente`),
  ADD KEY `pacientedirecciondireccion` (`iddireccion`);

--
-- Indexes for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ci` (`ci`),
  ADD KEY `categoriapaciente` (`idcategoria`),
  ADD KEY `pacientesnivel` (`idpeligro`);

--
-- Indexes for table `promedios`
--
ALTER TABLE `promedios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_vemec` (`idvemec`),
  ADD KEY `fk_paciente` (`idpaciente`);

--
-- Indexes for table `referentes`
--
ALTER TABLE `referentes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `referentepaciente` (`idpaciente`);

--
-- Indexes for table `telefonos`
--
ALTER TABLE `telefonos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `telefonopaciente` (`idpaciente`);

--
-- Indexes for table `updatetime`
--
ALTER TABLE `updatetime`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT for table `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `departamentos`
--
ALTER TABLE `departamentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `direcciones`
--
ALTER TABLE `direcciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `niveles`
--
ALTER TABLE `niveles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pacientedirecciones`
--
ALTER TABLE `pacientedirecciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `promedios`
--
ALTER TABLE `promedios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17813;

--
-- AUTO_INCREMENT for table `referentes`
--
ALTER TABLE `referentes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `telefonos`
--
ALTER TABLE `telefonos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `updatetime`
--
ALTER TABLE `updatetime`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `vemecs`
--
ALTER TABLE `vemecs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `categoria`
--
ALTER TABLE `categoria`
  ADD CONSTRAINT `categoriadepartamento` FOREIGN KEY (`iddepartamento`) REFERENCES `departamentos` (`id`);

--
-- Constraints for table `direcciones`
--
ALTER TABLE `direcciones`
  ADD CONSTRAINT `departamentodireccion` FOREIGN KEY (`iddepartamento`) REFERENCES `departamentos` (`id`);

--
-- Constraints for table `pacientedirecciones`
--
ALTER TABLE `pacientedirecciones`
  ADD CONSTRAINT `pacientedirecciondireccion` FOREIGN KEY (`iddireccion`) REFERENCES `direcciones` (`id`),
  ADD CONSTRAINT `pacientedireccionpaciente` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`id`);

--
-- Constraints for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD CONSTRAINT `categoriapaciente` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `pacientesnivel` FOREIGN KEY (`idpeligro`) REFERENCES `niveles` (`id`);

--
-- Constraints for table `promedios`
--
ALTER TABLE `promedios`
  ADD CONSTRAINT `fk_paciente` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_vemec` FOREIGN KEY (`idvemec`) REFERENCES `vemecs` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `referentes`
--
ALTER TABLE `referentes`
  ADD CONSTRAINT `referentepaciente` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`id`);

--
-- Constraints for table `telefonos`
--
ALTER TABLE `telefonos`
  ADD CONSTRAINT `telefonopaciente` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`id`);

--
-- Constraints for table `vemecs`
--
ALTER TABLE `vemecs`
  ADD CONSTRAINT `vemecs_ibfk_2` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
