package co.edu.uniquindio.clinica.modelo.Entidades;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mensaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Lob
    @Column(nullable = false)
    private String mensaje;

    @ManyToOne
    private Eps eps;

    @ManyToOne
    private Cuenta cuenta;

    @ManyToOne
    private Pqrs pqrs;
}
