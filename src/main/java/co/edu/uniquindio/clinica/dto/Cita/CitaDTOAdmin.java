package co.edu.uniquindio.clinica.dto.Cita;

import co.edu.uniquindio.clinica.modelo.Entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.Entidades.EstadoCita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CitaDTOAdmin(int codigoCita,
        @NotBlank String cedulaPaciente,
        @NotBlank String nombrePaciente,
        @NotBlank String nombreMedico,
        @NotNull LocalDateTime fecha,
        @NotNull Especialidad especializacion,
        @NotNull EstadoCita estadoCita) {

}
