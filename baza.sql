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
    longitude double precision NOT NULL
);


ALTER TABLE "Kavarna" OWNER TO postgres;

--
-- Name: napitek_autoinc; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE napitek_autoinc
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000000
    CACHE 1;


ALTER TABLE napitek_autoinc OWNER TO postgres;

--
-- Name: Napitek; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Napitek" (
    id integer DEFAULT nextval('napitek_autoinc'::regclass) NOT NULL,
    prep_time character varying(30),
    size character varying(20) NOT NULL,
    type character varying(30) NOT NULL,
    price double precision
);


ALTER TABLE "Napitek" OWNER TO postgres;

--
-- Name: napitki_kavarne_autoinc; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE napitki_kavarne_autoinc
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000000
    CACHE 1;


ALTER TABLE napitki_kavarne_autoinc OWNER TO postgres;

--
-- Name: Napitki_kavarne; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Napitki_kavarne" (
    id integer DEFAULT nextval('napitki_kavarne_autoinc'::regclass) NOT NULL,
    id_napitka integer NOT NULL,
    id_kavarna integer NOT NULL
);


ALTER TABLE "Napitki_kavarne" OWNER TO postgres;

--
-- Name: napitki_narocila_autoinc; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE napitki_narocila_autoinc
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 10000000
    CACHE 1;


ALTER TABLE napitki_narocila_autoinc OWNER TO postgres;

--
-- Name: Napitki_narocila; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Napitki_narocila" (
    id integer DEFAULT nextval('napitki_narocila_autoinc'::regclass) NOT NULL,
    id_narocila integer NOT NULL,
    id_napitka integer NOT NULL
);


ALTER TABLE "Napitki_narocila" OWNER TO postgres;

--
-- Name: narocilo_autoinc; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE narocilo_autoinc
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000000
    CACHE 1;


ALTER TABLE narocilo_autoinc OWNER TO postgres;

--
-- Name: Narocilo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Narocilo" (
    id integer DEFAULT nextval('narocilo_autoinc'::regclass) NOT NULL,
    prep_time character varying(50),
    prep_status character varying(50),
    payment_status character varying(50),
    id_uporabnik integer NOT NULL,
    id_kavarna integer NOT NULL,
    total_price double precision
);


ALTER TABLE "Narocilo" OWNER TO postgres;

--
-- Name: uporabnik_autoinc; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE uporabnik_autoinc
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000000
    CACHE 1;


ALTER TABLE uporabnik_autoinc OWNER TO postgres;

--
-- Name: Uporabnik; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Uporabnik" (
    id integer DEFAULT nextval('uporabnik_autoinc'::regclass) NOT NULL,
    name character varying(30) NOT NULL,
    surname character varying(30) NOT NULL,
    email character varying(50),
    latitude double precision,
    longitude double precision,
    username character varying(20)
);


ALTER TABLE "Uporabnik" OWNER TO postgres;

--
-- Data for Name: Kavarna; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Kavarna" (id, name, latitude, longitude) FROM stdin;
1	Marjetica	1234.8900000000001	1234.8900000000001
2	Beli Konj	56.43	32.670000000000002
3	Gostilna Pri Inotu	55.219999999999999	40.759999999999998
\.


--
-- Data for Name: Napitek; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Napitek" (id, prep_time, size, type, price) FROM stdin;
1	120s	small	cappuccino	1
2	120s	medium	cappuccino	1.2
3	150s	large	cappuccino	1.5
4	90s	small	espresso	1.2
5	100s	medium	irish coffee	1.5
6	130s	large	irish coffee	2
7	100s	small	macchiato	1
8	120s	medium	macchiato	1.3
9	160s	large	macchiato	1.7
\.


--
-- Data for Name: Napitki_kavarne; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Napitki_kavarne" (id, id_napitka, id_kavarna) FROM stdin;
1	2	1
2	5	1
3	4	1
4	3	1
5	6	1
6	7	1
7	7	2
8	1	2
9	2	2
10	3	2
11	9	2
12	9	3
13	8	3
14	7	3
\.


--
-- Data for Name: Napitki_narocila; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Napitki_narocila" (id, id_narocila, id_napitka) FROM stdin;
1	1	1
2	1	4
3	1	8
4	2	5
5	3	2
6	3	9
\.


--
-- Data for Name: Narocilo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Narocilo" (id, prep_time, prep_status, payment_status, id_uporabnik, id_kavarna, total_price) FROM stdin;
2	90	done	done	2	3	1.5
1	120	pending	done	1	1	3.5
3	180	done	pending	1	2	2.8999999999999999
\.


--
-- Data for Name: Uporabnik; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Uporabnik" (id, name, surname, email, latitude, longitude, username) FROM stdin;
1	David	Rubin	mail@rubin.si	48.433999999999997	32.231999999999999	pussslayer
2	Tilen	Venko	mail@venko.si	46.872999999999998	40.542999999999999	zeljestudent
\.


--
-- Name: napitek_autoinc; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('napitek_autoinc', 9, true);


--
-- Name: napitki_kavarne_autoinc; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('napitki_kavarne_autoinc', 14, true);


--
-- Name: napitki_narocila_autoinc; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('napitki_narocila_autoinc', 1, false);


--
-- Name: narocilo_autoinc; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('narocilo_autoinc', 275, true);


--
-- Name: uporabnik_autoinc; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('uporabnik_autoinc', 307, true);


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
-- Name: Napitki_kavarne Napitki_kavarne_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Napitki_kavarne"
    ADD CONSTRAINT "Napitki_kavarne_pkey" PRIMARY KEY (id);


--
-- Name: Napitki_narocila Napitki_narocila_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Napitki_narocila"
    ADD CONSTRAINT "Napitki_narocila_pkey" PRIMARY KEY (id);


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
-- Name: Napitki_kavarne id_kavarna; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Napitki_kavarne"
    ADD CONSTRAINT id_kavarna FOREIGN KEY (id_kavarna) REFERENCES "Kavarna"(id);


--
-- Name: Narocilo id_kavarna; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Narocilo"
    ADD CONSTRAINT id_kavarna FOREIGN KEY (id_kavarna) REFERENCES "Kavarna"(id);


--
-- Name: Napitki_narocila id_napitka; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Napitki_narocila"
    ADD CONSTRAINT id_napitka FOREIGN KEY (id_napitka) REFERENCES "Napitek"(id);


--
-- Name: Napitki_kavarne id_napitka; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Napitki_kavarne"
    ADD CONSTRAINT id_napitka FOREIGN KEY (id_napitka) REFERENCES "Napitek"(id);


--
-- Name: Napitki_narocila id_narocila; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Napitki_narocila"
    ADD CONSTRAINT id_narocila FOREIGN KEY (id_narocila) REFERENCES "Narocilo"(id);


--
-- Name: Narocilo id_uporabnik; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Narocilo"
    ADD CONSTRAINT id_uporabnik FOREIGN KEY (id_uporabnik) REFERENCES "Uporabnik"(id);


--
-- PostgreSQL database dump complete
--

