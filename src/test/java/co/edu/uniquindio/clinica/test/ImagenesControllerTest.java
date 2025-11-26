package co.edu.uniquindio.clinica.test;

import co.edu.uniquindio.clinica.dto.Clinica.ImagenDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ImagenesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void subirImagenTest() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.jpg",
                MediaType.IMAGE_JPEG_VALUE,
                "test image content".getBytes());

        mockMvc.perform(multipart("/api/imagenes/subir").file(file))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminarImagenTest() throws Exception {
        ImagenDTO imagenDTO = new ImagenDTO("test-id", "url-test");

        mockMvc.perform(delete("/api/imagenes/eliminar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(imagenDTO)))
                .andExpect(status().isOk());
    }
}
