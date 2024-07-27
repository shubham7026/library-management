CREATE DATABASE  IF NOT EXISTS `student_directory`;
USE `student_directory`;

CREATE TABLE if not exists user (
                        id int NOT NULL AUTO_INCREMENT,
                        username varchar(45) DEFAULT NULL,
                        password varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

USE `student_directory`;
CREATE TABLE if not exists `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;