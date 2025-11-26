package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.admin.LoginDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienterDTO;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AutenticacionControllerTest {

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
    public void loginTest() throws Exception {
        LoginDTO loginDTO = new LoginDTO("admin1@clinica.com", "password123");

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginDTO)))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarseTest() throws Exception {
        Ciudad ciudad = ciudadRepo.findById(1).orElseThrow();
        TipoSangre tipoSangre = tipoSangreRepo.findById(1).orElseThrow();
        Eps eps = epsRepo.findById(1).orElseThrow();

        RegistroPacienterDTO registroDTO = new RegistroPacienterDTO(
                "Nuevo Paciente",
                "nuevo@email.com",
                "1234567899",
                "3001234567",
                "password123",
                "url_foto",
                LocalDate.of(1990, 1, 1),
                ciudad,
                tipoSangre,
                "Ninguna");
        mockMvc.perform(post("/api/auth/registrar-paciente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registroDTO)))
                .andExpect(status().isCreated());
    }
}
