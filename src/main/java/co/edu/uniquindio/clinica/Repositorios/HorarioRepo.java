    package co.edu.uniquindio.clinica.Repositorios;

import co.edu.uniquindio.clinica.modelo.Entidades.Dia;
import co.edu.uniquindio.clinica.modelo.Entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface HorarioRepo extends JpaRepository<Horario, Integer> {

    @Query("select h from Horario h where h.medico.codigo = :codMedico and h.dia = :dia")
    Horario obtenerHorarioFecha(int codMedico, Dia dia);
}
