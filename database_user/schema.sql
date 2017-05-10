CREATE TYPE yesNo AS ENUM('Y', 'N');
CREATE TYPE masFem AS ENUM('M', 'F');

create table if not exists AccountsTable (
  id int(10) unsigned not null AUTO_INCREMENT,
  username varchar(30) not null,
  email varchar(200) not null, 
  password varchar(200) not null,
  id_stato int(10) unsigned,
  primary key (id),
  foreign key (id_stato) references StatoTable(id_stato)
);

create table if not exists UsersTable (
  id int(10) unsigned not null,
  genere masFem, 
  data_di_nascita DATE, 
  id_istr int(10) unsigned,
  id_occ int(10) unsigned,
  ha_auto_privata yesNo, 
  auto_anno_immatricolazione int(4) unsigned, 
  id_carb int(10) unsigned,
  usa_car_sharing yesNo, 
  id_forn int(10) unsigned,
  usa_bike_sharing yesNo, 
  ha_bici_privata yesNo,
  usa_mezzi_pubblici yesNo,
  id_freq int(10) unsigned,
  primary key (id),
  foreign key (id) references AccountsTable(id),
  foreign key (id_istr) references IstrTable(id_istr),
  foreign key (id_occ) references OccTable(id_occ),
  foreign key (id_carb) references CarbTable(id_carb),
  foreign key (id_forn) references FornTable(id_forn),
  foreign key (id_freq) references FreqTable(id_freq)
);

create table if not exists IstrTable (
  id_istr int(10) unsigned not null,
  titolo_istr varchar(50) not null,
  primary key (id_istr)
);

create table if not exists OccTable (
  id_occ int(10) unsigned not null,
  tipo_occ varchar(50) not null,
  primary key (id_occ)
);

create table if not exists CarbTable (
  id_carb int(10) unsigned not null,
  tipo_carb varchar(50) not null,
  primary key (id_carb)
);

create table if not exists FornTable (
  id_forn int(10) unsigned not null,
  nome_forn varchar(50) not null,
  primary key (id_forn)
);

create table if not exists FornTable (
  id_freq int(10) unsigned not null,
  tipo_freq varchar(50) not null,
  primary key (id_freq)
);

create table if not exists StatoTable (
  id_stato int(10) unsigned not null,
  tipo_stato varchar(50) not null,
  primary key (id_stato)
);