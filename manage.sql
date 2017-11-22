CREATE SCHEMA `manage` ;

CREATE TABLE `manage`.`nurse` (
  `nurse_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `addtime` DATETIME NULL,
  PRIMARY KEY (`nurse_id`));
  
CREATE TABLE `manage`.`station` (
  `station_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `addtime` DATETIME NULL,
  PRIMARY KEY (`station_id`));

CREATE TABLE `manage`.`assignment` (
  `assign_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nurse_id` BIGINT(20) NULL,
  `station_id` BIGINT(20) NULL,
  `addtime` DATETIME NULL,
  `expired` TINYINT(4) NULL,
  PRIMARY KEY (`assign_id`));
