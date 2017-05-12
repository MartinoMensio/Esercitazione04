CREATE TYPE masFem AS ENUM('M', 'F');

create table if not exists education_levels (
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

create table if not exists car_sharing_services (
  id bigint not null,
  name varchar(50) not null,
  primary key (id)
);

create table if not exists travel_documents (
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
  id BIGSERIAL,
  nickname varchar(30) not null,
  email varchar(200) not null unique,
  password varchar(200) not null,
  status_id bigint,
  primary key (id),
  foreign key (status_id) references status(id)
);

create table if not exists user_profiles (
  id bigint not null,
  sex masFem,
  date_of_birth DATE,
  education_level_id bigint,
  employment_id bigint,
  private_car_ownership boolean,
  car_registration_year integer,
  fuel_id bigint,
  car_sharing_usage boolean,
  car_sharing_service_id bigint,
  bike_usage boolean,
  private_bike_usage boolean,
  bike_sharing_usage boolean,
  public_transport_usage boolean,
  habitual_travel_document_id bigint,
  primary key (id),
  foreign key (id) references users(id),
  foreign key (education_level_id) references education_levels(id),
  foreign key (employment_id) references employments(id),
  foreign key (fuel_id) references fuels(id),
  foreign key (car_sharing_service_id) references car_sharing_services(id),
  foreign key (habitual_travel_document_id) references travel_documents(id)
);
