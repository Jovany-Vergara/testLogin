/*
 REM **************************************************************************
 REM Nombre del Script: users
 REM Proyecto: Test Login
 REM --------------------------------------------------------------------------
 REM AUDIT TRAIL: Version 1
 REM Realizado por: JVM el 06 de enero de 2023
 */

-- DROP SEQUENCE users;
-- DROP TABLE users;

CREATE TABLE users(
   id SERIAL PRIMARY KEY,
   name VARCHAR NOT NULL,
   password VARCHAR NOT NULL
);
