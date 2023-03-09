--
-- PostgreSQL database dump
--

-- Dumped from database version 13.5 (Debian 13.5-1.pgdg110+1)
-- Dumped by pg_dump version 14.6 (Homebrew)

-- Started on 2023-01-31 16:43:05 PST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3053 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 16394)
-- Name: phrase_sets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.phrase_sets (
    id integer NOT NULL,
    phrase_set_name character varying(255) NOT NULL,
    start_date date NOT NULL,
    end_date date
);


ALTER TABLE public.phrase_sets OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16384)
-- Name: collection_sets_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.collection_sets_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public.collection_sets_id_seq OWNER TO postgres;

--
-- TOC entry 3054 (class 0 OID 0)
-- Dependencies: 200
-- Name: collection_sets_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.collection_sets_id_seq OWNED BY public.phrase_sets.id;


--
-- TOC entry 210 (class 1259 OID 16457)
-- Name: databasechangeloglock; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);


ALTER TABLE public.databasechangeloglock OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16397)
-- Name: phrases; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.phrases (
    id integer NOT NULL,
    phrase_set_id integer NOT NULL,
    phrase character varying(255) NOT NULL,
    english character varying(255),
    example_path character varying(255)
);


ALTER TABLE public.phrases OWNER TO postgres;

--
-- TOC entry 3055 (class 0 OID 0)
-- Dependencies: 206
-- Name: COLUMN phrases.phrase_set_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.phrases.phrase_set_id IS 'what recording set is this';


--
-- TOC entry 3056 (class 0 OID 0)
-- Dependencies: 206
-- Name: COLUMN phrases.phrase; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.phrases.phrase IS 'phrase in langauge';


--
-- TOC entry 3057 (class 0 OID 0)
-- Dependencies: 206
-- Name: COLUMN phrases.example_path; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.phrases.example_path IS 'example audio path';


--
-- TOC entry 201 (class 1259 OID 16386)
-- Name: phrases_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.phrases_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.phrases_seq OWNER TO postgres;

--
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 201
-- Name: phrases_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.phrases_seq OWNED BY public.phrases.id;


--
-- TOC entry 207 (class 1259 OID 16403)
-- Name: user_phrase_comments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_phrase_comments (
    id integer NOT NULL,
    phrase_id integer,
    comment character varying(255),
    date_time timestamp(6) without time zone DEFAULT now() NOT NULL,
    user_id integer
);


ALTER TABLE public.user_phrase_comments OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16388)
-- Name: user_phrase_comments_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_phrase_comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public.user_phrase_comments_id_seq OWNER TO postgres;

--
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 202
-- Name: user_phrase_comments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_phrase_comments_id_seq OWNED BY public.user_phrase_comments.id;


--
-- TOC entry 208 (class 1259 OID 16407)
-- Name: user_phrases; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_phrases (
    id integer NOT NULL,
    phrase_id integer NOT NULL,
    user_id integer NOT NULL,
    date_time timestamp(6) without time zone DEFAULT now() NOT NULL,
    file_path character varying(255)
);


ALTER TABLE public.user_phrases OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16390)
-- Name: user_phrases_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_phrases_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public.user_phrases_id_seq OWNER TO postgres;

--
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 203
-- Name: user_phrases_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_phrases_id_seq OWNED BY public.user_phrases.id;


--
-- TOC entry 209 (class 1259 OID 16411)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(255) NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    project character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16392)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 204
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 3047 (class 0 OID 16457)
-- Dependencies: 210
-- Data for Name: databasechangeloglock; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.databasechangeloglock VALUES (1, false, NULL, NULL);

--
-- TOC entry 3046 (class 0 OID 16411)
-- Dependencies: 209
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES (1, 'a@g.com', 'bob', 'smith', 'idk');
INSERT INTO public.users VALUES (2, 'some', 'sally', 'last', 'some');


--
-- TOC entry 3042 (class 0 OID 16394)
-- Dependencies: 205
-- Data for Name: phrase_sets; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.phrase_sets VALUES (1, 'first', '2023-01-31', '2023-01-31');
INSERT INTO public.phrase_sets VALUES (2, 'second', '2023-01-31', '2023-01-31');


--
-- TOC entry 3043 (class 0 OID 16397)
-- Dependencies: 206
-- Data for Name: phrases; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.phrases VALUES (1, 1, 'my phrase original', 'english', 'some path idk');
INSERT INTO public.phrases VALUES (2, 1, 'some', 'eng2', 'path2');
INSERT INTO public.phrases VALUES (3, 2, 'hi', 'translation', 'path3');
INSERT INTO public.phrases VALUES (4, 2, 'hola', 'hi', 'path4');


--
-- TOC entry 3044 (class 0 OID 16403)
-- Dependencies: 207
-- Data for Name: user_phrase_comments; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3045 (class 0 OID 16407)
-- Dependencies: 208
-- Data for Name: user_phrases; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_phrases VALUES (1, 1, 1, '2023-01-31 16:35:36.015939', 'idk');
INSERT INTO public.user_phrases VALUES (2, 1, 2, '2023-01-31 16:35:59.401079', 'idk');
INSERT INTO public.user_phrases VALUES (3, 1, 2, '2023-01-31 16:36:21.062048', 'idk');
INSERT INTO public.user_phrases VALUES (4, 2, 2, '2023-01-31 16:36:56.453551', 'idk');





--
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 200
-- Name: collection_sets_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.collection_sets_id_seq', 2, false);


--
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 201
-- Name: phrases_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.phrases_seq', 2, false);


--
-- TOC entry 3064 (class 0 OID 0)
-- Dependencies: 202
-- Name: user_phrase_comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_phrase_comments_id_seq', 2, false);


--
-- TOC entry 3065 (class 0 OID 0)
-- Dependencies: 203
-- Name: user_phrases_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_phrases_id_seq', 2, false);


--
-- TOC entry 3066 (class 0 OID 0)
-- Dependencies: 204
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 2, false);


--
-- TOC entry 2886 (class 2606 OID 16418)
-- Name: phrase_sets collection_sets_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.phrase_sets
    ADD CONSTRAINT collection_sets_pkey PRIMARY KEY (id);


--
-- TOC entry 2901 (class 2606 OID 16461)
-- Name: databasechangeloglock databasechangeloglock_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.databasechangeloglock
    ADD CONSTRAINT databasechangeloglock_pkey PRIMARY KEY (id);


--
-- TOC entry 2897 (class 2606 OID 16429)
-- Name: users email; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT email UNIQUE (email);


--
-- TOC entry 2888 (class 2606 OID 16420)
-- Name: phrases phrases_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.phrases
    ADD CONSTRAINT phrases_pkey PRIMARY KEY (id);


--
-- TOC entry 2891 (class 2606 OID 16423)
-- Name: user_phrase_comments user_phrase_comments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_phrase_comments
    ADD CONSTRAINT user_phrase_comments_pkey PRIMARY KEY (id);


--
-- TOC entry 2894 (class 2606 OID 16427)
-- Name: user_phrases user_phrases_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_phrases
    ADD CONSTRAINT user_phrases_pkey PRIMARY KEY (id);


--
-- TOC entry 2899 (class 2606 OID 16431)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2889 (class 1259 OID 16421)
-- Name: user_phrase_comments_phrase_id_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX user_phrase_comments_phrase_id_idx ON public.user_phrase_comments USING btree (phrase_id);


--
-- TOC entry 2892 (class 1259 OID 16424)
-- Name: user_phrases_phrase_id_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX user_phrases_phrase_id_idx ON public.user_phrases USING btree (phrase_id);


--
-- TOC entry 2895 (class 1259 OID 16425)
-- Name: user_phrases_user_id_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX user_phrases_user_id_idx ON public.user_phrases USING btree (user_id);


--
-- TOC entry 2902 (class 2606 OID 16432)
-- Name: phrases phrases_phrase_set_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.phrases
    ADD CONSTRAINT phrases_phrase_set_fkey FOREIGN KEY (phrase_set_id) REFERENCES public.phrase_sets(id);


--
-- TOC entry 2903 (class 2606 OID 16437)
-- Name: user_phrase_comments user_phrase_comments_phrase_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_phrase_comments
    ADD CONSTRAINT user_phrase_comments_phrase_id_fkey FOREIGN KEY (phrase_id) REFERENCES public.phrases(id);


--
-- TOC entry 2904 (class 2606 OID 16442)
-- Name: user_phrase_comments user_phrase_comments_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_phrase_comments
    ADD CONSTRAINT user_phrase_comments_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 2905 (class 2606 OID 16447)
-- Name: user_phrases user_phrases_phrase_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_phrases
    ADD CONSTRAINT user_phrases_phrase_id_fkey FOREIGN KEY (phrase_id) REFERENCES public.phrases(id);


--
-- TOC entry 2906 (class 2606 OID 16452)
-- Name: user_phrases user_phrases_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_phrases
    ADD CONSTRAINT user_phrases_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2023-01-31 16:43:06 PST

--
-- PostgreSQL database dump complete
select a.user_id, b.id as phrase_id, count(*)as c from user_phrases a
full outer join phrases b
on a.phrase_id = b.id
where user_id  is not null
group by b.id , a.user_id
union
--stage 1 do a non-intersecting full outer join with the users and user_phrases (1 qury)
select user_id, phrases.id as phrase_id, 0 as c from
(select u.id as user_id from users u
left join user_phrases
on u.id = user_phrases.user_id
where user_phrases.user_id is null) as a
full outer join phrases on true
union
-- stage 2 non intersecting full outer join with phrases and user_phrases
select users.id as user_id, a.phrase_id, 0 as c from
(select p.id as phrase_id from phrases p
left join user_phrases
on p.id = user_phrases.phrase_id
where user_phrases.phrase_id  is null) as a
full outer join users on true;

