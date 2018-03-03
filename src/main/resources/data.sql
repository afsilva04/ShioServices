--COUNTRY
INSERT INTO country (id, name) VALUES ('1', 'Mexico');
INSERT INTO country (id, name) VALUES ('2', 'Colombia');

--STATE
INSERT INTO state (id, name, country_id) VALUES ('1', 'Aguascalientes', '1');
INSERT INTO state (id, name, country_id) VALUES ('2', 'Cali', '2');

--CITY
INSERT INTO city (id, name, state_id) VALUES ('1', 'Obregon1', '1');
INSERT INTO city (id, name, state_id) VALUES ('2', 'Obregon2', '2');

--SUBSIDIARY
INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company, city_id)
VALUES ('1', 'Olivares', 'olivares@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '1', '1');

INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company, city_id)
VALUES ('2', 'Luis Orci', 'luisorci@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '1', '1');

INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company, city_id)
VALUES ('3', 'Dila', 'dila@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '1', '1');

INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company, city_id)
VALUES ('4', 'Reforma', 'reforma@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '1', '1');

INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company, city_id)
VALUES ('5', 'Obregon', 'obregon@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '1', '1');

INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company, city_id)
VALUES ('6', 'Girasol', 'olivares@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '1', '1');

--COMPANY
INSERT INTO company (id, name, rfc, certificate, location, colony, address, zip, city_id)
VALUES ('1', 'SHIO BELLEZA INTEGRAL SA DE CV', 'SBI130426ID8', '00001000000407509544', 'loc', 'col', 'dir', '123', '1');

--CLIENT
INSERT INTO client (name, email, phone, mobile, birthdate, country_id, state_id, city_id, location, colony, address, zip, rfc, subsidiary_id, active)
VALUES ('Juan Camilo', 'jcamilo@gmail.com', '3335500', '3013336655', '1987-07-04', '1', '1', '1', '1', '1', '1056 Water AV', '123987', 'SHIOBB99DDF', '1', '0');

INSERT INTO client (name, email, phone, mobile, birthdate, country_id, state_id, city_id, location, colony, address, zip, rfc, subsidiary_id, active)
VALUES ('Andres Felipe', 'andres@gmail.com', '2224400', '3184094630', '1987-05-17', '1', '1', '2', '2', '1', '3311 Water AV',
'123987', 'AFSBB99DDF', '3', '1');