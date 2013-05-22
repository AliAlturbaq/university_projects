SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `twitter` DEFAULT CHARACTER SET utf8 ;
USE `twitter` ;

-- -----------------------------------------------------
-- Table `twitter`.`users`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `twitter`.`users` (
  `username` VARCHAR(20) NOT NULL ,
  `password` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`username`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `twitter`.`following`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `twitter`.`following` (
  `followID` INT(11) NOT NULL AUTO_INCREMENT ,
  `follow_usernam` VARCHAR(20) NULL DEFAULT NULL ,
  `Users_username` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`followID`) ,
  INDEX `fk_following_Users` (`Users_username` ASC) ,
  CONSTRAINT `fk_following_Users`
    FOREIGN KEY (`Users_username` )
    REFERENCES `twitter`.`users` (`username` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 38
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `twitter`.`tweets`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `twitter`.`tweets` (
  `tweetId` INT(11) NOT NULL AUTO_INCREMENT ,
  `tweet` VARCHAR(140) NOT NULL ,
  `Users_username` VARCHAR(20) NULL DEFAULT NULL ,
  `CreationDate` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`tweetId`) ,
  INDEX `fk_Tweets_Users` (`Users_username` ASC) ,
  CONSTRAINT `fk_Tweets_Users`
    FOREIGN KEY (`Users_username` )
    REFERENCES `twitter`.`users` (`username` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 52
DEFAULT CHARACTER SET = utf8;

USE `twitter`;

DELIMITER $$
USE `twitter`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `twitter`.`before_tweets_insert`
BEFORE INSERT ON `twitter`.`tweets`
FOR EACH ROW
BEGIN
	SET NEW.CreationDate = now();
	 END$$


DELIMITER ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
