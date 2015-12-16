drop database JTalk;

create database JTalk;

use JTalk;

create table OfflineMessage0 (
	sender_id int,
	message_id int,
	time bigint,
	content varchar(255)
);
