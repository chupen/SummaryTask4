-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema st4
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema st4
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `st4` DEFAULT CHARACTER SET utf8 ;
USE `st4` ;

-- -----------------------------------------------------
-- Table `st4`.`subjects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `st4`.`subjects` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `st4`.`universities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `st4`.`universities` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT 'unknown',
  `sphere` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `st4`.`faculties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `st4`.`faculties` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `universities_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Faculties_Universities1_idx` (`universities_id` ASC),
  CONSTRAINT `fk_Faculties_Universities1`
    FOREIGN KEY (`universities_id`)
    REFERENCES `st4`.`universities` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `st4`.`groups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `st4`.`groups` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `faculties_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Groups_Faculties1_idx` (`faculties_id` ASC),
  CONSTRAINT `fk_Groups_Faculties1`
    FOREIGN KEY (`faculties_id`)
    REFERENCES `st4`.`faculties` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `st4`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `st4`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `role_name` ENUM('ADMIN', 'USER') NULL DEFAULT 'USER',
  `name` VARCHAR(45) NULL DEFAULT 'name',
  `surname` VARCHAR(45) NULL DEFAULT 'surname',
  `is_blocked` TINYINT(1) NOT NULL DEFAULT '0',
  `groups_id` INT(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  INDEX `fk_Users_Groups1_idx` (`groups_id` ASC),
  CONSTRAINT `fk_Users_Groups1`
    FOREIGN KEY (`groups_id`)
    REFERENCES `st4`.`groups` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `st4`.`tests_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `st4`.`tests_info` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `complexity` ENUM('EASY', 'MEDIUM', 'HARD') NOT NULL,
  `time` INT(11) NOT NULL,
  `pass_mark` INT(11) NOT NULL,
  `subjects_id` INT(11) NOT NULL,
  `author_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_Tests_info_Subjects1_idx` (`subjects_id` ASC),
  INDEX `fk_Tests_info_Users1_idx` (`author_id` ASC),
  CONSTRAINT `fk_Tests_info_Subjects1`
    FOREIGN KEY (`subjects_id`)
    REFERENCES `st4`.`subjects` (`id`),
  CONSTRAINT `fk_Tests_info_Users1`
    FOREIGN KEY (`author_id`)
    REFERENCES `st4`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `st4`.`test_questions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `st4`.`test_questions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tests_info_id` INT(11) NOT NULL,
  `q_text` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`, `tests_info_id`),
  INDEX `fk_Questions_Tests_info1_idx` (`tests_info_id` ASC),
  CONSTRAINT `fk_Questions_Tests_info1`
    FOREIGN KEY (`tests_info_id`)
    REFERENCES `st4`.`tests_info` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `st4`.`complete_tests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `st4`.`complete_tests` (
  `answer_id` INT(11) NOT NULL AUTO_INCREMENT,
  `test_questions_id` INT(11) NOT NULL,
  `tests_info_id` INT(11) NOT NULL,
  `answer_text` VARCHAR(250) NOT NULL,
  `is_correct` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`answer_id`, `test_questions_id`, `tests_info_id`),
  INDEX `fk_Complete_tests_Test_question1_idx` (`test_questions_id` ASC, `tests_info_id` ASC),
  CONSTRAINT `fk_Complete_tests_Test_question1`
    FOREIGN KEY (`test_questions_id` , `tests_info_id`)
    REFERENCES `st4`.`test_questions` (`id` , `tests_info_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `st4`.`taken_tests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `st4`.`taken_tests` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `mark` INT(11) NOT NULL,
  `is_passed` TINYINT(1) NOT NULL DEFAULT '0',
  `date_of_taking` VARCHAR(45) NOT NULL,
  `users_id` INT(11) NOT NULL,
  `tests_info_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Taked_tests_Users1_idx` (`users_id` ASC),
  INDEX `fk_Taked_tests_Tests_info1_idx` (`tests_info_id` ASC),
  CONSTRAINT `fk_Taked_tests_Tests_info1`
    FOREIGN KEY (`tests_info_id`)
    REFERENCES `st4`.`tests_info` (`id`),
  CONSTRAINT `fk_Taked_tests_Users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `st4`.`users` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;