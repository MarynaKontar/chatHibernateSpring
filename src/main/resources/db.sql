-- -----------------------------------------------------
-- Schema CHAT
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `CHAT` ;

-- -----------------------------------------------------
-- Schema CHAT
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CHAT` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `CHAT` ;

CREATE TABLE `CHAT`.`attributes` (
 `name` varchar(45) NOT NULL,
 `default_value` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CHAT`.`chat_attributes` (
 `chat_name` varchar(45) NOT NULL,
 `attribute_name` varchar(45) NOT NULL,
 `value` varchar(500) DEFAULT NULL,
 `type` int(11) DEFAULT NULL,
 PRIMARY KEY (`chat_name`,`attribute_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CHAT`.`chats` (
 `NAME` varchar(50) NOT NULL,
 `DESCRIPTION` varchar(400) DEFAULT NULL,
 PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CHAT`.`groups` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(405) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE `CHAT`.`users` (
 `LOGIN` varchar(45) NOT NULL,
 `PASSWORD` varchar(45) NOT NULL,
 `USERNAME` varchar(45) NOT NULL,
 `REGISTRATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 PRIMARY KEY (`LOGIN`),
 KEY `IDX_USERS_PASSWORD` (`PASSWORD`,`REGISTRATION_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `CHAT`.`messages` (
 `ID` int(11) NOT NULL AUTO_INCREMENT,
 `USER_LOGIN` varchar(45) NOT NULL,
 `NAME` varchar(50) NOT NULL,
 `TEXT` varchar(500) NOT NULL,
 `TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`ID`),
 KEY `FK_MSG_USER_LOGIN_idx` (`USER_LOGIN`),
 KEY `FK_MSG_CHAT_NAME_idx` (`NAME`),
 CONSTRAINT `FK_MSG_CHAT_NAME` FOREIGN KEY (`NAME`) REFERENCES `CHAT`.`chats` (`NAME`) ON DELETE NO ACTION ON UPDATE NO ACTION,
 CONSTRAINT `FK_MSG_USER_LOGIN` FOREIGN KEY (`USER_LOGIN`) REFERENCES `CHAT`.`users` (`LOGIN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE `CHAT`.`user_groups` (
 `group_id` int(11) NOT NULL,
 `user_login` varchar(45) NOT NULL,
 PRIMARY KEY (`group_id`,`user_login`),
 KEY `FK_UG_USER_LOGIN_idx` (`user_login`),
 CONSTRAINT `FK_UG_GROUP_ID` FOREIGN KEY (`group_id`) REFERENCES `CHAT`.`groups` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
 CONSTRAINT `FK_UG_USER_LOGIN` FOREIGN KEY (`user_login`) REFERENCES `CHAT`.`users` (`LOGIN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;