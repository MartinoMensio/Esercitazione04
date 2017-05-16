create table if not exists topics(
  id bigint not null,
  value varchar(50) not null,
  primary key (id)
);


create table if not exists messages (
  id BIGSERIAL,
  sender_id bigint not null,
  text varchar(2000) not null,
  sending_time timestamp not null,
  topic_id bigint not null,
  primary key (id),
  foreign key (sender_id) references users(id),
  foreign key (topic_id) references topics(id)
);

create table if not exists images (
  id BIGSERIAL not null,
  value BYTEA not null,
  primary key (id)
)
