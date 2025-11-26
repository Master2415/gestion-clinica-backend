package co.edu.uniquindio.clinica.modelo.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 50, unique = true)
    private String correo;

    @Column(nullable = false)
    @Lob
    private String contrasena;

    @OneToMany(mappedBy = "cuenta")
    private List<Mensaje> mensajes;

}
