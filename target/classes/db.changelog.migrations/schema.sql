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
CREATE SCHEMA IF NOT EXISTS "public";
-- ----------------------------
-- Sequence structure for collection_sets_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."collection_sets_id_seq";
CREATE SEQUENCE "public"."collection_sets_id_seq"
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for phrases_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."phrases_seq";
CREATE SEQUENCE "public"."phrases_seq"
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for user_phrase_comments_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_phrase_comments_id_seq";
CREATE SEQUENCE "public"."user_phrase_comments_id_seq"
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for user_phrases_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."user_phrases_id_seq";
CREATE SEQUENCE "public"."user_phrases_id_seq"
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for users_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."users_id_seq";
CREATE SEQUENCE "public"."users_id_seq"
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Table structure for phrase_sets
-- ----------------------------
DROP TABLE IF EXISTS "public"."phrase_sets";
CREATE TABLE "public"."phrase_sets" (
  "id" int4 NOT NULL DEFAULT nextval('collection_sets_id_seq'::regclass),
  "phrase_set_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "start_date" date NOT NULL,
  "end_date" date
)
;

-- ----------------------------
-- Table structure for phrases
-- ----------------------------
DROP TABLE IF EXISTS "public"."phrases";
CREATE TABLE "public"."phrases" (
  "id" int4 NOT NULL DEFAULT nextval('phrases_seq'::regclass),
  "phrase_set_id" int4 NOT NULL,
  "phrase" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "english" varchar(255) COLLATE "pg_catalog"."default",
  "example_path" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."phrases"."phrase_set_id" IS 'what recording set is this';
COMMENT ON COLUMN "public"."phrases"."phrase" IS 'phrase in langauge';
COMMENT ON COLUMN "public"."phrases"."example_path" IS 'example audio path';

-- ----------------------------
-- Table structure for user_phrase_comments
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_phrase_comments";
CREATE TABLE "public"."user_phrase_comments" (
  "id" int4 NOT NULL DEFAULT nextval('user_phrase_comments_id_seq'::regclass),
  "phrase_id" int4,
  "comment" varchar(255) COLLATE "pg_catalog"."default",
  "date_time" timestamp(6) NOT NULL DEFAULT now(),
  "user_id" int4
)
;

-- ----------------------------
-- Table structure for user_phrases
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_phrases";
CREATE TABLE "public"."user_phrases" (
  "id" int4 NOT NULL DEFAULT nextval('user_phrases_id_seq'::regclass),
  "phrase_id" int4 NOT NULL,
  "user_id" int4 NOT NULL,
  "date_time" timestamp(6) NOT NULL DEFAULT now(),
  "file_path" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
  "id" int4 NOT NULL DEFAULT nextval('users_id_seq'::regclass),
  "email" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "first_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "last_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "project" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."collection_sets_id_seq"
OWNED BY "public"."phrase_sets"."id";
SELECT setval('"public"."collection_sets_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."phrases_seq"
OWNED BY "public"."phrases"."id";
SELECT setval('"public"."phrases_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user_phrase_comments_id_seq"
OWNED BY "public"."user_phrase_comments"."id";
SELECT setval('"public"."user_phrase_comments_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."user_phrases_id_seq"
OWNED BY "public"."user_phrases"."id";
SELECT setval('"public"."user_phrases_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."users_id_seq"
OWNED BY "public"."users"."id";
SELECT setval('"public"."users_id_seq"', 2, false);

-- ----------------------------
-- Primary Key structure for table phrase_sets
-- ----------------------------
ALTER TABLE "public"."phrase_sets" ADD CONSTRAINT "collection_sets_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table phrases
-- ----------------------------
ALTER TABLE "public"."phrases" ADD CONSTRAINT "phrases_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_phrase_comments
-- ----------------------------
CREATE INDEX "user_phrase_comments_phrase_id_idx" ON "public"."user_phrase_comments" USING btree (
  "phrase_id" "pg_catalog"."int4_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_phrase_comments
-- ----------------------------
ALTER TABLE "public"."user_phrase_comments" ADD CONSTRAINT "user_phrase_comments_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_phrases
-- ----------------------------
CREATE INDEX "user_phrases_phrase_id_idx" ON "public"."user_phrases" USING btree (
  "phrase_id" "pg_catalog"."int4_ops" ASC NULLS LAST
);
CREATE INDEX "user_phrases_user_id_idx" ON "public"."user_phrases" USING btree (
  "user_id" "pg_catalog"."int4_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_phrases
-- ----------------------------
ALTER TABLE "public"."user_phrases" ADD CONSTRAINT "user_phrases_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD CONSTRAINT "email" UNIQUE ("email");

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD CONSTRAINT "users_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table phrases
-- ----------------------------
ALTER TABLE "public"."phrases" ADD CONSTRAINT "phrases_phrase_set_fkey" FOREIGN KEY ("phrase_set_id") REFERENCES "public"."phrase_sets" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_phrase_comments
-- ----------------------------
ALTER TABLE "public"."user_phrase_comments" ADD CONSTRAINT "user_phrase_comments_phrase_id_fkey" FOREIGN KEY ("phrase_id") REFERENCES "public"."phrases" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."user_phrase_comments" ADD CONSTRAINT "user_phrase_comments_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "public"."users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_phrases
-- ----------------------------
ALTER TABLE "public"."user_phrases" ADD CONSTRAINT "user_phrases_phrase_id_fkey" FOREIGN KEY ("phrase_id") REFERENCES "public"."phrases" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."user_phrases" ADD CONSTRAINT "user_phrases_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "public"."users" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
