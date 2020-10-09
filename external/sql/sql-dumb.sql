-- MySQL Script generated by MySQL Workbench
-- Thu Oct  8 20:15:37 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema facultative_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema facultative_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `facultative_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `facultative_db` ;

-- -----------------------------------------------------
-- Table `facultative_db`.`usr`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultative_db`.`usr` (
  `usr_id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `blocked` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`usr_id`),
  UNIQUE INDEX `usr_id_UNIQUE` (`usr_id` ASC) INVISIBLE,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facultative_db`.`subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultative_db`.`subject` (
  `subject_id` INT NOT NULL AUTO_INCREMENT,
  `subject_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`subject_id`),
  UNIQUE INDEX `subject_id_UNIQUE` (`subject_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facultative_db`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultative_db`.`course` (
  `course_id` INT NOT NULL AUTO_INCREMENT,
  `course_name` VARCHAR(45) NOT NULL,
  `subject_id` INT NOT NULL,
  `teacher_id` INT NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `course_status` VARCHAR(45) NOT NULL DEFAULT 'NOT_STARTED',
  PRIMARY KEY (`course_id`),
  UNIQUE INDEX `course_id_UNIQUE` (`course_id` ASC) VISIBLE,
  INDEX `fk_course_subject1_idx` (`subject_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_subject1`
    FOREIGN KEY (`subject_id`)
    REFERENCES `facultative_db`.`subject` (`subject_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facultative_db`.`journal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultative_db`.`journal` (
  `journal_id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  `mark` VARCHAR(45) NULL,
  PRIMARY KEY (`journal_id`, `student_id`, `course_id`),
  UNIQUE INDEX `journal_id_UNIQUE` (`journal_id` ASC) VISIBLE,
  INDEX `fk_journal_usr1_idx` (`student_id` ASC) VISIBLE,
  INDEX `fk_journal_course1_idx` (`course_id` ASC) VISIBLE,
  CONSTRAINT `fk_journal_usr1`
    FOREIGN KEY (`student_id`)
    REFERENCES `facultative_db`.`usr` (`usr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_journal_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `facultative_db`.`course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `facultative_db`.`course_student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `facultative_db`.`course_student` (
  `course_id` INT NOT NULL,
  `student_id` INT NOT NULL,
  PRIMARY KEY (`course_id`, `student_id`),
  INDEX `fk_course_has_usr_usr1_idx` (`student_id` ASC) VISIBLE,
  INDEX `fk_course_has_usr_course1_idx` (`course_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_has_usr_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `facultative_db`.`course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_has_usr_usr1`
    FOREIGN KEY (`student_id`)
    REFERENCES `facultative_db`.`usr` (`usr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
