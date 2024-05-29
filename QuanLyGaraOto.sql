-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 28, 2024 at 05:21 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QuanLyGaraOto`
--

-- --------------------------------------------------------

--
-- Table structure for table `KyThuatVien`
--

CREATE TABLE `KyThuatVien` (
  `MaKyThuatVien` int(11) NOT NULL,
  `TenKyThuatVien` varchar(255) DEFAULT NULL,
  `ChuyenMon` varchar(255) DEFAULT NULL,
  `NgayThue` date DEFAULT NULL,
  `SoDienThoai` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `KyThuatVien`
--

INSERT INTO `KyThuatVien` (`MaKyThuatVien`, `TenKyThuatVien`, `ChuyenMon`, `NgayThue`, `SoDienThoai`) VALUES
(1, 'Nguyễn Văn Tú', 'Động cơ', '2020-01-15', '0987654321'),
(2, 'Trần Thị Hương', 'Điện tử', '2019-05-20', '0123456789'),
(3, 'Phạm Đình Long', 'Hệ thống điều khiển', '2021-03-10', '0932468012'),
(4, 'Lê Thanh Hòa', 'Hệ thống phanh', '2018-11-05', '0975312468');

-- --------------------------------------------------------

--
-- Table structure for table `NguoiDung`
--

CREATE TABLE `NguoiDung` (
  `MaNguoiDung` int(11) NOT NULL,
  `TenDangNhap` varchar(255) DEFAULT NULL,
  `MatKhau` varchar(255) DEFAULT NULL,
  `VaiTro` enum('NhanVien','QuanLy','KyThuatVien') DEFAULT NULL,
  `TenNguoiDung` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `SoDienThoai` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `NguoiDung`
--

INSERT INTO `NguoiDung` (`MaNguoiDung`, `TenDangNhap`, `MatKhau`, `VaiTro`, `TenNguoiDung`, `Email`, `SoDienThoai`) VALUES
(1, 'quanly1', '123', 'QuanLy', 'Nguyễn Văn Quản', 'quanly1@example.com', '0987654321'),
(2, 'kythuatvien1', '123', 'KyThuatVien', 'Trần Thị Kỹ Thuật', 'kythuatvien1@example.com', '0123456789'),
(3, 'nhanvien1', 'password', 'NhanVien', 'Lê Văn Nhân Viên', 'nhanvien1@example.com', '0901234567'),
(4, 'sdf', 'sdf', 'KyThuatVien', 'sdf', 'sdf', 'sdf');

-- --------------------------------------------------------

--
-- Table structure for table `SuaChua`
--

CREATE TABLE `SuaChua` (
  `MaSuaChua` int(11) NOT NULL,
  `MaXe` int(11) DEFAULT NULL,
  `MoTaSuaChua` text DEFAULT NULL,
  `NgaySuaChua` date DEFAULT NULL,
  `MaVatTu` int(11) DEFAULT NULL,
  `SoLuongSuDung` int(11) DEFAULT NULL,
  `MaKyThuatVien` int(11) DEFAULT NULL,
  `ChiPhi` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `SuaChua`
--

INSERT INTO `SuaChua` (`MaSuaChua`, `MaXe`, `MoTaSuaChua`, `NgaySuaChua`, `MaVatTu`, `SoLuongSuDung`, `MaKyThuatVien`, `ChiPhi`) VALUES
(1, 1, 'Thay nhớt và kiểm tra hệ thống phanh', '2024-05-10', 2, 3, 4, '150.00'),
(2, 2, 'Thay bánh xe và kiểm tra hệ thống điện', '2024-05-12', 1, 4, 2, '300.00'),
(3, 3, 'Kiểm tra hệ thống điều khiển và sửa chữa', '2024-05-14', 3, 2, 3, '200.00'),
(4, 4, 'Thay đèn pha và kiểm tra hệ thống phanh', '2024-05-16', 4, 2, 1, '250.00');

-- --------------------------------------------------------

--
-- Table structure for table `VatTu`
--

CREATE TABLE `VatTu` (
  `MaVatTu` int(11) NOT NULL,
  `TenVatTu` varchar(255) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `DonGia` decimal(10,2) DEFAULT NULL,
  `NhaCungCap` varchar(255) DEFAULT NULL,
  `NgayNhap` date DEFAULT NULL,
  `TrangThai` enum('Nhập','Xuất') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `VatTu`
--

INSERT INTO `VatTu` (`MaVatTu`, `TenVatTu`, `SoLuong`, `DonGia`, `NhaCungCap`, `NgayNhap`, `TrangThai`) VALUES
(1, 'Bánh xe', 50, '100.00', 'Công ty A', '2024-05-01', 'Nhập'),
(2, 'Dầu nhớt', 100, '50.00', 'Công ty B', '2024-05-03', 'Nhập'),
(3, 'Bộ lọc gió', 30, '80.00', 'Công ty C', '2024-05-05', 'Nhập'),
(4, 'Đèn pha', 20, '120.00', 'Công ty D', '2024-05-07', 'Nhập'),
(5, 'qweeqe', 12, '1212.00', '1212', '2002-06-12', 'Nhập');

-- --------------------------------------------------------

--
-- Table structure for table `Xe`
--

CREATE TABLE `Xe` (
  `MaXe` int(11) NOT NULL,
  `BienSo` varchar(20) DEFAULT NULL,
  `ChuSoHuu` varchar(255) DEFAULT NULL,
  `Model` varchar(255) DEFAULT NULL,
  `NamSanXuat` int(11) DEFAULT NULL,
  `MauSac` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Xe`
--

INSERT INTO `Xe` (`MaXe`, `BienSo`, `ChuSoHuu`, `Model`, `NamSanXuat`, `MauSac`) VALUES
(1, '29A-12345', 'Nguyễn Văn A', 'Toyota Camry', 2018, 'Đen'),
(2, '51G-67890', 'Trần Thị B', 'Honda Civic', 2019, 'Trắng'),
(3, '36H-24680', 'Phạm Văn C', 'Hyundai Accent', 2017, 'Xám'),
(4, '92T-13579', 'Lê Thị D', 'Mazda 3', 2020, 'Đỏ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `KyThuatVien`
--
ALTER TABLE `KyThuatVien`
  ADD PRIMARY KEY (`MaKyThuatVien`);

--
-- Indexes for table `NguoiDung`
--
ALTER TABLE `NguoiDung`
  ADD PRIMARY KEY (`MaNguoiDung`),
  ADD UNIQUE KEY `TenDangNhap` (`TenDangNhap`);

--
-- Indexes for table `SuaChua`
--
ALTER TABLE `SuaChua`
  ADD PRIMARY KEY (`MaSuaChua`),
  ADD KEY `MaXe` (`MaXe`),
  ADD KEY `MaVatTu` (`MaVatTu`),
  ADD KEY `MaKyThuatVien` (`MaKyThuatVien`);

--
-- Indexes for table `VatTu`
--
ALTER TABLE `VatTu`
  ADD PRIMARY KEY (`MaVatTu`);

--
-- Indexes for table `Xe`
--
ALTER TABLE `Xe`
  ADD PRIMARY KEY (`MaXe`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `KyThuatVien`
--
ALTER TABLE `KyThuatVien`
  MODIFY `MaKyThuatVien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `NguoiDung`
--
ALTER TABLE `NguoiDung`
  MODIFY `MaNguoiDung` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `SuaChua`
--
ALTER TABLE `SuaChua`
  MODIFY `MaSuaChua` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `VatTu`
--
ALTER TABLE `VatTu`
  MODIFY `MaVatTu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `Xe`
--
ALTER TABLE `Xe`
  MODIFY `MaXe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `SuaChua`
--
ALTER TABLE `SuaChua`
  ADD CONSTRAINT `suachua_ibfk_1` FOREIGN KEY (`MaXe`) REFERENCES `Xe` (`MaXe`),
  ADD CONSTRAINT `suachua_ibfk_2` FOREIGN KEY (`MaVatTu`) REFERENCES `VatTu` (`MaVatTu`),
  ADD CONSTRAINT `suachua_ibfk_3` FOREIGN KEY (`MaKyThuatVien`) REFERENCES `KyThuatVien` (`MaKyThuatVien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
