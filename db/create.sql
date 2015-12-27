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

insert into Account values(1, "1", "one", "1", "1");
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
insert into OfflineMessage1 values(0, 2, 1, 1, "hello1");
insert into OfflineMessage1 values(0, 2, 2, 2, "hello2");
insert into OfflineMessage1 values(0, 2, 3, 3, "hello3");
insert into OfflineMessage1 values(0, 3, 1, 1, "hi1");
insert into OfflineMessage1 values(0, 3, 2, 2, "hi2");
insert into OfflineMessage1 values(0, 3, 3, 3, "hi3");



insert into Account values(2, "2", "two", "2", "2");
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



insert into Account values(3, "3", "three", "3", "3");
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


