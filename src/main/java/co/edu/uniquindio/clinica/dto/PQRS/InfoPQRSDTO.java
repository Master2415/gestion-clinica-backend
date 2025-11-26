package co.edu.uniquindio.clinica.dto.PQRS;

import co.edu.uniquindio.clinica.modelo.Entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.Entidades.EstadoCita;
import co.edu.uniquindio.clinica.modelo.Entidades.EstadoPqrs;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;


public record InfoPQRSDTO(int codigo,
        @NotNull EstadoPqrs estado,
        @NotBlank String motivo,
        @NotBlank String nombrePaciente,
        @NotBlank String nombreMedico,
        @NotNull Especialidad especializacion,
        @NotNull LocalDateTime fecha,
        ArrayList<Object> objects) {

}
