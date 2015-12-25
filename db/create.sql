drop database JTalk;

create database JTalk;

use JTalk;

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
