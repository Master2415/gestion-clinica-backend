package co.edu.uniquindio.clinica.servicios.Impl;

import co.edu.uniquindio.clinica.Repositorios.AdministradorRepo;
import co.edu.uniquindio.clinica.Repositorios.MedicoRepo;
import co.edu.uniquindio.clinica.Repositorios.PacienteRepo;
import co.edu.uniquindio.clinica.dto.admin.LoginDTO;
import co.edu.uniquindio.clinica.dto.token.TokenDTO;
import co.edu.uniquindio.clinica.modelo.Entidades.Cuenta;
import co.edu.uniquindio.clinica.modelo.Entidades.Medico;
import co.edu.uniquindio.clinica.modelo.Entidades.Paciente;
import co.edu.uniquindio.clinica.servicios.interfaces.AutenticacionServicio;
import co.edu.uniquindio.clinica.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServicio {

    private final PacienteRepo pacienteRepo;
    private final MedicoRepo medicoRepo;
    private final AdministradorRepo administradorRepo;
    private final JWTUtils jwtUtils;

    @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Cuenta cuenta = null;

        // Intentar buscar en paciente
        Paciente paciente = pacienteRepo.findByCorreo(loginDTO.correo());
        if (paciente != null) {
            cuenta = paciente;
        }

        // Si no se encontró en paciente, buscar en médico
        if (cuenta == null) {
            Medico medico = medicoRepo.findByCorreo(loginDTO.correo());
            if (medico != null) {
                cuenta = medico;
            }
        }

        // Si no se encontró en médico, buscar en administrador
        if (cuenta == null) {
            cuenta = administradorRepo.findByCorreo(loginDTO.correo());
        }

        // Si no se encontró en ningún repositorio, lanzar excepción
        if (cuenta == null) {
            throw new Exception("No existe el correo ingresado");
        }

        // Verificar la contraseña
        if (!passwordEncoder.matches(loginDTO.contrasenia(), cuenta.getContrasena())) {
            throw new Exception("La contraseña ingresada es incorrecta");
        }

        return new TokenDTO(crearToken(cuenta));
    }

    private String crearToken(Cuenta cuenta) {
        String rol;
        String nombre;
        if (cuenta instanceof Paciente) {
            rol = "paciente";
            nombre = ((Paciente) cuenta).getNombre();
        } else if (cuenta instanceof Medico) {
            rol = "medico";
            nombre = ((Medico) cuenta).getNombre();
        } else {
            rol = "admin";
            nombre = "Administrador";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rol", rol);
        map.put("nombre", nombre);
        map.put("id", cuenta.getCodigo());

        return jwtUtils.generarToken(cuenta.getCorreo(), map);
    }

}