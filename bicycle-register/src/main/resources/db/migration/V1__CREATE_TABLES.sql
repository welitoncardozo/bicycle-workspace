CREATE TABLE IF NOT EXISTS brand
(
    id SERIAL NOT NULL,
    name character varying(255),
    CONSTRAINT brand_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS bicycle
(
    id SERIAL NOT NULL,
    name TEXT NOT NULL,
    rented boolean NOT NULL DEFAULT false,
    brand_id bigint NOT NULL,
    CONSTRAINT bicycle_pkey PRIMARY KEY (id),
    CONSTRAINT brand_fk FOREIGN KEY (brand_id)
    REFERENCES brand (id) MATCH SIMPLE
    ON UPDATE NO ACTION
);

INSERT INTO brand
    (name)
VALUES
    ('Caloi'),
    ('Sense'),
    ('Oggi');

INSERT INTO bicycle
    (name, brand_id)
VALUES
    ('GTS ARO 29 FREIO HIDRÁULICO 27 MARCHAS E SUSPENSÃO', 1),
    ('GTS ARO 29 FREIO A DISCO CÂMBIO SHIMANO 21 MARCHAS E AMORTECEDOR', 1),
    ('29 Dropp Aluminum 27 Marchas index Freio a Disco MTB - Branco+Preto', 2),
    ('Mountain Bike Aro 26 TK3 Track TB 300 AP - Aço Freio V-Brake 21 Marchas', 2),
    ('Mountain Bike Aro 26 Caloi Andes Aço Freio V-Brake - 21 Marchas', 3),
    ('ABSOLUTE NERO SPORT HIDRAULICA M', 3);