package co.edu.uniquindio.clinica.controladores.controller;

import co.edu.uniquindio.clinica.dto.Clinica.MensajeDTO;
import co.edu.uniquindio.clinica.dto.paciente.DetallePacienteDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienterDTO;
import co.edu.uniquindio.clinica.modelo.Entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.Entidades.Eps;
import co.edu.uniquindio.clinica.modelo.Entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.Entidades.TipoSangre;
import co.edu.uniquindio.clinica.servicios.interfaces.ClinicaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/clinica")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClinicaController {

    private final ClinicaServicio clinicaServicio;

    @GetMapping("/lista-ciudades")
    public ResponseEntity<MensajeDTO<List<Ciudad>>> listarCiudades() {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarCiudades()));
    }

    @GetMapping("/lista-eps")
    public ResponseEntity<MensajeDTO<List<Eps>>> listarEps() {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarEps()));
    }

    @GetMapping("/lista-especializacion")
    public ResponseEntity<MensajeDTO<List<Especialidad>>> listarEspecializacion() {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarEspecializacion()));
    }

    @GetMapping("/lista-tipo-sangre")
    public ResponseEntity<MensajeDTO<List<TipoSangre>>> listarTipoDeSangre() {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarTipoDeSangre()));
    }

    @GetMapping("/listar-pqrs/{codigoPqrs}")
    public ResponseEntity<MensajeDTO<List<co.edu.uniquindio.clinica.dto.Clinica.MensajeDTO2>>> listarPQRS(
            @PathVariable int codigoPqrs) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarPQRS(codigoPqrs)));
    }

    @GetMapping("/cambiar-password/{codigoUsuario}/{nuevaPassword}")
    public ResponseEntity<MensajeDTO<String>> cambiarPassword(@PathVariable int codigoUsuario,
            @PathVariable String nuevaPassword) throws Exception {
        clinicaServicio.cambiarPassword(codigoUsuario, nuevaPassword);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Contraseña cambiada exitosamente"));
    }

}
