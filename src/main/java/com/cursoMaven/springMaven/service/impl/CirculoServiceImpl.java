package com.cursoMaven.springMaven.service.impl;

import com.cursoMaven.springMaven.dto.CirculoDto;
import com.cursoMaven.springMaven.service.CirculoService;
import org.springframework.stereotype.Service;

@Service
public class CirculoServiceImpl implements CirculoService {

    @Override
    public double calcularAreaCirculo(CirculoDto request) {

        double area = Math.PI * Math.pow(request.getRadio(), 2);

        return area;
    }

    @Override
    public double calcularPermietroCirculo(CirculoDto request) {

        double perimetro = 2 * Math.PI * request.getRadio();

        return perimetro;
    }
}