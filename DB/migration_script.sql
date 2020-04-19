-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: backup2ndtry
-- Source Schemata: rentmyspeakerdb1
-- Created: Sat Apr 18 16:29:10 2020
-- Workbench Version: 8.0.19
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema backup2ndtry
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `backup2ndtry` ;
CREATE SCHEMA IF NOT EXISTS `backup2ndtry` ;

-- ----------------------------------------------------------------------------
-- Table backup2ndtry.imagen_publicacion
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `backup2ndtry`.`imagen_publicacion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME(6) NULL DEFAULT NULL,
  `id_publicacion` INT(11) NULL DEFAULT NULL,
  `url_img` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKkvt6aokmuvm5sdblgy0y9iog` (`id_publicacion` ASC),
  CONSTRAINT `FKkvt6aokmuvm5sdblgy0y9iog`
    FOREIGN KEY (`id_publicacion`)
    REFERENCES `backup2ndtry`.`publicacion` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table backup2ndtry.publicacion
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `backup2ndtry`.`publicacion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(1800) NULL DEFAULT NULL,
  `disponible` BIT(1) NOT NULL,
  `fecha` DATETIME(6) NULL DEFAULT NULL,
  `id_usuario` INT(11) NULL DEFAULT NULL,
  `precio_dia` DOUBLE NOT NULL,
  `tipo_articulo` VARCHAR(255) NULL DEFAULT NULL,
  `titulo_pub` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK9kh5k6pnpbv4xeqrdwv4585b7` (`id_usuario` ASC),
  CONSTRAINT `FK9kh5k6pnpbv4xeqrdwv4585b7`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `backup2ndtry`.`usuario` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table backup2ndtry.renta
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `backup2ndtry`.`renta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `estado_renta` VARCHAR(255) NULL DEFAULT NULL,
  `fecha` DATETIME(6) NULL DEFAULT NULL,
  `id_solicitud` INT(11) NULL DEFAULT NULL,
  `id_usuario` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKb343k5n4bf2lbtrq5nggt3qmm` (`id_usuario` ASC),
  CONSTRAINT `FKb343k5n4bf2lbtrq5nggt3qmm`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `backup2ndtry`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table backup2ndtry.session
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `backup2ndtry`.`session` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `final_sesion` DATETIME(6) NULL DEFAULT NULL,
  `id_usuario` INT(11) NULL DEFAULT NULL,
  `inicio_sesion` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table backup2ndtry.solicitud
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `backup2ndtry`.`solicitud` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `estado_solicitud` VARCHAR(255) NULL DEFAULT NULL,
  `fecha` DATETIME(6) NULL DEFAULT NULL,
  `id_publicacion` INT(11) NULL DEFAULT NULL,
  `id_usuario` INT(11) NULL DEFAULT NULL,
  `num_dias` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKnm4y7w49isl37c27aq2fmos5t` (`id_usuario` ASC),
  INDEX `FKn9wv9hntlm5q77tfwdyx80oj1` (`id_publicacion` ASC),
  CONSTRAINT `FKn9wv9hntlm5q77tfwdyx80oj1`
    FOREIGN KEY (`id_publicacion`)
    REFERENCES `backup2ndtry`.`publicacion` (`id`),
  CONSTRAINT `FKnm4y7w49isl37c27aq2fmos5t`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `backup2ndtry`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table backup2ndtry.usuario
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `backup2ndtry`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `apellidos` VARCHAR(60) NULL DEFAULT NULL,
  `contra` VARCHAR(100) NULL DEFAULT NULL,
  `correo` VARCHAR(125) NULL DEFAULT NULL,
  `fecha` DATETIME(6) NULL DEFAULT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `numero_telefonico` VARCHAR(16) NULL DEFAULT NULL,
  `url_img` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;
SET FOREIGN_KEY_CHECKS = 1;
