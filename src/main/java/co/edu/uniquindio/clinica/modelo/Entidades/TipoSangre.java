package co.edu.uniquindio.clinica.modelo.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoSangre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 50)
    private String nombre;

    @OneToMany(mappedBy = "tipoSangre", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Paciente> pacientes;

    // Constructor para proyección optimizada
    public TipoSangre(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
