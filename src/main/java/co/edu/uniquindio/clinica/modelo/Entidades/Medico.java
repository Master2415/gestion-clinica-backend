package co.edu.uniquindio.clinica.modelo.Entidades;

import co.edu.uniquindio.clinica.modelo.Entidades.EstadoMedico;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends Usuario implements Serializable {

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;

    @ManyToOne
    private EstadoMedico estadoMedico;

    @ManyToOne
    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @OneToMany(mappedBy = "medico")
    private List<Horario> horarios;

    @OneToMany(mappedBy = "medico")
    private List<DiaLibre> diaLibres;

}
