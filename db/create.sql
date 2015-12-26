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

create table Friend0 (
	id int
);

create table Friend1 (
	id int
);

create table Friend2 (
	id int
);

create table OfflineMessage0 (
	type int,
	sender_id int,
	message_id int,
	time bigint,
	content varchar(255)
);

create table OfflineMessage0 (
	type int,
	sender_id int,
	message_id int,
	time bigint,
	content varchar(255)
);

create table OfflineMessage1 (
	type int,
	sender_id int,
	message_id int,
	time bigint,
	content varchar(255)
);

create table OfflineMessage2 (
	type int,
	sender_id int,
	message_id int,
	time bigint,
	content varchar(255)
);

#insert into Account values(0, "0",)
