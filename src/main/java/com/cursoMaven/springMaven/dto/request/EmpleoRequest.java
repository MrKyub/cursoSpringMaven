package com.cursoMaven.springMaven.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EmpleoRequest {

    private Long empleoId;
    private String titulo;
    private String empresa;
    private BigDecimal salario;

}
