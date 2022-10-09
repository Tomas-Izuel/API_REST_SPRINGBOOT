package com.example.apirest.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Libro extends Base {
    private String titulo;
    private int fecha;
    private String genero;
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "libro_autor",
        joinColumns = @JoinColumn(name = "codLibro"),
        inverseJoinColumns = @JoinColumn(name = "codAutor")
    )
    private List<Autor> autores;
}
