--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.0
-- Dumped by pg_dump version 9.6.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: Kavarna; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Kavarna" (
    id integer NOT NULL,
    name character varying(40) NOT NULL,
    latitude double precision NOT NULL,
    longtitude double precision NOT NULL
);


ALTER TABLE "Kavarna" OWNER TO postgres;

--
-- Name: Napitek; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Napitek" (
    id integer NOT NULL,
    prep_time character varying(30),
    size character varying(20) NOT NULL,
    type character varying(30) NOT NULL
);


ALTER TABLE "Napitek" OWNER TO postgres;

--
-- Name: Narocilo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Narocilo" (
    id integer NOT NULL,
    item_list character varying(50)[] NOT NULL,
    prep_time character varying(50),
    prep_status character varying(50),
    payment_status character varying(50)
);


ALTER TABLE "Narocilo" OWNER TO postgres;

--
-- Name: Uporabnik; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Uporabnik" (
    id integer NOT NULL,
    name character varying(30) NOT NULL,
    surname character varying(30) NOT NULL,
    email character varying(50),
    latitude double precision,
    longtitude double precision,
    username character varying(20)
);


ALTER TABLE "Uporabnik" OWNER TO postgres;

--
-- Data for Name: Kavarna; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Kavarna" (id, name, latitude, longtitude) FROM stdin;
\.


--
-- Data for Name: Napitek; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Napitek" (id, prep_time, size, type) FROM stdin;
\.


--
-- Data for Name: Narocilo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Narocilo" (id, item_list, prep_time, prep_status, payment_status) FROM stdin;
\.


--
-- Data for Name: Uporabnik; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Uporabnik" (id, name, surname, email, latitude, longtitude, username) FROM stdin;
1	David	Rubin	mail@david.si	48.235622999999997	47.346899999999998	rdavid
\.


--
-- Name: Kavarna Kavarna_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Kavarna"
    ADD CONSTRAINT "Kavarna_pkey" PRIMARY KEY (id);


--
-- Name: Napitek Napitek_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Napitek"
    ADD CONSTRAINT "Napitek_pkey" PRIMARY KEY (id);


--
-- Name: Narocilo Narocilo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Narocilo"
    ADD CONSTRAINT "Narocilo_pkey" PRIMARY KEY (id);


--
-- Name: Uporabnik Uporabnik_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Uporabnik"
    ADD CONSTRAINT "Uporabnik_pkey" PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--
