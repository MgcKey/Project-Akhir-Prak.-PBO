-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2022 at 09:09 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbapotek`
--

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `id_obat` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `bentuk` varchar(10) NOT NULL,
  `aturan_konsumsi` varchar(40) NOT NULL,
  `stok` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`id_obat`, `nama`, `bentuk`, `aturan_konsumsi`, `stok`, `harga`) VALUES
(3, 'Sanmol', 'Tablet', '1x1', 90, 5000),
(4, 'Oskadon', 'Kaplet', '1x1', 43, 3000);

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id_pesanan` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_obat` int(11) NOT NULL,
  `nama_pemesan` varchar(30) NOT NULL,
  `nama_obat` varchar(30) NOT NULL,
  `jumlah_obat` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL,
  `status_bayar` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pemesanan`
--

INSERT INTO `pemesanan` (`id_pesanan`, `id_user`, `id_obat`, `nama_pemesan`, `nama_obat`, `jumlah_obat`, `total_harga`, `status_bayar`) VALUES
(1, 2, 1, 'Rafli Irfansyah', 'Paramex', 5, 5000, 'Completed'),
(2, 2, 1, 'Rafli Irfansyah', 'Paramex', 1, 1000, 'Completed'),
(3, 2, 3, 'Rafli Irfansyah', 'Sanmol', 50, 125000, 'Completed'),
(4, 3, 4, 'Jayadi', 'Oskadon', 5, 15000, 'Completed'),
(5, 3, 4, 'Jayadi', 'Oskadon', 2, 6000, 'Completed');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status_role` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `nama`, `jenis_kelamin`, `email`, `username`, `password`, `status_role`) VALUES
(1, 'admin', 'Laki-laki', 'admin123@gmail.com', 'admin', 'admin123', 'admin'),
(2, 'Rafli Irfansyah', 'Laki-laki', 'rafli123@gmail.com', 'rafli', 'rafli123', 'pengunjung'),
(3, 'Jayadi', 'Laki-laki', 'jaya@gmail.com', 'jaya', 'jaya', 'pengunjung');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`id_obat`);

--
-- Indexes for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`id_pesanan`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `obat`
--
ALTER TABLE `obat`
  MODIFY `id_obat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pemesanan`
--
ALTER TABLE `pemesanan`
  MODIFY `id_pesanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
