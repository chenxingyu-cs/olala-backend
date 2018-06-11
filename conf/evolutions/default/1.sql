# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  id                            bigint auto_increment not null,
  email                         varchar(255),
  full_name                     varchar(255),
  password                      varchar(255),
  create_time                   datetime(6),
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists user;

