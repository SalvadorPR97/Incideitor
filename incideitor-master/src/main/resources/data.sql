-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: incideitor
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMINISTRADOR'),(2,'USUARIO'),(3,'ANONIMO'),(4,'AYUNTAMIENTO_ADMIN'),(5,'AYUNTAMIENTO_GESTOR');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ayuntamientos`
--

LOCK TABLES `ayuntamientos` WRITE;
/*!40000 ALTER TABLE `ayuntamientos` DISABLE KEYS */;
INSERT INTO `ayuntamientos` VALUES (1,'chiclana3.png','chiclana3.png','chiclana.png','chiclana2.png','Chiclana'),(2,'jerez3.png','jerez4.png','jerez.png','jerez2.png','Jerez'),(3,'murcia3.png','murcia4.png','murcia.png','murcia2.png','Murcia'),(4,'albacete3.png','albacete4.png','albacete.png','albacete2.png','Albacete'),(5,'toledo3.png','toledo4.png','toledo.png','toledo2.png','Toledo'),(6,'sevilla3.png','sevilla4.png','sevilla.png','sevilla2.png','Sevilla');
/*!40000 ALTER TABLE `ayuntamientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Y medio','juan.png',0,'$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a',NULL,'12345678A','juan@gmail.com',NULL,'Juan',0,'Hombre',NULL,2,NULL,NULL,NULL,1),(2,'Valles','manuel.png',0,'$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a',NULL,'12345678B','manuel@gmail.com',NULL,'Manuel',0,'Hombre',NULL,1,NULL,NULL,NULL,2),(3,'Suarez','manolo.png',0,'$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a',NULL,'12345678C','anonimo@anonimo.com',NULL,'Manolo',0,'Otro',NULL,NULL,NULL,NULL,NULL,3),(4,'Cobo','carmelo.png',0,'$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a',NULL,'12345678D','carmelo@gmail.com',NULL,'Carmelo',0,'Mujer',NULL,NULL,NULL,NULL,NULL,4),(5,'Lima','domingo.png',0,'$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a','Urbanismo','12345678E','domingo@gmail.com',304,'Domingo',0,'Hombre',NULL,NULL,NULL,NULL,NULL,5),(6,'Aguado','lola.png',0,'$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a',NULL,'12345678F','lola@gmail.com',NULL,'Lola',0,'Hombre',NULL,NULL,NULL,NULL,NULL,2),(7,'Barros','kirby.png',0,'$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a',NULL,'12345678G','andrea@gmail.com',NULL,'Andrea',0,'Otro',NULL,NULL,NULL,NULL,NULL,2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tipoincidencia`
--

LOCK TABLES `tipoincidencia` WRITE;
/*!40000 ALTER TABLE `tipoincidencia` DISABLE KEYS */;
INSERT INTO `tipoincidencia` VALUES (999999,_binary '','Padre',0,NULL),(1,_binary '','Acerado',10,999999),(2,_binary '','Aguas',20,999999),(3,_binary '','Alumbrado',30,999999),(4,_binary '','Arquetas',40,999999),(5,_binary '','Cableado',50,999999),(6,_binary '','Calzada',60,999999),(7,_binary '','Carril bici',70,999999),(8,_binary '','Fuentes',80,999999),(9,_binary '','Jardines y zonas verdes',90,999999),(10,_binary '','Limpieza',100,999999),(11,_binary '','Medio ambiente',110,999999),(12,_binary '','Mobiliario urbano',120,999999),(13,_binary '','Monumentos',130,999999),(14,_binary '','Parada bus/taxi',140,999999),(15,_binary '','Parques infantiles',150,999999),(16,_binary '','Plagas',160,999999),(17,_binary '','Playas',170,999999),(18,_binary '','Saneamiento',180,999999),(19,_binary '','Semaforos',190,999999),(20,_binary '','Agrietado',10,1),(21,_binary '','Baldosas',20,1),(22,_binary '','Socavón',30,1),(23,_binary '','Corte del Servicio',10,2),(24,_binary '','Mala calidad',20,2),(25,_binary '','Cables al Descubierto',10,3),(26,_binary '','Cristal Roto',20,3),(27,_binary '','Luminaria Apagada',30,3),(28,_binary '','Farol Roto',40,3),(29,_binary '','Arqueta Abierta',10,4),(30,_binary '','Arqueta en Mal Estado',20,4),(31,_binary '','Arqueta con Tapa Desaparecida',30,4);
/*!40000 ALTER TABLE `tipoincidencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'Registrado'),(2,'En Curso'),(3,'Finalizado');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `incidencias`
--

LOCK TABLES `incidencias` WRITE;
/*!40000 ALTER TABLE `incidencias` DISABLE KEYS */;
INSERT INTO `incidencias` VALUES (1,0,'La baldosa de la calle está levantada y se puede caer alguien','Calle Ópalo, Mijas, España','2023-06-10',NULL,'Baldosa rota',1,1,NULL,21,1),(2,0,'La tapa de la arqueta de la calle no está','Calle Diamante, Mijas, España','2023-06-11',NULL,'Tapa de arqueta desaparecida',3,1,NULL,31,2),(3,0,'El cristal de la farola está roto','Calle Ónice, Mijas, España','2023-06-11','2023-06-18','Cristal de farola roto',4,3,NULL,26,3),(4,0,'La bombilla no funciona','Calle Zafiro, Mijas, España','2023-06-21',NULL,'Bombilla fundida',5,2,NULL,27,4);
/*!40000 ALTER TABLE `incidencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `historicos`
--

LOCK TABLES `historicos` WRITE;
/*!40000 ALTER TABLE `historicos` DISABLE KEYS */;
INSERT INTO `historicos` VALUES (1,'2023-06-01',NULL,1,1),(2,'2023-06-01','Hermanos Rodriguez va a arreglarlo',2,2),(3,'2023-06-01','Se ha sustituido la bombilla',3,3);
/*!40000 ALTER TABLE `historicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reportes`
--

LOCK TABLES `reportes` WRITE;
/*!40000 ALTER TABLE `reportes` DISABLE KEYS */;
INSERT INTO `reportes` VALUES (1,'Bug','No se ve la pantalla','Pantalla',NULL,NULL),(2,'Error','Incidencia con fotos borrosas','Fotos en la incidencia',NULL,NULL),(3,'Error','La dirección está mal','Dirección',NULL,NULL);
/*!40000 ALTER TABLE `reportes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `fotos`
--

LOCK TABLES `fotos` WRITE;
/*!40000 ALTER TABLE `fotos` DISABLE KEYS */;
/*!40000 ALTER TABLE `fotos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `votos`
--

LOCK TABLES `votos` WRITE;
/*!40000 ALTER TABLE `votos` DISABLE KEYS */;
/*!40000 ALTER TABLE `votos` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `lugares`
--

LOCK TABLES `lugares` WRITE;
/*!40000 ALTER TABLE `lugares` DISABLE KEYS */;
/*!40000 ALTER TABLE `lugares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `mensajes`
--

LOCK TABLES `mensajes` WRITE;
/*!40000 ALTER TABLE `mensajes` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `notificaciones`
--

LOCK TABLES `notificaciones` WRITE;
/*!40000 ALTER TABLE `notificaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `parametros_incidencia`
--

LOCK TABLES `parametros_incidencia` WRITE;
/*!40000 ALTER TABLE `parametros_incidencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametros_incidencia` ENABLE KEYS */;
UNLOCK TABLES;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-21 17:50:25
