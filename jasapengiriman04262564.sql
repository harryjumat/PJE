-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Nov 2020 pada 13.51
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jasapengiriman04262564`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `paket`
--

CREATE TABLE `paket` (
  `id_paket04262564` int(10) NOT NULL,
  `id_kurir_service04262564` int(11) NOT NULL,
  `nip_pengirim04262564` int(11) NOT NULL,
  `nomor_resi04262564` varchar(10) NOT NULL DEFAULT '',
  `order_id04262564` int(10) NOT NULL DEFAULT 0,
  `alamat_paket04262564` varchar(255) NOT NULL DEFAULT '',
  `penerima04262564` varchar(50) NOT NULL DEFAULT '',
  `service04262564` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `paket`
--

INSERT INTO `paket` (`id_paket04262564`, `id_kurir_service04262564`, `nip_pengirim04262564`, `nomor_resi04262564`, `order_id04262564`, `alamat_paket04262564`, `penerima04262564`, `service04262564`) VALUES
(1242, 9, 12342, '142121', 12423, 'tangerang', 'bowid', 'regular'),
(9072, 255, 55555, '4657', 691, 'banjar', 'engkohncek', 'regular');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengirim`
--

CREATE TABLE `pengirim` (
  `nip_pengirim04262564` int(11) NOT NULL,
  `nama_pengirim04262564` varchar(50) DEFAULT NULL,
  `telp_pengirim04262564` varchar(14) DEFAULT NULL,
  `email_pengirim04262564` varchar(255) DEFAULT NULL,
  `alamat_pengirim04262564` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

--
-- Dumping data untuk tabel `pengirim`
--

INSERT INTO `pengirim` (`nip_pengirim04262564`, `nama_pengirim04262564`, `telp_pengirim04262564`, `email_pengirim04262564`, `alamat_pengirim04262564`) VALUES
(12342, 'jae', '02121212', 'ahay@gmail.com', 'cilegon'),
(55555, 'Alpan', '0854', 'alpan@gmail.com', 'cipondoh');

-- --------------------------------------------------------

--
-- Struktur dari tabel `service`
--

CREATE TABLE `service` (
  `id_kurir_service04262564` int(11) NOT NULL,
  `nama_service04262564` varchar(20) NOT NULL,
  `harga_service04262564` int(8) NOT NULL,
  `lama_hari04262564` int(2) NOT NULL,
  `berat_barang04262564` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

--
-- Dumping data untuk tabel `service`
--

INSERT INTO `service` (`id_kurir_service04262564`, `nama_service04262564`, `harga_service04262564`, `lama_hari04262564`, `berat_barang04262564`) VALUES
(9, 'Same Day', 40000, 1, '1kg'),
(255, 'Instant', 90000, 2, '1kg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `track_paket`
--

CREATE TABLE `track_paket` (
  `nomor_resi04262564` varchar(10) NOT NULL DEFAULT '',
  `kode_cabang04262564` int(10) NOT NULL DEFAULT 0,
  `nip_pengirim04262564` int(11) NOT NULL DEFAULT 0,
  `keterangan04262564` varchar(100) NOT NULL,
  `lokasi04262564` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

--
-- Dumping data untuk tabel `track_paket`
--

INSERT INTO `track_paket` (`nomor_resi04262564`, `kode_cabang04262564`, `nip_pengirim04262564`, `keterangan04262564`, `lokasi04262564`) VALUES
('142121', 1242, 12342, 'tertahan', 'papua'),
('4657', 3364, 55555, 'ongoing', 'surabaya');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `paket`
--
ALTER TABLE `paket`
  ADD PRIMARY KEY (`id_paket04262564`),
  ADD KEY `id_kurir_service04262564` (`id_kurir_service04262564`),
  ADD KEY `nip_pengirim04262564` (`nip_pengirim04262564`),
  ADD KEY `nomor_resi04262564` (`nomor_resi04262564`);

--
-- Indeks untuk tabel `pengirim`
--
ALTER TABLE `pengirim`
  ADD PRIMARY KEY (`nip_pengirim04262564`);

--
-- Indeks untuk tabel `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`id_kurir_service04262564`);

--
-- Indeks untuk tabel `track_paket`
--
ALTER TABLE `track_paket`
  ADD PRIMARY KEY (`nomor_resi04262564`),
  ADD KEY `nip_pengirim04262564` (`nip_pengirim04262564`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `paket`
--
ALTER TABLE `paket`
  MODIFY `id_paket04262564` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9073;

--
-- AUTO_INCREMENT untuk tabel `pengirim`
--
ALTER TABLE `pengirim`
  MODIFY `nip_pengirim04262564` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55556;

--
-- AUTO_INCREMENT untuk tabel `service`
--
ALTER TABLE `service`
  MODIFY `id_kurir_service04262564` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=256;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `paket`
--
ALTER TABLE `paket`
  ADD CONSTRAINT `paket_ibfk_1` FOREIGN KEY (`id_kurir_service04262564`) REFERENCES `service` (`id_kurir_service04262564`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `paket_ibfk_2` FOREIGN KEY (`nip_pengirim04262564`) REFERENCES `pengirim` (`nip_pengirim04262564`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `paket_ibfk_3` FOREIGN KEY (`nomor_resi04262564`) REFERENCES `track_paket` (`nomor_resi04262564`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `track_paket`
--
ALTER TABLE `track_paket`
  ADD CONSTRAINT `track_paket_ibfk_1` FOREIGN KEY (`nip_pengirim04262564`) REFERENCES `pengirim` (`nip_pengirim04262564`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
