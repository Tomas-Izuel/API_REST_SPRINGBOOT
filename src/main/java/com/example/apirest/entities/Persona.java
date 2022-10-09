package com.example.apirest.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Persona extends Base {
    private String nombre;
    private String apellido;
    private int dni;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codDomicilio")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable( name = "persona_libro",
        joinColumns = @JoinColumn(name = "codPersona"),
        inverseJoinColumns = @JoinColumn(name = "codLibro")
    )
    private List<Libro> libros = new ArrayList<Libro>();
}
