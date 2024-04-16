package com.cursoMaven.springMaven.service;

import com.cursoMaven.springMaven.dto.CirculoDto;

public interface CirculoService {

    double calcularAreaCirculo(CirculoDto request);

    double calcularPermietroCirculo(CirculoDto request);

}
