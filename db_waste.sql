-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 01, 2024 at 03:35 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_waste`
--

-- --------------------------------------------------------

--
-- Table structure for table `kurir`
--

CREATE TABLE `kurir` (
  `id_kurir` int NOT NULL,
  `nama_kurir` varchar(100) DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL,
  `lokasi` varchar(100) DEFAULT NULL,
  `poin` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kurir`
--

INSERT INTO `kurir` (`id_kurir`, `nama_kurir`, `no_telp`, `lokasi`, `poin`) VALUES
(1, 'Solehuddin', '102', 'Tamansari', 1000),
(2, 'Iman', '104', 'Dago', 100),
(3, 'Asep', '08234567890', 'Setiabudi', 200),
(4, 'Rahmat', '08345678901', 'Lengkong', 300),
(5, 'Putra', '08456789012', 'Ledeng', 400),
(6, 'Dimas', '08567890123', 'Kopo', 500),
(7, 'Firman', '08678901234', 'Cihampelas', 600),
(8, 'Taufik', '08789012345', 'Dipatiukur', 700),
(9, 'Kiki', '08890123456', 'Braga', 800),
(10, 'Budi', '08901234567', 'Ciumbuleuit', 900);

-- --------------------------------------------------------

--
-- Table structure for table `masyarakat`
--

CREATE TABLE `masyarakat` (
  `id_masyarakat` int NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `poin_masyarakat` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `masyarakat`
--

INSERT INTO `masyarakat` (`id_masyarakat`, `nama`, `no_telp`, `alamat`, `poin_masyarakat`) VALUES
(1, 'Jojo Sajojo', '09012345678', 'Jl.Ciumbeleuit No.90,Bandung', 1000),
(2, 'Fitri Lia', '08456789012', 'Jl.Gegerkalong Tengah IV,Bandung', 400),
(3, 'Eka Syahputra', '08567890123', 'Jl.Dago No.20,Bandung', 500),
(4, 'Dani Kurnia', '08678901234', 'Jl.Lengkong No.30,Bandung', 600),
(5, 'Liana Lili', '08789012345', 'Jl.Tamansari No.45,Bandung', 300),
(6, 'Hani Hanifa', '08890123456', 'Jl.Dipatiukur No.50,Bandung', 700),
(7, 'Indra Putra', '08901234567', 'Jl.Ledeng No.20,Bandung', 200);

-- --------------------------------------------------------

--
-- Table structure for table `penjemputan`
--

CREATE TABLE `penjemputan` (
  `id_penjemputan` int NOT NULL,
  `id_masyarakat` int DEFAULT NULL,
  `id_sampah` int DEFAULT NULL,
  `id_kurir` int DEFAULT NULL,
  `tanggal_penjemputan` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `estimasi_waktu` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `penjemputan`
--

INSERT INTO `penjemputan` (`id_penjemputan`, `id_masyarakat`, `id_sampah`, `id_kurir`, `tanggal_penjemputan`, `status`, `estimasi_waktu`) VALUES
(1, 2, 2, 3, '2023-12-19', 'Diproses', '00:10:00'),
(2, 3, 4, 2, '2023-12-14', 'Telah diterima', '00:10:00'),
(3, 1, 5, 7, '2023-12-15', 'Selesai', '00:10:00'),
(4, 4, 3, 1, '2023-12-04', 'Ditolak', '00:10:00');

-- --------------------------------------------------------

--
-- Table structure for table `riwayat`
--

CREATE TABLE `riwayat` (
  `id_riwayat` int NOT NULL,
  `id_penjemputan` int DEFAULT NULL,
  `id_masyarakat` int DEFAULT NULL,
  `id_sampah` int DEFAULT NULL,
  `id_kurir` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `riwayat`
--

INSERT INTO `riwayat` (`id_riwayat`, `id_penjemputan`, `id_masyarakat`, `id_sampah`, `id_kurir`) VALUES
(1, 1, 2, 1, 3),
(2, 2, 3, 4, 2),
(3, 3, 1, 5, 7),
(4, 4, 4, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sampah`
--

CREATE TABLE `sampah` (
  `id_sampah` int NOT NULL,
  `nama_sampah` varchar(100) DEFAULT NULL,
  `jenis_sampah` varchar(100) DEFAULT NULL,
  `total_sampah` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sampah`
--

INSERT INTO `sampah` (`id_sampah`, `nama_sampah`, `jenis_sampah`, `total_sampah`) VALUES
(1, 'Komputer', 'Elektronik', 2),
(2, 'Laptop', 'Elektronik', 1),
(3, 'Handphone', 'Elektronik', 2),
(4, 'Printer', 'Elektronik', 1),
(5, 'CPU', 'Elektronik', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kurir`
--
ALTER TABLE `kurir`
  ADD PRIMARY KEY (`id_kurir`);

--
-- Indexes for table `masyarakat`
--
ALTER TABLE `masyarakat`
  ADD PRIMARY KEY (`id_masyarakat`);

--
-- Indexes for table `penjemputan`
--
ALTER TABLE `penjemputan`
  ADD PRIMARY KEY (`id_penjemputan`),
  ADD KEY `id_masyarakat` (`id_masyarakat`),
  ADD KEY `id_sampah` (`id_sampah`),
  ADD KEY `id_kurir` (`id_kurir`);

--
-- Indexes for table `riwayat`
--
ALTER TABLE `riwayat`
  ADD PRIMARY KEY (`id_riwayat`),
  ADD KEY `id_penjemputan` (`id_penjemputan`),
  ADD KEY `id_masyarakat` (`id_masyarakat`),
  ADD KEY `id_sampah` (`id_sampah`),
  ADD KEY `id_kurir` (`id_kurir`);

--
-- Indexes for table `sampah`
--
ALTER TABLE `sampah`
  ADD PRIMARY KEY (`id_sampah`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kurir`
--
ALTER TABLE `kurir`
  MODIFY `id_kurir` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `masyarakat`
--
ALTER TABLE `masyarakat`
  MODIFY `id_masyarakat` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `penjemputan`
--
ALTER TABLE `penjemputan`
  MODIFY `id_penjemputan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `riwayat`
--
ALTER TABLE `riwayat`
  MODIFY `id_riwayat` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `sampah`
--
ALTER TABLE `sampah`
  MODIFY `id_sampah` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `penjemputan`
--
ALTER TABLE `penjemputan`
  ADD CONSTRAINT `penjemputan_ibfk_1` FOREIGN KEY (`id_masyarakat`) REFERENCES `masyarakat` (`id_masyarakat`),
  ADD CONSTRAINT `penjemputan_ibfk_2` FOREIGN KEY (`id_sampah`) REFERENCES `sampah` (`id_sampah`),
  ADD CONSTRAINT `penjemputan_ibfk_3` FOREIGN KEY (`id_kurir`) REFERENCES `kurir` (`id_kurir`);

--
-- Constraints for table `riwayat`
--
ALTER TABLE `riwayat`
  ADD CONSTRAINT `riwayat_ibfk_1` FOREIGN KEY (`id_penjemputan`) REFERENCES `penjemputan` (`id_penjemputan`),
  ADD CONSTRAINT `riwayat_ibfk_2` FOREIGN KEY (`id_masyarakat`) REFERENCES `masyarakat` (`id_masyarakat`),
  ADD CONSTRAINT `riwayat_ibfk_3` FOREIGN KEY (`id_sampah`) REFERENCES `sampah` (`id_sampah`),
  ADD CONSTRAINT `riwayat_ibfk_4` FOREIGN KEY (`id_kurir`) REFERENCES `kurir` (`id_kurir`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
