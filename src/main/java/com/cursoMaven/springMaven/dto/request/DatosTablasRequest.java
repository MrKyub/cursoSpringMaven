package com.cursoMaven.springMaven.dto.request;

import com.cursoMaven.springMaven.model.Direcciones;
import com.cursoMaven.springMaven.model.Empleos;
import com.cursoMaven.springMaven.model.Personas;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatosTablasRequest {

    private Personas datosPersona;

    private Empleos datosEmpleo;

    private Direcciones datosDireccion;

}
