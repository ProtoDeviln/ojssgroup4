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
create table skill (
skill_id varchar(16) not null,
skill char(20) not null,
user_id varchar(16) not null,
primary key (skill_id),
foreign key (user_id)
	references userAccount(user_id)
);

create table recruiter (
user_id varchar(16) not null,
business_name text(100) not null,
business_descrip text(1000) not null,
primary key (user_id),
foreign key (user_id)
	references userAccount(user_id)
);

create table job (
jb_id varchar(16) not null,
jb_name char(30) not null,
jb_unit_street_No char(30),
jb_street char(30),
jb_suburb char(30),
jb_postcode varchar(4),
jb_state varchar(3),
jb_sal int,
job_cat char(20) not null,
job_desc text(1000),
job_type char(20) not null,
user_id varchar(16) not null,
primary key (jb_id),
foreign key (user_id)
	references userAccount(user_id)
);

create table invitation (
in_id varchar(16) not null,
jb_id varchar(16) not null,
re_id varchar(16) not null,
js_id varchar(16) not null,
detail text(1000),
primary key (in_id),
foreign key (jb_id)
	references job(jb_id),
foreign key (re_id)
	references recruiter(user_id),
foreign key (js_id)
	references jobSeeker(user_id)
);



insert into userAccount values ('12345678','Yao Zhao','zy19941104','0450791191','437207532@qq.com', '180','city rd','southbank','3006','VIC');
insert into jobSeeker values ('12345678','Yao','Zhao','general seceretary of People of Republic China');
insert into skill values ('87654321','java','12345678');
insert into recruiter values ('12345678','OJSS','Fuck FIT5136');
insert into job values ('abcdefgh','abc','180','city rd','southbank','3006','VIC',15,'abc','def','bvc','12345678');
insert into invitation values ('aaaaaaaa','abcdefgh','12345678','12345678','fuck fit5136');



select * from userAccount;
select * from jobSeeker;
select * from skill;
select * from recruiter;
select * from job;
select * from invitation;

drop table userAccount;
drop table jobSeeker;
drop table skill;
drop table recruiter;
drop table job;
drop table invitation;