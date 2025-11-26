package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.modelo.Entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.Entidades.Eps;
import co.edu.uniquindio.clinica.modelo.Entidades.TipoSangre;
import co.edu.uniquindio.clinica.Repositorios.CiudadRepo;
import co.edu.uniquindio.clinica.Repositorios.EpsRepo;
import co.edu.uniquindio.clinica.Repositorios.TipoSangreRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private TipoSangreRepo tipoSangreRepo;

    @Autowired
    private EpsRepo epsRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarseTest() throws Exception {
        Ciudad ciudad = ciudadRepo.findById(1).orElseThrow();
        TipoSangre tipoSangre = tipoSangreRepo.findById(1).orElseThrow();

        RegistroPacienterDTO registroDTO = new RegistroPacienterDTO(
                "Paciente Test",
                "test@email.com",
                "111222333",
                "3001112222",
                "password123",
                "url_foto",
                LocalDate.of(1995, 5, 5),
                ciudad,
                tipoSangre,
                "Ninguna");

        mockMvc.perform(post("/api/paciente/registrarse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registroDTO)))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void editarPerfilTest() throws Exception {
        Ciudad ciudad = ciudadRepo.findById(1).orElseThrow();
        TipoSangre tipoSangre = tipoSangreRepo.findById(1).orElseThrow();
        Eps eps = epsRepo.findById(1).orElseThrow();

        DetallePacienteDTO detalleDTO = new DetallePacienteDTO(
                101,
                "1234567890",
                "Usuario 1 Modificado",
                "1234567890",
                "url1.jpg",
                ciudad,
                LocalDate.of(1990, 1, 1),
                "Ninguna",
                eps,
                tipoSangre,
                "usuario1@example.com");

        mockMvc.perform(put("/api/paciente/editar-perfil/101")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(detalleDTO)))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCuentaTest() throws Exception {
        mockMvc.perform(delete("/api/paciente/eliminar/101"))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePacienteTest() throws Exception {
        mockMvc.perform(get("/api/paciente/detalle-paciente/101"))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPqrsPacienteTest() throws Exception {
        mockMvc.perform(get("/api/paciente/listar-pqrs/101"))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasPacienteTest() throws Exception {
        mockMvc.perform(get("/api/paciente/listar-citas-paciente/101"))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agendarCitaTest() throws Exception {
        CitaPacienteDTO citaDTO = new CitaPacienteDTO(
                "Motivo test",
                LocalDateTime.now().plusDays(1),
                201,
                101);

        mockMvc.perform(post("/api/paciente/agendar-cita")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(citaDTO)))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void crearPqrsTest() throws Exception {
        PqrsPacienteDTO pqrsDTO = new PqrsPacienteDTO(
                1,
                "Motivo PQRS");

        mockMvc.perform(post("/api/paciente/crear-pqrs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pqrsDTO)))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void responderPqrsTest() throws Exception {
        RespuestaPacientePqrsDTO respuestaDTO = new RespuestaPacientePqrsDTO(
                1,
                "Respuesta test",
                1,
                101);

        mockMvc.perform(post("/api/paciente/responder-pqrs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(respuestaDTO)))
                .andExpect(status().isOk());
    }
}
