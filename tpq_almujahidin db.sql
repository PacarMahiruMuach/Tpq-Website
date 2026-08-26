-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 24, 2024 at 05:49 PM
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
-- Database: `tpq_almujahidin`
--

-- --------------------------------------------------------

--
-- Table structure for table `pengajar`
--

CREATE TABLE `pengajar` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `wali_kelas` varchar(50) NOT NULL,
  `ttl` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengajar`
--

INSERT INTO `pengajar` (`id`, `nama`, `gender`, `wali_kelas`, `ttl`) VALUES
(3, 'Siti Fatimah', 'Perempuan', 'Sughro', 'Sukabumi, 9 April 1985');

-- --------------------------------------------------------

--
-- Table structure for table `santri`
--

CREATE TABLE `santri` (
  `id` int(11) NOT NULL,
  `nis` varchar(7) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `kelas` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `ttl` varchar(60) DEFAULT NULL,
  `wali` varchar(100) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  `UTS` varchar(400) DEFAULT NULL,
  `UAS` varchar(40) DEFAULT NULL,
  `Qiroah` varchar(400) DEFAULT NULL,
  `Hafalan` varchar(400) DEFAULT NULL,
  `Sikap` varchar(400) DEFAULT NULL,
  `Rata` varchar(400) DEFAULT NULL,
  `Predikat` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `santri`
--

INSERT INTO `santri` (`id`, `nis`, `nama`, `kelas`, `gender`, `ttl`, `wali`, `note`, `UTS`, `UAS`, `Qiroah`, `Hafalan`, `Sikap`, `Rata`, `Predikat`) VALUES
(68, '2024001', 'Muhammad Marzuki', 'Sughro', 'Laki-Laki', 'Jakarta, 7 Mei 2005', 'Siti Zubaedah', '-', '100', '90', '90', '80', '20', '76', 'B'),
(69, '2024002', 'Ryan', 'Sughro', 'Laki-Laki', 'Jakarta, 10 Mei 2005', 'Sutrisno', '-', '100', '80', '90', '70', '90', '86', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'anakuin', 'anakuin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pengajar`
--
ALTER TABLE `pengajar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `santri`
--
ALTER TABLE `santri`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nis` (`nis`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pengajar`
--
ALTER TABLE `pengajar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `santri`
--
ALTER TABLE `santri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
