CREATE TYPE yesNo AS ENUM('Y', 'N');
CREATE TYPE masFem AS ENUM('M', 'F');

create table if not exists IstrTable (
  id_istr bigint not null,
  nome varchar(50) not null,
  primary key (id_istr)
);

create table if not exists OccTable (
  id_occ bigint not null,
  nome varchar(50) not null,
  primary key (id_occ)
);

create table if not exists CarbTable (
  id_carb bigint not null,
  nome varchar(50) not null,
  primary key (id_carb)
);

create table if not exists FornTable (
  id_forn bigint not null,
  nome varchar(50) not null,
  primary key (id_forn)
);

create table if not exists FreqTable (
  id_freq bigint not null,
  nome varchar(50) not null,
  primary key (id_freq)
);

create table if not exists StatoTable (
  id_stato bigint not null,
  nome varchar(50) not null,
  primary key (id_stato)
);

create table if not exists AccountsTable (
  id SERIAL,
  username varchar(30) not null,
  email varchar(200) not null,
  password varchar(200) not null,
  id_stato bigint,
  primary key (id),
  foreign key (id_stato) references StatoTable(id_stato)
);

create table if not exists ProfilesTable (
  id bigint not null,
  genere masFem,
  data_di_nascita DATE,
  id_istr bigint,
  id_occ bigint,
  ha_auto_privata yesNo,
  auto_anno_immatricolazione smallint,
  id_carb bigint,
  usa_car_sharing yesNo,
  id_forn bigint,
  usa_bike_sharing yesNo,
  ha_bici_privata yesNo,
  usa_mezzi_pubblici yesNo,
  id_freq bigint,
  primary key (id),
  foreign key (id) references AccountsTable(id),
  foreign key (id_istr) references IstrTable(id_istr),
  foreign key (id_occ) references OccTable(id_occ),
  foreign key (id_carb) references CarbTable(id_carb),
  foreign key (id_forn) references FornTable(id_forn),
  foreign key (id_freq) references FreqTable(id_freq)
);
