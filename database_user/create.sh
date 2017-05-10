#!/bin/sh

DB_NAME=lab4

export PGPASSWORD=ai-user-password

dropdb -h localhost -U postgres $DB_NAME
createdb -h localhost -U postgres $DB_NAME
psql -h localhost -U postgres -d $DB_NAME -f schema.sql
psql -h localhost -U postgres -d $DB_NAME -f tabelle_valori.sql
psql -h localhost -U postgres -d $DB_NAME -f utenti_esempio.sql
