-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mineria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mineria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mineria` DEFAULT CHARACTER SET utf8 ;
USE `mineria` ;

-- -----------------------------------------------------
-- Table `mineria`.`admin_sistema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mineria`.`admin_sistema` (
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`nombre_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mineria`.`deposito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mineria`.`deposito` (
  `iddeposito` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`iddeposito`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mineria`.`admin_ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mineria`.`admin_ventas` (
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(255) NOT NULL,
  `admin_sistema_nombre_usuario` VARCHAR(45) NOT NULL,
  `deposito_iddeposito` INT NOT NULL,
  PRIMARY KEY (`nombre_usuario`),
  INDEX `fk_admin_ventas_admin_sistema1_idx` (`admin_sistema_nombre_usuario` ASC),
  INDEX `fk_admin_ventas_deposito1_idx` (`deposito_iddeposito` ASC),
  CONSTRAINT `fk_admin_ventas_admin_sistema1`
    FOREIGN KEY (`admin_sistema_nombre_usuario`)
    REFERENCES `mineria`.`admin_sistema` (`nombre_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_admin_ventas_deposito1`
    FOREIGN KEY (`deposito_iddeposito`)
    REFERENCES `mineria`.`deposito` (`iddeposito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mineria`.`admin_stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mineria`.`admin_stock` (
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(255) NOT NULL,
  `admin_sistema_nombre_usuario` VARCHAR(45) NOT NULL,
  `deposito_iddeposito` INT NOT NULL,
  PRIMARY KEY (`nombre_usuario`),
  INDEX `fk_admin_stock_admin_sistema_idx` (`admin_sistema_nombre_usuario` ASC),
  INDEX `fk_admin_stock_deposito1_idx` (`deposito_iddeposito` ASC),
  CONSTRAINT `fk_admin_stock_admin_sistema`
    FOREIGN KEY (`admin_sistema_nombre_usuario`)
    REFERENCES `mineria`.`admin_sistema` (`nombre_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_admin_stock_deposito1`
    FOREIGN KEY (`deposito_iddeposito`)
    REFERENCES `mineria`.`deposito` (`iddeposito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mineria`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mineria`.`material` (
  `idmaterial` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(20) NOT NULL,
  `pureza` VARCHAR(10) NOT NULL,
  `cantidad` DECIMAL(10,2) NOT NULL,
  `fecha_de_ingreso` DATE NOT NULL,
  `deposito_iddeposito` INT NOT NULL,
  PRIMARY KEY (`idmaterial`),
  INDEX `fk_material_deposito1_idx` (`deposito_iddeposito` ASC),
  CONSTRAINT `fk_material_deposito1`
    FOREIGN KEY (`deposito_iddeposito`)
    REFERENCES `mineria`.`deposito` (`iddeposito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mineria`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mineria`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `admin_ventas_nombre_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcliente`),
  INDEX `fk_cliente_admin_ventas1_idx` (`admin_ventas_nombre_usuario` ASC),
  CONSTRAINT `fk_cliente_admin_ventas1`
    FOREIGN KEY (`admin_ventas_nombre_usuario`)
    REFERENCES `mineria`.`admin_ventas` (`nombre_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mineria`.`direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mineria`.`direccion` (
  `iddireccion` INT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `codigo_postal` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `cliente_idcliente` INT NOT NULL,
  PRIMARY KEY (`iddireccion`),
  INDEX `fk_direccion_cliente1_idx` (`cliente_idcliente` ASC),
  CONSTRAINT `fk_direccion_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `mineria`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mineria`.`material_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mineria`.`material_pedido` (
  `idmaterial` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `pureza` VARCHAR(45) NOT NULL,
  `cantidad` DECIMAL(10,2) NOT NULL,
  `precio_base` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`idmaterial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mineria`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mineria`.`pedido` (
  `idpedido` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `total` DECIMAL(10,2) NULL,
  `admin_ventas_nombre_usuario` VARCHAR(45) NOT NULL,
  `cliente_idcliente` INT NOT NULL,
  `material_pedido_idmaterial` INT NOT NULL,
  PRIMARY KEY (`idpedido`),
  INDEX `fk_pedido_admin_ventas1_idx` (`admin_ventas_nombre_usuario` ASC),
  INDEX `fk_pedido_cliente1_idx` (`cliente_idcliente` ASC),
  INDEX `fk_pedido_material_pedido1_idx` (`material_pedido_idmaterial` ASC),
  CONSTRAINT `fk_pedido_admin_ventas1`
    FOREIGN KEY (`admin_ventas_nombre_usuario`)
    REFERENCES `mineria`.`admin_ventas` (`nombre_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `mineria`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_material_pedido1`
    FOREIGN KEY (`material_pedido_idmaterial`)
    REFERENCES `mineria`.`material_pedido` (`idmaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
