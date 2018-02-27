--COUNTRY
INSERT INTO country (id, name) VALUES ('1', 'Mexico');

--STATE
INSERT INTO state (id, name, country) VALUES ('1', 'Aguas', '1');

--CITY
INSERT INTO city (id, name, state) VALUES ('1', 'Obregon1', '1');
INSERT INTO city (id, name, state) VALUES ('2', 'Obregon2', '1');

--SUBSIDIARY
INSERT INTO subsidiary (id, name) VALUES ('1', 'Olivares');
INSERT INTO subsidiary (id, name) VALUES ('2', 'Luis Orci');
INSERT INTO subsidiary (id, name) VALUES ('3', 'Dila');
INSERT INTO subsidiary (id, name) VALUES ('4', 'Reforma');
INSERT INTO subsidiary (id, name) VALUES ('5', 'Obregon');
INSERT INTO subsidiary (id, name) VALUES ('6', 'Girasol');

--CLIENT
INSERT INTO client (name, email, phone, mobile, birthdate, country_id, state_id, city_id, location, colony, address, zip, rfc, subsidiary_id, active)
VALUES ('Juan Camilo', 'jcamilo@gmail.com', '3335500', '3013336655', '1987-07-04', '1', '1', '1', '1', '1', '1056 Water AV', '123987', 'SHIOBB99DDF', '1', '0');

INSERT INTO client (name, email, phone, mobile, birthdate, country_id, state_id, city_id, location, colony, address, zip, rfc, subsidiary_id, active)
VALUES ('Andres Felipe', 'andres@gmail.com', '2224400', '3184094630', '1987-05-17', '1', '1', '2', '2', '1', '3311 Water AV',
'123987', 'AFSBB99DDF', '3', '1');