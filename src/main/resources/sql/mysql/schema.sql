drop table if exists sky_task;
drop table if exists sky_user;
drop table if exists sky_mobilesession;
drop table if exists sky_resource;

create table sky_mobilesession (
	id bigint auto_increment,
	user_id bigint not null,
	mobilesession varchar(32) not null,
    primary key (id)
) engine=InnoDB;

create table sky_resource (
	id bigint auto_increment,
	title varchar(128) not null,
	url varchar(255),
	user_id bigint not null,
	resource_type varchar(32) not null,
	extension varchar(32) not null,
    primary key (id)
) engine=InnoDB;

create table sky_task (
	id bigint auto_increment,
	title varchar(128) not null,
	description varchar(255),
	user_id bigint not null,
    primary key (id)
) engine=InnoDB;

create table sky_user (
	id bigint auto_increment,
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64) not null,
	roles varchar(255) not null,
	register_date timestamp not null default 0,
	primary key (id)
) engine=InnoDB;