package com.example.apirest.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "autor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Autor extends Base {
    private String nombre;
    private String apellido;
    @Column(length = 1500)
    private String biografia;
}
