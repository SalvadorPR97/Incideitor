INSERT INTO roles(nombre) VALUES ('Administrador');
INSERT INTO roles(nombre) VALUES ('Usuario');


INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ( 'Juan', 'Y medio', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios ( nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ( 'Pepe', 'Caja', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios ( nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ( 'Manolo', 'Bombo', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios ( nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ( 'Messi', 'Dios', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ( 'Guardiola', 'Juan', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios ( nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ('Rambo', 'Ak', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios ( nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ( 'Shrek', 'Gordo', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');

INSERT INTO ayuntamientos (id, nombre, fotoCabecera, fotologin, foto3, foto4) VALUES (1, 'Chiclana', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (id, nombre, fotoCabecera, fotologin, foto3, foto4) VALUES (2, 'Jerez', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (id, nombre, fotoCabecera, fotologin, foto3, foto4) VALUES (3, 'Murcia', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (id, nombre, fotoCabecera, fotologin, foto3, foto4) VALUES (4, 'Albacete', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (id, nombre, fotoCabecera, fotologin, foto3, foto4) VALUES (5, 'Toledo', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (id, nombre, fotoCabecera, fotologin, foto3, foto4) VALUES (6, 'Miami', 'Juan', 'Juan', 'Juan', 'Juan');

INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (999999, 'Padre', null, true, 0);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (1,'Acerado', 999999, true, 10);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (2,'Aguas', 999999, true, 20);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (3,'Alumbrado', 999999, true, 30);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (4,'Arquetas', 999999, true, 40);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (5,'Cableado', 999999, true, 50);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (6, 'Calzada', 999999, true, 60 );
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (7, 'Carril bici', 999999, true, 70);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (8, 'Fuentes', 999999, true, 80);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (9, 'Jardines y zonas verdes', 999999, true, 90);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (10, 'Limpieza', 999999, true, 100);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (11, 'Medio ambiente', 999999, true, 110);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (12, 'Mobiliario urbano', 999999, true, 120);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (13, 'Monumentos', 999999, true, 130);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (14, 'Parada bus/taxi', 999999, true, 140);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (15, 'Parques infantiles', 999999, true, 150);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (16, 'Plagas', 999999, true, 160);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (17, 'Playas', 999999, true, 170);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (18, 'Saneamiento', 999999, true, 180);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (19, 'Semaforos', 999999, true, 190);

INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (20, 'Baldosa', 1, true, 10);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (21, 'Tuberia rota', 2, true, 20);

INSERT INTO estados (nombre) VALUES ('Iniciado');
INSERT INTO estados (nombre) VALUES ('Finalizado');


INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id, borrado_logico) VALUES ('Apocalipsis','Ha llegado Rambo con un ak-47','2023-06-01',21,1,1,1,1);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id, borrado_logico) VALUES ('Afilador','Ha llegado el afilador','2023-06-01',2,2,3,1,1);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id, borrado_logico) VALUES ('Churreria','Problema en Churreria Hmnos Pernia','2023-06-01',3,3,4,1,1);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id, borrado_logico) VALUES ('Guerra nuclear','Y hizo pum ya esta aqui la guerra','2023-06-01',4,4,5,2,1);


INSERT INTO historicos (incidencia_id, estado_id) VALUES (1, 1);
INSERT INTO historicos (incidencia_id, estado_id) VALUES (2, 2);


INSERT INTO reportes (categoria, descripcion) VALUES ('0', 'No se ve la pantalla');