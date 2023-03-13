-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: MyBodega
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clientes` (
  `idClientes` int NOT NULL AUTO_INCREMENT,
  `CliNombre` varchar(60) DEFAULT NULL,
  `CliDireccion` varchar(200) DEFAULT NULL,
  `CliTelefon` varchar(60) DEFAULT NULL,
  `CliCiudad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idClientes`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
INSERT INTO `Clientes` VALUES (1,'Andres Bermudez','Calle Mandalay','320 584 6987','Bogota'),(2,'Alejandra Hernandez','Calle Foreo','601 547 5463','Bogota'),(3,'Pedro Benavides','Avenida Bom dia','748 9698 457','Copacabana');
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Inventario`
--

DROP TABLE IF EXISTS `Inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Inventario` (
  `idBodega` int NOT NULL AUTO_INCREMENT,
  `fk_RegUserID` varchar(45) DEFAULT NULL,
  `fk_Producto` int DEFAULT NULL,
  `fk_Movimientos` int DEFAULT NULL,
  PRIMARY KEY (`idBodega`),
  KEY `fk_RegUserID` (`fk_RegUserID`),
  KEY `fk_Producto` (`fk_Producto`),
  KEY `fk_Movimientos` (`fk_Movimientos`),
  CONSTRAINT `Inventario_ibfk_1` FOREIGN KEY (`fk_RegUserID`) REFERENCES `Registro` (`RegUserID`),
  CONSTRAINT `Inventario_ibfk_2` FOREIGN KEY (`fk_Producto`) REFERENCES `Productos` (`idProductos`),
  CONSTRAINT `Inventario_ibfk_3` FOREIGN KEY (`fk_Movimientos`) REFERENCES `Movimientos` (`idMovimientos`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Inventario`
--

LOCK TABLES `Inventario` WRITE;
/*!40000 ALTER TABLE `Inventario` DISABLE KEYS */;
INSERT INTO `Inventario` VALUES (10,NULL,NULL,NULL),(11,'jcamacho',1,2),(12,'jquintero',2,1),(13,'jquintero',3,3);
/*!40000 ALTER TABLE `Inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Movimientos`
--

DROP TABLE IF EXISTS `Movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Movimientos` (
  `idMovimientos` int NOT NULL AUTO_INCREMENT,
  `MovFechaSalida` date DEFAULT NULL,
  `MovFechaIngreso` date DEFAULT NULL,
  `MovCantidadSalida` int DEFAULT NULL,
  `MovCantidadIngreso` int DEFAULT NULL,
  `MovHora` time DEFAULT NULL,
  PRIMARY KEY (`idMovimientos`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movimientos`
--

LOCK TABLES `Movimientos` WRITE;
/*!40000 ALTER TABLE `Movimientos` DISABLE KEYS */;
INSERT INTO `Movimientos` VALUES (1,'2020-11-17','2021-01-10',10,11,'10:45:30'),(2,'2022-02-05','2022-06-30',5,2,'09:08:01'),(3,'2022-02-22','2022-03-15',20,15,'16:15:10');
/*!40000 ALTER TABLE `Movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Productos`
--

DROP TABLE IF EXISTS `Productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Productos` (
  `idProductos` int NOT NULL AUTO_INCREMENT,
  `ProNombre` varchar(50) DEFAULT NULL,
  `ProCantidad` int DEFAULT NULL,
  `ProPrecio` decimal(12,2) DEFAULT NULL,
  `ProUnidadMedida` varchar(10) DEFAULT NULL,
  `ProObservaciones` varchar(500) DEFAULT NULL,
  `ProStatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idProductos`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Productos`
--

LOCK TABLES `Productos` WRITE;
/*!40000 ALTER TABLE `Productos` DISABLE KEYS */;
INSERT INTO `Productos` VALUES (1,'Tomate',2000,500.00,'Lb','N/A','Disponible'),(2,'Limon',50,2000.00,'Lb','N/A','Disponible'),(3,'Manzana',80,3500.00,'Kg','N/A','Disponible');
/*!40000 ALTER TABLE `Productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Registro`
--

DROP TABLE IF EXISTS `Registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Registro` (
  `RegUserID` varchar(50) NOT NULL,
  `RegRol` varchar(10) NOT NULL,
  `fk_Identificacion` varchar(45) NOT NULL,
  PRIMARY KEY (`RegUserID`),
  KEY `fk_Identificacion` (`fk_Identificacion`),
  CONSTRAINT `Registro_ibfk_1` FOREIGN KEY (`fk_Identificacion`) REFERENCES `Usuario` (`UsuIdentificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Registro`
--

LOCK TABLES `Registro` WRITE;
/*!40000 ALTER TABLE `Registro` DISABLE KEYS */;
INSERT INTO `Registro` VALUES ('jcamacho','Admin','102074154'),('jquintero','User','108063222');
/*!40000 ALTER TABLE `Registro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuario` (
  `UsuIdentificacion` varchar(100) NOT NULL,
  `UsuContraseña` varchar(45) NOT NULL,
  `UsuNombre` varchar(100) NOT NULL,
  `UsuApellido` varchar(100) NOT NULL,
  `UsuEmail` varchar(100) NOT NULL,
  PRIMARY KEY (`UsuIdentificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES ('102074154','Cup2151','Jhoan','Camacho','jcamacho@mybodega.com'),('108063222','dwe745','Juan','Quintero','jquintero@mybodega.com');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ventas`
--

DROP TABLE IF EXISTS `Ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ventas` (
  `idVentas` int NOT NULL AUTO_INCREMENT,
  `fkClientes` int DEFAULT NULL,
  `fkBodega` int DEFAULT NULL,
  `VenProducto` int NOT NULL,
  `VenPrecioTotal` double DEFAULT NULL,
  `VenFecha` date DEFAULT NULL,
  `VenStatus` varchar(20) DEFAULT NULL,
  `VenObservaciones` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`idVentas`),
  KEY `fkClientes` (`fkClientes`),
  KEY `fkBodega` (`fkBodega`),
  KEY `VenProducto` (`VenProducto`),
  CONSTRAINT `Ventas_ibfk_1` FOREIGN KEY (`fkClientes`) REFERENCES `Clientes` (`idClientes`),
  CONSTRAINT `Ventas_ibfk_2` FOREIGN KEY (`fkBodega`) REFERENCES `Inventario` (`idBodega`),
  CONSTRAINT `Ventas_ibfk_3` FOREIGN KEY (`VenProducto`) REFERENCES `Productos` (`idProductos`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ventas`
--

LOCK TABLES `Ventas` WRITE;
/*!40000 ALTER TABLE `Ventas` DISABLE KEYS */;
INSERT INTO `Ventas` VALUES (2,1,10,1,120000,'2021-10-24','Enviado','Entregar en la mañana'),(3,2,10,2,40000,'2022-08-20','Empacando','No se recibe los fines de semana'),(4,3,10,3,15000,'2022-07-02','Enviado','Llamar al 745 6805');
/*!40000 ALTER TABLE `Ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-17 12:49:28
