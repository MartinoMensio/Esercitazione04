CREATE TYPE yesNo AS ENUM('Y', 'N');
CREATE TYPE masFem AS ENUM('M', 'F');
CREATE TYPE istruzione AS ENUM('LICENZA ELEMENTARE', 'LICENZA MEDIA', 'DIPLOMA DI ISTRUZIONE SECONDARIA SUPERIORE', 'LAUREA DI PRIMO LIVELLO', 'LAUREA SPECIALISTICA', 'MASTER UNIVERSITARIO DI PRIMO LIVELLO', 'MASTER UNIVERSITARIO DI SECONDO LIVELLO');
CREATE TYPE occ AS ENUM('STUDENTE', 'DISOCCUPATO', 'OCCUPATO AUTONOMO', 'OCCUPATO PERMANENTE', 'OCCUPATO TEMPORANEO', 'PENSIONATO');
CREATE TYPE carb AS ENUM ('BENZINA', 'DIESEL', 'GPL', 'GASOLIO', 'METANO', 'AUTO ELETTRICA');
CREATE TYPE forn AS ENUM('ENJOY', 'CAR2GO', 'BLUETORINO');
CREATE TYPE freq AS ENUM('BUS', 'TRAM', 'METRO', 'TAXI');
CREATE TYPE stato AS ENUM('AUTENTICATO', 'NON_AUTENTICATO', 'BANNATO');
create table if not exists UsersTable (
  username varchar(30) not null,
  email varchar(200) not null,
  password varchar(200) not null,
  genere masFem, 
  data_di_nascita  DATE, 
  livello_istruzione istruzione, 
  occupazione occ, 
  ha_auto_privata yesNo, 
  auto_anno_immatricolazione Int, 
  auto_tipo_carburante carb, 
  usa_car_sharing yesNo, 
  car_sharing_fornitore forn, 
  usa_bike_sharing yesNo, 
  ha_bici_privata yesNo,
  usa_mezzi_pubblici yesNo,
  titolo_viaggio_frequente freq, 
  stato_utente stato,
  primary key (email)
);