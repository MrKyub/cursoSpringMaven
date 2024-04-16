package com.cursoMaven.springMaven.service.impl;

import com.cursoMaven.springMaven.dto.TrianguloDto;
import com.cursoMaven.springMaven.service.TrianguloService;
import org.springframework.stereotype.Service;

@Service
public class TrianguloServiceImpl implements TrianguloService {

    @Override
    public double calcularAreaTriangulo(TrianguloDto request) {

        double area = (request.getBase() * request.getAltura()) / 2;

        return area;
    }

    @Override
    public double calcularPerimetroTriangulo(TrianguloDto request) {

        double perimetro = 3 * request.getLado();

        return 0;
    }
}
