drop database JTalk;

create database JTalk;

use JTalk;

create table Account(
	ID int AUTO_INCREMENT,
	Password char(60),
	Name char(20),
	LoginTime char(30),
	LoginIP char(40),
	primary key (ID)
);

insert into Account values(1, "1", "我是one", "1", "1");
create table Friend1 (
	id int primary key
);
create table OfflineMessage1 (
	type int,
	sender_id int,
	message_id int,
	time bigint,
	content varchar(255)
);
insert into Friend1 values(2);
insert into Friend1 values(3);
insert into OfflineMessage1 values(0, 2, 1, 1451304200000, "hello1");
insert into OfflineMessage1 values(0, 2, 2, 1451304210000, "hello2");
insert into OfflineMessage1 values(0, 2, 3, 1451304220000, "hello3");
insert into OfflineMessage1 values(0, 3, 1, 1451304230000, "hi1");
insert into OfflineMessage1 values(0, 3, 2, 1451304240000, "hi2");
insert into OfflineMessage1 values(0, 3, 3, 1451304250000, "hi3");



insert into Account values(2, "2", "我是two", "2", "2");
create table Friend2 (
	id int primary key
);
create table OfflineMessage2 (
	type int,
	sender_id int,
	message_id int,
	time bigint,
	content varchar(255)
);
insert into Friend2 values(1);
insert into Friend2 values(3);



insert into Account values(3, "3", "我是three", "3", "3");
create table Friend3 (
	id int primary key
);
create table OfflineMessage3 (
	type int,
	sender_id int,
	message_id int,
	time bigint,
	content varchar(255)
);
insert into Friend3 values(1);
insert into Friend3 values(2);


