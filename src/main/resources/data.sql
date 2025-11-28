-- Script de inicialización de datos para la clínica
-- Las contraseñas están encriptadas con BCrypt

-- Ciudades
INSERT INTO
    ciudad (codigo, nombre)
VALUES (1, 'Armenia')
ON DUPLICATE KEY UPDATE
    nombre = 'Armenia';

INSERT INTO
    ciudad (codigo, nombre)
VALUES (2, 'Pereira')
ON DUPLICATE KEY UPDATE
    nombre = 'Pereira';

INSERT INTO
    ciudad (codigo, nombre)
VALUES (3, 'Manizales')
ON DUPLICATE KEY UPDATE
    nombre = 'Manizales';

INSERT INTO
    ciudad (codigo, nombre)
VALUES (4, 'Bogotá')
ON DUPLICATE KEY UPDATE
    nombre = 'Bogotá';

INSERT INTO
    ciudad (codigo, nombre)
VALUES (5, 'Medellín')
ON DUPLICATE KEY UPDATE
    nombre = 'Medellín';

-- Especialidades
INSERT INTO
    especialidad (codigo, nombre)
VALUES (1, 'Pediatría')
ON DUPLICATE KEY UPDATE
    nombre = 'Pediatría';

INSERT INTO
    especialidad (codigo, nombre)
VALUES (2, 'Cardiología')
ON DUPLICATE KEY UPDATE
    nombre = 'Cardiología';

INSERT INTO
    especialidad (codigo, nombre)
VALUES (3, 'Dermatología')
ON DUPLICATE KEY UPDATE
    nombre = 'Dermatología';

INSERT INTO
    especialidad (codigo, nombre)
VALUES (4, 'Oftalmología')
ON DUPLICATE KEY UPDATE
    nombre = 'Oftalmología';

INSERT INTO
    especialidad (codigo, nombre)
VALUES (5, 'Neurología')
ON DUPLICATE KEY UPDATE
    nombre = 'Neurología';

-- EPS
INSERT INTO
    eps (codigo, nombre)
VALUES (1, 'Sanitas')
ON DUPLICATE KEY UPDATE
    nombre = 'Sanitas';

INSERT INTO
    eps (codigo, nombre)
VALUES (2, 'Sura')
ON DUPLICATE KEY UPDATE
    nombre = 'Sura';

INSERT INTO
    eps (codigo, nombre)
VALUES (3, 'Nueva EPS')
ON DUPLICATE KEY UPDATE
    nombre = 'Nueva EPS';

INSERT INTO
    eps (codigo, nombre)
VALUES (4, 'Salud Total')
ON DUPLICATE KEY UPDATE
    nombre = 'Salud Total';

INSERT INTO
    eps (codigo, nombre)
VALUES (5, 'Compensar')
ON DUPLICATE KEY UPDATE
    nombre = 'Compensar';

-- Tipos de Sangre
INSERT INTO
    tipo_sangre (codigo, nombre)
VALUES (1, 'O+')
ON DUPLICATE KEY UPDATE
    nombre = 'O+';

INSERT INTO
    tipo_sangre (codigo, nombre)
VALUES (2, 'O-')
ON DUPLICATE KEY UPDATE
    nombre = 'O-';

INSERT INTO
    tipo_sangre (codigo, nombre)
VALUES (3, 'A+')
ON DUPLICATE KEY UPDATE
    nombre = 'A+';

INSERT INTO
    tipo_sangre (codigo, nombre)
VALUES (4, 'A-')
ON DUPLICATE KEY UPDATE
    nombre = 'A-';

INSERT INTO
    tipo_sangre (codigo, nombre)
VALUES (5, 'B+')
ON DUPLICATE KEY UPDATE
    nombre = 'B+';

-- Estados
INSERT INTO
    estado_medico (codigo, nombre)
VALUES (1, 'ACTIVO')
ON DUPLICATE KEY UPDATE
    nombre = 'ACTIVO';

INSERT INTO
    estado_medico (codigo, nombre)
VALUES (2, 'INACTIVO')
ON DUPLICATE KEY UPDATE
    nombre = 'INACTIVO';

INSERT INTO
    estado_cita (codigo, estado)
VALUES (1, 'PROGRAMADA')
ON DUPLICATE KEY UPDATE
    estado = 'PROGRAMADA';

INSERT INTO
    estado_cita (codigo, estado)
VALUES (2, 'COMPLETADA')
ON DUPLICATE KEY UPDATE
    estado = 'COMPLETADA';

INSERT INTO
    estado_cita (codigo, estado)
VALUES (3, 'CANCELADA')
ON DUPLICATE KEY UPDATE
    estado = 'CANCELADA';

INSERT INTO
    estado_pqrs (codigo, estado)
VALUES (1, 'NUEVO')
ON DUPLICATE KEY UPDATE
    estado = 'NUEVO';

INSERT INTO
    estado_pqrs (codigo, estado)
VALUES (2, 'EN_TRAMITE')
ON DUPLICATE KEY UPDATE
    estado = 'EN_TRAMITE';

INSERT INTO
    estado_pqrs (codigo, estado)
VALUES (3, 'ARCHIVADO')
ON DUPLICATE KEY UPDATE
    estado = 'ARCHIVADO';

-- Administrador de prueba
-- Email: admin1@clinica.com
-- Password: password123
-- Password encriptado con BCrypt: $2a$10$3oJYc0d8Qz7zxTWnt3dzmu.WXo0hH5vZA7qbt0nBHlVnQCDd1UEC2
INSERT INTO
    cuenta (codigo, correo, contrasena)
VALUES (
        1,
        'admin1@clinica.com',
        '$2a$10$3oJYc0d8Qz7zxTWnt3dzmu.WXo0hH5vZA7qbt0nBHlVnQCDd1UEC2'
    )
ON DUPLICATE KEY UPDATE
    contrasena = '$2a$10$3oJYc0d8Qz7zxTWnt3dzmu.WXo0hH5vZA7qbt0nBHlVnQCDd1UEC2';

INSERT INTO
    administrador (codigo)
VALUES (1)
ON DUPLICATE KEY UPDATE
    codigo = 1;