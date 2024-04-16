package com.cursoMaven.springMaven.service;

import com.cursoMaven.springMaven.dto.RectanguloDto;

public interface RectanguloService {

    double calcularAreaRectangulo(RectanguloDto request);
    double calcularPerimetroRectangulo(RectanguloDto request);

}
