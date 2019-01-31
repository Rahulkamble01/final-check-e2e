SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `skynews` ;
CREATE SCHEMA IF NOT EXISTS `skynews` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `skynews` ;

-- -----------------------------------------------------
-- Table `skynews`.`article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skynews`.`article` ;

CREATE  TABLE IF NOT EXISTS `skynews`.`article` (
  `ar_id` INT NOT NULL AUTO_INCREMENT ,
  `ar_author` VARCHAR(45) NULL ,
  `ar_title` VARCHAR(450) NOT NULL ,
  `ar_description` VARCHAR(450) NOT NULL ,
  `ar_url` VARCHAR(500) NOT NULL ,
  `ar_urltoimage` VARCHAR(500) NOT NULL ,
  `ar_publishedat` VARCHAR(45) NULL ,
  `ar_content` VARCHAR(1000) NOT NULL ,
  PRIMARY KEY (`ar_id`) ,
  UNIQUE INDEX `ar_title_UNIQUE` (`ar_title` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skynews`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skynews`.`role` ;

CREATE  TABLE IF NOT EXISTS `skynews`.`role` (
  `ro_id` INT NOT NULL AUTO_INCREMENT ,
  `ro_description` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ro_id`) ,
  UNIQUE INDEX `ro_description_UNIQUE` (`ro_description` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skynews`.`language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skynews`.`language` ;

CREATE  TABLE IF NOT EXISTS `skynews`.`language` (
  `la_id` INT NOT NULL AUTO_INCREMENT ,
  `la_language` VARCHAR(50) NULL ,
  `la_code` VARCHAR(4) NULL ,
  PRIMARY KEY (`la_id`) ,
  UNIQUE INDEX `la_language_UNIQUE` (`la_language` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skynews`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skynews`.`user` ;

CREATE  TABLE IF NOT EXISTS `skynews`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT ,
  `us_name` VARCHAR(80) NOT NULL ,
  `us_email` VARCHAR(80) NOT NULL ,
  `us_password` VARCHAR(40) NOT NULL ,
  `us_status` VARCHAR(15) NOT NULL ,
  `us_ro_id` INT NULL ,
  `us_la_id` INT NULL ,
  PRIMARY KEY (`us_id`) ,
  INDEX `us_ro_fk` (`us_ro_id` ASC) ,
  UNIQUE INDEX `us_email_UNIQUE` (`us_email` ASC) ,
  CONSTRAINT `us_la_fk`
    FOREIGN KEY (`us_la_id` )
    REFERENCES `skynews`.`language` (`la_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `us_ro_fk`
    FOREIGN KEY (`us_ro_id` )
    REFERENCES `skynews`.`role` (`ro_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skynews`.`user_favourite_article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skynews`.`user_favourite_article` ;

CREATE  TABLE IF NOT EXISTS `skynews`.`user_favourite_article` (
  `fa_id` INT NOT NULL AUTO_INCREMENT ,
  `fa_ar_id` INT NULL ,
  `fa_us_id` INT NULL ,
  PRIMARY KEY (`fa_id`) ,
  INDEX `fa_ar_fk` (`fa_ar_id` ASC) ,
  INDEX `fa_us_fk` (`fa_us_id` ASC) ,
  CONSTRAINT `fa_ar_fk`
    FOREIGN KEY (`fa_ar_id` )
    REFERENCES `skynews`.`article` (`ar_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fa_us_fk`
    FOREIGN KEY (`fa_us_id` )
    REFERENCES `skynews`.`user` (`us_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
