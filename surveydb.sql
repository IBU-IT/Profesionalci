-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2016 at 02:26 AM
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
(12, 6, 'VENO OTAC', 0);

-- --------------------------------------------------------

--
-- Table structure for table `greske`
--

CREATE TABLE `greske` (
  `id` int(11) NOT NULL,
  `opis_greske` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

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
(6, 'Ko ima navecu kitu na faxu?', b'0');

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
(4, 'johnD', '123', 'John', 'Doe', 22, 1, 0),
(5, 'kiso', '123', 'Anes', 'Karic', 20, 1, 0),
(6, 'novi neki', 'asddsada', 'venan', 'osmic', 20, 1, 1),
(7, '', '', 'Sen', 'Seniii', 0, 0, 0),
(8, 'Imal', 'Greske', '', '', 20, 1, 1),
(9, 'a', 'a', 'sadbasj', 'kjsans', 10, 1, 0),
(10, 'Mala Mlohava Kita', '123', 'Atif', 'Kotoric', 18, 2, 0);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `greske`
--
ALTER TABLE `greske`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `submited_answers`
--
ALTER TABLE `submited_answers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
