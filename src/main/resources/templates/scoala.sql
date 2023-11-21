-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: nov. 21, 2023 la 06:25 PM
-- Versiune server: 10.4.28-MariaDB
-- Versiune PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `scoala`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `grupe`
--

CREATE TABLE `grupe` (
  `id` int(11) NOT NULL,
  `NumeGrupa` varchar(255) NOT NULL,
  `nume_grupa` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `grupe`
--

INSERT INTO `grupe` (`id`, `NumeGrupa`, `nume_grupa`) VALUES
(1, 'A', NULL),
(2, 'Test1', NULL),
(3, 'C', NULL),
(4, 'D', NULL);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `medii`
--

CREATE TABLE `medii` (
  `CodStudent` int(11) DEFAULT NULL,
  `MedieSemestriala` double DEFAULT NULL,
  `OreAbsentateNemotivate` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `medii`
--

INSERT INTO `medii` (`CodStudent`, `MedieSemestriala`, `OreAbsentateNemotivate`) VALUES
(4, 9.5, 2);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `mediisemestriale`
--

CREATE TABLE `mediisemestriale` (
  `id` int(11) DEFAULT NULL,
  `MedieSemestriala` double DEFAULT NULL,
  `OreAbsentateNemotivate` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `mediisemestriale`
--

INSERT INTO `mediisemestriale` (`id`, `MedieSemestriala`, `OreAbsentateNemotivate`) VALUES
(1, 8.5, 2),
(3, 7.5, 3),
(4, 9.5, 2),
(5, 8, 1);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `note`
--

CREATE TABLE `note` (
  `id` int(11) NOT NULL,
  `idStudent` int(11) DEFAULT NULL,
  `notaSemestru` double DEFAULT NULL,
  `absenteNemotivate` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `note`
--

INSERT INTO `note` (`id`, `idStudent`, `notaSemestru`, `absenteNemotivate`) VALUES
(1, 2, 8.5, 2),
(2, 2, 4.55, 5),
(3, 3, 7.5, 3),
(4, 1, 9.5, 2),
(5, 3, 8, 1);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `studenti`
--

CREATE TABLE `studenti` (
  `id` int(11) NOT NULL,
  `Nume` varchar(255) NOT NULL,
  `Prenume` varchar(255) NOT NULL,
  `GrupaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `studenti`
--

INSERT INTO `studenti` (`id`, `Nume`, `Prenume`, `GrupaID`) VALUES
(1, 'Popescu', 'Ion', 1),
(2, 'Ionescu', 'Maria', 2),
(3, 'Georgescu', 'Andrei', 1),
(4, 'Mihai', 'Elena', 3),
(5, 'John', 'Doe', 1),
(7, 'Coretchi', 'Valeriu', 2),
(11, 'Teaca', 'Alex', 2);

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `studentsdeleted`
--

CREATE TABLE `studentsdeleted` (
  `id` int(11) NOT NULL,
  `nume` varchar(50) DEFAULT NULL,
  `prenume` varchar(50) DEFAULT NULL,
  `GrupaID` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Eliminarea datelor din tabel `studentsdeleted`
--

INSERT INTO `studentsdeleted` (`id`, `nume`, `prenume`, `GrupaID`) VALUES
(2, 'Ionescu', 'Maria', '2');

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `grupe`
--
ALTER TABLE `grupe`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`id`);

--
-- Indexuri pentru tabele `studenti`
--
ALTER TABLE `studenti`
  ADD PRIMARY KEY (`id`),
  ADD KEY `GrupaID` (`GrupaID`);

--
-- AUTO_INCREMENT pentru tabele eliminate
--

--
-- AUTO_INCREMENT pentru tabele `grupe`
--
ALTER TABLE `grupe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pentru tabele `note`
--
ALTER TABLE `note`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pentru tabele `studenti`
--
ALTER TABLE `studenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
