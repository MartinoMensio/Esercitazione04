create table if not exists topics(
  id bigint not null,
  value varchar(50) not null,
  primary key (id)
);


create table if not exists messages (
  id_sender bigint not null,
  text varchar(2000) not null,
  sending_time timestamp not null,
  id_topic bigint not null,
  primary key (id_sender, sending_time, id_topic),
  foreign key (id_sender) references users(id),
  foreign key (id_topic) references topics(id)
);