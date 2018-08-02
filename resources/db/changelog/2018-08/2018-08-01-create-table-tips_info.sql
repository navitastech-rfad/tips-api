--liquibase formatted sql
--changeset Jonathan.Solomon:2018-08-01-jonathan-01
CREATE TABLE IF NOT EXISTS tips_info
(
    tips_id       	UUID       		DEFAULT gen_random_uuid(),
    first_name		VARCHAR(50),
    last_name		VARCHAR(50),
    email			VARCHAR(30),
    phone			VARCHAR(12),
    description		VARCHAR(1000)	NOT NULL,
    created_date 	TIMESTAMP 		NOT NULL DEFAULT NOW(),
    updated_date 	TIMESTAMP 		NOT NULL DEFAULT NOW(),
    CONSTRAINT tips_pk PRIMARY KEY (tips_id)
);
