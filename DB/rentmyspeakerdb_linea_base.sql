CREATE DATABASE rentmyspeakerdb CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE usuario (
	id INTEGER NOT NULL AUTO_INCREMENT  PRIMARY KEY,
	nombre VARCHAR(45) NOT NULL,
	apellido VARCHAR(60) NOT NULL,
	correo VARCHAR(125) NOT NULL,
	contra VARCHAR(20) NOT NULL,
	imagen MEDIUMBLOB,
	nombre_img VARCHAR(15),
	fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE publicacion (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	disponible BOOLEAN NOT NULL,
	titulo_pub VARCHAR(150) NOT NULL,
	tipo_articulo ENUM('sonido', 'percusiones', 'instrumentos', 'electrónicos') NOT NULL,
	descripcion VARCHAR(1800),
	precio_dia FLOAT NOT NULL, 
	fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP	
);

CREATE TABLE solicitud (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	num_dias INTEGER NOT NULL,
	estado_solicitud ENUM('pendiente', 'aceptada', 'rechazada') NOT NULL,	
	fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP		
);

CREATE TABLE renta (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	estado_renta ENUM('en espera','en proceso','finalizada') NOT NULL,
	fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE usuario_publicacion (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_proveedor INTEGER NOT NULL,
	id_publicacion INTEGER NOT NULL,
	FOREIGN KEY (id_proveedor) REFERENCES usuario(id),
	FOREIGN KEY (id_publicacion) REFERENCES publicacion(id),
	fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE usuario_solicitud (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_solicitud INTEGER NOT NULL,
	id_receptor INTEGER NOT NULL,
	FOREIGN KEY (id_solicitud) REFERENCES solicitud(id),
	FOREIGN KEY (id_receptor) REFERENCES usuario(id),
	fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE publicacion_imagenes (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_publicacion INTEGER NOT NULL,
	imagen MEDIUMBLOB NOT NULL,
	nombre_img VARCHAR(15) NOT NULL,
	FOREIGN KEY (id_publicacion) REFERENCES publicacion(id),
	fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP	
);

CREATE TABLE solicitud_publicacion (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_solicitud INTEGER NOT NULL,
	id_publicacion INTEGER NOT NULL,
	FOREIGN KEY  (id_solicitud) REFERENCES solicitud(id),
	FOREIGN KEY  (id_publicacion) REFERENCES publicacion(id),
	fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP		
);

CREATE TABLE renta_solicitud (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_renta INTEGER NOT NULL,
	id_solicitud INTEGER NOT NULL,
	FOREIGN KEY (id_renta) REFERENCES renta(id),
	FOREIGN KEY (id_solicitud) REFERENCES solicitud(id),
	fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);