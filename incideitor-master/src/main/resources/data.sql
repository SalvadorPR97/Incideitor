INSERT INTO roles(nombre) VALUES ('Administrador');
INSERT INTO roles(nombre) VALUES ('Usuario');


INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ('Juan', 'Y medio', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ('Pepe', 'Caja', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ('Manolo', 'Bombo', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ('Messi', 'Dios', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ('Guardiola', 'Juan', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ('Rambo', 'Ak', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension) VALUES ('Shrek', 'Gordo', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan');

INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Chiclana', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Jerez', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Murcia', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Albacete', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Toledo', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Miami', 'Juan', 'Juan', 'Juan', 'Juan');

INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Acerado',1);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Aguas', 2);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Alumbrado', 3);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Arquetas', 4);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Cableado', 5);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Calzada', 6 );
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Carril bici', 7);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Fuentes', 8);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Jardines y zonas verdes', 9);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Limpieza', 10);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Medio ambiente', 11);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Mobiliario urbano', 12);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Monumentos', 13);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Parada bus/taxi', 14);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Parques infantiles', 15);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Plagas', 16);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Playas', 17);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Saneamiento', 18);
INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Semaforos', 19);

INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id) VALUES ('Apocalipsis','Ha llegado Rambo con un ak-47','2023-06-01',1,1,1);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id) VALUES ('Afilador','Ha llegado el afilador','2023-06-01',2,2,3);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id) VALUES ('Churreria','Problema en Churreria Hmnos Pernia','2023-06-01',3,3,4);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id) VALUES ('Guerra nuclear','Y hizo pum ya esta aqui la guerra','2023-06-01',4,4,5);

INSERT INTO reportes (categoria, descripcion) VALUES ('0', 'No se ve la pantalla')