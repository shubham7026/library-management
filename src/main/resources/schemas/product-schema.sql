CREATE DATABASE  IF NOT EXISTS `student_directory`;
USE `student_directory`;

create table if not exists product (
    id int PRIMARY KEY,
    name varchar(20),
    description varchar(100),
    price decimal(8,3)

);