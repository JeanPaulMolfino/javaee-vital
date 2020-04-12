-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 09-04-2020 a las 08:29:05
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

CREATE TABLE `historial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestap` int(11) NOT NULL,
  `presionmaxima` int(11) NOT NULL,
  `presionminima` int(11) NOT NULL,
  `volgasaporta` int(11) NOT NULL,
  `frecaporte` int(11) NOT NULL,
  `compomezcla` int(11) NOT NULL,
  `humedadaire` int(11) NOT NULL,
  `tempentrada` int(11) NOT NULL,
  `tempsalida` int(11) NOT NULL,
  `presentrada` int(11) NOT NULL,
  `pressalida` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `ci` int(11) NOT NULL,
  `nombre` int(11) NOT NULL,
  `apellido` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `VeMeC`
--

CREATE TABLE `vemec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `ubicacion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`ci`),
  ADD KEY `id` (`id`);

--
-- Indices de la tabla `VeMeC`
--
ALTER TABLE `vemec`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`id`) REFERENCES `vemec` (`id`);

--
-- Filtros para la tabla `VeMeC`
--
ALTER TABLE `vemec`
  ADD CONSTRAINT `vemec_ibfk_1` FOREIGN KEY (`id`) REFERENCES `paciente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
