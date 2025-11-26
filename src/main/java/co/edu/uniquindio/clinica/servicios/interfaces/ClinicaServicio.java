package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.Clinica.MensajeDTO2;
import co.edu.uniquindio.clinica.modelo.Entidades.Ciudad;
import co.edu.uniquindio.clinica.modelo.Entidades.Eps;
import co.edu.uniquindio.clinica.modelo.Entidades.Especialidad;
import co.edu.uniquindio.clinica.modelo.Entidades.TipoSangre;

import java.util.List;

public interface ClinicaServicio {

    List<MensajeDTO2> listarPQRS(int codigoPqrs) throws Exception;

    void cambiarPassword(int codigoUsuario, String nuevaPassword) throws Exception;

    List<Ciudad> listarCiudades();

    List<Eps> listarEps();

    List<Especialidad> listarEspecializacion();

    List<TipoSangre> listarTipoDeSangre();
}
