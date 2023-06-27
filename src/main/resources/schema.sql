--/*
-- Navicat Premium Data Transfer
--
-- Source Server         : Wakashan ASR AWS
-- Source Server Type    : PostgreSQL
-- Source Server Version : 120005
-- Source Host           : wakashan-asr-pgsql1.cljtnhnuesfp.us-west-2.rds.amazonaws.com:5432
-- Source Catalog        : postgres
-- Source Schema         : public
--
-- Target Server Type    : PostgreSQL
-- Target Server Version : 120005
-- File Encoding         : 65001
--
-- Date: 16/03/2021 14:09:57
--*/
--
-- ----------------------------
-- Sequence structure for collection_sets_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS collection_sets_id_seq;


CREATE SEQUENCE collection_sets_id_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START WITH 1 CACHE 1;DROP SEQUENCE IF EXISTS phrases_seq;CREATE SEQUENCE phrases_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1 CACHE 1;-- ----------------------------
-- Sequence structure for user_phrase_comments_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS user_phrase_comments_id_seq;CREATE SEQUENCE user_phrase_comments_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;-- ----------------------------
-- Sequence structure for user_phrases_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS user_phrases_id_seq;CREATE SEQUENCE user_phrases_id_seq
  INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;-- ----------------------------
-- Sequence structure for users_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS users_id_seq;CREATE SEQUENCE users_id_seq INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;-- ----------------------------
-- Table structure for phrase_sets
-- ----------------------------
DROP TABLE IF EXISTS phrase_sets;

CREATE TABLE IF NOT EXISTS phrase_sets(
  id int4 NOT NULL,
--   DEFAULT nextval('collection_sets_id_seq' :: regclass),
  phrase_set_name varchar(255) COLLATE pg_catalog.default NOT NULL,
  start_date date NOT NULL,
  end_date date
);-- ----------------------------
-- Table structure for phrases
-- ----------------------------
DROP TABLE IF EXISTS phrases;CREATE TABLE phrases(
  id int4 NOT NULL,
--  DEFAULT nextval('phrases_seq' :: regclass),
  phrase_set_id int4 NOT NULL,
  phrase varchar(255) COLLATE pg_catalog.default NOT NULL,
  english varchar(255) COLLATE pg_catalog.default,
  example_path varchar(255) COLLATE pg_catalog.default,
  enabled boolean
);COMMENT ON COLUMN phrases.phrase_set_id IS 'what recording set is this';COMMENT ON COLUMN phrases.phrase IS 'phrase in langauge';COMMENT ON COLUMN phrases.example_path IS 'example audio path';-- ----------------------------
-- Table structure for user_phrase_comments
-- ----------------------------
DROP TABLE IF EXISTS user_phrase_comments;CREATE TABLE user_phrase_comments (
  id int4 NOT NULL,
--   DEFAULT nextval('user_phrase_comments_id_seq' :: regclass),
  phrase_id int4,
  comment varchar(255) COLLATE pg_catalog.default,
  date_time timestamp(6) NOT NULL DEFAULT now(),
  user_id int4
);-- ----------------------------
-- Table structure for user_phrases
-- ----------------------------
DROP TABLE IF EXISTS user_phrases;CREATE TABLE user_phrases (
  id int4 NOT NULL,
--   DEFAULT nextval('user_phrases_id_seq' :: regclass),
  phrase_id int4 NOT NULL,
  user_id int4 NOT NULL,
  file_hash varchar(255) unique,
  file_is_valid boolean,
  delivered boolean, -- delivered to user
  date_time timestamp(6) NOT NULL DEFAULT now(),
  file_path varchar(255) COLLATE pg_catalog.default
);-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS users;CREATE TABLE users (
  id int4 NOT NULL,
--   DEFAULT nextval('users_id_seq' :: regclass),
  email varchar(255) COLLATE pg_catalog.default NOT NULL,
  first_name varchar(255) COLLATE pg_catalog.default NOT NULL,
  last_name varchar(255) COLLATE pg_catalog.default NOT NULL,
  project varchar(255) COLLATE pg_catalog.default
);-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE collection_sets_id_seq OWNED BY phrase_sets.id;
SELECT
  setval('collection_sets_id_seq', 2, false);-- ----------------------------
  -- Alter sequences owned by
  -- ----------------------------
  ALTER SEQUENCE phrases_seq OWNED BY phrases.id;
SELECT
  setval('phrases_seq', 2, false);-- ----------------------------
  -- Alter sequences owned by
  -- ----------------------------
  ALTER SEQUENCE user_phrase_comments_id_seq OWNED BY user_phrase_comments.id;
SELECT
  setval('user_phrase_comments_id_seq', 2, false);-- ----------------------------
  -- Alter sequences owned by
  -- ----------------------------
  ALTER SEQUENCE user_phrases_id_seq OWNED BY user_phrases.id;
SELECT
  setval('user_phrases_id_seq', 2, false);-- ----------------------------
  -- Alter sequences owned by
  -- ----------------------------
  ALTER SEQUENCE users_id_seq OWNED BY users.id;
SELECT
  setval('users_id_seq', 2, false);-- ----------------------------
  -- Primary Key structure for table phrase_sets
  -- ----------------------------
ALTER TABLE
  phrase_sets
ADD
  CONSTRAINT collection_sets_pkey PRIMARY KEY (id);-- ----------------------------
  -- Primary Key structure for table phrases
  -- ----------------------------
ALTER TABLE
  phrases
ADD
  CONSTRAINT phrases_pkey PRIMARY KEY (id);-- ----------------------------
  -- Indexes structure for table user_phrase_comments
  -- ----------------------------
  CREATE INDEX user_phrase_comments_phrase_id_idx ON user_phrase_comments USING btree (phrase_id pg_catalog.int4_ops ASC NULLS LAST);-- ----------------------------
  -- Primary Key structure for table user_phrase_comments
  -- ----------------------------
ALTER TABLE
  user_phrase_comments
ADD
  CONSTRAINT user_phrase_comments_pkey PRIMARY KEY (id);-- ----------------------------
  -- Indexes structure for table user_phrases
  -- ----------------------------
  CREATE INDEX user_phrases_phrase_id_idx ON user_phrases USING btree (phrase_id pg_catalog.int4_ops ASC NULLS LAST);CREATE INDEX user_phrases_user_id_idx ON user_phrases USING btree (user_id pg_catalog.int4_ops ASC NULLS LAST);-- ----------------------------
  -- Primary Key structure for table user_phrases
  -- ----------------------------
ALTER TABLE
  user_phrases
ADD
  CONSTRAINT user_phrases_pkey PRIMARY KEY (id);-- ----------------------------
  -- Uniques structure for table users
  -- ----------------------------
ALTER TABLE
  users
ADD
  CONSTRAINT email UNIQUE (email);-- ----------------------------
  -- Primary Key structure for table users
  -- ----------------------------
ALTER TABLE
  users
ADD
  CONSTRAINT users_pkey PRIMARY KEY (id);-- ----------------------------
  -- Foreign Keys structure for table phrases
  -- ----------------------------
ALTER TABLE
  phrases
ADD
  CONSTRAINT phrases_phrase_set_fkey FOREIGN KEY (phrase_set_id) REFERENCES phrase_sets (id) ON DELETE NO ACTION ON UPDATE NO ACTION;-- ----------------------------
  -- Foreign Keys structure for table user_phrase_comments
  -- ----------------------------
ALTER TABLE
  user_phrase_comments
ADD
  CONSTRAINT user_phrase_comments_phrase_id_fkey FOREIGN KEY (phrase_id) REFERENCES phrases (id) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE
  user_phrase_comments
ADD
  CONSTRAINT user_phrase_comments_user_id_fkey FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION;-- ----------------------------
  -- Foreign Keys structure for table user_phrases
  -- ----------------------------
ALTER TABLE
  user_phrases
ADD
  CONSTRAINT user_phrases_phrase_id_fkey FOREIGN KEY (phrase_id) REFERENCES phrases (id) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE
  user_phrases
ADD
  CONSTRAINT user_phrases_user_id_fkey FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION;

--create view user_phrase_count AS
--SELECT u.user_id, u.phrase_id, u.phrase_set_id, COALESCE(c, 0) AS c
--FROM (
--  SELECT u.id AS user_id, p.id AS phrase_id, p.phrase_set_id
--  FROM users u
--  FULL JOIN phrases p ON TRUE
--) AS u
--LEFT JOIN (
--  SELECT up.user_id, p.id AS phrase_id, COUNT(*) AS c
--  FROM user_phrases up
--  FULL OUTER JOIN phrases p ON up.phrase_id = p.id
--  WHERE up.user_id IS NOT NULL
--  GROUP BY p.id, up.user_id
--) AS up
--ON u.user_id = up.user_id AND u.phrase_id = up.phrase_id;

--CREATE VIEW user_phrase_count AS
--SELECT ROW_NUMBER() OVER (ORDER BY u.user_id, u.phrase_id) AS id,
--       u.user_id,
--       u.phrase_id,
--       u.phrase_set_id,
--       COALESCE(c, 0) AS c
--FROM (
--  SELECT u.id AS user_id, p.id AS phrase_id, p.phrase_set_id
--  FROM users u
--  FULL JOIN phrases p ON TRUE
--) AS u
--LEFT JOIN (
--  SELECT up.user_id, p.id AS phrase_id, COUNT(*) AS c
--  FROM user_phrases up
--  FULL OUTER JOIN phrases p ON up.phrase_id = p.id
--  WHERE up.user_id IS NOT NULL
--  GROUP BY p.id, up.user_id
--) AS up
--ON u.user_id = up.user_id AND u.phrase_id = up.phrase_id;
