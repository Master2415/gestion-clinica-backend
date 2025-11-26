package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {

    @Query("SELECT new Ciudad(c.codigo, c.nombre) FROM Ciudad c")
    List<Ciudad> findAllMinimal();
}
