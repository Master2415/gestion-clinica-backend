package co.edu.uniquindio.clinica.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ClinicaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudadesTest() throws Exception {
        mockMvc.perform(get("/api/clinica/lista-ciudades"))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarEpsTest() throws Exception {
        mockMvc.perform(get("/api/clinica/lista-eps"))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarEspecializacionTest() throws Exception {
        mockMvc.perform(get("/api/clinica/lista-especializacion"))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTipoSangreTest() throws Exception {
        mockMvc.perform(get("/api/clinica/lista-tipo-sangre"))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPqrsTest() throws Exception {
        mockMvc.perform(get("/api/clinica/listar-pqrs/1"))
                .andExpect(status().isOk());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarPasswordTest() throws Exception {
        mockMvc.perform(get("/api/clinica/cambiar-password/101/newpass123"))
                .andExpect(status().isOk());
    }
}
