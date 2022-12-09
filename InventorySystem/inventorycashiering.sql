-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2022 at 10:21 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventorycashiering`
--

-- --------------------------------------------------------

--
-- Table structure for table `cashiertransaction`
--

CREATE TABLE `cashiertransaction` (
  `Date` varchar(100) NOT NULL,
  `Time` varchar(100) NOT NULL,
  `Details` varchar(1000) NOT NULL,
  `id` int(50) NOT NULL,
  `User` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cashiertransaction`
--

INSERT INTO `cashiertransaction` (`Date`, `Time`, `Details`, `id`, `User`) VALUES
('11-23,2022', '11:05:28 AM', 'has been sold :! -Product code: 1 Product name: kuan Quantity: 2 Price : 56.0', 15, 'Ron'),
('11-25,2022', '02:38:13 PM', 'has been sold :! -Product code: 3 Product name: erer Quantity: 5 Price : 345.0', 17, 'Sly');

-- --------------------------------------------------------

--
-- Table structure for table `insertedintocart`
--

CREATE TABLE `insertedintocart` (
  `id` int(11) NOT NULL,
  `Product_name` varchar(50) NOT NULL,
  `qty` double NOT NULL,
  `price` float NOT NULL,
  `total_product` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `insertedintocart`
--

INSERT INTO `insertedintocart` (`id`, `Product_name`, `qty`, `price`, `total_product`) VALUES
(1, 'kuan', 1, 56, 56),
(2, 'dasd', 2, 45, 90);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `id` varchar(50) NOT NULL,
  `Product_name` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `qty` varchar(50) NOT NULL,
  `Date` varchar(50) NOT NULL,
  `Stock_In_Out` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id`, `Product_name`, `Category`, `qty`, `Date`, `Stock_In_Out`) VALUES
('1', 'kuan', 'siomai', '45.0', '2022,11,23', 'Stock In'),
('3', 'erer', 'ere', '56.0', '2022,11,25', 'Stock In'),
('3', 'erer', 'ere', '34.0', '2022,11,25', 'Stock Out'),
('3', 'erer', 'ere', '6.0', '2022,11,25', 'Stock Out'),
('3', 'erer', 'ere', '5.0', '2022,11,25', 'Stock Out'),
('7', 'd', 't', '5.0', '2022,12,02', 'Stock In');

-- --------------------------------------------------------

--
-- Table structure for table `inv_products`
--

CREATE TABLE `inv_products` (
  `id` int(11) NOT NULL,
  `Product_name` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Portion` varchar(100) NOT NULL,
  `Serving` varchar(100) NOT NULL,
  `Price` varchar(10) NOT NULL,
  `qty` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inv_products`
--

INSERT INTO `inv_products` (`id`, `Product_name`, `Category`, `Portion`, `Serving`, `Price`, `qty`) VALUES
(1, 'kuan', 'siomai', '4', '4', '56.0', 19),
(2, 'dasd', 'asdas', '4', '4', '45.0', 28),
(3, 'erer', 'ere', '56', '45', '345.0', 23),
(4, 'refewffffffff', 'fffffffffffff', '12', '2', '123.0', 10),
(5, 'efe', 'sdf', '2', '23', '123.0', 20),
(6, 'q', 'qw', '2', '11', '231.0', 9),
(7, 'd', 't', '2', '12', '32.0', 6);

-- --------------------------------------------------------

--
-- Table structure for table `salesreport`
--

CREATE TABLE `salesreport` (
  `pcode` varchar(100) NOT NULL,
  `pname` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `qty` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `totalp` float(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salesreport`
--

INSERT INTO `salesreport` (`pcode`, `pname`, `date`, `time`, `qty`, `price`, `totalp`) VALUES
('1', 'kuan', '12-02,2022', '05:08:58 PM', '1', '56.0', 56),
('2', 'dasd', '12-02,2022', '05:08:58 PM', '2', '45.0', 90);

-- --------------------------------------------------------

--
-- Table structure for table `stafftransaction`
--

CREATE TABLE `stafftransaction` (
  `Date` varchar(100) NOT NULL,
  `Time` varchar(100) NOT NULL,
  `Details` varchar(1000) NOT NULL,
  `id` int(50) NOT NULL,
  `User` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stafftransaction`
--

INSERT INTO `stafftransaction` (`Date`, `Time`, `Details`, `id`, `User`) VALUES
('11-25,2022', '02:01:07 PM', 'has added new Product! -Pcode:  ProductName: d Category: t Portion: 2 Serving: 12 Price: 32 QTY: 2', 16, 'JD');

-- --------------------------------------------------------

--
-- Table structure for table `usertype_table`
--

CREATE TABLE `usertype_table` (
  `id` int(11) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `middlename` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `age` int(100) NOT NULL,
  `user` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `usertype` varchar(100) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertype_table`
--

INSERT INTO `usertype_table` (`id`, `firstname`, `middlename`, `lastname`, `address`, `age`, `user`, `pass`, `gender`, `usertype`, `status`) VALUES
(15, 'Aron', 'U', 'Balais', 'Cebu City', 22, 'Ron', '12345678', 'Male', 'Admin', 'Active'),
(16, 'John', 'D', 'Doe', 'Cebu City', 23, 'JD', '12345678', 'Male', 'Staff', 'Active'),
(17, 'Sly', 'J', 'Bataluna', 'Cebu City', 21, 'Sly', '12345678', 'Female', 'Cashier', 'Active'),
(18, 'Kevin', 'D', 'Campanilla', 'Bohol City', 21, 'KD', '12345678', 'Male', 'Cashier', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `viewlogs`
--

CREATE TABLE `viewlogs` (
  `Date` varchar(11) NOT NULL,
  `Time` varchar(100) NOT NULL,
  `Details` varchar(1000) NOT NULL,
  `User` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `viewlogs`
--

INSERT INTO `viewlogs` (`Date`, `Time`, `Details`, `User`) VALUES
('11-23,2022', '10:31:46 AM', 'has added new Product! - Product Name: kuan Category: siomai Portion: 4 Serving : 4 Price: 56 QTY: 5', ''),
('11-23,2022', '10:32:31 AM', 'Logout', ''),
('11-23,2022', '10:47:13 AM', 'Login', 'Ron'),
('11-23,2022', '10:47:51 AM', 'Sales : ID: 1 Product Name: kuan QTY: 3 Price: 56.0 Total Price: 168.0', 'Ron'),
('11-23,2022', '11:21:26 AM', 'has added new Product! - Product Name: dasd Category: asdas Portion: 4 Serving : 4 Price: 45 QTY: 45', 'Ron'),
('11-25,2022', '01:07:57 PM', 'Login', 'Ron'),
('11-25,2022', '01:08:35 PM', 'has added new Product! - Product Name: efe Category: sdf Portion: 2 Serving : 23 Price: 123 QTY: 21', 'Ron'),
('11-25,2022', '01:18:25 PM', 'Logout', 'Ron'),
('11-25,2022', '01:37:58 PM', 'Login', 'Ron'),
('11-25,2022', '01:44:57 PM', 'has added new Product! - Product Name: q Category: qw Portion: 2 Serving : 11 Price: 231 QTY: 12', 'Ron'),
('11-25,2022', '01:50:30 PM', 'Sales : ID: 1 Product Name: kuan QTY: 12 Price: 56.0 Total Price: 672.0', 'Ron'),
('11-25,2022', '01:58:02 PM', 'Stock Out:ID: 3 Product Name:ererQTY:6', 'Ron'),
('11-25,2022', '01:58:38 PM', 'Logout', 'Ron'),
('11-25,2022', '01:59:11 PM', 'Login', 'JD'),
('11-25,2022', '02:01:07 PM', 'has added new Product! - Product Name: d Category: t Portion: 2 Serving : 12 Price: 32 QTY: 2', 'JD'),
('11-25,2022', '02:01:59 PM', 'Stock Out:ID: 3 Product Name:ererQTY:5', 'JD'),
('11-25,2022', '02:19:47 PM', 'Logout', 'JD'),
('11-25,2022', '02:20:48 PM', 'Login', 'JD'),
('11-25,2022', '02:22:03 PM', 'Logout', 'JD'),
('11-25,2022', '02:22:16 PM', 'Login', 'Ron'),
('11-25,2022', '02:22:45 PM', 'Logout', 'Ron'),
('11-25,2022', '02:23:02 PM', 'Login', 'Sly'),
('11-25,2022', '02:37:56 PM', 'Sales : ID: 3 Product Name: erer QTY: 5 Price: 345.0 Total Price: 1725.0', 'Sly'),
('11-25,2022', '02:48:33 PM', 'Logout', 'Sly'),
('11-25,2022', '02:50:52 PM', 'Login', 'Sly'),
('11-25,2022', '02:51:47 PM', 'Registered In: Fn: Kevin Ln:CampanillaUserType:Cashier', 'Sly'),
('11-25,2022', '02:53:33 PM', 'Logout', 'Sly'),
('11-25,2022', '02:53:45 PM', 'Logout', 'Sly'),
('11-25,2022', '02:54:06 PM', 'Login', 'Ron'),
('11-25,2022', '03:05:27 PM', 'Logout', 'Ron'),
('11-25,2022', '03:05:59 PM', 'Login', 'Sly'),
('11-25,2022', '03:06:37 PM', 'Sales : ID: 2 Product Name: dasd QTY: 5 Price: 45.0 Total Price: 225.0', 'Sly'),
('11-25,2022', '03:10:12 PM', 'Logout', 'Sly'),
('11-25,2022', '03:11:20 PM', 'Login', 'Sly'),
('11-25,2022', '03:12:01 PM', 'Sales : ID: 6 Product Name: q QTY: 2 Price: 231.0 Total Price: 462.0', 'Sly'),
('11-25,2022', '03:18:07 PM', 'Logout', 'Sly'),
('11-25,2022', '03:19:26 PM', 'Login', 'Sly'),
('11-25,2022', '03:20:01 PM', 'Sales : ID: 1 Product Name: kuan QTY: 3 Price: 56.0 Total Price: 168.0', 'Sly'),
('11-25,2022', '03:25:49 PM', 'Logout', 'Sly'),
('11-25,2022', '03:25:50 PM', 'Logout', 'Sly'),
('11-25,2022', '03:25:58 PM', 'Logout', 'Sly'),
('11-25,2022', '03:26:26 PM', 'Login', 'Sly'),
('11-25,2022', '03:26:57 PM', 'Sales : ID: 5 Product Name: efe QTY: 1 Price: 123.0 Total Price: 123.0', 'Sly'),
('11-25,2022', '03:36:48 PM', 'Logout', 'Sly'),
('11-25,2022', '03:36:57 PM', 'Logout', 'Sly'),
('11-25,2022', '03:37:20 PM', 'Login', 'Sly'),
('11-25,2022', '03:37:44 PM', 'Sales : ID: 4 Product Name: refewffffffff QTY: 2 Price: 123.0 Total Price: 246.0', 'Sly'),
('11-25,2022', '03:37:58 PM', 'Logout', 'Sly'),
('11-25,2022', '03:40:32 PM', 'Login', 'Sly'),
('11-25,2022', '03:41:24 PM', 'Sales : ID: 1 Product Name: kuan QTY: 5 Price: 56.0 Total Price: 280.0', 'Sly'),
('12-01,2022', '02:33:39 PM', 'Login', 'Ron'),
('12-01,2022', '02:37:07 PM', 'Sales : ID: 3 Product Name: erer QTY: 12 Price: 345.0 Total Price: 4140.0', 'Ron'),
('12-02,2022', '12:38:28 PM', 'Login', 'Ron'),
('12-02,2022', '12:39:26 PM', 'Sales : ID: 2 Product Name: dasd QTY: 5 Price: 45.0 Total Price: 225.0', 'Ron'),
('12-02,2022', '03:52:41 PM', 'Logout', 'Ron'),
('12-02,2022', '03:54:29 PM', 'Login', 'Ron'),
('12-02,2022', '03:56:12 PM', 'Sales : ID: 2 Product Name: dasd QTY: 5 Price: 45.0 Total Price: 225.0', 'Ron'),
('12-02,2022', '03:56:53 PM', 'Logout', 'Ron'),
('12-02,2022', '04:20:11 PM', 'Sales : ID: 1 Product Name: kuan QTY: 5 Price: 56.0 Total Price: 280.0', ''),
('12-02,2022', '04:23:26 PM', 'Login', 'Ron'),
('12-02,2022', '04:24:39 PM', 'Sales : ID: 3 Product Name: erer QTY: 3 Price: 345.0 Total Price: 1035.0', 'Ron'),
('12-02,2022', '04:25:00 PM', 'Logout', 'Ron'),
('12-02,2022', '04:27:11 PM', 'Login', 'Ron'),
('12-02,2022', '04:59:48 PM', 'Login', 'Ron'),
('12-02,2022', '05:00:11 PM', 'Stock In : ID: 7 Product Name:dQTY:5', 'Ron'),
('12-02,2022', '05:01:15 PM', 'Sales : ID: 7 Product Name: d QTY: 1 Price: 32.0 Total Price: 32.0', 'Ron'),
('12-02,2022', '05:01:15 PM', 'Sales : ID: 6 Product Name: q QTY: 1 Price: 231.0 Total Price: 231.0', 'Ron'),
('12-02,2022', '05:01:15 PM', 'Sales : ID: 3 Product Name: erer QTY: 2 Price: 345.0 Total Price: 690.0', 'Ron'),
('12-02,2022', '05:01:28 PM', 'Logout', 'Ron'),
('12-02,2022', '05:08:26 PM', 'Login', 'Ron'),
('12-02,2022', '05:08:58 PM', 'Sales : ID: 1 Product Name: kuan QTY: 1 Price: 56.0 Total Price: 56.0', 'Ron'),
('12-02,2022', '05:08:58 PM', 'Sales : ID: 2 Product Name: dasd QTY: 2 Price: 45.0 Total Price: 90.0', 'Ron'),
('12-02,2022', '05:09:24 PM', 'Logout', 'Ron');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cashiertransaction`
--
ALTER TABLE `cashiertransaction`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `inv_products`
--
ALTER TABLE `inv_products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stafftransaction`
--
ALTER TABLE `stafftransaction`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usertype_table`
--
ALTER TABLE `usertype_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cashiertransaction`
--
ALTER TABLE `cashiertransaction`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `inv_products`
--
ALTER TABLE `inv_products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `stafftransaction`
--
ALTER TABLE `stafftransaction`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `usertype_table`
--
ALTER TABLE `usertype_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
