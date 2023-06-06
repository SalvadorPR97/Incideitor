INSERT INTO roles(nombre) VALUES ('Administrador');
INSERT INTO roles(nombre) VALUES ('Usuario');

INSERT INTO mensajes(fecha, contenido, leido) VALUES ('2023-06-01','Contenido del mensaje',1);
INSERT INTO mensajes(fecha, contenido, leido) VALUES ('2023-06-01','Contenido del mensaje',2);
INSERT INTO mensajes(fecha, contenido, leido) VALUES ('2023-06-01','Contenido del mensaje',3);

INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension, mensaje_emisor_id, mensaje_receptor_id) VALUES ('Juan', 'Y medio', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan',1,2);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension, mensaje_emisor_id, mensaje_receptor_id) VALUES ('Pepe', 'Caja', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan',1,3);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension, mensaje_emisor_id, mensaje_receptor_id) VALUES ('Manolo', 'Bombo', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan',1,2);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension, mensaje_emisor_id, mensaje_receptor_id) VALUES ('Messi', 'Dios', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan',1,3);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension, mensaje_emisor_id, mensaje_receptor_id) VALUES ('Guardiola', 'Juan', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan',1,2);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension, mensaje_emisor_id, mensaje_receptor_id) VALUES ('Rambo', 'Ak', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan',1,3);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension, mensaje_emisor_id, mensaje_receptor_id) VALUES ('Shrek', 'Gordo', 'Juan', 'mail.alejandro.teixeira@gmail.com', 'Juan', 'Juan', '1', 'Juan', 'Juan',1,2);

INSERT INTO Usuario_has_rol (usuario_id, rol_id) VALUES (1, 1);
INSERT INTO Usuario_has_rol (usuario_id, rol_id) VALUES (1, 1);
INSERT INTO Usuario_has_rol (usuario_id, rol_id) VALUES (1, 2);
INSERT INTO Usuario_has_rol (usuario_id, rol_id) VALUES (1, 2);
INSERT INTO Usuario_has_rol (usuario_id, rol_id) VALUES (1, 2);
INSERT INTO Usuario_has_rol (usuario_id, rol_id) VALUES (1, 2);
INSERT INTO Usuario_has_rol (usuario_id, rol_id) VALUES (1, 2);

INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Chiclana', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Jerez', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Murcia', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Albacete', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Toledo', 'Juan', 'Juan', 'Juan', 'Juan');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Miami', 'Juan', 'Juan', 'Juan', 'Juan');

INSERT INTO tipos_incidencia(nombre, incidencia_padre_id) VALUES ('Acerado', 1);
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

INSERT INTO estados (nombre) VALUES ('Iniciado');
INSERT INTO estados (nombre) VALUES ('Finalizado');

INSERT INTO lugares (latitud, longitud, direccion, descripcion) VALUES (4, 6, 'Japon', 'Donde el cerezo de Doraemon');

INSERT INTO parametros_incidencia (nombre, valor) VALUES ('parametro1', 'valor1');
INSERT INTO parametros_incidencia (nombre, valor) VALUES ('parametro2', 'valor2');
INSERT INTO parametros_incidencia (nombre, valor) VALUES ('parametro3', 'valor3');

INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id, lugar_id, parametro_incidencia_id) VALUES ('Apocalipsis','Ha llegado Rambo con un ak-47','2023-06-01',1 ,1 ,1 ,1 ,1, 1);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id, lugar_id, parametro_incidencia_id) VALUES ('Afilador','Ha llegado el afilador','2023-06-01', 2, 2, 3, 1, 1, 2);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id, lugar_id, parametro_incidencia_id) VALUES ('Churreria','Problema en Churreria Hmnos Pernia','2023-06-01', 3, 3, 4, 1, 1, 2);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id, lugar_id, parametro_incidencia_id) VALUES ('Guerra nuclear','Y hizo pum ya esta aqui la guerra','2023-06-01', 4, 4, 5, 2, 1, 1);

INSERT INTO votos (id, incidencia_id, usuario_id, voto, fecha) VALUES ('1', 1,  1, 1, '2023-06-01');
INSERT INTO votos (id, incidencia_id, usuario_id, voto, fecha) VALUES ('2', 2,  2, 1, '2023-06-01');

INSERT INTO reportes (categoria, descripcion, incidencia_id, usuario_id) VALUES (1, 'No se ve la pantalla', 1, 1);
INSERT INTO reportes (categoria, descripcion, incidencia_id, usuario_id) VALUES (2, 'Ha llegado Goku', 1, 1);

INSERT INTO fotos(incidencia_id, foto, orden) VALUES (1,'url de la foto 1', 1);
INSERT INTO fotos(incidencia_id, foto, orden) VALUES (1,'url de la foto 2', 2);
INSERT INTO fotos(incidencia_id, foto, orden) VALUES (1,'url de la foto 3', 3);

INSERT INTO notificaciones(descripcion, incidencia_id, fecha_notificacion) VALUES ('Ha llegado Rambo con un ak-47',1,'2023-06-01');
INSERT INTO notificaciones(descripcion, incidencia_id, fecha_notificacion) VALUES ('Ha llegado el afilador',2,'2023-06-01');

INSERT INTO historicos (incidencia_id, estado_id) VALUES (1, 1);
INSERT INTO historicos (incidencia_id, estado_id) VALUES (2, 2);

