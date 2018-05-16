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
INSERT INTO company (name, rfc, certificate, location, colony, address, zip, city_id)
VALUES ('SHIO BELLEZA INTEGRAL SA DE CV', 'SBI130426ID8', '00001000000407509544', 'loc', 'col', 'dir', '123', '1');

INSERT INTO company (name, rfc, certificate, location, colony, address, zip, city_id)
VALUES ('LIBET ALEJANDRA LIRA ANGULO', 'LIAL770809L70', '00001000000304005466', 'loc', 'col', 'dir', '123', '1');

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

INSERT INTO employee (name, email, phone, position, active, subsidiary_id)
VALUES ('Empleado 2', 'empleado@dabalash.org', '123123444', 'Administrador', '1', '2');

--CLIENT
INSERT INTO client (name, email, phone, mobile, birthdate, country_id, state_id, city_id, location, colony,
address, zip, rfc, subsidiary_id, active)
VALUES ('Juan Camilo', 'jcamilo@gmail.com', '3335500', '3013336655', '1987-07-04', '1', '1', '1', '1', '1',
'1056 Water AV', '123987', 'SBI130426ID8', '1', '0');

INSERT INTO client (name, email, phone, mobile, birthdate, country_id, state_id, city_id, location, colony,
address, zip, rfc, subsidiary_id, active)
VALUES ('Andres Felipe', 'andres@gmail.com', '2224400', '3184094630', '1987-05-17', '1', '1', '2', '2', '1',
'3311 Water AV', '123987', 'SBI130426ID8', '2', '1');

--PRODUCT
INSERT INTO product (name, description, codbar, commission, active, price, key, unit)
VALUES ('Dabalash', 'Crecimiento de pestanas y cejas', '9001231231239', '10', '1', '1850', '53131638', 'XUN');

--SERVICE
INSERT INTO service (name, description, codbar, commission, active, price, time, key, unit)
VALUES ('Corte Mujer', '', '123123', '15', '1', '500', '20', '53131638', 'XUN');

--APPOINTMENT
INSERT INTO appointment (date, note, rescheduled, client_id, subsidiary_id)
VALUES ('2018-03-03', 'Notas', 'true', '1', '1');

INSERT INTO appointment (date, note, rescheduled, client_id, subsidiary_id)
VALUES ('2018-03-10', 'Notas', 'false', '2', '2');

--APPOINTMENT ITEM
INSERT INTO appointmentitem (time, started, status, service_id, employee_id, appointment_id)
VALUES ('2018-03-03 10:15:00', '2018-04-08 23:35:00', 'Iniciada', '1', '1', '1');

INSERT INTO appointmentitem (time, started, status, service_id, employee_id, appointment_id)
VALUES ('2018-03-03 11:10:00', '2018-04-08 23:30:00', 'Iniciada', '1    ', '2', '2');

--TRANSACTION
INSERT INTO transaction (date, invoice, invoicepdf, canceled, processed, reason, client_id, subsidiary_id)
VALUES ('2018-03-03', '123123', '', 'false', 'true', '1', '1', '1');

INSERT INTO transaction (date, invoice, invoicepdf, canceled, processed, reason, client_id, subsidiary_id)
VALUES ('2018-03-08', '', '', 'false', 'false', '1', '1', '2');

INSERT INTO transaction (date, invoice, invoicepdf, canceled, processed, reason, client_id, subsidiary_id)
VALUES ('2018-03-12', '', '', 'false', 'false', '2', '2', '3');

--TRANSACTION ITEM
INSERT INTO transactionitem (type, quantity, price, aditional, anticipated, coupon, dateused, product_id, service_id, employee_id, transaction_id)
VALUES ('1', '2', 300, 0, 'true', 'OL1N1521392259269', null, '1', null, '1', '1');

INSERT INTO transactionitem (type, quantity, price, aditional, anticipated, coupon, dateused, product_id, service_id, employee_id, transaction_id)
VALUES ('1', '2', 50, 0, 'true', null, null, null, '1', '1', '2');

INSERT INTO transactionitem (type, quantity, price, aditional, anticipated, coupon, dateused, product_id, service_id, employee_id, transaction_id)
VALUES ('1', '2', 50, 0, 'false', null, null, '1', null, '1', '2');

--TRANSACTION COUPON
INSERT INTO transactioncoupon (code, transaction_id)
VALUES ('A00000001112222', '3');

--INVENTORY
INSERT INTO inventory (quantity, product_id, subsidiary_id)
VALUES ('10', '1', '1');

INSERT INTO inventory (quantity, product_id, subsidiary_id)
VALUES ('5', '1', '2');

--ENTRY
INSERT INTO entry (date, confirmed, subsidiary_id)
VALUES ('2018-03-10', '0', '1');

INSERT INTO entry (date, confirmed, subsidiary_id)
VALUES ('2018-04-12', '0', '2');

--ENTRY ITEM
INSERT INTO entryitem (quantity, product_id, entry_id)
VALUES ('3', '1', '1');

INSERT INTO entryitem (quantity, product_id, entry_id)
VALUES ('6', '1', '2');

--COUPON
INSERT INTO coupon (code, quantity, available, transactionorigin, transactionused, product_id, service_id, client_id)
VALUES ('AAAAAA111222333', '2', '2', '2', null, '1', null, '1');