package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.Cita.CitaDTOAdmin;
import co.edu.uniquindio.clinica.dto.PQRS.InfoPQRSDTO;
import co.edu.uniquindio.clinica.dto.PQRS.ItemPqrsAdminDTO;
import co.edu.uniquindio.clinica.dto.admin.*;
import co.edu.uniquindio.clinica.modelo.Entidades.*;
import co.edu.uniquindio.clinica.modelo.Entidades.EstadoPqrs;
import co.edu.uniquindio.clinica.Repositorios.*;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;
    @Autowired
    private EspecialidadRepo especialidadRepo;
    @Autowired
    private CiudadRepo ciudadRepo;
    @Autowired
    private EstadoPqrsRepo estadoPqrsRepo;
    @Autowired
    private DiaRepo diaRepo;
    @Autowired
    private EstadoMedicoRepo estadoMedicoRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearMedicoTest() {

        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add(new HorarioDTO(
                diaRepo.findById(4).get(), // Assuming 4 is JUEVES
                LocalTime.of(3, 0, 0),
                LocalTime.of(8, 0, 0)));

        EstadoMedico estadoMedico = estadoMedicoRepo.findById(1).orElseThrow(); // Assuming 1 is ACTIVO

        RegistroMedicoDTO registroMedicoDTO = new RegistroMedicoDTO(
                "alejandro zapata",
                "az0031456@gmail.com",
                "2873821771",
                "3207889867",
                "Enrrique segoviano",
                "12234",
                especialidadRepo.findById(1).get(), // Assuming 1 is RADIOLOGIA
                "url_foto",
                ciudadRepo.findById(1).get(), // Assuming 1 is ARMENIA
                horarios,
                estadoMedico);

        try {
            int codigoMedico = administradorServicio.crearMedico(registroMedicoDTO);
            Assertions.assertNotEquals(0, codigoMedico);

        } catch (Exception e) {
            // nueva excepción si es necesario
            Assertions.fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarMedicoTest() {
        try {
            // Obtener el estado actual del medico
            DetalleMedicoDTO medico = administradorServicio.obtenerMedico(1);

            // Crear un objeto ActualizarMedicoDTO con cambios
            DetalleMedicoDTO nuevo = new DetalleMedicoDTO(
                    medico.codigo(),
                    medico.nombre(),
                    medico.correo(),
                    medico.cedula(),
                    medico.telefono(),
                    // medico.direccion(),
                    medico.especialidad(),
                    medico.horaInicio(),
                    medico.horaFin(),
                    medico.urlFoto(),
                    medico.ciudad(),
                    medico.horarios());

            administradorServicio.actualizarMedico(nuevo); // Realizar la actualización
            administradorServicio.obtenerMedico(1); // Obtener el estado actualizado del medico

        } catch (Exception e) {
            Assertions.fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarMedico() {
        try {
            // Eliminar al médico
            administradorServicio.eliminarMedico(1);

            // Verificar que el médico ha sido desactivado (estado = false)
            administradorServicio.obtenerMedico(1);

            // Intentar obtener el médico nuevamente debería lanzar una excepción
            Assertions.assertThrows(Exception.class, () -> administradorServicio.obtenerMedico(1));

        } catch (Exception e) {
            // nueva excepción si es necesario
            Assertions.fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerMedico() {
        try {
            // Obtener el detalle del médico
            DetalleMedicoDTO detalleMedicoDTO = administradorServicio.obtenerMedico(1);

            // Verificar que el nombre del médico sea el esperado
            Assertions.assertEquals("Dr. Juan Perez", detalleMedicoDTO.nombre());

        } catch (Exception e) {
            // nueva excepción si es necesario
            Assertions.fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarMedicos() {
        try {
            // Obtener la lista de médicos
            List<ItemMedicoDTO> listaMedicos = administradorServicio.listarMedicos();

            // Verificar que la lista no sea nula
            Assertions.assertNotNull(listaMedicos);

            // Verificar que la cantidad de médicos sea la esperada (en este caso, 5)
            Assertions.assertEquals(3, listaMedicos.size());

        } catch (Exception e) {
            Assertions.fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPqrs() {
        try {
            // Obtener la lista de PQRS
            List<ItemPqrsAdminDTO> listaPqrs = administradorServicio.listarPQRS();

            // Verificar que la lista no sea nula
            Assertions.assertNotNull(listaPqrs);

            // Verificar que la cantidad de PQRS sea la esperada (en este caso, 5)
            Assertions.assertEquals(2, listaPqrs.size());

        } catch (Exception e) {
            // ueva excepción si es necesario
            Assertions.fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void responderPqrs() {
        try {
            // Crear una respuesta para la PQRS
            RespuestaAdminDTO respuestaAdminPqrsDTO = new RespuestaAdminDTO(1, 1, "El pqrs esta en tramite");

            // Responder a la PQRS
            int codigoRespuestaPqrs = administradorServicio.responderPQRS(respuestaAdminPqrsDTO);

            // Verificar que se haya generado un código de respuesta válido
            Assertions.assertNotEquals(1, codigoRespuestaPqrs);

        } catch (Exception e) {
            // Puedes manejar la excepción aquí o lanzar una nueva excepción si es necesario
            Assertions.fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePQRS() {
        try {
            // Obtener el detalle de la PQRS
            InfoPQRSDTO infoPQRSDTO = administradorServicio.verDetallePQRS(1);

            // Verificar que el motivo de la PQRS sea el esperado
            Assertions.assertEquals("Gripe comun", infoPQRSDTO.motivo());

        } catch (Exception e) {
            // nueva excepción si es necesario
            Assertions.fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitas() {
        try {
            // Obtener la lista de citas
            List<CitaDTOAdmin> citaAdminDTOList = administradorServicio.listarCitas();

            // Verificar que la lista no sea nula
            Assertions.assertNotNull(citaAdminDTOList);

            // Verificar que la cantidad de citas sea la esperada (en este caso, 5)
            Assertions.assertEquals(5, citaAdminDTOList.size());

        } catch (Exception e) {
            // nueva excepción si es necesario
            Assertions.fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarEstadoPqrs() {
        try {
            // Cambiar el estado del PQRS a ARCHIVADO
            EstadoPqrs estadoArchivado = estadoPqrsRepo.findById(3).get(); // Assuming 3 is ARCHIVADO
            administradorServicio.cambiarEstadoPQRS(1, estadoArchivado);

            // Obtener el PQRS actualizado
            Optional<ItemPqrsAdminDTO> optional = administradorServicio.listarPQRS().stream()
                    .filter(p -> p.codigo() == 1).findFirst();

            // Verificar que el estado del PQRS sea ARCHIVADO
            Assertions.assertTrue(optional.isPresent(), "El PQRS no está presente en la lista");
            Assertions.assertEquals(estadoArchivado.getCodigo(), optional.get().estadoPqrs().getCodigo());

        } catch (Exception e) {
            // nueva excepción si es necesario
            Assertions.fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }
}
