package com.cursoMaven.springMaven.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DireccionRequest {

    private Long direccionId;
    private String calle;
    private String ciudad;
    private String estado;
    private String codigoPostal;

}
