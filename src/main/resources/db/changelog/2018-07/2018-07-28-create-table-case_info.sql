--liquibase formatted sql
--changeset Jonathan.Solomon:2018-07-26-jonathan-01
CREATE TABLE IF NOT EXISTS case_info
(
    case_id       	Serial          NOT NULL,
    created_by		UUID 			NOT NULL,
    benefit_applied VARCHAR(10)		NOT NULL,		
    title       	VARCHAR(50)     NOT NULL,
    first_name		VARCHAR(50) 	NOT NULL,
    last_name		VARCHAR(50)		NOT NULL,
    address			VARCHAR(50)		NOT NULL,
    city			VARCHAR(30)		NOT NULL,
    state			CHAR(2)			NOT NULL,
    updated_by		UUID 			NOT NULL,
    created_date 	TIMESTAMP 		NOT NULL DEFAULT NOW(),
    updated_date 	TIMESTAMP 		NOT NULL DEFAULT NOW(),
    CONSTRAINT case_pk PRIMARY KEY (case_id)
);
