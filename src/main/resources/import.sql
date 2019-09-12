insert into `users` (username, password, enabled) VALUES ('admin', '$2a$10$Fm9qCH73CX0HQQjJO./4K.AWszwsFPEbOkE2RATkSO5.Zo/a67F9K',1);
insert into `users` (username, password, enabled) VALUES ('ventas', '$2a$10$B8htJIk12nSbf0EPDQGG/Om8tMMO2AOPmG78DRHZtzpUxyH/NUWkC',1);


insert into `authorities` (user_id, authority) VALUES(1, 'ROLE_ADMIN');
insert into `authorities` (user_id, authority) VALUES(2, 'ROLE_ADMIN');

insert into `tipos_clientes` (descripcion) VALUES('Cliente');
insert into `tipos_clientes` (descripcion) VALUES('Proveedores');

insert into `clientes` (apellido_materno, apellido_paterno, direccion, nombre, rut, telefono, email, tipo_cliente_id) VALUES ('Castillo','Jara','Av. San Martin','Alberto','11111-0',111,'alberto@gmail.com',1);
insert into `clientes` (apellido_materno, apellido_paterno, direccion, nombre, rut, telefono, email, tipo_cliente_id) VALUES ('Reyes','Reyes','Calle camino largo','Camilo','121212-k',222,'camilo@gmail.com',2);
insert into `clientes` (apellido_materno, apellido_paterno, direccion, nombre, rut, telefono, email, tipo_cliente_id) VALUES ('Fernandez','Mesa','Av. San Martin','Mario','56789-0',111,'mario@gmail.com',1);
insert into `clientes` (apellido_materno, apellido_paterno, direccion, nombre, rut, telefono, email, tipo_cliente_id) VALUES ('Perez','Cotapo','Calle camino largo','Paulina','12345-k',222,'paulina@gmail.com',2);
