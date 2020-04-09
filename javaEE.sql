-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 09-04-2020 a las 07:57:49
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `javaEE`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Historial`
--

CREATE TABLE `Historial` (
  `ID` int(11) NOT NULL,
  `TIMESTAMP` int(11) NOT NULL,
  `PRESIONMAXIMA` int(11) NOT NULL,
  `PRESIONMINIMA` int(11) NOT NULL,
  `VOLGASAPORTA` int(11) NOT NULL,
  `FRECAPORTE` int(11) NOT NULL,
  `COMPOMEZCLA` int(11) NOT NULL,
  `HUMEDADAIRE` int(11) NOT NULL,
  `TEMPENTRADA` int(11) NOT NULL,
  `TEMPSALIDA` int(11) NOT NULL,
  `PRESENTRADA` int(11) NOT NULL,
  `PRESSALIDA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `VeMeC`
--

CREATE TABLE `VeMeC` (
  `ID` int(11) NOT NULL,
  `MARCA` varchar(50) NOT NULL,
  `MODELO` varchar(50) NOT NULL,
  `SECTOR` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Historial`
--
ALTER TABLE `Historial`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `VeMeC`
--
ALTER TABLE `VeMeC`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
