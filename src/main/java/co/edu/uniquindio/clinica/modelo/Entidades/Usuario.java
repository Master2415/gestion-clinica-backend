package co.edu.uniquindio.clinica.modelo.Entidades;

import co.edu.uniquindio.clinica.modelo.Entidades.Cuenta;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Usuario extends Cuenta implements Serializable {

    @Column(nullable = false, length = 10, unique = true)
    private String cedula;
    @Column(nullable = false, length = 200)
    private String nombre;
    @Column(nullable = false, length = 10)
    private String celular;

    @Lob
    @Column(nullable = false)
    private String urlFoto;
    @ManyToOne
    private Ciudad ciudad;

}
