--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4 (Ubuntu 12.4-1.pgdg20.04+1)
-- Dumped by pg_dump version 12.4 (Ubuntu 12.4-1.pgdg20.04+1)

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
-- Name: collectionneur; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE collectionneur WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_CA.UTF-8' LC_CTYPE = 'en_CA.UTF-8';


ALTER DATABASE collectionneur OWNER TO postgres;

\connect collectionneur

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: collection; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.collection (
    id integer NOT NULL,
    nom text,
    description text
);


ALTER TABLE public.collection OWNER TO postgres;

--
-- Name: collection_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.collection_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.collection_id_seq OWNER TO postgres;

--
-- Name: collection_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.collection_id_seq OWNED BY public.collection.id;


--
-- Name: collection id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collection ALTER COLUMN id SET DEFAULT nextval('public.collection_id_seq'::regclass);


--
-- Data for Name: collection; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.collection VALUES (1, 'Livres', 'Des livres anciens sont les joyaux de collections savantes.');
INSERT INTO public.collection VALUES (2, 'Cartes', 'Différentes collecitons de cartes nous font souvenir d''époques : carte Red Rose, cartes de hockey, cartes de jeux de rôles, etc.');
INSERT INTO public.collection VALUES (3, 'Lampes', 'Un éclairaige sur notre histoire collective.');
INSERT INTO public.collection VALUES (5, 'Figurines', 'On peut acheter et vendre des figurines avec profit sur eBay.');
INSERT INTO public.collection VALUES (6, 'Monnaie', 'Les cents qui ont de la valeur sont souvent celles qui ont des défauts de fabrication célèbres.');
INSERT INTO public.collection VALUES (7, 'Vases', 'Évocations florales d''une autre époque.');
INSERT INTO public.collection VALUES (9, 'Bijoux', 'Certaines boucles d''oreilles ancienne ne percent pas les oreilles !');
INSERT INTO public.collection VALUES (10, 'Timbres', 'Ils sont aussi un souvenir de nos correspondances.');


--
-- Name: collection_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.collection_id_seq', 12, true);


--
-- Name: collection collection_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collection
    ADD CONSTRAINT collection_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

