    package co.edu.uniquindio.clinica.controladores.controller;

import co.edu.uniquindio.clinica.dto.admin.ConsultaDTO;
import co.edu.uniquindio.clinica.dto.medico.DetalleAtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.clinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.clinica.dto.Clinica.MensajeDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medico")
public class MedicoController {

    private final MedicoServicio medicoServicio;

    @GetMapping("/listar-citas-pendientes/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<ConsultaDTO>>> listarCitasPendientes(@PathVariable int codigoMedico)
            throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.listarCitasPendientes(codigoMedico)));
    }

    @GetMapping("/historial-atenciones-paciente/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<DetalleAtencionMedicaDTO>>> listarHistorialAtencionesPaciente(
            @PathVariable int codigoPaciente) throws Exception {
        return ResponseEntity.ok()
                .body(new MensajeDTO<>(false, medicoServicio.listarHistorialAtencionesPaciente(codigoPaciente)));
    }

    @GetMapping("/listar-citas-realizadas/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<DetalleAtencionMedicaDTO>>> listarCitasRealizadasMedico(
            @PathVariable int codigoMedico) throws Exception {
        return ResponseEntity.ok()
                .body(new MensajeDTO<>(false, medicoServicio.listarCitasRealizadasMedico(codigoMedico)));
    }

    @GetMapping("/detalle-consulta/{codigoCita}")
    public ResponseEntity<MensajeDTO<DetalleAtencionMedicaDTO>> verDetalleAtencion(@PathVariable int codigoCita)
            throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.verDetalleAtencion(codigoCita)));
    }

    @PostMapping("/atender-cita")
    public ResponseEntity<MensajeDTO<String>> atenderCita(@Valid @RequestBody RegistroAtencionDTO registroAtencionDTO)
            throws Exception {
        medicoServicio.atenderCita(registroAtencionDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cita atendida exitosamente"));
    }

    @PostMapping("/agendar-dia-libre")
    public ResponseEntity<MensajeDTO<String>> agendarDiaLibre(@Valid @RequestBody DiaLibreDTO diaLibreDTO)
            throws Exception {
        medicoServicio.agendarDiaLibre(diaLibreDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Día libre agendado exitosamente"));
    }

}
