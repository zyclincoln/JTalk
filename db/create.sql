drop database JTalk;

create database JTalk;

use JTalk;

create table Account(
	ID int,
	Password char(60),
	Name char(20),
	LoginTime char(30),
	LoginIP char(40),
	primary key (ID)
);

create table Friend1 (
	id int
);

create table Friend2 (
	id int
);

create table Friend3 (
	id int
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

create table OfflineMessage3 (
	type int,
	sender_id int,
	message_id int,
	time bigint,
	content varchar(255)
);

insert into Account values(1, "1", "1", "1", "1");
insert into Account values(2, "2", "2", "2", "2");
insert into Account values(3, "3", "3", "3", "3");
