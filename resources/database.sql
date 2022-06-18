SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema organograma
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `organograma` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `organograma` ;

-- -----------------------------------------------------
-- Table `organograma`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organograma`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(14) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `nome_empresa` VARCHAR(30) NOT NULL,
  `responsavel` VARCHAR(30) NOT NULL,
  `telefone` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_2vf89ija5fea0souakqh3bg59` (`cnpj` ASC) VISIBLE,
  UNIQUE INDEX `UK_cmxo70m08n43599l3h0h07cc6` (`email` ASC) VISIBLE,
  UNIQUE INDEX `UK_p8c203pb1sq229aw9ea1an1ce` (`nome_empresa` ASC) VISIBLE,
  UNIQUE INDEX `UK_i94fmdo5ix2yqqi0l3mdruvrb` (`responsavel` ASC) VISIBLE,
  UNIQUE INDEX `UK_cjamibneobl928lfs71yos48r` (`telefone` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 106
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `organograma`.`nucleo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organograma`.`nucleo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `area` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `sigla` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_bpwlyut7wj1ylft0lmph6027t` (`area` ASC) VISIBLE,
  UNIQUE INDEX `UK_krll00schptgn0ws6ql5gjrss` (`nome` ASC) VISIBLE,
  UNIQUE INDEX `UK_h7w98cgm5gsjx2kj9tabndft0` (`sigla` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `organograma`.`membro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organograma`.`membro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cargo` VARCHAR(10) NOT NULL,
  `curso` VARCHAR(3) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `nome` VARCHAR(30) NOT NULL,
  `nucleo_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_qo1nfjymnt8sryfstaxp4c8s1` (`email` ASC) VISIBLE,
  UNIQUE INDEX `UK_i1ijd6x07e1x1ssiwg00uh4wf` (`nome` ASC) VISIBLE,
  INDEX `FKt1clpfuh3jhcsstob5sn256iw` (`nucleo_id` ASC) VISIBLE,
  CONSTRAINT `FKt1clpfuh3jhcsstob5sn256iw`
    FOREIGN KEY (`nucleo_id`)
    REFERENCES `organograma`.`nucleo` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 109
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `organograma`.`projeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organograma`.`projeto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `status` VARCHAR(255) NOT NULL,
  `cliente_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_eid3ga5yg105b9t867m8gmhm8` (`nome` ASC) VISIBLE,
  INDEX `FKifbtsmek1wlh473951ea983vm` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `FKifbtsmek1wlh473951ea983vm`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `organograma`.`cliente` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 104
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `organograma`.`projeto_membro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `organograma`.`projeto_membro` (
  `projeto_id` INT NOT NULL,
  `membro_id` INT NOT NULL,
  PRIMARY KEY (`projeto_id`, `membro_id`),
  INDEX `FKis0tr4l6g69j2sy1pmqgu1b5x` (`membro_id` ASC) VISIBLE,
  CONSTRAINT `FKayu6jvu828k689e7muhs9ga78`
    FOREIGN KEY (`projeto_id`)
    REFERENCES `organograma`.`projeto` (`id`),
  CONSTRAINT `FKis0tr4l6g69j2sy1pmqgu1b5x`
    FOREIGN KEY (`membro_id`)
    REFERENCES `organograma`.`membro` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
