CREATE TABLE IF NOT EXISTS `survey`.`publishers` (
  `publisher_id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` CHAR(45) NOT NULL DEFAULT '',
  `password` CHAR(64) NOT NULL DEFAULT '',
  `created_at` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`publisher_id`),
  UNIQUE INDEX `publisher_id_UNIQUE` (`publisher_id` ASC),
  UNIQUE KEY `email_UNIQUE` (`email`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `survey`.`surveies` (
  `survey_id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL DEFAULT '',
  `created_by` BIGINT NOT NULL DEFAULT 0,
  `created_at` VARCHAR(45) NOT NULL DEFAULT 'now()',
  `modified_by` BIGINT NOT NULL DEFAULT 0,
  `modified_at` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`survey_id`),
  KEY `FK_surveies_publisher_id_idx` (`created_by` ASC),
  CONSTRAINT `FK_surveies_publisher_id`
    FOREIGN KEY (`created_by`)
    REFERENCES `survey`.`publishers` (`publisher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `survey`.`questions` (
  `question_id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(1000) NOT NULL DEFAULT '',
  `survey_id` BIGINT NOT NULL DEFAULT 0,
  `created_by` BIGINT NOT NULL DEFAULT 0,
  `created_at` DATETIME NOT NULL DEFAULT now(),
  `modified_by` BIGINT NOT NULL DEFAULT 0,
  `modified_at` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`question_id`),
  KEY `FK_questions_survey_id_idx` (`survey_id` ASC),
  KEY `FK_questions_created_by_idx` (`created_by` ASC),
  CONSTRAINT `FK_questions_survey_id`
    FOREIGN KEY (`survey_id`)
    REFERENCES `survey`.`surveies` (`survey_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_questions_created_by`
    FOREIGN KEY (`created_by`)
    REFERENCES `survey`.`publishers` (`publisher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `survey`.`options` (
  `option_id` BIGINT NOT NULL AUTO_INCREMENT,
  `question_id` BIGINT NOT NULL DEFAULT 0,
  `title` VARCHAR(45) NOT NULL DEFAULT '',
  `created_by` BIGINT NOT NULL DEFAULT 0,
  `created_at` DATETIME NOT NULL DEFAULT now(),
  `modified_by` BIGINT NOT NULL DEFAULT 0,
  `modified_at` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`option_id`),
  KEY `FK_options_question_id_idx` (`question_id` ASC),
  KEY `FK_options_created_by_idx` (`created_by` ASC),
  CONSTRAINT `FK_options_question_id`
    FOREIGN KEY (`question_id`)
    REFERENCES `survey`.`questions` (`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_options_created_by`
    FOREIGN KEY (`created_by`)
    REFERENCES `survey`.`publishers` (`publisher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `survey`.`audiences` (
  `audience_id` BIGINT NOT NULL AUTO_INCREMENT,
  `survey_id` BIGINT NOT NULL,
  `nickname` VARCHAR(45) NOT NULL DEFAULT '',
  `email` VARCHAR(45) NOT NULL DEFAULT '',
  `created_at` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`audience_id`),
  KEY `FK_collaborators_survey_id_idx` (`survey_id` ASC),
  CONSTRAINT `FK_ audiences_survey_id`
    FOREIGN KEY (`survey_id`)
    REFERENCES `survey`.`surveies` (`survey_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `survey`.`answers` (
  `answer_id` BIGINT NOT NULL AUTO_INCREMENT,
  `audience_id` BIGINT NOT NULL,
  `question_id` BIGINT NOT NULL,
  `option_id` BIGINT NOT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `FK_answers_coborator_id_idx` (`audience_id` ASC),
  KEY `FK_answers_option_id_idx` (`option_id` ASC),
  KEY `FK_answers_question_id_idx` (`question_id` ASC),
  CONSTRAINT `FK_answers_ audiences_id`
    FOREIGN KEY (`audience_id`)
    REFERENCES `survey`.`audiences` (`audience_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_answers_option_id`
    FOREIGN KEY (`option_id`)
    REFERENCES `survey`.`options` (`option_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_answers_question_id`
    FOREIGN KEY (`question_id`)
    REFERENCES `survey`.`questions` (`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
