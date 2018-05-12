
create database ojssgroup4;

create table job_seeker (

id int(16) not null auto_increment,
pwd varchar(30) not null,
phone_number int(20),
email varchar(30),
address varchar(30),
suburb varchar(20),
postcode int(8),
fname varchar(20),
lname varchar(20),
exp varchar(3000),
nick_name varchar(30),
state varchar(20),
primary key (id),
unique (nick_name)
);

create table job_recruiter (

id int(16) not null auto_increment,
pwd varchar(30) not null,
address varchar(30),
suburb varchar(20),
postcode int(8),
phone_number int(20),
email varchar(30),
state varchar(20),
intro varchar(2000),
busi_name varchar(30),
nick_name varchar(30),
primary key (id),
unique (nick_name)
);