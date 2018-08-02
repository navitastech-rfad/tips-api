--liquibase formatted sql
--changeset Gopala.Vadlamani:2018-08-01-gopala-01
CREATE TABLE IF NOT EXISTS tips_info
(
   tips_id           UUID  ,
   first_name        VARCHAR(50),
   last_name        VARCHAR(50),
   email            VARCHAR(30),
   phone            VARCHAR(12),
   description        VARCHAR(1000)    NOT NULL,
   created_date     TIMESTAMP         ,
   updated_date     TIMESTAMP         ,
   CONSTRAINT tips_pk PRIMARY KEY (tips_id)
);
