CREATE DATABASE  IF NOT EXISTS `student_tracker`;
USE `student_tracker`;

CREATE TABLE if not exists user (
                        id int NOT NULL AUTO_INCREMENT,
                        usernamevarchar(45) DEFAULT NULL,
                        password varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;