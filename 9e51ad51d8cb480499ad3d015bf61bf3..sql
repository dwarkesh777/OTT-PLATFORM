-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 23, 2025 at 07:54 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ott`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` bigint(100) NOT NULL,
  `admin_name` varchar(10) DEFAULT NULL,
  `admin_email` varchar(20) DEFAULT NULL,
  `admin_password` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_name`, `admin_email`, `admin_password`) VALUES
(7854123252, 'sds', 'Admin@gmail.com', 'Admin@123'),
(7854785412, 'sd', 'd@gmail.com', 'Admin@123'),
(7859988312, 'l', 'E@gmail.com', 'Dwarkesh@123'),
(8484848686, 'fds', 'f@gmail.com', 'Admin@123'),
(8484868684, 'jh', 's@gmail.com', 'Admin@123'),
(8849403877, 'sds', 'd@gmail.com', 'Admin@123');

-- --------------------------------------------------------

--
-- Table structure for table `episode`
--

CREATE TABLE `episode` (
  `episodeID` int(10) NOT NULL,
  `seriesID` int(10) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `episodeNO` int(10) DEFAULT NULL,
  `video_path` longtext DEFAULT NULL,
  `duration` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `his_ID` int(10) NOT NULL,
  `time` varchar(30) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`his_ID`, `time`, `user_id`, `date`) VALUES
(1, '121', 7859988312, '2025-07-23'),
(2, '23:10:58', 7859988312, '2025-07-23');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `loginID` int(10) NOT NULL,
  `userID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `movie_id` int(10) NOT NULL,
  `movie_title` varchar(20) DEFAULT NULL,
  `movie_language` varchar(10) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `video_path` varchar(30) DEFAULT NULL,
  `duration` varchar(10) DEFAULT NULL,
  `like` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movie_id`, `movie_title`, `movie_language`, `category`, `video_path`, `duration`, `like`) VALUES
(1, 'Jawan', 'Hindi', 'Action', 'C:/Movies/jawan.mp4', '2h45m', 0),
(2, 'RRR', 'Telugu', 'Drama', 'C:/Movies/rrr.mp4', '3h07m', 0),
(3, 'KGF', 'Kannada', 'Action', 'C:/Movies/kgf.mp4', '2h35m', 0),
(4, 'Pathaan', 'Hindi', 'Spy', 'C:/Movies/pathaan.mp4', '2h40m', 0),
(5, 'Dangal', 'Hindi', 'Biopic', 'C:/Movies/dangal.mp4', '2h49m', 0),
(6, 'Bahubali', 'Telugu', 'Epic', 'C:/Movies/bahubali.mp4', '2h58m', 0),
(7, 'Pushpa', 'Telugu', 'Action', 'C:/Movies/pushpa.mp4', '2h59m', 0),
(8, 'Drishyam', 'Malayalam', 'Thriller', 'C:/Movies/drishyam.mp4', '2h45m', 0),
(9, 'Vikram', 'Tamil', 'Action', 'C:/Movies/vikram.mp4', '2h47m', 0),
(10, 'Master', 'Tamil', 'Drama', 'C:/Movies/master.mp4', '2h43m', 0),
(11, '3 Idiots', 'Hindi', 'Comedy', 'C:/Movies/3idiots.mp4', '2h51m', 0),
(12, 'Shershaah', 'Hindi', 'War', 'C:/Movies/shershaah.mp4', '2h18m', 0),
(13, 'Article 15', 'Hindi', 'Crime', 'C:/Movies/article15.mp4', '2h10m', 0),
(14, 'Kantara', 'Kannada', 'Mystery', 'C:/Movies/kantara.mp4', '2h27m', 0),
(15, 'Gully Boy', 'Hindi', 'Musical', 'C:/Movies/gullyboy.mp4', '2h34m', 0),
(16, 'Lagaan', 'Hindi', 'Historical', 'C:/Movies/lagaan.mp4', '3h44m', 0),
(17, 'Sita Ramam', 'Telugu', 'Romance', 'C:/Movies/sitaramam.mp4', '2h30m', 0),
(18, 'Dil Bechara', 'Hindi', 'Romance', 'C:/Movies/dilbechara.mp4', '1h41m', 0),
(19, 'URI', 'Hindi', 'War', 'C:/Movies/uri.mp4', '2h18m', 0),
(20, 'Raazi', 'Hindi', 'Spy', 'C:/Movies/raazi.mp4', '2h20m', 0),
(21, 'Chhichhore', 'Hindi', 'Drama', 'C:/Movies/chhichhore.mp4', '2h23m', 0),
(22, 'The Kashmir Files', 'Hindi', 'Drama', 'C:/Movies/kashmirfiles.mp4', '2h50m', 0),
(23, 'Rocketry', 'Hindi', 'Biopic', 'C:/Movies/rocketry.mp4', '2h38m', 0),
(24, 'Super 30', 'Hindi', 'Biography', 'C:/Movies/super30.mp4', '2h34m', 0),
(25, 'Andhadhun', 'Hindi', 'Thriller', 'C:/Movies/andhadhun.mp4', '2h19m', 0);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `reviewID` int(10) NOT NULL,
  `userID` int(10) DEFAULT NULL,
  `content` varchar(30) DEFAULT NULL,
  `rating` int(10) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `series`
--

CREATE TABLE `series` (
  `id` int(11) NOT NULL,
  `title` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `subscription_plan`
--

CREATE TABLE `subscription_plan` (
  `Subscription_id` int(11) NOT NULL,
  `type` varchar(30) DEFAULT NULL,
  `Start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `middle_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `mobile_no` bigint(20) DEFAULT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `first_name`, `middle_name`, `last_name`, `email`, `password`, `mobile_no`, `age`) VALUES
(7859988312, 'savaliya', 'dwarkesh', 'sanjaybhai', 'g@gmail.com', 'Dwarkesh@123', 7859988312, 18);

-- --------------------------------------------------------

--
-- Table structure for table `user1`
--

CREATE TABLE `user1` (
  `user_id` bigint(20) NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `middle_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `mobile_no` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user1`
--

INSERT INTO `user1` (`user_id`, `first_name`, `middle_name`, `last_name`, `email`, `password`, `mobile_no`) VALUES
(8486515320, 's', 'd', 'd', 'd@gmail.com', 'User@123', 8486515320);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `episode`
--
ALTER TABLE `episode`
  ADD PRIMARY KEY (`episodeID`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`his_ID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`loginID`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movie_id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`reviewID`);

--
-- Indexes for table `series`
--
ALTER TABLE `series`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subscription_plan`
--
ALTER TABLE `subscription_plan`
  ADD PRIMARY KEY (`Subscription_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user1`
--
ALTER TABLE `user1`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` bigint(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8849403878;

--
-- AUTO_INCREMENT for table `episode`
--
ALTER TABLE `episode`
  MODIFY `episodeID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `his_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `loginID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `movie_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `reviewID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `series`
--
ALTER TABLE `series`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subscription_plan`
--
ALTER TABLE `subscription_plan`
  MODIFY `Subscription_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7859988313;

--
-- AUTO_INCREMENT for table `user1`
--
ALTER TABLE `user1`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8486515321;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
