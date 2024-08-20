CREATE DATABASE  IF NOT EXISTS `student_directory`;
USE `student_directory`;



--create table if not exists taco_order (
--        id BIGINT,
--        delivery_Name varchar(50) not null,
--        delivery_Street varchar(50) not null,
--        delivery_City varchar(50) not null,
--        delivery_State varchar(2) not null,
--        delivery_Zip varchar(10) not null,
--        cc_number varchar(16) not null,
--        cc_expiration varchar(5) not null,
--        cc_cvv varchar(3) not null,
--        placed_at timestamp not null
--);
--
--create table if not exists taco (
--id BIGINT,
--name varchar(50) not null,
--taco_order BIGINT not null,
--taco_order_key bigint not null,
--created_at timestamp not null
--);
--alter table taco add foreign key (taco_order) references taco_order(id);



CREATE TABLE if not exists Ingredient (
                        id varchar(5) NOT NULL ,
                        name varchar(20) DEFAULT NULL,
                        type varchar(15) DEFAULT NULL,
                        PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--create table if not exists ingredient_ref (
--        ingredient varchar(4) not null,
--        taco bigint not null,
--        taco_key bigint not null
--);
--
--alter table ingredient_ref add foreign key (ingredient) references ingredient(id);