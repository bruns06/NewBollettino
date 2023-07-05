-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Lug 05, 2023 alle 12:55
-- Versione del server: 10.4.25-MariaDB
-- Versione PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bollettini_app`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `conti_abilitati`
--

CREATE TABLE `conti_abilitati` (
  `id` int(11) NOT NULL,
  `codice_conto` varchar(255) DEFAULT NULL,
  `nome_intestatario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `conti_abilitati`
--

INSERT INTO `conti_abilitati` (`id`, `codice_conto`, `nome_intestatario`) VALUES
(1, '382754', 'Telecom Italia'),
(2, '392012', 'Eni Italia'),
(3, '963782', 'Banca san Paolo '),
(4, '393012', 'Iren Italia'),
(5, '172202', 'SIAE '),
(6, '231299', 'ASL');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `conti_abilitati`
--
ALTER TABLE `conti_abilitati`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `conti_abilitati`
--
ALTER TABLE `conti_abilitati`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
