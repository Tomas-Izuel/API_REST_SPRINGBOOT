package com.example.apirest.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Domicilio extends Base {
    private String calle;
    private int numero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codLocalidad")
    private Localidad localidad;
}
