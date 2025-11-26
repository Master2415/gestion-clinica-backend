package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.Entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.Entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.Entidades.EstadoMedico;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record RegistroMedicoDTO(
                @NotBlank @Length(max = 200) String nombre,
                @NotBlank @Email @Length(max = 80) String correo,
                @NotBlank @Length(max = 10) String cedula,
                @NotBlank @Length(max = 20) String telefono,
                @NotBlank @Length(max = 200) String password,
                @NotBlank @Length(max = 100) String direccion,
                @NotNull Especialidad especialidad,
                @NotBlank String urlFoto,
                @NotNull Ciudad ciudad,
                @NotNull List<HorarioDTO> horarios,
                @NotNull EstadoMedico estadoMedico) {
}
