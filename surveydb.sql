-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2016 at 12:04 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `surveydb`
--
CREATE DATABASE IF NOT EXISTS `surveydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `surveydb`;

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE `answers` (
  `id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `answer_count` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`id`, `question_id`, `answer`, `answer_count`) VALUES
(1, 3, 'Za mene', 0),
(2, 3, 'Za tebe', 0),
(3, 3, 'Za nas', 0),
(4, 4, 'ODGOVOR PRVI', 0),
(5, 4, 'ODGOVOR DRUGO', 0),
(6, 4, 'ODGOVOR TRECI', 0),
(7, 5, 'Adzo', 0),
(8, 5, 'iVeno', 0),
(9, 5, 'Napravii', 0),
(10, 6, 'Venan', 0),
(11, 6, 'V E N A N', 0),
(12, 6, 'VENO OTAC', 0),
(13, 7, 'Jen', 0),
(14, 7, 'Dva', 0),
(15, 7, 'Tri', 0),
(16, 8, 'Prvi Odgovor', 0),
(17, 8, 'Drugi Odgovor', 0),
(18, 8, 'Treci Odgovor', 0),
(19, 9, 'Prvi', 0),
(20, 9, 'Drugi', 0),
(21, 9, '', 0),
(22, 10, 'prvi', 0),
(23, 10, 'drugi', 0),
(24, 10, '', 0),
(25, 11, 'asd', 0),
(26, 11, '', 0),
(27, 11, '', 0),
(28, 12, 'asd', 0),
(29, 12, 'asd', 0),
(30, 12, '', 0),
(31, 13, 'asd', 0),
(32, 13, 'asd', 0),
(33, 13, '', 0),
(44, 24, 'klsamdaksl', 0),
(38, 18, 'RADI', 0),
(37, 18, 'ADMIN', 0),
(43, 23, 'DVA', 0),
(42, 23, 'JEN', 0),
(45, 24, 'alkmkasdm', 0),
(46, 24, 'aslkmdasmkl', 0),
(47, 25, 'DODAJ1', 0),
(48, 25, 'DODAJ2', 0),
(49, 25, 'DODAJ3', 0),
(50, 26, 'IMA', 1),
(51, 26, 'IMA', 1),
(52, 26, 'IMA', 1),
(53, 27, 'prvi', 0),
(54, 27, 'drugi', 0),
(55, 28, 'Atif', 10),
(56, 28, 'Venan', 0),
(57, 28, 'Osmo', 0),
(58, 29, 'Keks', 3),
(59, 29, 'Kola', 0),
(60, 29, 'Cigare', 0),
(61, 30, 'asmir', 1),
(62, 30, 'glup', 0),
(63, 30, 'kokurac', 0),
(64, 31, 'JEDAN ODGOVOR', 0),
(65, 31, 'DRUGI ODGOVOR', 0),
(66, 32, 'jen', 1),
(67, 32, 'dva', 1),
(68, 32, 'tri', 0),
(69, 33, 'Jedan ', 1),
(70, 33, 'Drugi', 0),
(71, 33, 'Treci', 0),
(72, 34, 'kura1', 0),
(73, 34, 'KURA2', 1),
(74, 34, 'kura3', 0);

-- --------------------------------------------------------

--
-- Table structure for table `greske`
--

CREATE TABLE `greske` (
  `id` int(11) NOT NULL,
  `opis_greske` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `greske`
--

INSERT INTO `greske` (`id`, `opis_greske`) VALUES
(1, 'Prijavi gresku'),
(2, 'aasd aasd aasd aasd aasd aasd aasd '),
(3, 'Problem u dodavanju anekte'),
(4, 'report an error aksdnsjaknddksajnssa');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int(11) NOT NULL,
  `question_text` varchar(255) NOT NULL,
  `is_closed` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `question_text`, `is_closed`) VALUES
(1, 'Za koga glasate?', b'0'),
(2, 'Za koga glasate?', b'0'),
(3, 'Za koga glasamo?', b'0'),
(4, 'Drugo pitanje?', b'0'),
(5, 'Evoga', b'0'),
(6, 'Ko ima navecu kitu na faxu?', b'0'),
(7, 'De jos jednu evo da me zelja mine.', b'0'),
(8, 'Anketa na kojoj testiram jel radi?', b'0'),
(9, 'Anketa na kojoj nema treceg odgovora', b'0'),
(10, 'NEMA TRI ODGOVORA', b'0'),
(11, 'Pitanje', b'0'),
(12, 'PROBNI', b'0'),
(13, 'OPET PROBA', b'0'),
(18, 'RADIL OVO ?', b'0'),
(23, 'TRI ODGOVORA', b'0'),
(24, 'NOVA ANKETA', b'0'),
(25, 'DODAJ TRI', b'0'),
(26, 'IMAL OVDJE TRI', b'0'),
(27, 'SAMO DVA IMAJU', b'0'),
(28, 'Dodaj za testiranje sa 3 odgovora.', b'0'),
(29, 'ZADNJA NEKA', b'0'),
(30, 'deki', b'0'),
(31, 'EVO jedna s dva odgovora', b'0'),
(32, 'EVO jedna s tri odgovora', b'0'),
(33, 'ZADNJA NOVA', b'0'),
(34, 'kurcina', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `submited_answers`
--

CREATE TABLE `submited_answers` (
  `id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `answer_id` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `submited_answers`
--

INSERT INTO `submited_answers` (`id`, `question_id`, `user_id`, `answer_id`) VALUES
(1, 26, 2, 50),
(2, 26, 2, 50),
(3, 28, 2, 55),
(4, 28, 2, 55),
(5, 28, 2, 55),
(6, 28, 2, 55),
(7, 28, 2, 55),
(8, 28, 2, 55),
(9, 28, 2, 55),
(10, 28, 2, 55),
(11, 28, 2, 55),
(12, 28, 2, 55),
(13, 28, 2, 55),
(14, 29, 2, 58),
(15, 29, 2, 58),
(16, 29, 2, 58),
(17, 30, 2, 61),
(18, 33, 2, 69),
(19, 32, 16, 66),
(20, 32, 17, 67),
(21, 34, 2, 73);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` int(11) NOT NULL,
  `user_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `first_name`, `last_name`, `age`, `gender`, `user_role`) VALUES
(1, 'admin', 'admin', 'Venan', 'Osmic', 20, 1, 1),
(2, 'user', 'user', 'Korisnik', 'Prezime', 25, 1, 2),
(3, 'adsasda', 'asdsad', 'asdsad', 'asdsadasd', 20, 1, 1),
(5, 'kiso', '123', 'Anes', 'Karic', 20, 1, 0),
(6, 'novi neki', 'asddsada', 'venan', 'osmic', 20, 1, 1),
(10, 'Mala Mlohava Kita', '123', 'Atif', 'Kotoric', 18, 2, 0),
(15, 'nista', 'niko', 'nema', 'nisza', 20, 1, 0),
(16, 'osmo', '123456', 'Osman', 'Hasanic', 20, 1, 0),
(17, 'asdd', '123', 'neko treci', 'nesto', 20, 1, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `greske`
--
ALTER TABLE `greske`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `submited_answers`
--
ALTER TABLE `submited_answers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answers`
--
ALTER TABLE `answers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;
--
-- AUTO_INCREMENT for table `greske`
--
ALTER TABLE `greske`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT for table `submited_answers`
--
ALTER TABLE `submited_answers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
