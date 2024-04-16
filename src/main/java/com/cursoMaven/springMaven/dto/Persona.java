package com.cursoMaven.springMaven.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class Persona {

    @NotBlank(message = "El nombre no puede ser vacio o nulo")
    private String nombre;
    @NotBlank(message = "El apellido paterno debe tener datos")
    private String apellidoPaterno;
    @NotBlank(message = "El apellido materno debe tener datos")
    private String apellidoMaterno;
    @Pattern(regexp = "[0-9]{1,3}", message = "El campo solo admite numeros enteros y maximo 3 digitos")
    private String edad;
    private String genero;
    @Email
    private String email;

}
