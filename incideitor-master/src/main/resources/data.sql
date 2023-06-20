INSERT INTO roles(nombre) VALUES ('ADMINISTRADOR');
INSERT INTO roles(nombre) VALUES ('USUARIO');
INSERT INTO roles(nombre) VALUES ('ANONIMO');
INSERT INTO roles(nombre) VALUES ('AYUNTAMIENTO_ADMIN');
INSERT INTO roles(nombre) VALUES ('AYUNTAMIENTO_GESTOR');

INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Chiclana', 'chiclana.png', 'chiclana2.png', 'chiclana3.png', 'chiclana3.png');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Jerez', 'jerez.png', 'jerez2.png', 'jerez3.png', 'jerez4.png');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Murcia', 'murcia.png', 'murcia2.png', 'murcia3.png', 'murcia4.png');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Albacete', 'albacete.png', 'albacete2.png', 'albacete3.png', 'albacete4.png');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Toledo', 'toledo.png', 'toledo2.png', 'toledo3.png', 'toledo4.png');
INSERT INTO ayuntamientos (nombre, fotoCabecera, fotologin, foto3, foto4) VALUES ('Sevilla', 'sevilla.png', 'sevilla2.png', 'sevilla3.png', 'sevilla4.png');

-- la contraseña es: No12345..
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, rol_id) VALUES ('Juan', 'Y medio', 'juan.png', 'juan@gmail.com', '12345678A', '$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a', 'Hombre', 1);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, rol_id, ayuntamiento_id) VALUES ('Manuel', 'Valles', 'manuel.png', 'manuel@gmail.com', '12345678B', '$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a', 'Hombre', 2, 1);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, rol_id) VALUES ('Manolo', 'Suarez', 'manolo.png', 'anonimo@anonimo.com', '12345678C', '$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a', 'Otro', 3);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, rol_id) VALUES ('Carmelo', 'Cobo', 'carmelo.png', 'carmelo@gmail.com', '12345678D', '$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a', 'Mujer', 4);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, departamento, extension, rol_id) VALUES ('Domingo', 'Lima', 'domingo.png', 'domingo@gmail.com', '12345678E', '$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a', 'Hombre', 'Urbanismo', 304, 5);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, rol_id) VALUES ('Lola', 'Aguado', 'lola.png', 'lola@gmail.com', '12345678F', '$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a', 'Hombre', 2);
INSERT INTO usuarios (nombre, apellido, avatar, email, dni, contrasena, sexo, rol_id) VALUES ('Andrea', 'Barros', 'kirby.png', 'andrea@gmail.com', '12345678G', '$2a$10$lqrr0Uu.I/qLKWu8pPCLL.1Ll7ORZSr3BC4OCaRmGK1FQQ4Qu4R8a', 'Otro', 2);



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

INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (20, 'Agrietado', 1, true, 10);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (21, 'Baldosas', 1, true, 20);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (22, 'Socavón', 1, true, 30);

INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (23, 'Corte del Servicio', 2, true, 10);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (24, 'Mala calidad', 2, true, 20);

INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (25, 'Cables al Descubierto', 3, true, 10);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (26, 'Cristal Roto', 3, true, 20);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (27, 'Luminaria Apagada', 3, true, 30);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (28, 'Farol Roto', 3, true, 40);

INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (29, 'Arqueta Abierta', 4, true, 10);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (30, 'Arqueta en Mal Estado', 4, true, 20);
INSERT INTO tipoincidencia(id, nombre, incidencia_padre_id, active, orden) VALUES (31, 'Arqueta con Tapa Desaparecida', 4, true, 30);

INSERT INTO estados (nombre) VALUES ('Registrado');
INSERT INTO estados (nombre) VALUES ('En Curso');
INSERT INTO estados (nombre) VALUES ('Finalizado');


INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id) VALUES ('Baldosa rota','La baldosa de la calle está levantada y se puede caer alguien','2023-06-01',21,1,1,1);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id) VALUES ('Tapa de arqueta desaparecida','La tapa de la arqueta de la calle no está','2023-06-01',31,2,3,1);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id) VALUES ('Cristal de farola roto','El cristal de la farola está roto','2023-06-01',26,3,4,3);
INSERT INTO incidencias(titulo, descripcion, fecha, tipo_incidencia_id, usuario_id, ayuntamiento_id, estado_id) VALUES ('Bombilla fundida','La bombilla no funciona','2023-06-01',27,4,5,2);


INSERT INTO historicos (incidencia_id, estado_id, fechaCambioEstado) VALUES (1, 1, '2023-06-01');
INSERT INTO historicos (incidencia_id, estado_id, fechaCambioEstado, mensajeAdicional) VALUES (2, 2, '2023-06-01', 'Hermanos Rodriguez va a arreglarlo');
INSERT INTO historicos (incidencia_id, estado_id, fechaCambioEstado, mensajeAdicional) VALUES (3, 3, '2023-06-01', 'Se ha sustituido la bombilla');


INSERT INTO reportes (titulo, categoria, descripcion) VALUES ('Pantalla', 'Bug', 'No se ve la pantalla');
INSERT INTO reportes (titulo, categoria, descripcion) VALUES ('Fotos en la incidencia', 'Error', 'Incidencia con fotos borrosas');
INSERT INTO reportes (titulo, categoria, descripcion) VALUES ('Dirección', 'Error', 'La dirección está mal');
