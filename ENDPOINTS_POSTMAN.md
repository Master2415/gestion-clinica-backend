# 📋 Documentación de Endpoints - Sistema de Clínica

**Base URL:** `http://localhost:8080`

---

## 🔐 Autenticación (`/api/auth`)
    
### 1. Login
**POST** `/api/auth/login`

**Body (JSON):**
```json
{
  "correo": "usuario@example.com",
  "contrasenia": "password123"
}
```

**Respuesta exitosa:**
```json
{
  "error": false,
  "respuesta": {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
  }
}
```

---

### 2. Registrarse (Paciente)
**POST** `/api/auth/registrarse`

**Body (JSON):**
```json
{
  "nombre": "Juan Pérez",
  "correo": "juan.perez@example.com",
  "cedula": "1234567890",
  "celular": "3001234567",
  "contrasena": "password123",
  "urlFoto": "https://example.com/foto.jpg",
  "fechaNacimiento": "1990-05-15",
  "ciudad": {
    "codigo": 1,
    "nombre": "Armenia"
  },
  "tipoSangre": {
    "codigo": 1,
    "tipo": "O+"
  },
  "alergias": "Ninguna"
}
```

**Respuesta exitosa:**
```json
{
  "error": false,
  "respuesta": "Usuario creado correctamente"
}
```

---

## 👤 Paciente (`/api/paciente`)

### 3. Editar Perfil
**PUT** `/api/paciente/editar-perfil/{codigo}`

**Parámetros de ruta:**
- `codigo`: ID del paciente (ej: 1)

**Body (JSON):**
```json
{
  "codigo": 1,
  "cedula": "1234567890",
  "nombre": "Juan Pérez Actualizado",
  "telefono": "3001234567",
  "urlFoto": "https://example.com/nueva-foto.jpg",
  "ciudad": {
    "codigo": 1,
    "nombre": "Armenia"
  },
  "fechaNacimiento": "1990-05-15",
  "alergias": "Polen",
  "eps": {
    "codigo": 1,
    "nombre": "Sura"
  },
  "tipoSangre": {
    "codigo": 1,
    "tipo": "O+"
  },
  "correo": "juan.perez@example.com"
}
```

---

### 4. Eliminar Cuenta
**DELETE** `/api/paciente/eliminar/{codigoPaciente}`

**Parámetros de ruta:**
- `codigoPaciente`: ID del paciente (ej: 1)

---

### 5. Ver Detalle del Paciente
**GET** `/api/paciente/detalle-paciente/{codigo}`

**Parámetros de ruta:**
- `codigo`: ID del paciente (ej: 1)

---

### 6. Listar PQRS del Paciente
**GET** `/api/paciente/listar-pqrs/{idPaciente}`

**Parámetros de ruta:**
- `idPaciente`: ID del paciente (ej: 1)

---

### 7. Listar Citas del Paciente
**GET** `/api/paciente/listar-citas-paciente/{codigoPaciente}`

**Parámetros de ruta:**
- `codigoPaciente`: ID del paciente (ej: 1)

---

### 8. Filtrar Citas por Fecha
**GET** `/api/paciente/listar-citas-fecha`

**Query Parameters:**
```
codigoPaciente=1
nombreMedico=Dr. García
fechaCita=2024-11-25T10:00:00
```

---

### 9. Filtrar Médicos para Cita
**GET** `/api/paciente/listar-citas-medico`

**Query Parameters:**
```
especialidad=CARDIOLOGIA
fecha=2024-11-25T10:00:00
```

---

### 10. Agendar Cita
**POST** `/api/paciente/agendar-cita`

**Body (JSON):**
```json
{
  "motivo": "Consulta de control",
  "fecha": "2024-11-25T10:00:00",
  " codigoMedico": 1,
  "codigoPaciente": 1
}
```

---

### 11. Crear PQRS
**POST** `/api/paciente/crear-pqrs`

**Body (JSON):**
```json
{
  "codigoCita": 1,
  "motivo": "Queja sobre el servicio de atención"
}
```

---

### 12. Responder PQRS
**POST** `/api/paciente/responder-pqrs`

**Body (JSON):**
```json
{
  "codigoPqrs": 1,
  "mensaje": "Gracias por la respuesta, estoy satisfecho",
  "respuestaAdmin": 1,
  "codigoPaciente": 1
}
```

---

### 13. Enviar Link de Recuperación
**POST** `/api/paciente/enviar-link-recuperacion`

**Query Parameters:**
```
correo=usuario@example.com
```

---

## 👨‍⚕️ Médico (`/api/medico`)

### 14. Listar Citas Pendientes
**GET** `/api/medico/listar-citas-pendientes/{codigoMedico}`

**Parámetros de ruta:**
- `codigoMedico`: ID del médico (ej: 1)

---

### 15. Historial de Atenciones de Paciente
**GET** `/api/medico/historial-atenciones-paciente/{codigoPaciente}`

**Parámetros de ruta:**
- `codigoPaciente`: ID del paciente (ej: 1)

---

### 16. Listar Citas Realizadas por Médico
**GET** `/api/medico/listar-citas-realizadas/{codigoMedico}`

**Parámetros de ruta:**
- `codigoMedico`: ID del médico (ej: 1)

---

### 17. Ver Detalle de Consulta
**GET** `/api/medico/detalle-consulta/{codigoCita}`

**Parámetros de ruta:**
- `codigoCita`: ID de la cita (ej: 1)

---

### 18. Atender Cita
**POST** `/api/medico/atender-cita`

**Body (JSON):**
```json
{
  "codigoCita": 1,
  "codigoMedico": 1,
  "notasMedicas": "Paciente presenta mejoría",
  "tratamiento": "Continuar con medicación actual",
  "sintomas": "Dolor de cabeza leve",
  "medicamentos": [
    {
      "nombre": "Ibuprofeno",
      "cantidad": 20,
      "uso": "Oral",
      "dosis": "400mg cada 8 horas"
    },
    {
      "nombre": "Paracetamol",
      "cantidad": 10,
      "uso": "Oral",
      "dosis": "500mg cada 6 horas"
    }
  ],
  "descripcionReceta": "Tomar medicamentos con alimentos",
  "diagnostico": "Cefalea tensional"
}
```

---

### 19. Agendar Día Libre
**POST** `/api/medico/agendar-dia-libre`

**Body (JSON):**
```json
{
  "codigoMedico": 1,
  "fecha": "2024-11-30T00:00:00"
}
```

---

## 👨‍💼 Administrador (`/api/administrador`)

### 20. Crear Médico
**POST** `/api/administrador/crear-medico`

**Body (JSON):**
```json
{
  "nombre": "Dr. Carlos García",
  "correo": "carlos.garcia@clinica.com",
  "cedula": "9876543210",
  "telefono": "3109876543",
  "password": "password123",
  "direccion": "Calle 15 #20-30",
  "especialidad": {
    "codigo": 1,
    "nombre": "CARDIOLOGIA"
  },
  "urlFoto": "https://example.com/foto-medico.jpg",
  "ciudad": {
    "codigo": 1,
    "nombre": "Armenia"
  },
  "horarios": [
    {
      "dia": {
        "codigo": 1,
        "nombre": "LUNES"
      },
      "horaInicio": "08:00:00",
      "horaSalida": "17:00:00"
    },
    {
      "dia": {
        "codigo": 2,
        "nombre": "MARTES"
      },
      "horaInicio": "08:00:00",
      "horaSalida": "17:00:00"
    }
  ],
  "estadoMedico": {
    "codigo": 1,
    "estado": "ACTIVO"
  }
}
```

---

### 21. Actualizar Médico
**PUT** `/api/administrador/actualizar-medico`

**Body (JSON):**
```json
{
  "codigo": 1,
  "nombre": "Dr. Carlos García Actualizado",
  "correo": "carlos.garcia@clinica.com",
  "cedula": "9876543210",
  "telefono": "3109876543",
  "especialidad": {
    "codigo": 1,
    "nombre": "CARDIOLOGIA"
  },
  "horaInicio": "08:00:00",
  "horaFin": "17:00:00",
  "urlFoto": "https://example.com/nueva-foto-medico.jpg",
  "ciudad": {
    "codigo": 1,
    "nombre": "Armenia"
  },
  "horarios": [
    {
      "dia": {
        "codigo": 1,
        "nombre": "LUNES"
      },
      "horaInicio": "08:00:00",
      "horaSalida": "17:00:00"
    }
  ]
}
```

---

### 22. Eliminar Médico
**DELETE** `/api/administrador/eliminar-medico/{codigo}`

**Parámetros de ruta:**
- `codigo`: ID del médico (ej: 1)

---

### 23. Listar Médicos
**GET** `/api/administrador/listar-medicos`

---

### 24. Obtener Detalle de Médico
**GET** `/api/administrador/detalle-medico/{codigo}`

**Parámetros de ruta:**
- `codigo`: ID del médico (ej: 1)

---

### 25. Listar PQRS
**GET** `/api/administrador/listar-pqrs`

---

### 26. Responder PQRS
**POST** `/api/administrador/responder-pqrs`

**Body (JSON):**
```json
{
  "codigoPqrs": 1,
  "codigoAdmin": 1,
  "mensaje": "Hemos revisado su caso y tomaremos las medidas necesarias"
}
```

---

### 27. Ver Detalle de PQRS
**GET** `/api/administrador/ver-detalle-pqrs/{codigo}`

**Parámetros de ruta:**
- `codigo`: ID del PQRS (ej: 1)

---

### 28. Listar Citas
**GET** `/api/administrador/listar-citas`

---

## 🏥 Clínica (`/api/clinica`)

### 29. Listar Ciudades
**GET** `/api/clinica/lista-ciudades`

---

### 30. Listar EPS
**GET** `/api/clinica/lista-eps`

---

### 31. Listar Especializaciones
**GET** `/api/clinica/lista-especializacion`

---

### 32. Listar Tipos de Sangre
**GET** `/api/clinica/lista-tipo-sangre`

---

### 33. Listar Mensajes de PQRS
**GET** `/api/clinica/listar-pqrs/{codigoPqrs}`

**Parámetros de ruta:**
- `codigoPqrs`: ID del PQRS (ej: 1)

---

### 34. Cambiar Contraseña
**GET** `/api/clinica/cambiar-password/{codigoUsuario}/{nuevaPassword}`

**Parámetros de ruta:**
- `codigoUsuario`: ID del usuario (ej: 1)
- `nuevaPassword`: Nueva contraseña (ej: "nuevaPassword123")

---

## 📷 Imágenes (`/api/imagenes`)

### 35. Subir Imagen
**POST** `/api/imagenes/subir`

**Content-Type:** `multipart/form-data`

**Form Data:**
- `file`: (archivo de imagen)

**Nota:** En Postman, selecciona "Body" → "form-data" y agrega una key llamada "file" de tipo "File"

---

### 36. Eliminar Imagen
**DELETE** `/api/imagenes/eliminar`

**Body (JSON):**
```json
{
  "id": "imagen_id_cloudinary",
  "url": "https://res.cloudinary.com/..."
}
```

---

## 📝 Notas Importantes

### Autenticación con JWT
Para los endpoints que requieren autenticación, debes agregar el token JWT en los headers:

**Headers:**
```
Authorization: Bearer {token}
```

### Formato de Fechas
- **LocalDate:** `"YYYY-MM-DD"` (ej: `"2024-11-25"`)
- **LocalDateTime:** `"YYYY-MM-DDTHH:mm:ss"` (ej: `"2024-11-25T10:30:00"`)
- **LocalTime:** `"HH:mm:ss"` (ej: `"08:00:00"`)

### Códigos de Respuesta HTTP
- **200 OK:** Operación exitosa
- **201 Created:** Recurso creado exitosamente
- **400 Bad Request:** Error en la validación de datos
- **401 Unauthorized:** No autenticado
- **403 Forbidden:** No autorizado
- **404 Not Found:** Recurso no encontrado
- **500 Internal Server Error:** Error del servidor

### Estructura de Respuesta Estándar
```json
{
  "error": false,
  "respuesta": "Datos o mensaje de respuesta"
}
```

### Enumeraciones Comunes

**Especialidades:**
- CARDIOLOGIA
- DERMATOLOGIA
- PEDIATRIA
- NEUROLOGIA
- OFTALMOLOGIA
- etc.

**Días de la Semana:**
- LUNES
- MARTES
- MIERCOLES
- JUEVES
- VIERNES
- SABADO
- DOMINGO

**Estados de Médico:**
- ACTIVO
- INACTIVO
- VACACIONES

**Estados de Cita:**
- PENDIENTE
- COMPLETADA
- CANCELADA

**Estados de PQRS:**
- ABIERTO
- EN_PROCESO
- CERRADO

---

## 🚀 Colección de Postman

Para importar estos endpoints en Postman:

1. Abre Postman
2. Click en "Import"
3. Crea una nueva colección llamada "Sistema Clínica"
4. Crea las carpetas: Autenticación, Paciente, Médico, Administrador, Clínica, Imágenes
5. Agrega cada endpoint según la documentación anterior
6. Configura una variable de entorno `baseUrl` con valor `http://localhost:8080`
7. Configura una variable de entorno `token` para almacenar el JWT después del login

### Variables de Entorno Sugeridas
```
baseUrl: http://localhost:8080
token: (se llenará después del login)
codigoPaciente: 1
codigoMedico: 1
codigoAdmin: 1
```

---

**Última actualización:** 2024-11-24
**Puerto del servidor:** 8080
**Base de datos:** MySQL (proyectoClinica)
