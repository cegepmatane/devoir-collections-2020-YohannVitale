--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

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
-- Name: Collection; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Collection" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_Canada.1252' LC_CTYPE = 'French_Canada.1252';


ALTER DATABASE "Collection" OWNER TO postgres;

\connect "Collection"

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
-- Name: oeuvre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.oeuvre (
    description text,
    id integer NOT NULL,
    nom text,
    id_collection integer
);


ALTER TABLE public.oeuvre OWNER TO postgres;

--
-- Name: oeuvre_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.oeuvre_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.oeuvre_id_seq OWNER TO postgres;

--
-- Name: oeuvre_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.oeuvre_id_seq OWNED BY public.oeuvre.id;


--
-- Name: collection id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collection ALTER COLUMN id SET DEFAULT nextval('public.collection_id_seq'::regclass);


--
-- Name: oeuvre id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.oeuvre ALTER COLUMN id SET DEFAULT nextval('public.oeuvre_id_seq'::regclass);


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
-- Data for Name: oeuvre; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.oeuvre VALUES ('Bilbon est un hobbit qui est partie aller cherche une salade', 1, 'Les Aventures De bilbon', 1);
INSERT INTO public.oeuvre VALUES ('UN timbre fait en or en 1900', 2, 'Le timbre d''or
', 10);
INSERT INTO public.oeuvre VALUES ('Un Vase en porcelaine qui on appartenu a Louis XIV', 3, 'Vase en porcelaine de Louis XIV', 7);
INSERT INTO public.oeuvre VALUES ('Des gens mangent les enfants', 4, 'Les Mangeur d''enfant', 1);


--
-- Name: collection_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.collection_id_seq', 12, true);


--
-- Name: oeuvre_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.oeuvre_id_seq', 4, true);


--
-- Name: collection collection_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.collection
    ADD CONSTRAINT collection_pkey PRIMARY KEY (id);


--
-- Name: oeuvre oeuvre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.oeuvre
    ADD CONSTRAINT oeuvre_pkey PRIMARY KEY (id);


--
-- Name: oeuvre fk_Collection_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.oeuvre
    ADD CONSTRAINT "fk_Collection_id" FOREIGN KEY (id_collection) REFERENCES public.collection(id) NOT VALID;


--
-- PostgreSQL database dump complete
--

