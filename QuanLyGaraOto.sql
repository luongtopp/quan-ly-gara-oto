-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 14, 2024 at 10:37 AM
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
-- Table structure for table `BaoCao`
--

CREATE TABLE `BaoCao` (
  `MaBaoCao` int(11) NOT NULL,
  `NgayLapBaoCao` date DEFAULT NULL,
  `NoiDung` text DEFAULT NULL,
  `MaGiamDoc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `GiamDoc`
--

CREATE TABLE `GiamDoc` (
  `MaGiamDoc` int(11) NOT NULL,
  `TenGiamDoc` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `SoDienThoai` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `GiamDoc`
--

INSERT INTO `GiamDoc` (`MaGiamDoc`, `TenGiamDoc`, `Email`, `SoDienThoai`) VALUES
(1, 'Trần Văn Em', 'trane@example.com', '0912345679'),
(4, 'Trần Thanh Hoa', 'thanhoa121@gmail.com', '0912345679');

-- --------------------------------------------------------

--
-- Table structure for table `KeToan`
--

CREATE TABLE `KeToan` (
  `MaHoaDon` int(11) NOT NULL,
  `MaSuaChua` int(11) DEFAULT NULL,
  `NgayLapHoaDon` date DEFAULT NULL,
  `TongTien` decimal(10,2) DEFAULT NULL,
  `TrangThaiThanhToan` enum('Đã thanh toán','Chưa thanh toán') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `KeToan`
--

INSERT INTO `KeToan` (`MaHoaDon`, `MaSuaChua`, `NgayLapHoaDon`, `TongTien`, `TrangThaiThanhToan`) VALUES
(1, 1, '2024-05-31', '3000.00', 'Đã thanh toán'),
(4, 1, '2024-05-29', '1000000.00', 'Đã thanh toán');

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
(1, 'Nguyễn Văn D', 'Điện tử', '2023-02-20', '0976543210'),
(2, 'Phạm Thị E', 'Hệ thống phanh', '2023-03-20', '0909876543');

-- --------------------------------------------------------

--
-- Table structure for table `NguoiDung`
--

CREATE TABLE `NguoiDung` (
  `MaNguoiDung` int(11) NOT NULL,
  `TenDangNhap` varchar(255) DEFAULT NULL,
  `MatKhau` varchar(255) DEFAULT NULL,
  `VaiTro` enum('KeToan','NhanVien','QuanLy','KyThuatVien','Admin') DEFAULT NULL,
  `TenNguoiDung` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `SoDienThoai` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `NguoiDung`
--

INSERT INTO `NguoiDung` (`MaNguoiDung`, `TenDangNhap`, `MatKhau`, `VaiTro`, `TenNguoiDung`, `Email`, `SoDienThoai`) VALUES
(1, '1', '1', 'NhanVien', 'Nguyễn Văn A', 'nguyenvana@example.com', '0987654321'),
(2, '2', '2', 'QuanLy', 'Trần Thị B', 'tranthib@example.com', '0901234567'),
(3, '10', '1', 'KeToan', '1', '1', '1');

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
(1, 1, 'Thay nhớt, kiểm tra hệ thống phanh, ly hợp', '2024-05-28', 2, 3, 1, '4000.00'),
(2, 2, 'Kiểm tra hệ thống điện tử', '2024-05-27', 1, 2, 2, '200.00'),
(5, 1, '10', '2024-05-29', 1, 10, 1, '10.00');

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
(1, 'Lốp xe', 50, '150.00', 'Công ty Lốp Lớn', '2024-05-25', 'Nhập'),
(2, 'Dầu nhớt', 100, '30.00', 'Hãng Dầu Xanh', '2024-05-26', 'Nhập'),
(3, 'Ốc vít', 200, '5.00', 'Công ty Phụ Tùng Đa Dạng', '2024-05-26', 'Nhập'),
(5, 'Ốc vít', 200, '10.00', 'Công ty Phụ Tùng Đa Dạng', '2024-05-26', 'Nhập'),
(6, 'Ốc vít', 200, '10.00', 'Công ty Phụ Tùng Đa Dạng', '2024-05-26', 'Nhập');

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
(1, '29A-12345', 'Nguyễn Văn A', 'Toyota Camry', 2019, 'Đen'),
(2, '51G-67890', 'Trần Thị Bên', 'Honda CR-V', 2020, 'Bạc'),
(3, '36C-24680', 'Lê Văn Nam', 'Ford Ranger', 2018, 'Xanh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `BaoCao`
--
ALTER TABLE `BaoCao`
  ADD PRIMARY KEY (`MaBaoCao`),
  ADD KEY `MaGiamDoc` (`MaGiamDoc`);

--
-- Indexes for table `GiamDoc`
--
ALTER TABLE `GiamDoc`
  ADD PRIMARY KEY (`MaGiamDoc`);

--
-- Indexes for table `KeToan`
--
ALTER TABLE `KeToan`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `MaSuaChua` (`MaSuaChua`);

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
-- AUTO_INCREMENT for table `BaoCao`
--
ALTER TABLE `BaoCao`
  MODIFY `MaBaoCao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `GiamDoc`
--
ALTER TABLE `GiamDoc`
  MODIFY `MaGiamDoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `KeToan`
--
ALTER TABLE `KeToan`
  MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `KyThuatVien`
--
ALTER TABLE `KyThuatVien`
  MODIFY `MaKyThuatVien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `NguoiDung`
--
ALTER TABLE `NguoiDung`
  MODIFY `MaNguoiDung` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `SuaChua`
--
ALTER TABLE `SuaChua`
  MODIFY `MaSuaChua` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `VatTu`
--
ALTER TABLE `VatTu`
  MODIFY `MaVatTu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `Xe`
--
ALTER TABLE `Xe`
  MODIFY `MaXe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `BaoCao`
--
ALTER TABLE `BaoCao`
  ADD CONSTRAINT `baocao_ibfk_1` FOREIGN KEY (`MaGiamDoc`) REFERENCES `GiamDoc` (`MaGiamDoc`);

--
-- Constraints for table `KeToan`
--
ALTER TABLE `KeToan`
  ADD CONSTRAINT `ketoan_ibfk_1` FOREIGN KEY (`MaSuaChua`) REFERENCES `SuaChua` (`MaSuaChua`);

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
