--COUNTRY
INSERT INTO country (id, name) VALUES ('1', 'Mexico');
INSERT INTO country (id, name) VALUES ('2', 'Colombia');

--STATE
INSERT INTO state (id, name, country_id) VALUES ('1', 'Aguascalientes', '1');
INSERT INTO state (id, name, country_id) VALUES ('2', 'Cali', '2');

--CITY
INSERT INTO city (id, name, state_id) VALUES ('1', 'Obregon1', '1');
INSERT INTO city (id, name, state_id) VALUES ('2', 'Obregon2', '2');

--COMPANY
INSERT INTO company (id, name, rfc, certificate, location, colony, address, zip, city_id)
VALUES ('1', 'SHIO BELLEZA INTEGRAL SA DE CV', 'SBI130426ID8', '00001000000407509544', 'loc', 'col', 'dir', '123', '1');

INSERT INTO company (id, name, rfc, certificate, location, colony, address, zip, city_id)
VALUES ('2', 'LIBET ALEJANDRA LIRA ANGULO', 'LIAL770809L70', '00001000000304005466', 'loc', 'col', 'dir', '123', '1');

--SUBSIDIARY
INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company_id, city_id)
VALUES ('1', 'Olivares', 'olivares@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '1', '1');

INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company_id, city_id)
VALUES ('2', 'Luis Orci', 'luisorci@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '1', '1');

INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company_id, city_id)
VALUES ('3', 'Dila', 'dila@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '1', '1');

INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company_id, city_id)
VALUES ('4', 'Reforma', 'reforma@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '2', '1');

INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company_id, city_id)
VALUES ('5', 'Obregon', 'obregon@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '1', '1');

INSERT INTO subsidiary (id, name, email, phone, mobile, location, colony, address, zip, active, company_id, city_id)
VALUES ('6', 'Girasol', 'olivares@shio.com', '3322244', '3187766655', 'loc', 'col', 'dir', '468', '1', '1', '1');

--EMPLOYEE
INSERT INTO employee (name, email, phone, position, active, subsidiary_id)
VALUES ('Wisi', 'wisi@dabalash.org', '123123123', 'Administrador', '1', '1');

--CLIENT
INSERT INTO client (name, email, phone, mobile, birthdate, country_id, state_id, city_id, location, colony,
address, zip, rfc, subsidiary_id, active)
VALUES ('Juan Camilo', 'jcamilo@gmail.com', '3335500', '3013336655', '1987-07-04', '1', '1', '1', '1', '1',
'1056 Water AV', '123987', 'SBI130426ID8', '1', '0');

INSERT INTO client (name, email, phone, mobile, birthdate, country_id, state_id, city_id, location, colony,
address, zip, rfc, subsidiary_id, active)
VALUES ('Andres Felipe', 'andres@gmail.com', '2224400', '3184094630', '1987-05-17', '1', '1', '2', '2', '1',
'3311 Water AV', '123987', 'SBI130426ID8', '3', '1');

--PRODUCT
INSERT INTO product (name, description, codbar, commission, active, price)
VALUES ('Dabalash', 'Crecimiento de pestanas y cejas', '9001231231239', '10', '1', '1850');

--SERVICE
INSERT INTO service (name, description, codbar, commission, active, price, time)
VALUES ('Corte Mujer', '', '123123', '15', '1', '500', '20');

--APPOINTMENT
INSERT INTO appointment (date, note, rescheduled, client_id, subsidiary_id)
VALUES ('2018-03-03', 'Notas', '1', '1', '2');

--APPOINTMENT ITEM
INSERT INTO appointment_item (time, status, service_id, appointment_id)
VALUES ('10', '1', '1', '1');

--TRANSACTION
INSERT INTO transaction (date, invoice, invoicepdf, canceled, processed, reason, client_id, subsidiary_id)
VALUES ('2018-03-03', '123123', '', 'true', 'true', '1', '1', '1');

INSERT INTO transaction (date, invoice, invoicepdf, canceled, processed, reason, client_id, subsidiary_id)
VALUES ('2018-03-08', '', '', 'true', 'true', '1', '1', '1');

--TRANSACTION ITEM
INSERT INTO transactionitem (type, quantity, price, aditional, product_id, service_id, transaction_id)
VALUES ('1', '2', 300, 0, '1', null, '1');

INSERT INTO transactionitem (type, quantity, price, aditional, product_id, service_id, transaction_id)
VALUES ('1', '2', 50, 0, null, '1', '2');