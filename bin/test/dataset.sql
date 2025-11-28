-- Inserción de datos para tablas maestras/referenciales

-- Ciudad
INSERT INTO ciudad (codigo, nombre) VALUES (1, 'Armenia');

INSERT INTO ciudad (codigo, nombre) VALUES (2, 'Pereira');

INSERT INTO ciudad (codigo, nombre) VALUES (3, 'Manizales');

INSERT INTO ciudad (codigo, nombre) VALUES (4, 'Bogotá');

INSERT INTO ciudad (codigo, nombre) VALUES (5, 'Medellín');

-- Especialidad
INSERT INTO especialidad (codigo, nombre) VALUES (1, 'Pediatría');

INSERT INTO especialidad (codigo, nombre) VALUES (2, 'Cardiología');

INSERT INTO especialidad (codigo, nombre) VALUES (3, 'Dermatología');

INSERT INTO especialidad (codigo, nombre) VALUES (4, 'Oftalmología');

INSERT INTO especialidad (codigo, nombre) VALUES (5, 'Neurología');

-- EPS
INSERT INTO eps (codigo, nombre) VALUES (1, 'Sanitas');

INSERT INTO eps (codigo, nombre) VALUES (2, 'Sura');

INSERT INTO eps (codigo, nombre) VALUES (3, 'Nueva EPS');

INSERT INTO eps (codigo, nombre) VALUES (4, 'Salud Total');

INSERT INTO eps (codigo, nombre) VALUES (5, 'Compensar');

-- TipoSangre
INSERT INTO tipo_sangre (codigo, nombre) VALUES (1, 'O+');

INSERT INTO tipo_sangre (codigo, nombre) VALUES (2, 'O-');

INSERT INTO tipo_sangre (codigo, nombre) VALUES (3, 'A+');

INSERT INTO tipo_sangre (codigo, nombre) VALUES (4, 'A-');

INSERT INTO tipo_sangre (codigo, nombre) VALUES (5, 'B+');

-- EstadoMedico
INSERT INTO estado_medico (codigo, nombre) VALUES (1, 'ACTIVO');

INSERT INTO estado_medico (codigo, nombre) VALUES (2, 'INACTIVO');

-- EstadoCita
INSERT INTO estado_cita (codigo, estado) VALUES (1, 'PROGRAMADA');

INSERT INTO estado_cita (codigo, estado) VALUES (2, 'COMPLETADA');

INSERT INTO estado_cita (codigo, estado) VALUES (3, 'CANCELADA');

-- EstadoPqrs
INSERT INTO estado_pqrs (codigo, estado) VALUES (1, 'NUEVO');

INSERT INTO estado_pqrs (codigo, estado) VALUES (2, 'EN_TRAMITE');

INSERT INTO estado_pqrs (codigo, estado) VALUES (3, 'ARCHIVADO');

-- Cuentas (Administradores)
INSERT INTO
    cuenta (codigo, correo, contrasena)
VALUES (
        1,
        'admin1@clinica.com',
        'password123'
    );

INSERT INTO
    cuenta (codigo, correo, contrasena)
VALUES (
        2,
        'admin2@clinica.com',
        'password123'
    );

-- Administradores
INSERT INTO
    administrador (codigo, correo, contrasena)
VALUES (
        1,
        'admin1@clinica.com',
        'password123'
    );

INSERT INTO
    administrador (codigo, correo, contrasena)
VALUES (
        2,
        'admin2@clinica.com',
        'password123'
    );

-- Cuentas (Pacientes)
INSERT INTO
    cuenta (codigo, correo, contrasena)
VALUES (
        101,
        'juan.perez@email.com',
        'pass123'
    );

INSERT INTO
    cuenta (codigo, correo, contrasena)
VALUES (
        102,
        'maria.lopez@email.com',
        'pass123'
    );

INSERT INTO
    cuenta (codigo, correo, contrasena)
VALUES (
        103,
        'carlos.garcia@email.com',
        'pass123'
    );

INSERT INTO
    cuenta (codigo, correo, contrasena)
VALUES (
        104,
        'ana.martinez@email.com',
        'pass123'
    );

INSERT INTO
    cuenta (codigo, correo, contrasena)
VALUES (
        105,
        'luis.rodriguez@email.com',
        'pass123'
    );

-- Usuarios (Pacientes)
INSERT INTO
    usuario (
        codigo,
        cedula,
        nombre,
        celular,
        ciudad_codigo,
        url_foto
    )
VALUES (
        101,
        '1094857123',
        'Juan Perez',
        '3111234567',
        1,
        'foto_juan.jpg'
    );

INSERT INTO
    usuario (
        codigo,
        cedula,
        nombre,
        celular,
        ciudad_codigo,
        url_foto
    )
VALUES (
        102,
        '1094857124',
        'Maria Lopez',
        '3111234568',
        2,
        'foto_maria.jpg'
    );

INSERT INTO
    usuario (
        codigo,
        cedula,
        nombre,
        celular,
        ciudad_codigo,
        url_foto
    )
VALUES (
        103,
        '1094857125',
        'Carlos Garcia',
        '3111234569',
        3,
        'foto_carlos.jpg'
    );

INSERT INTO
    usuario (
        codigo,
        cedula,
        nombre,
        celular,
        ciudad_codigo,
        url_foto
    )
VALUES (
        104,
        '1094857126',
        'Ana Martinez',
        '3111234570',
        1,
        'foto_ana.jpg'
    );

INSERT INTO
    usuario (
        codigo,
        cedula,
        nombre,
        celular,
        ciudad_codigo,
        url_foto
    )
VALUES (
        105,
        '1094857127',
        'Luis Rodriguez',
        '3111234571',
        2,
        'foto_luis.jpg'
    );

-- Pacientes
INSERT INTO
    paciente (
        codigo,
        fecha_nacimiento,
        alergias,
        eps_codigo,
        tipo_sangre_codigo
    )
VALUES (
        101,
        '1990-05-15',
        'Ninguna',
        1,
        1
    );

INSERT INTO
    paciente (
        codigo,
        fecha_nacimiento,
        alergias,
        eps_codigo,
        tipo_sangre_codigo
    )
VALUES (
        102,
        '1985-08-20',
        'Penicilina',
        2,
        2
    );

INSERT INTO
    paciente (
        codigo,
        fecha_nacimiento,
        alergias,
        eps_codigo,
        tipo_sangre_codigo
    )
VALUES (
        103,
        '1992-03-10',
        'Polvo',
        1,
        3
    );

INSERT INTO
    paciente (
        codigo,
        fecha_nacimiento,
        alergias,
        eps_codigo,
        tipo_sangre_codigo
    )
VALUES (
        104,
        '1988-11-25',
        'Ninguna',
        3,
        1
    );

INSERT INTO
    paciente (
        codigo,
        fecha_nacimiento,
        alergias,
        eps_codigo,
        tipo_sangre_codigo
    )
VALUES (
        105,
        '1995-01-30',
        'Latex',
        2,
        4
    );

-- Cuentas (Medicos)
INSERT INTO
    cuenta (codigo, correo, contrasena)
VALUES (
        201,
        'dr.house@clinica.com',
        'doc123'
    );

INSERT INTO
    cuenta (codigo, correo, contrasena)
VALUES (
        202,
        'dra.grey@clinica.com',
        'doc123'
    );

INSERT INTO
    cuenta (codigo, correo, contrasena)
VALUES (
        203,
        'dr.strange@clinica.com',
        'doc123'
    );

-- Usuarios (Medicos)
INSERT INTO
    usuario (
        codigo,
        cedula,
        nombre,
        celular,
        ciudad_codigo,
        url_foto
    )
VALUES (
        201,
        '987654321',
        'Gregory House',
        '3201112233',
        1,
        'foto_house.jpg'
    );

INSERT INTO
    usuario (
        codigo,
        cedula,
        nombre,
        celular,
        ciudad_codigo,
        url_foto
    )
VALUES (
        202,
        '987654322',
        'Meredith Grey',
        '3201112234',
        2,
        'foto_grey.jpg'
    );

INSERT INTO
    usuario (
        codigo,
        cedula,
        nombre,
        celular,
        ciudad_codigo,
        url_foto
    )
VALUES (
        203,
        '987654323',
        'Stephen Strange',
        '3201112235',
        3,
        'foto_strange.jpg'
    );

-- Medicos
INSERT INTO
    medico (
        codigo,
        especialidad_codigo,
        estado_medico_codigo,
        hora_inicio,
        hora_fin
    )
VALUES (
        201,
        1,
        1,
        '08:00:00',
        '16:00:00'
    );

INSERT INTO
    medico (
        codigo,
        especialidad_codigo,
        estado_medico_codigo,
        hora_inicio,
        hora_fin
    )
VALUES (
        202,
        2,
        1,
        '09:00:00',
        '17:00:00'
    );

INSERT INTO
    medico (
        codigo,
        especialidad_codigo,
        estado_medico_codigo,
        hora_inicio,
        hora_fin
    )
VALUES (
        203,
        5,
        1,
        '10:00:00',
        '18:00:00'
    );

-- Dias Libres
INSERT INTO
    dia_libre (codigo, fecha, medico_codigo)
VALUES (1, '2023-12-25', 201);

INSERT INTO
    dia_libre (codigo, fecha, medico_codigo)
VALUES (2, '2024-01-01', 202);

-- Dias
INSERT INTO dia (codigo, nombre) VALUES (1, 'LUNES');

INSERT INTO dia (codigo, nombre) VALUES (2, 'MARTES');

INSERT INTO dia (codigo, nombre) VALUES (3, 'MIERCOLES');

INSERT INTO dia (codigo, nombre) VALUES (4, 'JUEVES');

INSERT INTO dia (codigo, nombre) VALUES (5, 'VIERNES');

INSERT INTO dia (codigo, nombre) VALUES (6, 'SABADO');

INSERT INTO dia (codigo, nombre) VALUES (7, 'DOMINGO');

-- Horarios
INSERT INTO
    horario (
        codigo,
        dia_codigo,
        hora_inicio,
        hora_fin,
        medico_codigo
    )
VALUES (
        1,
        1,
        '2025-01-01 08:00:00.000000',
        '2025-01-01 16:00:00.000000',
        201
    );

INSERT INTO
    horario (
        codigo,
        dia_codigo,
        hora_inicio,
        hora_fin,
        medico_codigo
    )
VALUES (
        2,
        2,
        '2025-01-02 08:00:00.000000',
        '2025-01-02 16:00:00.000000',
        201
    );

INSERT INTO
    horario (
        codigo,
        dia_codigo,
        hora_inicio,
        hora_fin,
        medico_codigo
    )
VALUES (
        3,
        3,
        '2025-01-03 09:00:00.000000',
        '2025-01-03 17:00:00.000000',
        202
    );

-- Citas
INSERT INTO
    cita (
        codigo,
        fecha_creacion,
        fecha_cita,
        motivo,
        estado_cita_codigo,
        medico_codigo,
        paciente_codigo
    )
VALUES (
        1,
        '2023-11-01 10:00:00',
        '2023-11-05 09:00:00',
        'Fiebre alta',
        2,
        201,
        101
    );

INSERT INTO
    cita (
        codigo,
        fecha_creacion,
        fecha_cita,
        motivo,
        estado_cita_codigo,
        medico_codigo,
        paciente_codigo
    )
VALUES (
        2,
        '2023-11-02 11:00:00',
        '2023-11-06 10:00:00',
        'Chequeo corazón',
        1,
        202,
        102
    );

INSERT INTO
    cita (
        codigo,
        fecha_creacion,
        fecha_cita,
        motivo,
        estado_cita_codigo,
        medico_codigo,
        paciente_codigo
    )
VALUES (
        3,
        '2023-11-03 12:00:00',
        '2023-11-07 11:00:00',
        'Dolor de cabeza',
        1,
        203,
        103
    );

INSERT INTO
    cita (
        codigo,
        fecha_creacion,
        fecha_cita,
        motivo,
        estado_cita_codigo,
        medico_codigo,
        paciente_codigo
    )
VALUES (
        4,
        '2023-11-04 09:00:00',
        '2023-11-08 09:00:00',
        'Control pediatrico',
        3,
        201,
        104
    );

INSERT INTO
    cita (
        codigo,
        fecha_creacion,
        fecha_cita,
        motivo,
        estado_cita_codigo,
        medico_codigo,
        paciente_codigo
    )
VALUES (
        5,
        '2023-11-05 14:00:00',
        '2023-11-09 15:00:00',
        'Arritmia',
        1,
        202,
        105
    );

-- Atencion
INSERT INTO
    atencion (
        codigo,
        fecha,
        diagnostico,
        notas_medicas,
        sintomas,
        tratamiento,
        cita_codigo
    )
VALUES (
        1,
        '2023-11-05 09:30:00',
        'Infección viral',
        'Paciente presenta fiebre',
        'Fiebre, malestar',
        'Repos y líquidos',
        1
    );

-- PQRS
INSERT INTO
    pqrs (
        codigo,
        fecha_creacion,
        motivo,
        tipo,
        estado_pqrs_codigo,
        cita_codigo,
        eps_codigo
    )
VALUES (
        1,
        '2023-11-06 10:00:00',
        'Demora en atención',
        'QUEJA',
        2,
        1,
        1
    );

INSERT INTO
    pqrs (
        codigo,
        fecha_creacion,
        motivo,
        tipo,
        estado_pqrs_codigo,
        cita_codigo,
        eps_codigo
    )
VALUES (
        2,
        '2023-11-08 11:00:00',
        'Excelente servicio',
        'FELICITACION',
        3,
        2,
        1
    );