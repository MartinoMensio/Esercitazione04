create table if not exists MessagesTable (
  id numeroutente not null,
  text varchar(2000) not null,
  ora_di_invio timestamp not null,
  topic varchar(20) not null,
  primary key (id, ora_di_invio, topic),
  foreign key (id) references UsersTable(id)
);