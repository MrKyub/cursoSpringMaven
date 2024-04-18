package com.cursoMaven.springMaven.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "empleos")
@Getter
@Setter
public class Empleos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleo_id", nullable = false)
    private Long empleoId;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "salario")
    private BigDecimal salario;

}