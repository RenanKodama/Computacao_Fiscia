-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Pulse_Sensor
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Pulse_Sensor
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Pulse_Sensor` DEFAULT CHARACTER SET utf8 ;
USE `Pulse_Sensor` ;

-- -----------------------------------------------------
-- Table `Pulse_Sensor`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pulse_Sensor`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nomeUsuario` VARCHAR(45) NULL,
  `peso` FLOAT NULL,
  `idade` INT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pulse_Sensor`.`Sensor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pulse_Sensor`.`Sensor` (
  `idSensor` INT NOT NULL AUTO_INCREMENT,
  `nomeSensor` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`idSensor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pulse_Sensor`.`Leitura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pulse_Sensor`.`Leitura` (
  `idLeitura` INT NOT NULL AUTO_INCREMENT,
  `ValorLeitura` FLOAT NULL,
  `data` DATETIME NULL,
  `Sensor_idSensor` INT NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idLeitura`),
  INDEX `fk_Leitura_Sensor1_idx` (`Sensor_idSensor` ASC),
  INDEX `fk_Leitura_Usuario1_idx` (`Usuario_idUsuario` ASC),
  CONSTRAINT `fk_Leitura_Sensor1`
    FOREIGN KEY (`Sensor_idSensor`)
    REFERENCES `Pulse_Sensor`.`Sensor` (`idSensor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Leitura_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `Pulse_Sensor`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
