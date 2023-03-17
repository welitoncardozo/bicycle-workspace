CREATE TABLE IF NOT EXISTS client
(
    id SERIAL NOT NULL,
    name TEXT NOT NULL,
    cpf character varying(14),
    CONSTRAINT client_pkey PRIMARY KEY (id)
);

INSERT INTO client
  (id, name, cpf)
VALUES
  (nextval('client_register.client_id_seq'), 'Weliton', '123.456.789-01'),
  (nextval('client_register.client_id_seq'), 'Higor', '456.789.123-12'),
  (nextval('client_register.client_id_seq'), 'Teste', '123.123.555-88');