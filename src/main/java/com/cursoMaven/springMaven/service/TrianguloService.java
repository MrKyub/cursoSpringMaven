package com.cursoMaven.springMaven.service;

import com.cursoMaven.springMaven.dto.TrianguloDto;

public interface TrianguloService {
    double calcularAreaTriangulo(TrianguloDto request);

    double calcularPerimetroTriangulo(TrianguloDto request);

}
