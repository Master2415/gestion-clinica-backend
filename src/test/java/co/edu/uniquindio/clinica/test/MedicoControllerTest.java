package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MedicoControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        @Sql("classpath:dataset.sql")
        public void listarCitasPendientesTest() throws Exception {
                mockMvc.perform(get("/api/medico/listar-citas-pendientes/201"))
                                .andExpect(status().isOk());
        }

        @Test
        @Sql("classpath:dataset.sql")
        public void listarHistorialAtencionesPacienteTest() throws Exception {
                mockMvc.perform(get("/api/medico/historial-atenciones-paciente/101"))
                                .andExpect(status().isOk());
        }

        @Test
        @Sql("classpath:dataset.sql")
        public void listarCitasRealizadasMedicoTest() throws Exception {
                mockMvc.perform(get("/api/medico/listar-citas-realizadas/201"))
                                .andExpect(status().isOk());
        }

        @Test
        @Sql("classpath:dataset.sql")
        public void verDetalleAtencionTest() throws Exception {
                mockMvc.perform(get("/api/medico/detalle-consulta/1"))
                                .andExpect(status().isOk());
        }

        @Test
        @Sql("classpath:dataset.sql")
        public void atenderCitaTest() throws Exception {
                RegistroAtencionDTO registroAtencionDTO = new RegistroAtencionDTO(
                                1,
                                201,
                                "Notas test",
                                "Tratamiento test",
                                "Sintomas test",
                                java.util.Collections.emptyList(),
                                "Descripcion receta",
                                "Diagnostico test");

                mockMvc.perform(post("/api/medico/atender-cita")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(registroAtencionDTO)))
                                .andExpect(status().isOk());
        }

        @Test
        @Sql("classpath:dataset.sql")
        public void agendarDiaLibreTest() throws Exception {
                DiaLibreDTO diaLibreDTO = new DiaLibreDTO(
                                201,
                                java.time.LocalDateTime.of(2023, 12, 25, 0, 0));

                mockMvc.perform(post("/api/medico/agendar-dia-libre")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(diaLibreDTO)))
                                .andExpect(status().isOk());
        }
}
