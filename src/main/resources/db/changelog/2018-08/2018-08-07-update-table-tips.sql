--liquibase formatted sql
--changeset Gopala.Vadlamani:2018-08-07-gopala-01
ALTER TABLE tips_info ADD COLUMN IF NOT EXISTS company VARCHAR(500);
ALTER TABLE tips_info ADD COLUMN IF NOT EXISTS status VARCHAR(500);
ALTER TABLE tips_info ADD COLUMN IF NOT EXISTS analytical_output VARCHAR(5000);
ALTER TABLE tips_info ADD COLUMN IF NOT EXISTS tips_comment VARCHAR(5000);
