-- 该文件用于存储数据库语句

CREATE DATABASE coal;

USE coal;

#煤流检验信息表
CREATE TABLE coalmine(
                         `index` INT NOT NULL AUTO_INCREMENT,
                         `area` INT,
                         `datetime` TIMESTAMP,
                         `type` VARCHAR(10),
                         `length` INT,
                         `width` INT,
                         PRIMARY KEY(`index`))

SELECT * FROM coalmine;

#用户信息表
CREATE TABLE users(
                      username VARCHAR(30) NOT NULL,
                      `password` VARCHAR(20) NOT NULL,
                      `type` ENUM('管理员','用户') NOT NULL,
                      email VARCHAR(30) NOT NULL,
                      PRIMARY KEY(username,`type`)
)

SELECT * FROM users;

CREATE TABLE workers(
                        job VARCHAR(30),
                        `name` VARCHAR(20),
                        phone VARCHAR(30))
    );


ALTER TABLE users CHANGE email phone VARCHAR(30);

CREATE TABLE auto_code(
                          id INT(11) AUTO_INCREMENT,
                          phone VARCHAR(30) NOT NULL,
                          `code` VARCHAR(30) NOT NULL,
                          createtime DATETIME NOT NULL,
                          endtime DATETIME NOT NULL,
                          PRIMARY KEY(`id`)
)

ALTER TABLE managers DROP email;

ALTER TABLE managers ADD company VARCHAR(40);

ALTER TABLE managers ADD phone VARCHAR(30);

UPDATE managers SET phone = '19880036651',company = '公司1';

DESC workers;

-- 进行主键的删除
ALTER TABLE `users` DROP PRIMARY KEY
ALTER TABLE `workers` DROP PRIMARY KEY;

-- 增加自增主键
ALTER TABLE `users` ADD id INT AUTO_INCREMENT PRIMARY KEY;
SELECT * FROM users

ALTER TABLE `users` ADD UNIQUE KEY(`username`);

DESC users;

SELECT * FROM workers;

CREATE TABLE device(
                       `id` INT AUTO_INCREMENT PRIMARY KEY,
                       `name` VARCHAR(30),
                       `area` INT,
                       startTime TIMESTAMP)

    SHOW TABLES;
ALTER TABLE `workers` ADD id INT AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE users DROP `type`;

CREATE TABLE coalException(
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              state TINYINT,
                              `time`  TIMESTAMP,
                              content TEXT
);

DESC device

INSERT INTO workers VALUES('区域1', 'hyb', '19880036651', 1);`coalmine``managers`

SELECT * FROM device

ALTER TABLE device MODIFY `area` VARCHAR(30);

SELECT * FROM workers;

DESC workers;




-- 新增加的条件

INSERT INTO workers VALUES('区域2', 'hby', '15389270371', NULL);

INSERT INTO workers VALUES('区域3', 'yl', '13359152051', NULL);

SELECT * FROM users

CREATE TABLE workers(
                        job VARCHAR(30),
                        `name` VARCHAR(20),
                        phone VARCHAR(30))
    );


ALTER TABLE users CHANGE email phone VARCHAR(30);

CREATE TABLE auto_code(
                          id INT(11) AUTO_INCREMENT,
                          phone VARCHAR(30) NOT NULL,
                          `code` VARCHAR(30) NOT NULL,
                          createtime DATETIME NOT NULL,
                          endtime DATETIME NOT NULL,
                          PRIMARY KEY(`id`)
)

ALTER TABLE managers DROP email;

ALTER TABLE managers ADD company VARCHAR(40);

ALTER TABLE managers ADD phone VARCHAR(30);

update managers set phone = '19880036651',company = '公司1';

desc workers;

-- 进行主键的删除
alter table `users` drop primary key
alter table `workers` drop primary key;

-- 增加自增主键
alter table `users` add id int auto_increment primary key;
select * from users

alter table `users` add unique key(`username`);

desc users;

select * from workers;

create table device(
                       `id` int auto_increment primary key,
                       `name` varchar(30),
                       `area` int,
                       startTime timestamp)

    show tables;
ALTER TABLE `workers` ADD id INT AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE users DROP `type`;

create table coalException(
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              state TINYINT,
                              `time`  TIMESTAMP,
                              content text
);

desc device

insert into workers values('区域1', 'hyb', '19880036651', 1);`coalmine``managers`

select * from device

alter table device modify `area` varchar(30);

select * from workers;

desc workers;




-- 新增加的条件

insert into workers values('区域2', 'hby', '15389270371', null);

INSERT INTO workers VALUES('区域3', 'yl', '13359152051', null);

select * from users

select * from coalexception













