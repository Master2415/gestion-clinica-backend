package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Entidades.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCitaRepo extends JpaRepository<EstadoCita, Integer> {
}
