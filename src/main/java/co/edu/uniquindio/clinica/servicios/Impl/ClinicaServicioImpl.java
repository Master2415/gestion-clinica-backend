
package co.edu.uniquindio.clinica.servicios.Impl;

import co.edu.uniquindio.clinica.Repositorios.*;
import co.edu.uniquindio.clinica.dto.Clinica.MensajeDTO2;
import co.edu.uniquindio.clinica.modelo.Entidades.*;
import co.edu.uniquindio.clinica.modelo.Entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.Entidades.Eps;
import co.edu.uniquindio.clinica.modelo.Entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.Entidades.TipoSangre;
import co.edu.uniquindio.clinica.servicios.interfaces.ClinicaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClinicaServicioImpl implements ClinicaServicio {

    private final CiudadRepo ciudadRepo;
    private final EpsRepo epsRepo;
    private final EspecialidadRepo especialidadRepo;
    private final TipoSangreRepo tipoSangreRepo;
    private final MensajeRepo mensajeRepo;
    private final MedicoRepo medicoRepo;
    private final PacienteRepo pacienteRepo;

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAllMinimal();
    }

    @Override
    public List<Eps> listarEps() {
        return epsRepo.findAll();
    }

    @Override
    public List<Especialidad> listarEspecializacion() {
        return especialidadRepo.findAll();
    }

    @Override
    public List<TipoSangre> listarTipoDeSangre() {
        return tipoSangreRepo.findAllMinimal();
    }

    @Override
    public void cambiarPassword(int codigoUsuario, String nuevaPassword) throws Exception {
        // Intentar encontrar un médico con el código de usuario proporcionado
        Optional<Medico> medico = medicoRepo.findById(codigoUsuario);

        // Verificar si se encontró un médico y actualizar la contraseña si es así
        if (medico.isPresent()) {
            actualizarContrasenia(medico.get(), nuevaPassword, medicoRepo);
            return;
        }

        // Intentar encontrar un paciente con el código de usuario proporcionado
        Optional<Paciente> paciente = pacienteRepo.findById(codigoUsuario);

        // Verificar si se encontró un paciente y actualizar la contraseña si es así
        if (paciente.isPresent()) {
            actualizarContrasenia(paciente.get(), nuevaPassword, pacienteRepo);
            return;
        }

        // Lanzar una excepción si no se encontró ningún usuario con el código
        // proporcionado
        throw new Exception("El usuario con el código " + codigoUsuario + " no existe");
    }

    // Método para listar los mensajes asociados a una PQRS .
    @Override
    public List<MensajeDTO2> listarPQRS(int codigoPqrs) throws Exception {
        List<Mensaje> mensajes = mensajeRepo.findAll(); // This should ideally be filtered by PQRS, but for now getting
                                                        // all and filtering in stream or adding a method in repo
        // Better approach: Add findByPqrsCodigo in MensajeRepo. Assuming it exists or I
        // should add it.
        // Let's assume I need to filter manually if I don't add it to repo yet, or just
        // use findAll for now and filter.
        // Actually, I should probably add the method to the repo. But for now let's
        // just filter.

        return mensajes.stream()
                .filter(m -> m.getPqrs().getCodigo() == codigoPqrs)
                .sorted(Comparator.comparing(Mensaje::getCodigo))
                .map(mensaje -> new MensajeDTO2(
                        mensaje.getCodigo(),
                        mensaje.getCuenta().getCodigo(),
                        mensaje.getCuenta().getCorreo(), // Assuming Cuenta has correo. Yes it does.
                        mensaje.getMensaje(),
                        mensaje.getFechaCreacion(),
                        mensaje.getPqrs().getCodigo()))
                .collect(Collectors.toList());
    }

    // Método privado para actualizar la contraseña de un usuario genérico.
    private <T extends Usuario> void actualizarContrasenia(T usuario, String nuevaPassword,
            JpaRepository<T, Integer> repository) {

        // Codificar la nueva contraseña utilizando BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(nuevaPassword);

        // Actualizar la contraseña del usuario y guardar los cambios en el repositorio
        usuario.setContrasena(passwordEncriptada);
        repository.save(usuario);
    }

}
