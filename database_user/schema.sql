CREATE TYPE masFem AS ENUM('M', 'F');

create table if not exists educationLevels (
  id bigint not null,
  value varchar(50) not null,
  primary key (id)
);

create table if not exists employments (
  id bigint not null,
  value varchar(100) not null,
  primary key (id)
);

create table if not exists fuels (
  id bigint not null,
  value varchar(50) not null,
  primary key (id)
);

create table if not exists carSharingServices (
  id bigint not null,
  name varchar(50) not null,
  primary key (id)
);

create table if not exists travelDocuments (
  id bigint not null,
  name varchar(50) not null,
  cost real,
  description varchar(1000),
  primary key (id)
);

create table if not exists status (
  id bigint not null,
  value varchar(50) not null,
  primary key (id)
);

create table if not exists users (
  id SERIAL,
  nickname varchar(30) not null,
  email varchar(200) not null,
  password varchar(200) not null,
  status_id bigint,
  primary key (id),
  foreign key (status_id) references status(id)
);

create table if not exists userProfiles (
  id bigint not null,
  sex masFem,
  dateOfBirth DATE,
  education_level_id bigint,
  employment_id bigint,
  privateCarOwnership boolean,
  carRegistrationYear smallint,
  fuel_id bigint,
  carSharingUsage boolean,
  car_sharing_service_id bigint,
  bikeUsage boolean,
  privateBikeUsage boolean,
  bikeSharingUsage boolean,
  publicTransportUsage boolean,
  habitual_travel_document_id bigint,
  primary key (id),
  foreign key (id) references users(id),
  foreign key (education_level_id) references educationLevels(id),
  foreign key (employment_id) references employments(id),
  foreign key (fuel_id) references fuels(id),
  foreign key (car_sharing_service_id) references carSharingServices(id),
  foreign key (habitual_travel_document_id) references travelDocuments(id)
);
