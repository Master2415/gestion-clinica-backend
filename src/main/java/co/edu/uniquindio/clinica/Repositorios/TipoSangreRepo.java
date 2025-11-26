package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Entidades.TipoSangre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoSangreRepo extends JpaRepository<TipoSangre, Integer> {

    @Query("SELECT new TipoSangre(t.codigo, t.nombre) FROM TipoSangre t")
    List<TipoSangre> findAllMinimal();
}
