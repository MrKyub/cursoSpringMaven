package com.cursoMaven.springMaven.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "direcciones")
@Getter
@Setter
public class Direcciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direccion_id", nullable = false)
    private Long direccionId;

    @Column(name = "calle")
    private String calle;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codigo_postal")
    private String codigoPostal;

}